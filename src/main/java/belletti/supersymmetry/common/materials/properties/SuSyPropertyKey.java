package belletti.supersymmetry.common.materials.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class SuSyPropertyKey<T extends IMaterialProperty<T>> {
    public static final PropertyKey<FiberProperty> FIBER = new PropertyKey<>("fiber", FiberProperty.class);
    static {
        MaterialProperties.addBaseType(FIBER);
    }
}
