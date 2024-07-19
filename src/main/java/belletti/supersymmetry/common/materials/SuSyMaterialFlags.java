package belletti.supersymmetry.common.materials;

import belletti.supersymmetry.common.materials.properties.SuSyPropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class SuSyMaterialFlags {
    public static MaterialFlag GENERATE_CATALYST_PELLET = (new MaterialFlag.Builder("generate_catalyst_bed"))
            .requireProps(new PropertyKey[]{PropertyKey.DUST})
            .build();

    public static MaterialFlag GENERATE_CATALYST_BED = (new MaterialFlag.Builder("generate_catalyst_bed"))
            .requireProps(new PropertyKey[]{PropertyKey.DUST})
            .requireFlags(GENERATE_CATALYST_PELLET)
            .build();

    public static MaterialFlag GENERATE_SIFTED = (new MaterialFlag.Builder("generate_sifted"))
            .requireProps(new PropertyKey[]{PropertyKey.ORE})
            .build();

    public static MaterialFlag GENERATE_FLOTATED = (new MaterialFlag.Builder("generate_flotated"))
            .requireProps(new PropertyKey[]{PropertyKey.ORE})
            .build();

    public static MaterialFlag GENERATE_CONCENTRATE = (new MaterialFlag.Builder("generate_concentrate"))
            .requireProps(new PropertyKey[]{PropertyKey.ORE})
            .build();

    public static MaterialFlag GENERATE_FIBER = (new MaterialFlag.Builder("generate_fiber"))
            .requireProps(new PropertyKey[]{SuSyPropertyKey.FIBER})
            .build();

    public static MaterialFlag GENERATE_WET_FIBER = (new MaterialFlag.Builder("generate_wet_fiber"))
            .requireProps(new PropertyKey[]{SuSyPropertyKey.FIBER})
            .build();

    public static MaterialFlag GENERATE_THREAD = (new MaterialFlag.Builder("generate_thread"))
            .requireProps(new PropertyKey[]{SuSyPropertyKey.FIBER})
            .build();
}
