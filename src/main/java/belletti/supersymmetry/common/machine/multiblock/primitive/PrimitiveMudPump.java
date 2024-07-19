package belletti.supersymmetry.common.machine.multiblock.primitive;

import com.gregtechceu.gtceu.api.capability.IControllable;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.Precipitation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static belletti.supersymmetry.common.materials.SuSyMaterials.Mud;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PrimitiveMudPump extends MultiblockControllerMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(PrimitiveMudPump.class,
            MultiblockControllerMachine.MANAGED_FIELD_HOLDER);

    private long biomeModifier = 0;
    private int hatchModifier = 0;
    private NotifiableFluidTank fluidTank;
    private TickableSubscription produceMudSubscription;

    public PrimitiveMudPump(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        initializeTank();
        produceMudSubscription = subscribeServerTick(this::produceMud);
        produceMud();
    }

    private void initializeTank() {
        for (IMultiPart part : getParts()) {
            for (var handler : part.getRecipeHandlers()) {
                if (handler.getHandlerIO() == IO.OUT && handler.getCapability() == FluidRecipeCapability.CAP) {
                    fluidTank = (NotifiableFluidTank) handler;
                    long tankCapacity = fluidTank.getTankCapacity(0);
                    if (tankCapacity == FluidHelper.getBucket()) {
                        hatchModifier = 1;
                    } else if (tankCapacity == FluidHelper.getBucket() * 8) {
                        hatchModifier = 2;
                    } else {
                        hatchModifier = 4;
                    }
                    return;
                }
            }
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        resetState();
    }

    @Override
    public void onPartUnload() {
        super.onPartUnload();
        resetState();
    }

    @Override
    public void onUnload() {
        super.onUnload();
        resetState();
    }

    private void resetState() {
        unsubscribe(produceMudSubscription);
        hatchModifier = 0;
        fluidTank = null;
    }

    private void produceMud() {
        if (getOffsetTimer() % 20 == 0 && isFormed() && !getMultiblockState().hasError()) {
            if (biomeModifier == 0) {
                biomeModifier = getMudAmount();
            } else if (biomeModifier > 0) {
                if (fluidTank == null) initializeTank();
                if (fluidTank != null) {
                    fluidTank.handleRecipe(IO.OUT, null,
                            List.of(FluidIngredient.of(Mud.getFluid(biomeModifier * hatchModifier))), null, false);
                }
            }
        }
    }

    private int getMudAmount() {
        Holder <Biome> biome = getLevel().getBiome(getPos());

        if (getPos().getY() < 40 || getPos().getY() > 95) {
            return -1; // Disabled
        }

        if (!biome.is(BiomeTags.IS_RIVER) && !biome.is(BiomeTags.HAS_SWAMP_HUT)){
            return -1; // Disabled
        }

        return 250;
    }
}
