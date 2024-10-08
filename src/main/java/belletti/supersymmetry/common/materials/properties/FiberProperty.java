package belletti.supersymmetry.common.materials.properties;

import belletti.supersymmetry.common.materials.SuSyMaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IngotProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class FiberProperty implements IMaterialProperty<FiberProperty> {
    // For generating wet fibers
    public boolean solutionSpun;

    // To allow for fluid generation
    private boolean meltSpun;

    // For plate making
    private boolean weaving;

    public FiberProperty(boolean solutionSpun, boolean meltSpun, boolean weaving) {
        this.solutionSpun = solutionSpun;
        this.meltSpun = meltSpun;
        this.weaving = weaving;
    }

    // Default constructor
    public FiberProperty() {
        this(false, true, false);
    }

    @Override
    public void verifyProperty(MaterialProperties properties) {
        if (properties.hasProperty(PropertyKey.FLUID) && !this.meltSpun) { throw new IllegalStateException("Material " + properties.getMaterial() + " has both a fluid property and is not a melt spun fiber, which is not allowed!"); }
        if (this.solutionSpun) { properties.getMaterial().addFlags(SuSyMaterialFlags.GENERATE_WET_FIBER); }
        if (this.weaving) { properties.getMaterial().addFlags(MaterialFlags.GENERATE_PLATE); }

        properties.getMaterial().addFlags(SuSyMaterialFlags.GENERATE_FIBER, SuSyMaterialFlags.GENERATE_THREAD, MaterialFlags.DISABLE_DECOMPOSITION);
    }
}
