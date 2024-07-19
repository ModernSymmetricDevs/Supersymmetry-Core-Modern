package belletti.supersymmetry.common.materials;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import static belletti.supersymmetry.common.materials.SuSyFirstDegreeMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.NO_SMASHING;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.ROUGH;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static belletti.supersymmetry.common.materials.SuSyMaterials.*;

public class SuSySecondDegreeMaterials {
    public static void init() {
        Gabbro = new Material.Builder(Supersymmetry.id("gabbro"))
                .dust()
                .color(0x5C5C5C).iconSet(ROUGH)
                .flags(NO_SMASHING, DISABLE_DECOMPOSITION)
                .components(Labradorite, 5, Bytownite, 3, Olivine, 2, Augite, 1, Biotite, 1)
                .buildAndRegister();

        Gneiss = new Material.Builder(Supersymmetry.id("gneiss"))
                .dust()
                .color(0x643631).iconSet(ROUGH)
                .flags(NO_SMASHING, DISABLE_DECOMPOSITION)
                .components(Albite, 4, SiliconDioxide, 3, Biotite, 1, Muscovite, 1)
                .buildAndRegister();
        Limestone = new Material.Builder(Supersymmetry.id("limestone"))
                .dust()
                .color(0xa9a9a9).iconSet(ROUGH)
                .flags(NO_SMASHING, DISABLE_DECOMPOSITION)
                .components(Calcite, 4, Dolomite, 1)
                .buildAndRegister();

        Phyllite = new Material.Builder(Supersymmetry.id("phyllite"))
                .dust()
                .color(0x716f71).iconSet(ROUGH)
                .flags(NO_SMASHING, DISABLE_DECOMPOSITION)
                .components(Albite, 3, SiliconDioxide, 3, Muscovite, 4)
                .buildAndRegister();

        Shale = new Material.Builder(Supersymmetry.id("shale"))
                .dust()
                .color(0x3f2e2f).iconSet(ROUGH)
                .flags(NO_SMASHING, DISABLE_DECOMPOSITION)
                .components(Calcite, 6, Clay, 2, SiliconDioxide, 1, Fluorite, 1)
                .buildAndRegister();

        Slate = new Material.Builder(Supersymmetry.id("slate"))
                .dust()
                .color(0x756869).iconSet(ROUGH)
                .flags(NO_SMASHING, DISABLE_DECOMPOSITION)
                .components(SiliconDioxide, 5, Muscovite, 2, Clinochlore, 2, Albite, 1)
                .buildAndRegister();

        Kimberlite = new Material.Builder(Supersymmetry.id("kimberlite"))
                .dust()
                .color(0x201313).iconSet(ROUGH)
                .flags(NO_SMASHING, DISABLE_DECOMPOSITION)
                .components(Forsterite, 3, Augite, 3, Andradite, 2, Lizardite, 1)
                .buildAndRegister();
    }


}
