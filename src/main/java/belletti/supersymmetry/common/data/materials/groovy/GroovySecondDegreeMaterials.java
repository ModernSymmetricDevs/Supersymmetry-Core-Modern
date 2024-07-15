package belletti.supersymmetry.common.data.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;

import static belletti.supersymmetry.common.data.materials.SuSyMaterialFlags.GENERATE_CATALYST_BED;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.*;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.ActivatedCarbon;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.PotassiumCarbonate;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.PotassiumHydroxide;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.PotassiumIodide;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GroovySecondDegreeMaterials {
    public static void register() {

        Supersymmetry.LOGGER.info("Registering Second Degree Materials!");

        NitrateSaltMix = new Material.Builder(Supersymmetry.id("nitrate_salt_mix"))
                .dust()
                .components(AmmoniumChloride, 1, Saltpeter, 1)
                .colorAverage()
                .buildAndRegister();

        AmmoniumChlorideSolution = new Material.Builder(Supersymmetry.id("ammonium_chloride_solution"))
                .liquid()
                .components(AmmoniumChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumChlorideSolution = new Material.Builder(Supersymmetry.id("potassium_chloride_solution"))
                .liquid()
                .color(0x3b5eeb)
                .components(RockSalt, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumBisulfateSolution = new Material.Builder(Supersymmetry.id("potassium_bisulfate_solution"))
                .liquid()
                .components(PotassiumBisulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumBisulfateSolution = new Material.Builder(Supersymmetry.id("sodium_bisulfate_solution"))
                .liquid()
                .components(SodiumBisulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        CalciumChlorideSolution = new Material.Builder(Supersymmetry.id("calcium_chloride_solution"))
                .liquid()
                .components(CalciumChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodaAshSolution = new Material.Builder(Supersymmetry.id("soda_ash_solution"))
                .liquid()
                .components(SodaAsh, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumBicarbonateSolution = new Material.Builder(Supersymmetry.id("sodium_bicarbonate_solution"))
                .liquid()
                .color(0x252747)
                .buildAndRegister()
                .setFormula("(H2O)(NaHCO3)", true);

        AmmoniumNitrateSolution = new Material.Builder(Supersymmetry.id("ammonium_nitrate_solution"))
                .liquid()
                .components(Water, 1)
                .colorAverage()
                .buildAndRegister();

        NitrateSolution = new Material.Builder(Supersymmetry.id("nitrate_solution"))
                .liquid()
                .components(AmmoniumChloride, 1, Saltpeter, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumNitrateSolution = new Material.Builder(Supersymmetry.id("sodium_nitrate_solution"))
                .liquid()
                .components(SodiumNitrate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedPotassiumCarbonateSolution = new Material.Builder(Supersymmetry.id("diluted_potassium_carbonate_solution"))
                .liquid()
                .components(PotassiumCarbonate, 1, Water, 3)
                .colorAverage()
                .buildAndRegister();

        PotassiumHydroxideSolution = new Material.Builder(Supersymmetry.id("potassium_hydroxide_solution"))
                .liquid()
                .components(PotassiumHydroxide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        CalciumHydroxideSlurry = new Material.Builder(Supersymmetry.id("calcium_hydroxide_slurry"))
                .liquid()
                .components(Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumSilicateSolution = new Material.Builder(Supersymmetry.id("sodium_silicate_solution"))
                .liquid()
                .components(SodiumSilicate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumAluminateSolution = new Material.Builder(Supersymmetry.id("sodium_aluminate_solution"))
                .liquid()
                .components(SodiumAluminate, 1, Water, 1)
                .color(0x3f71bf)
                .buildAndRegister();

        SodiumFluorideSolution = new Material.Builder(Supersymmetry.id("sodium_fluoride_solution"))
                .liquid()
                .components(SodiumFluoride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumFluorideSolution = new Material.Builder(Supersymmetry.id("potassium_fluoride_solution"))
                .liquid()
                .components(PotassiumFluoride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumTetrafluoroborateSolution = new Material.Builder(Supersymmetry.id("potassium_tetrafluoroborate_solution"))
                .liquid()
                .components(PotassiumTetrafluoroborate, 2, Water, 7)
                .color(0x8fb5a3)
                .buildAndRegister();

        SodiumBromideSolution = new Material.Builder(Supersymmetry.id("sodium_bromide_solution"))
                .liquid()
                .components(SodiumBromide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        WackerCatalyst = new Material.Builder(Supersymmetry.id("wacker_catalyst"))
                .dust()
                .components(PalladiumChloride, 1, CopperIIChloride, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumIodideSolution = new Material.Builder(Supersymmetry.id("potassium_iodide_solution"))
                .liquid()
                .components(PotassiumIodide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumSulfateSolution = new Material.Builder(Supersymmetry.id("sodium_sulfate_solution"))
                .liquid()
                .components(SodiumSulfite, 1, Water, 1)
                .color(0xb0b0bf)
                .buildAndRegister();

        ImpregnatedCopperOxideCatalyst = new Material.Builder(Supersymmetry.id("impregnated_copper_oxide_catalyst"))
                .dust()
                .components(CupricOxide, 1, Alumina, 1)
                .colorAverage()
                .buildAndRegister();

        PhilipsCatalyst = new Material.Builder(Supersymmetry.id("philips_catalyst"))
                .dust()
                .components(SiliconDioxide, 1, ChromiumTrioxide, 1)
                .colorAverage()
                .buildAndRegister();

        ZieglerNattaCatalyst = new Material.Builder(Supersymmetry.id("ziegler_natta_catalyst"))
                .dust()
                .components(Triethylaluminium, 1, TitaniumTetrachloride, 1)
                .colorAverage()
                .buildAndRegister();

        HydrogenPeroxideSolution = new Material.Builder(Supersymmetry.id("hydrogen_peroxide_solution"))
                .liquid()
                .components(HydrogenPeroxide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AmmoniumAcetateSolution = new Material.Builder(Supersymmetry.id("ammonium_acetate_solution"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 2, Water, 1)
                .colorAverage()
                .buildAndRegister();

        TetramethylammoniumHydroxideSolution = new Material.Builder(Supersymmetry.id("tetramethylammonium_hydroxide_solution"))
                .liquid()
                .components(Methanol, 1, TetramethylammoniumHydroxide, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumSulfiteSolution = new Material.Builder(Supersymmetry.id("sodium_sulfite_solution"))
                .liquid()
                .components(SodiumSulfite, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PhosphorusSolution = new Material.Builder(Supersymmetry.id("phosphorus_solution"))
                .liquid()
                .components(PhosphorusTrichloride, 1, Phosphorus, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumCyanideSolution = new Material.Builder(Supersymmetry.id("sodium_cyanide_solution"))
                .liquid()
                .components(SodiumCyanide, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        BrominatedSulfurDioxide = new Material.Builder(Supersymmetry.id("brominated_sulfur_dioxide"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, 1, HydrobromicAcid, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumThiosulfateSolution = new Material.Builder(Supersymmetry.id("sodium_thiosulfate_solution"))
                .liquid()
                .components(SodiumThiosulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumPerchlorateSolution = new Material.Builder(Supersymmetry.id("sodium_perchlorate_solution"))
                .liquid()
                .color(0x5880c7)
                .buildAndRegister()
                .setFormula("(H2O)(NaClO4)", true);


        SodiumChlorateSolution = new Material.Builder(Supersymmetry.id("sodium_chlorate_solution"))
                .liquid()
                .color(0x315fe8)
                .buildAndRegister()
                .setFormula("(H2O)(NaClO3)", true);


        DilutedAniline = new Material.Builder(Supersymmetry.id("diluted_aniline"))
                .liquid()
                .color(0x5fb36e)
                .buildAndRegister()
                .setFormula("(H2O)2(C6H5NH2)", true);


        DilutedIronIIIChlorideSolution = new Material.Builder(Supersymmetry.id("diluted_iron_iii_chloride_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Iron3Chloride, 1, Water, 3)
                .colorAverage()
                .buildAndRegister();

        ChloroauricAcidSolution = new Material.Builder(Supersymmetry.id("chloroauric_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroauricAcid, 3, NitricAcid, 1, Water, 6)
                .color(0xd69129)
                .buildAndRegister();

        ZincChlorideSolution = new Material.Builder(Supersymmetry.id("zinc_chloride_solution"))
                .liquid()
                .components(ZincChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        WohlwillElectrolyte = new Material.Builder(Supersymmetry.id("wohlwill_electrolyte"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroauricAcid, 1, Water, 1, HydrogenChloride, 2)
                .color(0xe8b833)
                .buildAndRegister();

        SpentWohlwilElectrolyte = new Material.Builder(Supersymmetry.id("spent_wohlwill_electrolyte"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroauricAcid, 1, Water, 1, HydrogenChloride, 2)
                .color(0xfacd50)
                .buildAndRegister()
                .setFormula("(?)(H[AuCl4])(H2O)(HCl)2", true);


        GoldOreSlurry = new Material.Builder(Supersymmetry.id("gold_ore_slurry"))
                .liquid()
                .components(GoldConcentrate, 4, Water, 6)
                .colorAverage()
                .buildAndRegister();

        GoldEluent = new Material.Builder(Supersymmetry.id("gold_eluent"))
                .liquid()
                .components(SodiumCyanide, 1, SodiumHydroxide, 1, Water, 27)
                .colorAverage()
                .buildAndRegister();

        GoldEluteSolution = new Material.Builder(Supersymmetry.id("gold_elute_solution"))
                .liquid()
                .components(SodiumCyanide, 1, SodiumHydroxide, 1, Sodium, 27, Gold, 27, Carbon, 54, Nitrogen, 54, Water, 27)
                .color(0xbbcc64)
                .buildAndRegister()
                .setFormula("(NaCN)(NaOH)(Na[Au(CN)2])27(H2O)27", true);


        PotassiumCarbonateSolution = new Material.Builder(Supersymmetry.id("potassium_carbonate_solution"))
                .liquid()
                .components(PotassiumCarbonate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumSulfateSolution = new Material.Builder(Supersymmetry.id("potassium_sulfate_solution"))
                .liquid()
                .components(GroovySuSyMaterials.PotassiumSulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PhosphoriteSlurry = new Material.Builder(Supersymmetry.id("phosphorite_slurry"))
                .liquid()
                .components(Phosphorite, 2, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedHexafluorosilicicAcid = new Material.Builder(Supersymmetry.id("diluted_hexafluorosilicic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HexafluorosilicicAcid, 1, Water, 8)
                .colorAverage()
                .buildAndRegister();

        LithiumSulfateSolution = new Material.Builder(Supersymmetry.id("lithium_sulfate_solution"))
                .liquid()
                .components(LithiumSulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedSodiumSulfateSolution = new Material.Builder(Supersymmetry.id("diluted_sodium_sulfate_solution"))
                .liquid()
                .components(SodiumSulfite, 1, Water, 2)
                .color(0x9191b3)
                .buildAndRegister();

        DilutedHydrofluoricAcid = new Material.Builder(Supersymmetry.id("diluted_hydrofluoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HydrogenFluoride, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        FluorideFusedBeryl = new Material.Builder(Supersymmetry.id("fluoride_fused_beryl"))
                .dust()
                .components(SodiumFluoroberyllate, 6, Alumina, 2, SiliconDioxide, 15)
                .color(0x424f3e)
                .buildAndRegister();

        SodiumFluoroberyllateSolution = new Material.Builder(Supersymmetry.id("sodium_fluoroberyllate_solution"))
                .liquid()
                .components(SodiumFluoroberyllate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AmmoniumFluoroberyllateSolution = new Material.Builder(Supersymmetry.id("ammonium_fluoroberyllate_solution"))
                .liquid()
                .components(AmmoniumFluoroberyllate, 1, Water, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NH4)2(BeF4)(H2O)3", true);


        AmmoniumFluorideSolution = new Material.Builder(Supersymmetry.id("ammonium_fluoride_solution"))
                .liquid()
                .components(AmmoniumFluoride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AlkaliFusedBeryl = new Material.Builder(Supersymmetry.id("alkali_fused_beryl"))
                .dust()
                .components(Emerald, 1, SodaAsh, 1)
                .colorAverage()
                .buildAndRegister();

        AluminiumSulfateSolution = new Material.Builder(Supersymmetry.id("aluminium_sulfate_solution"))
                .liquid()
                .components(AluminiumSulfate, 1, Water, 6)
                .colorAverage()
                .buildAndRegister();

        OxidizedManganateSolution = new Material.Builder(Supersymmetry.id("oxidized_manganate_solution"))
                .liquid()
                .components()
                .color(0x48065e)
                .buildAndRegister();

        CopperSulfateSolution = new Material.Builder(Supersymmetry.id("copper_sulfate_solution"))
                .liquid()
                .components(CopperSulfate, 1, Water, 1)
                .color(0x2d3bcf)
                .buildAndRegister();

        BariumChlorideSolution = new Material.Builder(Supersymmetry.id("barium_chloride_solution"))
                .liquid()
                .components(BariumChloride, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        DilutedSodiumSilicateSolution = new Material.Builder(Supersymmetry.id("diluted_sodium_silicate_solution"))
                .liquid()
                .components(SodiumSilicate, 1, Water, 4)
                .colorAverage()
                .buildAndRegister();

        SodiumDichromateSolution = new Material.Builder(Supersymmetry.id("sodium_dichromate_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SodiumDichromate, 1, Water, 1, SulfuricAcid, 1)
                .color(0xe0912f)
                .buildAndRegister();

        ChromiumSodaMixture = new Material.Builder(Supersymmetry.id("chromium_soda_mixture"))
                .dust()
                .components(ChromiumIIIOxide, 1, SodaAsh, 1)
                .buildAndRegister();

        LeadChlorideSolution = new Material.Builder(Supersymmetry.id("lead_chloride_solution"))
                .liquid(new FluidBuilder().temperature(343))
                .components(LeadChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AmmoniumSulfateSolution = new Material.Builder(Supersymmetry.id("ammonium_sulfate_solution"))
                .liquid()
                .components(AmmoniumSulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AmmoniumChromeAlumSolution = new Material.Builder(Supersymmetry.id("ammonium_chrome_alum_solution"))
                .liquid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .buildAndRegister();

        AgedAmmoniumChromeAlumSolution = new Material.Builder(Supersymmetry.id("aged_ammonium_chrome_alum_solution"))
                .liquid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .buildAndRegister();

        PurifiedAmmoniumChromeAlumSolution = new Material.Builder(Supersymmetry.id("purified_ammonium_chrome_alum_solution"))
                .liquid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .buildAndRegister();

        AmmoniumIronIISulfateSolution = new Material.Builder(Supersymmetry.id("ammonium_iron_ii_sulfate_solution"))
                .liquid(new FluidBuilder().temperature(343))
                .components(AmmoniumIronIISulfate, 1, Water, 1)
                .color(0x70cc6e)
                .buildAndRegister();

        //FREE IDs: 13072-13074

        DilutedAmmoniumSulfateSolution = new Material.Builder(Supersymmetry.id("diluted_ammonium_sulfate_solution"))
                .liquid()
                .components(AmmoniumSulfate, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        AlluvialPlatinumMotherLiquor = new Material.Builder(Supersymmetry.id("alluvial_platinum_mother_liquor"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 2, Palladium, 1, Chlorine, 4, ZincChloride, 1, HydrogenChloride, 4, Water, 14)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H2PdCl4)(ZnCl2)(HCl)4(H2O)14", true);


        AmmoniacalSodiumBicarbonateSolution = new Material.Builder(Supersymmetry.id("ammoniacal_sodium_bicarbonate_solution"))
                .liquid()
                .components(AmmoniumChloride, 1, SodiumBicarbonate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        VeryDilutedSodiumSulfateSolution = new Material.Builder(Supersymmetry.id("very_diluted_sodium_sulfate_solution"))
                .liquid()
                .components(SodiumSulfite, 1, Water, 9)
                .colorAverage()
                .buildAndRegister();

        MolybdicAcidSolution = new Material.Builder(Supersymmetry.id("molybdic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 2, Molybdenum, 1, Oxygen, 4, HydrogenChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H2MoO4)(HCl)(H2O)", true);


        NeutralizedAmmoniumMolybdateSolution = new Material.Builder(Supersymmetry.id("neutralized_ammonium_molybdate_solution"))
                .liquid()
                .components(Nitrogen, 2, Hydrogen, 8, Molybdenum, 1, Oxygen, 4, AmmoniumChloride, 1, Water, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("[(NH4)2MoO4](NH4Cl)(H2O)4", true);


        SublimatedMolybdenumTrioxide = new Material.Builder(Supersymmetry.id("sublimated_molybdenum_trioxide"))
                .liquid()
                .components(PurifiedMolybdenumTrioxide, 1, Air, 1)
                .colorAverage()
                .buildAndRegister();

        AmmoniumThiocyanateSolution = new Material.Builder(Supersymmetry.id("ammonium_thiocyanate_solution"))
                .liquid()
                .components(AmmoniumThiocyanate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        TantalumFluorideSolution = new Material.Builder(Supersymmetry.id("tantalum_fluoride_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TantalumFluoride, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        AmmoniumPerrhenateSolution = new Material.Builder(Supersymmetry.id("ammonium_perrhenate_solution"))
                .liquid()
                .components(AmmoniumPerrhenate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AluminiumChlorideSolution = new Material.Builder(Supersymmetry.id("aluminium_chloride_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AluminiumChloride, 1, Water, 3)
                .colorAverage()
                .buildAndRegister();

        DilutedSodiumSulfiteSolution = new Material.Builder(Supersymmetry.id("diluted_sodium_sulfite_solution"))
                .liquid()
                .components(SodiumSulfite, 1, Water, 14)
                .color(0x75745a)
                .buildAndRegister();

        EGlass = new Material.Builder(Supersymmetry.id("e_glass"))
                .dust().liquid(new FluidBuilder().temperature(2300))
                .components(SiliconDioxide, 6, Alumina, 1, BoronTrioxide, 1, Quicklime, 2)
                .color(0x778f8b)
                .buildAndRegister();

        AlluvialPalladiumMotherLiquor = new Material.Builder(Supersymmetry.id("alluvial_palladium_mother_liquor"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AmmoniumChloride, 2, ZincChloride, 1, HydrogenChloride, 4, Water, 16)
                .colorAverage()
                .buildAndRegister();

        AlluvialDivalentPalladiumSolution = new Material.Builder(Supersymmetry.id("alluvial_divalent_palladium_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 2, Palladium, 1, Chlorine, 4, ZincChloride, 1, HydrogenChloride, 4, Water, 14)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H2PdCl4)(ZnCl2)(HCl)4(H2O)14", true);


        PlatinumPrecursorSolution = new Material.Builder(Supersymmetry.id("platinum_precursor_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AmmoniumHexachloroplatinate, 1, PhosphoricAcid, 1)
                .colorAverage()
                .buildAndRegister();

        SupportedPlatinum = new Material.Builder(Supersymmetry.id("supported_platinum"))
                .dust()
                .components(Alumina, 1, Platinum, 1, Chlorine, 4)
                .flags(GENERATE_CATALYST_BED)
                .buildAndRegister();

        CrudeManganeseIISulfateSolution = new Material.Builder(Supersymmetry.id("crude_manganese_ii_sulfate_solution"))
                .liquid()
                .components(ManganeseIISulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(MnSO4)(H2O)", true);

        ManganeseIISulfateSolution = new Material.Builder(Supersymmetry.id("manganese_ii_sulfate_solution"))
                .liquid()
                .components(ManganeseIISulfate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(MnSO4)(H2O)", true);

        DilutedZincChlorideSolution = new Material.Builder(Supersymmetry.id("diluted_zinc_chloride_solution"))
                .liquid()
                .components(ZincChloride, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        TrichlorosilaneSolution = new Material.Builder(Supersymmetry.id("trichlorosilane_solution"))
                .liquid()
                .components(Trichlorosilane, 1, Toluene, 6)
                .colorAverage()
                .buildAndRegister();

        ImpureBariumSulfideSolution = new Material.Builder(Supersymmetry.id("impure_barium_sulfide_solution"))
                .liquid()
                .components(ImpureBariumSulfide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        ImpureStrontiumSulfideSlurry = new Material.Builder(Supersymmetry.id("impure_strontium_sulfide_slurry"))
                .liquid()
                .components(ImpureStrontiumSulfide, 1, Water, 1, SiliconDioxide, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedSodiumCarbonateSolution = new Material.Builder(Supersymmetry.id("diluted_sodium_carbonate_solution"))
                .liquid()
                .components(SodaAsh, 1, Water, 3)
                .colorAverage()
                .buildAndRegister();

        PalladiumOnCarbon = new Material.Builder(Supersymmetry.id("palladium_on_carbon"))
                .dust()
                .components(Palladium, 1, ActivatedCarbon, 4)
                .colorAverage()
                .buildAndRegister();

        ManganeseIIChlorideSolution = new Material.Builder(Supersymmetry.id("manganese_ii_chloride_solution"))
                .liquid()
                .components(ManganeseIIChloride, 1, Water, 3)
                .colorAverage()
                .buildAndRegister();

        DilutedManganeseIIChlorideSolution = new Material.Builder(Supersymmetry.id("diluted_manganese_ii_chloride_solution"))
                .liquid()
                .components(ManganeseIIChloride, 1, Water, 6)
                .colorAverage()
                .buildAndRegister();

        PalladiumPrecursorSolution = new Material.Builder(Supersymmetry.id("palladium_precursor_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PalladiumChloride, 1, PhosphoricAcid, 1)
                .colorAverage()
                .buildAndRegister();

        SupportedPalladium = new Material.Builder(Supersymmetry.id("supported_palladium"))
                .dust()
                .components(PalladiumChloride, 1, Alumina, 1)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .buildAndRegister();

        MixedCyanideSolution = new Material.Builder(Supersymmetry.id("mixed_cyanide_solution"))
                .liquid()
                .components(SodiumCyanide, 2, Hydrogen, 2, Carbon, 2, Nitrogen, 2, Water, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NaCN)2(HCN)2(H2O)", true);


        ChlorinatedBeryl = new Material.Builder(Supersymmetry.id("chlorinated_beryl"))
                .gas(new FluidBuilder().temperature(1100))
                .components(BerylliumChloride, 3, AluminiumChloride, 2, SiliconTetrachloride, 6, CarbonMonoxide, 18)
                .colorAverage()
                .buildAndRegister();

        SupportedMolybdenumVanadium = new Material.Builder(Supersymmetry.id("supported_molybdenum_vanadium"))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .components(MolybdenumTrioxide, 1, VanadiumPentoxide, 1, Alumina, 1)
                .colorAverage()
                .buildAndRegister();

        IndiumChlorideSolution = new Material.Builder(Supersymmetry.id("indium_chloride_solution"))
                .liquid()
                .components(IndiumChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        TelluriumLiquor = new Material.Builder(Supersymmetry.id("tellurium_liquor"))
                .liquid()
                .components(Hydrogen, 2, Tellurium, 1, Oxygen, 4, SodiumSulfite, 1, Water, 1)
                .color(0x97bfb5)
                .buildAndRegister();

        CaesiumAluminaMixture = new Material.Builder(Supersymmetry.id("caesium_alumina_mixture"))
                .dust()
                .components(Caesium, 2, Oxygen, 1, Alumina, 1)
                .color(0x776ed4)
                .buildAndRegister();

        CaesiumChlorideSolution = new Material.Builder(Supersymmetry.id("caesium_chloride_solution"))
                .liquid()
                .components(CaesiumChloride, 2, Water, 3)
                .colorAverage()
                .buildAndRegister();

        RubidiumHydroxideSolution = new Material.Builder(Supersymmetry.id("rubidium_hydroxide_solution"))
                .liquid()
                .components(RubidiumHydroxide, 1, Water, 4)
                .colorAverage()
                .buildAndRegister();

        SodiumAlumSolution = new Material.Builder(Supersymmetry.id("sodium_alum_solution"))
                .liquid()
                .components(SodiumAlum, 1, Water, 4)
                .colorAverage()
                .buildAndRegister();
    }
}
