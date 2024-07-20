package belletti.supersymmetry.common.data;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.*;
import belletti.supersymmetry.common.machine.multiblock.electrical.*;
import belletti.supersymmetry.common.machine.multiblock.primitive.CoagulationTank;
import belletti.supersymmetry.common.machine.multiblock.primitive.PrimitiveMudPump;
import belletti.supersymmetry.common.machine.multiblock.electrical.Dumper;
import belletti.supersymmetry.common.machine.singleblock.electrical.BathCondenser;
import belletti.supersymmetry.common.pattern.SuSyPredicates;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.*;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.client.renderer.machine.WorkableSteamMachineRenderer;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.ints.Int2LongFunction;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static belletti.supersymmetry.api.registries.SuSyRegistries.REGISTRATE;
import static belletti.supersymmetry.common.pattern.SuSyPredicates.isTankSizeIndicatorPredicate;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.air;
import static com.gregtechceu.gtceu.api.pattern.Predicates.autoAbilities;
import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;

public class SuSyMachines {
    public final static int[] ELECTRIC_TIERS = GTValues.tiersBetween(LV, GTCEuAPI.isHighTier() ? OpV : UV);
    public final static int[] LOW_TIERS = GTValues.tiersBetween(LV, EV);
    public final static int[] HIGH_TIERS = GTValues.tiersBetween(IV, GTCEuAPI.isHighTier() ? OpV : UHV);
    public static final Int2LongFunction defaultTankSizeFunction = tier -> (tier <= GTValues.LV ? 8 : tier == GTValues.MV ? 12 : tier == GTValues.HV ? 16 : tier == GTValues.EV ? 32 : 64) * FluidHelper.getBucket();

    // Simple Machines //

    public final static Pair<MachineDefinition, MachineDefinition> STEAM_ROASTER = registerSimpleSteamMachines(
            "roaster",
            SuSyRecipeTypes.ROASTER_RECIPES
    );
    public final static MachineDefinition[] ROASTER = registerSimpleMachines(
            "roaster",
            SuSyRecipeTypes.ROASTER_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static Pair<MachineDefinition, MachineDefinition> STEAM_VULCANIZING_PRESS = registerSimpleSteamMachines(
            "vulcanizing_press",
            SuSyRecipeTypes.VULCANIZATION_RECIPES
    );
    public final static MachineDefinition[] VULCANIZING_PRESS = registerSimpleMachines(
            "vulcanizing_press",
            SuSyRecipeTypes.VULCANIZATION_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, EV)
    );

    public final static Pair<MachineDefinition, MachineDefinition> STEAM_MIXER = registerSimpleSteamMachines(
            "mixer",
            GTRecipeTypes.MIXER_RECIPES
    );

    public final static Pair<MachineDefinition, MachineDefinition> STEAM_VACUUM_CHAMBER = registerSimpleSteamMachines(
            "vacuum_chamber",
            SuSyRecipeTypes.VACUUM_CHAMBER
    );
    public final static MachineDefinition[] VACUUM_CHAMBER = registerSimpleMachines(
            "vacuum_chamber",
            SuSyRecipeTypes.VACUUM_CHAMBER,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] BATCH_REACTOR = registerSimpleMachines(
            "batch_reactor",
            SuSyRecipeTypes.BATCH_REACTOR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] CRYSTALLIZER = registerSimpleMachines(
            "crystallizer",
            SuSyRecipeTypes.CRYSTALLIZER_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] DRYER = registerSimpleMachines(
            "dryer",
            SuSyRecipeTypes.DRYER_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] ION_EXCHANGE_COLUMN = registerSimpleMachines(
            "ion_exchange_column",
            SuSyRecipeTypes.ION_EXCHANGE_COLUMN_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] ZONE_REFINER = registerSimpleMachines(
            "zone_refiner",
            SuSyRecipeTypes.ZONE_REFINER_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] TUBE_FURNACE = registerSimpleMachines(
            "tube_furnace",
            SuSyRecipeTypes.TUBE_FURNACE_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] UV_LIGHT_BOX = registerSimpleMachines(
            "uv_light_box",
            SuSyRecipeTypes.UV_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] CVD = registerSimpleMachines(
            "cvd",
            SuSyRecipeTypes.CVD_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] ION_IMPLANTER = registerSimpleMachines(
            "ion_implanter",
            SuSyRecipeTypes.ION_IMPLANTATION_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] FLUID_COMPRESSOR = registerSimpleMachines(
            "fluid_compressor",
            SuSyRecipeTypes.FLUID_COMPRESSOR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] FLUID_DECOMPRESSOR = registerSimpleMachines(
            "fluid_decompressor",
            SuSyRecipeTypes.FLUID_DECOMPRESSOR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] WEAPONS_FACTORY = registerSimpleMachines(
            "weapons_factory",
            SuSyRecipeTypes.WEAPONS_FACTORY_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] ELECTROSTATIC_SEPARATOR = registerSimpleMachines(
            "electrostatic_separator",
            SuSyRecipeTypes.ELECTROSTATIC_SEPARATOR,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] TEXTILE_SPINNER = registerSimpleMachines(
            "textile_spinner",
            SuSyRecipeTypes.SPINNING_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );
    public final static MachineDefinition[] POLISHING_MACHINE = registerSimpleMachines(
            "polishing_machine",
            SuSyRecipeTypes.POLISHING_MACHINE,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] PHASE_SEPARATOR = registerSimpleMachines(
            "phase_separator",
            SuSyRecipeTypes.PHASE_SEPARATOR,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition BATH_CONDENSER = REGISTRATE.machine("bath_condenser", holder -> new BathCondenser(holder, LV, defaultTankSizeFunction))
            .langValue("Bath Condenser")
            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(Supersymmetry.id("bath_condenser"), SuSyRecipeTypes.BATH_CONDENSER))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.BATH_CONDENSER)
            .workableTieredHullRenderer(Supersymmetry.id("block/machines/bath_condenser"))
            .tooltips(
                    Stream.concat(
                            Stream.of(Component.literal("Only works inside a Cryogenic Distillation Tower").withStyle(ChatFormatting.AQUA)),
                            Stream.of(workableTiered(LV, GTValues.V[LV], GTValues.V[LV] * 64, SuSyRecipeTypes.BATH_CONDENSER, defaultTankSizeFunction.apply(LV), true))
                    ).toArray(Component[]::new)
            )
            .register();

    // @TODO: the machine is losing it's front/back side texture when powered up, besides that, the textures are not emissive
    // it's affecting both steam and normal latex collectors
    public final static Pair<MachineDefinition, MachineDefinition> STEAM_LATEX_COLLECTOR = registerSimpleSteamMachines(
            "latex_collector",
            SuSyRecipeTypes.LATEX_COLLECTOR_RECIPES
    );
    public final static MachineDefinition[] LATEX_COLLECTOR = registerSimpleMachines(
            "latex_collector",
            SuSyRecipeTypes.LATEX_COLLECTOR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, EV)
    );

    public final static MachineDefinition[] CONTINUOUS_STIRRED_TANK_REACTOR = registerSimpleMachines(
            "continuous_stirred_tank_reactor",
            SuSyRecipeTypes.CSTR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] FIXED_BED_REACTOR = registerSimpleMachines(
            "fixed_bed_reactor",
            SuSyRecipeTypes.FIXED_BED_REACTOR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] TRICKLE_BED_REACTOR = registerSimpleMachines(
            "trickle_bed_reactor",
            SuSyRecipeTypes.TRICKLE_BED_REACTOR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public final static MachineDefinition[] BUBBLE_COLUMN_REACTOR = registerSimpleMachines(
            "bubble_column_reactor",
            SuSyRecipeTypes.BUBBLE_COLUMN_REACTOR_RECIPES,
            defaultTankSizeFunction,
            true,
            GTValues.tiersBetween(LV, OpV)
    );

    public static final MultiblockMachineDefinition COAGULATION_TANK = REGISTRATE.multiblock("coagulation_tank", CoagulationTank::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.COAGULATION_RECIPES)
            .appearanceBlock(SuSyBlocks.COAGULATION_TANK_WALL)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "XXX", "XXX")
                    .aisle("XXX", "XPX", "X#X").setRepeatable(1, 4)
                    .aisle("XXX", "XSX", "XXX")
                    //      L1      L2     l3
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('X',
                            Predicates.blocks(SuSyBlocks.COAGULATION_TANK_WALL.get())
                                    .or(Predicates.ability(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1))
                                    .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)))
                    .where('P', isTankSizeIndicatorPredicate())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    Supersymmetry.id("block/casings/wooden_coagulation_tank_wall/bottom"),
                    Supersymmetry.id("block/multiblock/coagulation_tank"))
            .register();

    public static final MultiblockMachineDefinition PRIMITIVE_MUD_PUMP = REGISTRATE.multiblock("primitive_mud_pump", PrimitiveMudPump::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("       ", "       ", "       ", "       ", "       ", "       ")
                    .aisle(" A   A ", " A   A ", " BBBBB ", " A   A ", " A   A ", " BBBBB ")
                    .aisle("       ", "       ", " BBBBB ", "  CCC  ", "  CCC  ", " BBBBB ")
                    .aisle("       ", "       ", " BBBBB ", "  CCC  ", "  CCC  ", " BBBBB ")
                    .aisle("       ", "       ", " BBBBB ", "  CSC  ", "  CCC  ", " BBBBB ")
                    .aisle(" A   A ", " A   A ", " BBBBB ", " A   A ", " A   A ", " BBBBB ")
                    .aisle("       ", "       ", "       ", "       ", "       ", "       ")
                    //      L1      L2     l3
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('A', Predicates.frames(GTMaterials.TreatedWood))
                    .where('B', Predicates.states(GTBlocks.TREATED_WOOD_PLANK.getDefaultState()))
                    .where('C', Predicates.states(GTBlocks.CASING_BRONZE_BRICKS.getDefaultState())
                            .or(Predicates.abilities(PartAbility.PUMP_FLUID_HATCH, PartAbility.EXPORT_FLUIDS)))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    Supersymmetry.id("block/multiblock/primitive_mud_pump"))
            .register();

    public static final MultiblockMachineDefinition MINING_DRILL = REGISTRATE.multiblock("mining_drill", MiningDrill::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.MINING_DRILL_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("               ", "     DDDDD     ", "     DDDDD     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "   DDDDDDDDD   ", "   DDDDDDDDD   ", "    BB   BB    ", "    BB   BB    ", "    BB   BB    ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "  DDDDDDDDDDD  ", "  DDDDDDDDDDD  ", "    BB   BB    ", "    BB   BB    ", "    BB   BB    ", "     BB BB     ", "     BB BB     ", "     BB BB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", " DDDDDDDDDDDDD ", " DDDDDDDDDDDDD ", "               ", "               ", "               ", "     BB BB     ", "     BB BB     ", "     BB BB     ", "     BB BB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", " DDDDDDDDDDDDD ", " DDDDDDDDDDDDD ", " BB         BB ", " BB         BB ", " BB         BB ", "               ", "       E       ", "     BBEBB     ", "     AAEAA     ", "       E       ", "       E       ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "DDDDDD   DDDDDD", "DDDDDD   DDDDDD", " BB         BB ", " BB         BB ", " BB         BB ", "  BB       BB  ", "  BB   E   BB  ", "  BBBAAAAABBB  ", "   BAAACAAAB   ", "     GGCGG     ", "     BGEGB     ", "     BGAGB     ", "     B   B     ", "     B   B     ", "     BB  B     ", "     B B B     ", "     B  BB     ", "     B   B     ")
                    .aisle("       H       ", "DDDDD     DDDDD", "DDDDD     DDDDD", "      AAA      ", "      BAB      ", "      BAB      ", "  BB  BAB  BB  ", "  BB  BAB  BB  ", "  BBBAAAAABBB  ", "   BAACCCAAB   ", "     GCCCG     ", "     GCCCG     ", "     GGCGG     ", "               ", "               ", "         B     ", "      ACA      ", "     BAAA      ", "               ")
                    .aisle("      HHH      ", "DDDDD  F  DDDDD", "DDDDD  C  DDDDD", "      ACA      ", "      ACA      ", "      ACA      ", "      ACA      ", "    EEACAEE    ", "    EAACAAE    ", "    ECCCCCE    ", "    ECCCCCE    ", "    EECCCEE    ", "     AGGGA     ", "       C       ", "       C       ", "       C       ", "     BCCCB     ", "      AAA      ", "               ")
                    .aisle("       H       ", "DDDDD     DDDDD", "DDDDD     DDDDD", "      AAA      ", "      BSB      ", "      BAB      ", "  BB  BAB  BB  ", "  BB  BAB  BB  ", "  BBBAAAAABBB  ", "   BAACCCAAB   ", "     GCCCG     ", "     GCCCG     ", "     GGCGG     ", "               ", "               ", "     B         ", "      ACA      ", "      AAAB     ", "               ")
                    .aisle("               ", "DDDDDD   DDDDDD", "DDDDDD   DDDDDD", " BB         BB ", " BB         BB ", " BB         BB ", "  BB       BB  ", "  BB   E   BB  ", "  BBBAAAAABBB  ", "   BAAACAAAB   ", "     GGCGG     ", "     BGEGB     ", "     BGAGB     ", "     B   B     ", "     B   B     ", "     B  BB     ", "     B B B     ", "     BB  B     ", "     B   B     ")
                    .aisle("               ", " DDDDDDDDDDDDD ", " DDDDDDDDDDDDD ", " BB         BB ", " BB         BB ", " BB         BB ", "               ", "       E       ", "     BBEBB     ", "     AAEAA     ", "       E       ", "       E       ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", " DDDDDDDDDDDDD ", " DDDDDDDDDDDDD ", "               ", "               ", "               ", "     BB BB     ", "     BB BB     ", "     BB BB     ", "     BB BB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "  DDDDDDDDDDD  ", "  DDDDDDDDDDD  ", "    BB   BB    ", "    BB   BB    ", "    BB   BB    ", "     BB BB     ", "     BB BB     ", "     BB BB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "   DDDDDDDDD   ", "   DDDDDDDDD   ", "    BB   BB    ", "    BB   BB    ", "    BB   BB    ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "     DDDDD     ", "     DDDDD     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(true, false, false))
                            .or(Predicates.ability(PartAbility.EXPORT_ITEMS))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('B', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('D', Predicates.blocks(GTBlocks.LIGHT_CONCRETE.get()))
                    .where('E', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('F', Predicates.blocks(SuSyBlocks.DRILL_HEAD.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_GRATE.get()))
                    .where('H', SuSyPredicates.oreDepositPredicate())
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/mining_drill"))
            .register();

    public static final MultiblockMachineDefinition CoolingUnit = REGISTRATE.multiblock("cooling_unit", CoolingUnit::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.COOLING_UNIT_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAAAAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "AADDDAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "       ", "  EEE  ")
                    .aisle("AAAAAAA", "A#####A", "A#####A", "A#####A", "A#####A", "A#####A", "A#####A", "A#####A", "AAAAAAA", " EEEEE ", " EEEEE ")
                    .aisle("AAAAAAA", "A##B##A", "A##B##A", "A##B##A", "D##B##D", "A##B##A", "A##B##A", "A##B##A", "AAAAAAA", " E   E ", "EE C EE")
                    .aisle("AAAAAAA", "A#BDB#A", "A#BDB#A", "A#BDB#A", "D#BDB#D", "A#BDB#A", "A#BDB#A", "A#BDB#A", "AAAAAAA", " E C E ", "EECCCEE")
                    .aisle("AAAAAAA", "A##B##A", "A##B##A", "A##B##A", "D##B##D", "A##B##A", "A##B##A", "A##B##A", "AAAAAAA", " E   E ", "EE C EE")
                    .aisle("AAAAAAA", "A#####A", "A#####A", "A#####A", "A#####A", "A#####A", "A#####A", "A#####A", "AAAAAAA", " EEEEE ", " EEEEE ")
                    .aisle("AAASAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "AADDDAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "       ", "  EEE  ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(true, false, false))
                            .or(Predicates.ability(PartAbility.EXPORT_ITEMS))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('B', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('C', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.StainlessSteel).get()))
                    .where('D', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('E', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where(' ', Predicates.any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/cooling_unit"))
            .register();

    public static final MultiblockMachineDefinition Blender = REGISTRATE.multiblock("blender", Blender::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.BLENDER_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" XXX ", " XPX ", " XXX ", "  X  ")
                    .aisle("XXXXX", "X D X", "X   X", "  X  ")
                    .aisle("XXXXX", "PDDDP", "X E X", "XXCXX")
                    .aisle("XXXXX", "X D X", "X   X", "  X  ")
                    .aisle(" XXX ", " XSX ", " XXX ", "  X  ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('X', Predicates.blocks(GTBlocks.CASING_PTFE_INERT.get())
                            .setMinGlobalLimited(34)
                            .or(Predicates.autoAbilities()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where('D', Predicates.blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()))
                    .where('E', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.StainlessSteel).get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STAINLESS_STEEL_GEARBOX.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition CatalyticReformer = REGISTRATE.multiblock("catalytic_reformer", CatalyticReformer::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.CATALYTIC_REFORMER_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("F   F", "XXXPX", "XXXPX", "XXXPX")
                    .aisle("     ", "XXXPX", "X###M", "XXXPX")
                    .aisle("F   F", "XXXPX", "XSXPX", "XXXPX")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('X', Predicates.blocks(GTBlocks.CASING_TITANIUM_STABLE.get())
                            .setMinGlobalLimited(24)
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), true, false, true, true, true, true))
                            .or(Predicates.autoAbilities(true, false, false)))
                    .where('P', Predicates.blocks(GTBlocks.CASING_TITANIUM_PIPE.get()))
                    .where('F', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Titanium).get()))
                    .where('M', Predicates.ability(PartAbility.MUFFLER))
                    .where(' ', Predicates.any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition AdvancedArcFurnace = REGISTRATE.multiblock("advanced_arc_furnace", AdvancedArcFurnace::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.ADVANCED_ARC_FURNACE)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" AAA ", " AAA ", " EEE ", "     ")
                    .aisle("AAAAA", "A#C#A", "E#C#E", " ACA ")
                    .aisle("CAAAC", "C###C", "C###C", "CAAAC")
                    .aisle("AAAAA", "A###A", "E###E", " AAA ")
                    .aisle(" AAA ", " ASA ", " EEE ", "     ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('C', Predicates.blocks(SuSyBlocks.ELECTRODE_ASSEMBLY_CARBON.get()))
                    .where('D', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('E', Predicates.blocks(GTBlocks.FIREBOX_STEEL.get()))
                    .where(' ', Predicates.any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/arc_furnace"))
            .register();

    public static final MultiblockMachineDefinition Clarifier = REGISTRATE.multiblock("clarifier", Clarifier::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.CLARIFIER)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("      AAAA      ", "      AAAA      ", "      AAAA      ", "                ")
                    .aisle("    AAAAAAAA    ", "    AADDDDAA    ", "    AA    AA    ", "                ")
                    .aisle("   AAAAAAAAAA   ", "   ADDDDDDDDA   ", "   A        A   ", "                ")
                    .aisle("  AAAAAAAAAAAA  ", "  ADDDDDDDDDDA  ", "  A          A  ", "                ")
                    .aisle(" AAAAAAAAAAAAAA ", " ADDDDDDDDDDDDA ", " A            A ", "                ")
                    .aisle(" AAAAAAAAAAAAAA ", " ADDDDDDDDDDDDA ", " A            A ", "                ")
                    .aisle("AAAAAAAAAAAAAAAA", "ADDDDDDDDDDDDDDA", "A              A", "                ")
                    .aisle("AAAAAAAAAAAAAAAA", "ADDDDDDBBDDDDDDA", "A      BB      A", "       EE       ")
                    .aisle("AAAAAAAAAAAAAAAA", "ADDDDDDBBDDDDDDA", "A      BBF     A", "       EE       ")
                    .aisle("AAAAAAAAAAAAAAAA", "ADDDDDDDDDDDDDDA", "A       FFF    A", "                ")
                    .aisle(" AAAAAAAAAAAAAA ", " ADDDDDDDDDDDDA ", " A       FFF  A ", "                ")
                    .aisle(" AAAAAAAAAAAAAA ", " ADDDDDDDDDDDDA ", " A        FFF A ", "                ")
                    .aisle("  AAAAAAAAAAAA  ", "  ADDDDDDDDDDA  ", "  A        FFA  ", "                ")
                    .aisle("   AAAAAAAAAC   ", "   ADDDDDDDDA   ", "   A        A   ", "                ")
                    .aisle("    AAAAAAAAC   ", "    AADDDDAA    ", "    AA    AA    ", "                ")
                    .aisle("      AAAA BBB  ", "      AAAA BSB  ", "      AAAA      ", "                ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('A', Predicates.blocks(GTBlocks.LIGHT_CONCRETE.get())
                            .setMinGlobalLimited(250)
                            .or(Predicates.autoAbilities())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('D', Predicates.blocks(SuSyBlocks.MULTIBLOCK_TANK.get(BlockMultiblockTank.MultiblockTankType.CLARIFIER).get()))
                    .where('E', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('F', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/clarifier"))
            .register();

    public static final MultiblockMachineDefinition CokingTower = REGISTRATE.multiblock("coking_tower", CokingTower::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.COKING_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" CCSCCF", "PCP PCP")
                    .aisle(" CFCFCF", "PCP PCP")
                    .aisle(" CFCFCF", "PCP PCP")
                    .aisle(" CFCFCF", "PPP PPP")
                    .aisle(" CFCFCF", "  P   P")
                    .aisle(" CCCCCF", "  P   P")
                    .aisle("  FFFFF", "  P   P")
                    .aisle("  FF FF", "  P   P")
                    .aisle("  FF FF", "  P   P")
                    .aisle("  FF FF", "  P   P")
                    .aisle("  FF FF", "       ")
                    .aisle("  FF FF", "       ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('F', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY))
                            .or(Predicates.ability(PartAbility.MUFFLER)))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition Condenser = REGISTRATE.multiblock("condenser", Condenser::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.CONDENSER_RECIPES)
            .appearanceBlock(GTBlocks.CASING_ALUMINIUM_FROSTPROOF)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "CCC", "CCC", "CCC")
                    .aisle("CCC", "C C", "C C", "CCC")
                    .aisle("CCC", "CSC", "CCC", "CCC")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('C', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), true, true, false, false, true, true)))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_frost_proof"),
                    GTCEu.id("block/multiblock/condenser"))
            .register();

    public static final MultiblockMachineDefinition electrolyticCell = REGISTRATE.multiblock("electrolytic_cell", ElectrolyticCell::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.ELECTROLYTIC_CELL_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCCCC", "CCCCC", "CCCCC")
                    .aisle("CCCCC", "CPPPC", "CPPPC")
                    .aisle("CCCCC", "CPPPC", "CPPPC")
                    .aisle("CCCCC", "CCSCC", "CCCCC")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/electrolytic_cell"))
            .register();

    public static final MultiblockMachineDefinition evaporationPool = REGISTRATE.multiblock("evaporation_pool", EvaporationPool::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.EVAPORATION_POOL)
//            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .appearanceBlock(GTBlocks.LIGHT_CONCRETE)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("efFIEEEEEE", "          ")
                    .aisle("EEEEEEEEEE", " EEEEEEEE ")
                    .aisle("EECCCGCCEE", " E######E ")
                    .aisle("EECGCGCGEE", " E######E ")
                    .aisle("EECGCGCGEE", " E######E ")
                    .aisle("EECGCGCGEE", " E######E ")
                    .aisle("EECGCGCGEE", " E######E ")
                    .aisle("EECGCCCGEE", " E######E ")
                    .aisle("EEEEEEEEEE", " EEEEEEEE ")
                    .aisle("EEESEEEEEE", "          ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('E', Predicates.blocks(GTBlocks.LIGHT_CONCRETE.get()))
                    .where('G', Predicates.blocks(SuSyBlocks.EVAPORATION_BED.get()))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('e', Predicates.ability(PartAbility.INPUT_ENERGY))
                    .where('f', Predicates.ability(PartAbility.IMPORT_FLUIDS))
                    .where('F', Predicates.ability(PartAbility.EXPORT_FLUIDS))
                    .where('I', Predicates.ability(PartAbility.IMPORT_ITEMS))
                    .where('C', Predicates.heatingCoils())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/stones/light_concrete/stone"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition fermentation_vat = REGISTRATE.multiblock("fermentation_vat", FermentationVat::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.FERMENTATION_VAT_RECIPES)
            .appearanceBlock(GTBlocks.MACHINE_CASING_ULV)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("     ", "     ", " XXX ", " XXX ", " XXX ", "     ")
                    .aisle(" F F ", " XXX ", "X###X", "X###X", "X###X", " XXX ")
                    .aisle("     ", " XXX ", "X###X", "X###X", "X###X", " XMX ")
                    .aisle(" F F ", " XXX ", "X###X", "X###X", "X###X", " XXX ")
                    .aisle("     ", "     ", " XXX ", " XSX ", " XXX ", "     ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('X', Predicates.blocks(GTBlocks.MACHINE_CASING_ULV.get())
                            .setMinGlobalLimited(40)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('F', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('M', Predicates.ability(PartAbility.MUFFLER))
                    .where(' ', Predicates.any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/voltage/ulv/side"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition fluidizedBedReactor = REGISTRATE.multiblock("fluidized_bed_reactor", FluidizedBedReactor::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.FLUIDIZED_BED_REACTOR_RECIPES)
            .appearanceBlock(GTBlocks.CASING_PTFE_INERT)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("F F", "XXX", "XXX", "XXX", "XXX")
                    .aisle("   ", "XPX", "XPX", "XPX", "XPX")
                    .aisle("F F", "XSX", "XXX", "XXX", "XXX")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('F', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where('X', Predicates.blocks(GTBlocks.CASING_PTFE_INERT.get())
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_inert_ptfe"),
                    Supersymmetry.id("block/multiblock/fluidized_bed"))
            .register();

    public static final MultiblockMachineDefinition FrothFlotationTank = REGISTRATE.multiblock("froth_flotation_tank", FrothFlotationTank::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.FROTH_FLOTATION)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("   B   ", "   B   ", "   B   ", "       ", "       ")
                    .aisle("  AAA  ", "  AAA  ", "  AAA  ", "  AAA  ", "  AAA  ")
                    .aisle(" AAAAA ", " ABBBA ", " ABBBA ", " ADDDA ", " A   A ")
                    .aisle("BAAAAAB", "BABBBAB", "BABBBAB", " ADBDA ", " A E A ")
                    .aisle(" AAAAA ", " ABBBA ", " ABBBA ", " ADDDA ", " A   A ")
                    .aisle("  AAA  ", "  AAA  ", "  AAA  ", "  AAA  ", "  AAA  ")
                    .aisle("   B   ", "   B   ", "   S   ", "       ", "       ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(51)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('D', Predicates.states(SuSyBlocks.MULTIBLOCK_TANK.get(BlockMultiblockTank.MultiblockTankType.FLOTATION).getDefaultState()))
                    .where('E', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get())) // double check this
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Supersymmetry.id("block/multiblock/froth_flotation"))
            .register();

    public static final MultiblockMachineDefinition GravitySeparator = REGISTRATE.multiblock("gravity_separator", GravitySeparator::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.GRAVITY_SEPARATOR_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, UP, BACK)
                    .aisle("C   C", "CC CC", "CFCFC", "CCSCC", " CCC ", " CCC ", "     ")
                    .aisle("     ", " OOO ", "C###C", "RRRRR", "C###C", "C   C", "     ")
                    .aisle("C   C", "C   C", "MCCCM", "C###C", "RRRRR", "C   C", "     ")
                    .aisle("C   C", "C   C", "ECCCE", "RRRRR", "C###C", "C###C", "     ")
                    .aisle("     ", "     ", "C   C", "CCCCC", "RRRRR", "C###C", "C###C")
                    .aisle("     ", "C   C", "C   C", " CCC ", "C###C", "RRRRR", "J###J")
                    .aisle("C   C", "CC CC", "CCCCC", " CCC ", " CCC ", "CCCCC", "CIIIC")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('R', Predicates.blocks(SuSyBlocks.SEPARATOR_ROTOR.get()))
//                    .where('R', rotorOrientation()) // @TODO: render (and require) the rotor using the proper specific direction
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where('M', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('E', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('I', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS)))
                    .where('O', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.EXPORT_ITEMS)))
                    .where('J', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS)))
                    .where('F', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS)))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    // @TODO: add addDisplayText for every multiblock until here

    public static final MultiblockMachineDefinition HeatExchanger = REGISTRATE.multiblock("heat_exchanger", HeatExchanger::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.HEAT_EXCHANGER_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CCC", "BCB", "ACA")
                    .aisle("CCC", "CDC", "ACA")
                    .aisle("CCC", "CDC", "ACA")
                    .aisle("CCC", "CDC", "ACA")
                    .aisle("CCC", "CDC", "ACA")
                    .aisle("CCC", "CDC", "ACA")
                    .aisle("CCC", "CDC", "ACA")
                    .aisle("CCC", "CDC", "ACA")
                    .aisle("CCC", "BSB", "ACA")
                    .where('S', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('A', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('B', Predicates.ability(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(2)
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(2)))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)) // @TODO: check if all machine that needed a maintenance port actually have it
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)))
                    .where('D', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/heat_exchanger"))
            .register();

    // @TODO: fix bloom, HeatRadiator is a good one for testing

    public static final MultiblockMachineDefinition HeatRadiator = REGISTRATE.multiblock("heat_radiator", HeatRadiator::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.HEAT_RADIATOR_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, FRONT, UP)
                    .aisle("ASA") // bottom
                    .aisle("CBC") // middle
                    .aisle("AAA") // top
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('B', Predicates.blocks(SuSyBlocks.SERPENTINE.get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/radiator"))
            .register();

    public static final MultiblockMachineDefinition HighPressureCryogenicDistillationPlant = REGISTRATE.multiblock("hp_cryogenic_distillation_plant", HighPressureCryogenicDistillationPlant::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.HIGH_PRESSURE_CRYOGENIC_DISTILLATION)
            .appearanceBlock(GTBlocks.CASING_ALUMINIUM_FROSTPROOF)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, BACK, UP)
                    .aisle("CCC", "CCC", "CCC")
                    .aisle("CSC", "CFC", "CCC")
                    .aisle("XXX", "XFX", "XXX").setRepeatable(1, 16)
                    .aisle("DDD", "DDD", "DDD")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('C', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('F', Predicates.blocks(SuSyBlocks.SUSY_MULTIBLOCK_CASING_BLOCKS.get(BlockSuSyMultiblockCasing.CasingType.SIEVE_TRAY).get()))
                    .where('X', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS).setMaxLayerLimited(1))
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setMaxLayerLimited(1)))
                    .where('D', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()))
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_frost_proof"),
                    Supersymmetry.id("block/multiblock/distillation_towers/high_pressure_cryogenic_distilation_tower"))
            .register();

    public static final MultiblockMachineDefinition HighTemperatureDistillationTower = REGISTRATE.multiblock("hp_temperature_distillation_tower", HighTemperatureDistillationTower::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.HIGH_TEMPERATURE_DISTILLATION)
            .appearanceBlock(SuSyBlocks.SUSY_MULTIBLOCK_CASING_BLOCKS.get(BlockSuSyMultiblockCasing.CasingType.SILICON_CARBIDE_CASING))
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, BACK, UP)
                    .aisle("YSY", "YYY", "YYY")
                    .aisle("XXX", "X#X", "XXX").setRepeatable(1, 11)
                    .aisle("XXX", "XXX", "XXX")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('Y', Predicates.blocks(SuSyBlocks.SUSY_MULTIBLOCK_CASING_BLOCKS.get(BlockSuSyMultiblockCasing.CasingType.SILICON_CARBIDE_CASING).get())
                            .or(Predicates.ability(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)))
                    .where('X', Predicates.blocks(SuSyBlocks.SUSY_MULTIBLOCK_CASING_BLOCKS.get(BlockSuSyMultiblockCasing.CasingType.SILICON_CARBIDE_CASING).get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS).setMinLayerLimited(1).setMaxLayerLimited(1))
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(
                    Supersymmetry.id("block/multiblock_casing/silicon_carbide_casing"),
                    Supersymmetry.id("block/multiblock/distillation_towers/high_temperature_distilation_tower"))
            .register();

    public static final MultiblockMachineDefinition LargeWeaponsFactory = REGISTRATE.multiblock("large_weapons_factory", LargeWeaponsFactory::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.LARGE_WEAPONS_FACTORY_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FBF", "FFF")
                    .aisle("CBC", " A ")
                    .aisle("CBC", " A ")
                    .aisle("CBC", "EAE")
                    .aisle("CBC", "EAE")
                    .aisle("CBC", " A ")
                    .aisle("CBC", " A ")
                    .aisle("DDD", "DSD")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('C', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get())
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('D', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS)))
                    .where('E', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)))
                    .where('F', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.EXPORT_ITEMS)))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/large_weapons_factory"))
            .register();

    public static final MultiblockMachineDefinition LowPressureCryogenicDistillationPlant = REGISTRATE.multiblock("low_pressure_cryogenic_distillation_plant", LowPressureCryogenicDistillationPlant::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.LOW_PRESSURE_CRYOGENIC_DISTILLATION)
            .appearanceBlock(GTBlocks.CASING_ALUMINIUM_FROSTPROOF)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, BACK, UP)
                    .aisle("CCC", "CCC", "CCC")
                    .aisle("XXX", "XFX", "XXX")//.setRepeatable(1, 16) SuSy has no extra feature for extended ones, no reason for repeatable
                    .aisle("CSC", "E E", "CEC")
                    .aisle("DDD", "DDD", "DDD")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('C', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)
                                    .setMinGlobalLimited(1)
                                    .setMaxGlobalLimited(3))
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)
                                    .setExactLimit(1)))
                    .where('F', Predicates.blocks(SuSyBlocks.SUSY_MULTIBLOCK_CASING_BLOCKS.get(BlockSuSyMultiblockCasing.CasingType.STRUCTURAL_PACKING).get()))
                    .where('X', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS).setMaxLayerLimited(1))
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setMaxLayerLimited(1)))
                    .where('D', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()))
                    .where('E', Predicates.ability(PartAbility.PASSTHROUGH_HATCH)
                            .or(Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_frost_proof"),
                    Supersymmetry.id("block/multiblock/distillation_towers/low_pressure_cryogenic_distilation_tower"))
            .register();

    public static final MultiblockMachineDefinition MagneticRefrigerator = REGISTRATE.multiblock("magnetic_refrigerator", MagneticRefrigerator::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.COOLING_RECIPES)
            .appearanceBlock(GTBlocks.CASING_ALUMINIUM_FROSTPROOF)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "CCC", "CCC", "XXX")
                    .aisle("XXX", "C#C", "C#C", "XXX")
                    .aisle("XSX", "CCC", "CCC", "XXX")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('X', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()).setMinGlobalLimited(10)
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), true, true, true, true, true, true)
                                    .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1))))
                    .where('C', SuSyPredicates.coolingCoils())
                    .where('#', air())
                    .build())
            .shapeInfos(definition -> {
                ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                var builder = MultiblockShapeInfo.builder()
                        .aisle("XEM", "CCC", "CCC", "XXX")
                        .aisle("XXD", "C#C", "C#C", "XXX")
                        .aisle("ISO", "CCC", "CCC", "XXX")
                        .where('X', GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                        .where('S', SuSyMachines.MagneticRefrigerator, Direction.SOUTH)
                        .where('#', Blocks.AIR)
                        .where('E', GTMachines.ENERGY_INPUT_HATCH[GTValues.MV], Direction.NORTH)
                        .where('I', GTMachines.ITEM_IMPORT_BUS[GTValues.LV], Direction.SOUTH)
                        .where('O', GTMachines.ITEM_EXPORT_BUS[GTValues.LV], Direction.SOUTH)
                        .where('D', GTMachines.FLUID_EXPORT_HATCH[GTValues.LV], Direction.EAST)
                        .where('M', ConfigHolder.INSTANCE.machines.enableMaintenance ?
                                GTMachines.MAINTENANCE_HATCH.getBlock().defaultBlockState().setValue(
                                        GTMachines.MAINTENANCE_HATCH.get().getRotationState().property, Direction.NORTH) :
                                GTBlocks.CASING_INVAR_HEATPROOF.getDefaultState());
                SuSyBlocks.COOLING_COIL_BLOCKS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().getCoilTemperature()))
                        .forEach(
                                coil -> shapeInfo.add(builder.shallowCopy().where('C', coil.getValue().get()).build()));
                return shapeInfo;
            })
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_frost_proof"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition MagnetohydrodynamicGenerator = REGISTRATE.multiblock("magneto_hydrodynamic_generator", MagnetohydrodynamicGenerator::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.MAGNETOHYDRODYNAMIC_FUELS)
            .appearanceBlock(GTBlocks.CASING_TUNGSTENSTEEL_ROBUST)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" A ", " C ", " A ", "   ", "   ")
                    .aisle("   ", " B ", " B ", " B ", "   ")
                    .aisle(" B ", "AAA", "AAA", "AAA", " B ")
                    .aisle(" B ", "AAA", "EAE", "AAA", " B ")
                    .aisle(" B ", "AAA", "AAA", "AAA", " B ")
                    .aisle("   ", " B ", " B ", " B ", "   ")
                    .aisle(" A ", " S ", " A ", "   ", "   ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_TUNGSTENSTEEL_ROBUST.get())
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('B', Predicates.blocks(GTBlocks.FUSION_CASING.get()))
                    .where('C', Predicates.ability(PartAbility.OUTPUT_ENERGY))
                    .where('E', Predicates.ability(PartAbility.IMPORT_FLUIDS)
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS)))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition MultiStageFlashDistiller = REGISTRATE.multiblock("multi_stage_flash_distiller", MultiStageFlashDistiller::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.MULTI_STAGE_FLASH_DISTILLATION)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" EEEB", " BEEB", " BEEB", " EEEB", "  BBB")
                    .aisle(" AAA ", " B#B ", " B#BB", " AAA ", "  B  ")
                    .aisle("CAAAB", "CAAAB", "CAAAB", "CAAAC", "CCBCC")
                    .aisle(" DDD ", " DDD ", " DDD ", " DDD ", "  B  ")
                    .aisle(" DDD ", " D#D ", " D#D ", " DDD ", "  B  ")
                    .aisle("CDDDC", "CDDDC", "CDDDC", "CDDDC", "CCBCC")
                    .aisle(" AAA ", " BAB ", " BAB ", " AAA ", "  B  ")
                    .aisle(" AAA ", " B#B ", " B#B ", " AAA ", "  B  ")
                    .aisle("CAAAC", "CAAAC", "CAAAC", "CAAAC", "CCBCC")
                    .aisle(" DDD ", " DDD ", " DDD ", " DDD ", "  B  ")
                    .aisle(" DDD ", " D#D ", " D#D ", " DDD ", "  B  ")
                    .aisle("CDDDC", "CDDDC", "CDDDC", "CDDDC", "CCBCC")
                    .aisle(" AAAB", " BABB", " BABB", " AAAB", "  BBB")
                    .aisle(" AAAC", " B#BC", " B#BC", " AAAC", "  BCC")
                    .aisle(" FFF ", " FSF ", " FFF ", " FFF ", "  B  ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('C', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE, PartAbility.INPUT_ENERGY)))
                    .where('D', Predicates.blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE, PartAbility.INPUT_ENERGY)))
                    .where('E', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE, PartAbility.INPUT_ENERGY))
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS)))
                    .where('F', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE, PartAbility.INPUT_ENERGY))
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS)))
                    .where(' ', Predicates.any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition OreSorter = REGISTRATE.multiblock("ore_sorter", OreSorter::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.ORE_SORTER_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" C C ", " C C ", " C C ", " D D ")
                    .aisle("     ", "     ", "     ", " D D ")
                    .aisle("ABBBA", "ABBBA", "ABBBA", " D D ")
                    .aisle("ABBBA", "B###B", "ABBBA", " D D ")
                    .aisle("ABSBA", "ABBBA", "ABBBA", " D D ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .setMinGlobalLimited(16)
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY, PartAbility.IMPORT_ITEMS, PartAbility.EXPORT_ITEMS)
                                    .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1))))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get())
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS)))
                    .where('D', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Aluminium).get()))
                    .where(' ', Predicates.any())
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/ore_sorter"))
            .register();

    public static final MultiblockMachineDefinition PolymerizationTank = REGISTRATE.multiblock("polymerization_tank", PolymerizationTank::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.POLYMERIZATION_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("F F", "XXX", "XXX", "XXX", "XXX")
                    .aisle("   ", "XPX", "XPX", "XPX", "XPX")
                    .aisle("F F", "XSX", "XXX", "XXX", "XXX")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('F', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('X', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), true, true, true, true, true, true))
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/ore_sorter"))
            .register();

    public static final MultiblockMachineDefinition PressureSwingAdsorber = REGISTRATE.multiblock("pressure_swing_adsorber", PressureSwingAdsorber::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.PRESSURE_SWING_ADSORBER_RECIPES)
            .appearanceBlock(GTBlocks.CASING_ALUMINIUM_FROSTPROOF)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAA", "AAA", "AAA", "AAA")
                    .aisle("AAA", "ABA", "ABA", "AAA")
                    .aisle("AAA", "ASA", "AAA", "AAA")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()).setMinGlobalLimited(25)
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), true, true, true, true, true, true))
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_frost_proof"),
                    Supersymmetry.id("block/multiblock/pressure_swing_absorber"))
            .register();

    public static final MultiblockMachineDefinition Quencher = REGISTRATE.multiblock("quencher", Quencher::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.QUENCHER_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("GGBBF", "GG   ", "     ")
                    .aisle("GABC ", "GG D ", " CDD ")
                    .aisle("GGB F", "GG   ", "     ")
                    .aisle("  AAA", "  AAA", "     ")
                    .aisle("  ASA", "  AAA", "     ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STAINLESS_STEEL_GEARBOX.get()))
                    .where('D', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.StainlessSteel).get()))
                    .where('F', Predicates.ability(PartAbility.EXPORT_FLUIDS).setExactLimit(1)
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setExactLimit(1)))
                    .where('G', Predicates.blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)
                                    .or(Predicates.autoAbilities(definition.getRecipeTypes(), true, true, true, true, false, false))))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Supersymmetry.id("block/multiblock/quencher"))
            .register();

    public static final MultiblockMachineDefinition ReactionFurnace = REGISTRATE.multiblock("reaction_furnace", ReactionFurnace::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.REACTION_FURNACE_RECIPES)
            .appearanceBlock(GTBlocks.CASING_INVAR_HEATPROOF)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("     ", "     ", " P P ", " P P ", " P P ")
                    .aisle("F   F", "FBBBF", "XPXPX", "XXXXX", " P P ")
                    .aisle("     ", "XBBBX", "XP#PX", "XPMPX", " P P ")
                    .aisle("F   F", "FBBBF", "XXSXX", "XXXXX", "     ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('X', Predicates.blocks(GTBlocks.CASING_INVAR_HEATPROOF.get()).setMinGlobalLimited(13)
                            .or(autoAbilities(definition.getRecipeTypes(), true, true, true, true, true, true)
                                    .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1))))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('F', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Invar).get()))
                    .where('M', Predicates.ability(PartAbility.MUFFLER))
                    .where('B', Predicates.blocks(GTBlocks.FIREBOX_STEEL.get()))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition ReverberatoryFurnace = REGISTRATE.multiblock("reverberatory_furnace", ReverberatoryFurnace::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.REVERBERATORY_FURNACE)
            .appearanceBlock(GTBlocks.CASING_PRIMITIVE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "XXX", "XXX", "YYY")
                    .aisle("XXX", "X#X", "X#X", "Y#Y")
                    .aisle("XXX", "X#X", "X#X", "YYY")
                    .aisle("XXX", "X#X", "X#X", "YYY")
                    .aisle("XXX", "X#X", "X#X", "YYY")
                    .aisle("XXX", "X#X", "X#X", "YYY")
                    .aisle("XXX", "XSX", "XXX", "YYY")
                    .where('Y', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                    .where('X', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get())
                            .or(autoAbilities(definition.getRecipeTypes(), false, false, true, true, true, true)))
                    .where('#', air())
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition RotaryKiln = REGISTRATE.multiblock("rotary_kiln", RotaryKiln::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.ROTARY_KILN)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("A    A    A", "A    A    A", "L    A    R", "LCCCCMCCCCR", "L    A    R")
                    .aisle("A    A    A", "A    A    A", "LCCCCMCCCCR", "L#########R", "LCCCCMCCCCR")
                    .aisle("A    A    A", "A    A    A", "L    A    R", "LCCCCSCCCCR", "L    A    R")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.MATERIAL_BLOCKS.get(TagPrefix.frameGt, GTMaterials.Steel).get()))
                    .where('C', Predicates.blocks(GTBlocks.LIGHT_CONCRETE.get()))
                    .where('L', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), false, false, true, false, false, true))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY).setMinGlobalLimited(0))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)).setMaxGlobalLimited(1))
                    .where('R', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes(), false, false, false, true, true, false))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY).setMinGlobalLimited(0))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)).setMaxGlobalLimited(1))
                    .where('M', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.MAINTENANCE)).setMaxGlobalLimited(1))
                    .where(' ', Predicates.any())
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/rotary_kiln"))
            .register();

    public static final MultiblockMachineDefinition LargeSteamTurbine = REGISTRATE.multiblock("large_steam_turbine", LargeSteamTurbine::new)
            .rotationState(RotationState.ALL)
            .recipeType(SuSyRecipeTypes.LARGE_STEAM_TURBINE)
            .generator(true)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("GAAAAAAAO", "GAAAAAAAO", "G   A   O")
                    .aisle("GAAAAAAAO", "GDDDDCCCF", "GAAAAAAAO")
                    .aisle("GAAAAAAAO", "GSAAAAAAO", "G   A   O")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_TURBINE.get())
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)))
                    .where('O', Predicates.blocks(GTBlocks.CASING_STEEL_TURBINE.get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)))
//                    .where('C', coilOrientation()) //  @TODO
//                    .where('D', rotorOrientation()) // @TODO
                    .where('C', Predicates.blocks(SuSyBlocks.ALTERNATOR_COIL.get()))
                    .where('D', Predicates.blocks(SuSyBlocks.TURBINE_ROTOR.get()))
                    .where('F', Predicates.ability(PartAbility.OUTPUT_ENERGY))
                    .where('G', Predicates.blocks(GTBlocks.CASING_STEEL_TURBINE.get())
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/large_steam_turbine"))
            .register();

    public static final MultiblockMachineDefinition LargeGasTurbine = REGISTRATE.multiblock("large_gas_turbine", LargeSteamTurbine::new)
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.GAS_TURBINE_FUELS)
            .generator(true)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("GAAAAAAAO", "GAAAAAAAO", "G   A   O")
                    .aisle("GAAAAAAAO", "GDDDDCCCF", "GAAAAAAAO")
                    .aisle("GAAAAAAAO", "GSAAAAAAO", "G   A   O")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.blocks(GTBlocks.CASING_STEEL_TURBINE.get())
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)))
                    .where('O', Predicates.blocks(GTBlocks.CASING_STEEL_TURBINE.get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)))
//                    .where('C', coilOrientation()) //  @TODO
//                    .where('D', rotorOrientation()) // @TODO
                    .where('C', Predicates.blocks(SuSyBlocks.ALTERNATOR_COIL.get()))
                    .where('D', Predicates.blocks(SuSyBlocks.TURBINE_ROTOR.get()))
                    .where('F', Predicates.ability(PartAbility.OUTPUT_ENERGY))
                    .where('G', Predicates.blocks(GTBlocks.CASING_STEEL_TURBINE.get())
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/large_steam_turbine"))
            .register();

    public static final MultiblockMachineDefinition SingleColumnCryogenicDistillationPlant = REGISTRATE.multiblock("single_column_cryogenic_distillation_plant", SingleColumnCryogenicDistillationPlant::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.SINGLE_COLUMN_CRYOGENIC_DISTILLATION)
            .appearanceBlock(GTBlocks.CASING_ALUMINIUM_FROSTPROOF)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, BACK, UP)
                    .aisle("CCC", "CCC", "CCC")
                    .aisle("CSC", "CFC", "CCC")
                    .aisle("XXX", "XFX", "XXX")//.setRepeatable(1,16)
                    .aisle("CCC", "CCC", "CCC")
                    .aisle("CEC", "E E", "CEC")
                    .aisle("DDD", "DED", "DDD")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('C', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY)
                                    .setMinGlobalLimited(1)
                                    .setMaxGlobalLimited(3))
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)
                                    .setExactLimit(1)))
                    .where('F', Predicates.blocks(SuSyBlocks.SUSY_MULTIBLOCK_CASING_BLOCKS.get(BlockSuSyMultiblockCasing.CasingType.STRUCTURAL_PACKING).get()))
                    .where('X', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS).setMaxLayerLimited(1))
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setMaxLayerLimited(1)))
                    .where('D', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()))
                    .where('E', Predicates.ability(PartAbility.PASSTHROUGH_HATCH)
                            .or(Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_frost_proof"),
                    GTCEu.id("block/multiblock/assembly_line")) // @TODO: own texture
            .register();

    public static final MultiblockMachineDefinition OceanPumper = REGISTRATE.multiblock("ocean_pumper", OceanPumper::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.OCEAN_PUMPER)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FF***********FF", "FF***********FF", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************" ,"***************", "***************")
                    .aisle("FF***********FF", "FF***********FF", "*FF*********FF*", "*FF*********FF*", "***************", "*****FFFFF*****", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "*FF*********FF*", "*FF*********FF*", "**FFFFFFFFFFF**", "**FFFFFFFFFFF**", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "***************", "***************", "**FFF*****FFF**", "**FFFFFFFFFFF**", "***FF*****FF***", "***FF*****FF***", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "***************", "***************", "**FF*******FF**", "**FF*******FF**", "***FF*****FF***", "***FF*****FF***", "****FF***FF****", "****FF***FF****", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "***************", "***************", "**F*********F**", "*FFF**CCC**FFF*", "******CCC******", "******CCC******", "****FFCCCFF****", "****FFF*FFF****", "*****F*F*F*****", "*****FF*FF*****", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "*******C*******", "*******C*******", "**F***CCC***F**", "*FFF*CCCCC*FFF*", "*****CPPPC*****", "*****CPPPC*****", "*****CCPCC*****", "*****F*C*F*****", "*******C*******", "*****F*C*F*****", "*******C*******", "*******G*******", "*******G*******", "******GGG******")
                    .aisle("*******P*******", "*******P*******", "******CPC******", "******CPC******", "**F***CPC***F**", "*FFF*CCPCC*FFF*", "*****CPPPC*****", "*****CPPPC*****", "*****CPPPC*****", "******CPC******", "*****FCPCF*****", "******CPC******", "******CPC******", "******GPG******", "******GPG******", "******GPG******")
                    .aisle("***************", "***************", "*******C*******", "*******C*******", "**F***CCC***F**", "*FFF*CCCCC*FFF*", "*****CPPPC*****", "*****CPPPC*****", "*****CCPCC*****", "*****F*C*F*****", "*******C*******", "*****F*C*F*****", "*******C*******", "*******G*******", "*******G*******", "******GGG******")
                    .aisle("***************", "***************", "***************", "***************", "**F*********F**", "*FFF**CCC**FFF*", "******CCC******", "******CSC******", "****FFCCCFF****", "****FFF*FFF****", "*****F*F*F*****", "*****FF*FF*****", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "***************", "***************", "**FF*******FF**", "**FF*******FF**", "***FF*****FF***", "***FF*****FF***", "****FF***FF****", "****FF***FF****", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "***************", "***************", "**FFF*****FFF**", "**FFFFFFFFFFF**", "***FF*****FF***", "***FF*****FF***", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("***************", "***************", "*FF*********FF*", "*FF*********FF*", "**FFFFFFFFFFF**", "**FFFFFFFFFFF**", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("FF***********FF", "FF***********FF", "*FF*********FF*", "*FF*********FF*", "***************", "*****FFFFF*****", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************")
                    .aisle("FF***********FF", "FF***********FF", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************", "***************" ,"***************", "***************")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.MAINTENANCE)))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('F', Predicates.frames(GTMaterials.Steel))
                    .where('G', Predicates.blocks(GTBlocks.CASING_GRATE.get()))
                    .where('L', Predicates.blocks(GTBlocks.LIGHT_CONCRETE.get()))
                    .where('*', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/oceanic_drill"))
            .register();

    public static final MultiblockMachineDefinition VacuumDistillationTower = REGISTRATE.multiblock("vacuum_distillation_tower", VacuumDistillationTower::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.VACUUM_DISTILLATION_RECIPES)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, BACK, UP)
                    .aisle(" CSC  ", "CCCCCC", "CCCCCC", "CCCCCC", " CCC  ")
                    .aisle(" CGC  ", "C#F#CC", "IFFF#P", "C#F#CC", " CCC  ")
                    .aisle(" CCC  ", "C#F#CC", "CFFFCC", "C#F#CC", " CCC  ")
                    .aisle(" XXX  ", "X#F#D ", "XFFFD ", "X#F#D ", " XXX  ").setRepeatable(1,12)
                    .aisle(" DDD  ", "DDDDD ", "DDDDD ", "DDDDD ", " DDD  ")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('G', Predicates.blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('F', Predicates.frames(GTMaterials.Steel))
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.ability(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1))
                            .or(Predicates.ability(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)))
                    .where('I', Predicates.ability(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1))
                    .where('D', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where('X', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS_1X, PartAbility.EXPORT_FLUIDS_4X)
                                    .setMinLayerLimited(1).setMaxLayerLimited(1))
                            .or(Predicates.ability(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/distillation_towers/vacuum_distillation_tower"))
            .register();

    public static final MultiblockMachineDefinition Dumper = REGISTRATE.multiblock("dumper", Dumper::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.DUMPER)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("A  A", "BBBB", "A  A")
                    .aisle("BBBB", "C##A", "BBBB")
                    .aisle("A  A", "BSBB", "A  A")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('A', Predicates.frames(GTMaterials.Steel))
                    .where('B', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where('C', Predicates.ability(PartAbility.IMPORT_FLUIDS).setExactLimit(1))
                    .where(' ', Predicates.any())
                    .where('#', Predicates.air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Supersymmetry.id("block/multiblock/dumper"))
            .register();

    public static final MultiblockMachineDefinition FlareStack = REGISTRATE.multiblock("flarestack", FlareStack::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(SuSyRecipeTypes.FLARESTACK)
            .appearanceBlock(GTBlocks.FIREBOX_STEEL)
            .pattern(definition -> FactoryBlockPattern.start(RIGHT, BACK, UP)
                    .aisle("S")
                    .aisle("P").setRepeatable(3,7)
                    .aisle("F")
                    .where('S', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('P', SuSyPredicates.flareStackPredicate()
                            .or(Predicates.ability(PartAbility.IMPORT_FLUIDS).setExactLimit(1)))
                    .where('F', Predicates.ability(PartAbility.MUFFLER).setExactLimit(1))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/firebox/machine_casing_firebox_steel"),
                    Supersymmetry.id("block/multiblock/flare_stack"))
            .register();

    // Helpers //

    public static MachineDefinition[] registerSimpleMachines(String name,
                                                             GTRecipeType recipeType,
                                                             Int2LongFunction tankScalingFunction,
                                                             SimpleTieredMachine tieredMachine,
                                                             boolean hasPollutionDebuff,
                                                             int... tiers) {
        return registerTieredMachines(name,
                (holder, tier) -> tieredMachine, (tier, builder) -> {
                    if (hasPollutionDebuff) {
                        builder.recipeModifiers(GTRecipeModifiers.ENVIRONMENT_REQUIREMENT
                                                .apply(GTMedicalConditions.CARBON_MONOXIDE_POISONING, 100 * tier),
                                        GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
                                .tooltips(defaultEnvironmentRequirement());
                    } else {
                        builder.recipeModifier(
                                GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK));
                    }
                    return builder
                            .langValue("%s %s %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(Supersymmetry.id(name), recipeType))
                            .rotationState(RotationState.NON_Y_AXIS)
                            .recipeType(recipeType)
                            .workableTieredHullRenderer(Supersymmetry.id("block/machines/" + name))
                            .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, recipeType,
                                    tankScalingFunction.apply(tier), true))
                            .compassNode(name)
                            .register();
                },
                tiers);
    }

    public static MachineDefinition[] registerSimpleMachines(String name,
                                                             GTRecipeType recipeType,
                                                             Int2LongFunction tankScalingFunction,
                                                             boolean hasPollutionDebuff,
                                                             int... tiers) {
        return registerTieredMachines(name,
                (holder, tier) -> new SimpleTieredMachine(holder, tier, tankScalingFunction), (tier, builder) -> {
                    if (hasPollutionDebuff) {
                        builder.recipeModifiers(GTRecipeModifiers.ENVIRONMENT_REQUIREMENT
                                                .apply(GTMedicalConditions.CARBON_MONOXIDE_POISONING, 100 * tier),
                                        GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
                                .tooltips(defaultEnvironmentRequirement());
                    } else {
                        builder.recipeModifier(
                                GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK));
                    }
                    return builder
                            .langValue("%s %s %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(Supersymmetry.id(name), recipeType))
                            .rotationState(RotationState.NON_Y_AXIS)
                            .recipeType(recipeType)
                            .workableTieredHullRenderer(Supersymmetry.id("block/machines/" + name))
                            .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, recipeType,
                                    tankScalingFunction.apply(tier), true))
                            .compassNode(name)
                            .register();
                },
                tiers);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType,
                                                             Int2LongFunction tankScalingFunction,
                                                             boolean hasPollutionDebuff) {
        return registerSimpleMachines(name, recipeType, tankScalingFunction, hasPollutionDebuff, ELECTRIC_TIERS);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType,
                                                             Int2LongFunction tankScalingFunction) {
        return registerSimpleMachines(name, recipeType, tankScalingFunction, false);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType) {
        return registerSimpleMachines(name, recipeType, defaultTankSizeFunction);
    }

    public static MachineDefinition[] registerTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = REGISTRATE
                    .machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static Pair<MachineDefinition, MachineDefinition> registerSimpleSteamMachines(String name,
                                                                                         GTRecipeType recipeType) {
        return registerSteamMachines("steam_" + name, SimpleSteamMachine::new, (pressure, builder) -> builder
                .rotationState(RotationState.ALL)
                .recipeType(recipeType)
                .recipeModifier(SimpleSteamMachine::recipeModifier)
                .renderer(() -> new WorkableSteamMachineRenderer(pressure, Supersymmetry.id("block/machines/" + name)))
                .register());
    }


    public static void init() {
    }
}
