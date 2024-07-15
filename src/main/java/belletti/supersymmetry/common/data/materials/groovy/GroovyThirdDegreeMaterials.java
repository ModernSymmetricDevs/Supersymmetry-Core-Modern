package belletti.supersymmetry.common.data.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;

import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.*;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.Dichloroethane;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GroovyThirdDegreeMaterials {
    public static void register() {
        Supersymmetry.LOGGER.info("Registering Third Degree Materials!");

        DiethylEtherSolution = new Material.Builder(Supersymmetry.id("diethyl_ether_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        LithiumSolution = new Material.Builder(Supersymmetry.id("lithium_solution"))
                .liquid()
                .components(Lithium, 2)
                .colorAverage()
                .buildAndRegister();

        DimethylacetamideSolution = new Material.Builder(Supersymmetry.id("dimethylacetamide_solution"))
                .liquid()
                .components(Dimethylacetamide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        FurfuralSolution = new Material.Builder(Supersymmetry.id("furfural_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Furfural, 1, SulfuricAcid, 1, Water, 3)
                .colorAverage()
                .buildAndRegister();

        WackerCatalystSolution = new Material.Builder(Supersymmetry.id("wacker_catalyst_solution"))
                .liquid()
                .components(WackerCatalyst, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        TwoEthylanthraquinoneSolution = new Material.Builder(Supersymmetry.id("two_ethylanthraquinone_solution"))
                .liquid()
                .components(TwoEthylanthraquinone, 1, HydrogenPeroxide, 3)
                .colorAverage()
                .buildAndRegister();

        AcetamideSolution = new Material.Builder(Supersymmetry.id("acetamide_solution"))
                .liquid()
                .components(Butanone, 1, Acetamide, 1)
                .colorAverage()
                .buildAndRegister();

        HydrazineSolution = new Material.Builder(Supersymmetry.id("hydrazine_solution"))
                .liquid()
                .components(Hydrazine, 1, Ammonia, 2, Water, 4)
                .colorAverage()
                .buildAndRegister();

        LithiumHexafluorophosphateElectrolyte = new Material.Builder(Supersymmetry.id("lithium_hexafluorophosphate_electrolyte"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(LithiumHexafluorophosphate, 1, EthyleneCarbonate, 1)
                .colorAverage()
                .buildAndRegister();

        TNTSlurry = new Material.Builder(Supersymmetry.id("tnt_slurry"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TNT, 1, DilutedSulfuricAcid, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedDiTertButylPeroxide = new Material.Builder(Supersymmetry.id("diluted_di_tert_butyl_peroxide"))
                .liquid()
                .components(DiTertButylPeroxide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        TetrasodiumEthylenediaminetetraacetateSolution = new Material.Builder(Supersymmetry.id("tetrasodium_ethylenediaminetetraacetate_solution"))
                .liquid()
                .components(TetrasodiumEthylenediaminetetraacetate, 1, Water, 4)
                .colorAverage()
                .buildAndRegister();

        UreaSolution = new Material.Builder(Supersymmetry.id("urea_solution"))
                .liquid()
                .components(Urea, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DiiodobenzeneSolution = new Material.Builder(Supersymmetry.id("diiodobenzene_solution"))
                .liquid()
                .components(Ethanol, 1, Diiodobenzene, 1)
                .colorAverage()
                .buildAndRegister();

        ImpureFourFourOxydianiline = new Material.Builder(Supersymmetry.id("impure_four_four_oxydianiline"))
                .liquid()
                .components(Ethanol, 2, Water, 5, FourFourOxydianiline, 1, AmmoniumIodide, 4)
                .colorAverage()
                .buildAndRegister();

        EthyleneGlycolSolution = new Material.Builder(Supersymmetry.id("ethylene_glycol_solution"))
                .liquid()
                .components(EthyleneGlycol, 1, Water, 2, SodiumHydroxide, 3)
                .colorAverage()
                .buildAndRegister();

        TerephthalicAcidSlurry = new Material.Builder(Supersymmetry.id("terephthalic_acid_slurry"))
                .liquid()
                .components(AceticAcid, 1, Water, 1, TerephthalicAcid, 1)
                .colorAverage()
                .buildAndRegister();

        CelluloseAcetateSolution = new Material.Builder(Supersymmetry.id("cellulose_acetate_solution"))
                .liquid()
                .components(Acetone, 1, CelluloseAcetate, 1)
                .colorAverage()
                .buildAndRegister();

        TwoButanolSolution = new Material.Builder(Supersymmetry.id("two_butanol_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, 1, TwoButanol, 1)
                .colorAverage()
                .buildAndRegister();

        FourFourOxydianilineSlurry = new Material.Builder(Supersymmetry.id("four_four_oxydianiline_slurry"))
                .liquid()
                .components(FourFourOxydianiline, 1, Water, 5)
                .colorAverage()
                .buildAndRegister();

        DiglycolicAcidSolution = new Material.Builder(Supersymmetry.id("diglycolic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(DiglycolicAcid, 1, AmmoniaSolution, 1, Ethanol, 1)
                .colorAverage()
                .buildAndRegister();

        DiTwoEthylhexylPhosphoricAcidSolution = new Material.Builder(Supersymmetry.id("di_two_ethylhexyl_phosphoric_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(DiTwoEthylhexylPhosphoricAcid, 1, Hexane, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedChloroaceticAnhydride = new Material.Builder(Supersymmetry.id("diluted_chloroacetic_anhydride"))
                .liquid()
                .components(ChloroaceticAnhydride, 1, Pyridine, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        ZirconiumTetrachlorideTetrahydrofuranComplex = new Material.Builder(Supersymmetry.id("zirconium_tetrachloride_tetrahydrofuran_complex"))
                .dust()
                .components(ZirconiumTetrachloride, 1, Tetrahydrofuran, 2)
                .colorAverage()
                .buildAndRegister();

        DilutedTwoEthylTwoHexenal = new Material.Builder(Supersymmetry.id("diluted_two_ethyl_two_hexenal"))
                .liquid()
                .components(TwoEthylTwoHexenal, 1, DilutedSodiumHydroxideSolution, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumButylXanthateSolution = new Material.Builder(Supersymmetry.id("potassium_butyl_xanthate_solution"))
                .liquid()
                .components(PotassiumButylXanthate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedMethylIsobutylKetone = new Material.Builder(Supersymmetry.id("diluted_methyl_isobutyl_ketone"))
                .liquid()
                .components(MethylIsobutylKetone, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedTwoEthylhexylNitrate = new Material.Builder(Supersymmetry.id("diluted_two_ethylhexyl_nitrate"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TwoEthylhexylNitrate, 1, Water, 1, SulfuricAcid, 1)
                .colorAverage()
                .buildAndRegister();

        HydratedMagnesiumChlorideGlycolate = new Material.Builder(Supersymmetry.id("hydrated_magnesium_chloride_glycolate"))
                .liquid()
                .components(MagnesiumChloride, 1, Water, 2, EthyleneGlycol, 3)
                .colorAverage()
                .buildAndRegister();

        MagnesiumChlorideGlycolate = new Material.Builder(Supersymmetry.id("magnesium_chloride_glycolate"))
                .liquid()
                .components(MagnesiumChloride, 1, EthyleneGlycol, 3)
                .colorAverage()
                .buildAndRegister();

        DilutedDiisopropylamine = new Material.Builder(Supersymmetry.id("diluted_diisopropylamine"))
                .liquid()
                .components(Diisopropylamine, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        PerfluorooctanoicAcidMixture = new Material.Builder(Supersymmetry.id("perfluorooctanoic_acid_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PerfluorooctanoicAcid, 1, HydrofluoricAcid, 1)
                .colorAverage()
                .buildAndRegister();

        FluorinatedSurfactantMixture = new Material.Builder(Supersymmetry.id("fluorinated_surfactant_mixture"))
                .liquid()
                .components(PerfluorooctanoicAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumEthylXanthateSolution = new Material.Builder(Supersymmetry.id("sodium_ethyl_xanthate_solution"))
                .liquid()
                .components(SodiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumAmylXanthateSolution = new Material.Builder(Supersymmetry.id("potassium_amyl_xanthate_solution"))
                .liquid()
                .components(PotassiumAmylXanthate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumIsobutylXanthateSolution = new Material.Builder(Supersymmetry.id("sodium_isobutyl_xanthate_solution"))
                .liquid()
                .components(SodiumIsobutylXanthate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumIsopropylXanthateSolution = new Material.Builder(Supersymmetry.id("potassium_isopropyl_xanthate_solution"))
                .liquid()
                .components(PotassiumIsopropylXanthate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PotassiumEthylXanthateSolution = new Material.Builder(Supersymmetry.id("potassium_ethyl_xanthate_solution"))
                .liquid()
                .components(PotassiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AcidicTributylPhosphate = new Material.Builder(Supersymmetry.id("acidic_tributyl_phosphate"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TributylPhosphate, 1, HydrogenChloride, 3)
                .colorAverage()
                .buildAndRegister();

        PhosgeneSolution = new Material.Builder(Supersymmetry.id("phosgene_solution"))
                .liquid()
                .components(Phosgene, 1, Dichloromethane, 1)
                .colorAverage()
                .buildAndRegister();

        TriethylamineSolution = new Material.Builder(Supersymmetry.id("triethylamine_solution"))
                .liquid()
                .components(Triethylamine, 1, Dichloromethane, 4)
                .colorAverage()
                .buildAndRegister();

        KaminskyCatalyst = new Material.Builder(Supersymmetry.id("kaminsky_catalyst"))
                .dust()
                .components(ZirconoceneDichloride, 1, Methylaluminoxane, 1)
                .colorAverage()
                .buildAndRegister();

        TNPSlurry = new Material.Builder(Supersymmetry.id("tnp_slurry"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PicricAcid, 1, DilutedSulfuricAcid, 1)
                .colorAverage()
                .buildAndRegister();

        IsophthaloylChlorideSolution = new Material.Builder(Supersymmetry.id("isophthaloyl_chloride_solution"))
                .liquid()
                .components(Dichloroethane, 1, IsophthaloylChloride, 1)
                .colorAverage()
                .buildAndRegister();

        IsophthalicAcidSlurry = new Material.Builder(Supersymmetry.id("isophthalic_acid_slurry"))
                .liquid()
                .components(Water, 1, Dichloroethane, 1, IsophthalicAcid, 1)
                .colorAverage()
                .buildAndRegister();

        DichloroethaneIsophthalicAcidSolution = new Material.Builder(Supersymmetry.id("dichloroethane_isophthalic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Dichloroethane, 1, IsophthalicAcid, 1)
                .colorAverage()
                .buildAndRegister();

        TetrahydrofuranSolution = new Material.Builder(Supersymmetry.id("tetrahydrofuran_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tetrahydrofuran, 1, SulfuricAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AcidicTriethylPhosphate = new Material.Builder(Supersymmetry.id("acidic_triethyl_phosphate"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TriethylPhosphate, 1, HydrogenChloride, 3)
                .color(0x4639ee)
                .buildAndRegister();

        NickelIIBisacetylacetonateSolution = new Material.Builder(Supersymmetry.id("nickel_ii_bisacetylacetonate_solution"))
                .liquid()
                .components(NickelIIBisacetylacetonate, 1, SodiumNitrate, 2, Water, 2)
                .color(0x3e5051)
                .buildAndRegister();

        ShellHigherOlefinCatalystSolution = new Material.Builder(Supersymmetry.id("shell_higher_olefin_catalyst_solution"))
                .liquid()
                .components(Nickel, 1, DiphenylphosphinoaceticAcid, 1, Cyclooctadiene, 2, EthyleneGlycol, 1)
                .color(0x9c1012)
                .buildAndRegister();

        AcidicNitrobenzeneMixture = new Material.Builder(Supersymmetry.id("acidic_nitrobenzene_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Nitrobenzene, 1, SulfuricAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DichlorobistriphenylphosphinenickelII = new Material.Builder(Supersymmetry.id("dichlorobistriphenylphosphinenickel_ii"))
                .dust()
                .components(Nickel, 1, Chlorine, 2, Triphenylphosphine, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("NiCl2(PPh3)2", true);


        DicarbonylbistriphenylphosphinenickelZero = new Material.Builder(Supersymmetry.id("dicarbonylbistriphenylphosphinenickel_zero"))
                .dust()
                .components(Nickel, 1, Carbon, 2, Oxygen, 2, Triphenylphosphine, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Ni(CO)2(PPh)2", true);


        SodiumPhenoxideSolution = new Material.Builder(Supersymmetry.id("sodium_phenoxide_solution"))
                .liquid()
                .components(SodiumPhenoxide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        WetEpoxy = new Material.Builder(Supersymmetry.id("wet_epoxy"))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Epoxy, 1)
                .color(0xa16f0d)
                .buildAndRegister();

        TetrabromobisphenolASolution = new Material.Builder(Supersymmetry.id("tetrabromobisphenol_a_solution"))
                .liquid()
                .components(TetrabromobisphenolA, 1, Dichloroethane, 6)
                .colorAverage()
                .buildAndRegister();

        EpoxyCuringMixture = new Material.Builder(Supersymmetry.id("epoxy_curing_mixture"))
                .dust()
                .components(Dicyandiamide, 1, TwoMethylimidazole, 1, PhthalicAnhydride, 1)
                .colorAverage()
                .buildAndRegister();

        WetFlameRetardantEpoxy = new Material.Builder(Supersymmetry.id("wet_flame_retardant_epoxy"))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(FlameRetardantEpoxy, 1)
                .color(0xa1530b)
                .buildAndRegister();

        PropyleneOxideSolution = new Material.Builder(Supersymmetry.id("propylene_oxide_solution"))
                .liquid()
                .components(CalciumChloride, 1, PropyleneOxide, 2, Water, 2)
                .colorAverage()
                .buildAndRegister();

        OrthoParaXyleneMixture = new Material.Builder(Supersymmetry.id("ortho_para_xylene_mixture"))
                .liquid()
                .components(OrthoXylene, 60, ParaXylene, 40)
                .colorAverage()
                .buildAndRegister();

        HydrogenSilsesquioxanePhotoresist = new Material.Builder(Supersymmetry.id("hydrogen_silsesquioxane_photoresist"))
                .liquid()
                .components(HydrogenSilsesquioxane, 1, MethylIsobutylKetone, 99)
                .colorAverage()
                .buildAndRegister();

        CrudeTerephthalicAcidSlurry = new Material.Builder(Supersymmetry.id("crude_terephthalic_acid_slurry"))
                .liquid()
                .components(AmocoTerephthalicAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        CrudeIsophthalicAcidSlurry = new Material.Builder(Supersymmetry.id("crude_isophthalic_acid_slurry"))
                .liquid()
                .components(AmocoIsophthalicAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        HydrogenatedTerephthalicAcidSlurry = new Material.Builder(Supersymmetry.id("hydrogenated_terephthalic_acid_slurry"))
                .liquid()
                .components(TerephthalicAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        HydrogenatedIsophthalicAcidSlurry = new Material.Builder(Supersymmetry.id("hydrogenated_isophthalic_acid_slurry"))
                .liquid()
                .components(IsophthalicAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AmocoPurificationMotherLiquor = new Material.Builder(Supersymmetry.id("amoco_purification_mother_liquor"))
                .liquid()
                .components(MethylParaToluate, 1, Water, 100)
                .colorAverage()
                .buildAndRegister();

        ParaToluateMixture = new Material.Builder(Supersymmetry.id("para_toluate_mixture"))
                .liquid(new FluidBuilder().temperature(540))
                .components(Carbon, 9, Hydrogen, 8, Oxygen, 4, ParaToluicAcid, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(C10H10O4)(C9H8O4)", true);


        CrudeDimethylTerephthalateSolution = new Material.Builder(Supersymmetry.id("crude_dimethyl_terephthalate_solution"))
                .liquid()
                .components(CrudeDimethylTerephthalate, 1, Methanol, 1)
                .colorAverage()
                .buildAndRegister();

        TerephthalateMotherLiquor = new Material.Builder(Supersymmetry.id("terephthalate_mother_liquor"))
                .liquid()
                .components(CrudeDimethylTerephthalate, 1, Methanol, 2)
                .colorAverage()
                .buildAndRegister();

        MethylParaToluateMixture = new Material.Builder(Supersymmetry.id("methyl_para_toluate_mixture"))
                .liquid(new FluidBuilder().temperature(540))
                .components(MethylParaToluate, 1, DimethylTerephthalate, 1)
                .colorAverage()
                .buildAndRegister();

        SodiumDodecylSulfateSolution = new Material.Builder(Supersymmetry.id("sodium_dodecyl_sulfate_solution"))
                .liquid()
                .components(SodiumDodecylSulfate, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumCyclopentadienideSolution = new Material.Builder(Supersymmetry.id("sodium_cyclopentadienide_solution"))
                .liquid()
                .components(Sodium, 1, Carbon, 5, Hydrogen, 5, Tetrahydrofuran, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NaC5H5)(C4H8O)", true);

        MethylcyclopentadieneSolution = new Material.Builder(Supersymmetry.id("methylcyclopentadiene_solution"))
                .liquid()
                .components(Methylcyclopentadiene, 1, Tetrahydrofuran, 1, Salt, 2)
                .colorAverage()
                .buildAndRegister();

        BismethylcyclopentadienylmanganeseSolution = new Material.Builder(Supersymmetry.id("bismethylcyclopentadienylmanganese_solution"))
                .liquid()
                .components(Bismethylcyclopentadienylmanganese, 1, Diglyme, 1, Salt, 2)
                .colorAverage()
                .buildAndRegister();

        DilutedNitromethane = new Material.Builder(Supersymmetry.id("diluted_nitromethane"))
                .liquid()
                .components(Nitromethane, 3, Water, 1)
                .colorAverage()
                .buildAndRegister();

        EthyleneVinylAcetateSuspension = new Material.Builder(Supersymmetry.id("ethylene_vinyl_acetate_suspension"))
                .liquid()
                .components(EthyleneVinylAcetate, 1, Methanol, 1)
                .colorAverage()
                .buildAndRegister();

        EthyleneIsobutyleneVinylAcetateSuspension = new Material.Builder(Supersymmetry.id("ethylene_isobutylene_vinyl_acetate_suspension"))
                .liquid()
                .components(EthyleneIsobutyleneVinylAcetate, 1, Methanol, 1)
                .colorAverage()
                .buildAndRegister();

        DewaxingSolvent = new Material.Builder(Supersymmetry.id("dewaxing_solvent"))
                .liquid()
                .components(Dichloroethane, 1, Dichloromethane, 1)
                .colorAverage()
                .buildAndRegister();

        OlefinPolymerizationInitiator = new Material.Builder(Supersymmetry.id("olefin_polymerization_initiator"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(NButanol, 1, BoronTrifluoride, 3)
                .colorAverage()
                .buildAndRegister();

        TrimelliticAcidSlurry = new Material.Builder(Supersymmetry.id("trimellitic_acid_slurry"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TrimelliticAcid, 1, AceticAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        CalciumSalicylateSolution = new Material.Builder(Supersymmetry.id("calcium_salicylate_solution"))
                .liquid()
                .components(CalciumSalicylate, 1, DiethyleneGlycol, 1)
                .colorAverage()
                .buildAndRegister();

        AcidicTricresylPhosphate = new Material.Builder(Supersymmetry.id("acidic_tricresyl_phosphate"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TricresylPhosphate, 1, HydrogenChloride, 3)
                .colorAverage()
                .buildAndRegister();

        ChloroaceticAcidSolution = new Material.Builder(Supersymmetry.id("chloroacetic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroaceticAcid, 1, SulfuricAcid, 2)
                .colorAverage()
                .buildAndRegister();

        OrthoPhenylenediamineSlurry = new Material.Builder(Supersymmetry.id("ortho_phenylenediamine_slurry"))
                .liquid()
                .components(OrthoPhenylenediamine, 1, Toluene, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        NomexPolymerizationMix = new Material.Builder(Supersymmetry.id("nomex_polymerization_mix"))
                .liquid()
                .components(Nomex, 1, CalciumChloride, 1, Dimethylacetamide, 4)
                .colorAverage()
                .buildAndRegister();

        KevlarPolymerizationMix = new Material.Builder(Supersymmetry.id("kevlar_polymerization_mix"))
                .liquid()
                .components(Kevlar, 1, CalciumChloride, 1, Dimethylacetamide, 4)
                .colorAverage()
                .buildAndRegister();

        SpentDimethylacetamide = new Material.Builder(Supersymmetry.id("spent_dimethylacetamide"))
                .liquid()
                .components(CalciumChloride, 1, Dimethylacetamide, 4)
                .colorAverage()
                .buildAndRegister();

        SodiumCelluloseXanthateSolution = new Material.Builder(Supersymmetry.id("sodium_cellulose_xanthate_solution"))
                .liquid()
                .components(SodiumCelluloseXanthate, 1, SodiumHydroxide, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        CrotonaldehydeMixture = new Material.Builder(Supersymmetry.id("crotonaldehyde_mixture"))
                .liquid()
                .components(SodiumHydroxide, 1, Crotonaldehyde, 1)
                .colorAverage()
                .buildAndRegister();

        GaseousMethacrylicAcidMixture = new Material.Builder(Supersymmetry.id("gaseous_methacrylic_acid_mixture"))
                .gas(new FluidBuilder().temperature(434))
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 1, MethacrylicAcid, 3, Water, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(C4H6O)(C4H6O2)3(H2O)4", true);


        MethacrylicAcidSolution = new Material.Builder(Supersymmetry.id("methacrylic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(MethacrylicAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AcidicChlorodifluoromethane = new Material.Builder(Supersymmetry.id("acidic_chlorodifluoromethane"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorodifluoromethane, 1, HydrogenChloride, 2)
                .color(0xbd97c7)
                .buildAndRegister();

        SaltyNMethylTwoPyrrolidone = new Material.Builder(Supersymmetry.id("salty_n_methyl_two_pyrrolidone"))
                .liquid()
                .components(NMethylTwoPyrrolidone, 1, Salt, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedNMethylTwoPyrrolidone = new Material.Builder(Supersymmetry.id("diluted_n_methyl_two_pyrrolidone"))
                .liquid()
                .components(NMethylTwoPyrrolidone, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        DilutedButyllithium = new Material.Builder(Supersymmetry.id("diluted_butyllithium"))
                .liquid()
                .components(Butyllithium, 1, DiethylEther, 1)
                .colorAverage()
                .buildAndRegister();

        SpentPBISolution = new Material.Builder(Supersymmetry.id("spent_pbi_solution"))
                .liquid()
                .components(Dimethylacetamide, 1)
                .colorAverage()
                .buildAndRegister();

        OxalicAcidSolution = new Material.Builder(Supersymmetry.id("oxalic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(OxalicAcid, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        GalliumSulfateSolution = new Material.Builder(Supersymmetry.id("gallium_sulfate_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Gallium, 2, Sulfur, 3, Oxygen, 12, OxalicAcid, 6, Water, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Ga2(SO4)3)(H2C2O4)6(H2O)3", true);


        FormicAcidWaterAzeotrope = new Material.Builder(Supersymmetry.id("formic_acid_water_azeotrope"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(GroovySuSyMaterials.FormicAcid, 6, Water, 4)
                .color(0xbf3983)
                .buildAndRegister();
    }
}
