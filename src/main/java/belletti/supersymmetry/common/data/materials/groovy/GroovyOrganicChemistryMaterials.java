package belletti.supersymmetry.common.data.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.data.materials.properties.FiberProperty;
import belletti.supersymmetry.common.data.materials.properties.SuSyPropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;

import static belletti.supersymmetry.common.data.materials.SuSyMaterialFlags.GENERATE_CATALYST_BED;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GroovyOrganicChemistryMaterials {
    public static void register() {

        Supersymmetry.LOGGER.info("Registering Organic Chemistry Materials!");

        FourChloronitrobenzene = new Material.Builder(Supersymmetry.id("four_chloronitrobenzene"))
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        FourNitroaniline = new Material.Builder(Supersymmetry.id("four_nitroaniline"))
                .dust()
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        ParaPhenylenediamine = new Material.Builder(Supersymmetry.id("para_phenylenediamine"))
                .dust()
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        TwoTwoDichlorohydrazobenzene = new Material.Builder(Supersymmetry.id("two_two_dichlorohydrazobenzene"))
                .dust()
                .components(Carbon, 12, Hydrogen, 10, Chlorine, 2, Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumPhenoxide = new Material.Builder(Supersymmetry.id("sodium_phenoxide"))
                .dust()
                .components(Carbon, 6, Hydrogen, 5, Sodium, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        IsophthaloylChloride = new Material.Builder(Supersymmetry.id("isophthaloyl_chloride"))
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        CaprolactamOxime = new Material.Builder(Supersymmetry.id("caprolactam_oxime"))
                .dust()
                .components(Carbon, 6, Hydrogen, 11, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        TNT = new Material.Builder(Supersymmetry.id("tnt"))
                .dust()
                .components(Carbon, 7, Hydrogen, 5, Nitrogen, 3, Oxygen, 6)
                .color(0xacb38d)
                .buildAndRegister();

        Polystyrene = new Material.Builder(Supersymmetry.id("polystyrene"))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(513))
                .components(Carbon, 8, Hydrogen, 8)
                .color(0xa2a389)
                .buildAndRegister();

        OneTwoDichlorobenzene = new Material.Builder(Supersymmetry.id("one_two_dichlorobenzene"))
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        PolyvinylideneFluorine = new Material.Builder(Supersymmetry.id("polyvinylidene_fluoride"))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(468))
                .color(0xfde3ff)
                .flags(GENERATE_FOIL)
                .components(Carbon, 2, Hydrogen, 2, Fluorine, 2)
                .buildAndRegister();

        Methylenedianiline = new Material.Builder(Supersymmetry.id("methylenedianiline"))
                .dust()
                .components(Carbon, 13, Hydrogen, 14, Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        MethyleneDiphenylDiisocyanate = new Material.Builder(Supersymmetry.id("methylene_diphenyl_diisocyanate"))
                .dust()
                .components(Carbon, 15, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        EthyleneCarbonate = new Material.Builder(Supersymmetry.id("ethylene_carbonate"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 3)
                .color(0x348060)
                .buildAndRegister();

        Rayon = new Material.Builder(Supersymmetry.id("rayon"))
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .color(0xaee8d9)
                .buildAndRegister()
                .setFormula("C6H5(OH)4OH", true);

        Rayon.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(true, false, true));

        AlkaliCellulose = new Material.Builder(Supersymmetry.id("alkali_cellulose"))
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Sodium, 1)
                .color(0x7d6547)
                .buildAndRegister();

        SodiumCelluloseXanthate = new Material.Builder(Supersymmetry.id("sodium_cellulose_xanthate"))
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Carbon, 1, Sulfur, 2, Sodium, 1)
                .color(0x7d6057)
                .buildAndRegister();

        PMMA = new Material.Builder(Supersymmetry.id("pmma"))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(438))
                .color(0x72e0c9)
                .flags(GENERATE_FOIL)
                .components(Carbon, 5, Oxygen, 2, Hydrogen, 8)
                .buildAndRegister();

        PhthalicAnhydride = new Material.Builder(Supersymmetry.id("phthalic_anhydride"))
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        TributylPhosphate = new Material.Builder(Supersymmetry.id("tributyl_phosphate"))
                .liquid()
                .components(Carbon, 12, Hydrogen, 27, Oxygen, 4, Phosphorus, 1)
                .color(0xf5e3b3)
                .buildAndRegister();

        CrudeStyrene = new Material.Builder(Supersymmetry.id("crude_styrene"))
                .liquid()
                .color(0x4d4d3e)
                .buildAndRegister();

        ChlorinatedMethaneMixture = new Material.Builder(Supersymmetry.id("chlorinated_methane_mixture"))
                .liquid()
                .color(0x8327d9)
                .buildAndRegister();

        ChlorinatedChloromethaneMixture = new Material.Builder(Supersymmetry.id("chlorinated_chloromethane_mixture"))
                .liquid()
                .color(0x6124bd)
                .buildAndRegister();

        ChlorinatedDichloromethaneMixture = new Material.Builder(Supersymmetry.id("chlorinated_dichloromethane_mixture"))
                .liquid()
                .color(0x4922a3)
                .buildAndRegister();

        ChloromethaneSolution = new Material.Builder(Supersymmetry.id("chloromethane_solution"))
                .liquid()
                .components(Chloromethane, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        //FREE ID: 15025

        AcidicTetrafluoroethylene = new Material.Builder(Supersymmetry.id("acidic_tetrafluoroethylene"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tetrafluoroethylene, 1, HydrogenChloride, 4)
                .color(0x726678)
                .buildAndRegister();

        TrinitromethaneSolution = new Material.Builder(Supersymmetry.id("trinitromethane_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x333c52)
                .buildAndRegister();

        TetranitronmethaneSolution = new Material.Builder(Supersymmetry.id("tetranitromethane_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tetranitromethane, 1, SulfuricAcid, 1, Water, 3)
                .color(0x373352)
                .buildAndRegister();

        ImpureDimethyldichlorosilane = new Material.Builder(Supersymmetry.id("impure_dimethyldichlorosilane"))
                .liquid()
                .color(0x291e38)
                .buildAndRegister();

        ChlorinatedGlycerol = new Material.Builder(Supersymmetry.id("chlorinated_glycerol"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        EpichlorohydrinSolution = new Material.Builder(Supersymmetry.id("epichlorohydrin_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Epichlorohydrin, 1, Salt, 1, Water, 3)
                .color(0x9c6241)
                .buildAndRegister();

        AllylAlcoholMix = new Material.Builder(Supersymmetry.id("allyl_alcohol_mix"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xbede9b)
                .buildAndRegister();

        DilutedEpichlorohydrin = new Material.Builder(Supersymmetry.id("diluted_epichlorohydrin"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Epichlorohydrin, 1, Salt, 1, Water, 1)
                .color(0x91664d)
                .buildAndRegister();

        Isobutane = new Material.Builder(Supersymmetry.id("isobutane"))
                .gas()
                .components(Carbon, 4, Hydrogen, 10)
                .color(0x8a7566)
                .buildAndRegister();

        Isobutylene = new Material.Builder(Supersymmetry.id("isobutylene"))
                .gas()
                .components(Carbon, 4, Hydrogen, 8)
                .color(0x917d61)
                .buildAndRegister();

        TriarylsulfoniumHexafluoroantimonate = new Material.Builder(Supersymmetry.id("triarylsulfonium_hexafluoroantimonate"))
                .dust()
                .components(Carbon, 24, Hydrogen, 19, Fluorine, 6, Sulfur, 2, Antimony, 1)
                .color(0x31a374)
                .buildAndRegister();

        NMethylTwoPyrrolidone = new Material.Builder(Supersymmetry.id("n_methyl_two_pyrrolidone"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        //FREE ID: 15038

        MethylAcetateSolution = new Material.Builder(Supersymmetry.id("methyl_acetate_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, 1, MethylAcetate, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        TwoChloronitrobenzene = new Material.Builder(Supersymmetry.id("two_chloronitrobenzene"))
                .dust().liquid(new FluidBuilder().temperature(306))
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                .color(0xc7c944)
                .buildAndRegister();

        MixedChloronitrobenzene = new Material.Builder(Supersymmetry.id("mixed_chloronitrobenzene"))
                .dust().liquid(new FluidBuilder().temperature(330))
                .color(0xa4a644)
                .buildAndRegister();

        FourNitroanilineSolution = new Material.Builder(Supersymmetry.id("four_nitroaniline_solution"))
                .liquid()
                .components(Toluene, 1, FourNitroaniline, 1)
                .colorAverage()
                .buildAndRegister();

        ParaPhenylenediamineSolution = new Material.Builder(Supersymmetry.id("para_phenylenediamine_solution"))
                .liquid()
                .components(Toluene, 1, ParaPhenylenediamine, 1)
                .colorAverage()
                .buildAndRegister();

        //FREE ID: 15044

        DichlorobenzidineSolution = new Material.Builder(Supersymmetry.id("dichlorobenzidine_solution"))
                .liquid()
                .components(Toluene, 1, Dichlorobenzidine, 1)
                .colorAverage()
                .buildAndRegister();

        Xylene = new Material.Builder(Supersymmetry.id("xylene"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x2e281f)
                .buildAndRegister();

        Phosgene = new Material.Builder(Supersymmetry.id("phosgene"))
                .liquid()
                .components(Carbon, 1, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        GroovySuSyMaterials.Dichloroethane = new Material.Builder(Supersymmetry.id("dichloroethane"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        Propionaldehyde = new Material.Builder(Supersymmetry.id("propionaldehyde"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 1)
                .color(0x917b0f)
                .buildAndRegister();

        Cyclohexylamine = new Material.Builder(Supersymmetry.id("cyclohexylamine"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 13, Nitrogen, 1)
                .color(0xbfba8c)
                .buildAndRegister();

        DiphenylIsophthalateSolution = new Material.Builder(Supersymmetry.id("diphenyl_isophthalate_solution"))
                .liquid()
                .components(DiphenylIsophtalate, 1, GroovySuSyMaterials.Dichloroethane, 1)
                .colorAverage()
                .buildAndRegister();

        DiaminobenzidineSolution = new Material.Builder(Supersymmetry.id("diaminobenzidine_solution"))
                .liquid()
                .components(Diaminobenzidine, 1, Toluene, 1)
                .colorAverage()
                .buildAndRegister();

        //FREE ID: 15053

        PBIFoam = new Material.Builder(Supersymmetry.id("pbi_foam"))
                .dust()
                .color(0x332d28)
                .buildAndRegister();

        PBIPrepolymer = new Material.Builder(Supersymmetry.id("pbi_prepolymer"))
                .dust()
                .color(0x292623)
                .buildAndRegister();

        Dimethylacetamide = new Material.Builder(Supersymmetry.id("dimethylacetamide"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        PBISolution = new Material.Builder(Supersymmetry.id("pbi_solution"))
                .liquid()
                .components(Dimethylacetamide, 1, Polybenzimidazole, 1)
                .color(0x171410)
                .buildAndRegister();

        PBIWaste = new Material.Builder(Supersymmetry.id("pbi_waste"))
                .liquid()
                .color(0x202226)
                .buildAndRegister();

        Hydroxylamine = new Material.Builder(Supersymmetry.id("hydroxylamine"))
                .liquid(new FluidBuilder().temperature(306))
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        Cyclohexanone = new Material.Builder(Supersymmetry.id("cyclohexanone"))
                .liquid()
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .color(0x2b1e11)
                .buildAndRegister();

        NHexadecylammoniumAcetate = new Material.Builder(Supersymmetry.id("n_hexadecylammonium_acetate"))
                .dust()
                .components(Carbon, 16, Hydrogen, 39, Nitrogen, 1, Oxygen, 2)
                .color(0xffd4d4)
                .buildAndRegister();

        CaprolactamSolution = new Material.Builder(Supersymmetry.id("caprolactam_solution"))
                .liquid()
                .components(AmmoniumSulfate, 1, Caprolactam, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        Chlorotrimethylsilane = new Material.Builder(Supersymmetry.id("chlorotrimethylsilane"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 9, Silicon, 1, Chlorine, 1)
                .color(0xd9dddc)
                .buildAndRegister()
                .setFormula("(CH3)3SiCl", true);


        Methyldichlorosilane = new Material.Builder(Supersymmetry.id("methyldichlorosilane"))
                .liquid()
                .components(Carbon, 1, Hydrogen, 4, Chlorine, 2, Silicon, 1)
                .color(0xd9dddc)
                .buildAndRegister()
                .setFormula("CH3Cl2SiH", true);


        Methyltrichlorosilane = new Material.Builder(Supersymmetry.id("methyltrichlorosilane"))
                .liquid()
                .components(Carbon, 1, Hydrogen, 3, Silicon, 1, Chlorine, 3)
                .color(0xd9dddc)
                .buildAndRegister()
                .setFormula("CH3SiCl3", true);


        //FREE ID: 15066

        VinylChlorideSuspension = new Material.Builder(Supersymmetry.id("vinyl_chloride_suspension"))
                .liquid()
                .components(VinylChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PolyvinylChlorideSuspension = new Material.Builder(Supersymmetry.id("polyvinyl_chloride_suspension"))
                .liquid()
                .components(PolyvinylChloride, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        StyreneSuspension = new Material.Builder(Supersymmetry.id("styrene_suspension"))
                .liquid()
                .components(Styrene, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        PolystyreneSuspension = new Material.Builder(Supersymmetry.id("polystyrene_suspension"))
                .liquid()
                .components(Polystyrene, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        VinylAcetateSuspension = new Material.Builder(Supersymmetry.id("vinyl_acetate_suspension"))
                .liquid()
                .components(Methanol, 1, VinylAcetate, 1)
                .colorAverage()
                .buildAndRegister();

        PolyvinylAcetateSuspension = new Material.Builder(Supersymmetry.id("polyvinyl_acetate_suspension"))
                .liquid()
                .components(Methanol, 1, PolyvinylAcetate, 1)
                .colorAverage()
                .buildAndRegister();

        Bleach = new Material.Builder(Supersymmetry.id("bleach"))
                .liquid()
                .components(Sodium, 1, Chlorine, 1, Oxygen, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        ImpureBleach = new Material.Builder(Supersymmetry.id("impure_bleach"))
                .liquid()
                .components(Bleach, 1, Salt, 1, Water, 3)
                .colorAverage()
                .buildAndRegister();

        OneFourDichlorobenzeneSolution = new Material.Builder(Supersymmetry.id("one_four_dichlorobenzene_solution"))
                .liquid()
                .components(Toluene, 1, Dichlorobenzene, 1)
                .colorAverage()
                .buildAndRegister();

        OneTwoDichlorobenzeneSolution = new Material.Builder(Supersymmetry.id("one_two_dichlorobenzene_solution"))
                .liquid()
                .components(Toluene, 1, OneTwoDichlorobenzene, 1)
                .colorAverage()
                .buildAndRegister();

        StyreneButadieneSolution = new Material.Builder(Supersymmetry.id("styrene_butadiene_solution"))
                .liquid()
                .components(Styrene, 1, Butadiene, 3, Ethanol, 1)
                .colorAverage()
                .buildAndRegister();

        OneBromobutane = new Material.Builder(Supersymmetry.id("one_bromobutane"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .colorAverage()
                .buildAndRegister();

        //FREE ID: 15080

        Butyllithium = new Material.Builder(Supersymmetry.id("butyllithium"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                .colorAverage()
                .buildAndRegister();

        PolymerizedStyreneButadieneSolution = new Material.Builder(Supersymmetry.id("polymerized_styrene_butadiene_solution"))
                .liquid()
                .color(0x332e2c)
                .buildAndRegister();

        //FREE ID: 15084-15085

        Acetylene = new Material.Builder(Supersymmetry.id("acetylene"))
                .gas()
                .components(Carbon, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister();

        TetrapropylammoniumBromide = new Material.Builder(Supersymmetry.id("tetrapropylammonium_bromide"))
                .dust()
                .components(Carbon, 12, Hydrogen, 28, Bromine, 1, Nitrogen, 1)
                .color(0x916c0f)
                .buildAndRegister();

        GroovySuSyMaterials.Formaldehyde = new Material.Builder(Supersymmetry.id("formaldehyde"))
                .gas()
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        MethylamineMix = new Material.Builder(Supersymmetry.id("methylamine_mix"))
                .liquid()
                .color(0x6b4ea6)
                .buildAndRegister();

        Methylamine = new Material.Builder(Supersymmetry.id("methylamine"))
                .liquid()
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .color(0x794c91)
                .buildAndRegister()
                .setFormula("CH3NH2", true);

        Trimethylamine = new Material.Builder(Supersymmetry.id("trimethylamine"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .color(0x4c2461)
                .buildAndRegister();

        Butynediol = new Material.Builder(Supersymmetry.id("butynediol"))
                .liquid(new FluidBuilder().temperature(331))
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        Butanediol = new Material.Builder(Supersymmetry.id("butanediol"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        GammaButyrolactone = new Material.Builder(Supersymmetry.id("gamma_butyrolactone"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .color(0x4242f5)
                .buildAndRegister();

        //FREE ID: 15095

        DimethyldichlorosilaneEmulsion = new Material.Builder(Supersymmetry.id("dimethyldichlorosilane_emulsion"))
                .liquid()
                .color(0x542a4c)
                .buildAndRegister();

        TetrafluoroethyleneEmulsion = new Material.Builder(Supersymmetry.id("tetrafluoroethylene_emulsion"))
                .liquid()
                .color(0x3b2e38)
                .buildAndRegister();

        Dichloromethane = new Material.Builder(Supersymmetry.id("dichloromethane"))
                .liquid()
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        CarbonTetrachloride = new Material.Builder(Supersymmetry.id("carbon_tetrachloride"))
                .liquid()
                .components(Carbon, 1, Chlorine, 4)
                .colorAverage()
                .buildAndRegister();

        IsophthalicAcid = new Material.Builder(Supersymmetry.id("isophthalic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .color(0x8ac294)
                .buildAndRegister();

        NPropanol = new Material.Builder(Supersymmetry.id("n_propanol"))
                .liquid()
                .components()
                .color(0xad9113)
                .buildAndRegister()
                .setFormula("CH3CH2CH2OH", true);


        PolytetrafluoroethyleneSolution = new Material.Builder(Supersymmetry.id("polytetrafluoroethylene_solution"))
                .liquid()
                .components(Polytetrafluoroethylene, 1, Water, 1)
                .colorAverage()
                .buildAndRegister();

        AcidicChloronitrobenzeneMixture = new Material.Builder(Supersymmetry.id("acidic_chloronitrobenzene_mixture"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc18c18)
                .buildAndRegister();

        MixedDichlorobenzeneSolution = new Material.Builder(Supersymmetry.id("mixed_dichlorobenzene_solution"))
                .liquid()
                .color(0xFF7F7F)
                .buildAndRegister();

        Novolacs = new Material.Builder(Supersymmetry.id("novolacs"))
                .liquid()
                .color(0xbfa26f)
                .buildAndRegister();

        Ethanolamine = new Material.Builder(Supersymmetry.id("ethanolamine"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .color(0x56a6e3)
                .buildAndRegister();

        Diethanolamine = new Material.Builder(Supersymmetry.id("diethanolamine"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1, Oxygen, 2)
                .color(0x4296d6)
                .buildAndRegister();

        Triethanolamine = new Material.Builder(Supersymmetry.id("triethanolamine"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1, Oxygen, 3)
                .color(0x2e86c9)
                .buildAndRegister();

        EthyleneGlycol = new Material.Builder(Supersymmetry.id("ethylene_glycol"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .color(0x2e86c9)
                .buildAndRegister();

        EthyleneOxide = new Material.Builder(Supersymmetry.id("ethylene_oxide"))
                .gas()
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        EthanolamineMix = new Material.Builder(Supersymmetry.id("ethanolamine_mix"))
                .liquid()
                .color(0x3e86bd)
                .buildAndRegister();

        RichAmine = new Material.Builder(Supersymmetry.id("rich_amine"))
                .liquid()
                .color(0x3ea8bd)
                .buildAndRegister();

        Pentane = new Material.Builder(Supersymmetry.id("pentane"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 12)
                .color(0xe8e7be)
                .buildAndRegister();

        Hexane = new Material.Builder(Supersymmetry.id("hexane"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 14)
                .color(0xcfceb6)
                .buildAndRegister();

        Furfural = new Material.Builder(Supersymmetry.id("furfural"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 4, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        Cresol = new Material.Builder(Supersymmetry.id("cresol"))
                .liquid()
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 1)
                .color(0x827863)
                .buildAndRegister();

        Xylenol = new Material.Builder(Supersymmetry.id("xylenol"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .color(0x693834)
                .buildAndRegister();

        Creosol = new Material.Builder(Supersymmetry.id("creosol"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 2)
                .color(0x473339)
                .buildAndRegister();

        Anthracene = new Material.Builder(Supersymmetry.id("anthracene"))
                .dust()
                .components(Carbon, 14, Hydrogen, 10)
                .color(0x000000)
                .buildAndRegister();

        Triethylenediamine = new Material.Builder(Supersymmetry.id("triethylenediamine"))
                .dust()
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        Polyurethane = new Material.Builder(Supersymmetry.id("polyurethane"))
                .dust()
                .components(Carbon, 17, Hydrogen, 16, Nitrogen, 2, Oxygen, 4)
                .color(0xd1d1d1)
                .flags(NO_UNIFICATION, GENERATE_PLATE, FORCE_GENERATE_BLOCK)
                .buildAndRegister()
                .setFormula("(C15H10N2O2)(C2H6O2)", true);

        DiethylEther = new Material.Builder(Supersymmetry.id("diethyl_ether"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .color(0x2177ff)
                .buildAndRegister()
                .setFormula("(C2H5)2O", true);


        Polypropylene = new Material.Builder(Supersymmetry.id("polypropylene"))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(444))
                .components(Carbon, 3, Hydrogen, 6)
                .color(0xdfe39a)
                .flags(GENERATE_FOIL)
                .buildAndRegister();

        Dimethylformamide = new Material.Builder(Supersymmetry.id("dimethylformamide"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CH3)2NCH", true);

        CativaCatalyst = new Material.Builder(Supersymmetry.id("cativa_catalyst"))
                .dust()
                .color(0x695449)
                .buildAndRegister()
                .setFormula("[PPN][IrI2(CO)2]", true);

        TwoEthylanthraquinone = new Material.Builder(Supersymmetry.id("two_ethylanthraquinone"))
                .liquid()
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        TwoEthylanthrahydroquinone = new Material.Builder(Supersymmetry.id("two_ethylanthrahydroquinone"))
                .liquid()
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        Butanone = new Material.Builder(Supersymmetry.id("butanone"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        Durene = new Material.Builder(Supersymmetry.id("durene"))
                .dust()
                .components(Carbon, 10, Hydrogen, 14)
                .colorAverage()
                .buildAndRegister();

        PyromelliticDianhydride = new Material.Builder(Supersymmetry.id("pyromellitic_dianhydride"))
                .dust()
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .colorAverage()
                .buildAndRegister();

        FourFourOxydianiline = new Material.Builder(Supersymmetry.id("four_four_oxydianiline"))
                .dust()
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        KaptonK = new Material.Builder(Supersymmetry.id("kapton_k"))
                .polymer(1)
                .components(Carbon, 22, Hydrogen, 10, Nitrogen, 2, Oxygen, 5)
                .color(0xfabe19)
                .buildAndRegister();

        KaptonE = new Material.Builder(Supersymmetry.id("kapton_e"))
                .polymer(1)
                .components(Carbon, 22, Hydrogen, 10, Nitrogen, 2, Oxygen, 5)
                .color(0xdcfa19)
                .buildAndRegister();

        TwoButanol = new Material.Builder(Supersymmetry.id("two_butanol"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        Acetamide = new Material.Builder(Supersymmetry.id("acetamide"))
                .dust()
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        Hydrazine = new Material.Builder(Supersymmetry.id("hydrazine"))
                .liquid()
                .components(Nitrogen, 2, Hydrogen, 4)
                .colorAverage()
                .buildAndRegister();

//        Ethylenediamine = new Material.Builder(Supersymmetry.id("ethylenediamine"))
//                .liquid()
//                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
//                .colorAverage()
//                .buildAndRegister();

        Pyrocatechol = new Material.Builder(Supersymmetry.id("pyrocatechol"))
                .dust()
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        AcetoneCyanohydrin = new Material.Builder(Supersymmetry.id("acetone_cyanohydrin"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        MethylMethacrylate = new Material.Builder(Supersymmetry.id("methyl_methacrylate"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        MethylMethacrylateEmulsion = new Material.Builder(Supersymmetry.id("methyl_methacrylate_emulsion"))
                .liquid()
                .color(0x789c94)
                .buildAndRegister();

        PolymethylMethacrylateSolution = new Material.Builder(Supersymmetry.id("polymethyl_methacrylate_solution"))
                .liquid()
                .color(0x79baad)
                .buildAndRegister();

        PolystyreneSulfonate = new Material.Builder(Supersymmetry.id("polystyrene_sulfonate"))
                .polymer(1)
                .liquid()
                .color(0x8f795e)
                .buildAndRegister()
                .setFormula("(CH2CHC6H4SO3H)", true);

        EthylenediaminetetraaceticAcid = new Material.Builder(Supersymmetry.id("ethylenediaminetetraacetic_acid"))
                .dust()
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H4EDTA)", true);

        TetrasodiumEthylenediaminetetraacetate = new Material.Builder(Supersymmetry.id("tetrasodium_ethylenediaminetetraacetate"))
                .dust()
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Sodium, 4, Oxygen, 8)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na4EDTA)", true);


        Urea = new Material.Builder(Supersymmetry.id("urea"))
                .dust()
                .components(Carbon, 1, Oxygen, 1, Nitrogen, 2, Hydrogen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("CO(NH2)2", true);


        Diiodobenzene = new Material.Builder(Supersymmetry.id("diiodobenzene"))
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Iodine, 2)
                .colorAverage()
                .buildAndRegister();

        TerephthalicAcid = new Material.Builder(Supersymmetry.id("terephthalic_acid"))
                .dust().liquid(new FluidBuilder().temperature(473))
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .color(0xadf0ce)
                .buildAndRegister();

        Bistrichloromethylbenzene = new Material.Builder(Supersymmetry.id("bistrichloromethylbenzene"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 4, Carbon, 2, Chlorine, 6)
                .colorAverage()
                .buildAndRegister()
                .setFormula("C6H4(CCl3)2", true);


        TerephthaloylChloride = new Material.Builder(Supersymmetry.id("terephthaloyl_chloride"))
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        Kevlar = new Material.Builder(Supersymmetry.id("kevlar"))
                .color(0x4d443e)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .flags(GENERATE_PLATE)
                .buildAndRegister()
                .setFormula("[COC6H4CONHC6H4NH]n", true);

        Kevlar.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(true, false, true));

        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(Supersymmetry.id("biphenyl_tetracarboxylic_acid_dianhydride"))
                .dust()
                .components(Carbon, 16, Hydrogen, 16, Oxygen, 6)
                .colorAverage()
                .buildAndRegister();

        CelluloseAcetate = new Material.Builder(Supersymmetry.id("cellulose_acetate"))
                .components(Carbon, 76, Hydrogen, 114, Oxygen, 49)
                .color(0xd4c9ab)
                .buildAndRegister();

        CelluloseAcetate.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, false, false));

        Pyridine = new Material.Builder(Supersymmetry.id("pyridine"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 5, Nitrogen, 1)
                .color(0x202836)
                .buildAndRegister();

        Quinoline = new Material.Builder(Supersymmetry.id("quinoline"))
                .liquid()
                .components(Carbon, 9, Hydrogen, 7, Nitrogen, 1)
                .color(0x2e3620)
                .buildAndRegister();

        DimethylCarbonate = new Material.Builder(Supersymmetry.id("dimethyl_carbonate"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        DiethyleneGlycol = new Material.Builder(Supersymmetry.id("diethylene_glycol"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 3)
                .color(0x2ec9c1)
                .buildAndRegister();

        DiglycolicAcid = new Material.Builder(Supersymmetry.id("diglycolic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        NOctanol = new Material.Builder(Supersymmetry.id("n_octanol"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 1)
                .color(0xbf8454)
                .buildAndRegister()
                .setFormula("C8H17OH", true);


        NOctylamine = new Material.Builder(Supersymmetry.id("n_octylamine"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 19, Nitrogen, 1)
                .color(0xeb8634)
                .buildAndRegister();

        Dioctylamine = new Material.Builder(Supersymmetry.id("dioctylamine"))
                .liquid()
                .components(Carbon, 16, Hydrogen, 35, Nitrogen, 1)
                .colorAverage()
                .buildAndRegister();

        TetraoctylDiglycolamide = new Material.Builder(Supersymmetry.id("tetraoctyl_diglycolamide"))
                .liquid()
                .components(Carbon, 36, Hydrogen, 72, Nitrogen, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        TwoEthylTwoHexenal = new Material.Builder(Supersymmetry.id("two_ethyl_two_hexenal"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 14, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        TwoEthylhexanol = new Material.Builder(Supersymmetry.id("two_ethylhexanol"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        DiTwoEthylhexylPhosphoricAcid = new Material.Builder(Supersymmetry.id("di_two_ethylhexyl_phosphoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .color(0xb5a677)
                .buildAndRegister()
                .setFormula("(C8H17O)2PO(OH)2", true);


        LauricAcid = new Material.Builder(Supersymmetry.id("lauric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 12, Hydrogen, 24, Oxygen, 2)
                .color(0xe39c32)
                .buildAndRegister();

        CapricAcid = new Material.Builder(Supersymmetry.id("capric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 10, Hydrogen, 20, Oxygen, 2)
                .color(0xe3ba32)
                .buildAndRegister();

        PrimaryAmineN = new Material.Builder(Supersymmetry.id("primary_amine_n"))
                .liquid()
                .components(Carbon, 20, Hydrogen, 43, Nitrogen, 1)
                .color(0x8533e8)
                .buildAndRegister();

        NineOctadecene = new Material.Builder(Supersymmetry.id("nine_octadecanone"))
                .liquid()
                .components(Carbon, 18, Hydrogen, 36, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        TriOctylDecylAmine = new Material.Builder(Supersymmetry.id("tri_octyl_decyl_amine"))
                .liquid()
                .components(Carbon, 54, Hydrogen, 111, Nitrogen, 1)
                .color(0x6776c9)
                .buildAndRegister();

        Diethylbenzene = new Material.Builder(Supersymmetry.id("diethylbenzene"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 14)
                .color(0xad9797)
                .buildAndRegister();

        Divinylbenzene = new Material.Builder(Supersymmetry.id("divinylbenzene"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 10)
                .color(0xad9797)
                .buildAndRegister();

        NButanol = new Material.Builder(Supersymmetry.id("n_butanol"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        DibutylCarbitol = new Material.Builder(Supersymmetry.id("dibutyl_carbitol"))
                .liquid()
                .components(Carbon, 12, Hydrogen, 26, Oxygen, 3)
                .color(0x89db6b)
                .buildAndRegister()
                .setFormula("(CH3CH2CH2CH2OCH2CH2)2O", true);


        MonoTwoEthylhexylPhosphoricAcid = new Material.Builder(Supersymmetry.id("mono_two_ethylhexyl_phosphoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 16, Hydrogen, 34, Oxygen, 3, Phosphorus, 1)
                .color(0xb5a677)
                .buildAndRegister()
                .setFormula("(C8H17O)2PO(OH)", true);


        MethylIsobutylKetone = new Material.Builder(Supersymmetry.id("methyl_isobutyl_ketone"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 1)
                .color(0x86dbb1)
                .buildAndRegister();

        MethylIsobutylCarbinol = new Material.Builder(Supersymmetry.id("methyl_isobutyl_carbinol"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
                .color(0x79c4c7)
                .buildAndRegister();

        NHexanol = new Material.Builder(Supersymmetry.id("n_hexanol"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
                .color(0xff9640)
                .buildAndRegister()
                .setFormula("C6H13OH", true);


        NDecanol = new Material.Builder(Supersymmetry.id("n_decanol"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 22, Oxygen, 1)
                .color(0xdb8035)
                .buildAndRegister()
                .setFormula("C10H21OH", true);


        NDodecanol = new Material.Builder(Supersymmetry.id("n_dodecanol"))
                .liquid(new FluidBuilder().temperature(293))
                .components(Carbon, 12, Hydrogen, 26, Oxygen, 1)
                .color(0xbd6e2d)
                .buildAndRegister()
                .setFormula("C12H25OH", true);


        NTetradecanol = new Material.Builder(Supersymmetry.id("n_tetradecanol"))
                .liquid(new FluidBuilder().temperature(311))
                .components(Carbon, 14, Hydrogen, 30, Oxygen, 1)
                .color(0x2177ff)
                .buildAndRegister()
                .setFormula("C14H29OH", true);


        NHexadecanol = new Material.Builder(Supersymmetry.id("n_hexadecanol"))
                .liquid(new FluidBuilder().temperature(323))
                .components(Carbon, 16, Hydrogen, 34, Oxygen, 1)
                .color(0x824b1e)
                .buildAndRegister()
                .setFormula("C16H33OH", true);


        OleicAcid = new Material.Builder(Supersymmetry.id("oleic_acid"))
                .dust().liquid()
                .components(Carbon, 18, Hydrogen, 34, Oxygen, 2)
                .color(0xb1d1ae)
                .buildAndRegister();

        LinoleicAcid = new Material.Builder(Supersymmetry.id("linoleic_acid"))
                .dust().liquid()
                .components(Carbon, 18, Hydrogen, 32, Oxygen, 2)
                .color(0xbfd1a3)
                .buildAndRegister();

        PalmiticAcid = new Material.Builder(Supersymmetry.id("palmitic_acid"))
                .dust().liquid()
                .components(Carbon, 16, Hydrogen, 32, Oxygen, 2)
                .color(0xd4d392)
                .buildAndRegister();

        Capsaicin = new Material.Builder(Supersymmetry.id("capsaicin"))
                .dust()
                .components(Carbon, 18, Hydrogen, 27, Nitrogen, 1, Oxygen, 3)
                .color(0xff1900)
                .buildAndRegister();

        Diisopropylamine = new Material.Builder(Supersymmetry.id("diisopropylamine"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1)
                .colorAverage()
                .buildAndRegister();

        Diisopropylaminoethanol = new Material.Builder(Supersymmetry.id("diisopropylaminoethanol"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 19, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        IsopropylAlcohol = new Material.Builder(Supersymmetry.id("isopropyl_alcohol"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 8, Oxygen, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CH3)2CHOH", true);


        Triethylamine = new Material.Builder(Supersymmetry.id("triethylamine"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1)
                .color(0xe07d26)
                .buildAndRegister();

        Diethylamine = new Material.Builder(Supersymmetry.id("diethylamine"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1)
                .color(0xf59542)
                .buildAndRegister();

        Ethylamine = new Material.Builder(Supersymmetry.id("ethylamine"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1)
                .color(0xf5a55f)
                .buildAndRegister();

        Diethylacetamide = new Material.Builder(Supersymmetry.id("diethylacetamide"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 13, Oxygen, 1, Nitrogen, 1)
                .colorAverage()
                .buildAndRegister();

        Diethylacetimidamine = new Material.Builder(Supersymmetry.id("diethylacetimidamine"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 14, Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        Novichok = new Material.Builder(Supersymmetry.id("novichok"))
                .liquid()
                .components(Carbon, 7, Hydrogen, 16, Fluorine, 1, Nitrogen, 2, Oxygen, 1, Phosphorus, 1)
                .colorAverage()
                .buildAndRegister();

        IsoamylAlcohol = new Material.Builder(Supersymmetry.id("isoamyl_alcohol"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 12, Oxygen, 1)
                .color(0x23ad13)
                .buildAndRegister()
                .setFormula("(CH3)2CHCH2CH2OH", true);


        IsobutylAlcohol = new Material.Builder(Supersymmetry.id("isobutyl_alcohol"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .color(0xa0ad13)
                .buildAndRegister()
                .setFormula("(CH3)2CHCH2OH", true);


        CaprylicAcid = new Material.Builder(Supersymmetry.id("caprylic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2)
                .color(0x748545)
                .buildAndRegister();

        OctanoylChloride = new Material.Builder(Supersymmetry.id("octanoyl_chloride"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 15, Chlorine, 1, Oxygen, 1)
                .color(0x458548)
                .buildAndRegister();

        PerfluorooctanoylFluoride = new Material.Builder(Supersymmetry.id("perfluorooctanoyl_fluoride"))
                .liquid()
                .components(Carbon, 8, Fluorine, 16, Oxygen, 1)
                .color(0x288a7b)
                .buildAndRegister();

        PerfluorooctanoicAcid = new Material.Builder(Supersymmetry.id("perfluorooctanoic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 1, Fluorine, 15, Oxygen, 2)
                .color(0x24bfa8)
                .buildAndRegister();

        OneButene = new Material.Builder(Supersymmetry.id("one_butene"))
                .gas()
                .components(Carbon, 4, Hydrogen, 8)
                .color(0xed9595)
                .buildAndRegister();

        TwoButene = new Material.Builder(Supersymmetry.id("two_butene"))
                .gas()
                .components(Carbon, 4, Hydrogen, 8)
                .color(0xab6009)
                .buildAndRegister();

        NPentanol = new Material.Builder(Supersymmetry.id("n_pentanol"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 12, Oxygen, 1)
                .color(0xb37834)
                .buildAndRegister();

        SodiumEthoxideSolution = new Material.Builder(Supersymmetry.id("sodium_ethoxide_solution"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Sodium, 1, Ethanol, 1)
                .color(0xcc5050)
                .buildAndRegister()
                .setFormula("(CH3CH2ONa)(H2O)", true);


        SodiumEthylXanthate = new Material.Builder(Supersymmetry.id("sodium_ethyl_xanthate"))
                .dust()
                .components(Carbon, 3, Hydrogen, 5, Oxygen, 1, Sulfur, 2, Sodium, 1)
                .color(0xfdffbf)
                .buildAndRegister()
                .setFormula("CH3CH2OCS2Na", true);


        PotassiumAmylXanthate = new Material.Builder(Supersymmetry.id("potassium_amyl_xanthate"))
                .dust()
                .components(Carbon, 6, Hydrogen, 11, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xe0d582)
                .buildAndRegister()
                .setFormula("C5H11OCS2K", true);


        Isobutyraldehyde = new Material.Builder(Supersymmetry.id("isobutyraldehyde"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .color(0x9ccf69)
                .buildAndRegister();

        SodiumIsobutylXanthate = new Material.Builder(Supersymmetry.id("sodium_isobutyl_xanthate"))
                .dust()
                .components(Carbon, 5, Hydrogen, 9, Oxygen, 1, Sulfur, 2, Sodium, 1)
                .color(0xb1bf60)
                .buildAndRegister()
                .setFormula("(CH3)2CHCH2OCS2Na", true);


        PotassiumIsopropylXanthate = new Material.Builder(Supersymmetry.id("potassium_isopropyl_xanthate"))
                .dust()
                .components(Carbon, 4, Hydrogen, 7, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xcbdb6b)
                .buildAndRegister()
                .setFormula("(CH3)2CHOCS2K", true);


        PotassiumEthylXanthate = new Material.Builder(Supersymmetry.id("potassium_ethyl_xanthate"))
                .dust()
                .components(Carbon, 3, Hydrogen, 5, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xfdffc8)
                .buildAndRegister()
                .setFormula("CH3CH2OCS2K", true);


        Valeraldehyde = new Material.Builder(Supersymmetry.id("valeraldehyde"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 10, Oxygen, 1)
                .color(0xb3af34)
                .buildAndRegister();

        NHexadecylamine = new Material.Builder(Supersymmetry.id("n_hexadecylamine"))
                .dust()
                .components(Carbon, 16, Hydrogen, 35, Nitrogen, 1)
                .color(0xcff5ff)
                .buildAndRegister();

        TertButylAlcohol = new Material.Builder(Supersymmetry.id("tert_butyl_alcohol"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CH3)3COH", true);


        ButylatedHydroxytoluene = new Material.Builder(Supersymmetry.id("butylated_hydroxytoluene"))
                .liquid()
                .components(Carbon, 15, Hydrogen, 25, Oxygen, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("((CH3)3C)2CH3C6H2OH", true);


        DimethylTertButylphenol = new Material.Builder(Supersymmetry.id("dimethyl_tert_butylphenol"))
                .liquid()
                .components(Carbon, 12, Hydrogen, 18, Oxygen, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CH3)2(CH3)3C7H2OH", true);


        AluminiumPhenolate = new Material.Builder(Supersymmetry.id("aluminium_phenolate"))
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Aluminium, 1, Oxygen, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Al(OC6H5)3", true);


        DiTertButylphenol = new Material.Builder(Supersymmetry.id("di_tert_butylphenol"))
                .liquid()
                .components(Carbon, 14, Hydrogen, 22, Oxygen, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("((CH3)3C)2C6H3OH", true);


        IsoOctane = new Material.Builder(Supersymmetry.id("isooctane"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 18)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CH3)3CCH2CH(CH3)2", true);


        PurifiedIsoprene = new Material.Builder(Supersymmetry.id("purified_isoprene"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 8)
                .color(0x000000)
                .buildAndRegister();

        Cyclopentadiene = new Material.Builder(Supersymmetry.id("cyclopentadiene"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 6)
                .color(0x403c32)
                .buildAndRegister();

        //FREE ID: 15226

        Ferrocene = new Material.Builder(Supersymmetry.id("ferrocene"))
                .dust()
                .components(Carbon, 10, Hydrogen, 10, Iron, 1)
                .color(0x403c32)
                .buildAndRegister()
                .setFormula("Fe(C5H5)2", true);


        Polyisoprene = new Material.Builder(Supersymmetry.id("polyisoprene"))
                .dust()
                .iconSet(SHINY)
                .components(Carbon, 5, Hydrogen, 8)
                .color(0x1f1f1f)
                .buildAndRegister();

        Chloroethane = new Material.Builder(Supersymmetry.id("chloroethane"))
                .gas()
                .components(Carbon, 2, Hydrogen, 5, Chlorine, 1)
                .colorAverage()
                .buildAndRegister();

        ExtractedCaprolactamSolution = new Material.Builder(Supersymmetry.id("extracted_caprolactam_solution"))
                .liquid()
                .components(Caprolactam, 1, Toluene, 1)
                .colorAverage()
                .buildAndRegister();

        Trimethylaluminium = new Material.Builder(Supersymmetry.id("trimethylaluminium"))
                .liquid()
                .components(Aluminium, 1, Carbon, 3, Hydrogen, 9)
                .color(0x7abfb4)
                .buildAndRegister()
                .setFormula("Al(CH3)3", true);


        Methylaluminoxane = new Material.Builder(Supersymmetry.id("methylaluminoxane"))
                .dust()
                .components(Aluminium, 1, Carbon, 1, Hydrogen, 3, Oxygen, 1)
                .color(0x33a391)
                .buildAndRegister();

        ZirconoceneDichloride = new Material.Builder(Supersymmetry.id("zirconocene_dichloride"))
                .dust()
                .components(Zirconium, 1, Carbon, 10, Hydrogen, 10, Chlorine, 2)
                .color(0x3ea0a3)
                .buildAndRegister()
                .setFormula("Zr(C5H5)2Cl2", true);


        Tetrahydrofuran = new Material.Builder(Supersymmetry.id("tetrahydrofuran"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .color(0xd13485)
                .buildAndRegister();

        //FREE ID: 15235

        OctylHydroxamicAcid = new Material.Builder(Supersymmetry.id("octyl_hydroxamic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 17, Oxygen, 2, Nitrogen, 1)
                .color(0xd47f31)
                .buildAndRegister();

        PotassiumOctylHydroxamate = new Material.Builder(Supersymmetry.id("potassium_octyl_hydroxamate"))
                .dust()
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2, Nitrogen, 1, Potassium, 1)
                .color(0xd47f50)
                .buildAndRegister();

        PotassiumButylXanthate = new Material.Builder(Supersymmetry.id("potassium_butyl_xanthate"))
                .dust()
                .components(Carbon, 5, Hydrogen, 9, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xd1c675)
                .buildAndRegister()
                .setFormula("C4H9OCS2K", true);


        PicricAcid = new Material.Builder(Supersymmetry.id("picric_acid"))
                .dust()
                .components(Carbon, 6, Hydrogen, 3, Nitrogen, 3, Oxygen, 7)
                .color(0xc2ba1f)
                .buildAndRegister();

        Monomethylhydrazine = new Material.Builder(Supersymmetry.id("monomethylhydrazine"))
                .liquid()
                .components(Carbon, 1, Hydrogen, 6, Nitrogen, 2)
                .color(0x558ca6)
                .buildAndRegister();

        OrthoXylene = new Material.Builder(Supersymmetry.id("ortho_xylene"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x3d3427)
                .buildAndRegister();

        MetaXylene = new Material.Builder(Supersymmetry.id("meta_xylene"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x40392f)
                .buildAndRegister();

        ParaXylene = new Material.Builder(Supersymmetry.id("para_xylene"))
                .dust().liquid()
                .flags(NO_UNIFICATION)
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x1a1611)
                .buildAndRegister();

        MetaParaXyleneMixture = new Material.Builder(Supersymmetry.id("meta_para_xylene_mixture"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x2b2319)
                .buildAndRegister();

        Tripropylamine = new Material.Builder(Supersymmetry.id("tripropylamine"))
                .liquid()
                .components(Carbon, 9, Hydrogen, 21, Nitrogen, 1)
                .color(0x90b846)
                .buildAndRegister();

        NBromopropane = new Material.Builder(Supersymmetry.id("n_bromopropane"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 7, Bromine, 1)
                .color(0x9e833f)
                .buildAndRegister();

        Triethylenetetramine = new Material.Builder(Supersymmetry.id("triethylenetetramine"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 18, Nitrogen, 4)
                .color(0x3d98ab)
                .buildAndRegister();

        Aminoethylpiperazine = new Material.Builder(Supersymmetry.id("aminoethylpiperazine"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 3)
                .color(0xcce862)
                .buildAndRegister();

        GroovySuSyMaterials.Diethylenetriamine = new Material.Builder(Supersymmetry.id("diethylenetriamine"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 13, Nitrogen, 3)
                .color(0x0234a8)
                .buildAndRegister();

        Ethylenediamine = new Material.Builder(Supersymmetry.id("ethylenediamine"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .color(0x2e7a25)
                .buildAndRegister();

        Piperazine = new Material.Builder(Supersymmetry.id("piperazine"))
                .liquid(new FluidBuilder().temperature(379))
                .components(Carbon, 4, Hydrogen, 10, Nitrogen, 2)
                .color(0x8a8f9f)
                .buildAndRegister();

        Cyclooctadiene = new Material.Builder(Supersymmetry.id("cyclooctadiene"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 12)
                .color(0x4639ee)
                .buildAndRegister();

        TriethylPhosphate = new Material.Builder(Supersymmetry.id("triethyl_phosphate"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 15, Oxygen, 4, Phosphorus, 1)
                .color(0x4639ee)
                .buildAndRegister();

        IsopropenylAcetate = new Material.Builder(Supersymmetry.id("isopropenyl_acetate"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .color(0x4639ee)
                .buildAndRegister();

        Acetylacetone = new Material.Builder(Supersymmetry.id("acetylacetone"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .color(0x092b30)
                .buildAndRegister();

        NickelIIBisacetylacetonate = new Material.Builder(Supersymmetry.id("nickel_ii_bisacetylacetonate"))
                .dust()
                .components(Carbon, 10, Hydrogen, 14, Nickel, 1, Oxygen, 4)
                .color(0x3e5051)
                .buildAndRegister()
                .setFormula("Ni(acac)2", true);


        BiscyclooctadienenickelZero = new Material.Builder(Supersymmetry.id("biscyclooctadienenickel_zero"))
                .dust()
                .components(Carbon, 16, Hydrogen, 24, Nickel, 1)
                .color(0xe0e00d)
                .buildAndRegister()
                .setFormula("Ni(cod)2", true);


        DiethylaluminiumAcetylacetonate = new Material.Builder(Supersymmetry.id("diethylaluminium_acetylacetonate"))
                .liquid()
                .components(Aluminium, 1, Carbon, 9, Hydrogen, 17, Oxygen, 2)
                .color(0x10a37e)
                .buildAndRegister()
                .setFormula("(acac)AlEt2", true);


        OxalicAcid = new Material.Builder(Supersymmetry.id("oxalic_acid"))
                .dust()
                .components(Hydrogen, 2, Carbon, 2, Oxygen, 4)
                .color(0xb5a7aa)
                .buildAndRegister();

        OneAmidoethylTwoAlkylTwoImidazoline = new Material.Builder(Supersymmetry.id("one_amidoethyl_two_alkyl_two_imidazoline"))
                .liquid()
                .color(0x9c3398)
                .buildAndRegister();

        Chlorodiphenylphosphine = new Material.Builder(Supersymmetry.id("chlorodiphenylphosphine"))
                .liquid()
                .components(Carbon, 12, Hydrogen, 10, Chlorine, 1, Phosphorus, 1)
                .color(0xd2e080)
                .buildAndRegister();

        DiphenylphosphinoaceticAcid = new Material.Builder(Supersymmetry.id("diphenylphosphinoacetic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 14, Hydrogen, 13, Oxygen, 2, Phosphorus, 1)
                .color(0xdeba6d)
                .buildAndRegister();

        OneHexene = new Material.Builder(Supersymmetry.id("one_hexene"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 12)
                .color(0xd96c6c)
                .buildAndRegister();

        Tripropylene = new Material.Builder(Supersymmetry.id("tripropylene"))
                .liquid()
                .components(Carbon, 9, Hydrogen, 18)
                .color(0xcf5f1f)
                .buildAndRegister();

        Isodecanal = new Material.Builder(Supersymmetry.id("isodecanal"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 20, Oxygen, 1)
                .color(0xde8431)
                .buildAndRegister();

        Isodecanol = new Material.Builder(Supersymmetry.id("isodecanol"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 22, Oxygen, 1)
                .color(0xeb9546)
                .buildAndRegister();

        Trioctylamine = new Material.Builder(Supersymmetry.id("trioctylamine"))
                .liquid()
                .components(Carbon, 24, Hydrogen, 51, Nitrogen, 1)
                .color(0x2274a3)
                .buildAndRegister();

        NButylamine = new Material.Builder(Supersymmetry.id("n_butylamine"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1)
                .color(0x43576e)
                .buildAndRegister();

        Ethyltoluene = new Material.Builder(Supersymmetry.id("ethyltoluene"))
                .liquid()
                .components(Carbon, 9, Hydrogen, 12)
                .color(0x806706)
                .buildAndRegister();

        VinylbenzylChloride = new Material.Builder(Supersymmetry.id("vinylbenzyl_chloride"))
                .liquid()
                .components(Carbon, 9, Hydrogen, 9, Chlorine, 1)
                .color(0x8fa32a)
                .buildAndRegister();

        TetrabromobisphenolA = new Material.Builder(Supersymmetry.id("tetrabromobisphenol_a"))
                .dust()
                .components(Carbon, 15, Hydrogen, 12, Bromine, 4, Oxygen, 2)
                .color(0x6b3220)
                .buildAndRegister();

        Cyanamide = new Material.Builder(Supersymmetry.id("cyanamide"))
                .dust()
                .components(Carbon, 1, Hydrogen, 2, Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        Dicyandiamide = new Material.Builder(Supersymmetry.id("dicyandiamide"))
                .dust()
                .components(Carbon, 2, Hydrogen, 4, Nitrogen, 4)
                .colorAverage()
                .iconSet(QUARTZ)
                .buildAndRegister();

        TwoMethylimidazole = new Material.Builder(Supersymmetry.id("two_methylimidazole"))
                .dust()
                .components(Carbon, 4, Hydrogen, 6, Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        FlameRetardantEpoxy = new Material.Builder(Supersymmetry.id("flame_retardant_epoxy"))
                .dust().liquid()
                .components(Carbon, 21, Hydrogen, 21, Bromine, 4, Chlorine, 1, Oxygen, 5)
                .color(0xc86b14)
                .buildAndRegister();

        PropyleneChlorohydrin = new Material.Builder(Supersymmetry.id("propylene_chlorohydrin"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 7, Chlorine, 1, Oxygen, 1)
                .colorAverage()
                .buildAndRegister();

        PropyleneOxide = new Material.Builder(Supersymmetry.id("propylene_oxide"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 1)
                .color(0x9ab522)
                .buildAndRegister();

        PropyleneCarbonate = new Material.Builder(Supersymmetry.id("propylene_carbonate"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 3)
                .color(0x5db522)
                .buildAndRegister();

        DiphenylSulfide = new Material.Builder(Supersymmetry.id("diphenyl_sulfide"))
                .dust()
                .components(Carbon, 12, Hydrogen, 10, Sulfur, 1)
                .color(0x5e5c0a)
                .buildAndRegister();

        DiphenylSulfoxide = new Material.Builder(Supersymmetry.id("diphenyl_sulfoxide"))
                .dust()
                .components(Carbon, 12, Hydrogen, 10, Oxygen, 1, Sulfur, 1)
                .color(0x435e0a)
                .buildAndRegister();

        MethanesulfonicAcid = new Material.Builder(Supersymmetry.id("methanesulfonic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 1, Hydrogen, 4, Oxygen, 3, Sulfur, 1)
                .color(0xff6e6e)
                .buildAndRegister();

        TriphenylphosphineOxide = new Material.Builder(Supersymmetry.id("triphenylphosphine_oxide"))
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Oxygen, 1, Phosphorus, 1)
                .colorAverage()
                .buildAndRegister();

        TosylicAcidSolution = new Material.Builder(Supersymmetry.id("tosylic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 3, Sulfur, 1, Water, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(TsOH)(H2O)", true);


        Triphenylphosphine = new Material.Builder(Supersymmetry.id("triphenylphosphine"))
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Phosphorus, 1)
                .colorAverage()
                .buildAndRegister();

        TriphenylphosphineDichloride = new Material.Builder(Supersymmetry.id("triphenylphosphine_dichloride"))
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Chlorine, 2, Phosphorus, 1)
                .colorAverage()
                .buildAndRegister();

        BistriphenylphosphineiminiumChloride = new Material.Builder(Supersymmetry.id("bistriphenylphosphineiminium_chloride"))
                .dust()
                .components(Carbon, 36, Hydrogen, 30, Chlorine, 1, Nitrogen, 1, Phosphorus, 2)
                .colorAverage()
                .buildAndRegister();

        DimethylTerephthalate = new Material.Builder(Supersymmetry.id("dimethyl_terephthalate"))
                .dust().liquid(new FluidBuilder().temperature(533))
                .components(Carbon, 10, Hydrogen, 10, Oxygen, 4)
                .color(0x56c48c)
                .buildAndRegister();

        PolyethyleneTerephthalate = new Material.Builder(Supersymmetry.id("polyethylene_terephthalate"))
                .polymer().liquid(new FluidBuilder().temperature(533))
                .flags(GENERATE_FOIL)
                .components(Carbon, 10, Hydrogen, 6, Oxygen, 4)
                .color(0x7e9e8e)
                .buildAndRegister();

        PolyethyleneTerephthalate.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, false));

        AmocoTerephthalicAcid = new Material.Builder(Supersymmetry.id("amoco_terephthalic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .color(0x66916c)
                .buildAndRegister();

        AmocoIsophthalicAcid = new Material.Builder(Supersymmetry.id("amoco_isophthalic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .color(0x6b9166)
                .buildAndRegister();

        ParaToluicAcid = new Material.Builder(Supersymmetry.id("para_toluic_acid"))
                .dust().liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(454))
                .flags(NO_UNIFICATION)
                .components(Carbon, 8, Hydrogen, 8, Oxygen, 2)
                .color(0x83943a)
                .buildAndRegister();

        MethylParaToluate = new Material.Builder(Supersymmetry.id("methyl_para_toluate"))
                .liquid(new FluidBuilder().temperature(323))
                .components(Carbon, 9, Hydrogen, 10, Oxygen, 2)
                .color(0x4e8538)
                .buildAndRegister();

        CrudeDimethylTerephthalate = new Material.Builder(Supersymmetry.id("crude_dimethyl_terephthalate"))
                .dust()
                .components(Carbon, 10, Hydrogen, 10, Oxygen, 4)
                .color(0x388568)
                .buildAndRegister();

        WetTerephthalicAcid = new Material.Builder(Supersymmetry.id("wet_terephthalic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .color(0x669181)
                .iconSet(DULL)
                .buildAndRegister();

        WetIsophthalicAcid = new Material.Builder(Supersymmetry.id("wet_isophthalic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .color(0x609169)
                .iconSet(DULL)
                .buildAndRegister();

        HydrogenDodecylSulfate = new Material.Builder(Supersymmetry.id("hydrogen_dodecyl_sulfate"))
                .dust()
                .components(Carbon, 12, Hydrogen, 26, Sulfur, 1, Oxygen, 4)
                .iconSet(SAND)
                .color(0xd8dbb8)
                .buildAndRegister();

        SodiumDodecylSulfate = new Material.Builder(Supersymmetry.id("sodium_dodecyl_sulfate"))
                .dust()
                .components(Carbon, 12, Hydrogen, 25, Sulfur, 1, Oxygen, 4, Sodium, 1)
                .iconSet(SAND)
                .color(0xe6e4cf)
                .buildAndRegister();

        Dinonylnaphthalene = new Material.Builder(Supersymmetry.id("dinonylnaphthalene"))
                .dust()
                .components(Carbon, 28, Hydrogen, 44)
                .iconSet(SAND)
                .color(0xbfa263)
                .buildAndRegister();

        DinonylnaphthaleneSulfonicAcid = new Material.Builder(Supersymmetry.id("dinonylnaphthalene_sulfonic_acid"))
                .dust()
                .components(Carbon, 28, Hydrogen, 44, Sulfur, 1, Oxygen, 3)
                .iconSet(SAND)
                .color(0xbfb463)
                .buildAndRegister();

        Pseudocumene = new Material.Builder(Supersymmetry.id("pseudocumene"))
                .liquid()
                .components(Carbon, 9, Hydrogen, 12)
                .color(0x553300)
                .buildAndRegister();

        Methylcyclopentadiene = new Material.Builder(Supersymmetry.id("methylcyclopentadiene"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 8)
                .color(0x57ab82)
                .buildAndRegister()
                .setFormula("C5H4CH3", true);


        Diglyme = new Material.Builder(Supersymmetry.id("diglyme"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 3)
                .color(0x2f9982)
                .buildAndRegister();

        Bismethylcyclopentadienylmanganese = new Material.Builder(Supersymmetry.id("bismethylcyclopentadienylmanganese"))
                .liquid()
                .components(Carbon, 12, Hydrogen, 10, Manganese, 1)
                .color(0x75250d)
                .buildAndRegister()
                .setFormula("Mn(C5H4CH3)2", true);


        MethylcyclopentadienylmanganeseTricarbonyl = new Material.Builder(Supersymmetry.id("methylcyclopentadienylmanganese_tricarbonyl"))
                .liquid()
                .components(Carbon, 9, Hydrogen, 7, Oxygen, 3, Manganese, 1)
                .color(0xa16c0b)
                .buildAndRegister()
                .setFormula("(C5H4CH3)Mn(CO)3", true);


        MethylCarbitol = new Material.Builder(Supersymmetry.id("methyl_carbitol"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 12, Oxygen, 3)
                .color(0x3fd1b1)
                .buildAndRegister();

        DiisopropylParaPhenylenediamine = new Material.Builder(Supersymmetry.id("diisopropyl_para_phenylenediamine"))
                .dust()
                .components(Carbon, 12, Hydrogen, 22, Nitrogen, 2)
                .color(0x1d666e)
                .buildAndRegister();

        OneTwoDiaminopropaneSolution = new Material.Builder(Supersymmetry.id("one_two_diaminopropane_solution"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 10, Nitrogen, 2, Water, 1)
                .color(0x22b55d)
                .buildAndRegister();

        Salicylaldehyde = new Material.Builder(Supersymmetry.id("salicylaldehyde"))
                .liquid()
                .components(Carbon, 7, Hydrogen, 6, Oxygen, 2)
                .color(0x3f44a6)
                .buildAndRegister();

        SalicylideneOneTwoPropanediamine = new Material.Builder(Supersymmetry.id("salicylidene_one_two_propanediamine"))
                .dust()
                .components(Carbon, 17, Hydrogen, 18, Nitrogen, 2, Oxygen, 2)
                .color(0x571f80)
                .buildAndRegister();

        EthyleneVinylAcetate = new Material.Builder(Supersymmetry.id("ethylene_vinyl_acetate"))
                .polymer()
                .components(Ethylene, 1, VinylAcetate, 1)
                .color(0x686ad4)
                .fluidPipeProperties(363, 100, true)
                .iconSet(DULL)
                .buildAndRegister();

        EthyleneIsobutyleneVinylAcetate = new Material.Builder(Supersymmetry.id("ethylene_isobutylene_vinyl_acetate"))
                .dust()
                .components(Ethylene, 1, Isobutylene, 1, VinylAcetate, 1)
                .color(0x8768d4)
                .iconSet(DULL)
                .buildAndRegister();

        Dihexadecylamine = new Material.Builder(Supersymmetry.id("dihexadecylamine"))
                .liquid(new FluidBuilder().temperature(340))
                .components(Carbon, 32, Hydrogen, 67, Nitrogen, 1)
                .color(0x5f6e0e)
                .buildAndRegister();

        DihexadecylaminePhthalateAmide = new Material.Builder(Supersymmetry.id("dihexadecylamine_phthalate_amide"))
                .dust()
                .components(Carbon, 72, Hydrogen, 138, Nitrogen, 2, Oxygen, 3)
                .color(0x3e6e0e)
                .buildAndRegister();

        MethylTertButylEther = new Material.Builder(Supersymmetry.id("methyl_tert_butyl_ether"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 12, Oxygen, 1)
                .color(0xae21b0)
                .buildAndRegister();

        TetraethylOrthosilicate = new Material.Builder(Supersymmetry.id("tetraethyl_orthosilicate"))
                .liquid()
                .components(Silicon, 1, Carbon, 8, Hydrogen, 20, Oxygen, 4)
                .color(0x96a894)
                .buildAndRegister()
                .setFormula("Si(C2H5)4", true);


        Methylphenyldichlorosilane = new Material.Builder(Supersymmetry.id("methylphenyldichlorosilane"))
                .liquid()
                .components(Silicon, 1, Carbon, 7, Hydrogen, 8, Chlorine, 2)
                .color(0x9ba178)
                .buildAndRegister()
                .setFormula("C6H5Si(CH3)Cl2", true);


        OneOctene = new Material.Builder(Supersymmetry.id("one_octene"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 16)
                .color(0xd68b9d)
                .buildAndRegister();

        OneDecene = new Material.Builder(Supersymmetry.id("one_decene"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 20)
                .color(0xbf7184)
                .buildAndRegister();

        OneDodecene = new Material.Builder(Supersymmetry.id("one_dodecene"))
                .liquid()
                .components(Carbon, 12, Hydrogen, 24)
                .color(0xb0566c)
                .buildAndRegister();

        OneTetradecene = new Material.Builder(Supersymmetry.id("one_tetradecene"))
                .liquid()
                .components(Carbon, 14, Hydrogen, 28)
                .color(0xb54a64)
                .buildAndRegister();

        OneHexadecene = new Material.Builder(Supersymmetry.id("one_hexadecene"))
                .liquid()
                .components(Carbon, 16, Hydrogen, 32)
                .color(0xcc4969)
                .buildAndRegister();

        OneOctadecene = new Material.Builder(Supersymmetry.id("one_octadecene"))
                .liquid()
                .components(Carbon, 18, Hydrogen, 36)
                .color(0xd94368)
                .buildAndRegister();

        OneIcosene = new Material.Builder(Supersymmetry.id("one_icosene"))
                .liquid(new FluidBuilder().temperature(308))
                .components(Carbon, 20, Hydrogen, 40)
                .color(0xe63560)
                .buildAndRegister();

        OneDocosene = new Material.Builder(Supersymmetry.id("one_docosene"))
                .liquid(new FluidBuilder().temperature(310))
                .components(Carbon, 22, Hydrogen, 44)
                .color(0xcf2750)
                .buildAndRegister();

        OneTetracosene = new Material.Builder(Supersymmetry.id("one_tetracosene"))
                .liquid(new FluidBuilder().temperature(318))
                .components(Carbon, 24, Hydrogen, 48)
                .color(0xb51b41)
                .buildAndRegister();

        Polybutene = new Material.Builder(Supersymmetry.id("polybutene"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 8)
                .color(0xb5471b)
                .buildAndRegister()
                .setFormula("[C4H8]n", true);


        TrimelliticAcid = new Material.Builder(Supersymmetry.id("trimellitic_acid"))
                .dust()
                .components(Carbon, 9, Hydrogen, 6, Oxygen, 6)
                .color(0xcb6fde)
                .buildAndRegister();

        TrimelliticAnhydride = new Material.Builder(Supersymmetry.id("trimellitic_anhydride"))
                .dust()
                .components(Carbon, 9, Hydrogen, 4, Oxygen, 5)
                .color(0xac59bd)
                .buildAndRegister();

        Oleylamide = new Material.Builder(Supersymmetry.id("oleylamide"))
                .liquid()
                .components(Carbon, 18, Hydrogen, 35, Nitrogen, 1, Oxygen, 1)
                .color(0x59bbbd)
                .buildAndRegister();

        StearicAcid = new Material.Builder(Supersymmetry.id("stearic_acid"))
                .liquid(new FluidBuilder().temperature(342))
                .components(Carbon, 18, Hydrogen, 36, Oxygen, 2)
                .color(0xd3d4ae)
                .buildAndRegister();

        //FREE ID: 15332

        OneNitronaphthalene = new Material.Builder(Supersymmetry.id("one_nitronaphthalene"))
                .dust()
                .components(Carbon, 10, Hydrogen, 7, Nitrogen, 1, Oxygen, 2)
                .color(0x82bd8a)
                .buildAndRegister();

        OneNaphthylamine = new Material.Builder(Supersymmetry.id("one_naphthylamine"))
                .dust().liquid(new FluidBuilder().temperature(322))
                .components(Carbon, 10, Hydrogen, 9, Nitrogen, 1)
                .color(0x82bd9c)
                .buildAndRegister();

        NPhenylOneNaphthylamine = new Material.Builder(Supersymmetry.id("n_phenyl_one_naphthylamine"))
                .dust()
                .components(Carbon, 16, Hydrogen, 13, Nitrogen, 1)
                .color(0x62a37f)
                .buildAndRegister();

        Polyisobutene = new Material.Builder(Supersymmetry.id("polyisobutene"))
                .dust()
                .components(Carbon, 4, Hydrogen, 8)
                .color(0x944234)
                .buildAndRegister()
                .setFormula("[C4H8]n", true);


        EthylenePropyleneCopolymer = new Material.Builder(Supersymmetry.id("ethylene_propylene_copolymer"))
                .dust()
                .components(Carbon, 5, Hydrogen, 10)
                .color(0xbab18a)
                .buildAndRegister()
                .setFormula("[(C2H4)(C3H6)]n", true);


        MethacrylicAcid = new Material.Builder(Supersymmetry.id("methacrylic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .color(0x5590ad)
                .buildAndRegister();

        StyreneIsopreneSolution = new Material.Builder(Supersymmetry.id("styrene_isoprene_solution"))
                .liquid()
                .components(Isoprene, 3, Styrene, 1, Ethanol, 1)
                .color(0x520734)
                .buildAndRegister();

        RawStyreneIsopreneRubber = new Material.Builder(Supersymmetry.id("raw_styrene_isoprene_rubber"))
                .dust()
                .components(Isoprene, 3, Styrene, 1)
                .color(0x3d0727)
                .buildAndRegister();

        StyreneIsopreneRubber = new Material.Builder(Supersymmetry.id("styrene_isoprene_rubber"))
                .polymer()
                .iconSet(SHINY)
                .flags(GENERATE_FOIL, GENERATE_RING)
                .components(Isoprene, 3, Styrene, 1)
                .color(0x57103a)
                .buildAndRegister();

        HydrogenatedStyreneIsopreneRubber = new Material.Builder(Supersymmetry.id("hydrogenated_styrene_isoprene_rubber"))
                .dust()
                .components(Carbon, 23, Hydrogen, 38)
                .color(0x70186c)
                .buildAndRegister()
                .setFormula("(C5H10)3C8H8", true);


        HydrogenatedStyreneButadieneRubber = new Material.Builder(Supersymmetry.id("hydrogenated_styrene_butadiene_rubber"))
                .dust()
                .components(Carbon, 20, Hydrogen, 32)
                .color(0x701818)
                .buildAndRegister()
                .setFormula("(C4H8)3C8H8", true)        ;


        Dodecylphenol = new Material.Builder(Supersymmetry.id("dodecylphenol"))
                .dust()
                .components(Carbon, 18, Hydrogen, 30, Oxygen, 1)
                .color(0x4c3c63)
                .buildAndRegister();

        CalciumPhenate = new Material.Builder(Supersymmetry.id("calcium_phenate"))
                .liquid()
                .components(Calcite, 1, Carbon, 18, Hydrogen, 29, Oxygen, 1, Sulfur, 1)
                .color(0x4a3f0a)
                .buildAndRegister()
                .setFormula("[C18H29SOCa(CO2)(CaOH)]n", true);


        Dodecylbenzene = new Material.Builder(Supersymmetry.id("dodecylbenzene"))
                .dust()
                .components(Carbon, 18, Hydrogen, 30)
                .color(0x604882)
                .buildAndRegister();

        DodecylbenzenesulfonicAcid = new Material.Builder(Supersymmetry.id("dodecylbenzenesulfonic_acid"))
                .dust()
                .components(Carbon, 18, Hydrogen, 30, Sulfur, 1, Oxygen, 3)
                .color(0x7c4882)
                .buildAndRegister();

        CalciumDodecylbenzeneSulfonate = new Material.Builder(Supersymmetry.id("calcium_dodecylbenzene_sulfonate"))
                .dust()
                .components(Calcium, 1, Carbon, 36, Hydrogen, 60, Sulfur, 2, Oxygen, 6)
                .color(0x944a7c)
                .buildAndRegister()
                .setFormula("Ca(C18H30SO3)2", true);


        CalciumSalicylate = new Material.Builder(Supersymmetry.id("calcium_salicylate"))
                .dust()
                .components(Calcium, 1, Carbon, 14, Hydrogen, 10, Oxygen, 6)
                .color(0x64bd90)
                .buildAndRegister()
                .setFormula("Ca(C7H5O3)2", true);


        MaleicAnhydride = new Material.Builder(Supersymmetry.id("maleic_anhydride"))
                .dust()
                .components(Carbon, 4, Hydrogen, 2, Oxygen, 3)
                .color(0xdb42ba)
                .buildAndRegister();

        CalciumDinonylnaphthaleneSulfonate = new Material.Builder(Supersymmetry.id("calcium_dinonylnaphthalene_sulfonate"))
                .dust()
                .components(Calcium, 1, Carbon, 56, Hydrogen, 86, Sulfur, 2, Oxygen, 6)
                .color(0x42a3db)
                .buildAndRegister()
                .setFormula("Ca(C28H43SO3)", true);


        MetaParaCresolMixture = new Material.Builder(Supersymmetry.id("meta_para_cresol_mixture"))
                .liquid()
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 1)
                .color(0x73674e)
                .buildAndRegister();

        OrthoCresol = new Material.Builder(Supersymmetry.id("ortho_cresol"))
                .liquid()
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 1)
                .color(0xb5a991)
                .buildAndRegister();

        TricresylPhosphate = new Material.Builder(Supersymmetry.id("tricresyl_phosphate"))
                .liquid()
                .components(Carbon, 21, Hydrogen, 21, Oxygen, 4, Phosphorus, 1)
                .color(0x9c924b)
                .buildAndRegister();

        DiisopropyldithiophosphoricAcid = new Material.Builder(Supersymmetry.id("diisopropyldithiophosphoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 6, Hydrogen, 15, Oxygen, 2, Phosphorus, 1, Sulfur, 2)
                .color(0x857714)
                .buildAndRegister()
                .setFormula("(C3H7O)2PS2H", true);


        DibutyldithiophosphoricAcid = new Material.Builder(Supersymmetry.id("dibutyldithiophosphoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 8, Hydrogen, 19, Oxygen, 2, Phosphorus, 1, Sulfur, 2)
                .color(0x856914)
                .buildAndRegister()
                .setFormula("(C4H9O)2PS2H", true);


        TwoButoxyethanol = new Material.Builder(Supersymmetry.id("two_butoxyethanol"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 2)
                .color(0xa0c9db)
                .buildAndRegister();

        //FREE ID: 15359

        Diamylamine = new Material.Builder(Supersymmetry.id("diamylamine"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 23, Nitrogen, 1)
                .color(0x2b7842)
                .buildAndRegister();

        SodiumDiamylthiocarbamateSolution = new Material.Builder(Supersymmetry.id("sodium_diamyldithiocarbamate_solution"))
                .liquid()
                .components(Carbon, 11, Hydrogen, 22, Nitrogen, 1, Sulfur, 2, Sodium, 1, Water, 1)
                .color(0x2b7865)
                .buildAndRegister()
                .setFormula("(C11H22NS2Na)(H2O)", true);


        ZincBisdiamyldithiocarbamate = new Material.Builder(Supersymmetry.id("zinc_bisdiamyldithiocarbamate"))
                .dust()
                .components(Zinc, 1, Carbon, 22, Hydrogen, 44, Nitrogen, 2, Sulfur, 4)
                .color(0x69782b)
                .buildAndRegister()
                .setFormula("Zn(C11H22NS2)2", true);


        Didodecylbenzene = new Material.Builder(Supersymmetry.id("didodecylbenzene"))
                .dust()
                .components(Carbon, 30, Hydrogen, 54)
                .color(0x327894)
                .buildAndRegister();

        DidodecylbenzenesulfonicAcid = new Material.Builder(Supersymmetry.id("didodecylbenzenesulfonic_acid"))
                .dust()
                .components(Carbon, 30, Hydrogen, 54, Sulfur, 1, Oxygen, 3)
                .color(0x32947c)
                .buildAndRegister();

        CalciumDidodecylbenzeneSulfonate = new Material.Builder(Supersymmetry.id("calcium_didodecylbenzene_sulfonate"))
                .dust()
                .components(Calcium, 1, Carbon, 60, Hydrogen, 106, Sulfur, 2, Oxygen, 6)
                .color(0x325994)
                .buildAndRegister()
                .setFormula("Ca(C30H53SO3)2", true);


        Nonylphenol = new Material.Builder(Supersymmetry.id("nonylphenol"))
                .liquid()
                .components(Carbon, 15, Hydrogen, 24, Oxygen, 1)
                .color(0x4070b8)
                .buildAndRegister();

        Trichloroethylene = new Material.Builder(Supersymmetry.id("trichloroethylene"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 1, Chlorine, 3)
                .color(0x55a663)
                .buildAndRegister();

        ChloroaceticAcid = new Material.Builder(Supersymmetry.id("chloroacetic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 2, Hydrogen, 3, Chlorine, 1, Oxygen, 2)
                .color(0x58a33b)
                .buildAndRegister();

        FourNonylphenoxyaceticAcid = new Material.Builder(Supersymmetry.id("four_nonylphenoxyacetic_acid"))
                .dust()
                .components(Carbon, 17, Hydrogen, 26, Oxygen, 3)
                .color(0x953ba3)
                .buildAndRegister();

        TwoNitroanilineSolution = new Material.Builder(Supersymmetry.id("two_nitroaniline_solution"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .color(0x7653bd)
                .buildAndRegister();

        OrthoPhenylenediamine = new Material.Builder(Supersymmetry.id("ortho_phenylenediamine"))
                .dust()
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .color(0x252a80)
                .buildAndRegister();

        Benzotriazole = new Material.Builder(Supersymmetry.id("benzotriazole"))
                .dust()
                .components(Carbon, 6, Hydrogen, 5, Nitrogen, 3)
                .color(0x4971ad)
                .buildAndRegister();

        Mercaptobenzothiazole = new Material.Builder(Supersymmetry.id("mercaptobenzothiazole"))
                .dust()
                .components(Carbon, 7, Hydrogen, 5, Nitrogen, 1, Sulfur, 2)
                .color(0x878000)
                .buildAndRegister();

        SalicylideneEthylenediamine = new Material.Builder(Supersymmetry.id("salicylidene_ethylenediamine"))
                .dust()
                .components(Carbon, 16, Hydrogen, 16, Nitrogen, 2, Oxygen, 2)
                .color(0x5c84c4)
                .buildAndRegister();

        PolyethyleneGlycol = new Material.Builder(Supersymmetry.id("polyethylene_glycol"))
                .liquid()
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .color(0x599c8e)
                .buildAndRegister();

        OneThreeDinitrobenzene = new Material.Builder(Supersymmetry.id("one_three_dinitrobenzene"))
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Nitrogen, 2, Oxygen, 4)
                .color(0x1c718a)
                .buildAndRegister()
                .setFormula("C6H4(NO2)2", true);


        MetaPhenylenediamine = new Material.Builder(Supersymmetry.id("meta_phenylenediamine"))
                .dust()
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .color(0x1e89a8)
                .buildAndRegister()
                .setFormula("C6H4(NH2)2", true);


        Nomex = new Material.Builder(Supersymmetry.id("nomex"))
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .color(0x5d95a3)
                .buildAndRegister()
                .setFormula("[COC6H4CONHC6H4NH]n", true);

        Nomex.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(true, false, true));

        UltraHighMolecularWeightPolyethylene = new Material.Builder(Supersymmetry.id("ultra_high_molecular_weight_polyethylene"))
                .dust().liquid(new FluidBuilder().temperature(425))
                .flags(GENERATE_PLATE)
                .components(Carbon, 2, Hydrogen, 4)
                .color(0xc5e3de)
                .iconSet(SHINY)
                .buildAndRegister()
                .setFormula("[C2H4]n", true);

        UltraHighMolecularWeightPolyethylene.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, true));

        AdipicAcid = new Material.Builder(Supersymmetry.id("adipic_acid"))
                .dust()
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 4)
                .color(0xe3ddb6)
                .buildAndRegister();

        Trimethylolpropane = new Material.Builder(Supersymmetry.id("trimethylolpropane"))
                .dust()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 3)
                .color(0x5d8230)
                .buildAndRegister();

        AcrylicAcid = new Material.Builder(Supersymmetry.id("acrylic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 2)
                .color(0x308264)
                .buildAndRegister();

        TrimethylolpropaneTriacrylate = new Material.Builder(Supersymmetry.id("trimethylolpropane_triacrylate"))
                .liquid()
                .components(Carbon, 15, Hydrogen, 20, Oxygen, 6)
                .color(0x279630)
                .buildAndRegister();

        BenzenediazoniumChloride = new Material.Builder(Supersymmetry.id("benzenediazonium_chloride"))
                .dust()
                .components(Carbon, 6, Hydrogen, 5, Nitrogen, 2, Chlorine, 1)
                .color(0x18262b)
                .buildAndRegister();

        Crotonaldehyde = new Material.Builder(Supersymmetry.id("crotonaldehyde"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 1)
                .color(0xa31a5c)
                .buildAndRegister();

        CalciumAcetate = new Material.Builder(Supersymmetry.id("calcium_acetate"))
                .dust()
                .components(Calcium, 1, Carbon, 4, Hydrogen, 6, Oxygen, 4)
                .color(0xe3dcc8)
                .iconSet(QUARTZ)
                .buildAndRegister()
                .setFormula("Ca(CH3CO2)2", true);


        GaseousMethacroleinMixture = new Material.Builder(Supersymmetry.id("gaseous_methacrolein_mixture"))
                .gas(new FluidBuilder().temperature(434))
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 1, Steam, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(C4H6O)(H2O)", true);


        GaseousMethacroleinResidue = new Material.Builder(Supersymmetry.id("gaseous_methacrolein_residue"))
                .gas(new FluidBuilder().temperature(434))
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 1, Steam, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(C4H6O)(H2O)4", true);


        AbsorbedMethacrolein = new Material.Builder(Supersymmetry.id("absorbed_methacrolein"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 1, AceticAcid, 4, Water, 5)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(C4H6O)(CH3COOH)4(H2O)5", true);


        Tetraethyllead = new Material.Builder(Supersymmetry.id("tetraethyllead"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 20, Lead, 1)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Pb(CH3CH2)4", true);


        TertButylHydroperoxide = new Material.Builder(Supersymmetry.id("tert_butyl_hydroperoxide"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CH3)3COOH", true);


        DiTertButylPeroxide = new Material.Builder(Supersymmetry.id("di_tert_butyl_peroxide"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CH3)3COOC(CH3)3", true);


        TwoEthylhexylNitrate = new Material.Builder(Supersymmetry.id("two_ethylhexyl_nitrate"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 17, Nitrogen, 1, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        Nitromethane = new Material.Builder(Supersymmetry.id("nitromethane"))
                .liquid()
                .components(Carbon, 1, Hydrogen, 3, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumBisphenolateSolution = new Material.Builder(Supersymmetry.id("sodium_bisphenolate_solution"))
                .liquid()
                .components(SodiumHydroxide, 2, BisphenolA, 1, Water, 2)
                .colorAverage()
                .buildAndRegister();

        Polycarbonate = new Material.Builder(Supersymmetry.id("polycarbonate"))
                .polymer()
                .flags(GENERATE_PLATE)
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 3)
                .color(0xa1cacf)
                .iconSet(SHINY)
                .buildAndRegister()
                .setFormula("C16H14O3", true);


        Trichlorofluoromethane = new Material.Builder(Supersymmetry.id("trichlorofluoromethane"))
                .gas()
                .components(Carbon, 1, Chlorine, 3, Fluorine, 1)
                .color(0xeb6a6a)
                .buildAndRegister();

        Dichlorodifluoromethane = new Material.Builder(Supersymmetry.id("dichlorodifluoromethane"))
                .gas()
                .components(Carbon, 1, Chlorine, 2, Fluorine, 2)
                .color(0xd14d4d)
                .buildAndRegister();

        Chlorotrifluoromethane = new Material.Builder(Supersymmetry.id("chlorotrifluoromethane"))
                .gas()
                .components(Carbon, 1, Chlorine, 1, Fluorine, 3)
                .color(0xbf3232)
                .buildAndRegister();

        Chlorodifluoromethane = new Material.Builder(Supersymmetry.id("chlorodifluoromethane"))
                .gas()
                .components(Carbon, 1, Hydrogen, 1, Chlorine, 1, Fluorine, 2)
                .color(0x8c5a99)
                .buildAndRegister();

        Acrolein = new Material.Builder(Supersymmetry.id("acrolein"))
                .liquid()
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 1)
                .color(0x389c7a)
                .buildAndRegister();

        Dicyclopentadiene = new Material.Builder(Supersymmetry.id("dicyclopentadiene"))
                .liquid(new FluidBuilder().temperature(306))
                .components(Carbon, 10, Hydrogen, 12)
                .color(0x9c388b)
                .buildAndRegister();

        SodiumMethoxide = new Material.Builder(Supersymmetry.id("sodium_methoxide"))
                .dust()
                .components(Carbon, 1, Hydrogen, 3, Oxygen, 1, Sodium, 1)
                .color(0xd19c21)
                .buildAndRegister();

        NeutralizedMethylFormateSolution = new Material.Builder(Supersymmetry.id("neutralized_methyl_formate_solution"))
                .liquid()
                .color(0x6b3f58)
                .buildAndRegister();

        HydrolyzedMethylFormateSolution = new Material.Builder(Supersymmetry.id("hydrolyzed_methyl_formate_solution"))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x91436e)
                .buildAndRegister();

        EthylAcetate = new Material.Builder(Supersymmetry.id("ethyl_acetate"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 2)
                .color(0xa5c773)
                .buildAndRegister();

        GroovySuSyMaterials.FormicAcid = new Material.Builder(Supersymmetry.id("formic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 2)
                .color(0xbf395b)
                .buildAndRegister();

        MethylFormateSolution = new Material.Builder(Supersymmetry.id("methyl_formate_solution"))
                .liquid()
                .color(0x915161)
                .buildAndRegister();

        PolyvinylAlcohol = new Material.Builder(Supersymmetry.id("polyvinyl_alcohol"))
                .dust()
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .color(0xd4984e)
                .buildAndRegister();
    }
}
