package belletti.supersymmetry.api.data.tag;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.SuSyStoneVariantBlock;
import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.data.materials.SuSyMaterialFlags;
import belletti.supersymmetry.common.data.materials.SuSyMaterials;
import belletti.supersymmetry.common.data.materials.info.SuSyMaterialIconType;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
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

    public static final TagPrefix catalystBed = new TagPrefix("catalystBed")
            .idPattern("%s_catalyst_bed")
            .defaultTagPath("catalyst_bed/%s")
            .unformattedTagPath("catalyst_bed")
            .langValue("%s Catalyst Bed")
            .materialAmount(GTValues.M / 4)
            .materialIconType(SuSyMaterialIconType.catalystBed)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_CATALYST_BED));

    public static final TagPrefix catalystPellet = new TagPrefix("catalystPellet")
            .idPattern("%s_catalyst_pellet")
            .defaultTagPath("catalyst_pellet/%s")
            .unformattedTagPath("catalyst_pellet")
            .langValue("%s Catalyst Pellet")
            .materialAmount(GTValues.M / 4)
            .materialIconType(SuSyMaterialIconType.catalystPellet)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_CATALYST_PELLET));

    // Tiered Catalysts Beds
    public static final TagPrefix catalystBedReduction = new TagPrefix("catalystBedReduction")
            .idPattern("%s_catalyst_bed_reduction")
            .defaultTagPath("catalyst_bed_reduction/%s")
            .unformattedTagPath("catalyst_bed_reduction")
            .langValue("%s Catalyst Bed Reduction")
            .materialAmount(GTValues.M)
            .materialIconType(SuSyMaterialIconType.catalystBed)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    public static final TagPrefix catalystBedOxidation = new TagPrefix("catalystBedOxidation")
            .idPattern("%s_catalyst_bed_oxidation")
            .defaultTagPath("catalyst_bed_oxidation/%s")
            .unformattedTagPath("catalyst_bed_oxidation")
            .langValue("%s Catalyst Bed Oxidation")
            .materialAmount(GTValues.M)
            .materialIconType(SuSyMaterialIconType.catalystBed)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    public static final TagPrefix catalystBedCracking = new TagPrefix("catalystBedCracking")
            .idPattern("%s_catalyst_bed_cracking")
            .defaultTagPath("catalyst_bed_cracking/%s")
            .unformattedTagPath("catalyst_bed_cracking")
            .langValue("%s Catalyst Bed Cracking")
            .materialAmount(GTValues.M)
            .materialIconType(SuSyMaterialIconType.catalystBed)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    public static final TagPrefix catalystBedZieglerNatta = new TagPrefix("catalystBedZieglerNatta")
            .idPattern("%s_catalyst_bed_ziegler_natta")
            .defaultTagPath("catalyst_bed_ziegler_natta/%s")
            .unformattedTagPath("catalyst_bed_ziegler_natta")
            .langValue("%s Catalyst Bed Ziegler Natta")
            .materialAmount(GTValues.M)
            .materialIconType(SuSyMaterialIconType.catalystBed)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    // Tiered Catalyst Pellets
    public static final TagPrefix catalystPelletReduction = new TagPrefix("catalystPelletReduction")
            .idPattern("%s_catalyst_pellet_reduction")
            .defaultTagPath("catalyst_pellet_reduction/%s")
            .unformattedTagPath("catalyst_pellet_reduction")
            .langValue("%s Catalyst Pellet Reduction")
            .materialAmount(GTValues.M * 4)
            .materialIconType(SuSyMaterialIconType.catalystPellet)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    public static final TagPrefix catalystPelletOxidation = new TagPrefix("catalystPelletOxidation")
            .idPattern("%s_catalyst_pellet_oxidation")
            .defaultTagPath("catalyst_pellet_oxidation/%s")
            .unformattedTagPath("catalyst_pellet_oxidation")
            .langValue("%s Catalyst Pellet Oxidation")
            .materialAmount(GTValues.M * 4)
            .materialIconType(SuSyMaterialIconType.catalystPellet)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    public static final TagPrefix catalystPelletCracking = new TagPrefix("catalystPelletCracking")
            .idPattern("%s_catalyst_pellet_cracking")
            .defaultTagPath("catalyst_pellet_cracking/%s")
            .unformattedTagPath("catalyst_pellet_cracking")
            .langValue("%s Catalyst Pellet Cracking")
            .materialAmount(GTValues.M * 4)
            .materialIconType(SuSyMaterialIconType.catalystPellet)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    public static final TagPrefix catalystPelletZieglerNatta = new TagPrefix("catalystPelletZieglerNatta")
            .idPattern("%s_catalyst_pellet_ziegler_natta")
            .defaultTagPath("catalyst_pellet_ziegler_natta/%s")
            .unformattedTagPath("catalyst_pellet_ziegler_natta")
            .langValue("%s Catalyst Pellet Ziegler Natta")
            .materialAmount(GTValues.M * 4)
            .materialIconType(SuSyMaterialIconType.catalystPellet)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> false);

    // Ore Processing Intermediates
    public static final TagPrefix dustSifted = new TagPrefix("dustSifted")
            .idPattern("%s_catalyst_pellet_ziegler_natta")
            .defaultTagPath("catalyst_pellet_ziegler_natta/%s")
            .unformattedTagPath("catalyst_pellet_ziegler_natta")
            .langValue("%s Catalyst Pellet Ziegler Natta")
            .materialIconType(SuSyMaterialIconType.sifted)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_SIFTED));

    public static final TagPrefix dustFlotated = new TagPrefix("dustFlotated")
            .idPattern("flotated_%s_dust")
            .defaultTagPath("flotated_dust/%s")
            .unformattedTagPath("flotated_dust")
            .langValue("Flotated %s Dust")
            .materialIconType(SuSyMaterialIconType.flotated)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_FLOTATED));

    public static final TagPrefix dustConcentrate = new TagPrefix("dustConcentrate")
            .idPattern("concentrate_%s_dust")
            .defaultTagPath("concentrate_dust/%s")
            .unformattedTagPath("concentrate_dust")
            .langValue("Concentrate %s Dust")
            .materialIconType(SuSyMaterialIconType.concentrate)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_CONCENTRATE));

    // Fiber
    public static final TagPrefix fiber = new TagPrefix("fiber")
            .idPattern("%s_fiber")
            .defaultTagPath("fiber/%s")
            .unformattedTagPath("fiber")
            .langValue("%s Fiber")
            .materialAmount(GTValues.M / 8)
            .materialIconType(SuSyMaterialIconType.fiber)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_FIBER));

    public static final TagPrefix wetFiber = new TagPrefix("wetFiber")
            .idPattern("%s_wet_fiber")
            .defaultTagPath("wet_fiber/%s")
            .unformattedTagPath("wet_fiber")
            .langValue("Wet %s Fiber")
            .materialAmount(GTValues.M / 8)
            .materialIconType(SuSyMaterialIconType.wetFiber)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_WET_FIBER));

    public static final TagPrefix thread = new TagPrefix("thread")
            .idPattern("%s_thread")
            .defaultTagPath("thread/%s")
            .unformattedTagPath("thread")
            .langValue("%s Thread")
            .materialAmount(GTValues.M / 8)
            .materialIconType(SuSyMaterialIconType.thread)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_THREAD));

    public static void init() {}
}
