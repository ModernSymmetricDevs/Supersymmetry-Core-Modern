package belletti.supersymmetry.api.data.tag;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.SuSyStoneVariantBlock;
import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.data.materials.SuSyMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.Tags;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.hasOreProperty;

public class SuSyTagPrefix {
    public static TagPrefix oreGabbro = TagPrefix.oreTagPrefix("oreGabbro", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Gabbro %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    () -> SuSyMaterials.Gabbro,
                    BlockBehaviour.Properties.of()
                            .mapColor(DyeColor.byId(0x5C5C5C))
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/gabbro_smooth"));

    public static TagPrefix oreGneiss = TagPrefix.oreTagPrefix("oreGneiss", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Gneiss %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    () -> SuSyMaterials.Gneiss,
                    BlockBehaviour.Properties.of()
                            .mapColor(DyeColor.byId(0x643631))
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/gneiss_smooth"));

    public static TagPrefix oreLimestone = TagPrefix.oreTagPrefix("oreLimestone", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Limestone %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    () -> SuSyMaterials.Limestone,
                    BlockBehaviour.Properties.of()
                            .mapColor(DyeColor.byId(0xa9a9a9))
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/limestone_smooth"));

    public static TagPrefix orePhyllite = TagPrefix.oreTagPrefix("orePhyllite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Phyllite %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    () -> SuSyMaterials.Phyllite,
                    BlockBehaviour.Properties.of()
                            .mapColor(DyeColor.byId(0x716f71))
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/phyllite_smooth"));

    public static TagPrefix oreQuartzite = TagPrefix.oreTagPrefix("oreQuartzite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Quartzite %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    null,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.QUARTZ)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/quartzite_smooth"));

    public static TagPrefix oreShale = TagPrefix.oreTagPrefix("oreShale", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Shale %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    () -> SuSyMaterials.Shale,
                    BlockBehaviour.Properties.of()
                            .mapColor(DyeColor.byId(0x3f2e2f))
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/shale_smooth"));

    public static TagPrefix oreSlate = TagPrefix.oreTagPrefix("oreSlate", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Slate %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    () -> SuSyMaterials.Slate,
                    BlockBehaviour.Properties.of()
                            .mapColor(DyeColor.byId(0x756869))
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/slate_smooth"));

    public static TagPrefix oreSoapstone = TagPrefix.oreTagPrefix("oreSoapstone", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Soapstone %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    null,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.TERRACOTTA_GRAY)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/soapstone_smooth"));

    public static TagPrefix oreKimberlite = TagPrefix.oreTagPrefix("oreKimberlite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Kimberlite %s Ore")
            .registerOre(
                    Blocks.STONE::defaultBlockState,
                    () -> SuSyMaterials.Kimberlite,
                    BlockBehaviour.Properties.of()
                            .mapColor(DyeColor.byId(0x201313))
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/susy_stones/kimberlite_smooth"));

//    public static TagPrefix catalystBed = oreTagPrefix("catalystBed", BlockTags.MINEABLE_WITH_PICKAXE);
//    public static TagPrefix catalystPellet = oreTagPrefix("catalystPellet", BlockTags.MINEABLE_WITH_PICKAXE);

    public static void init() {}
}
