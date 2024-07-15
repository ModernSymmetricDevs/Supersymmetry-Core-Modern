package belletti.supersymmetry.common.data.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.data.materials.properties.FiberProperty;
import belletti.supersymmetry.common.data.materials.properties.SuSyPropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;

import static belletti.supersymmetry.common.data.materials.SuSyMaterialFlags.GENERATE_CATALYST_BED;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GroovyUnknownCompositionMaterials {
    public static void register() {

        Supersymmetry.LOGGER.info("Registering Unknown Composition Materials!");

        EarthGreenhouseGas = new Material.Builder(Supersymmetry.id("greenhouse_gases"))
                .gas()
                .color(0x95cade)
                .buildAndRegister();

        Asphalt = new Material.Builder(Supersymmetry.id("asphalt"))
                .dust()
                .color(0x000000)
                .buildAndRegister();

        BlackAsh = new Material.Builder(Supersymmetry.id("black_ash"))
                .dust()
                .color(0x000000)
                .colorAverage()
                .buildAndRegister();

        MolecularSieve = new Material.Builder(Supersymmetry.id("molecular_sieve"))
                .dust()
                .iconSet(SHINY)
                .color(0x737373)
                .colorAverage()
                .buildAndRegister();

        WetMolecularSieve = new Material.Builder(Supersymmetry.id("wet_molecular_sieve"))
                .dust()
                .iconSet(SHINY)
                .color(0x5c5c5c)
                .colorAverage()
                .buildAndRegister();

        RawMolecularSieve = new Material.Builder(Supersymmetry.id("raw_molecular_sieve"))
                .liquid()
                .color(0x8c94a8)
                .buildAndRegister();

        FlueGas = new Material.Builder(Supersymmetry.id("flue_gas"))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x484a48)
                .buildAndRegister();

        ExhaustSteam = new Material.Builder(Supersymmetry.id("exhaust_steam"))
                .gas(new FluidBuilder().temperature(400))
                .color(0xc4c4c4)
                .buildAndRegister();

        SmokeBombMix = new Material.Builder(Supersymmetry.id("smoke_bomb_mix"))
                .gas()
                .color(0x515443)
                .buildAndRegister();

        SugaryWater = new Material.Builder(Supersymmetry.id("sugary_water"))
                .liquid()
                .color(0x8fbf9b)
                .buildAndRegister();

        ClarifiedSugaryWater = new Material.Builder(Supersymmetry.id("clarified_sugary_water"))
                .liquid()
                .color(0xa7d6b3)
                .buildAndRegister();

        Brine = new Material.Builder(Supersymmetry.id("brine"))
                .liquid()
                .color(0xd1d08e)
                .buildAndRegister();

        ImpureSodiumAluminateSolution = new Material.Builder(Supersymmetry.id("impure_sodium_aluminate_solution"))
                .liquid()
                .color(0x5b80ba)
                .buildAndRegister();

        RedMud = new Material.Builder(Supersymmetry.id("red_mud"))
                .liquid()
                .color(0x913f2d)
                .buildAndRegister();

        ImpureSodaAshSolution = new Material.Builder(Supersymmetry.id("impure_soda_ash_solution"))
                .liquid()
                .color(0x91919b)
                .buildAndRegister();

        ImpureSodiumHydroxideSolution = new Material.Builder(Supersymmetry.id("impure_sodium_hydroxide_solution"))
                .liquid()
                .color(0x3a4991)
                .buildAndRegister();

        ConcentratedRedMud = new Material.Builder(Supersymmetry.id("concentrated_red_mud"))
                .liquid()
                .color(0x824133)
                .buildAndRegister();

        AmmoniaReactionMix = new Material.Builder(Supersymmetry.id("ammonia_reaction_mix"))
                .gas(new FluidBuilder().temperature(400))
                .color(0x38478a)
                .buildAndRegister();

        AmmoniaRichGas = new Material.Builder(Supersymmetry.id("ammonia_rich_gas"))
                .gas(new FluidBuilder().temperature(400))
                .color(0x345691)
                .buildAndRegister();

        PalladiumContainingSolution = new Material.Builder(Supersymmetry.id("palladium_containing_solution"))
                .liquid()
                .color(0x808080)
                .buildAndRegister();

        Mash = new Material.Builder(Supersymmetry.id("mash"))
                .liquid()
                .color(0x9e8660)
                .buildAndRegister();

        WeedKiller = new Material.Builder(Supersymmetry.id("weed_killer"))
                .liquid()
                .color(0xade677)
                .buildAndRegister();

        Pesticide = new Material.Builder(Supersymmetry.id("pesticide"))
                .liquid()
                .color(0xc0c77d)
                .buildAndRegister();

        GrainSolution = new Material.Builder(Supersymmetry.id("grain_solution"))
                .liquid()
                .color(0xc2cc9d)
                .buildAndRegister();

        YeastSolution = new Material.Builder(Supersymmetry.id("yeast_solution"))
                .liquid()
                .color(0xe6e3aa)
                .buildAndRegister();

        ImpureEthanol = new Material.Builder(Supersymmetry.id("impure_ethanol"))
                .liquid()
                .color(0xbf9c77)
                .buildAndRegister();

        BorateLiquor = new Material.Builder(Supersymmetry.id("borate_liquor"))
                .liquid()
                .color(0xacbbac)
                .buildAndRegister();

        ImpureAcetaldehyde = new Material.Builder(Supersymmetry.id("impure_acetaldehyde"))
                .liquid()
                .color(0x6e6e6e)
                .buildAndRegister();

        CativaCatalystPreparation = new Material.Builder(Supersymmetry.id("cativa_catalyst_preparation"))
                .liquid()
                .color(0x9c8275)
                .buildAndRegister();

        CativaCatalystSolution = new Material.Builder(Supersymmetry.id("cativa_catalyst_solution"))
                .liquid()
                .color(0x75665e)
                .buildAndRegister();

        AcidicCumene = new Material.Builder(Supersymmetry.id("acidic_cumene"))
                .liquid()
                .color(0x571a0b)
                .buildAndRegister();

        RearrangedCumene = new Material.Builder(Supersymmetry.id("rearranged_cumene"))
                .liquid()
                .color(0x4f2f27)
                .buildAndRegister();

        AlkylatedButane = new Material.Builder(Supersymmetry.id("alkylated_butane"))
                .liquid()
                .color(0x6e4c2c)
                .buildAndRegister();

        ImpureKaptonK = new Material.Builder(Supersymmetry.id("impure_kapton_k"))
                .liquid()
                .color(0xe0b53f)
                .buildAndRegister();

        ImpureKaptonE = new Material.Builder(Supersymmetry.id("impure_kapton_e"))
                .liquid()
                .color(0xcad96f)
                .buildAndRegister();

        KaptonEPreparation = new Material.Builder(Supersymmetry.id("kapton_e_preparation"))
                .liquid()
                .color(0x899444)
                .buildAndRegister();

        ImpureDiiodobenzene = new Material.Builder(Supersymmetry.id("impure_diiodobenzene"))
                .liquid()
                .color(0x736c63)
                .buildAndRegister();

        ImpureEthyleneOxide = new Material.Builder(Supersymmetry.id("impure_ethylene_oxide"))
                .gas()
                .color(0x52755c)
                .buildAndRegister();

        AmocoProcessCatalyst = new Material.Builder(Supersymmetry.id("amoco_process_catalyst"))
                .dust()
                .iconSet(SHINY)
                .color(0xdea68c)
                .buildAndRegister();

        GraniteTailings = new Material.Builder(Supersymmetry.id("granite_tailings"))
                .dust()
                .color(0x302323)
                .buildAndRegister();

        LimestoneTailings = new Material.Builder(Supersymmetry.id("limestone_tailings"))
                .dust()
                .color(0x68695d)
                .buildAndRegister();

        PegmatiteTailings = new Material.Builder(Supersymmetry.id("pegmatite_tailings"))
                .dust()
                .color(0x1f1c1c)
                .buildAndRegister();

        UltramaficTailings = new Material.Builder(Supersymmetry.id("ultramafic_tailings"))
                .dust()
                .color(0x141414)
                .buildAndRegister();

        Corundum = new Material.Builder(Supersymmetry.id("corundum"))
                .dust()
                .iconSet(SHINY)
                .color(0x7a4261)
                .buildAndRegister();

        Tourmaline = new Material.Builder(Supersymmetry.id("tourmaline"))
                .dust().gem()
                .iconSet(SHINY)
                .color(0x8c613f)
                .buildAndRegister();

        NonMarineEvaporite = new Material.Builder(Supersymmetry.id("non_marine_evaporite"))
                .dust()
                .color(0x78756d)
                .buildAndRegister();

        HalideEvaporite = new Material.Builder(Supersymmetry.id("halide_evaporite"))
                .dust()
                .color(0x99867c)
                .buildAndRegister();

        CarbonateEvaporite = new Material.Builder(Supersymmetry.id("carbonate_evaporite"))
                .dust()
                .color(0xe3e3e3)
                .buildAndRegister();

        SulfateEvaporite = new Material.Builder(Supersymmetry.id("sulfate_evaporite"))
                .dust()
                .color(0xc7c0b1)
                .buildAndRegister();

        Vinegar = new Material.Builder(Supersymmetry.id("vinegar"))
                .liquid()
                .color(0xc3c4b3)
                .buildAndRegister();

        RawCellulose = new Material.Builder(Supersymmetry.id("raw_cellulose"))
                .dust()
                .color(0x302b1a)
                .buildAndRegister();

        WhiteLiquor = new Material.Builder(Supersymmetry.id("white_liquor"))
                .liquid()
                .color(0xd9d3c1)
                .buildAndRegister();

        BlackLiquor = new Material.Builder(Supersymmetry.id("black_liquor"))
                .liquid()
                .color(0x2e2a1f)
                .buildAndRegister();

        ConcentratedBlackLiquor = new Material.Builder(Supersymmetry.id("concentrated_black_liquor"))
                .liquid()
                .color(0x1f1d18)
                .buildAndRegister();

        GreenLiquor = new Material.Builder(Supersymmetry.id("green_liquor"))
                .liquid()
                .color(0x2b4536)
                .buildAndRegister();

        AcidicCelluloseSolution = new Material.Builder(Supersymmetry.id("acidic_cellulose_solution"))
                .liquid()
                .color(0xb7bd60)
                .buildAndRegister();

        Wastewater = new Material.Builder(Supersymmetry.id("wastewater"))
                .liquid()
                .color(0x2d402f)
                .buildAndRegister();

        HeatedWastewater = new Material.Builder(Supersymmetry.id("heated_wastewater"))
                .liquid(new FluidBuilder().temperature(340))
                .color(0x435e46)
                .buildAndRegister();

        FlocculatedWastewater = new Material.Builder(Supersymmetry.id("flocculated_wastewater"))
                .liquid()
                .color(0x435e46)
                .buildAndRegister();

        FilteredWastewater = new Material.Builder(Supersymmetry.id("filtered_wastewater"))
                .liquid()
                .color(0x457568)
                .buildAndRegister();

        WastewaterSludge = new Material.Builder(Supersymmetry.id("wastewater_sludge"))
                .liquid()
                .color(0x2b1e1e)
                .buildAndRegister();

        CarburizedStainlessSteel = new Material.Builder(Supersymmetry.id("carburized_stainless_steel"))
                .dust().liquid(new FluidBuilder().temperature(1500))
                .color(0x6b6552)
                .buildAndRegister();

        UnscrubbedWoodGas = new Material.Builder(Supersymmetry.id("unscrubbed_wood_gas"))
                .gas()
                .color(0x85806f)
                .buildAndRegister();

        LightOil = new Material.Builder(Supersymmetry.id("light_oil"))
                .liquid()
                .color(0x5e5e4d)
                .buildAndRegister();

        NaphthaleneOil = new Material.Builder(Supersymmetry.id("naphthalene_oil"))
                .liquid()
                .color(0x2e2926)
                .buildAndRegister();

        AnthraceneOil = new Material.Builder(Supersymmetry.id("anthracene_oil"))
                .liquid()
                .color(0x211f1e)
                .buildAndRegister();

        AlkalineNaphthaleneOil = new Material.Builder(Supersymmetry.id("alkaline_naphthalene_oil"))
                .liquid()
                .color(0x403833)
                .buildAndRegister();

        PurifiedNaphthaleneOil = new Material.Builder(Supersymmetry.id("purified_naphthalene_oil"))
                .liquid()
                .color(0x595542)
                .buildAndRegister();

        AcidicLightOil = new Material.Builder(Supersymmetry.id("acidic_light_oil"))
                .liquid()
                .color(0x87816c)
                .buildAndRegister();

        CrudePyridiniumSulfate = new Material.Builder(Supersymmetry.id("crude_pyridinium_sulfate"))
                .liquid()
                .color(0x48523b)
                .buildAndRegister();

        ImpurePyridine = new Material.Builder(Supersymmetry.id("impure_pyridine"))
                .liquid()
                .color(0x233326)
                .buildAndRegister();

        AcidicAnthraceneOil = new Material.Builder(Supersymmetry.id("acidic_anthracene_oil"))
                .liquid()
                .color(0x87816c)
                .buildAndRegister();

        AnthraceneExtract = new Material.Builder(Supersymmetry.id("anthracene_extract"))
                .liquid()
                .color(0x211c1c)
                .buildAndRegister();

        CrudeQuinoliniumSulfate = new Material.Builder(Supersymmetry.id("crude_quinolinium_sulfate"))
                .liquid()
                .color(0x1b1c0a)
                .buildAndRegister();

        ImpureQuinoline = new Material.Builder(Supersymmetry.id("impure_quinoline"))
                .liquid()
                .color(0x222418)
                .buildAndRegister();

        ConcentratedBrine = new Material.Builder(Supersymmetry.id("concentrated_brine"))
                .liquid()
                .color(0xa6a444)
                .buildAndRegister();

        BoronFreeBrine = new Material.Builder(Supersymmetry.id("boron_free_brine"))
                .liquid()
                .color(0xa68a44)
                .buildAndRegister();

        LithiumFreeBrine = new Material.Builder(Supersymmetry.id("lithium_free_brine"))
                .liquid()
                .color(0xa17a4c)
                .buildAndRegister();

        ChlorinatedBrine = new Material.Builder(Supersymmetry.id("chlorinated_brine"))
                .liquid()
                .color(0xa3b560)
                .buildAndRegister();

        ImpureBromine = new Material.Builder(Supersymmetry.id("impure_bromine"))
                .gas(new FluidBuilder().temperature(373))
                .color(0x572d2b)
                .buildAndRegister();

        ChilledLava = new Material.Builder(Supersymmetry.id("chilled_lava"))
                .liquid(new FluidBuilder().temperature(400))
                .color(0x4d2d25)
                .buildAndRegister();

        ChilledFlueGas = new Material.Builder(Supersymmetry.id("chilled_flue_gas"))
                .gas(new FluidBuilder().temperature(400))
                .color(0x171717)
                .buildAndRegister();

        WoodAsh = new Material.Builder(Supersymmetry.id("wood_ash"))
                .dust()
                .color(0x242221)
                .buildAndRegister();

        VeryConcentratedBrine = new Material.Builder(Supersymmetry.id("very_concentrated_brine"))
                .liquid()
                .color(0xb5b226)
                .buildAndRegister();

        LangbeiniteLeach = new Material.Builder(Supersymmetry.id("langbeinite_leach"))
                .liquid()
                .color(0x9c9a87)
                .buildAndRegister();

        PolyhaliteLeach = new Material.Builder(Supersymmetry.id("polyhalite_leach"))
                .liquid()
                .color(0xb3a094)
                .buildAndRegister();

        TinDross = new Material.Builder(Supersymmetry.id("tin_dross"))
                .dust().liquid(new FluidBuilder().temperature(600))
                .color(0x2a2e2e)
                .buildAndRegister();

        DecopperizedTin = new Material.Builder(Supersymmetry.id("decopperized_tin"))
                .dust().liquid(new FluidBuilder().temperature(600))
                .color(0xb5b7c9)
                .buildAndRegister();

        KainiteLeach = new Material.Builder(Supersymmetry.id("kainite_leach"))
                .liquid()
                .color(0xadb07f)
                .buildAndRegister();

        Zeolite13X = new Material.Builder(Supersymmetry.id("zeolite_13"))
                .dust()
                .iconSet(SHINY)
                .color(0xe4e8bc)
                .buildAndRegister();

        Zeolite13XSolution = new Material.Builder(Supersymmetry.id("zeolite_13_solution"))
                .liquid()
                .color(0xe4e8bc)
                .buildAndRegister();

        LTSCatalyst = new Material.Builder(Supersymmetry.id("lts_catalyst"))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x756857)
                .buildAndRegister();

        HTSCatalyst = new Material.Builder(Supersymmetry.id("hts_catalyst"))
                .dust()
                .color(0x5e4f4f)
                .buildAndRegister();

        SpentBismuthCatalyst = new Material.Builder(Supersymmetry.id("spent_bismuth_catalyst"))
                .dust()
                .color(0x31403f)
                .buildAndRegister();

        AlkalineSodiumOleateSolution = new Material.Builder(Supersymmetry.id("alkaline_sodium_oleate_solution"))
                .liquid()
                .color(0xa6b584)
                .buildAndRegister();

        FattyAcidSolution = new Material.Builder(Supersymmetry.id("fatty_acid_solution"))
                .liquid()
                .color(0xa1ad5c)
                .buildAndRegister();

        OleicAcidSolution = new Material.Builder(Supersymmetry.id("oleic_acid_solution"))
                .liquid()
                .color(0x8dbf67)
                .buildAndRegister();

        AluminiumSilicateLeach = new Material.Builder(Supersymmetry.id("aluminium_silicate_leach"))
                .liquid()
                .color(0x587682)
                .buildAndRegister();

        AlkaliAlumMix = new Material.Builder(Supersymmetry.id("alkali_alum_mix"))
                .iconSet(SHINY)
                .dust()
                .color(0xe34949)
                .buildAndRegister();

        AmblygoniteLeach = new Material.Builder(Supersymmetry.id("amblygonite_leach"))
                .liquid()
                .color(0xbaced6)
                .buildAndRegister();

        // FREE ID: 4102

        LepidoliteLeach = new Material.Builder(Supersymmetry.id("lepidolite_leach"))
                .liquid()
                .color(0x805066)
                .buildAndRegister();

        NeutralizedLepidoliteLeach = new Material.Builder(Supersymmetry.id("neutralized_lepidolite_leach"))
                .liquid()
                .color(0x675d85)
                .buildAndRegister();

        AluminiumFreeLepidoliteLeach = new Material.Builder(Supersymmetry.id("aluminium_free_lepidolite_leach"))
                .liquid()
                .color(0x557365)
                .buildAndRegister();

        GoldLeachSolution = new Material.Builder(Supersymmetry.id("gold_leach_solution"))
                .liquid()
                .color(0x9c8a46)
                .buildAndRegister();

        PhosphatePulp = new Material.Builder(Supersymmetry.id("phosphate_pulp"))
                .dust()
                .color(0x8c7e2a)
                .iconSet(SAND)
                .buildAndRegister();

        FilteredPhosphatePulp = new Material.Builder(Supersymmetry.id("filtered_phosphate_pulp"))
                .dust()
                .color(0x8c7e2a)
                .iconSet(SHINY)
                .buildAndRegister();

        PhosphateConcentrate = new Material.Builder(Supersymmetry.id("phosphate_concentrate"))
                .dust()
                .color(0xd1b615)
                .iconSet(SHINY)
                .buildAndRegister();

        PropanalMixture = new Material.Builder(Supersymmetry.id("propanal_mixture"))
                .liquid()
                .color(0x84910f)
                .buildAndRegister();

        ImpureAmmoniumFluoroberyllateSolution = new Material.Builder(Supersymmetry.id("impure_ammonium_fluoroberyllate_solution"))
                .liquid()
                .color(0x1b8541)
                .buildAndRegister()
                .setFormula("(?)(NH4)2(BeF4)(H2O)3", true);


        ImpureBerylliumSulfateSolution = new Material.Builder(Supersymmetry.id("impure_beryllium_sulfate_solution"))
                .liquid()
                .color(0x608726)
                .buildAndRegister();

        ImpureLithiumSulfateSolution = new Material.Builder(Supersymmetry.id("impure_lithium_sulfate_solution"))
                .liquid()
                .color(0xf0bc89)
                .buildAndRegister();

        GalenaByproductsSlurry = new Material.Builder(Supersymmetry.id("galena_byproducts_slurry"))
                .liquid()
                .color(0x592880)
                .buildAndRegister();

        SinteredLeadConcentrate = new Material.Builder(Supersymmetry.id("sintered_lead_concentrate"))
                .dust()
                .color(0x3a1954)
                .iconSet(SAND)
                .buildAndRegister();

        ZincOxideFume = new Material.Builder(Supersymmetry.id("zinc_oxide_fume"))
                .dust()
                .color(0x757061)
                .iconSet(DULL)
                .buildAndRegister();

        BlackMetal = new Material.Builder(Supersymmetry.id("black_metal"))
                .dust()
                .color(0x3d3440)
                .buildAndRegister();

        AntimonyArsenicFlueDust = new Material.Builder(Supersymmetry.id("antimony_arsenic_flue_dust"))
                .dust()
                .color(0x707063)
                .iconSet(DULL)
                .buildAndRegister();

        BurnedBlackMetal = new Material.Builder(Supersymmetry.id("burned_black_metal"))
                .dust()
                .color(0x3d3440)
                .iconSet(DULL)
                .buildAndRegister();

        LithargeSlag = new Material.Builder(Supersymmetry.id("litharge_slag"))
                .dust()
                .color(0xb5443c)
                .iconSet(DULL)
                .buildAndRegister();

        HarrisSlag = new Material.Builder(Supersymmetry.id("harris_slag"))
                .dust()
                .color(0xabb074)
                .iconSet(DULL)
                .buildAndRegister();

        SodiumArsenateStannateSolution = new Material.Builder(Supersymmetry.id("sodium_arsenate_stannate_solution"))
                .liquid()
                .color(0x5c3a23)
                .buildAndRegister();

        SodiumArsenateStannateMixture = new Material.Builder(Supersymmetry.id("sodium_arsenate_stannate_mixture"))
                .dust()
                .color(0x784c2f)
                .buildAndRegister();

        ImpureEthyleneGlycol = new Material.Builder(Supersymmetry.id("impure_ethylene_glycol"))
                .liquid()
                .color(0xc8c8e0)
                .buildAndRegister();

        ImpureSaturatedAmmoniacalMethanol = new Material.Builder(Supersymmetry.id("impure_saturated_ammoniacal_methanol"))
                .liquid()
                .color(0xad8653)
                .buildAndRegister();

        CarnalliteLeach = new Material.Builder(Supersymmetry.id("carnallite_leach"))
                .liquid()
                .color(0xc1c499)
                .buildAndRegister();

        HaliteLeach = new Material.Builder(Supersymmetry.id("halite_leach"))
                .liquid()
                .color(0x9bbdbc)
                .buildAndRegister();

        EthylenediaminePyrocatechol = new Material.Builder(Supersymmetry.id("ethylenediamine_pyrocatechol"))
                .liquid()
                .color(0x42392f)
                .buildAndRegister();

        CeramicThickFilmPaste = new Material.Builder(Supersymmetry.id("ceramic_thick_film_paste"))
                .liquid()
                .color(0x000000)
                .buildAndRegister();

        BoraxElectrolyte = new Material.Builder(Supersymmetry.id("borax_electrolyte"))
                .liquid()
                .color(0x85806b)
                .buildAndRegister();

        FerroelectricCeramicBinding = new Material.Builder(Supersymmetry.id("ferroelectric_ceramic_binding"))
                .liquid()
                .color(0xede772)
                .buildAndRegister();

        DisproportionatedTrichlorosilane = new Material.Builder(Supersymmetry.id("disproportionated_trichlorosilane"))
                .liquid()
                .color(0x849169)
                .buildAndRegister();

        DisproportionatedDichlorosilane = new Material.Builder(Supersymmetry.id("disproportionated_dichlorosilane"))
                .liquid()
                .color(0xa1ad86)
                .buildAndRegister();

        DisproportionatedChlorosilane = new Material.Builder(Supersymmetry.id("disproportionated_chlorosilane"))
                .liquid()
                .color(0xb5bf9b)
                .buildAndRegister();

        ChlorofluoromethaneMix = new Material.Builder(Supersymmetry.id("chlorofluoromethane_mix"))
                .liquid()
                .color(0xb03f5d)
                .buildAndRegister();

        CoconutOil = new Material.Builder(Supersymmetry.id("coconut_oil"))
                .liquid()
                .color(0xd6d39a)
                .buildAndRegister();

        CoconutAcid = new Material.Builder(Supersymmetry.id("coconut_acid"))
                .liquid()
                .color(0xbdb280)
                .buildAndRegister();

        TwoEthylhexylPhosphoricAcidMix = new Material.Builder(Supersymmetry.id("two_ethylhexyl_phosphoric_acid_mix"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xd1bb75)
                .buildAndRegister();

        RareEarthCatalystYNd = new Material.Builder(Supersymmetry.id("rare_earth_catalyst_y_nd"))
                .dust()
                .color(0x2e2a2a)
                .buildAndRegister();

        DilutedPrimaryAmineN = new Material.Builder(Supersymmetry.id("diluted_primary_amine_n"))
                .liquid()
                .color(0x704a9e)
                .buildAndRegister();

        CrosslinkedPolystyrene = new Material.Builder(Supersymmetry.id("crosslinked_polystyrene"))
                .ingot().liquid(new FluidBuilder().temperature(513))
                .flags(GENERATE_ROUND)
                .color(0xa7a9d6)
                .buildAndRegister();

        EthyleneGlycolMix = new Material.Builder(Supersymmetry.id("ethylene_glycol_mix"))
                .liquid()
                .color(0x2eafc9)
                .buildAndRegister();

        PalladiumDopedCrosslinkedPolystyrene = new Material.Builder(Supersymmetry.id("palladium_doped_crosslinked_polystyrene"))
                .ingot().liquid(new FluidBuilder().temperature(513))
                .flags(GENERATE_ROUND)
                .color(0xe0e6bc)
                .buildAndRegister();

        AlfolTrialkylaluminiumMixture = new Material.Builder(Supersymmetry.id("alfol_trialkylaluminium_mixture"))
                .liquid()
                .color(0x6b777d)
                .buildAndRegister()
                .setFormula("AlR3", true);


        AluminiumAlkoxideMixture = new Material.Builder(Supersymmetry.id("aluminium_alkoxide_mixture"))
                .dust()
                .color(0x657780)
                .buildAndRegister()
                .setFormula("Al(OR)3", true);


        ZieglerAlfolMixture = new Material.Builder(Supersymmetry.id("ziegler_alfol_mixture"))
                .liquid()
                .color(0xc47631)
                .buildAndRegister();

        AluminiumAlkoxideSolution = new Material.Builder(Supersymmetry.id("aluminium_alkoxide_solution"))
                .liquid()
                .color(0x657780)
                .buildAndRegister()
                .setFormula("[(C2H5)2O]Al(OR)3", true);


        CapsaicinSolution = new Material.Builder(Supersymmetry.id("capsaicin_solution"))
                .liquid()
                .color(0xd43b2a)
                .buildAndRegister();

        TearGas = new Material.Builder(Supersymmetry.id("tear_gas"))
                .liquid()
                .color(0xd1ba5c)
                .buildAndRegister();

        HydratedPropene = new Material.Builder(Supersymmetry.id("hydrated_propene"))
                .liquid()
                .color(0xc9997d)
                .buildAndRegister();

        EthylamineMix = new Material.Builder(Supersymmetry.id("ethylamine_mix"))
                .liquid()
                .color(0xdbaf48)
                .buildAndRegister();

        GermaniumRichOxide = new Material.Builder(Supersymmetry.id("germanium_rich_oxide"))
                .dust()
                .color(0x7b9a9e)
                .buildAndRegister();

        UnprocessedSphaleriteSlurry = new Material.Builder(Supersymmetry.id("unprocessed_sphalerite_slurry"))
                .liquid()
                .color(0xc7c991)
                .buildAndRegister();

        CocoAmine = new Material.Builder(Supersymmetry.id("coco_amine"))
                .liquid()
                .color(0xb4d487)
                .buildAndRegister();

        CocoAmineAcetate = new Material.Builder(Supersymmetry.id("coco_amine_acetate"))
                .liquid()
                .color(0xada67b)
                .buildAndRegister();

        ZincFlue = new Material.Builder(Supersymmetry.id("zinc_flue"))
                .dust()
                .color(0x26222e)
                .buildAndRegister();

        CrudeZinc = new Material.Builder(Supersymmetry.id("crude_zinc"))
                .liquid()
                .color(0x565863)
                .buildAndRegister();

        CadmiumRichZinc = new Material.Builder(Supersymmetry.id("cadmium_rich_zinc"))
                .liquid()
                .color(0x80849c)
                .buildAndRegister();

        //FREE ID: 4160-4161

        ZincLeach = new Material.Builder(Supersymmetry.id("zinc_leach"))
                .liquid()
                .color(0x8c6f58)
                .buildAndRegister();

        ZincLeachResidue = new Material.Builder(Supersymmetry.id("zinc_leach_residue"))
                .dust()
                .color(0x33281f)
                .buildAndRegister();

        HotZincLeach = new Material.Builder(Supersymmetry.id("hot_zinc_leach"))
                .liquid(new FluidBuilder().temperature(353))
                .color(0xb89e8a)
                .buildAndRegister();

        LeadSilicaResidue = new Material.Builder(Supersymmetry.id("lead_silica_residue"))
                .dust()
                .color(0x3b332d)
                .buildAndRegister();

        WaelzSlag = new Material.Builder(Supersymmetry.id("waelz_slag"))
                .dust()
                .color(0x242323)
                .buildAndRegister();

        ReducedZincLeach = new Material.Builder(Supersymmetry.id("reduced_zinc_leach"))
                .liquid()
                .color(0xb38764)
                .buildAndRegister();

        WaelzOxide = new Material.Builder(Supersymmetry.id("waelz_oxide"))
                .dust() //.liquid(new FluidBuilder().temperature(700))
                .color(0x475453)
                .buildAndRegister();

        //FREE ID: 4169

        ZincCementationSlurry = new Material.Builder(Supersymmetry.id("zinc_cementation_slurry"))
                .liquid()
                .color(0x4f5663)
                .buildAndRegister();

        PrecipitatedZincLeach = new Material.Builder(Supersymmetry.id("precipitated_zinc_leach"))
                .liquid()
                .color(0x756d54)
                .buildAndRegister();

        CopperCadmiumResidue = new Material.Builder(Supersymmetry.id("copper_cadmium_residue"))
                .dust()
                .color(0x47271d)
                .buildAndRegister();

        HotPrecipitatedZincLeach = new Material.Builder(Supersymmetry.id("hot_precipitated_zinc_leach"))
                .liquid(new FluidBuilder().temperature(353))
                .color(0x918a71)
                .buildAndRegister();

        ReprecipitatedZincLeach = new Material.Builder(Supersymmetry.id("reprecipitated_zinc_leach"))
                .liquid()
                .color(0x756e54)
                .buildAndRegister();

        CobaltResidue = new Material.Builder(Supersymmetry.id("cobalt_residue"))
                .dust()
                .color(0x373b6b)
                .buildAndRegister();

        FuselOil = new Material.Builder(Supersymmetry.id("fusel_oil"))
                .liquid()
                .color(0xa62403)
                .buildAndRegister();

        AshSlurry = new Material.Builder(Supersymmetry.id("ash_slurry"))
                .liquid()
                .color(0x252526)
                .buildAndRegister();

        DesulfurizedFlueGas = new Material.Builder(Supersymmetry.id("desulfurized_flue_gas"))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x151521)
                .buildAndRegister();

        ZincOxideFumeGas = new Material.Builder(Supersymmetry.id("zinc_oxide_fume_gas"))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x757061)
                .buildAndRegister();

        AntimonyArsenicFlueGas = new Material.Builder(Supersymmetry.id("antimony_arsenic_flue_gas"))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x707063)
                .buildAndRegister();

        ZincFlueGas = new Material.Builder(Supersymmetry.id("zinc_flue_gas"))
                .gas(new FluidBuilder().temperature(1000))
                .color(0x26222e)
                .buildAndRegister();

        FluorinatedOctanoylChlorideMixture = new Material.Builder(Supersymmetry.id("fluorinated_octanoyl_chloride_mixture"))
                .liquid()
                .color(0x458583)
                .buildAndRegister();

        ButyraldehydeMixture = new Material.Builder(Supersymmetry.id("butyraldehyde_mixture"))
                .liquid()
                .color(0x96920e)
                .buildAndRegister();

        PentanalMixture = new Material.Builder(Supersymmetry.id("pentanal_mixture"))
                .liquid()
                .color(0x968450)
                .buildAndRegister();

        SaltRoastedVanadinite = new Material.Builder(Supersymmetry.id("salt_roasted_vanadinite"))
                .dust()
                .color(0x2e2b28)
                .buildAndRegister();

        SodaAshRoastedVanadinite = new Material.Builder(Supersymmetry.id("soda_ash_roasted_vanadinite"))
                .dust()
                .color(0x38342f)
                .buildAndRegister();

        LeachedSaltRoastedVanadinite = new Material.Builder(Supersymmetry.id("leached_salt_roasted_vanadinite"))
                .dust()
                .color(0x403c37)
                .buildAndRegister();

        LeachedSodaAshRoastedVanadinite = new Material.Builder(Supersymmetry.id("leached_soda_ash_roasted_vanadinite"))
                .dust()
                .color(0x4d463f)
                .buildAndRegister();

        DissolvedFerrochromium = new Material.Builder(Supersymmetry.id("dissolved_ferrochromium"))
                .liquid()
                .color(0xd17979)
                .buildAndRegister();

        CrudeAmmoniumIronIISulfate = new Material.Builder(Supersymmetry.id("crude_ammonium_iron_ii_sulfate"))
                .dust()
                .color(0x96cf70)
                .buildAndRegister();

        MohrMotherLiquor = new Material.Builder(Supersymmetry.id("mohr_mother_liquor"))
                .liquid()
                .color(0x43a375)
                .buildAndRegister();

        CrudeAmmoniumIronIISulfateSolution = new Material.Builder(Supersymmetry.id("crude_ammonium_iron_ii_sulfate_solution"))
                .liquid(new FluidBuilder().temperature(343))
                .color(0x96cf70)
                .buildAndRegister();

        ChromiumAnolyte = new Material.Builder(Supersymmetry.id("chromium_anolyte"))
                .liquid()
                .color(0xd97777)
                .buildAndRegister();

        ChromiumCatholyte = new Material.Builder(Supersymmetry.id("chromium_catholyte"))
                .liquid()
                .color(0xc45e4f)
                .buildAndRegister();

        ChromiumMotherLiquor = new Material.Builder(Supersymmetry.id("chromium_mother_liquor"))
                .liquid()
                .color(0xeb94d1)
                .buildAndRegister();

        ReducedChromiumAnolyte = new Material.Builder(Supersymmetry.id("reduced_chromium_anolyte"))
                .liquid()
                .color(0xd9b077)
                .buildAndRegister();

        Sienna = new Material.Builder(Supersymmetry.id("sienna"))
                .dust()
                .color(0x4a3724)
                .buildAndRegister();

        BurntSienna = new Material.Builder(Supersymmetry.id("burnt_sienna"))
                .dust()
                .color(0x662e2e)
                .buildAndRegister();

        //FREE IDs: 4199-4200

        SiliconDioxideSlurry = new Material.Builder(Supersymmetry.id("silicon_dioxide_slurry"))
                .liquid()
                .color(0x69675b)
                .buildAndRegister();

        //FREE IDs: 4202

        VTSlag = new Material.Builder(Supersymmetry.id("vt_slag"))
                .dust()
                .color(0x302222)
                .buildAndRegister();

        AlkaliVTSlag = new Material.Builder(Supersymmetry.id("alkali_vt_slag"))
                .dust()
                .color(0x3b2531)
                .buildAndRegister();

        TitaniaSlag = new Material.Builder(Supersymmetry.id("titania_slag"))
                .dust()
                .color(0x4f2b3f)
                .buildAndRegister();

        CarnotiteLeach = new Material.Builder(Supersymmetry.id("carnotite_leach"))
                .liquid()
                .color(0x929c5c)
                .buildAndRegister();

        ReducedCarnotiteLeach = new Material.Builder(Supersymmetry.id("reduced_carnotite_leach"))
                .liquid()
                .color(0x696840)
                .buildAndRegister();

        UraniumVanadiumExtractionMixture = new Material.Builder(Supersymmetry.id("uranium_vanadium_extraction_mixture"))
                .liquid()
                .color(0xd4d03f)
                .buildAndRegister();

        UraniumVanadiumExtract = new Material.Builder(Supersymmetry.id("uranium_vanadium_extract"))
                .liquid()
                .color(0x505e3a)
                .buildAndRegister();

        UraniumExtract = new Material.Builder(Supersymmetry.id("uranium_extract"))
                .liquid()
                .color(0x4a6e3b)
                .buildAndRegister();

        AcidicVanadylSolution = new Material.Builder(Supersymmetry.id("acidic_vanadyl_solution"))
                .liquid()
                .color(0x804221)
                .buildAndRegister();

        ImpureUranylCarbonateSolution = new Material.Builder(Supersymmetry.id("impure_uranyl_carbonate_solution"))
                .liquid()
                .color(0x9cad37)
                .buildAndRegister();

        UranylCarbonateSolution = new Material.Builder(Supersymmetry.id("uranyl_carbonate_solution"))
                .liquid()
                .color(0xbed14d)
                .buildAndRegister();

        UranylSulfateSolution = new Material.Builder(Supersymmetry.id("uranyl_sulfate_solution"))
                .liquid()
                .color(0xb5a638)
                .buildAndRegister();

        TetraethylleadSludge = new Material.Builder(Supersymmetry.id("tetraethyllead_sludge"))
                .liquid()
                .color(0x2b1e1e)
                .buildAndRegister();

        Oxygenates = new Material.Builder(Supersymmetry.id("oxygenates"))
                .liquid()
                .color(0xb4c5e0)
                .buildAndRegister();

        Antioxidants = new Material.Builder(Supersymmetry.id("antioxidants"))
                .liquid()
                .color(0x380b0d)
                .buildAndRegister();

        Antiknock = new Material.Builder(Supersymmetry.id("antiknock"))
                .liquid()
                .color(0x48485e)
                .buildAndRegister();

        //FREE ID: 4221

        MidgradeGasoline = new Material.Builder(Supersymmetry.id("midgrade_gasoline"))
                .liquid()
                .color(0xc49735)
                .flags(FLAMMABLE)
                .buildAndRegister();

        PremiumGasoline = new Material.Builder(Supersymmetry.id("premium_gasoline"))
                .liquid()
                .color(0xdb8427)
                .flags(FLAMMABLE)
                .buildAndRegister();

        SupremeGasoline = new Material.Builder(Supersymmetry.id("supreme_gasoline"))
                .liquid()
                .color(0xf26d1b)
                .flags(FLAMMABLE)
                .buildAndRegister();

        //FREE IDs: 4225-4231

        TitanylSulfateSolution = new Material.Builder(Supersymmetry.id("titanyl_sulfate_solution"))
                .liquid()
                .color(0x74561d)
                .buildAndRegister()
                .setFormula("(H20)(TiO[SO4])(?)", true);


        AcidicWastewater = new Material.Builder(Supersymmetry.id("acidic_wastewater"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc88a41)
                .buildAndRegister()
                .setFormula("(H2O)(?)", true);


        DirtyMolecularSieve = new Material.Builder(Supersymmetry.id("dirty_molecular_sieve"))
                .dust()
                .color(0x737373)
                .iconSet(DULL)
                .buildAndRegister();

        PotashConcentrate = new Material.Builder(Supersymmetry.id("potash_concentrate"))
                .dust()
                .color(0xb39a9a)
                .buildAndRegister();

        ImpurePotashSlurry = new Material.Builder(Supersymmetry.id("impure_potash_slurry"))
                .liquid()
                .color(0xb39a9a)
                .buildAndRegister();

        PotashSlurry = new Material.Builder(Supersymmetry.id("potash_slurry"))
                .liquid()
                .color(0xd4b2b2)
                .buildAndRegister();

        SupersaturatedBrine = new Material.Builder(Supersymmetry.id("supersaturated_brine"))
                .liquid()
                .color(0xdbb56e)
                .buildAndRegister();

        OligomericBisphenolSolution = new Material.Builder(Supersymmetry.id("oligomeric_bisphenol_solution"))
                .liquid()
                .color(0xcfa532)
                .buildAndRegister();

        NetherMolecularSieve = new Material.Builder(Supersymmetry.id("nether_molecular_sieve"))
                .dust()
                .color(0x6e6565)
                .iconSet(DULL)
                .buildAndRegister();

        //FREE ID: 4241

        GraniteTailingSlurry = new Material.Builder(Supersymmetry.id("granite_tailing_slurry"))
                .liquid()
                .color(0xc48072)
                .buildAndRegister();

        //FREE ID: 4243

        SphaleriteByproductSlurry = new Material.Builder(Supersymmetry.id("sphalerite_byproduct_slurry"))
                .liquid()
                .color(0x9f97a1)
                .buildAndRegister();

        //FREE IDs: 4245-4250

        PegmatiteTailingSlurry = new Material.Builder(Supersymmetry.id("pegmatite_tailing_slurry"))
                .liquid()
                .color(0x2c4a2d)
                .buildAndRegister();

        FilteredPhosphateSlurry = new Material.Builder(Supersymmetry.id("filtered_phosphate_slurry"))
                .liquid()
                .color(0x918e27)
                .buildAndRegister();

        PhosphateConcentrateSlurry = new Material.Builder(Supersymmetry.id("phosphate_concentrate_slurry"))
                .liquid()
                .color(0xadaa32)
                .buildAndRegister();

        //FREE IDs: 4254-4255

        LimestoneTailingSlurry = new Material.Builder(Supersymmetry.id("limestone_tailing_slurry"))
                .liquid()
                .color(0x68695d)
                .buildAndRegister();

        //FREE IDs: 4257-4258

        ImpureChalcopyriteSlurry = new Material.Builder(Supersymmetry.id("impure_chalcopyrite_slurry"))
                .liquid()
                .color(0x856119)
                .buildAndRegister();

        CopperMatteFlueDust = new Material.Builder(Supersymmetry.id("copper_matte_flue"))
                .dust()
                .color(0x3e146e)
                .iconSet(DULL)
                .buildAndRegister();

        ImpureBorniteSlurry = new Material.Builder(Supersymmetry.id("impure_bornite_slurry"))
                .liquid()
                .color(0x7d511d)
                .buildAndRegister();

        CopperMatteFlueGas = new Material.Builder(Supersymmetry.id("copper_matte_flue_gas"))
                .liquid()
                .color(0x3e146e)
                .buildAndRegister();

        ImpureChalcociteSlurry = new Material.Builder(Supersymmetry.id("impure_chalcocite_slurry"))
                .liquid()
                .color(0x262424)
                .buildAndRegister();

        ZSMFive = new Material.Builder(Supersymmetry.id("zsm_five"))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x739133)
                .buildAndRegister();

        MalachiteLeach = new Material.Builder(Supersymmetry.id("malachite_leach"))
                .liquid()
                .color(0x0f6880)
                .buildAndRegister();

        OxidizedMalachiteLeach = new Material.Builder(Supersymmetry.id("oxidized_malachite_leach"))
                .liquid()
                .color(0x1a728a)
                .buildAndRegister();

        PyriteSlurry = new Material.Builder(Supersymmetry.id("pyrite_slurry"))
                .liquid()
                .color(0x967828)
                .buildAndRegister();

        CopperConcentrateSlurry = new Material.Builder(Supersymmetry.id("copper_concentrate_slurry"))
                .liquid()
                .color(0xff6400)
                .buildAndRegister();

        CopperConcentrate = new Material.Builder(Supersymmetry.id("copper_concentrate"))
                .dust()
                .color(0xff6400)
                .iconSet(SAND)
                .buildAndRegister();

        CopperMatte = new Material.Builder(Supersymmetry.id("copper_matte"))
                .dust()
                .color(0x5c3d08)
                .buildAndRegister();

        BlisterCopper = new Material.Builder(Supersymmetry.id("blister_copper"))
                .ingot()
                .flags(GENERATE_PLATE)
                .color(0x6e4c14)
                .iconSet(SHINY)
                .buildAndRegister();

        //FREE IDs: 4272-4275

        CalcinedScheelite = new Material.Builder(Supersymmetry.id("calcined_scheelite"))
                .dust()
                .color(0xc88c14)
                .iconSet(FLINT)
                .buildAndRegister();

        //FREE IDs: 4277-4280

        SilicateFreeTungstateSolution = new Material.Builder(Supersymmetry.id("silicate_free_tungstate_solution"))
                .liquid()
                .color(0x2c8576)
                .buildAndRegister();

        MolybdenumFreeTungstateSolution = new Material.Builder(Supersymmetry.id("molybdenum_free_tungstate_solution"))
                .liquid()
                .color(0x25889c)
                .buildAndRegister();

        IsodecanalMixture = new Material.Builder(Supersymmetry.id("isodecanal_mixture"))
                .liquid()
                .color(0xadad45)
                .buildAndRegister();

        TungstenExtractionMixture = new Material.Builder(Supersymmetry.id("tungsten_extraction_mixture"))
                .liquid()
                .color(0xbfb341)
                .buildAndRegister();

        TungstenExtract = new Material.Builder(Supersymmetry.id("tungsten_extract"))
                .liquid()
                .color(0x9e7c2e)
                .buildAndRegister();

        ScrubbedTungstenExtract = new Material.Builder(Supersymmetry.id("scrubbed_tungsten_extract"))
                .liquid()
                .color(0x85a825)
                .buildAndRegister();

        //FREE IDs: 4287-4289

        CopperMolybdeniteSlurry = new Material.Builder(Supersymmetry.id("copper_molybdenite_slurry"))
                .liquid()
                .color(0x2e2419)
                .buildAndRegister();

        //FREE IDs: 4291-4292

        HafniumExtractionMixture = new Material.Builder(Supersymmetry.id("hafnium_extraction_mixture"))
                .liquid()
                .color(0xc1e3d3)
                .buildAndRegister();

        HafniumExtract = new Material.Builder(Supersymmetry.id("hafnium_extract"))
                .liquid()
                .color(0xc1e3d9)
                .buildAndRegister();

        AminatedEthyleneMixture = new Material.Builder(Supersymmetry.id("aminated_ethylene_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xb9a9db)
                .buildAndRegister();

        NeutralizedAminatedEthyleneMixture = new Material.Builder(Supersymmetry.id("neutralized_aminated_ethylene_mixture"))
                .liquid()
                .color(0x8a819c)
                .buildAndRegister();

        //FREE IDs: 4297-4301

        RoastedPyrochlore = new Material.Builder(Supersymmetry.id("roasted_pyrochlore"))
                .dust()
                .color(0x230300)
                .iconSet(DULL)
                .buildAndRegister();

        DigestedPyrochlore = new Material.Builder(Supersymmetry.id("digested_pyrochlore"))
                .dust()
                .color(0x230300)
                .iconSet(QUARTZ)
                .buildAndRegister();

        ImpureNiobiumPentachloride = new Material.Builder(Supersymmetry.id("impure_niobium_pentachloride"))
                .liquid()
                .color(0xb0c8b8)
                .buildAndRegister();

        //FREE IDs: 4305-4309

        ImpureFluoroniobicAcidSolution = new Material.Builder(Supersymmetry.id("impure_fluoroniobic_acid_solution"))
                .liquid()
                .color(0x502b75)
                .buildAndRegister();

        NiobiumRichExtract = new Material.Builder(Supersymmetry.id("niobium_rich_extract"))
                .liquid()
                .color(0x4a2894)
                .buildAndRegister();

        MetalSulfateWaste = new Material.Builder(Supersymmetry.id("metal_sulfate_waste"))
                .liquid()
                .color(0x947728)
                .buildAndRegister();

        ScrubbedNiobiumRichExtract = new Material.Builder(Supersymmetry.id("scrubbed_niobium_rich_extract"))
                .liquid()
                .color(0x5a34ad)
                .buildAndRegister();

        DilutedTantalumExtract = new Material.Builder(Supersymmetry.id("diluted_tantalum_extract"))
                .liquid()
                .color(0xd99152)
                .buildAndRegister();

        FluoroniobicAcidSolution = new Material.Builder(Supersymmetry.id("fluoroniobic_acid_solution"))
                .liquid()
                .color(0x48147d)
                .buildAndRegister();

        DilutedNiobiumExtract = new Material.Builder(Supersymmetry.id("diluted_niobium_extract"))
                .liquid()
                .color(0xa46edb)
                .buildAndRegister();

        //FREE IDs: 4317-4321

        ImpureFluorotantalicAcidSolution = new Material.Builder(Supersymmetry.id("impure_fluorotantalic_acid_solution"))
                .liquid()
                .color(0x753a10)
                .buildAndRegister();

        TantalumRichExtract = new Material.Builder(Supersymmetry.id("tantalum_rich_extract"))
                .liquid()
                .color(0x9c5625)
                .buildAndRegister();

        ScrubbedTantalumRichExtract = new Material.Builder(Supersymmetry.id("scrubbed_tantalum_rich_extract"))
                .liquid()
                .color(0xb56731)
                .buildAndRegister();

        HydrofluoricAmmoniaMixture = new Material.Builder(Supersymmetry.id("hydrofluoric_ammonia_mixture"))
                .liquid()
                .color(0x5247b5)
                .buildAndRegister();

        MolybdeniteFlueGas = new Material.Builder(Supersymmetry.id("molybdenite_flue_gas"))
                .liquid()
                .color(0x464e61)
                .buildAndRegister();

        RheniumRichFlue = new Material.Builder(Supersymmetry.id("rhenium_rich_flue"))
                .dust()
                .color(0x384b75)
                .buildAndRegister();

        ScrubbedPerrhenateSolution = new Material.Builder(Supersymmetry.id("scrubbed_perrhenate_solution"))
                .liquid()
                .color(0x3c70bd)
                .buildAndRegister();

        AlphaOlefinMixture = new Material.Builder(Supersymmetry.id("alpha_olefin_mixture"))
                .liquid()
                .color(0xd15298)
                .buildAndRegister();

        //FREE ID: 4330-4332

        HZSMFive = new Material.Builder(Supersymmetry.id("hzsm_five"))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x75a118)
                .buildAndRegister();

        FunctionalizableCrosslinkedPolystyrene = new Material.Builder(Supersymmetry.id("functionalizable_crosslinked_polystyrene"))
                .ingot().liquid(new FluidBuilder().temperature(513))
                .flags(GENERATE_ROUND)
                .color(0x8689cf)
                .buildAndRegister();

        TantalumExtract = new Material.Builder(Supersymmetry.id("tantalum_extract"))
                .liquid()
                .color(0xc97328)
                .buildAndRegister();

        BisphenolBrominationCatalyst = new Material.Builder(Supersymmetry.id("bisphenol_bromination_catalyst"))
                .dust()
                .color(0xbd800f)
                .buildAndRegister();

        ImpureBrominatedBisphenolEmulsion = new Material.Builder(Supersymmetry.id("impure_brominated_bisphenol_emulsion"))
                .liquid()
                .color(0x502d0a)
                .buildAndRegister();

        ImpureBrominatedBisphenolSolution = new Material.Builder(Supersymmetry.id("impure_brominated_bisphenol_solution"))
                .liquid()
                .color(0x78410a)
                .buildAndRegister();

        BisphenolANovolacEpoxy = new Material.Builder(Supersymmetry.id("bisphenol_a_novolac_epoxy"))
                .dust()
                .color(0xa87e54)
                .buildAndRegister();

        SulfoniumPreparationMixture = new Material.Builder(Supersymmetry.id("sulfonium_preparation_mixture"))
                .liquid()
                .color(0x9e935c)
                .buildAndRegister();

        SuEight = new Material.Builder(Supersymmetry.id("su_eight"))
                .liquid()
                .color(0x11915c)
                .buildAndRegister();

        HydrodealkylatedTolueneMixture = new Material.Builder(Supersymmetry.id("hydrodealkylated_toluene_mixture"))
                .liquid()
                .color(0x4a320a)
                .buildAndRegister();

        AcidicHydrogenSilsesquioxaneSolution = new Material.Builder(Supersymmetry.id("acidic_hydrogen_silsesquioxane_solution"))
                .liquid()
                .color(0xb086aa)
                .buildAndRegister();

        HydrogenSilsesquioxaneSolution = new Material.Builder(Supersymmetry.id("hydrogen_silsesquioxane_solution"))
                .liquid()
                .color(0xa186b0)
                .buildAndRegister();

        ImpureCelestineSlurry = new Material.Builder(Supersymmetry.id("impure_celestine_slurry"))
                .liquid()
                .color(0x698886)
                .buildAndRegister();

        CelestineSlurry = new Material.Builder(Supersymmetry.id("celestine_slurry"))
                .liquid()
                .color(0x8cb5b3)
                .buildAndRegister();

        BariumResidue = new Material.Builder(Supersymmetry.id("barium_residue"))
                .dust()
                .color(0xc9c4b1)
                .buildAndRegister();

        OrganosiliconMixture = new Material.Builder(Supersymmetry.id("organosilicon_mixture"))
                .liquid()
                .color(0xbebdb8)
                .buildAndRegister();

        ImpurePolydimethylsiloxaneMixture = new Material.Builder(Supersymmetry.id("impure_polydimethylsiloxane_mixture"))
                .liquid()
                .color(0xf6f7f0)
                .buildAndRegister();

        RawPolydimethylsiloxaneMixture = new Material.Builder(Supersymmetry.id("raw_polydimethylsiloxane_mixture"))
                .liquid()
                .color(0xf6f7f0)
                .buildAndRegister();

        AcidicDinitrobenzeneMixture = new Material.Builder(Supersymmetry.id("acidic_dinitrobenzene_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(363))
                .color(0x255563)
                .buildAndRegister();

        AntistaticAdditive = new Material.Builder(Supersymmetry.id("antistatic_additive"))
                .liquid()
                .color(0xd1cc8e)
                .buildAndRegister();

        AntifoamingAdditive = new Material.Builder(Supersymmetry.id("antifoaming_additive"))
                .liquid()
                .color(0x597275)
                .buildAndRegister();

        DiisopropylParaPhenylenediamineSolution = new Material.Builder(Supersymmetry.id("diisopropyl_para_phenylenediamine_solution"))
                .liquid()
                .color(0x189477)
                .buildAndRegister();

        PropanolamineMix = new Material.Builder(Supersymmetry.id("propanolamine_mix"))
                .liquid()
                .color(0x4cb522)
                .buildAndRegister();

        LubricityAdditive = new Material.Builder(Supersymmetry.id("lubricity_additive"))
                .liquid()
                .color(0xab8f61)
                .buildAndRegister();

        MetalDeactivator = new Material.Builder(Supersymmetry.id("metal_deactivator"))
                .liquid()
                .color(0x9b34a8)
                .buildAndRegister();

        IgnitionImprover = new Material.Builder(Supersymmetry.id("ignition_improver"))
                .liquid()
                .color(0x8ede6f)
                .buildAndRegister();

        ColdFlowImprover = new Material.Builder(Supersymmetry.id("cold_flow_improver"))
                .liquid()
                .color(0x1c32a3)
                .buildAndRegister();

        CorrosionInhibitor = new Material.Builder(Supersymmetry.id("corrosion_inhibitor"))
                .liquid()
                .color(0x8a633a)
                .buildAndRegister();

        MidgradeDiesel = new Material.Builder(Supersymmetry.id("midgrade_diesel"))
                .liquid()
                .color(0xc4a535)
                .flags(FLAMMABLE)
                .buildAndRegister();

        PremiumDiesel = new Material.Builder(Supersymmetry.id("premium_diesel"))
                .liquid()
                .color(0xd1aa1d)
                .flags(FLAMMABLE)
                .buildAndRegister();

        SupremeDiesel = new Material.Builder(Supersymmetry.id("supreme_diesel"))
                .liquid()
                .color(0xdb9a16)
                .flags(FLAMMABLE)
                .buildAndRegister();

        MidgradeKerosene = new Material.Builder(Supersymmetry.id("midgrade_kerosene"))
                .liquid()
                .color(0xa8a44a)
                .flags(FLAMMABLE)
                .buildAndRegister();

        PremiumKerosene = new Material.Builder(Supersymmetry.id("premium_kerosene"))
                .liquid()
                .color(0xbab541)
                .flags(FLAMMABLE)
                .buildAndRegister();

        SupremeKerosene = new Material.Builder(Supersymmetry.id("supreme_kerosene"))
                .liquid()
                .color(0xd9c148)
                .flags(FLAMMABLE)
                .buildAndRegister();

        SAPOEleven = new Material.Builder(Supersymmetry.id("sapo_eleven"))
                .dust()
                .color(0x91834e)
                .buildAndRegister();

        PlatinumSAPOEleven = new Material.Builder(Supersymmetry.id("platinum_sapo_eleven"))
                .dust()
                .color(0x969444)
                .flags(GENERATE_CATALYST_BED)
                .buildAndRegister();

        SiliconeOilMixture = new Material.Builder(Supersymmetry.id("silicone_oil_mixture"))
                .liquid()
                .color(0x9aa38c)
                .buildAndRegister();

        SiliconeOil = new Material.Builder(Supersymmetry.id("silicone_oil"))
                .liquid()
                .color(0xbec7b1)
                .buildAndRegister();

        CrudePolyalphaolefinMixture = new Material.Builder(Supersymmetry.id("crude_polyalphaolefin_mixture"))
                .liquid()
                .color(0xc77db2)
                .buildAndRegister();

        BoronTrifluorideMixture = new Material.Builder(Supersymmetry.id("boron_trifluoride_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xbd3a6b)
                .buildAndRegister();

        UnsaturatedPolyalphaolefin = new Material.Builder(Supersymmetry.id("unsaturated_polyalphaolefin"))
                .liquid()
                .color(0xb393ba)
                .buildAndRegister();

        NButanolWaste = new Material.Builder(Supersymmetry.id("n_butanol_waste"))
                .liquid()
                .color(0xba6685)
                .buildAndRegister();

        Polyalphaolefin = new Material.Builder(Supersymmetry.id("polyalphaolefin"))
                .liquid()
                .color(0xcbaed1)
                .buildAndRegister();

        PolybuteneMixture = new Material.Builder(Supersymmetry.id("polybutene_mixture"))
                .liquid()
                .color(0xb08d63)
                .buildAndRegister();

        EsterBaseOil = new Material.Builder(Supersymmetry.id("ester_base_oil"))
                .liquid()
                .color(0xa098d4)
                .buildAndRegister();

        Monoglycerides = new Material.Builder(Supersymmetry.id("monoglycerides"))
                .liquid()
                .color(0xb39147)
                .buildAndRegister();

        CrudeOneNitronaphthalene = new Material.Builder(Supersymmetry.id("crude_one_nitronaphthalene"))
                .dust()
                .color(0x918a41)
                .buildAndRegister();

        PolyisobuteneMixture = new Material.Builder(Supersymmetry.id("polyisobutene_mixture"))
                .liquid()
                .color(0xad6d34)
                .buildAndRegister();

        AlkylMethacrylate = new Material.Builder(Supersymmetry.id("alkyl_methacrylate"))
                .liquid()
                .color(0x72ba6e)
                .buildAndRegister();

        PolyalkylMethacrylateSolution = new Material.Builder(Supersymmetry.id("polyalkyl_methacrylate_solution"))
                .liquid()
                .color(0x8db08b)
                .buildAndRegister();

        AlkylMethacrylateEmulsion = new Material.Builder(Supersymmetry.id("alkyl_methacrylate_emulsion"))
                .liquid()
                .color(0xa4d4a1)
                .buildAndRegister();

        Pama = new Material.Builder(Supersymmetry.id("pama"))
                .dust()
                .color(0xc9edc7)
                .buildAndRegister();

        PolymerizedStyreneIsopreneSolution = new Material.Builder(Supersymmetry.id("polymerized_styrene_isoprene_solution"))
                .liquid()
                .color(0x361940)
                .buildAndRegister();

        PolyisobuteneSuccinicAnhydride = new Material.Builder(Supersymmetry.id("polyisobutene_succinic_anhydride"))
                .dust()
                .color(0x6b142b)
                .buildAndRegister();

        ZincDialkyldithiophospate = new Material.Builder(Supersymmetry.id("zinc_dialkyldithiophosphate"))
                .liquid()
                .color(0x423900)
                .buildAndRegister()
                .setFormula("Zn[(S2P(OR)2]2", true);


        MolybdenumDialkyldithiophosphate = new Material.Builder(Supersymmetry.id("molybdenum_dialkyldithiophosphate"))
                .dust()
                .color(0x244200)
                .buildAndRegister()
                .setFormula("Mo[(S2P(OR)2]2", true);


        MidgradeLubricant = new Material.Builder(Supersymmetry.id("midgrade_lubricant"))
                .liquid()
                .color(0xc7aa2a)
                .buildAndRegister();

        PremiumLubricant = new Material.Builder(Supersymmetry.id("premium_lubricant"))
                .liquid()
                .color(0xba831c)
                .buildAndRegister();

        SupremeLubricant = new Material.Builder(Supersymmetry.id("supreme_lubricant"))
                .liquid()
                .color(0xad5f10)
                .buildAndRegister();

        DinitrobenzeneMixture = new Material.Builder(Supersymmetry.id("dinitrobenzene_mixture"))
                .dust()
                .color(0x1f6478)
                .buildAndRegister();

        Cotton = new Material.Builder(Supersymmetry.id("cotton"))
                .color(0xf0edd8)
                .buildAndRegister()
                .setFormula("C6H5(OH)4OH", true);

        // @TODO: this might not being correctly implemented, as the cotton fibber cannot be seen under the recipe viewer
        Cotton.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, false, false));

        Spandex = new Material.Builder(Supersymmetry.id("spandex"))
                .color(0x625f8a)
                .buildAndRegister();

        Spandex.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, false, true));

        PolyurethanePolymerizationMix = new Material.Builder(Supersymmetry.id("polyurethane_polymerization_mix"))
                .liquid()
                .color(0x9c9c9c)
                .buildAndRegister();

        SpandexPrepolymer = new Material.Builder(Supersymmetry.id("spandex_prepolymer"))
                .liquid()
                .color(0x393563)
                .buildAndRegister();

        SpandexPolymerizationMix = new Material.Builder(Supersymmetry.id("spandex_polymerization_mix"))
                .liquid()
                .color(0x494575)
                .buildAndRegister();

        AcrylicPhotoemulsion = new Material.Builder(Supersymmetry.id("acrylic_photoemulsion"))
                .liquid()
                .color(0x8a2531)
                .buildAndRegister();

        TreatedCollagen = new Material.Builder(Supersymmetry.id("treated_collagen"))
                .dust()
                .color(0xa6a490)
                .iconSet(ROUGH)
                .buildAndRegister();

        ImpureCadmiumSulfateSolution = new Material.Builder(Supersymmetry.id("impure_cadmium_sulfate_solution"))
                .liquid()
                .color(0x6f8485)
                .buildAndRegister();

        TannicAcidSolution = new Material.Builder(Supersymmetry.id("tannic_acid_solution"))
                .liquid()
                .color(0x702507)
                .buildAndRegister();

        GermaniumLeach = new Material.Builder(Supersymmetry.id("germanium_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7ecccb)
                .buildAndRegister();

        GermaniumConcentrate = new Material.Builder(Supersymmetry.id("germanium_concentrate"))
                .dust()
                .color(0x6ca3a2)
                .buildAndRegister();

        ImpureGermaniumTetrachloride = new Material.Builder(Supersymmetry.id("impure_germanium_tetrachloride"))
                .gas(new FluidBuilder().temperature(360))
                .color(0xc3ded9)
                .buildAndRegister();

        GermaniumOxalateLeach = new Material.Builder(Supersymmetry.id("germanium_oxalate_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x476f91)
                .buildAndRegister();

        PurifiedGermaniumOxalateLeach = new Material.Builder(Supersymmetry.id("purified_germanium_oxalate_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x52809c)
                .buildAndRegister();

        GermaniumGalliumExtractionMixture = new Material.Builder(Supersymmetry.id("germanium_gallium_extraction_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7657b5)
                .buildAndRegister();

        GermaniumGalliumExtract = new Material.Builder(Supersymmetry.id("germanium_gallium_extract"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x5a56a3)
                .buildAndRegister();

        GermaniumExtract = new Material.Builder(Supersymmetry.id("germanium_extract"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x6e59b5)
                .buildAndRegister();

        GermaniumOxalateSolution = new Material.Builder(Supersymmetry.id("germanium_oxalate_solution"))
                .liquid()
                .color(0x8b78cc)
                .buildAndRegister();

        CrudeIndiumIIIHydroxide = new Material.Builder(Supersymmetry.id("crude_indium_iii_hydroxide"))
                .dust()
                .color(0x5618ad)
                .buildAndRegister();

        IndiumResidue = new Material.Builder(Supersymmetry.id("indium_residue"))
                .dust()
                .color(0x7d41b5)
                .buildAndRegister();

        IndiumLeach = new Material.Builder(Supersymmetry.id("indium_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x7418ad)
                .buildAndRegister();

        CrudeIndiumIIISulfateSolution = new Material.Builder(Supersymmetry.id("crude_indium_iii_sulfate_solution"))
                .liquid()
                .color(0xab18ad)
                .buildAndRegister();

        SulfatizedLeadSlime = new Material.Builder(Supersymmetry.id("sulfatized_lead_slime"))
                .dust()
                .color(0x522a44)
                .buildAndRegister();

        ImpureIndiumLeach = new Material.Builder(Supersymmetry.id("impure_indium_leach"))
                .liquid()
                .color(0x853579)
                .buildAndRegister();

        ZincHydrochloricLeachResidue = new Material.Builder(Supersymmetry.id("zinc_hydrochloric_leach_residue"))
                .dust()
                .color(0x4a3b2f)
                .buildAndRegister();

        CopperAnodeSlimePaste = new Material.Builder(Supersymmetry.id("copper_anode_slime_paste"))
                .liquid()
                .color(0x706b36)
                .buildAndRegister();

        SeleniumTelluriumConcentrate = new Material.Builder(Supersymmetry.id("selenium_tellurium_concentrate"))
                .dust()
                .color(0x9bbf77)
                .buildAndRegister();

        TelluriumResidue = new Material.Builder(Supersymmetry.id("tellurium_residue"))
                .dust()
                .color(0x688767)
                .buildAndRegister();

        TelluriumSlag = new Material.Builder(Supersymmetry.id("tellurium_slag"))
                .dust()
                .color(0x98bf97)
                .buildAndRegister();

        PolluciteLeach = new Material.Builder(Supersymmetry.id("pollucite_leach"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x8fa8cf)
                .buildAndRegister();

        CaesiumRubidiumAlumMixture = new Material.Builder(Supersymmetry.id("caesium_rubidium_alum_mixture"))
                .dust()
                .color(0x631a87)
                .buildAndRegister();
    }
}
