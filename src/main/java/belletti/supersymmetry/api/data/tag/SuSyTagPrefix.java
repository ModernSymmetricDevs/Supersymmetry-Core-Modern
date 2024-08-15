package belletti.supersymmetry.api.data.tag;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.SuSyStoneTypes;
import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.materials.SuSyMaterialFlags;
import belletti.supersymmetry.common.materials.SuSyMaterials;
import belletti.supersymmetry.api.materials.SuSyMaterialIconType;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SuSyTagPrefix {
    public static TagPrefix oreGabbro = TagPrefix.oreTagPrefix("oreGabbro", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Gabbro %s Ore")
            .registerOre(
                    () -> SuSyBlocks.GABBRO.orElse(Blocks.STONE).defaultBlockState(),
                    () -> SuSyMaterials.Gabbro,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.GABBRO.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/gabbro"));

    public static TagPrefix oreGneiss = TagPrefix.oreTagPrefix("oreGneiss", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Gneiss %s Ore")
            .registerOre(
                    () -> SuSyBlocks.GNEISS.orElse(Blocks.STONE).defaultBlockState(),
                    () -> SuSyMaterials.Gneiss,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.GNEISS.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/gneiss"));

    public static TagPrefix oreLimestone = TagPrefix.oreTagPrefix("oreLimestone", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Limestone %s Ore")
            .registerOre(
                    () -> SuSyBlocks.LIMESTONE.orElse(Blocks.STONE).defaultBlockState(),
                    () -> SuSyMaterials.Limestone,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.LIMESTONE.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/limestone"));

    public static TagPrefix orePhyllite = TagPrefix.oreTagPrefix("orePhyllite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Phyllite %s Ore")
            .registerOre(
                    () -> SuSyBlocks.PHYLLITE.orElse(Blocks.STONE).defaultBlockState(),
                    () -> SuSyMaterials.Phyllite,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.PHYLLITE.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/phyllite"));

    public static TagPrefix oreQuartzite = TagPrefix.oreTagPrefix("oreQuartzite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Quartzite %s Ore")
            .registerOre(
                    () -> SuSyBlocks.QUARTZITE.orElse(Blocks.STONE).defaultBlockState(),
                    () -> GTMaterials.Quartzite,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.QUARTZITE.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/quartzite"));

    public static TagPrefix oreShale = TagPrefix.oreTagPrefix("oreShale", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Shale %s Ore")
            .registerOre(
                    () -> SuSyBlocks.SHALE.orElse(Blocks.STONE).defaultBlockState(),
                    () -> SuSyMaterials.Shale,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.SHALE.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/shale"));

    public static TagPrefix oreSlate = TagPrefix.oreTagPrefix("oreSlate", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Slate %s Ore")
            .registerOre(
                    () -> SuSyBlocks.SLATE.orElse(Blocks.STONE).defaultBlockState(),
                    () -> SuSyMaterials.Slate,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.SLATE.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/slate"));

    public static TagPrefix oreSoapstone = TagPrefix.oreTagPrefix("oreSoapstone", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Soapstone %s Ore")
            .registerOre(
                    () -> SuSyBlocks.SOAPSTONE.orElse(Blocks.STONE).defaultBlockState(),
                    () -> GTMaterials.Soapstone,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.SOAPSTONE.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/soapstone"));

    public static TagPrefix oreKimberlite = TagPrefix.oreTagPrefix("oreKimberlite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Kimberlite %s Ore")
            .registerOre(
                    () -> SuSyBlocks.KIMBERLITE.orElse(Blocks.STONE).defaultBlockState(),
                    () -> SuSyMaterials.Kimberlite,
                    BlockBehaviour.Properties.of()
                            .mapColor(SuSyStoneTypes.KIMBERLITE.mapColor)
                            .requiresCorrectToolForDrops()
                            .strength(2.0F, 10.0F),
                    Supersymmetry.id("block/kimberlite"));

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
            .defaultTagPath("flotated_dusts/%s")
            .unformattedTagPath("flotated_dusts")
            .langValue("Flotated %s Dust")
            .materialIconType(SuSyMaterialIconType.flotated)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_FLOTATED));

    public static final TagPrefix dustConcentrate = new TagPrefix("dustConcentrate")
            .idPattern("concentrate_%s_dust")
            .defaultTagPath("concentrate_dusts/%s")
            .unformattedTagPath("concentrate_dusts")
            .langValue("Concentrate %s Dust")
            .materialIconType(SuSyMaterialIconType.concentrate)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(mat -> mat.hasFlag(SuSyMaterialFlags.GENERATE_CONCENTRATE));

    // Fiber
    public static final TagPrefix fiber = new TagPrefix("fiber")
            .idPattern("%s_fiber")
            .defaultTagPath("fibers/%s")
            .unformattedTagPath("fibers")
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
