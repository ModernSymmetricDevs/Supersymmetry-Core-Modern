package belletti.supersymmetry.common.materials;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;

import static belletti.supersymmetry.common.materials.SuSyMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DECOMPOSITION_BY_ELECTROLYZING;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.NO_SMASHING;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class SuSyFirstDegreeMaterials {
    public static void init() {
        ManganeseIronArsenicPhosphide = new Material.Builder(Supersymmetry.id("manganese_iron_arsenic_phosphide"))
                .ingot()
                .color(0x03FCF0).iconSet(MaterialIconSet.METALLIC)
                .cableProperties(GTValues.V[4], 2, 4)
                .components(Manganese, 2, Iron, 2, Arsenic, 1, Phosphorus, 1)
                .blastTemp(2100, BlastProperty.GasTier.LOW)
                .buildAndRegister();

        PraseodymiumNickel = new Material.Builder(Supersymmetry.id("praseodymium_nickel"))
                .ingot()
                .color(0x03BAFC).iconSet(MaterialIconSet.METALLIC)
                .cableProperties(GTValues.V[4], 2, 4)
                .components(Praseodymium, 5, Nickel, 1)
                .blastTemp(2100, BlastProperty.GasTier.MID)
                .buildAndRegister();

        GadoliniumSiliconGermanium = new Material.Builder(Supersymmetry.id("gadolinium_silicon_germanium"))
                .ingot()
                .color(0x0388FC).iconSet(MaterialIconSet.SHINY)
                .cableProperties(GTValues.V[4], 2, 4)
                .components(Gadolinium, 5, Silicon, 2, Germanium, 2)
                .blastTemp(2100, BlastProperty.GasTier.HIGH)
                .buildAndRegister();

        // Minerals

        Anorthite = new Material.Builder(Supersymmetry.id("anorthite"))
                .dust()
                .gem()
                .color(0x595853).iconSet(CERTUS)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Calcium, 1, Aluminium, 2, Silicon, 2, Oxygen, 8)
                .buildAndRegister()
                .setFormula("Ca(Al2Si2O8)", true);


        Albite = new Material.Builder(Supersymmetry.id("albite"))
                .dust()
                .gem()
                .color(0xc4a997).iconSet(CERTUS)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Sodium, 1, Aluminium, 1, Silicon, 3, Oxygen, 8)
                .buildAndRegister()
                .setFormula("Na(AlSi3O8)", true);

        Oligoclase = new Material.Builder(Supersymmetry.id("oligoclase"))
                .dust()
                .gem()
                .color(0xd5c4b8).iconSet(CERTUS)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Albite, 4, Anorthite, 1)
                .buildAndRegister()
                .setFormula("(Na,Ca)(Si,Al)4O8", true);

        Andesine = new Material.Builder(Supersymmetry.id("andesine"))
                .dust()
                .gem()
                .color(0xe18e6f).iconSet(EMERALD)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Albite, 3, Anorthite, 2)
                .buildAndRegister()
                .setFormula("(Na,Ca)(Si,Al)4O8", true);

        Labradorite = new Material.Builder(Supersymmetry.id("labradorite"))
                .dust()
                .gem()
                .color(0x5c7181).iconSet(RUBY)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Albite, 2, Anorthite, 3)
                .buildAndRegister()
                .setFormula("(Na,Ca)(Si,Al)4O8", true);

        Bytownite = new Material.Builder(Supersymmetry.id("bytownite"))
                .dust()
                .gem()
                .color(0xc99c67).iconSet(LAPIS)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Albite, 1, Anorthite, 4)
                .buildAndRegister()
                .setFormula("(Na,Ca)(Si,Al)4O8", true);

        Clinochlore = new Material.Builder(Supersymmetry.id("chlinochlore"))
                .dust()
                .gem()
                .color(0x303e38).iconSet(EMERALD)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Magnesium, 5, Aluminium, 2, Silicon, 3, Oxygen, 18, Hydrogen, 8)
                .buildAndRegister()
                .setFormula("(Mg5Al)(AlSi3)O10(OH)8", true);

        Augite = new Material.Builder(Supersymmetry.id("augite"))
                .dust()
                .color(0x1b1717).iconSet(ROUGH)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Calcium, 2, Magnesium, 3, Iron, 3, Silicon, 8, Oxygen, 24)
                .buildAndRegister()
                .setFormula("(Ca2MgFe)(MgFe)2(Si2O6)4", true);

        Dolomite = new Material.Builder(Supersymmetry.id("dolomite"))
                .dust()
                .color(0xbbb8b2)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Calcium, 1, Magnesium, 1, Carbon, 2, Oxygen, 6)
                .buildAndRegister()
                .setFormula("CaMg(CO3)2", true);

        Muscovite = new Material.Builder(Supersymmetry.id("muscovite"))
                .dust()
                .color(0x8b876a)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Potassium, 1, Aluminium, 3, Silicon, 3, Oxygen, 12, Hydrogen, 10)
                .buildAndRegister()
                .setFormula("KAl2(AlSi3O10)(OH)2)", true);

        Fluorite = new Material.Builder(Supersymmetry.id("fluorite"))
                .dust()
                .gem()
                .ore()
                .color(0x276a4c).iconSet(CERTUS)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Calcium, 1, Fluorine, 2)
                .buildAndRegister();

        Forsterite = new Material.Builder(Supersymmetry.id("forsterite"))
                .dust()
                .gem()
                .color(0x1d640f).iconSet(LAPIS)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Magnesium, 2, Sulfur, 1, Oxygen, 4)
                .buildAndRegister()
                .setFormula("Mg2(SiO4)", true);

        Lizardite = new Material.Builder(Supersymmetry.id("lizardite"))
                .dust()
                .color(0xa79e42)
                .flags(NO_SMASHING, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Magnesium, 3, Silicon, 2, Oxygen, 9, Hydrogen, 4)
                .buildAndRegister()
                .setFormula("Mg3Si2O5(OH)4", true);

    }
}
