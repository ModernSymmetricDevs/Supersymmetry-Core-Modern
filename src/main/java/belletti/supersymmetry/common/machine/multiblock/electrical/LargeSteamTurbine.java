package belletti.supersymmetry.common.machine.multiblock.electrical;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMufflerMechanic;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.network.chat.Component;

import java.util.List;

// @TODO: this might need some tweaks, depends on recipes being integrated
public class LargeSteamTurbine extends WorkableElectricMultiblockMachine implements IMufflerMechanic, IExplosionMachine {
    private final int BASE_EU_OUTPUT;
    private final int tier;

    public LargeSteamTurbine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.tier = 2;
        this.BASE_EU_OUTPUT = (int) GTValues.V[tier];
    }

    @Override
    public long getOverclockVoltage() {
        return BASE_EU_OUTPUT;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        if (isFormed && isActive()) {
            String voltageName = GTValues.VNF[GTUtil.getTierByVoltage(getOverclockVoltage())];
            textList.add(Component.translatable("gtceu.multiblock.turbine.energy_per_tick",
                    FormattingUtil.formatNumbers(getOverclockVoltage()), voltageName));
        }
        super.addDisplayText(textList);
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public boolean dampingWhenWaiting() {
        return false;
    }

    @Override
    public boolean canVoidRecipeOutputs(RecipeCapability<?> capability) {
        return capability != EURecipeCapability.CAP;
    }

    @Override
    public boolean allowExtendedFacing() {
        return false;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return false;
    }
}
