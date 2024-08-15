package belletti.supersymmetry.common.item;

import belletti.supersymmetry.api.materials.SuSyMaterialIconSet;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.ItemMaterialInfo;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.TagPrefixItem;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.world.item.Item;

import static belletti.supersymmetry.api.registries.SuSyRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.common.data.GTItems.materialInfo;

public final class CatalystItems {
    public static void init() {

    }
//
//    private static void addTieredCatalystItem(MetaOreDictItem.OreDictValueItem[] items, int id, int RGB, TagPrefix prefix) {
//        for (int i = 0; i < items.length; i++) {
//            items[i] = SuSyMetaItems.oreDictItem.addOreDictItem(id + i, GTValues.TierMaterials[i].toString(), RGB, SuSyMaterialIconSet.TIERS[i], prefix);
////            new TagPrefixItem()
//            REGISTRATE.item("empty_mold", Item::new)
//                    .lang("Empty Mold")
//                    .onRegister(materialInfo(new ItemMaterialInfo(new MaterialStack(GTMaterials.Steel, GTValues.M * 4))))
//                    .register();
//        }
//    }
}
