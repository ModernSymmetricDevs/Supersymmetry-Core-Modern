package belletti.supersymmetry.common.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.materials.properties.SuSyFluidStorageKeys;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;

import static belletti.supersymmetry.common.materials.SuSyMaterialFlags.*;

import static belletti.supersymmetry.common.materials.groovy.GroovySuSyMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.LIGNITE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.SHINY;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GroovyOreMaterials {
    public static void register() {
        Supersymmetry.LOGGER.info("Registering Ore Materials!");

        Petalite = new Material.Builder(Supersymmetry.id("petalite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd2f7f6)
                .components(Silicon, 4, Oxygen, 10)
                .buildAndRegister();

        Amblygonite = new Material.Builder(Supersymmetry.id("amblygonite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xf7f5d2)
                .components(Oxygen, 4)
                .buildAndRegister()
                .setFormula("(Li,Na)AlPO4(F,OH)", true);


        Thortveitite = new Material.Builder(Supersymmetry.id("thortveitite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xb38969)
                .components(Silicon, 2, Oxygen, 7)
                .buildAndRegister()
                .setFormula("(Sc,Y)2Si2O7", true);


        Perovskite = new Material.Builder(Supersymmetry.id("perovskite"))
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x0b3d1d)
                .components(Oxygen, 3)
                .buildAndRegister();

        Titanomagnetite = new Material.Builder(Supersymmetry.id("titanomagnetite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x555c45)
                .components(Oxygen, 4)
                .buildAndRegister()
                .setFormula("Fe(Fe,Ti)2O4", true);


        Fluorapatite = new Material.Builder(Supersymmetry.id("fluorapatite"))
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xcc9681)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 12)
                .buildAndRegister()
                .setFormula("Ca5(PO4)3F", true);


        VanadiferousTitanomagnetite = new Material.Builder(Supersymmetry.id("vanadiferous_titanomagnetite"))
                .dust().ore().fluid(SuSyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SuSyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING, GENERATE_FLOTATED)
                .color(0x87685c)
                .components(Oxygen, 4)
                .buildAndRegister()
                .setFormula("(V,Fe,Ti)2O4", true);


        Baddeleyite = new Material.Builder(Supersymmetry.id("baddeleyite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3a4f43)
                .components(Oxygen, 2)
                .buildAndRegister()
                .setFormula("ZrO2", true);


        Vanadinite = new Material.Builder(Supersymmetry.id("vanadinite"))
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xbf5915)
                .components(Lead, 5, Vanadium, 3, Oxygen, 12)
                .buildAndRegister()
                .setFormula("Pb5(VO4)3Cl", true);


        Cerussite = new Material.Builder(Supersymmetry.id("cerussite"))
                .dust().ore().fluid(SuSyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SuSyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING)
                .color(0xe0d9ba)
                .components(Oxygen, 3)
                .buildAndRegister();

        Anglesite = new Material.Builder(Supersymmetry.id("anglesite"))
                .dust().ore().fluid(SuSyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SuSyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING)
                .color(0xe0ded5)
                .components(Oxygen, 4)
                .buildAndRegister();

        Enargite = new Material.Builder(Supersymmetry.id("enargite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xc9c7bd)
                .components(Copper, 3, Sulfur, 4)
                .buildAndRegister();

        Smithsonite = new Material.Builder(Supersymmetry.id("smithsonite"))
                .dust().ore().fluid(SuSyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SuSyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING)
                .color(0x6aadab)
                .components(Oxygen, 3)
                .buildAndRegister();

        Arsenopyrite = new Material.Builder(Supersymmetry.id("arsenopyrite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x7d7269)
                .components()
                .buildAndRegister();

        Acanthite = new Material.Builder(Supersymmetry.id("acanthite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x2c332d)
                .components(Silver, 2)
                .buildAndRegister();

        Pyrargyrite = new Material.Builder(Supersymmetry.id("pyrargyrite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x362a2a)
                .components(Silver, 3, Sulfur, 3)
                .buildAndRegister();

        Stephanite = new Material.Builder(Supersymmetry.id("stephanite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x3d3d36)
                .components(Silver, 5, Sulfur, 4)
                .buildAndRegister();

        Proustite = new Material.Builder(Supersymmetry.id("proustite"))
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x73142d)
                .components(Silver, 3, Sulfur, 3)
                .buildAndRegister();

        Celestine = new Material.Builder(Supersymmetry.id("celestine"))
                .dust().gem().ore()
                .flags(NO_SMELTING, GENERATE_SIFTED, GENERATE_FLOTATED)
                .color(0xafe3e0)
                .iconSet(SHINY)
                .components(Oxygen, 4)
                .buildAndRegister();

        Strontianite = new Material.Builder(Supersymmetry.id("strontianite"))
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0xe3d3af)
                .iconSet(SHINY)
                .components(Oxygen, 3)
                .buildAndRegister();

        Witherite = new Material.Builder(Supersymmetry.id("witherite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd1d0bc)
                .components(Oxygen, 3)
                .buildAndRegister();

        Wolframite = new Material.Builder(Supersymmetry.id("wolframite"))
                .dust().ore().fluid(SuSyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SuSyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING, GENERATE_SIFTED, GENERATE_FLOTATED)
                .color(0x1e1c36)
                .components(Oxygen, 4)
                .buildAndRegister()
                .setFormula("(Fe,Mn)WO4", true);


        Rhodplumsite = new Material.Builder(Supersymmetry.id("rhodplumsite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x292726)
                .components(Rhodium, 3, Lead, 2, Sulfur, 2)
                .buildAndRegister();

        Bowieite = new Material.Builder(Supersymmetry.id("bowieite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x323325)
                .components(Rhodium, 2, Sulfur, 3)
                .buildAndRegister()
                .setFormula("(Rh,Ir,Pt)2S3", true);


        Polarite = new Material.Builder(Supersymmetry.id("polarite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x2e360a)
                .components()
                .buildAndRegister()
                .setFormula("Pd(Bi,Pb)", true);

        Livingstonite = new Material.Builder(Supersymmetry.id("livingstonite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x5e5654)
                .components(Antimony, 4, Sulfur, 8)
                .buildAndRegister();

        Bismuthinite = new Material.Builder(Supersymmetry.id("bismuthinite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x85795b)
                .components(Bismuth, 2, Sulfur, 3)
                .buildAndRegister();

        Lorandite = new Material.Builder(Supersymmetry.id("lorandite"))
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0x913111)
                .components(Sulfur, 2)
                .buildAndRegister();

        Hutchinsonite = new Material.Builder(Supersymmetry.id("hutchinsonite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x332f2e)
                .components(Arsenic, 5, Sulfur, 9)
                .buildAndRegister()
                .setFormula("(Tl,Pb)2As5S9", true);


        Crookesite = new Material.Builder(Supersymmetry.id("crookesite"))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3e4a3f)
                .components(Copper, 7, Selenium, 4)
                .buildAndRegister()
                .setFormula("Cu7(Tl,Ag)Se4", true);


        Dilithium = new Material.Builder(Supersymmetry.id("dilithium"))
                .gem().ore()
                .components(Lithium, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister();

        Lignite = new Material.Builder(Supersymmetry.id("lignite"))
                .gem(1, 600).ore(2, 1)
                .color(0x644646).iconSet(LIGNITE)
                .components()
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .buildAndRegister();

        Anthracite = new Material.Builder(Supersymmetry.id("anthracite"))
                .gem(1, 2000).ore(2, 1)
                .color(0x241212).iconSet(LIGNITE)
                .components()
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .buildAndRegister();

        Phosphorite = new Material.Builder(Supersymmetry.id("phosphorite"))
                .ore()
                .iconSet(SHINY)
                .color(0x8a6e42)
                .buildAndRegister();

        Sperrylite = new Material.Builder(Supersymmetry.id("sperrylite"))
                .gem().ore()
                .components(Arsenic, 2)
                .iconSet(SHINY)
                .color(0xb3af86)
                .buildAndRegister();

        Kernite = new Material.Builder(Supersymmetry.id("kernite"))
                .dust()
                .color(0xd9c1a0)
                .components(Sodium, 2, Boron, 4, Oxygen, 8, Hydrogen, 2, Water, 3)
                .buildAndRegister()
                .setFormula("Na2B4O6(OH)2 * (H2O)3", true);

        Colemanite = new Material.Builder(Supersymmetry.id("colemanite"))
                .dust()
                .color(0xdbcd8f)
                .components(Calcium, 2, Boron, 6, Oxygen, 11, Water, 5)
                .buildAndRegister()
                .setFormula("Ca2B6O11 * (H2O)5", true);

        Ulexite = new Material.Builder(Supersymmetry.id("ulexite"))
                .dust()
                .color(0xc2aba1)
                .components(Boron, 5, Oxygen, 12, Hydrogen, 6, Water, 5)
                .buildAndRegister()
                .setFormula("NaCaB5O6(OH)6 * (H2O)5", true);

        Carnallite = new Material.Builder(Supersymmetry.id("carnallite"))
                .dust()
                .iconSet(SHINY)
                .color(0xffffff)
                .components(Chlorine, 3, Water, 6)
                .buildAndRegister()
                .setFormula("KCl.MgCl2 * (H2O)6", true);

        Kainite = new Material.Builder(Supersymmetry.id("kainite"))
                .dust()
                .iconSet(SHINY)
                .color(0xfff7c4)
                .components(Oxygen, 4, Water, 3)
                .buildAndRegister()
                .setFormula("KMg(SO4)Cl * (H2O)3", true);

        Kieserite = new Material.Builder(Supersymmetry.id("kieserite"))
                .dust()
                .color(0xdccade)
                .components(Oxygen, 4)
                .buildAndRegister()
                .setFormula("MgSO4 * H2O", true);

        Polyhalite = new Material.Builder(Supersymmetry.id("polyhalite"))
                .dust()
                .color(0xe0b2a4)
                .components(Potassium, 2, Calcium, 2, Sulfur, 4, Oxygen, 16, Water, 2)
                .buildAndRegister()
                .setFormula("K2Ca2Mg(SO4)4 * (H2O)2", true);

        Titanite = new Material.Builder(Supersymmetry.id("titanite"))
                .gem()
                .iconSet(SHINY)
                .color(0x967051)
                .components(Oxygen, 5)
                .buildAndRegister();

        Leucoxene = new Material.Builder(Supersymmetry.id("leucoxene"))
                .dust()
                .iconSet(SHINY)
                .color(0xb987c4)
                .components(Oxygen, 2)
                .buildAndRegister();

        Zircon = new Material.Builder(Supersymmetry.id("zircon"))
                .gem().ore().liquid().fluid(SuSyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SuSyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .iconSet(SHINY)
                .flags(GENERATE_SIFTED, GENERATE_FLOTATED, GENERATE_CONCENTRATE)
                .color(0xf05c51)
                .components(Oxygen, 4)
                .buildAndRegister();

        Mimetite = new Material.Builder(Supersymmetry.id("mimetite"))
                .dust()
                .iconSet(SHINY)
                .color(0xe8aa2e)
                .components(Lead, 5, Arsenic, 3, Oxygen, 12)
                .buildAndRegister()
                .setFormula("Pb5(AsO4)3Cl", true);

        Pyromorphite = new Material.Builder(Supersymmetry.id("pyromorphite"))
                .dust()
                .iconSet(SHINY)
                .color(0xd7e632)
                .components(Lead, 5, Phosphorus, 4, Oxygen, 12)
                .buildAndRegister()
                .setFormula("Pb5(PO4)3Cl", true);

        Descloizite = new Material.Builder(Supersymmetry.id("descloizite"))
                .dust()
                .iconSet(SHINY)
                .color(0x5e5d41)
                .components(Oxygen, 5)
                .buildAndRegister()
                .setFormula("(Pb,Zn)2VO4OH", true);

        Mottramite = new Material.Builder(Supersymmetry.id("mottramite"))
                .dust()
                .color(0x53730a)
                .components(Oxygen, 5)
                .buildAndRegister()
                .setFormula("PbCu(VO4)(OH)", true);

        Chlorapatite = new Material.Builder(Supersymmetry.id("chlorapatite"))
                .dust().gem().ore()
                .iconSet(SHINY)
                .color(0xc7af85)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 12)
                .buildAndRegister()
                .setFormula("Ca5(PO4)3Cl", true);

        GroovySuSyMaterials.Hematite = new Material.Builder(Supersymmetry.id("hematite"))
                .dust()
                .color(0x240f0f)
                .components(Iron, 2, Oxygen, 3)
                .buildAndRegister();

        Skutterudite = new Material.Builder(Supersymmetry.id("skutterudite"))
                .dust()
                .iconSet(SHINY)
                .color(0xabbec2)
                .components(Arsenic, 3)
                .buildAndRegister();

        Allanite = new Material.Builder(Supersymmetry.id("allanite"))
                .dust()
                .iconSet(SHINY)
                .color(0x6b7a7d)
                .components(Silicon, 3, Oxygen, 13)
                .buildAndRegister()
                .setFormula("(Ce,Ca,Y,La)2(Al,Fe)3(SiO4)3(OH)", true);

        Azurite = new Material.Builder(Supersymmetry.id("azurite"))
                .dust().gem()
                .iconSet(SHINY)
                .color(0x2216c9)
                .components(Copper, 3, Carbon, 2, Oxygen, 8, Hydrogen, 2)
                .buildAndRegister()
                .setFormula("Cu3(CO3)2(OH)2", true);

        GroovySuSyMaterials.Goethite = new Material.Builder(Supersymmetry.id("goethite"))
                .dust()
                .color(0x30251f)
                .components(Oxygen, 2)
                .buildAndRegister()
                .setFormula("α-FeO(OH)", true);

        Hydrozincite = new Material.Builder(Supersymmetry.id("hydrozincite"))
                .dust()
                .color(0xebd5ca)
                .components(Zinc, 5, Carbon, 2, Oxygen, 12, Hydrogen, 6)
                .buildAndRegister()
                .setFormula("Zn5(CO3)2(OH)6", true);

        Chlorargyrite = new Material.Builder(Supersymmetry.id("chlorargyrite"))
                .dust()
                .color(0x524728)
                .components()
                .buildAndRegister();

        Columbite = new Material.Builder(Supersymmetry.id("columbite"))
                .ore().dust().fluid(SuSyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SuSyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .color(0x574f2f)
                .iconSet(SHINY)
                .flags(GENERATE_SIFTED, GENERATE_FLOTATED, GENERATE_CONCENTRATE)
                .components(Niobium, 2, Oxygen, 6)
                .buildAndRegister()
                .setFormula("(Fe,Mn)Nb2O6", true);

        Ferrimolybdite = new Material.Builder(Supersymmetry.id("ferrimolybdite"))
                .dust()
                .color(0xc1c71c)
                .components(Iron, 2, Molybdenum, 3, Oxygen, 12, Water, 8)
                .buildAndRegister()
                .setFormula("Fe2(MoO4)3 * (H2O)8", true);

        Aguilarite = new Material.Builder(Supersymmetry.id("aguilarite"))
                .dust().gem()
                .color(0x303030)
                .iconSet(SHINY)
                .components(Silver, 4)
                .buildAndRegister();

        Orpiment = new Material.Builder(Supersymmetry.id("orpiment"))
                .dust().gem()
                .color(0xc28034)
                .iconSet(SHINY)
                .components(Arsenic, 2, Sulfur, 3)
                .buildAndRegister();

        Braggite = new Material.Builder(Supersymmetry.id("braggite"))
                .ore()
                .color(0x686b5f)
                .components()
                .buildAndRegister()
                .setFormula("(Pt,Pd,Ni)S", true);

        Stannite = new Material.Builder(Supersymmetry.id("stannite"))
                .dust()
                .color(0x474f3e)
                .components(Copper, 2, Sulfur, 4)
                .buildAndRegister();

        Euxenite = new Material.Builder(Supersymmetry.id("euxenite"))
                .dust()
                .color(0x9c973e)
                .components(Oxygen, 6)
                .buildAndRegister()
                .setFormula("(Y,Ca,Ce,U,Th)(Nb,Ta,Ti)2O6", true);

        Xenotime = new Material.Builder(Supersymmetry.id("xenotime"))
                .dust()
                .iconSet(SHINY)
                .color(0x6e572e)
                .components(Oxygen, 4)
                .buildAndRegister();

        Caliche = new Material.Builder(Supersymmetry.id("caliche"))
                .dust()
                .color(0xb3ae98)
                .components(Oxygen, 3)
                .buildAndRegister();

        Lauterite = new Material.Builder(Supersymmetry.id("lauterite"))
                .dust()
                .components(Iodine, 2, Oxygen, 6)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Ca(IO3)2", true);

        Langbeinite = new Material.Builder(Supersymmetry.id("langbeinite"))
                .dust()
                .components(Potassium, 2, Magnesium, 2, Sulfur, 3, Oxygen, 12)
                .colorAverage()
                .buildAndRegister()
                .setFormula("K2Mg2(SO4)3", true);

        Hydroxyapatite = new Material.Builder(Supersymmetry.id("hydroxyapatite"))
                .dust().gem().ore()
                .iconSet(SHINY)
                .color(0xc7afaa)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 13)
                .buildAndRegister()
                .setFormula("Ca5(PO4)3OH", true);

        Rhodochrosite = new Material.Builder(Supersymmetry.id("rhodochrosite"))
                .ore()
                .iconSet(SHINY)
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        Carnotite = new Material.Builder(Supersymmetry.id("carnotite"))
                .ore()
                .components(Potassium, 2, Uranium235, 2, Oxygen, 12, Vanadium, 2, Water, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("K2(UO2)2(VO4)2 * 3H2O", true);


        AlluvialPGMSand = new Material.Builder(Supersymmetry.id("alluvial_pgm_sand"))
                .ore()
                .color(0x948a5d)
                .buildAndRegister();

        LigniteCoke = new Material.Builder(Supersymmetry.id("lignite_coke"))
                .gem(1, 1200)
                .color(0x8f7070).iconSet(LIGNITE)
                .components()
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .buildAndRegister();

        OrthomagmaticDeposit = new Material.Builder(Supersymmetry.id("orthomagmatic_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x80081e)
                .buildAndRegister();

        MetamorphicDeposit = new Material.Builder(Supersymmetry.id("metamorphic_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x21011c)
                .buildAndRegister();

        SedimentaryDeposit = new Material.Builder(Supersymmetry.id("sedimentary_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0xfce46d)
                .buildAndRegister();

        HydrothermalDeposit = new Material.Builder(Supersymmetry.id("hydrothermal_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0xe8e1c1)
                .buildAndRegister();

        AlluvialDeposit = new Material.Builder(Supersymmetry.id("alluvial_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0xb59e35)
                .buildAndRegister();

        MagmaticHydrothermalDeposit = new Material.Builder(Supersymmetry.id("magmatic_hydrothermal_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x91835d)
                .buildAndRegister();
    }
}
