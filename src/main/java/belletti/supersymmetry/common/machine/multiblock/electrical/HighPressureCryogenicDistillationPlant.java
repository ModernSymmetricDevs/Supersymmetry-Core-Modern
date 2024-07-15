package belletti.supersymmetry.common.machine.multiblock.electrical;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;

public class HighPressureCryogenicDistillationPlant extends WorkableElectricMultiblockMachine implements IExplosionMachine {
    public HighPressureCryogenicDistillationPlant(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public boolean allowExtendedFacing() {
        return false;
    }
}
