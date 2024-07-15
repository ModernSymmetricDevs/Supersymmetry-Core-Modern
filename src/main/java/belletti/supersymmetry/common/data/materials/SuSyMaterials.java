package belletti.supersymmetry.common.data.materials;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.data.materials.groovy.GroovySuSyFirstDegreeMaterials;
import belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.lang.reflect.Field;
import java.util.Map;

public class SuSyMaterials {
    public static Material ManganeseIronArsenicPhosphide;
    public static Material PraseodymiumNickel;
    public static Material GadoliniumSiliconGermanium;
    public static Material Gabbro;
    public static Material Gneiss;
    public static Material Limestone;
    public static Material Phyllite;
    public static Material Shale;
    public static Material Slate;
    public static Material Kimberlite;
    public static Material Latex;
    public static Material Mud;
    public static Material Seawater;

    //Minerals
    public static Material Anorthite;
    public static Material Albite;
    public static Material Oligoclase;
    public static Material Andesine;
    public static Material Labradorite;
    public static Material Bytownite;
    public static Material Clinochlore;
    public static Material Augite;
    public static Material Dolomite;
    public static Material Muscovite;
    public static Material Forsterite;
    public static Material Lizardite;
    public static Material Fluorite;

    public static void init() {
        SuSyElementMaterials.init();
        SuSyFirstDegreeMaterials.init();
        SuSySecondDegreeMaterials.init();
        SuSyOrganicChemistryMaterials.init();
        SuSyHighDegreeMaterials.init();
        SuSyUnknownCompositionMaterials.init();

        GroovySuSyMaterials.init();
    }

    public static void safeSetProperty(Material material, PropertyKey key, IMaterialProperty property) {
        try {
            material.setProperty(key, property);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("already registered")) {
                throw e;
            }
            Supersymmetry.LOGGER.warn("Suppressed error while setting property for {}: {}", material.getName(), e.getMessage());
        }
    }

    public static void changeProperties() {
        // @TODO: these must be handled via datapacks for 1.20
        //  removeProperty(PropertyKey.ORE, GTMaterials.Soapstone);
        //  removeProperty(PropertyKey.ORE, GTMaterials.Quartzite);
        //  removeProperty(PropertyKey.ORE, GTMaterials.Mica);
        removeProperty(PropertyKey.FLUID_PIPE, GTMaterials.Lead);
        GTMaterials.Lead.setProperty(PropertyKey.FLUID_PIPE, new FluidPipeProperties(1200, 8, true, true, false, false));

        //Add dusts and fluids for elements that do not have them
        safeSetProperty(GTMaterials.Iodine, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Scandium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Germanium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Selenium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Bromine, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.Rubidium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Strontium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Zirconium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Technetium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Tellurium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Praseodymium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Promethium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Gadolinium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Terbium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Dysprosium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Holmium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Erbium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Thulium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Ytterbium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Hafnium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Rhenium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Thallium, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.CalciumChloride, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.MagnesiumChloride, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.RockSalt, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.Salt, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.SodiumHydroxide, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.Sodium, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.Phosphorus, PropertyKey.INGOT, new IngotProperty());

        FluidProperty fluidProperty = new FluidProperty();
        fluidProperty.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(317));
        safeSetProperty(GTMaterials.Phosphorus, PropertyKey.FLUID, fluidProperty);
        GTMaterials.Phosphorus.setMaterialARGB(0xfffed6);

        GTMaterials.HydrochloricAcid.setFormula("(H2O)(HCl)", true);
        GTMaterials.HydrofluoricAcid.setFormula("(H2O)(HF)", true);

        removeProperty(PropertyKey.FLUID, GTMaterials.Dimethyldichlorosilane);

        safeSetProperty(GTMaterials.Dimethyldichlorosilane, PropertyKey.FLUID, new FluidProperty());
        safeSetProperty(GTMaterials.Iron3Chloride, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Nitrochlorobenzene, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Dichlorobenzene, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Dichlorobenzidine, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.PhthalicAcid, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.DiphenylIsophtalate, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.Diaminobenzidine, PropertyKey.DUST, new DustProperty());
        safeSetProperty(GTMaterials.PolyvinylAcetate, PropertyKey.DUST, new DustProperty());

        GTMaterials.Platinum.addFlags(SuSyMaterialFlags.GENERATE_CATALYST_BED);

        GTMaterials.Cobalt.addFlags(SuSyMaterialFlags.GENERATE_CATALYST_BED);

        GTMaterials.Palladium.addFlags(SuSyMaterialFlags.GENERATE_CATALYST_BED);

        GTMaterials.Rhodium.addFlags(SuSyMaterialFlags.GENERATE_CATALYST_BED);

        GTMaterials.Copper.addFlags(SuSyMaterialFlags.GENERATE_CATALYST_BED);

        safeSetProperty(GTMaterials.Electrum, PropertyKey.ORE, new OreProperty());

        GTMaterials.Hydrogen.addFlags(MaterialFlags.FLAMMABLE);
    }

    private static void removeProperty(PropertyKey<?> key, Material material) {
        try {
            Field field = MaterialProperties.class.getDeclaredField("propertyMap");
            field.setAccessible(true);
            //noinspection unchecked
            Map<PropertyKey<?>, IMaterialProperty> map = (Map<PropertyKey<?>, IMaterialProperty>) field.get(material.getProperties());
            map.remove(key);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Supersymmetry.LOGGER.error("Failed to reflect material property map", e);
        }
    }
}
