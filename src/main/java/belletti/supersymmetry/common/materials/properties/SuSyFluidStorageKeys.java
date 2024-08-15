package belletti.supersymmetry.common.materials.properties;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.materials.SuSyMaterialIconType;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKey;

public class SuSyFluidStorageKeys {
    public static final FluidStorageKey SLURRY = new FluidStorageKey(Supersymmetry.id("slurry"),
            SuSyMaterialIconType.slurry,
            s -> s + "_slurry",
            m -> "susy.fluid.slurry",
            FluidState.LIQUID, -1);

    public static final FluidStorageKey IMPURE_SLURRY = new FluidStorageKey(Supersymmetry.id("impure_slurry"),
            SuSyMaterialIconType.slurry,
            s -> "impure_" + s + "_slurry",
            m -> "susy.fluid.impure_slurry",
            FluidState.LIQUID, -1);

//    private void SusyFluidStorageKeys() {}
}
