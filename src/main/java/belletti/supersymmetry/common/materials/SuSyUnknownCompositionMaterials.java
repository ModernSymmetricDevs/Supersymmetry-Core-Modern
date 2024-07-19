package belletti.supersymmetry.common.materials;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static belletti.supersymmetry.common.materials.SuSyMaterials.*;

public class SuSyUnknownCompositionMaterials {
    public static void init() {
        Latex = new Material.Builder(Supersymmetry.id("latex"))
                .dust().fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(293))
                .color(0xFFFADA)
                .buildAndRegister();

        Mud = new Material.Builder(Supersymmetry.id("mud"))
                .liquid()
                .color(0x211b14)
                .buildAndRegister();

        Seawater = new Material.Builder(Supersymmetry.id("sea_water"))
                .liquid()
                .color(0x3c5bc2)
                .buildAndRegister();
    }
}
