package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.common.materials.SuSyMaterials;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OceanPumper extends WorkableElectricMultiblockMachine {
    private int EU_CONSUMPTION_PER_PUMP;
    private long drainRate;
    private NotifiableFluidTank outputFluidTank;
    private Component customErrorComponent;

    public OceanPumper(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        initializeTank();
        subscribeServerTick(this::serverTickEvent);
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        if(customErrorComponent != null)
            textList.add(customErrorComponent.copy().withStyle(ChatFormatting.RED));

        if(isWorkingEnabled()) {
            textList.add(Component.translatable("susy.ocean_pumper.drainrate", drainRate));
            textList.add(Component.literal("Consuming %d EU per pump".formatted(EU_CONSUMPTION_PER_PUMP)));
        }

        if(!pumpWaterIntoFluidTank(true))
            textList.add(Component.translatable("susy.ocean_pumper.full").withStyle(ChatFormatting.RED));

        super.addDisplayText(textList);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        if(this.outputFluidTank == null)  initializeTank();
        if(this.energyContainer != null) {
            this.EU_CONSUMPTION_PER_PUMP = 128 * (1 << (GTUtil.getTierByVoltage(this.energyContainer.getInputVoltage()) - 1) * 2);
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.outputFluidTank = null;
    }

    private void initializeTank() {
        for (IMultiPart part : getParts()) {
            for (var handler : part.getRecipeHandlers()) {
                if (handler.getHandlerIO() == IO.OUT && handler.getCapability() == FluidRecipeCapability.CAP) {
                    outputFluidTank = (NotifiableFluidTank) handler;
                    return;
                }
            }
        }
    }

    private void serverTickEvent() {
        if (isRemote() || getOffsetTimer() % 20 != 0 || !isFormed()) return;

        if (!isValidLocation()) {
            this.customErrorComponent = Component.literal("Not in Ocean or the height is too high.");
            this.setWorkingEnabled(false);
            return;
        };

        if(this.outputFluidTank == null) {
            this.customErrorComponent = Component.literal("No output hatch tank detected.");
            this.initializeTank();
            this.setWorkingEnabled(false);
            return;
        }

        if(!this.isWorkingEnabled()) {
            this.customErrorComponent = Component.literal("Working is disabled.");
            this.setWorkingEnabled(false);
            return;
        }

        if(!(energyContainer.getEnergyStored() >= EU_CONSUMPTION_PER_PUMP)) {
            this.customErrorComponent = Component.literal("Insufficient energy for pumping.");
            this.setWorkingEnabled(false);
            return;
        };

        if(!drainEnergy(true)) {
            this.setWorkingEnabled(false);
        };

        this.setWorkingEnabled(true);
        drainEnergy(false);
        pumpWaterIntoFluidTank(false);

        this.customErrorComponent = null;
    }

    private boolean pumpWaterIntoFluidTank(boolean simulate) {
        if (!isValidLocation()) return false;
        if (this.energyContainer == null || this.outputFluidTank == null) return false;

        long fillAmount = Math.min(Long.MAX_VALUE, 500L * (1L << (GTUtil.getTierByVoltage(this.energyContainer.getInputVoltage()) - 1) * 2));
        FluidStack seaWaterFluid = SuSyMaterials.Seawater.getFluid(fillAmount);
        long insertedAmount = outputFluidTank.fillInternal(seaWaterFluid, true);

        if (!simulate) {
            seaWaterFluid.setAmount(Math.min(fillAmount, insertedAmount));
            outputFluidTank.fillInternal(seaWaterFluid, false);
            drainRate = Math.min(fillAmount, insertedAmount);
        }

        return (fillAmount == insertedAmount);
    }

    private boolean isValidLocation() {
        Holder<Biome> biome = getLevel().getBiome(getPos());

        if (getPos().getY() < 70 || getPos().getY() > 75) return false;

        return biome.is(BiomeTags.IS_OCEAN) || biome.is(BiomeTags.IS_DEEP_OCEAN);
    }

    public boolean drainEnergy(boolean simulate) {
        long energyToDrain = EU_CONSUMPTION_PER_PUMP;
        long resultEnergy = energyContainer.getEnergyStored() - energyToDrain;
        if (resultEnergy > 0L && resultEnergy <= energyContainer.getEnergyCapacity()) {
            if (!simulate) {
                energyContainer.removeEnergy(energyToDrain);
            }
            return true;
        }
        return false;
    }
}
