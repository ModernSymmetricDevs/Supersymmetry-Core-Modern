package belletti.supersymmetry.common.machine.multiblock;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
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
import lombok.Getter;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

public abstract class VoidingMultiblockBase extends WorkableElectricMultiblockMachine implements IMufflerMechanic {
    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(VoidingMultiblockBase.class,
            WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @DescSynced
    private boolean isActive = false;
    private NotifiableFluidTank inputFluidTank;
    @Persisted
    protected int rateBonus = 1;
    @Persisted
    protected int height = 5;
    protected int minHeight = 5;

    public VoidingMultiblockBase(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.initializeTank();
        this.subscribeServerTick(this::serverTickEvent);
    }

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

    protected abstract boolean canVoid(Fluid fluid);

    protected int getActualVoidingRate() {
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
    public void onStructureFormed() {
        super.onStructureFormed();
        var contextHeight = getMultiblockState().getMatchContext().get("height");

        if(contextHeight != null) {
            // +2 because of the base and top blocks
            this.height = (int) getMultiblockState().getMatchContext().get("height") + 2;
            this.rateBonus = (int) Math.pow(2, height - minHeight);
        }

        if (this.inputFluidTank == null)
            initializeTank();
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.inputFluidTank = null;
    }

    protected void initializeTank() {
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
