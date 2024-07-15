package belletti.supersymmetry.common.data.materials.groovy;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static com.gregtechceu.gtceu.api.fluids.FluidConstants.*;

public class GroovyGlobals {
    public static int determineTemperatureGas(Material material) {
        // .temperature is a private field, there's no way to check it.
        /*
        if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.GAS) != null) {
            var current = material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.GAS).temperature;
            if (current != -1) {
                return current
            }
        }
         */
        BlastProperty property = material.getProperty(PropertyKey.BLAST);
        if (property == null) {
            return ROOM_TEMPERATURE;
        } else {
            return property.getBlastTemperature() + GAS_TEMPERATURE_OFFSET;
        }
    }

    public static int determineTemperatureLiquid(Material material) {
        // .temperature is a private field, there's no way to check it.
        /*
        if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.LIQUID) != null) {
            FluidBuilder current = material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.LIQUID).temperature;
            if (current != -1) {
                return current;
            }
        }
         */
        BlastProperty property = material.getProperty(PropertyKey.BLAST);
        if (property == null) {
            if (material.hasProperty(PropertyKey.DUST)) {
                return SOLID_LIQUID_TEMPERATURE;
            }
            return ROOM_TEMPERATURE;
        } else {
            return property.getBlastTemperature() + LIQUID_TEMPERATURE_OFFSET;
        }
    }



}
