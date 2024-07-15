package belletti.supersymmetry.common.data.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;

import java.util.Arrays;

import static belletti.supersymmetry.common.data.materials.SuSyMaterialFlags.GENERATE_CATALYST_BED;
import static belletti.supersymmetry.common.data.materials.groovy.GroovyGlobals.determineTemperatureLiquid;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_PLATE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.api.fluids.FluidConstants.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.*;

public class GroovySuSyFirstDegreeMaterials {
    private static Material.Builder generatePurifiedElement(Material material, boolean generateLiquid, boolean generateIngot) {
        Material.Builder builder = new Material.Builder(Supersymmetry.id("high_purity_" + material.getName()))
                .dust()
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .color(material.getMaterialRGB())
                .components(material, 1);

        if (generateLiquid) {
            builder.liquid(new FluidBuilder().temperature(determineTemperatureLiquid(material)));
        }

        if (generateIngot) {
            builder.ingot();
        }

        return builder;
    }

    public static void register() {

        Supersymmetry.LOGGER.info("Registering First Degree Materials!");

        // IDs 8000-8100: Pure Elements

        HighPurityLithium = generatePurifiedElement(Lithium, false, false).buildAndRegister();
        HighPurityBeryllium = generatePurifiedElement(Beryllium, false, false).buildAndRegister();
        HighPurityBoron = generatePurifiedElement(Boron, false, false).buildAndRegister();
        HighPurityCarbon = generatePurifiedElement(Carbon, false, false).buildAndRegister();
        HighPuritySodium = generatePurifiedElement(Sodium, false, false).buildAndRegister();
        HighPurityMagnesium = generatePurifiedElement(Magnesium, false, false).buildAndRegister();
        HighPurityAluminium = generatePurifiedElement(Aluminium, false, false).buildAndRegister();
        HighPuritySilicon = generatePurifiedElement(Silicon, true, false).buildAndRegister();
        HighPurityPhosphorus = generatePurifiedElement(Phosphorus, true, true).buildAndRegister();
        HighPuritySulfur = generatePurifiedElement(Sulfur, false, false).buildAndRegister();
        HighPurityPotassium = generatePurifiedElement(Potassium, false, false).buildAndRegister();
        HighPurityCalcium = generatePurifiedElement(Calcium, false, false).buildAndRegister();
        HighPurityScandium = generatePurifiedElement(Scandium, false, false).buildAndRegister();
        HighPurityTitanium = generatePurifiedElement(Titanium, false, false).buildAndRegister();
        HighPurityVanadium = generatePurifiedElement(Vanadium, false, false).buildAndRegister();
        HighPurityChrome = generatePurifiedElement(Chromium, true, false).buildAndRegister();
        HighPurityManganese = generatePurifiedElement(Manganese, false, false).buildAndRegister();
        HighPurityIron = generatePurifiedElement(Iron, false, false).buildAndRegister();
        HighPurityNickel = generatePurifiedElement(Cobalt, false, false).buildAndRegister();
        HighPurityCobalt = generatePurifiedElement(Nickel, false, false).buildAndRegister();
        HighPurityCopper = generatePurifiedElement(Copper, false, false).buildAndRegister();
        HighPurityZinc = generatePurifiedElement(Zinc, false, false).buildAndRegister();
        HighPurityGallium = generatePurifiedElement(Gallium, true, false).buildAndRegister();
        HighPurityGermanium = generatePurifiedElement(Germanium, true, true).buildAndRegister();
        HighPurityArsenic = generatePurifiedElement(Arsenic, true, false).buildAndRegister();
        HighPuritySelenium = generatePurifiedElement(Selenium, true, false).buildAndRegister();
        HighPurityRubidium = generatePurifiedElement(Rubidium, false, false).buildAndRegister();
        HighPurityStronium = generatePurifiedElement(Strontium, false, false).buildAndRegister();
        HighPurityYttrium = generatePurifiedElement(Yttrium, false, false).buildAndRegister();
        HighPurityZirconium = generatePurifiedElement(Zirconium, false, false).buildAndRegister();
        HighPurityNiobium = generatePurifiedElement(Niobium, false, false).buildAndRegister();
        HighPurityMolybdenum = generatePurifiedElement(Molybdenum, false, false).buildAndRegister();
        HighPurityTechnetium = generatePurifiedElement(Technetium, false, false).buildAndRegister();
        HighPurityRuthenium = generatePurifiedElement(Ruthenium, false, false).buildAndRegister();
        HighPurityRhodium = generatePurifiedElement(Rhodium, false, false).buildAndRegister();
        HighPurityPalladium = generatePurifiedElement(Palladium, false, false).buildAndRegister();
        HighPuritySilver = generatePurifiedElement(Silver, false, false).buildAndRegister();
        HighPurityCadmium = generatePurifiedElement(Cadmium, false, false).buildAndRegister();
        HighPurityIndium = generatePurifiedElement(Indium, false, false).flags(GENERATE_PLATE).buildAndRegister();
        HighPurityTin = generatePurifiedElement(Tin, false, false).buildAndRegister();
        HighPurityAntimony = generatePurifiedElement(Antimony, false, false).buildAndRegister();
        HighPurityTellurium = generatePurifiedElement(Tellurium, false, true).buildAndRegister();
        HighPurityIodine = generatePurifiedElement(Iodine, false, false).buildAndRegister();
        HighPurityCaesium = generatePurifiedElement(Caesium, false, false).buildAndRegister();
        HighPurityBarium = generatePurifiedElement(Barium, false, false).buildAndRegister();
        HighPurityLanthanum = generatePurifiedElement(Lanthanum, false, false).buildAndRegister();
        HighPurityHafnium = generatePurifiedElement(Hafnium, false, false).buildAndRegister();
        HighPurityTantalum = generatePurifiedElement(Tantalum, false, false).buildAndRegister();
        HighPurityTungsten = generatePurifiedElement(Tungsten, false, false).buildAndRegister();
        HighPurityRhenium = generatePurifiedElement(Rhenium, false, false).buildAndRegister();
        HighPurityOsmium = generatePurifiedElement(Osmium, false, false).buildAndRegister();
        HighPurityIridium = generatePurifiedElement(Iridium, false, false).buildAndRegister();
        HighPurityPlatinum = generatePurifiedElement(Platinum, false, false).buildAndRegister();
        HighPurityGold = generatePurifiedElement(Gold, false, true).appendFlags(Arrays.asList(GENERATE_FOIL, GENERATE_PLATE)).buildAndRegister();
        HighPurityThallium = generatePurifiedElement(Thallium, false, false).buildAndRegister();
        HighPurityLead = generatePurifiedElement(Lead, false, false).buildAndRegister();
        HighPurityBismuth = generatePurifiedElement(Bismuth, false, false).buildAndRegister();
        HighPurityCerium = generatePurifiedElement(Cerium, false, false).buildAndRegister();
        HighPurityPraesodymium = generatePurifiedElement(Praseodymium, false, false).buildAndRegister();
        HighPurityNeodymium = generatePurifiedElement(Neodymium, false, false).buildAndRegister();
        HighPuritySamarium = generatePurifiedElement(Samarium, false, false).buildAndRegister();
        HighPurityEuropium = generatePurifiedElement(Europium, false, false).buildAndRegister();
        HighPurityGadolinium = generatePurifiedElement(Gadolinium, false, false).buildAndRegister();
        HighPurityTerbium = generatePurifiedElement(Terbium, false, false).buildAndRegister();
        HighPurityDysprosium = generatePurifiedElement(Dysprosium, false, false).buildAndRegister();
        HighPurityHolmium = generatePurifiedElement(Holmium, false, false).buildAndRegister();
        HighPurityErbium = generatePurifiedElement(Erbium, false, false).buildAndRegister();
        HighPurityThulium = generatePurifiedElement(Thulium, false, false).buildAndRegister();
        HighPurityYtterbium = generatePurifiedElement(Ytterbium, false, false).buildAndRegister();
        HighPurityLutetium = generatePurifiedElement(Lutetium, false, false).buildAndRegister();
        HighPurityThorium = generatePurifiedElement(Thorium, false, false).buildAndRegister();

        // IDs 8100+: Other first degree elements

        GroovySuSyMaterials.CalciumHydroxide = new Material.Builder(Supersymmetry.id("calcium_hydroxide"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .color(0xcfcabc)
                .buildAndRegister()
                .setFormula("Ca(OH)2", true);

        GroovySuSyMaterials.PotassiumHydroxide = new Material.Builder(Supersymmetry.id("potassium_hydroxide"))
                .dust().liquid(new FluidBuilder().temperature(683))
                .components()
                .colorAverage()
                .buildAndRegister();

        GroovySuSyMaterials.PotassiumCarbonate = new Material.Builder(Supersymmetry.id("potassium_carbonate"))
                .dust().liquid(new FluidBuilder().temperature(1164))
                .components(Potassium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumSilicate = new Material.Builder(Supersymmetry.id("sodium_silicate"))
                .dust()
                .components(Sodium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumAluminate = new Material.Builder(Supersymmetry.id("sodium_aluminate"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        PotassiumBisulfate = new Material.Builder(Supersymmetry.id("potassium_bisulfate"))
                .dust().liquid(new FluidBuilder().temperature(470))
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        AmmoniumNitrate = new Material.Builder(Supersymmetry.id("ammonium_nitrate"))
                .dust()
                .components(Nitrogen, 2, Oxygen, 3, Hydrogen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("NH4NO3", true);

        AmmoniumSulfate = new Material.Builder(Supersymmetry.id("ammonium_sulfate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NH4)2SO4", true);


        SodiumNitrate = new Material.Builder(Supersymmetry.id("sodium_nitrate"))
                .dust().liquid(new FluidBuilder().temperature(581))
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumFluoride = new Material.Builder(Supersymmetry.id("sodium_fluoride"))
                .dust().liquid(new FluidBuilder().temperature(1266))
                .components()
                .colorAverage()
                .buildAndRegister();

        PotassiumFluoride = new Material.Builder(Supersymmetry.id("potassium_fluoride"))
                .dust().liquid(new FluidBuilder().temperature(1131))
                .components()
                .colorAverage()
                .buildAndRegister();

        PotassiumTetrafluoroborate = new Material.Builder(Supersymmetry.id("potassium_tetrafluoroborate"))
                .dust().liquid(new FluidBuilder().temperature(803))
                .components(Fluorine, 4)
                .color(0x8fb5a3)
                .buildAndRegister();

        SodiumBromide = new Material.Builder(Supersymmetry.id("sodium_bromide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        Fluix = new Material.Builder(Supersymmetry.id("fluix"))
                .gem().iconSet(RUBY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_LENS)
                .components(Quartzite, 4)
                .color(0x6503b6)
                .buildAndRegister();

        PigIron = new Material.Builder(Supersymmetry.id("pig_iron"))
                .ingot().dust()
                .components()
                .color(0x99918A)
                .buildAndRegister()
                .setFormula("(Fe)(?)", true);


        GreenCoke = new Material.Builder(Supersymmetry.id("green_coke"))
                .gem(1, 2000).ore(2, 1)
                .color(0x424a34).iconSet(LIGNITE)
                .components()
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .buildAndRegister();

        IronIIISulfate = new Material.Builder(Supersymmetry.id("iron_iii_sulfate"))
                .dust()
                .color(0xb09d99)
                .components(Iron, 2, Sulfur, 3, Oxygen, 12)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .buildAndRegister()
                .setFormula("Fe2(SO4)3", true);

        AluminiumHydroxide = new Material.Builder(Supersymmetry.id("aluminium_hydroxide"))
                .dust()
                .components(Oxygen, 3, Hydrogen, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Al(OH)3", true);

        AluminiumTrifluoride = new Material.Builder(Supersymmetry.id("aluminium_trifluoride"))
                .dust()
                .components(Fluorine, 3)
                .color(0x3d98bf)
                .buildAndRegister();

        GalliumPhosphate = new Material.Builder(Supersymmetry.id("gallium_phosphate"))
                .gem().iconSet(RUBY)
                .flags(CRYSTALLIZABLE)
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("GaPO4", true);


        LithiumNiobate = new Material.Builder(Supersymmetry.id("lithium_niobate"))
                .dust().gem().iconSet(RUBY)
                .components(Oxygen, 3)
                .color(0xbcabde)
                .buildAndRegister();

        LeadZirconateTitanate = new Material.Builder(Supersymmetry.id("lead_zirconate_titanate"))
                .gem().iconSet(RUBY)
                .components(Lead, 2, Oxygen, 6)
                .colorAverage()
                .buildAndRegister();

        BoricAcid = new Material.Builder(Supersymmetry.id("boric_acid"))
                .dust()
                .color(0xedece8)
                .components(Hydrogen, 3, Oxygen, 3)
                .buildAndRegister();

        AmorphousBoron = new Material.Builder(Supersymmetry.id("amorphous_boron"))
                .dust()
                .color(0x47464b)
                .buildAndRegister();

        SulfurDichloride = new Material.Builder(Supersymmetry.id("sulfur_dichloride"))
                .liquid()
                .components(Chlorine, 2)
                .color(0xd2042d)
                .buildAndRegister();

        BoronTrioxide = new Material.Builder(Supersymmetry.id("boron_trioxide"))
                .dust().liquid(new FluidBuilder().temperature(723))
                .color(0xdfcfc2)
                .components(Boron, 2, Oxygen, 3)
                .buildAndRegister();

        ZincChloride = new Material.Builder(Supersymmetry.id("zinc_chloride"))
                .dust().liquid(new FluidBuilder().temperature(563))
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumTetraborate = new Material.Builder(Supersymmetry.id("sodium_tetraborate"))
                .dust()
                .components(Sodium, 2, Boron, 4, Oxygen, 7)
                .color(0xdbe7db)
                .buildAndRegister();

        ElectrolyticBoron = new Material.Builder(Supersymmetry.id("electrolytic_boron"))
                .dust()
                .components()
                .color(0x9bd4af)
                .buildAndRegister();

        CalciumSulfate = new Material.Builder(Supersymmetry.id("calcium_sulfate"))
                .dust()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        IronIISulfide = new Material.Builder(Supersymmetry.id("iron_ii_sulfide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        GroovySuSyMaterials.PotassiumSulfate = new Material.Builder(Supersymmetry.id("potassium_sulfate"))
                .dust()
                .components(Potassium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        WetAntimonyTrifluoride = new Material.Builder(Supersymmetry.id("wet_antimony_trifluoride"))
                .dust()
                .components(Fluorine, 3)
                .colorAverage()
                .buildAndRegister();

        CalciumSulfide = new Material.Builder(Supersymmetry.id("calcium_sulfide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        VanadiumPentoxide = new Material.Builder(Supersymmetry.id("vanadium_pentoxide"))
                .dust()
                .components(Vanadium, 2, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        PotassiumPersulfate = new Material.Builder(Supersymmetry.id("potassium_persulfate"))
                .dust()
                .components(Potassium, 2, Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .buildAndRegister();

        LithiumHydroxide = new Material.Builder(Supersymmetry.id("lithium_hydroxide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        CalciumCarbide = new Material.Builder(Supersymmetry.id("calcium_carbide"))
                .dust()
                .components(Carbon, 2)
                .color(0x87847c)
                .buildAndRegister();

        IronIIChloride = new Material.Builder(Supersymmetry.id("iron_ii_chloride"))
                .dust()
                .components(Chlorine, 2)
                .color(0x9dad37)
                .buildAndRegister();

        CuprousOxide = new Material.Builder(Supersymmetry.id("cuprous_oxide"))
                .dust()
                .components(Copper, 2)
                .flags(GENERATE_CATALYST_BED)
                .color(0x822635)
                .buildAndRegister();

        LithiumBromide = new Material.Builder(Supersymmetry.id("lithium_bromide"))
                .dust()
                .components()
                .color(0xC5C5C5)
                .buildAndRegister();

        IronIIIOxide = new Material.Builder(Supersymmetry.id("iron_iii_oxide"))
                .dust()
                .components(Iron, 2, Oxygen, 3)
                .flags(GENERATE_CATALYST_BED)
                .color(0x8F0C03)
                .buildAndRegister();

        CopperIIChloride = new Material.Builder(Supersymmetry.id("copper_ii_chloride"))
                .dust()
                .components(Chlorine, 2)
                .flags(GENERATE_CATALYST_BED)
                .color(0x12112c)
                .buildAndRegister();

        SiliconCarbide = new Material.Builder(Supersymmetry.id("silicon_carbide"))
                .dust()
                .flags(GENERATE_PLATE)
                .components()
                .color(0x404040)
                .buildAndRegister();

        TungstenTrioxide = new Material.Builder(Supersymmetry.id("tungsten_trioxide"))
                .dust()
                .components(Oxygen, 3)
                .color(0x8a9734)
                .buildAndRegister();

        Alumina = new Material.Builder(Supersymmetry.id("alumina"))
                .dust().liquid(new FluidBuilder().temperature(2345))
                .flags(GENERATE_PLATE)
                .components(Aluminium, 2, Oxygen, 3)
                .color(0xd0cff7)
                .buildAndRegister();

        BoronCarbide = new Material.Builder(Supersymmetry.id("boron_carbide"))
                .dust()
                .components(Boron, 4)
                .flags(GENERATE_ROD)
                .colorAverage()
                .buildAndRegister();

        SilverChloride = new Material.Builder(Supersymmetry.id("silver_chloride"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        ArsenicIIISulfide = new Material.Builder(Supersymmetry.id("arsenic_iii_sulfide"))
                .dust()
                .components(Arsenic, 2, Sulfur, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumArsenide = new Material.Builder(Supersymmetry.id("sodium_arsenide"))
                .dust()
                .components(Sodium, 3)
                .colorAverage()
                .buildAndRegister();

        ArsenicVSulfide = new Material.Builder(Supersymmetry.id("arsenic_v_sulfide"))
                .dust()
                .components(Arsenic, 2, Sulfur, 5)
                .colorAverage()
                .buildAndRegister();

        CopperSulfate = new Material.Builder(Supersymmetry.id("copper_sulfate"))
                .dust()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        RoastedSperrylite = new Material.Builder(Supersymmetry.id("roasted_sperrylite"))
                .dust()
                .components()
                .color(0x3b1754)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SAND)
                .buildAndRegister();

        EnargiteResidue = new Material.Builder(Supersymmetry.id("enargite_residue"))
                .dust()
                .components(Copper, 2)
                .color(0x59183c)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(BRIGHT)
                .buildAndRegister()
                .setFormula("(?)Cu2S", true);

        HydrogenChloride = new Material.Builder(Supersymmetry.id("hydrogen_chloride"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister();

        HydrogenFluoride = new Material.Builder(Supersymmetry.id("hydrogen_fluoride"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister();

        DilutedSaltwater = new Material.Builder(Supersymmetry.id("diluted_saltwater"))
                .liquid()
                .components(Water, 2)
                .color(0x3d61b8)
                .buildAndRegister();

        SodiumHydroxideSolution = new Material.Builder(Supersymmetry.id("sodium_hydroxide_solution"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister();

        IronIIIChlorideSolution = new Material.Builder(Supersymmetry.id("iron_iii_chloride_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister();

        DilutedSaltpeterSolution = new Material.Builder(Supersymmetry.id("diluted_saltpeter_solution"))
                .liquid()
                .components(Water, 2)
                .colorAverage()
                .buildAndRegister();

        HydrogenBromide = new Material.Builder(Supersymmetry.id("hydrogen_bromide"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister();

        DilutedCalciumChlorideSolution = new Material.Builder(Supersymmetry.id("diluted_calcium_chloride_solution"))
                .liquid()
                .components(Water, 2)
                .colorAverage()
                .buildAndRegister();

        DilutedRockSaltSolution = new Material.Builder(Supersymmetry.id("diluted_rock_salt_solution"))
                .liquid()
                .components(Water, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumThioantimoniteSolution = new Material.Builder(Supersymmetry.id("sodium_thioantimonite_solution"))
                .liquid()
                .components(Sodium, 12, Antimony, 4, Sulfur, 12, Water, 12)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na3SbS3)12(H2O)12", true);


        AmmoniaSolution = new Material.Builder(Supersymmetry.id("ammonia_solution"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister();

        SaltpeterSolution = new Material.Builder(Supersymmetry.id("saltpeter_solution"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister();

        SaltySaltpeterSolution = new Material.Builder(Supersymmetry.id("salty_saltpeter_solution"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister();

        CarbonDisulfide = new Material.Builder(Supersymmetry.id("carbon_disulfide"))
                .liquid()
                .components(Sulfur, 2)
                .colorAverage()
                .buildAndRegister();

        CopperISulfide = new Material.Builder(Supersymmetry.id("copper_i_sulfide"))
                .dust()
                .components(Copper, 2)
                .color(0x1a1101)
                .buildAndRegister();

        Cryolite = new Material.Builder(Supersymmetry.id("cryolite"))
                .dust().liquid(new FluidBuilder().temperature(1285))
                .components(Sodium, 3, Fluorine, 6)
                .color(0x2497a6)
                .buildAndRegister();

        HeavyWater = new Material.Builder(Supersymmetry.id("heavy_water"))
                .liquid()
                .components(Deuterium, 2)
                .color(0x2c37b0)
                .buildAndRegister();

        HeavyHydrogenSulfide = new Material.Builder(Supersymmetry.id("heavy_hydrogen_sulfide"))
                .gas()
                .components(Deuterium, 2)
                .color(0xb09a2c)
                .buildAndRegister();

        SemiHeavyHydrogenSulfide = new Material.Builder(Supersymmetry.id("semiheavy_hydrogen_sulfide"))
                .gas()
                .components()
                .color(0xc29836)
                .buildAndRegister();

        SemiHeavyWater = new Material.Builder(Supersymmetry.id("semiheavy_water"))
                .liquid()
                .components()
                .color(0x364ec2)
                .buildAndRegister();

        ImpureSemiheavyWater = new Material.Builder(Supersymmetry.id("impure_semiheavy_water"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister();

        IsotopicallyPureHydrogenSulfide = new Material.Builder(Supersymmetry.id("isotopically_pure_hydrogen_sulfide"))
                .gas()
                .components()
                .color(0xffab66)
                .buildAndRegister();

        ImpureSemiheavyHydrogenSulfide = new Material.Builder(Supersymmetry.id("impure_semiheavy_hydrogen_sulfide"))
                .gas()
                .components()
                .colorAverage()
                .buildAndRegister();

        ImpureHeavyHydrogenSulfide = new Material.Builder(Supersymmetry.id("impure_heavy_hydrogen_sulfide"))
                .gas()
                .components()
                .colorAverage()
                .buildAndRegister();

        TetrafluoroboricAcid = new Material.Builder(Supersymmetry.id("tetrafluoroboric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Fluorine, 4, Water, 3)
                .color(0xa4ab91)
                .buildAndRegister();

        BoronTrichloride = new Material.Builder(Supersymmetry.id("boron_trichloride"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID)).plasma()
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister();

        ProustiteAlkalineLeachSolution = new Material.Builder(Supersymmetry.id("proustite_alkaline_leach_solution"))
                .liquid()
                .components(Sodium, 3, Sulfur, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na3AsS3)(H2O)", true);

        CrudeArsenicTrichloride = new Material.Builder(Supersymmetry.id("crude_arsenic_trichloride"))
                .liquid()
                .components(Chlorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(AsCl3)", true);

        Arsine = new Material.Builder(Supersymmetry.id("arsine"))
                .gas()
                .components(Hydrogen, 3)
                .colorAverage()
                .buildAndRegister();

        EnargiteSulfideLeachSolution = new Material.Builder(Supersymmetry.id("enargite_sulfide_leach_solution"))
                .liquid()
                .components(Sodium, 3, Sulfur, 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na3AsS4)(H2O)", true);

        CobaltiteLeachSolution = new Material.Builder(Supersymmetry.id("cobaltite_leach_solution"))
                .liquid()
                .components(Cobalt, 3, Nitrogen, 6, Oxygen, 30, Hydrogen, 9, Arsenic, 3, Water, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Co(NO3)2)3(H3AsO4)3(H2O)3", true);

        ArsenopyriteLeachSolution = new Material.Builder(Supersymmetry.id("arsenopyrite_leach_solution"))
                .liquid()
                .components(Iron, 3, Nitrogen, 6, Oxygen, 32, Hydrogen, 13, Arsenic, 3, Water, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Fe(NO3)2)3(H3AsO4)3(H2O)3", true);

        CopperIISulfide = new Material.Builder(Supersymmetry.id("copper_ii_sulfide"))
                .dust()
                .components()
                .color(0x262626)
                .buildAndRegister();

        ArsenicTrichloride = new Material.Builder(Supersymmetry.id("arsenic_trichloride"))
                .liquid()
                .components(Chlorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister();

        PotassiumPermanganate = new Material.Builder(Supersymmetry.id("potassium_permanganate"))
                .dust()
                .components(Oxygen, 4)
                .color(0x320354)
                .buildAndRegister();

        SperryliteWaste = new Material.Builder(Supersymmetry.id("sperrylite_waste"))
                .liquid()
                .components(Chlorine, 4, Water, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Ni,Co)Cl2(H2O)4", true);

        AcidicCopperSolution = new Material.Builder(Supersymmetry.id("acidic_copper_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Copper, 2, Sulfur, 2, Oxygen, 8, NitricAcid, 2, Water, 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(CuSO4)2(HNO3)2(H2O)4", true);

        WustiteCatalyst = new Material.Builder(Supersymmetry.id("wustite_catalyst"))
                .dust()
                .components()
                .color(0x696e62)
                .buildAndRegister();

        PalladiumChloride = new Material.Builder(Supersymmetry.id("palladium_chloride"))
                .dust()
                .iconSet(SHINY)
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        HexachloroiridicAcid = new Material.Builder(Supersymmetry.id("hexachloroiridic_acid"))
                .dust()
                .iconSet(SHINY)
                .components(Chlorine, 6, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister();

        GroovySuSyMaterials.PotassiumIodide = new Material.Builder(Supersymmetry.id("potassium_iodide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        IridiumIodide = new Material.Builder(Supersymmetry.id("iridium_iodide"))
                .dust()
                .components(Iodine, 4)
                .colorAverage()
                .buildAndRegister();

        PhosphorusTrichloride = new Material.Builder(Supersymmetry.id("phosphorus_trichloride"))
                .liquid()
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister();

        Diamminedichloropalladium = new Material.Builder(Supersymmetry.id("diamminedichloropalladium"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 6, Chlorine, 2)
                .color(0xd4d192)
                .buildAndRegister()
                .setFormula("Pd(NH3)2Cl2", true);


        DecarburizedAir = new Material.Builder(Supersymmetry.id("decarburized_air"))
                .gas()
                .components(Nitrogen, 78, Oxygen, 21)
                .color(0x90bbe0)
                .buildAndRegister();

        ZincOxide = new Material.Builder(Supersymmetry.id("zinc_oxide"))
                .dust()
                .components()
                .color(0xFFFFF5)
                .buildAndRegister();

        HydrogenSilsesquioxane = new Material.Builder(Supersymmetry.id("hydrogen_silsesquioxane"))
                .dust()
                .color(0xC7C0CB)
                .components(Hydrogen, 8, Silicon, 8, Oxygen, 12)
                .buildAndRegister();

        SodiumDichromate = new Material.Builder(Supersymmetry.id("sodium_dichromate"))
                .dust()
                .components(Sodium, 2, Chromium, 2, Oxygen, 7)
                .colorAverage()
                .buildAndRegister();

        RaneyNickel = new Material.Builder(Supersymmetry.id("raney_nickel"))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0x858aa1)
                .buildAndRegister();

        ActivatedRaneyNickel = new Material.Builder(Supersymmetry.id("activated_raney_nickel"))
                .dust()
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0xa9aec4)
                .buildAndRegister();

        PurifiedAntimonyTrichloride = new Material.Builder(Supersymmetry.id("purified_antimony_trichloride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(347))
                .components(Antimony, 1, Chlorine, 3)
                .color(0x83b87b)
                .buildAndRegister();

        PurifiedAntimonyTrioxide = new Material.Builder(Supersymmetry.id("purified_antimony_trioxide"))
                .dust()
                .components(Antimony, 2, Oxygen, 3)
                .color(0x92d1d4)
                .buildAndRegister();

        DicobaltOctacarbonyl = new Material.Builder(Supersymmetry.id("dicobalt_octacarbonyl"))
                .dust()
                .components(Cobalt, 2, Cobalt, 8, Oxygen, 8)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Co2(CO)8", true);

        ImpregnatedAluminaCatalyst = new Material.Builder(Supersymmetry.id("impregnated_alumina_catalyst"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        BismuthCopper = new Material.Builder(Supersymmetry.id("bismuth_copper"))
                .dust()
                .components()
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .buildAndRegister();

        Bromobenzene = new Material.Builder(Supersymmetry.id("bromobenzene"))
                .liquid()
                .components(Carbon, 6, Hydrogen, 5)
                .colorAverage()
                .buildAndRegister();

        ManganeseIISulfate = new Material.Builder(Supersymmetry.id("manganese_ii_sulfate"))
                .dust()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        Triethylaluminium = new Material.Builder(Supersymmetry.id("triethylaluminium"))
                .liquid()
                .components(Carbon, 12, Hydrogen, 30, Aluminium, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Al2(C2H5)6", true);


        HydrogenPeroxide = new Material.Builder(Supersymmetry.id("hydrogen_peroxide"))
                .liquid()
                .components(Hydrogen, 2, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        CarbonTetrabromide = new Material.Builder(Supersymmetry.id("carbon_tetrabromide"))
                .dust()
                .components(Bromine, 4)
                .colorAverage()
                .buildAndRegister();

        Bromomethane = new Material.Builder(Supersymmetry.id("bromomethane"))
                .gas()
                .components(Hydrogen, 3)
                .colorAverage()
                .buildAndRegister();

        VeryDilutedSulfuricAcid = new Material.Builder(Supersymmetry.id("very_diluted_sulfuric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Water, 2)
                .color(0x54362c)
                .buildAndRegister();

        HeavyNetherGases = new Material.Builder(Supersymmetry.id("heavy_nether_gases"))
                .gas()
                .components(CarbonDioxide, 3)
                .colorAverage()
                .buildAndRegister();

        ThionylChloride = new Material.Builder(Supersymmetry.id("thionyl_chloride"))
                .liquid()
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        LithiumHydride = new Material.Builder(Supersymmetry.id("lithium_hydride"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        BoronTrifluoride = new Material.Builder(Supersymmetry.id("boron_trifluoride"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Fluorine, 3)
                .colorAverage()
                .buildAndRegister();

        Diborane = new Material.Builder(Supersymmetry.id("diborane"))
                .gas()
                .components(Boron, 2, Hydrogen, 6)
                .color(0x524545)
                .buildAndRegister();

        LithiumFluoride = new Material.Builder(Supersymmetry.id("lithium_fluoride"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        LithiumTetrafluoroborate = new Material.Builder(Supersymmetry.id("lithium_tetrafluoroborate"))
                .dust()
                .components(Fluorine, 4)
                .colorAverage()
                .buildAndRegister();

        TetramethylammoniumChloride = new Material.Builder(Supersymmetry.id("tetramethylammonium_chloride"))
                .dust()
                .components(Carbon, 4, Hydrogen, 12)
                .colorAverage()
                .buildAndRegister();

        TetramethylammoniumHydroxide = new Material.Builder(Supersymmetry.id("tetramethylammonium_hydroxide"))
                .dust()
                .components(Carbon, 4, Hydrogen, 13)
                .colorAverage()
                .buildAndRegister();

        MethacrylamideSulfate = new Material.Builder(Supersymmetry.id("methacrylamide_sulfate"))
                .dust()
                .components(Carbon, 4, Hydrogen, 9, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        AmmoniumBisulfate = new Material.Builder(Supersymmetry.id("ammonium_bisulfate"))
                .dust().liquid(new FluidBuilder().temperature(563))
                .components(Hydrogen, 5, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NH4)HSO4", true);

        Phosphine = new Material.Builder(Supersymmetry.id("phosphine"))
                .gas()
                .components(Hydrogen, 3)
                .colorAverage()
                .buildAndRegister();

        PotassiumHypophosphite = new Material.Builder(Supersymmetry.id("potassium_hypophosphite"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumHypophosphite = new Material.Builder(Supersymmetry.id("sodium_hypophosphite"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister();

        DipotassiumPhosphate = new Material.Builder(Supersymmetry.id("dipotassium_phosphate"))
                .dust()
                .components(Potassium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        DisodiumPhosphate = new Material.Builder(Supersymmetry.id("disodium_phosphate"))
                .dust()
                .components(Sodium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        SodiumCyanide = new Material.Builder(Supersymmetry.id("sodium_cyanide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        PhosphorylChloride = new Material.Builder(Supersymmetry.id("phosphoryl_chloride"))
                .liquid()
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister();

        PhosphorusPentachloride = new Material.Builder(Supersymmetry.id("phosphorus_pentachloride"))
                .dust()
                .components(Chlorine, 5)
                .colorAverage()
                .buildAndRegister();

        AmmoniumIodide = new Material.Builder(Supersymmetry.id("ammonium_iodide"))
                .dust().liquid(new FluidBuilder().temperature(824))
                .components(Hydrogen, 4)
                .colorAverage()
                .buildAndRegister();

        HydrobromicAcid = new Material.Builder(Supersymmetry.id("hydrobromic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister()
                .setFormula("(HBr)(H2O)", true);


        AluminiumChloride = new Material.Builder(Supersymmetry.id("aluminium_chloride"))
                .dust().gas(new FluidBuilder().temperature(453))
                .flags(GENERATE_CATALYST_BED)
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumSulfite = new Material.Builder(Supersymmetry.id("sodium_sulfite"))
                .dust()
                .components(Sodium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumThiosulfate = new Material.Builder(Supersymmetry.id("sodium_thiosulfate"))
                .dust()
                .components(Sodium, 2, Sulfur, 2, Oxygen, 3)
                .color(0x879e21)
                .buildAndRegister();

        SulfidicSilverCyanideSolution = new Material.Builder(Supersymmetry.id("sulfidic_silver_cyanide_solution"))
                .liquid()
                .components(Silver, 2, Carbon, 4, Nitrogen, 4, Sodium, 4, Water, 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister();

        SilverCyanideSolution = new Material.Builder(Supersymmetry.id("silver_cyanide_solution"))
                .liquid()
                .components(Silver, 2, Carbon, 4, Nitrogen, 4, Sodium, 4, Chlorine, 2, Water, 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na[Ag(CN)2])2(NaCl)2(H2O)4", true);

        SulfidicPyrargyriteCyanideLeachSolution = new Material.Builder(Supersymmetry.id("sulfidic_pyrargyrite_cyanide_leach_solution"))
                .liquid()
                .components(Sodium, 6, Silver, 3, Carbon, 6, Nitrogen, 6, Sulfur, 3, Water, 6)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na[Ag(CN)2])3(Na3SbS3)(H2O)6", true);

        PyrargyriteCyanideLeachSolution = new Material.Builder(Supersymmetry.id("pyrargyrite_cyanide_leach_solution"))
                .liquid()
                .components(Sodium, 6, Silver, 3, Carbon, 6, Nitrogen, 6, Chlorine, 3, Water, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na[Ag(CN)2])3(NaCl)2(NaSbCl4)(H2O)6", true);

        PyrargyriteThiosulfateLeachSolution = new Material.Builder(Supersymmetry.id("pyrargyrite_thiosulfate_leach_solution"))
                .liquid()
                .components(Sodium, 12, Silver, 3, Sulfur, 15, Oxygen, 18, Water, 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na3[Ag(S2O3)2])3(Na3SbS3)(H2O)5", true);

        ThiosulfateThioantimoniteSolution = new Material.Builder(Supersymmetry.id("thiosulfate_thioantimonite_solution"))
                .liquid()
                .components(Sodium, 15, Sulfur, 15, Oxygen, 18, Water, 5)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na2S2O3)6(Na3SbS3)(H2O)5", true);

        ThiosulfateThioarseniteSolution = new Material.Builder(Supersymmetry.id("thiosulfate_thioarsenite_solution"))
                .liquid()
                .components(Sodium, 15, Sulfur, 15, Oxygen, 18, Water, 5)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na2S2O3)6(Na3AsS3)(H2O)5", true);

        SulfidicStephaniteCyanideLeachSolution = new Material.Builder(Supersymmetry.id("sulfidic_stephanite_cyanide_leach_solution"))
                .liquid()
                .components(Sodium, 10, Silver, 5, Carbon, 10, Nitrogen, 10, Sulfur, 4, Water, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na[Ag(CN)2])5(Na3SbS3)(Na2S)(H2O)12", true);

        StephaniteCyanideLeachSolution = new Material.Builder(Supersymmetry.id("stephanite_cyanide_leach_solution"))
                .liquid()
                .components(Sodium, 10, Silver, 5, Carbon, 10, Nitrogen, 10, Chlorine, 5, Water, 20)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na[Ag(CN)2])5(NaCl)2(NaSbCl6)(H2O)20", true);

        ProustiteThiosulfateLeachSolution = new Material.Builder(Supersymmetry.id("proustite_thiosulfate_leach_solution"))
                .liquid()
                .components(Sodium, 12, Silver, 3, Sulfur, 15, Oxygen, 18, Water, 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na3[Ag(S2O3)2])3(Na3AsS3)(H2O)5", true);

        AcidicArsenateVSolution = new Material.Builder(Supersymmetry.id("acidic_arsenate_v_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 9, Arsenic, 3, Oxygen, 12, NitricAcid, 6)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H3AsO4)3(HNO3)6", true);

        ArsenicVOxide = new Material.Builder(Supersymmetry.id("arsenic_v_oxide"))
                .dust()
                .components(Arsenic, 2, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        SilverOxide = new Material.Builder(Supersymmetry.id("silver_oxide"))
                .dust()
                .components(Silver, 2)
                .colorAverage()
                .buildAndRegister();

        SilverSulfide = new Material.Builder(Supersymmetry.id("silver_sulfide"))
                .dust()
                .components(Silver, 2)
                .colorAverage()
                .buildAndRegister();

        IronThioantimonite = new Material.Builder(Supersymmetry.id("iron_thioantimonite"))
                .dust()
                .components(Sulfur, 3)
                .colorAverage()
                .buildAndRegister();

        AntimonyIIISulfide = new Material.Builder(Supersymmetry.id("antimony_iii_sulfide"))
                .dust()
                .components(Antimony, 2, Sulfur, 3)
                .colorAverage()
                .buildAndRegister();

        IronThioarsenite = new Material.Builder(Supersymmetry.id("iron_thioarsenite"))
                .dust()
                .components(Sulfur, 3)
                .colorAverage()
                .buildAndRegister();

        ManganeseIIOxide = new Material.Builder(Supersymmetry.id("manganese_ii_oxide"))
                .dust()
                .components()
                .color(0x472400)
                .iconSet(SAND)
                .buildAndRegister();

        RaneyCobalt = new Material.Builder(Supersymmetry.id("raney_cobalt"))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0x1858a1)
                .buildAndRegister();

        ActivatedRaneyCobalt = new Material.Builder(Supersymmetry.id("activated_raney_cobalt"))
                .dust()
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0x3274bf)
                .buildAndRegister();

        IronIIIHydroxide = new Material.Builder(Supersymmetry.id("iron_iii_hydroxide"))
                .dust()
                .components(Oxygen, 3, Hydrogen, 3)
                .color(0xcc7e35)
                .iconSet(SAND)
                .buildAndRegister()
                .setFormula("Fe(OH)3", true);

        Cellulose = new Material.Builder(Supersymmetry.id("cellulose"))
                .dust()
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .color(0x4a432f)
                .buildAndRegister();

        CrudeGalliumTrichloride = new Material.Builder(Supersymmetry.id("crude_gallium_trichloride"))
                .dust().liquid(new FluidBuilder().temperature(351))
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)GaCl3", true);

        GalliumTrichloride = new Material.Builder(Supersymmetry.id("gallium_trichloride"))
                .liquid(new FluidBuilder().temperature(351))
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("GaCl3", true);

        MercuryIIChloride = new Material.Builder(Supersymmetry.id("mercury_ii_chloride"))
                .dust()
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        BoronNitride = new Material.Builder(Supersymmetry.id("boron_nitride"))
                .dust()
                .flags(GENERATE_PLATE)
                .components()
                .colorAverage()
                .buildAndRegister();

        CrudeIronPentacarbonyl = new Material.Builder(Supersymmetry.id("crude_iron_pentacarbonyl"))
                .liquid()
                .components(Carbon, 5, Oxygen, 5)
                .color(0x362f2b)
                .buildAndRegister()
                .setFormula("Fe(CO)5", true);

        AluminiumSulfate = new Material.Builder(Supersymmetry.id("aluminium_sulfate"))
                .dust()
                .components(Aluminium, 2, Sulfur, 3, Oxygen, 12)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Al2(SO4)3", true);


        DemineralizedWater = new Material.Builder(Supersymmetry.id("demineralized_water"))
                .liquid()
                .components(Hydrogen, 2)
                .color(0x4761a8)
                .buildAndRegister();

        DeaeratedWater = new Material.Builder(Supersymmetry.id("deaerated_water"))
                .liquid()
                .components(Hydrogen, 2)
                .color(0x5681b3)
                .buildAndRegister();

        FilteredWater = new Material.Builder(Supersymmetry.id("filtered_water"))
                .liquid()
                .components(Hydrogen, 2)
                .color(0x62a0bd)
                .buildAndRegister();

        SterilizedWater = new Material.Builder(Supersymmetry.id("sterilized_water"))
                .liquid()
                .components(Hydrogen, 2)
                .color(0x6cb3c4)
                .buildAndRegister();

        UltrapureWater = new Material.Builder(Supersymmetry.id("ultrapure_water"))
                .liquid()
                .components(Hydrogen, 2)
                .color(0x7acacf)
                .buildAndRegister();

        Ferrochromium = new Material.Builder(Supersymmetry.id("ferrochromium"))
                .dust()
                .components(Chromium, 2)
                .color(0x6b6552)
                .buildAndRegister();

        Ferrosilicon = new Material.Builder(Supersymmetry.id("ferrosilicon"))
                .dust()
                .components(Silicon, 3)
                .iconSet(SHINY)
                .color(0x999a99)
                .buildAndRegister();

        ConcentratedSaltWater = new Material.Builder(Supersymmetry.id("concentrated_salt_water"))
                .liquid()
                .components(Salt, 2)
                .colorAverage()
                .buildAndRegister();

        HypersalineWater = new Material.Builder(Supersymmetry.id("hypersaline_water"))
                .liquid()
                .components(Salt, 4)
                .colorAverage()
                .buildAndRegister();

        CryogenicSolder = new Material.Builder(Supersymmetry.id("cryogenic_solder"))
                .dust().ingot().liquid(new FluidBuilder().temperature(430))
                .components(Indium, 27, Silver, 1)
                .color(0x8967bf)
                .buildAndRegister()
                .setFormula("In97Ag3", true);



        LithiumCobaltOxide = new Material.Builder(Supersymmetry.id("lithium_cobalt_oxide"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumCathodeAlloy = new Material.Builder(Supersymmetry.id("sodium_cathode_alloy"))
                .dust()
                .components(Sodium, 4, Iron, 3, Manganese, 3, Oxygen, 12)
                .colorAverage()
                .buildAndRegister();

        LithiumHexafluorophosphate = new Material.Builder(Supersymmetry.id("lithium_hexafluorophosphate"))
                .dust()
                .components(Fluorine, 6)
                .colorAverage()
                .buildAndRegister();

        NickelChloride = new Material.Builder(Supersymmetry.id("nickel_chloride"))
                .dust()
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        NickelHydroxide = new Material.Builder(Supersymmetry.id("nickel_hydroxide"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Ni(OH)2", true);


        NickelOxideHydroxide = new Material.Builder(Supersymmetry.id("nickel_oxide_hydroxide"))
                .dust()
                .components(Oxygen, 3, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("NiO(OH)2", true);


        SilverNitrateSolution = new Material.Builder(Supersymmetry.id("silver_nitrate_solution"))
                .liquid()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(AgNO3)(H2O)", true);


        ChloroauricAcid = new Material.Builder(Supersymmetry.id("chloroauric_acid"))
                .dust()
                .components(Chlorine, 4)
                .color(0xcc8821)
                .buildAndRegister()
                .setFormula("H[AuCl4]", true);


        SpentMoebiusElectrolyte = new Material.Builder(Supersymmetry.id("spent_moebius_electrolyte"))
                .liquid()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(AgNO3)(H2O)", true);


        GroovySuSyMaterials.ActivatedCarbon = new Material.Builder(Supersymmetry.id("activated_carbon"))
                .dust()
                .components()
                .color(0x38393b)
                .buildAndRegister();

        SulfuricPGMSolution = new Material.Builder(Supersymmetry.id("sulfuric_pgm_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, 3, HydrochloricAcid, 12, Water, 8)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(H2SO4)3(HCl)12(H2O)8", true);


        PGMSolution = new Material.Builder(Supersymmetry.id("pgm_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HydrochloricAcid, 12, Water, 12)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(HCl)12(H2O)12", true);


        GoldPlatedSteel = new Material.Builder(Supersymmetry.id("gold_plated_steel"))
                .ingot()
                .components()
                .color(0xb8a639)
                .flags(GENERATE_FINE_WIRE)
                .buildAndRegister();

        GoldConcentrate = new Material.Builder(Supersymmetry.id("gold_concentrate"))
                .dust()
                .components(SiliconDioxide, 4)
                .colorAverage()
                .iconSet(SAND)
                .buildAndRegister();

        LoadedCarbon = new Material.Builder(Supersymmetry.id("loaded_carbon"))
                .dust()
                .components(Carbon, 3, Nitrogen, 2)
                .color(0x44453b)
                .buildAndRegister()
                .setFormula("(Na[Au(CN)2])C", true);


        SpentActivatedCarbon = new Material.Builder(Supersymmetry.id("spent_activated_carbon"))
                .dust()
                .components()
                .color(0x262729)
                .buildAndRegister();

        WashedActivatedCarbon = new Material.Builder(Supersymmetry.id("washed_activated_carbon"))
                .dust()
                .components()
                .color(0x2d302b)
                .buildAndRegister();

        CalciumOrthosilicate = new Material.Builder(Supersymmetry.id("calcium_orthosilicate"))
                .dust()
                .components(Calcium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        MagnesiumChlorideSolution = new Material.Builder(Supersymmetry.id("magnesium_chloride_solution"))
                .liquid()
                .components(Water, 2)
                .colorAverage()
                .buildAndRegister();

        MagnesiumHydroxide = new Material.Builder(Supersymmetry.id("magnesium_hydroxide"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Mg(OH)2", true);


        MagnesiumSulfate = new Material.Builder(Supersymmetry.id("magnesium_sulfate"))
                .dust()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        CeriumIVOxide = new Material.Builder(Supersymmetry.id("cerium_iv_oxide"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        CeriumIIIOxide = new Material.Builder(Supersymmetry.id("cerium_iii_oxide"))
                .dust()
                .components(Cerium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        IronSulfate = new Material.Builder(Supersymmetry.id("iron_sulfate"))
                .dust()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        RoastedPetalite = new Material.Builder(Supersymmetry.id("roasted_petalite"))
                .dust()
                .color(0xabc9c9)
                .components(Silicon, 4, Oxygen, 10)
                .iconSet(SAND)
                .buildAndRegister()
                .setFormula("(LiAlSi2O6)(SiO2)2", true);

        BetaSpodumene = new Material.Builder(Supersymmetry.id("beta_spodumene"))
                .dust()
                .color(0xab7676)
                .components(Silicon, 2, Oxygen, 6)
                .buildAndRegister();

        LithiumSulfate = new Material.Builder(Supersymmetry.id("lithium_sulfate"))
                .dust()
                .components(Lithium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        AluminiumPhosphate = new Material.Builder(Supersymmetry.id("aluminium_phosphate"))
                .dust()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        SiliconTetrafluoride = new Material.Builder(Supersymmetry.id("silicon_tetrafluoride"))
                .gas()
                .components(Fluorine, 4)
                .colorAverage()
                .buildAndRegister();

        SodiumFluoroberyllate = new Material.Builder(Supersymmetry.id("sodium_fluoroberyllate"))
                .dust()
                .components(Sodium, 2, Fluorine, 4)
                .colorAverage()
                .buildAndRegister();

        SodiumFluorosilicate = new Material.Builder(Supersymmetry.id("sodium_fluorosilicate"))
                .dust()
                .components(Sodium, 2, Fluorine, 6)
                .colorAverage()
                .buildAndRegister();

        BerylliumHydroxide = new Material.Builder(Supersymmetry.id("beryllium_hydroxide"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Be(OH)2", true);

        BerylliumOxide = new Material.Builder(Supersymmetry.id("beryllium_oxide"))
                .dust().liquid(new FluidBuilder().temperature(2851))
                .flags(GENERATE_PLATE)
                .components()
                .colorAverage()
                .buildAndRegister();

        BerylliumChloride = new Material.Builder(Supersymmetry.id("beryllium_chloride"))
                .dust().liquid(new FluidBuilder().temperature(672))
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        AmmoniumFluoride = new Material.Builder(Supersymmetry.id("ammonium_fluoride"))
                .dust()
                .components(Hydrogen, 4)
                .colorAverage()
                .buildAndRegister();

        AmmoniumBifluoride = new Material.Builder(Supersymmetry.id("ammonium_bifluoride"))
                .dust()
                .components(Hydrogen, 5, Fluorine, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("[NH4][HF2]", true);


        AmmoniumFluoroberyllate = new Material.Builder(Supersymmetry.id("ammonium_fluoroberyllate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Fluorine, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NH4)2BeF4", true);


        ChromiumIIIHydroxide = new Material.Builder(Supersymmetry.id("chromium_iii_hydroxide"))
                .dust()
                .components(Oxygen, 3, Hydrogen, 3)
                .color(0x2e5207)
                .buildAndRegister()
                .setFormula("Cr(OH)3", true);


        DisassociatedAmmoniumFluoride = new Material.Builder(Supersymmetry.id("disassociated_ammonium_fluoride"))
                .gas(new FluidBuilder().temperature(1200))

                .components()
                .colorAverage()
                .buildAndRegister();

        BerylliumFluoride = new Material.Builder(Supersymmetry.id("beryllium_fluoride"))
                .dust()
                .components(Fluorine, 2)
                .colorAverage()
                .buildAndRegister();

        MagnesiumFluoride = new Material.Builder(Supersymmetry.id("magnesium_fluoride"))
                .dust()
                .components(Fluorine, 2)
                .colorAverage()
                .buildAndRegister();

        DissolvedMagnesiumFluoride = new Material.Builder(Supersymmetry.id("dissolved_magnesium_fluoride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorine, 2, HydrofluoricAcid, 2)
                .colorAverage()
                .buildAndRegister();

        DissolvedAlkaliBeryl = new Material.Builder(Supersymmetry.id("dissolved_beryl"))
                .liquid()
                .components(Beryllium, 3, Aluminium, 2, Sodium, 2, Sulfur, 7, Oxygen, 28, Water, 7)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(BeSO4)3(Al2(SO4)3)(Na2SO4)(H2O)7", true);


        PotassiumAlum = new Material.Builder(Supersymmetry.id("potassium_alum"))
                .dust()
                .components(Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .buildAndRegister()
                .setFormula("KAl(SO4)2", true);


        BerylliumSulfateSolution = new Material.Builder(Supersymmetry.id("beryllium_sulfate_solution"))
                .liquid()
                .components(Beryllium, 3, Sodium, 2, Sulfur, 4, Oxygen, 16, Water, 8)
                .colorAverage()
                .buildAndRegister();

        PotassiumManganate = new Material.Builder(Supersymmetry.id("potassium_manganate"))
                .dust()
                .components(Potassium, 2, Oxygen, 4)
                .color(0x071c06)
                .buildAndRegister();

        Trichlorosilane = new Material.Builder(Supersymmetry.id("trichlorosilane"))
                .liquid()
                .components(Chlorine, 3)
                .color(0x77979e)
                .buildAndRegister();

        PurifiedTrichlorosilane = new Material.Builder(Supersymmetry.id("purified_trichlorosilane"))
                .liquid()
                .components(Chlorine, 3)
                .color(0x93b9c2)
                .buildAndRegister();

        HexafluorosilicicAcid = new Material.Builder(Supersymmetry.id("hexafluorosilicic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 2, Fluorine, 6)
                .colorAverage()
                .buildAndRegister();

        CrudeLead = new Material.Builder(Supersymmetry.id("crude_lead"))
                .ingot().liquid(new FluidBuilder().temperature(600))
                .components()
                .color(0x1f1926)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .buildAndRegister();

        SilverFreeLead = new Material.Builder(Supersymmetry.id("silver_free_lead"))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components()
                .color(0x26202e)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        BismuthDross = new Material.Builder(Supersymmetry.id("bismuth_dross"))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components(Magnesium, 2, Bismuth, 2)
                .color(0x292b45)
                .buildAndRegister();

        AntimonyDross = new Material.Builder(Supersymmetry.id("antimony_dross"))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components(Magnesium, 2, Antimony, 2)
                .color(0x3c3a45)
                .buildAndRegister();

        ZincDross = new Material.Builder(Supersymmetry.id("zinc_dross"))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components(Zinc, 2)
                .color(0xb7baa8)
                .buildAndRegister();

        PurifiedTinIIOxide = new Material.Builder(Supersymmetry.id("purified_tin_ii_oxide"))
                .dust()
                .iconSet(SHINY)
                .components()
                .colorAverage()
                .buildAndRegister();

        AluminiumSilicate = new Material.Builder(Supersymmetry.id("aluminium_silicate"))
                .dust()
                .components(Aluminium, 2, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        ChromiumIIIOxide = new Material.Builder(Supersymmetry.id("chromium_iii_oxide"))
                .dust()
                .components(Chromium, 2, Oxygen, 3)
                .color(0xb3c99)
                .buildAndRegister();

        SodiumSulfateAcetoneSolution = new Material.Builder(Supersymmetry.id("sodium_sulfate_acetone_solution"))
                .liquid()
                .components(Sodium, 12, Sulfur, 6, Oxygen, 24, Water, 9)
                .color(0x2c733a)
                .buildAndRegister();

        LeadFreeSolder = new Material.Builder(Supersymmetry.id("lead_free_solder"))
                .ingot().liquid(new FluidBuilder().temperature(411))
                .components(Bismuth, 6, Tin, 4)
                .colorAverage()
                .buildAndRegister();

        CopperDross = new Material.Builder(Supersymmetry.id("copper_dross"))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0x000000)
                .buildAndRegister();

        DecopperedLead = new Material.Builder(Supersymmetry.id("decoppered_lead"))
                .liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0x886b9c)
                .buildAndRegister();

        DezincedLead = new Material.Builder(Supersymmetry.id("dezinced_lead"))
                .liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0x825d9c)
                .buildAndRegister();

        BettsCrudeLead = new Material.Builder(Supersymmetry.id("betts_crude_lead"))
                .ingot().liquid(new FluidBuilder().temperature(600))
                .components(Bismuth, 3, Lead, 6)
                .flags(DISABLE_DECOMPOSITION)
                .color(0x393673)
                .buildAndRegister();

        DecopperedBettsLead = new Material.Builder(Supersymmetry.id("decoppered_betts_lead"))
                .liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components(Bismuth, 3, Lead, 6)
                .color(0x2f2d63)
                .buildAndRegister();

        SoftenedLead = new Material.Builder(Supersymmetry.id("softened_lead"))
                .dust().liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components()
                .color(0x9874b0)
                .buildAndRegister();

        SodiumAntimonate = new Material.Builder(Supersymmetry.id("sodium_antimonate"))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumArsenate = new Material.Builder(Supersymmetry.id("sodium_arsenate"))
                .dust().liquid(new FluidBuilder().temperature(553))
                .components(Sodium, 3, Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        SodiumStannate = new Material.Builder(Supersymmetry.id("sodium_stannate"))
                .dust()
                .components(Sodium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SaltyArsenicAcid = new Material.Builder(Supersymmetry.id("salty_arsenic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Salt, 3, Hydrogen, 3, Oxygen, 4, Water, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H3AsO4)(NaCl)3(H2O)3", true);


        SaltyArsenicPentoxide = new Material.Builder(Supersymmetry.id("salty_arsenic_pentoxide"))
                .dust()
                .components(Salt, 6, Arsenic, 2, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        TinIVOxide = new Material.Builder(Supersymmetry.id("tin_iv_oxide"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        AntimonyVOxide = new Material.Builder(Supersymmetry.id("antimony_v_oxide"))
                .dust()
                .components(Antimony, 2, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        //FREE ID: 8360

        CrudeTin = new Material.Builder(Supersymmetry.id("crude_tin"))
                .liquid(new FluidBuilder().temperature(600))
                .components()
                .color(0xbfbfbf)
                .iconSet(DULL)
                .buildAndRegister();

        LeachedCassiteriteConcentrate = new Material.Builder(Supersymmetry.id("leached_cassiterite_concentrate"))
                .dust()
                .components()
                .colorAverage()
                .iconSet(DULL)
                .buildAndRegister();

        AmmoniumTungstateSolution = new Material.Builder(Supersymmetry.id("ammonium_tungstate_solution"))
                .liquid()
                .components(Nitrogen, 2, Hydrogen, 8, Oxygen, 8, Water, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("[(NH4)2WO4](H2O)2", true);


        CopperMonosulfide = new Material.Builder(Supersymmetry.id("copper_monosulfide"))
                .dust()
                .components()
                .color(0x1a1817)
                .buildAndRegister();

        PotassiumSaltMixture = new Material.Builder(Supersymmetry.id("potassium_salt_mixture"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister();

        PotassiumSulfide = new Material.Builder(Supersymmetry.id("potassium_sulfide"))
                .dust()
                .components(Potassium, 2)
                .color(0xcbcfae)
                .buildAndRegister();

        WashedMagnesiumChlorideAmmoniate = new Material.Builder(Supersymmetry.id("washed_magnesium_chloride_ammoniate"))
                .dust()
                .components(Ammonia, 6)
                .colorAverage()
                .iconSet(SHINY)
                .buildAndRegister();

        SaturatedAmmoniacalMethanol = new Material.Builder(Supersymmetry.id("saturated_ammoniacal_methanol"))
                .liquid()
                .components(Methanol, 2)
                .colorAverage()
                .buildAndRegister();

        MagnesiumChlorideAmmoniate = new Material.Builder(Supersymmetry.id("magnesium_chloride_ammoniate"))
                .dust()
                .components(Ammonia, 6)
                .colorAverage()
                .buildAndRegister();

        PurifiedMagnesiumChloride = new Material.Builder(Supersymmetry.id("purified_magnesium_chloride"))
                .dust().liquid(new FluidBuilder().temperature(987))
                .components()
                .color(0xd40d5c)
                .iconSet(SHINY)
                .buildAndRegister();

        BariumChloride = new Material.Builder(Supersymmetry.id("barium_chloride"))
                .dust()
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        BariumOxide = new Material.Builder(Supersymmetry.id("barium_oxide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        BariumCarbonate = new Material.Builder(Supersymmetry.id("barium_carbonate"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        IronPentacarbonyl = new Material.Builder(Supersymmetry.id("iron_pentacarbonyl"))
                .liquid()
                .components(Carbon, 5, Oxygen, 5)
                .color(0x8c180d)
                .buildAndRegister()
                .setFormula("Fe(CO)5", true);


        IronTwoThreeOxide = new Material.Builder(Supersymmetry.id("iron_two_three_oxide"))
                .dust()
                .color(0x141313)
                .components(Iron, 3, Oxygen, 4)
                .buildAndRegister();

        PurifiedIronTwoThreeOxide = new Material.Builder(Supersymmetry.id("purified_iron_two_three_oxide"))
                .dust()
                .iconSet(SHINY)
                .color(0x141313)
                .components(Iron, 3, Oxygen, 4)
                .buildAndRegister();

        PurifiedIronIIIOxide = new Material.Builder(Supersymmetry.id("purified_iron_iii_oxide"))
                .dust()
                .iconSet(SHINY)
                .color(0x8F0C03)
                .components(Iron, 2, Oxygen, 3)
                .buildAndRegister();

        NickelIIOxide = new Material.Builder(Supersymmetry.id("nickel_ii_oxide"))
                .dust()
                .color(0x92a371)
                .components()
                .buildAndRegister();

        CarbonTetrafluoride = new Material.Builder(Supersymmetry.id("carbon_tetrafluoride"))
                .gas().plasma()
                .components(Fluorine, 4)
                .colorAverage()
                .buildAndRegister();

        NitrogenTrifluoride = new Material.Builder(Supersymmetry.id("nitrogen_trifluoride"))
                .gas().plasma()
                .components(Fluorine, 3)
                .colorAverage()
                .buildAndRegister();

        CobaltFerrite = new Material.Builder(Supersymmetry.id("cobalt_ferrite"))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Iron, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        StrontiumFerrite = new Material.Builder(Supersymmetry.id("strontium_ferrite"))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Iron, 12, Oxygen, 19)
                .colorAverage()
                .buildAndRegister();

        BariumFerrite = new Material.Builder(Supersymmetry.id("barium_ferrite"))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Iron, 12, Oxygen, 19)
                .colorAverage()
                .buildAndRegister();

        ManganeseZincFerrite = new Material.Builder(Supersymmetry.id("manganese_zinc_ferrite"))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Iron, 4, Oxygen, 8)
                .colorAverage()
                .buildAndRegister();

        StrontiumCarbonate = new Material.Builder(Supersymmetry.id("strontium_carbonate"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        LithiumOxide = new Material.Builder(Supersymmetry.id("lithium_oxide"))
                .dust().liquid(new FluidBuilder().temperature(1711))
                .components(Lithium, 2)
                .colorAverage()
                .buildAndRegister();

        LeadOxide = new Material.Builder(Supersymmetry.id("lead_oxide"))
                .dust().gas(new FluidBuilder().temperature(1750))
                .flags(NO_UNIFICATION)
                .components()
                .colorAverage()
                .buildAndRegister();

        TantalumNitride = new Material.Builder(Supersymmetry.id("tantalum_nitride"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        RutheniumIVOxide = new Material.Builder(Supersymmetry.id("ruthenium_iv_oxide"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        BismuthIridate = new Material.Builder(Supersymmetry.id("bismuth_iridate"))
                .dust()
                .components(Bismuth, 2, Iridium, 2, Oxygen, 7)
                .colorAverage()
                .buildAndRegister();

        SodiumBismuthate = new Material.Builder(Supersymmetry.id("sodium_bismuthate"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        BismuthIIIOxide = new Material.Builder(Supersymmetry.id("bismuth_iii_oxide"))
                .dust()
                .components(Bismuth, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        ManganeseIINitrate = new Material.Builder(Supersymmetry.id("manganese_ii_nitrate"))
                .dust()
                .components(Nitrogen, 2, Oxygen, 6)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Mn(NO3)2", true);

        ManganeseDioxide = new Material.Builder(Supersymmetry.id("manganese_dioxide"))
                .dust()
                .iconSet(SHINY)
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        BariumTitanate = new Material.Builder(Supersymmetry.id("barium_titanate"))
                .gem().iconSet(RUBY)
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        HafniumTetrachloride = new Material.Builder(Supersymmetry.id("hafnium_tetrachloride"))
                .dust().liquid(new FluidBuilder().temperature(705))
                .components(Chlorine, 4)
                .color(0xcae3cc)
                .buildAndRegister();

        AmmoniumThiocyanate = new Material.Builder(Supersymmetry.id("ammonium_thiocyanate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("NH4SCN", true);


        RawElectrum = new Material.Builder(Supersymmetry.id("raw_electrum"))
                .ore().liquid(new FluidBuilder().temperature(1300))
                .color(0xfcf403)
                .components()
                .buildAndRegister();

        NeodymiumAlloy = new Material.Builder(Supersymmetry.id("neodymium_alloy"))
                .ingot()
                .color(0x2b2a2a).iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE)
                .components(Neodymium, 2, Iron, 14)
                .blastTemp(1297, BlastProperty.GasTier.MID)
                .buildAndRegister();

        TreatedNeodymiumAlloy = new Material.Builder(Supersymmetry.id("treated_neodymium_alloy"))
                .ingot()
                .color(0x2b2a2a).iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION)
                .components()
                .ingotSmeltInto(NeodymiumAlloy)
                .arcSmeltInto(NeodymiumAlloy)
                .macerateInto(NeodymiumAlloy)
                .buildAndRegister();

        NeodymiumAlloyMagnetic = new Material.Builder(Supersymmetry.id("neodymium_alloy_magnetic"))
                .ingot()
                .color(0x2b2a2a).iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION, IS_MAGNETIC)
                .components()
                .ingotSmeltInto(NeodymiumAlloy)
                .arcSmeltInto(NeodymiumAlloy)
                .macerateInto(NeodymiumAlloy)
                .buildAndRegister();

        TreatedNeodymiumAlloy.getProperty(PropertyKey.INGOT).setMagneticMaterial(NeodymiumAlloyMagnetic);

        SamariumAlloy = new Material.Builder(Supersymmetry.id("samarium_alloy"))
                .dust().ingot().liquid(new FluidBuilder().temperature(800))
                .color(0xb3d683).iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION)
                .components(Cobalt, 5)
                .buildAndRegister();

        TreatedSamariumAlloy = new Material.Builder(Supersymmetry.id("treated_samarium_alloy"))
                .ingot()
                .color(0xb3d683).iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION)
                .components()
                .ingotSmeltInto(SamariumAlloy)
                .arcSmeltInto(SamariumAlloy)
                .macerateInto(SamariumAlloy)
                .buildAndRegister();

        SamariumAlloyMagnetic = new Material.Builder(Supersymmetry.id("samarium_alloy_magnetic"))
                .ingot()
                .color(0xb3d683).iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION, IS_MAGNETIC)
                .components()
                .ingotSmeltInto(SamariumAlloy)
                .arcSmeltInto(SamariumAlloy)
                .macerateInto(SamariumAlloy)
                .buildAndRegister();

        TreatedSamariumAlloy.getProperty(PropertyKey.INGOT).setMagneticMaterial(SamariumAlloyMagnetic);

        //FREE ID: 8406

        Dichlorosilane = new Material.Builder(Supersymmetry.id("dichlorosilane"))
                .gas()
                .components(Hydrogen, 2, Chlorine, 2)
                .color(0x90ab84)
                .buildAndRegister();

        Chlorosilane = new Material.Builder(Supersymmetry.id("chlorosilane"))
                .liquid()
                .components(Hydrogen, 3)
                .color(0xa0ba95)
                .buildAndRegister();

        Silane = new Material.Builder(Supersymmetry.id("silane"))
                .gas()
                .components(Hydrogen, 4)
                .color(0xbbd1b2)
                .buildAndRegister();

        NickelCarbonyl = new Material.Builder(Supersymmetry.id("nickel_carbonyl"))
                .gas(new FluidBuilder().temperature(400))
                .components(Carbon, 4, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Ni(CO)4", true);


        ChloroaceticAnhydride = new Material.Builder(Supersymmetry.id("chloroacetic_anhydride"))
                .dust()
                .components(Carbon, 4, Hydrogen, 4, Oxygen, 3, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        ZirconiumDioxide = new Material.Builder(Supersymmetry.id("zirconium_dioxide"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        CopperIINitrate = new Material.Builder(Supersymmetry.id("copper_ii_nitrate"))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen, 2, Oxygen, 6)
                .color(0x292fe3)
                .buildAndRegister()
                .setFormula("Cu(NO3)2", true);


        NickelIINitrate = new Material.Builder(Supersymmetry.id("nickel_ii_nitrate"))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen, 2, Oxygen, 6)
                .color(0x236359)
                .buildAndRegister()
                .setFormula("Ni(NO3)2", true);


        ZincNitrate = new Material.Builder(Supersymmetry.id("zinc_nitrate"))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen, 2, Oxygen, 6)
                .color(0xdfe6cf)
                .buildAndRegister()
                .setFormula("Zn(NO3)2", true);


        MagnesiumNitrate = new Material.Builder(Supersymmetry.id("magnesium_nitrate"))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen, 2, Oxygen, 6)
                .color(0xe8d8e3)
                .buildAndRegister()
                .setFormula("Mg(NO3)2", true);


        YttriumOxide = new Material.Builder(Supersymmetry.id("yttrium_oxide"))
                .dust()
                .components(Yttrium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        NeodymiumOxide = new Material.Builder(Supersymmetry.id("neodymium_oxide"))
                .dust()
                .components(Neodymium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        Bromooctane = new Material.Builder(Supersymmetry.id("bromooctane"))
                .liquid()
                .components(Carbon, 8, Hydrogen, 17)
                .colorAverage()
                .buildAndRegister();

        LithiumDioctylcopper = new Material.Builder(Supersymmetry.id("lithium_dioctylcopper"))
                .liquid()
                .components(Carbon, 16, Hydrogen, 34)
                .colorAverage()
                .buildAndRegister();

        DecanoylChloride = new Material.Builder(Supersymmetry.id("decanoyl_chloride"))
                .liquid()
                .components(Carbon, 10, Hydrogen, 19)
                .colorAverage()
                .buildAndRegister();

        SodiumCyanoborohydride = new Material.Builder(Supersymmetry.id("sodium_cyanoborohydride"))
                .dust()
                .components(Hydrogen, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Na[BH3(CN)]", true);


        DilutedSodiumHydroxideSolution = new Material.Builder(Supersymmetry.id("diluted_sodium_hydroxide_solution"))
                .liquid()
                .components(Water, 2)
                .colorAverage()
                .buildAndRegister();

        Oleum = new Material.Builder(Supersymmetry.id("oleum"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, 10)
                .color(0xe8c3a5)
                .buildAndRegister();

        ChromiumSulfateSolution = new Material.Builder(Supersymmetry.id("chromium_sulfate_solution"))
                .liquid()
                .components(Chromium, 4, Sulfur, 6, Oxygen, 24, Water, 9)
                .color(0x2c733a)
                .buildAndRegister();

        MustardGas = new Material.Builder(Supersymmetry.id("mustard_gas"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 8, Chlorine, 2)
                .color(0xcf7f3e)
                .buildAndRegister();

        Methyldichlorophosphine = new Material.Builder(Supersymmetry.id("methyldichlorophosphine"))
                .liquid()
                .components(Hydrogen, 3, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        SulfurylChloride = new Material.Builder(Supersymmetry.id("sulfuryl_chloride"))
                .liquid()
                .components(Oxygen, 2, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        MethylphosphonylDichloride = new Material.Builder(Supersymmetry.id("methylphosphonyl_dichloride"))
                .liquid()
                .components(Hydrogen, 3, Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        MethylphosphonylDifluoride = new Material.Builder(Supersymmetry.id("methylphosphonyl_difluoride"))
                .liquid()
                .components(Hydrogen, 3, Fluorine, 2)
                .colorAverage()
                .buildAndRegister();

        Sarin = new Material.Builder(Supersymmetry.id("sarin"))
                .liquid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        MethylDiethylphosphinate = new Material.Builder(Supersymmetry.id("methyl_diethylphosphinate"))
                .liquid()
                .components(Carbon, 5, Hydrogen, 13, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        DiisopropylaminoEthylEthylMethylphosphonite = new Material.Builder(Supersymmetry.id("diisopropylamino_ethyl_ethyl_methylphosphonite"))
                .liquid()
                .components(Carbon, 11, Hydrogen, 26, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        VX = new Material.Builder(Supersymmetry.id("vx"))
                .liquid()
                .components(Carbon, 11, Hydrogen, 26, Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        TitaniumEthoxide = new Material.Builder(Supersymmetry.id("titanium_ethoxide"))
                .liquid()
                .components(Titanium, 4, Carbon, 32, Hydrogen, 80, Oxygen, 16)
                .colorAverage()
                .buildAndRegister();

        DilutedPhosphoricAcid = new Material.Builder(Supersymmetry.id("diluted_phosphoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PhosphoricAcid, 3)
                .colorAverage()
                .buildAndRegister();

        MonocalciumPhosphate = new Material.Builder(Supersymmetry.id("monocalcium_phosphate"))
                .dust()
                .components(Hydrogen, 4, Phosphorus, 2, Oxygen, 8)
                .color(0xc2bc13)
                .iconSet(SAND)
                .buildAndRegister()
                .setFormula("Ca(H2PO4)2", true);


        CalciumPhosphite = new Material.Builder(Supersymmetry.id("calcium_phosphite"))
                .dust()
                .components(Calcium, 3, Phosphorus, 2, Oxygen, 6)
                .color(0xa2a832)
                .iconSet(CERTUS)
                .buildAndRegister()
                .setFormula("Ca3(PO3)2", true);


        SulfurTrioxideReactionMixture = new Material.Builder(Supersymmetry.id("sulfur_trioxide_reaction_mixture"))
                .gas()
                .components()
                .colorAverage()
                .buildAndRegister();

        CalciumMetasilicate = new Material.Builder(Supersymmetry.id("calcium_metasilicate"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        HighPurityPhosphorusVaporMixture = new Material.Builder(Supersymmetry.id("high_purity_phosphorus_vapor_mixture"))
                .gas(new FluidBuilder().temperature(554))
                .components(Phosphorus, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(P)(H2O)", true);

//        PotassiumAmylXanthate = new Material.Builder(Supersymmetry.id("potassium_amyl_xanthate"))
//                .dust()
//                .components(Carbon, 6, Hydrogen, 11, Sulfur, 2)
//                .colorAverage()
//                .buildAndRegister();

        GoldAmalgam = new Material.Builder(Supersymmetry.id("gold_amalgam"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister();

        HotSulfuricAcid = new Material.Builder(Supersymmetry.id("hot_sulfuric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(353))
                .components(Hydrogen, 2, Oxygen, 4)
                .color(0xff570f)
                .buildAndRegister();

        CadmiumSulfateSolution = new Material.Builder(Supersymmetry.id("cadmium_sulfate_solution"))
                .liquid()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        MercuryOxide = new Material.Builder(Supersymmetry.id("mercury_oxide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        IndiumChloride = new Material.Builder(Supersymmetry.id("indium_chloride"))
                .dust()
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister();

        IndiumHydroxide = new Material.Builder(Supersymmetry.id("indium_hydroxide"))
                .dust()
                .components(Oxygen, 3, Hydrogen, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("In(OH)3", true);


        TitaniumDioxide = new Material.Builder(Supersymmetry.id("titanium_dioxide"))
                .dust()
                .components(Oxygen, 2)
                .color(0xffffff)
                .iconSet(SHINY)
                .buildAndRegister();

        IndiumOxide = new Material.Builder(Supersymmetry.id("indium_oxide"))
                .dust()
                .components(Indium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        EthanolWaterAzeotrope = new Material.Builder(Supersymmetry.id("ethanol_water_azeotrope"))
                .liquid()
                .components(Ethanol, 91, Water, 9)
                .color(0xad552f)
                .buildAndRegister();

        EntrainedEthanolWaterAzeotrope = new Material.Builder(Supersymmetry.id("entrained_ethanol_water_azeotrope"))
                .liquid()
                .components(Ethanol, 91, Water, 9, Toluene, 10)
                .colorAverage()
                .buildAndRegister();

        CalciumSulfite = new Material.Builder(Supersymmetry.id("calcium_sulfite"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SilicaGel = new Material.Builder(Supersymmetry.id("silica_gel"))
                .dust()
                .iconSet(SHINY)
                .components(Oxygen, 2)
                .color(0x6d6e63)
                .buildAndRegister();

        WetSilicaGel = new Material.Builder(Supersymmetry.id("wet_silica_gel"))
                .dust()
                .components(Oxygen, 2)
                .color(0x585950)
                .buildAndRegister();

        PhosphoricAcidSilicaGel = new Material.Builder(Supersymmetry.id("phosphoric_acid_silica_gel"))
                .dust()
                .iconSet(SHINY)
                .components()
                .colorAverage()
                .buildAndRegister();

        SodiumChromateMixture = new Material.Builder(Supersymmetry.id("sodium_chromate_mixture"))
                .dust()
                .components(Oxygen, 4)
                .color(0xfaff7d)
                .buildAndRegister();

        SodiumChromateSolution = new Material.Builder(Supersymmetry.id("sodium_chromate_solution"))
                .liquid()
                .components(Oxygen, 4)
                .color(0xa4a839)
                .buildAndRegister();

        LeadChloride = new Material.Builder(Supersymmetry.id("lead_chloride"))
                .dust().liquid(new FluidBuilder().temperature(774))
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        SodiumVanadateSolution = new Material.Builder(Supersymmetry.id("sodium_vanadate_solution"))
                .liquid()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NaVO3)(H2O)", true);


        AmmoniumMetavanadate = new Material.Builder(Supersymmetry.id("ammonium_metavanadate"))
                .dust()
                .components(Hydrogen, 4, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        CobaltAluminate = new Material.Builder(Supersymmetry.id("cobalt_aluminate"))
                .dust()
                .iconSet(SHINY)
                .components(Aluminium, 2, Oxygen, 4)
                .color(0x1605ff)
                .buildAndRegister();

        LeadNitrate = new Material.Builder(Supersymmetry.id("lead_nitrate"))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen, 2, Oxygen, 6)
                .color(0xffffff)
                .buildAndRegister()
                .setFormula("Pb(NO3)2", true);


        AmmoniumChromeAlum = new Material.Builder(Supersymmetry.id("ammonium_chrome_alum"))
                .dust()
                .components(Hydrogen, 4, Sulfur, 2, Oxygen, 8)
                .color(0x4e1554)
                .iconSet(SHINY)
                .buildAndRegister()
                .setFormula("NH4Cr(SO4)2", true);


        AmmoniumIronIISulfate = new Material.Builder(Supersymmetry.id("ammonium_iron_ii_sulfate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 2, Oxygen, 8)
                .color(0x70cc6e)
                .iconSet(SHINY)
                .buildAndRegister()
                .setFormula("Fe(NH4)2(SO4)2", true);


        ElectrolyticChromium = new Material.Builder(Supersymmetry.id("electrolytic_chromium"))
                .dust().liquid(new FluidBuilder().temperature(2180))
                .components()
                .colorAverage()
                .iconSet(SAND)
                .buildAndRegister();

        IronIIHydroxide = new Material.Builder(Supersymmetry.id("iron_ii_hydroxide"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .color(0x072406)
                .buildAndRegister()
                .setFormula("Fe(OH)2", true);


        SodiumAmide = new Material.Builder(Supersymmetry.id("sodium_amide"))
                .dust()
                .components(Hydrogen, 2)
                .colorAverage()
                .buildAndRegister();

        LeadChromate = new Material.Builder(Supersymmetry.id("lead_chromate"))
                .dust()
                .iconSet(SHINY)
                .components(Oxygen, 4)
                .color(0xfffb00)
                .buildAndRegister();

        IronIIOxide = new Material.Builder(Supersymmetry.id("iron_ii_oxide"))
                .dust()
                .components()
                .color(0x1c1c1c)
                .buildAndRegister();

        GalliumTrioxide = new Material.Builder(Supersymmetry.id("gallium_trioxide"))
                .dust()
                .components(Gallium, 2, Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        AmmoniumDihydrogenPhosphate = new Material.Builder(Supersymmetry.id("ammonium_dihydrogen_phosphate"))
                .dust()
                .components(Hydrogen, 6, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("NH4H2PO4", true);


        //FREE ID: 8474

        IronCarbonate = new Material.Builder(Supersymmetry.id("iron_carbonate"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        AmmoniumDiuranate = new Material.Builder(Supersymmetry.id("ammonium_diuranate"))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen, 2, Hydrogen, 8, Oxygen, 7)
                .color(0xe6be22)
                .buildAndRegister()
                .setFormula("(NH4)2U2O7", true);


        MagnesiumCarbonate = new Material.Builder(Supersymmetry.id("magnesium_carbonate"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        SodiumLeadAlloy = new Material.Builder(Supersymmetry.id("sodium_lead_alloy"))
                .ingot()
                .components()
                .colorAverage()
                .buildAndRegister();

        DenseSteam = new Material.Builder(Supersymmetry.id("dense_steam"))
                .gas(new FluidBuilder().temperature(373))
                .components()
                .color(0xcaddfa)
                .buildAndRegister();

        //FREE IDs: 8481-8485

        UltramaficTailingSlurry = new Material.Builder(Supersymmetry.id("ultramafic_tailing_slurry"))
                .liquid()
                .components()
                .color(0x878170)
                .buildAndRegister();

        RutileSlurry = new Material.Builder(Supersymmetry.id("rutile_slurry"))
                .liquid()
                .components()
                .color(0xe8e6e2)
                .buildAndRegister()
                .setFormula("(H2O)(TiO2)(?)", true);


        ImpureTitaniumTetrachloride = new Material.Builder(Supersymmetry.id("impure_titanium_tetrachloride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .color(0x54474a)
                .buildAndRegister()
                .setFormula("(TiCl4)(?)", true);


        DistilledTitaniumTetrachloride = new Material.Builder(Supersymmetry.id("distilled_titanium_tetrachloride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .color(0x8c6c73)
                .buildAndRegister()
                .setFormula("(TiCl4)(?)", true);


        VanadiumFreeTitaniumTetrachloride = new Material.Builder(Supersymmetry.id("vanadium_free_titanium_tetrachloride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .color(0xa16270)
                .buildAndRegister()
                .setFormula("(TiCl4)(?)", true);


        VanadiumOxydichloride = new Material.Builder(Supersymmetry.id("vanadium_oxydichloride"))
                .dust()
                .components(Chlorine, 2)
                .color(0x1c1294)
                .buildAndRegister();

        VanadiumOxytrichloride = new Material.Builder(Supersymmetry.id("vanadium_oxytrichloride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorine, 3)
                .color(0xbda51b)
                .buildAndRegister();

        GaseousIronIIIChloride = new Material.Builder(Supersymmetry.id("gaseous_iron_iii_chloride"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(590))
                .components()
                .color(0xba8f49)
                .buildAndRegister();

        GaseousTitaniumTetrachloride = new Material.Builder(Supersymmetry.id("gaseous_titanium_tetrachloride"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(1180))
                .components()
                .color(0x8f4064)
                .buildAndRegister();

        TinTetrachloride = new Material.Builder(Supersymmetry.id("tin_tetrachloride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorine, 4)
                .color(0x887866)
                .buildAndRegister();

        //FREE IDs: 8496-8498

        GroovySuSyMaterials.SodiumNitrite = new Material.Builder(Supersymmetry.id("sodium_nitrite"))
                .dust().liquid(new FluidBuilder().temperature(544))
                .components(Oxygen, 2)
                .color(0xe7e899)
                .buildAndRegister();

        SodiumOxide = new Material.Builder(Supersymmetry.id("sodium_oxide"))
                .dust()
                .components(Sodium, 2)
                .colorAverage()
                .buildAndRegister();

        AlluvialPGMSolution = new Material.Builder(Supersymmetry.id("alluvial_pgm_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 6, Platinum, 3, Chlorine, 20, Water, 10)
                .color(0xe06624)
                .buildAndRegister()
                .setFormula("(H2PtCl6)2(H2PdCl4)(FeCl2)(H2O)10", true);


        CementedAlluvialPGMSolution = new Material.Builder(Supersymmetry.id("cemented_alluvial_pgm_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 6, Platinum, 3, Chlorine, 20, Water, 8)
                .color(0xb87627)
                .buildAndRegister()
                .setFormula("(H2PtCl6)2(H2PdCl4)(ZnCl2)(H2O)10", true);


        AmmoniumHexachloroplatinate = new Material.Builder(Supersymmetry.id("ammonium_hexachloroplatinate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Chlorine, 6)
                .color(0xe6c532)
                .buildAndRegister()
                .setFormula("(NH4)2PtCl6", true);


        DilutedCopperSulfateSolution = new Material.Builder(Supersymmetry.id("diluted_copper_sulfate_solution"))
                .liquid()
                .components(CopperSulfate, 2, Water, 3)
                .colorAverage()
                .buildAndRegister();

        NickelSulfateSolution = new Material.Builder(Supersymmetry.id("nickel_sulfate_solution"))
                .liquid()
                .components(Oxygen, 4)
                .color(0x38add1)
                .buildAndRegister();

        DisulfurDichloride = new Material.Builder(Supersymmetry.id("disulfur_dichloride"))
                .liquid()
                .components(Sulfur, 2, Chlorine, 2)
                .color(0xccc31d)
                .buildAndRegister();

        AcidWashedSiliconDioxide = new Material.Builder(Supersymmetry.id("acid_washed_silicon_dioxide"))
                .dust()
                .components()
                .color(0xc8c8c8)
                .iconSet(SHINY)
                .buildAndRegister();

        AluminiumNitride = new Material.Builder(Supersymmetry.id("aluminium_nitride"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        AluminiumOxynitride = new Material.Builder(Supersymmetry.id("aluminium_oxynitride"))
                .dust()
                .flags(GENERATE_PLATE)
                .components(Aluminium, 23, Oxygen, 27, Nitrogen, 5)
                .color(0xc7dfed)
                .iconSet(GLASS)
                .buildAndRegister();

        HydrogenIodide = new Material.Builder(Supersymmetry.id("hydrogen_iodide"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister();

        AntimonyTrichloride = new Material.Builder(Supersymmetry.id("antimony_trichloride"))
                .dust().liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(347))
                .components(Chlorine, 3)
                .colorAverage()
                .buildAndRegister();

        AntimonyPentachloride = new Material.Builder(Supersymmetry.id("antimony_pentachloride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorine, 5)
                .colorAverage()
                .buildAndRegister();

        //FREE IDs: 8513-8516

        MolybdenumTrisulfide = new Material.Builder(Supersymmetry.id("molybdenum_trisulfide"))
                .dust()
                .components(Sulfur, 3)
                .colorAverage()
                .buildAndRegister();

        AmmoniumIsopolytungstateSolution = new Material.Builder(Supersymmetry.id("ammonium_isopolytungstate_solution"))
                .liquid()
                .components(Nitrogen, 5, Hydrogen, 21, Tungsten, 6, Oxygen, 21, Water, 5)
                .colorAverage()
                .buildAndRegister()
                .setFormula("[(NH4)5(HW6O21)](H2O)5", true);


        AmmoniumParatungstate = new Material.Builder(Supersymmetry.id("ammonium_paratungstate"))
                .dust()
                .components(Nitrogen, 10, Hydrogen, 42, Tungsten, 12, Oxygen, 42, Water, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NH4)10(H2W12O42) * 4H2O", true);


        ManganeseIIHydroxide = new Material.Builder(Supersymmetry.id("manganese_ii_hydroxide"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Mn(OH)2", true);


        SodiumTungstateSolution = new Material.Builder(Supersymmetry.id("sodium_tungstate_solution"))
                .liquid()
                .components(Sodium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(Na2WO4)(H2O)", true);


        ImpureMolybdenumTrioxide = new Material.Builder(Supersymmetry.id("impure_molybdenum_trioxide"))
                .dust()
                .components(Oxygen, 3)
                .color(0x154f25)
                .buildAndRegister()
                .setFormula("(?)(MoO3)", true);


        AmmoniumDimolybdate = new Material.Builder(Supersymmetry.id("ammonium_dimolybdate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Molybdenum, 2, Oxygen, 7)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(NH4)2Mo2O7", true);


        PurifiedMolybdenumTrioxide = new Material.Builder(Supersymmetry.id("purified_molybdenum_trioxide"))
                .dust()
                .components(Oxygen, 3)
                .color(0x0f5c23)
                .iconSet(SHINY)
                .buildAndRegister();

        MolybdenumTrioxide = new Material.Builder(Supersymmetry.id("molybdenum_trioxide"))
                .dust()
                .components(Oxygen, 3)
                .color(0x0f5c23)
                .buildAndRegister();

        AmmoniumMolybdateSolution = new Material.Builder(Supersymmetry.id("ammonium_molybdate_solution"))
                .liquid()
                .components(Nitrogen, 2, Hydrogen, 8, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("[(NH4)2MoO4](H2O)", true);


        PhosphorusPentasulfide = new Material.Builder(Supersymmetry.id("phosphorus_pentasulfide"))
                .dust()
                .components(Phosphorus, 2, Sulfur, 5)
                .colorAverage()
                .buildAndRegister();

        SodiumDithiophosphateSolution = new Material.Builder(Supersymmetry.id("sodium_dithiophosphate_solution"))
                .liquid()
                .components(Sodium, 3, Oxygen, 2, Sulfur, 2, Water, 2)
                .color(0xa69737)
                .buildAndRegister()
                .setFormula("(Na3PO2S2)(H2O)2", true);


        AlkaliFusedWulfenite = new Material.Builder(Supersymmetry.id("alkali_fused_wulfenite"))
                .dust()
                .components(Sodium, 2, Hydrogen, 2, Oxygen, 6)
                .color(0xff805e)
                .buildAndRegister()
                .setFormula("[Pb(OH)2](Na2MoO4)", true);


        LeadIIHydroxide = new Material.Builder(Supersymmetry.id("lead_ii_hydroxide"))
                .dust()
                .components(Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Pb(OH)2", true);


        SodiumMolybdateSolution = new Material.Builder(Supersymmetry.id("sodium_molybdate_solution"))
                .liquid()
                .components(Sodium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Na2MoO4)(H2O)", true);


        // FREE ID: 8532-8533

        TitaniumIodide = new Material.Builder(Supersymmetry.id("titanium_iodide"))
                .dust()
                .components(Iodine, 4)
                .colorAverage()
                .buildAndRegister();

        //FREE IDs: 8535-8537

        FusedZirconia = new Material.Builder(Supersymmetry.id("fused_zirconia"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .iconSet(GLASS)
                .buildAndRegister();

        ImpureZirconiumTetrachloride = new Material.Builder(Supersymmetry.id("impure_zirconium_tetrachloride"))
                .dust()
                .components(Chlorine, 4)
                .color(0x519c78)
                .buildAndRegister()
                .setFormula("(ZrCl4)(?)", true);


        ZirconiumSulfateSolution = new Material.Builder(Supersymmetry.id("zirconium_sulfate_solution"))
                .liquid()
                .components(Sulfur, 2, Oxygen, 8, Water, 3)
                .color(0x4fa15c)
                .buildAndRegister()
                .setFormula("[Zr(SO4)2](H2O)3", true);


        ZirconylChlorideSolution = new Material.Builder(Supersymmetry.id("zirconyl_chloride_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorine, 2, HydrogenChloride, 2, Water, 2)
                .color(0x38a149)
                .buildAndRegister()
                .setFormula("(ZrOCl2)(HCl)2(H2O)2", true);


        PurifiedZirconylChlorideSolution = new Material.Builder(Supersymmetry.id("purified_zirconyl_chloride_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorine, 2, HydrogenChloride, 2, Water, 2)
                .color(0x4ab55c)
                .buildAndRegister()
                .setFormula("(ZrOCl2)(HCl)2(H2O)2", true);


        ZirconiumBasicSulfate = new Material.Builder(Supersymmetry.id("zirconium_basic_sulfate"))
                .dust()
                .components(Zirconium, 5, Sulfur, 2, Oxygen, 16)
                .color(0x5fb54a)
                .buildAndRegister()
                .setFormula("Zr5O8(SO4)2", true);


        ZirconiumTetrachloride = new Material.Builder(Supersymmetry.id("zirconium_tetrachloride"))
                .dust().liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(710))
                .components(Chlorine, 4)
                .color(0x32ad72)
                .buildAndRegister();

        HafniumSulfateSolution = new Material.Builder(Supersymmetry.id("hafnium_sulfate_solution"))
                .liquid()
                .components(Sulfur, 2, Oxygen, 8, Water, 2)
                .color(0xbbd1b0)
                .buildAndRegister()
                .setFormula("[Hf(SO4)2](H2O)2", true);


        HafniumDioxide = new Material.Builder(Supersymmetry.id("hafnium_dioxide"))
                .dust()
                .components(Oxygen, 2)
                .colorAverage()
                .buildAndRegister();

        ImpureHafniumTetrachloride = new Material.Builder(Supersymmetry.id("impure_hafnium_tetrachloride"))
                .dust()
                .components(Chlorine, 4)
                .color(0xabccae)
                .buildAndRegister()
                .setFormula("(HfCl4)(?)", true);


        ZirconiumIodide = new Material.Builder(Supersymmetry.id("zirconium_iodide"))
                .dust()
                .components(Iodine, 4)
                .colorAverage()
                .buildAndRegister();

        HafniumIodide = new Material.Builder(Supersymmetry.id("hafnium_iodide"))
                .dust()
                .components(Iodine, 4)
                .colorAverage()
                .buildAndRegister();

        CalciumZirconate = new Material.Builder(Supersymmetry.id("calcium_zirconate"))
                .dust()
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        NickelIINitrateSolution = new Material.Builder(Supersymmetry.id("nickel_nitrate_solution"))
                .liquid()
                .components(Nitrogen, 2, Oxygen, 6)
                .colorAverage()
                .buildAndRegister()
                .setFormula("[Ni(NO3)2](H2O)", true);


        FerroniobiumTantalum = new Material.Builder(Supersymmetry.id("ferroniobium_tantalum"))
                .dust()
                .components(Iron, 30, Niobium, 65, Tantalum, 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .buildAndRegister();

        TantalumPentachloride = new Material.Builder(Supersymmetry.id("tantalum_pentachloride"))
                .dust().gas(new FluidBuilder().temperature(513))
                .flags(NO_UNIFICATION)
                .components(Chlorine, 5)
                .colorAverage()
                .buildAndRegister();

        NiobiumPentachloride = new Material.Builder(Supersymmetry.id("niobium_pentachloride"))
                .dust().gas(new FluidBuilder().temperature(521))
                .flags(NO_UNIFICATION)
                .components(Chlorine, 5)
                .color(0xcfcf1d)
                .buildAndRegister();

        NiobiumOxideDihydrate = new Material.Builder(Supersymmetry.id("niobium_oxide_dihydrate"))
                .dust()
                .components(Niobium, 2, Oxygen, 5, Water, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("Nb2O5 * (H2O)2", true);


        PurifiedFluoroniobicAcidSolution = new Material.Builder(Supersymmetry.id("purified_fluoroniobic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 6, Niobium, 3, Fluorine, 9, Water, 6)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H2NbF7)1.35(H2O)6", true);


        NiobiumOxide = new Material.Builder(Supersymmetry.id("niobium_oxide"))
                .dust()
                .components(Niobium, 2, Oxygen, 5)
                .colorAverage()
                .buildAndRegister();

        FluorotantalicAcidSolution = new Material.Builder(Supersymmetry.id("fluorotantalic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 2, Fluorine, 7)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(H2TaF7)0.9(H2O)", true);


        PotassiumHeptafluorotantalate = new Material.Builder(Supersymmetry.id("potassium_heptafluorotantalate"))
                .dust()
                .components(Potassium, 2, Fluorine, 7)
                .colorAverage()
                .buildAndRegister();

        DilutedAmmoniaSolution = new Material.Builder(Supersymmetry.id("diluted_ammonia_solution"))
                .liquid()
                .components(Water, 2)
                .colorAverage()
                .buildAndRegister();

        TantalumFluoride = new Material.Builder(Supersymmetry.id("tantalum_fluoride"))
                .dust()
                .components(Fluorine, 5)
                .colorAverage()
                .buildAndRegister();

        AmmoniumPerrhenate = new Material.Builder(Supersymmetry.id("ammonium_perrhenate"))
                .dust()
                .components(Hydrogen, 4, Oxygen, 4)
                .color(0x2b6cb3)
                .buildAndRegister();

        //FREE ID: 8565

        NickelHydrotalcite = new Material.Builder(Supersymmetry.id("nickel_hydrotalcite"))
                .dust()
                .components(Nickel, 6, Aluminium, 2)
                .color(0x9fb833)
                .buildAndRegister()
                .setFormula("[Ni3Al(OH)8]Cl", true);


        CalciumCyanamide = new Material.Builder(Supersymmetry.id("calcium_cyanamide"))
                .dust()
                .components(Nitrogen, 2)
                .colorAverage()
                .buildAndRegister();

        AntimonyPentafluoride = new Material.Builder(Supersymmetry.id("antimony_pentafluoride"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Fluorine, 5)
                .colorAverage()
                .buildAndRegister();

        SodiumHexafluoroantimonate = new Material.Builder(Supersymmetry.id("sodium_hexafluoroantimonate"))
                .dust()
                .components(Fluorine, 6)
                .colorAverage()
                .buildAndRegister();

        AlluvialPGM = new Material.Builder(Supersymmetry.id("alluvial_pgm"))
                .dust().ingot()
                .flags(DISABLE_DECOMPOSITION)
                .components(Platinum, 2)
                .colorAverage()
                .buildAndRegister();

        // FREE ID: 8572

        ImpureBariumSulfide = new Material.Builder(Supersymmetry.id("impure_barium_sulfide"))
                .dust()
                .components()
                .iconSet(DULL)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(BaS)", true);


        ImpureStrontiumSulfide = new Material.Builder(Supersymmetry.id("impure_strontium_sulfide"))
                .dust()
                .components()
                .iconSet(DULL)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(?)(SrS)", true);


        StrontiumSulfideSolution = new Material.Builder(Supersymmetry.id("strontium_sulfide_solution"))
                .liquid()
                .components()
                .colorAverage()
                .buildAndRegister()
                .setFormula("(SrS)(H2O)", true);


        StrontiumOxide = new Material.Builder(Supersymmetry.id("strontium_oxide"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        DilutedAceticAcid = new Material.Builder(Supersymmetry.id("diluted_acetic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister();

        CobaltIIAcetate = new Material.Builder(Supersymmetry.id("cobalt_ii_acetate"))
                .dust()
                .components(Carbon, 4, Oxygen, 6, Hydrogen, 4, Water, 4)
                .color(0xfc7e89)
                .buildAndRegister()
                .setFormula("Co(C2H3O2)2", true);


        PotassiumPyrosulfate = new Material.Builder(Supersymmetry.id("potassium_pyrosulfate"))
                .dust()
                .components(Potassium, 2, Sulfur, 2, Oxygen, 7)
                .colorAverage()
                .buildAndRegister();

        IronIIINitrateSolution = new Material.Builder(Supersymmetry.id("iron_iii_nitrate_solution"))
                .liquid()
                .components(Nitrogen, 3, Oxygen, 9, Water, 3)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Fe(NO3)3)(H2O)3", true);


        ChlorosulfuricAcid = new Material.Builder(Supersymmetry.id("chlorosulfuric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Oxygen, 3)
                .colorAverage()
                .buildAndRegister();

        ManganeseIIChloride = new Material.Builder(Supersymmetry.id("manganese_ii_chloride"))
                .dust()
                .components(Chlorine, 2)
                .colorAverage()
                .buildAndRegister();

        ChloroplatinicAcidSolution = new Material.Builder(Supersymmetry.id("chloroplatinic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, 2, Chlorine, 6, Water, 4)
                .colorAverage()
                .buildAndRegister();

        MolybdenumDisulfide = new Material.Builder(Supersymmetry.id("molybdenum_disulfide"))
                .dust()
                .components(Sulfur, 2)
                .colorAverage()
                .buildAndRegister();

        FluorinatedGraphite = new Material.Builder(Supersymmetry.id("fluorinated_graphite"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        AcrylicCatalyst = new Material.Builder(Supersymmetry.id("acrylic_catalyst"))
                .dust()
                .components(Bromine, 4)
                .colorAverage()
                .buildAndRegister();

        GelatinSolution = new Material.Builder(Supersymmetry.id("gelatin_solution"))
                .liquid(new FluidBuilder().temperature(323))
                .components()
                .colorAverage()
                .buildAndRegister();

        PhosphomolybdicAcid = new Material.Builder(Supersymmetry.id("phosphomolybdic_acid"))
                .dust()
                .components(Hydrogen, 3, Molybdenum, 12, Oxygen, 40)
                .color(0xb39c07)
                .buildAndRegister()
                .setFormula("H3[PMo12O40]", true);


        UraniumDioxide = new Material.Builder(Supersymmetry.id("uranium_dioxide"))
                .dust()
                .iconSet(SAND)
                .components(Oxygen, 2)
                .color(0x20291b)
                .buildAndRegister()
                .setFormula("UO2", true);


        UraniumTetrafluoride = new Material.Builder(Supersymmetry.id("uranium_tetrafluoride"))
                .dust()
                .iconSet(SAND)
                .components(Fluorine, 4)
                .color(0x58826a)
                .buildAndRegister()
                .setFormula("UF4", true);


        SiliconTetrachloride = new Material.Builder(Supersymmetry.id("silicon_tetrachloride"))
                .liquid()
                .components(Chlorine, 4)
                .color(0x63827f)
                .buildAndRegister();

        PurifiedSiliconTetrachloride = new Material.Builder(Supersymmetry.id("purified_silicon_tetrachloride"))
                .liquid()
                .components(Chlorine, 4)
                .color(0x7fa3a0)
                .buildAndRegister();

        SaltyHydrofluoricAcid = new Material.Builder(Supersymmetry.id("salty_hydrofluoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components()
                .colorAverage()
                .buildAndRegister();

        WaferTreatmentAcid = new Material.Builder(Supersymmetry.id("wafer_treatment_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HydrochloricAcid, 9, HydrofluoricAcid, 9, AceticAcid, 2)
                .color(0x3e7d68)
                .buildAndRegister();

        ThalliumIChloride = new Material.Builder(Supersymmetry.id("thallium_i_chloride"))
                .dust()
                .components()
                .colorAverage()
                .buildAndRegister();

        AcidicThalliumSulfateSolution = new Material.Builder(Supersymmetry.id("acidic_thallium_sulfate_solution"))
                .liquid()
                .components(Thallium, 2, Oxygen, 4, HydrogenChloride, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Tl2SO4)(HCl)2(H2O)", true);


        ThalliumSulfateSolution = new Material.Builder(Supersymmetry.id("thallium_sulfate_solution"))
                .liquid()
                .components(Thallium, 2, Oxygen, 4)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(Tl2SO4)(H2O)", true);


        //FREE ID: 8597

        //FREE ID: 8598

        PurifiedCadmiumSolution = new Material.Builder(Supersymmetry.id("purified_cadmium_solution"))
                .liquid()
                .components(Oxygen, 4)
                .colorAverage()
                .buildAndRegister();

        GermaniumTetrachloride = new Material.Builder(Supersymmetry.id("germanium_tetrachloride"))
                .liquid()
                .components(Chlorine, 4)
                .color(0xbae6dd)
                .buildAndRegister();

        GermaniumDioxide = new Material.Builder(Supersymmetry.id("germanium_dioxide"))
                .dust()
                .components(Oxygen, 2)
                .color(0x4b9485)
                .buildAndRegister();

        IronOxalateDihydrate = new Material.Builder(Supersymmetry.id("iron_oxalate_dihydrate"))
                .dust()
                .components(Carbon, 2, Oxygen, 4, Water, 2)
                .colorAverage()
                .buildAndRegister();

        IndiumIIISulfateSolution = new Material.Builder(Supersymmetry.id("indium_iii_sulfate_solution"))
                .liquid()
                .components(Indium, 2, Sulfur, 3, Oxygen, 12, Water, 6)
                .color(0x8d18ad)
                .buildAndRegister()
                .setFormula("(In2(SO4)3)(H2O)6", true);


        ZincSulfateSolution = new Material.Builder(Supersymmetry.id("zinc_sulfate_solution"))
                .liquid()
                .components(Oxygen, 4, Water, 2)
                .colorAverage()
                .buildAndRegister()
                .setFormula("(ZnSO4)(H2O)2", true);


        SodiumSelenateSolution = new Material.Builder(Supersymmetry.id("sodium_selenate_solution"))
                .liquid()
                .components(Sodium, 2, Oxygen, 4)
                .color(0xb0bf97)
                .buildAndRegister()
                .setFormula("(Na2SeO4)(H2O)", true);


        SodiumSeleniteSolution = new Material.Builder(Supersymmetry.id("sodium_selenite_solution"))
                .liquid()
                .components(Sodium, 2, Oxygen, 3)
                .color(0x96a67c)
                .buildAndRegister()
                .setFormula("(Na2SeO3)(H2O)", true);


        HydrogenSelenide = new Material.Builder(Supersymmetry.id("hydrogen_selenide"))
                .gas()
                .components(Hydrogen, 2)
                .color(0xcadb93)
                .buildAndRegister();

        TelluriumDioxide = new Material.Builder(Supersymmetry.id("tellurium_dioxide"))
                .dust()
                .components(Oxygen, 2)
                .color(0xb1d4b0)
                .buildAndRegister();

        SodiumTelluriteSolution = new Material.Builder(Supersymmetry.id("sodium_tellurite_solution"))
                .liquid()
                .components(Sodium, 2, Oxygen, 3, Water, 3)
                .color(0xb0d4c6)
                .buildAndRegister()
                .setFormula("(Na2TeO3)(H2O)3", true);


        SodiumAlum = new Material.Builder(Supersymmetry.id("sodium_alum"))
                .dust()
                .components(Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .buildAndRegister()
                .setFormula("NaAl(SO4)2", true);


        CaesiumAlum = new Material.Builder(Supersymmetry.id("caesium_alum"))
                .dust()
                .components(Sulfur, 2, Oxygen, 8)
                .color(0x293c9e)
                .buildAndRegister()
                .setFormula("CsAl(SO4)2", true);


        RubidiumAlum = new Material.Builder(Supersymmetry.id("rubidium_alum"))
                .dust()
                .components(Sulfur, 2, Oxygen, 8)
                .color(0xc72882)
                .buildAndRegister()
                .setFormula("RbAl(SO4)2", true);


        CaesiumSulfateSolution = new Material.Builder(Supersymmetry.id("caesium_sulfate_solution"))
                .liquid()
                .components(Caesium, 2, Oxygen, 4)
                .color(0x8528c7)
                .buildAndRegister();

        CaesiumChloride = new Material.Builder(Supersymmetry.id("caesium_chloride"))
                .dust()
                .components()
                .color(0x2885c7)
                .buildAndRegister();

        ReducedCaesiumMixture = new Material.Builder(Supersymmetry.id("reduced_caesium_mixture"))
                .dust()
                .components(Caesium, 2)
                .color(0xf7f7d0)
                .buildAndRegister();

        CaesiumHydroxideSolution = new Material.Builder(Supersymmetry.id("caesium_hydroxide_solution"))
                .liquid()
                .components()
                .color(0x5458bf)
                .buildAndRegister()
                .setFormula("(CsOH)(H2O)", true);


        CaesiumFormateSolution = new Material.Builder(Supersymmetry.id("caesium_formate_solution"))
                .liquid()
                .components(Oxygen, 2)
                .color(0x7b54bf)
                .buildAndRegister();

        RubidiumHydroxide = new Material.Builder(Supersymmetry.id("rubidium_hydroxide"))
                .dust()
                .components()
                .color(0xbf54bb)
                .buildAndRegister();
    }
}
