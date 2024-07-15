package belletti.supersymmetry.common.machine.singleblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.capability.ICryogenicProvider;
import belletti.supersymmetry.api.capability.ICryogenicReceiver;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableEnergyContainer;
import com.gregtechceu.gtceu.utils.InfiniteEnergyContainer;
import it.unimi.dsi.fastutil.ints.Int2LongFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BathCondenser extends SimpleTieredMachine implements ICryogenicReceiver {
    private @Nullable ICryogenicProvider cryogenicProvider;

    public BathCondenser(IMachineBlockEntity holder, int tier, Int2LongFunction tankScalingFunction, Object... args) {
        super(holder, tier, tankScalingFunction, args);
        super.energyContainer.setEnergyStored(Integer.MAX_VALUE);
    }

    @Override
    public boolean hasAutoOutputFluid() {
        return true;
    }

    @Override
    protected @NotNull NotifiableEnergyContainer createEnergyContainer(Object @NotNull ... args) {
        return new InfiniteEnergyContainer(this, 0, 0, 0, 0, 0) {
            @Override
            public boolean isOneProbeHidden() {
                return true;
            }
        };
    }

    @Override
    public boolean isRecipeLogicAvailable() {
        return cryogenicProvider != null && cryogenicProvider.isFormed() && super.isRecipeLogicAvailable();
    }

    @Override
    public void setCryogenicProvider(@Nullable ICryogenicProvider cryogenicProvider) {
        this.cryogenicProvider = cryogenicProvider;
    }

    @Override
    public long getMaxVoltage() {
        return GTValues.LV;
    }
}
