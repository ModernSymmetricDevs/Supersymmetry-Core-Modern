package belletti.supersymmetry.common.machine.multiblock.electrical;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

public class LargeWeaponsFactory extends WorkableElectricMultiblockMachine implements IExplosionMachine {
    public LargeWeaponsFactory(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }
}
