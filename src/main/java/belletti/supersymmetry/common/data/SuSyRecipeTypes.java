package belletti.supersymmetry.common.data;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.SuSyGuiTextures;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.SoundType;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

// Originally SuSyRecipeMaps.java
public class SuSyRecipeTypes {
    public static final GTRecipeType COOLING_RECIPES = register("magnetic_refrigerator", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 0)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType SINTERING_RECIPES = register("sintering_oven", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 0)
            .setSound(GTSoundEntries.COMBUSTION);

    public static final GTRecipeType COAGULATION_RECIPES = register("coagulation_tank", MULTIBLOCK)
            .setMaxIOSize(2, 1, 2, 0);

    public static final GTRecipeType LATEX_COLLECTOR_RECIPES = register("latex_collector", ELECTRIC)
            .setMaxIOSize(0, 0, 1, 2)
            .setProgressBar(SuSyGuiTextures.PROGRESS_BAR_EXTRACTION, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSound(GTSoundEntries.DRILL_TOOL);

    public static final GTRecipeType VULCANIZATION_RECIPES = register("vulcanizing_press", ELECTRIC)
            .setMaxIOSize(4, 2, 2, 1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLD_OVERLAY)
            .setSound(GTSoundEntries.COMBUSTION);

    public static final GTRecipeType ROASTER_RECIPES = register("roaster", ELECTRIC)
            .setMaxIOSize(2, 2, 2, 3)
            .setSound(GTSoundEntries.COMBUSTION);

    // @TODO: dont we need a separated STEAM_VACUM_CHAMBER and  STEAM_LATEX_COLLECTOR_RECIPES
    // because of GuiTextures.PROGRESS_BAR_COMPRESS / GuiTextures.PROGRESS_BAR_COMPRESS_STEAM
    public static final GTRecipeType VACUUM_CHAMBER = register("vacuum_chamber", ELECTRIC)
            .setMaxIOSize(4, 1, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType CSTR_RECIPES = register("continuous_stirred_tank_reactor", ELECTRIC)
            .setMaxIOSize(1, 0, 4, 2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType FIXED_BED_REACTOR_RECIPES = register("fixed_bed_reactor", ELECTRIC)
            .setMaxIOSize(2, 1, 3, 2)
            .setSlotOverlay(false, false, SuSyGuiTextures.CATALYST_BED_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType TRICKLE_BED_REACTOR_RECIPES = register("trickle_bed_reactor", ELECTRIC)
            .setMaxIOSize(2, 0, 3, 2)
            .setSlotOverlay(false, false, SuSyGuiTextures.CATALYST_PELLET_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType BUBBLE_COLUMN_REACTOR_RECIPES = register("bubble_column_reactor", ELECTRIC)
            .setMaxIOSize(1, 0, 3, 2)
            .setSlotOverlay(false, false, SuSyGuiTextures.LARGE_REACTOR_ITEM_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType BATCH_REACTOR_RECIPES = register("batch_reactor", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSlotOverlay(false, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.BEAKER_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.BEAKER_OVERLAY_3)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, true, false, GuiTextures.BEAKER_OVERLAY_3)
            .setSlotOverlay(true, true, true, GuiTextures.BEAKER_OVERLAY_3)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType CRYSTALLIZER_RECIPES = register("crystallizer", ELECTRIC)
            .setMaxIOSize(3, 2, 3, 3)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType DRYER_RECIPES = register("dryer", ELECTRIC)
            .setMaxIOSize(2, 2, 2, 2)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType ION_EXCHANGE_COLUMN_RECIPES = register("ion_exchange_column", ELECTRIC)
            .setMaxIOSize(1, 1, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSlotOverlay(false, false, true, SuSyGuiTextures.CUBIC_LATTICE_OVERLAY)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, SuSyGuiTextures.CUBIC_LATTICE_OVERLAY)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEntries.BATH);

    public static final GTRecipeType ZONE_REFINER_RECIPES = register("zone_refiner", ELECTRIC)
            .setMaxIOSize(1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.CRYSTAL_OVERLAY)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType TUBE_FURNACE_RECIPES = register("tube_furnace", ELECTRIC)
            .setMaxIOSize(3, 1, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.TURBINE_OVERLAY)
            .setSlotOverlay(true, false, true, SuSyGuiTextures.CUBIC_LATTICE_OVERLAY)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType ELECTROSTATIC_SEPARATOR = register("electrostatic_separator", ELECTRIC)
            .setMaxIOSize(3, 6, 3, 3)
            .setSlotOverlay(false, false, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.DUST_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MAGNET, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType SPINNING_RECIPES = register("spinning", ELECTRIC)
            .setMaxIOSize(1, 1, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MAGNET, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType POLISHING_MACHINE = register("polishing_machine", ELECTRIC)
            .setMaxIOSize(1, 1, 2, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType FLUIDIZED_BED_REACTOR_RECIPES = register("fluidized_bed_reactor", ELECTRIC)
            .setMaxIOSize(2, 2, 3, 2)
            .setSlotOverlay(false, true, SuSyGuiTextures.LARGE_REACTOR_FLUID_OVERLAY)
            .setSlotOverlay(true, true, SuSyGuiTextures.LARGE_REACTOR_FLUID_OVERLAY)
            .setSlotOverlay(false, false, SuSyGuiTextures.LARGE_REACTOR_ITEM_OVERLAY)
            .setSlotOverlay(true, false, SuSyGuiTextures.LARGE_REACTOR_ITEM_OVERLAY)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType POLYMERIZATION_RECIPES = register("polymerization_tank", ELECTRIC)
            .setMaxIOSize(3, 1, 3, 2)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType ELECTROLYTIC_CELL_RECIPES = register("electrolytic_cell", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 4)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, false, SuSyGuiTextures.ELECTRODE_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSound(GTSoundEntries.ELECTROLYZER);

    public static final GTRecipeType COKING_RECIPES = register("coking_tower", ELECTRIC)
            .setMaxIOSize(1, 1, 3, 2)
            .setSound(GTSoundEntries.COMBUSTION);

    public static final GTRecipeType VACUUM_DISTILLATION_RECIPES = register("vacuum_distillation", ELECTRIC)
            .setMaxIOSize(1, 1, 1, 12)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType CATALYTIC_REFORMER_RECIPES = register("catalytic_reformer_recipes", ELECTRIC)
            .setMaxIOSize(1, 0, 2, 4)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType FERMENTATION_VAT_RECIPES = register("vat_fermentation", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 3)
            .setSlotOverlay(false, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType UV_RECIPES = register("uv_light_box", ELECTRIC)
            .setMaxIOSize(2, 1, 1, 1)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType ION_IMPLANTATION_RECIPES = register("ion_implantation", ELECTRIC)
            .setMaxIOSize(3, 1, 2, 0)
            .setSound(GTSoundEntries.ELECTROLYZER);

    public static final GTRecipeType CVD_RECIPES = register("cvd", ELECTRIC)
            .setMaxIOSize(3, 1, 2, 2)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType ORE_SORTER_RECIPES = register("ore_sorter", ELECTRIC)
            .setMaxIOSize(2, 20, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR);

    public static final GTRecipeType COOLING_TOWER_RECIPES = register("cooling_tower", ELECTRIC)
            .setMaxIOSize(0, 0, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType COOLING_UNIT_RECIPES = register("cooling_unit", ELECTRIC)
            .setMaxIOSize(0, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType FLUID_DECOMPRESSOR_RECIPES = register("fluid_decompressor", ELECTRIC)
            .setMaxIOSize(0, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMPRESSOR);

    public static final GTRecipeType FLUID_COMPRESSOR_RECIPES = register("fluid_compressor", ELECTRIC)
            .setMaxIOSize(0, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMPRESSOR);

    public static final GTRecipeType HEAT_EXCHANGER_RECIPES = register("heat_exchanger", ELECTRIC)
            .setMaxIOSize(1, 0, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType CONDENSER_RECIPES = register("condenser", ELECTRIC)
            .setMaxIOSize(0, 0, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType HEAT_RADIATOR_RECIPES = register("radiator", ELECTRIC)
            .setMaxIOSize(0, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType QUENCHER_RECIPES = register("quencher", ELECTRIC)
            .setMaxIOSize(2, 1, 2, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType WEAPONS_FACTORY_RECIPES = register("weapons_factory", ELECTRIC)
            .setMaxIOSize(9, 1, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER);

    public static final GTRecipeType LARGE_WEAPONS_FACTORY_RECIPES = register("large_weapons_factory", ELECTRIC)
            .setMaxIOSize(9, 1, 3, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER);

    public static final GTRecipeType RAILROAD_ENGINEERING_STATION_RECIPES = register("railroad_engineering_station", ELECTRIC)
            .setMaxIOSize(16, 1, 4, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER);

    public static final GTRecipeType MINING_DRILL_RECIPES = register("mining_drill", ELECTRIC)
            .setMaxIOSize(1, 1, 1, 1)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEntries.MACERATOR);

    public static final GTRecipeType GRAVITY_SEPARATOR_RECIPES = register("gravity_separator", ELECTRIC)
            .setMaxIOSize(1, 6, 1, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSlotOverlay(false, false, true, SuSyGuiTextures.ORE_CHUNK_OVERLAY)
            .setSlotOverlay(false, true, false, SuSyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSlotOverlay(false, true, true, SuSyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSlotOverlay(true, false, false, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, true, false, SuSyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSlotOverlay(true, true, true, SuSyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSound(GTSoundEntries.MACERATOR);

    public static final GTRecipeType REACTION_FURNACE_RECIPES = register("reaction_furnace", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType PRESSURE_SWING_ADSORBER_RECIPES = register("pressure_swing_adsorption", ELECTRIC)
            .setMaxIOSize(1, 1, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSound(GTSoundEntries.COMPRESSOR);

    public static final GTRecipeType MAGNETOHYDRODYNAMIC_FUELS = register("magnetohydrodynamic_generator", GENERATOR)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType ADVANCED_ARC_FURNACE = register("advanced_arc_furnace", ELECTRIC)
            .setMaxIOSize(4, 2, 3, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType EVAPORATION_POOL = register("evaporation_pool", ELECTRIC)
            .setMaxIOSize(1, 4, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType CLARIFIER = register("clarifier", ELECTRIC)
            .setMaxIOSize(1, 1, 1, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType MULTI_STAGE_FLASH_DISTILLATION = register("multi_stage_flash_distillation", ELECTRIC)
            .setMaxIOSize(0, 0, 3, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType FROTH_FLOTATION = register("froth_flotation", ELECTRIC)
            .setMaxIOSize(3, 2, 4, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);

    public static final GTRecipeType HIGH_TEMPERATURE_DISTILLATION = register("high_temperature_distillation", ELECTRIC)
            .setMaxIOSize(1, 1, 1, 12)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.UP_TO_DOWN)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType IN_SITU_LEACHER = register("in_situ_leacher", ELECTRIC)
            .setMaxIOSize(2, 2, 2, 2)
            .setSound(GTSoundEntries.COMPRESSOR);

    public static final GTRecipeType EUV_LITHOGRAPHY = register("euv_lithography", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 3)
            .setSound(GTSoundEntries.ELECTROLYZER);

    public static final GTRecipeType ROTARY_KILN = register("rotary_kiln", ELECTRIC)
            .setMaxIOSize(3, 2, 3, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR);

    public static final GTRecipeType HIGH_PRESSURE_CRYOGENIC_DISTILLATION = register("high_pressure_cryogenic_distillation", ELECTRIC)
            .setMaxIOSize(1, 0, 9, 9)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.UP_TO_DOWN)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType LOW_PRESSURE_CRYOGENIC_DISTILLATION = register("low_pressure_cryogenic_distillation", ELECTRIC)
            .setMaxIOSize(1, 0, 9, 9)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType SINGLE_COLUMN_CRYOGENIC_DISTILLATION = register("single_column_cryogenic_distillation", ELECTRIC)
            .setMaxIOSize(1, 0, 9, 9)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType REVERBERATORY_FURNACE = register("reverberatory_furnace", ELECTRIC)
            .setMaxIOSize(3, 3, 3, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType PHASE_SEPARATOR = register("phase_separator", ELECTRIC)
            .setMaxIOSize(0, 1, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);

    public static final GTRecipeType BATH_CONDENSER = register("bath_condenser", ELECTRIC)
            .setMaxIOSize(0, 0, 2, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressTexture.FillDirection.DOWN_TO_UP)
            .setSound(GTSoundEntries.BATH);

    public static final GTRecipeType DRONE_PAD = register("drone_pad", ELECTRIC)
            .setMaxIOSize(4, 9, 0, 0);

    public static final GTRecipeType BLENDER_RECIPES = register("blender", ELECTRIC)
            .setMaxIOSize(6, 1, 6, 2)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL)
            .setSmallRecipeMap(MIXER_RECIPES);

    public static final GTRecipeType LARGE_STEAM_TURBINE = register("large_steam_turbine", GENERATOR)
            .setEUIO(IO.OUT)
            .setMaxIOSize(1, 0, 2, 1)
            .setSlotOverlay(false, true, GuiTextures.CENTRIFUGE_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.TURBINE);

    public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
        var recipeType = new GTRecipeType(Supersymmetry.id(name), group, proxyRecipes);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }

    public static void init() {
    }
}
