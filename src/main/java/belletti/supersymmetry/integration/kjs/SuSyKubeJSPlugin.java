package belletti.supersymmetry.integration.kjs;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.data.SuSyItems;
import belletti.supersymmetry.common.data.SuSyMachines;
import belletti.supersymmetry.common.data.SuSyRecipeTypes;
import belletti.supersymmetry.common.materials.SuSyElementMaterials;
import belletti.supersymmetry.common.materials.SuSyMaterials;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;

public class SuSyKubeJSPlugin extends KubeJSPlugin {
    @Override
    public void registerBindings(BindingsEvent event) {
        super.registerBindings(event);
        event.add("SuSyMaterials", SuSyMaterials.class);
        event.add("SuSyElements", SuSyElementMaterials.class);
        event.add("SuSyBlocks", SuSyBlocks.class);
        event.add("SuSyMachines", SuSyMachines.class);
        event.add("SuSyItems", SuSyItems.class);
        event.add("SuSyRecipeTypes", SuSyRecipeTypes.class);

        event.add("SuSyCore", Supersymmetry.class);
    }
}
