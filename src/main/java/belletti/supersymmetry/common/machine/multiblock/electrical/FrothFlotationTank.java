package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import net.minecraft.core.BlockPos;

public class FrothFlotationTank extends WorkableElectricMultiblockMachine implements IExplosionMachine {
    public FrothFlotationTank(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public boolean allowExtendedFacing() {
        return false;
    }
}
