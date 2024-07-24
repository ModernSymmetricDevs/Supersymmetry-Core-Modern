package belletti.supersymmetry.common.materials;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;

import static belletti.supersymmetry.common.materials.SuSyMaterials.SodiumSulfate;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Phosphorus;

public class GTFOMaterials {
    public static void init() {
        SodiumSulfate = new Material.Builder(Supersymmetry.id("sodium_sulfate"))
                .dust()
                .components(Sodium, 2, Sulfur, 1, Oxygen, 4)
                .buildAndRegister();
    }
}
