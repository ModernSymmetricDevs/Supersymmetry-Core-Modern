package belletti.supersymmetry.common.machine.multiblock.electrical;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMufflerMechanic;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FlareStack extends WorkableElectricMultiblockMachine implements IMufflerMechanic {
    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(FlareStack.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @DescSynced
    private boolean isActive = false;
    private NotifiableFluidTank inputFluidTank;
    @Persisted
    private int rateBonus = 1;
    @Persisted
    private int height = 5;
    private int minHeight = 5;

    public FlareStack(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.initializeTank();
        this.subscribeServerTick(this::serverTickEvent);
    }

    // @TODO item tooltip

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private void serverTickEvent() {
        if (getOffsetTimer() % 20 != 0) return;
        if (inputFluidTank == null || inputFluidTank.getContents().isEmpty()) {
            setEnabled(false);
            return;
        }

        FluidStack fluidIn = (FluidStack) inputFluidTank.getContents().get(0);
        if (fluidIn.isEmpty() || !canVoid(fluidIn.getFluid())) return;

        setEnabled(true);
        inputFluidTank.drainInternal(getActualVoidingRate(), false);
    }

    private boolean canVoid(Fluid fluid) {
        Material fluidMaterial = ChemicalHelper.getMaterial(fluid);
        if (fluidMaterial == null) return false;

        Fluid liquidFluid = fluidMaterial.getFluid(FluidStorageKeys.LIQUID);
        Fluid gasFluid = fluidMaterial.getFluid(FluidStorageKeys.GAS);
        boolean isLiquidFluidOrGas = (liquidFluid != null && liquidFluid == fluid) || (gasFluid != null && gasFluid == fluid);

        return isLiquidFluidOrGas && fluidMaterial.hasFlag(MaterialFlags.FLAMMABLE);
    }

    private int getActualVoidingRate() {
        int baseVoidingRate = 1000;
        return rateBonus * baseVoidingRate;
    }

    private void setEnabled(boolean flag) {
        this.isActive = flag;
        super.updateActiveBlocks(flag);
        this.recipeLogic.setStatus(flag ? RecipeLogic.Status.WORKING : RecipeLogic.Status.IDLE);
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if(!isFormed) return;
        Component componentHeight = Component.literal(String.valueOf(this.height)).withStyle(ChatFormatting.BLUE);
        Component componentRateBonus = Component.literal(this.rateBonus + "x").withStyle(ChatFormatting.DARK_PURPLE);
        Component componentRateBase = Component.translatable("gregtech.machine.flare_stack.rate", componentRateBonus).withStyle(ChatFormatting.GRAY);
        Component componentRateHover = Component.translatable("gregtech.machine.flare_stack.rate_hover").withStyle(ChatFormatting.GRAY);

        textList.add(Component.translatable("gregtech.machine.flare_stack.height", componentHeight).withStyle(ChatFormatting.GRAY));
        textList.add(componentRateBase.copy().setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, componentRateHover))));
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        // +2 because of the base and top blocks
        this.height = (int) getMultiblockState().getMatchContext().get("height") + 2;
        this.rateBonus = (int) Math.pow(2, height - minHeight);
        if (this.inputFluidTank == null) initializeTank();
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.inputFluidTank = null;
    }

    private void initializeTank() {
        for (IMultiPart part : getParts()) {
            for (var handler : part.getRecipeHandlers()) {
                if (handler.getHandlerIO() == IO.IN && handler.getCapability() == FluidRecipeCapability.CAP) {
                    inputFluidTank = (NotifiableFluidTank) handler;
                    return;
                }
            }
        }
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }
}
