package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.data.SuSyBlocks;
import com.gregtechceu.gtceu.api.block.MetaMachineBlock;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;

public class HeatRadiator extends WorkableElectricMultiblockMachine implements IExplosionMachine {
    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(HeatRadiator.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    public static final int MIN_RADIUS = 1;
    public static final int MIN_HEIGHT = 1;

    @Persisted
    @DescSynced
    private int sDist = 0;
    @Persisted
    @DescSynced
    private int bDist = 0;
    @Persisted
    @DescSynced
    private int area;

    public HeatRadiator(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Nullable
    @Override
    protected GTRecipe getRealRecipe(GTRecipe recipe) {
        return GTRecipeModifiers.accurateParallel(this, recipe, this.area, false).getFirst();
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);

        if (!isFormed) return;

        // @TODO: fix translatable lang stuff
        Component componentParallelAmount = Component.literal(String.valueOf(this.area))
                .setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE));
        Component componentParallelAmountBase = Component.translatable("gregtech.machine.heat_radiator.parallel", componentParallelAmount)
                .setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY));
        Component componentParallelAmountHover = Component.translatable("gregtech.machine.heat_radiator.parallel_hover")
                .setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY));

        Component componentWithHover = componentParallelAmountBase.copy().setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, componentParallelAmountHover)));

        textList.add(componentWithHover);
    }

    @NotNull
    @Override
    public BlockPattern getPattern() {
        if (getLevel() != null) updateStructureDimensions();
        if (sDist < MIN_RADIUS) sDist = MIN_RADIUS;
        if (bDist < MIN_HEIGHT) bDist = MIN_HEIGHT;

        return FactoryBlockPattern.start(RIGHT, FRONT, UP)
                .aisle(rowPattern(rowType.BOTTOM, sDist).toString())
                .aisle(rowPattern(rowType.MIDDLE, sDist)).setRepeatable(1, bDist)
                .aisle(rowPattern(rowType.TOP, sDist))
                .where('S', Predicates.controller(Predicates.blocks(this.getDefinition().get())))
                .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                        .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                .where('B', Predicates.blocks(SuSyBlocks.SERPENTINE.get()))
                .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                        .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1))
                        .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1)))
                .build();
    }

    protected void updateStructureDimensions() {
        Level world = getLevel();
        Direction front = getFrontFacing();

        Direction up = UP.getRelativeFacing(this.getFrontFacing(), this.getUpwardsFacing(), this.isFlipped); // From the flare stack, I hate free rotation.
        Direction left = front.getClockWise(up.getAxis());
        Direction right = left.getOpposite();

        BlockPos.MutableBlockPos lPos = getPos().relative(up).mutable();
        BlockPos.MutableBlockPos rPos = getPos().relative(up).mutable();
        BlockPos.MutableBlockPos uPos = getPos().mutable();

        int sDist = 0;
        int bDist = 0;

        // find the left, right, and upper distances for the structure pattern
        // maximum size is 11x16 including walls
        for (int i = 0; i < 16; ++i) {
            if (isBlockEdge(world, uPos, up)) {
                bDist = i;
                break;
            }
        }

        for (int i = 1; i < 6; i++) { // start at 1 for an off-by-one error
            if (isBlockEdge(world, lPos, left) & isBlockEdge(world, rPos, right)) {
                sDist = i; // The & is absolutely *essential* here.
                break;
            }
        }

        if (sDist < MIN_RADIUS || bDist < MIN_HEIGHT) {
            this.isFormed = false;
            return;
        }

        this.sDist = sDist;
        this.bDist = bDist;
        this.area = bDist * (2 * sDist - 1);
    }

    private boolean isBlockEdge(@NotNull Level world, @NotNull BlockPos.MutableBlockPos pos, @NotNull Direction direction) {
        BlockState blockState = world.getBlockState(pos.move(direction));
        return blockState.is(GTBlocks.CASING_STEEL_SOLID.get()) || blockState.getBlock() instanceof MetaMachineBlock;
    }

    private enum rowType {
        BOTTOM, MIDDLE, TOP, MIDDLE_PREVIEW, BOTTOM_PREVIEW
    }

    private String rowPattern(rowType rowType, int radius) {
        char center, left, right, other;

        // A: Metal Casing; S: Radiator; C: Metal Casing or Hatches; B: Tube Block
        switch (rowType) {
            case BOTTOM:
                center = 'S';
                left = right = 'A';
                other = 'A';
                break;
            case MIDDLE:
                center = 'B';
                left = right = 'C';
                other = 'B';
                break;
            case TOP:
                center = 'A';
                left = right = 'A';
                other = 'A';
                break;

            // These are only for JEI preview. I: Input Hatch; O: Output Hatch; M: Maintenance Hatch
            case BOTTOM_PREVIEW:
                center = 'S';
                left = 'M';
                right = 'A';
                other = 'A';
                break;
            case MIDDLE_PREVIEW:
                center = 'B';
                left = 'I';
                right = 'O';
                other = 'B';
                break;
            default:
                throw new IllegalArgumentException("Invalid rowType: " + rowType);
        }
        StringBuilder rowBuilder = new StringBuilder();
        for (int i = 0; i < radius; i++) {
            if (i == 0) {
                // Add Center
                rowBuilder.append(center);
            } else {
                rowBuilder.append(other);
                rowBuilder.insert(0, other);
            }
        }
        // Add Edges. I don't know whether left/right is correct or not, but it probably doesn't matter.
        rowBuilder.append(right);
        rowBuilder.insert(0, left);

        return rowBuilder.toString();
    }
}
