package belletti.supersymmetry.common.machine.multiblock.electrical;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMufflerMechanic;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

public class ReactionFurnace extends WorkableElectricMultiblockMachine implements IMufflerMechanic, IExplosionMachine {
    public ReactionFurnace(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }
}
