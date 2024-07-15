package belletti.supersymmetry.common.machine.multiblock.primitive;

import belletti.supersymmetry.api.SuSyGuiTextures;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.UITemplate;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IUIMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveWorkableMachine;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.ProgressWidget;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.TankWidget;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CoagulationTank extends PrimitiveWorkableMachine implements IUIMachine {
    private int tankSize = 1;

    public CoagulationTank(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Nullable
    @Override
    protected GTRecipe getRealRecipe(GTRecipe recipe) {
        return GTRecipeModifiers.accurateParallel(this, recipe, tankSize, false).getFirst();
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        return new ModularUI(176, 166, this, entityPlayer)
                .background(GuiTextures.PRIMITIVE_BACKGROUND)

                .widget(new LabelWidget(6, 6, getBlockState().getBlock().getDescriptionId()))
                .widget(new ProgressWidget(recipeLogic::getProgressPercent, 76, 41, 20, 15,
                        GuiTextures.PRIMITIVE_BLAST_FURNACE_PROGRESS_BAR))

                .widget(new SlotWidget(this.importItems.storage, 0, 30, 30, true, true)
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new SlotWidget(this.importItems.storage, 1, 48, 30, true, true)
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new TankWidget(this.importFluids.getStorages()[0], 30, 48, true, true)
                        .setShowAmount(true)
                        .setBackground(SuSyGuiTextures.FLUID_SLOT_PRIMITIVE))
                .widget(new TankWidget(this.importFluids.getStorages()[1], 48, 48, true, true)
                        .setShowAmount(true)
                        .setBackground(SuSyGuiTextures.FLUID_SLOT_PRIMITIVE))

                .widget(new SlotWidget(this.exportItems, 0, 106, 39, true, false)
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))

                .widget(UITemplate.bindPlayerInventory(entityPlayer.getInventory(), GuiTextures.PRIMITIVE_SLOT, 7, 84,
                        true));
    }

    @Override
    public void onStructureFormed() {
        tankSize = getMultiblockState().getMatchContext().get("tankSize");
        super.onStructureFormed();
    }
}
