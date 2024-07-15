package belletti.supersymmetry.common.data.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;

import static belletti.supersymmetry.common.data.materials.groovy.GroovyGlobals.determineTemperatureGas;
import static belletti.supersymmetry.common.data.materials.groovy.GroovyGlobals.determineTemperatureLiquid;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GroovyThermodynamicsMaterials {
    private static void generateHighPressureGases(Material materialName, boolean generateCold){
        var color = materialName.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("hot_hp_" + materialName.getName()))
                .gas(new FluidBuilder().temperature(323))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("hp_" + materialName.getName()))
                .gas()
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        if (generateCold) {
            new Material.Builder(Supersymmetry.id("cold_hp_" + materialName.getName()))
                    .gas(new FluidBuilder().temperature(223))
                    .color(color)
                    .components(materialName, 1)
                    .flags(DISABLE_DECOMPOSITION)
                    .buildAndRegister();
        }
    }

    private static void generateLiquidFromGas(Material materialName, int boilingTemperature){
        var color = materialName.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("liquid_" + materialName.getName()))
                .liquid(new FluidBuilder().temperature(boilingTemperature))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }

    private static void generateThermoRefrigerant(Material materialName){
        var color = materialName.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("hot_compressed_" + materialName.getName()))
                .gas(new FluidBuilder().temperature(323))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("compressed_" + materialName.getName()))
                .gas()
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("cold_compressed_" + materialName.getName()))
                .gas(new FluidBuilder().temperature(223))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("cold_" + materialName.getName()))
                .gas(new FluidBuilder().temperature(223))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }

    private static void generateCoolant(Material materialName){
        var color = materialName.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("warm_" + materialName.getName()))
                .liquid(new FluidBuilder().temperature(303))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

    }

    private static void generateHotGas(Material material) {
        var color = material.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("hot_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 100))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }

    private static void generateGreenhouseGases(Material material) {
        var color = material.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("warm_dry_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("warm_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("warm_humid_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("dry_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("humid_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("cool_dry_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("cool_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();

        new Material.Builder(Supersymmetry.id("cool_humid_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }

    private static void generatePurifiedGas(Material material) {
        var color = material.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("high_purity_" + material.getName()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                .color(color)
                .components(material, 1)
                .buildAndRegister();
    }

    private static void generatePurifiedLiquid(Material material) {
        var color = material.getMaterialRGB();

        new Material.Builder(Supersymmetry.id("high_purity_" + material.getName()))
                .liquid(new FluidBuilder().temperature(determineTemperatureLiquid(material)))
                .color(color)
                .components(material, 1)
                .buildAndRegister();
    }


    public static void register() {

        Supersymmetry.LOGGER.info("Registering Thermodynamics Materials!");

        generateHighPressureGases(Hydrogen, true);
        generateHighPressureGases(Oxygen, true);
        generateHighPressureGases(Helium, true);
        generateHighPressureGases(Neon, true);
        generateHighPressureGases(Argon, true);
        generateHighPressureGases(Krypton, true);
        generateHighPressureGases(Xenon, true);
        generateHighPressureGases(Nitrogen, true);
        generateHighPressureGases(Propene, false);
        generateHighPressureGases(Benzene, false);
        generateHighPressureGases(CarbonMonoxide, false);
        generateHighPressureGases(Air, true);
        generateHighPressureGases(NetherAir, true);
        generateHighPressureGases(RefineryGas, true);
        generateHighPressureGases(Methane, true);
        generateHighPressureGases(NaturalGas, true);
        generateHighPressureGases(DecarburizedAir, true);

        generateLiquidFromGas(Hydrogen, 14);
        generateLiquidFromGas(Neon, 27);
        generateLiquidFromGas(Argon, 88);
        generateLiquidFromGas(Krypton, 120);
        generateLiquidFromGas(Xenon, 165);
        generateLiquidFromGas(Nitrogen, 77);
        generateLiquidFromGas(RefineryGas, 112);
        generateLiquidFromGas(Methane, 112);
        generateLiquidFromGas(NaturalGas, 110);
        generateLiquidFromGas(DecarburizedAir, 80);

        generateThermoRefrigerant(Ammonia);
        generateThermoRefrigerant(Propane);
        generateThermoRefrigerant(CarbonDioxide);
        generateThermoRefrigerant(Trichlorofluoromethane);
        generateThermoRefrigerant(Dichlorodifluoromethane);
        generateThermoRefrigerant(Chlorotrifluoromethane);
        generateThermoRefrigerant(Chlorodifluoromethane);

        generateCoolant(Water);
        generateCoolant(EthyleneGlycol);
        generateCoolant(SaltWater);
        generateCoolant(Lubricant);
        generateCoolant(PolychlorinatedBiphenyl);
        generateCoolant(Brine);
        generateCoolant(SodiumPotassium);

        generateHotGas(Air);
        generateHotGas(Nitrogen);

        generatePurifiedGas(Hydrogen);
        generatePurifiedGas(Helium);
        generatePurifiedGas(Nitrogen);
        generatePurifiedGas(Oxygen);
        generatePurifiedGas(Fluorine);
        generatePurifiedGas(Neon);
        generatePurifiedGas(Chlorine);
        generatePurifiedGas(Argon);
        generatePurifiedGas(Krypton);
        generatePurifiedGas(Xenon);
        generatePurifiedLiquid(Bromine);
        generatePurifiedLiquid(Mercury);

        generateGreenhouseGases(EarthGreenhouseGas);

        EarthlikeAir = new Material.Builder(Supersymmetry.id("earth_like_air"))
                .gas()
                .color(0x8fbfe3)
                .buildAndRegister();

        HotHighPressureSteam = new Material.Builder(Supersymmetry.id("hot_hp_steam"))
                .gas(new FluidBuilder().temperature(1200))
                .color(0xffffff)
                .buildAndRegister();

        WasteGaseousNitrogen = new Material.Builder(Supersymmetry.id("waste_gaseous_nitrogen"))
                .gas()
                .color(0x29a4a6)
                .buildAndRegister();

        ChillyWasteGaseousNitrogen = new Material.Builder(Supersymmetry.id("chilly_waste_gaseous_nitrogen"))
                .gas(new FluidBuilder().temperature(243))
                .color(0x3f9d9e)
                .buildAndRegister();

        SubcooledLiquidNitrogen = new Material.Builder(Supersymmetry.id("subcooled_liquid_nitrogen"))
                .liquid(new FluidBuilder().temperature(60))
                .color(0x009a9c)
                .buildAndRegister();

        ColdWasteGaseousNitrogen = new Material.Builder(Supersymmetry.id("cold_waste_gaseous_nitrogen"))
                .gas(new FluidBuilder().temperature(223))
                .color(0x367f80)
                .buildAndRegister();

        UntreatedLiquidOxygen = new Material.Builder(Supersymmetry.id("untreated_liquid_oxygen"))
                .liquid(new FluidBuilder().temperature(55))
                .color(0x49a4d1)
                .buildAndRegister();

        UntreatedLiquidNitrogen = new Material.Builder(Supersymmetry.id("untreated_liquid_nitrogen"))
                .liquid(new FluidBuilder().temperature(60))
                .color(0x029799)
                .buildAndRegister();

        OxygenRichLiquid = new Material.Builder(Supersymmetry.id("oxygen_rich_liquid"))
                .liquid(new FluidBuilder().temperature(55))
                .color(0x67c6e0)
                .buildAndRegister();

        OxygenRichGas = new Material.Builder(Supersymmetry.id("oxygen_rich_gas"))
                .gas(new FluidBuilder().temperature(90))
                .color(0x78d2eb)
                .buildAndRegister();

        NitrogenRichGas = new Material.Builder(Supersymmetry.id("nitrogen_rich_gas"))
                .gas(new FluidBuilder().temperature(120))
                .color(0x7ee0dd)
                .buildAndRegister();

        ArgonRichGas = new Material.Builder(Supersymmetry.id("argon_rich_gas"))
                .gas(new FluidBuilder().temperature(140))
                .color(0x6bc9aa)
                .buildAndRegister();

        OxygenRichVapor = new Material.Builder(Supersymmetry.id("oxygen_rich_vapor"))
                .gas(new FluidBuilder().temperature(170))
                .color(0x92e1f7)
                .buildAndRegister();

        CrudeArgonVapor = new Material.Builder(Supersymmetry.id("crude_argon_vapor"))
                .gas(new FluidBuilder().temperature(160))
                .color(0x78e3c0)
                .buildAndRegister();

        SubcooledOxygenRichLiquid = new Material.Builder(Supersymmetry.id("subcooled_oxygen_rich_liquid"))
                .gas(new FluidBuilder().temperature(90))
                .color(0x0dba0d)
                .buildAndRegister();

        CrudeLiquidKrypton = new Material.Builder(Supersymmetry.id("crude_liquid_krypton"))
                .liquid(new FluidBuilder().temperature(120))
                .color(0x579e57)
                .buildAndRegister();

        RareGasRichFraction = new Material.Builder(Supersymmetry.id("rare_gas_rich_fraction"))
                .gas(new FluidBuilder().temperature(80))
                .color(0xd3eb94)
                .buildAndRegister();

        CondensedRareGasRichFraction = new Material.Builder(Supersymmetry.id("condensed_rare_gas_rich_fraction"))
                .gas(new FluidBuilder().temperature(60))
                .color(0xe3a56b)
                .buildAndRegister();

        CrudeNeonVapor = new Material.Builder(Supersymmetry.id("crude_neon_vapor"))
                .gas(new FluidBuilder().temperature(40))
                .color(0xc77b7b)
                .buildAndRegister();

        GaseousCrudeKrypton = new Material.Builder(Supersymmetry.id("gaseous_crude_krypton"))
                .gas(new FluidBuilder().temperature(160))
                .color(0x579e57)
                .buildAndRegister();

        ColdLiquidOxygen = new Material.Builder(Supersymmetry.id("cold_liquid_oxygen"))
                .liquid(new FluidBuilder().temperature(40))
                .color(0x1f729c)
                .buildAndRegister();

        CompressedCrudeNeon = new Material.Builder(Supersymmetry.id("compressed_crude_neon"))
                .gas(new FluidBuilder().temperature(40))
                .color(0xa65e5e)
                .buildAndRegister();

        PartiallyLiquefiedCrudeNeon = new Material.Builder(Supersymmetry.id("partially_liquefied_crude_neon"))
                .liquid(new FluidBuilder().temperature(30))
                .color(0xb35959)
                .buildAndRegister();

        GaseousCrudeNeon = new Material.Builder(Supersymmetry.id("gaseous_crude_neon"))
                .gas(new FluidBuilder().temperature(35))
                .color(0xbd5757)
                .buildAndRegister();

        LiquidCrudeNeon = new Material.Builder(Supersymmetry.id("liquid_crude_neon"))
                .liquid(new FluidBuilder().temperature(25))
                .color(0x944444)
                .buildAndRegister();

        LiquidCrudeArgon = new Material.Builder(Supersymmetry.id("liquid_crude_argon"))
                .liquid(new FluidBuilder().temperature(90))
                .color(0x0dba0d)
                .buildAndRegister();

        ColdGaseousNitrogen = new Material.Builder(Supersymmetry.id("cold_gaseous_nitrogen"))
                .gas(new FluidBuilder().temperature(140))
                .color(0x23b9ba)
                .buildAndRegister();

        LiquidArgonProduct = new Material.Builder(Supersymmetry.id("liquid_argon_product"))
                .liquid(new FluidBuilder().temperature(87))
                .color(0x0ecc0e)
                .buildAndRegister();

        LiquidOxygenProduct = new Material.Builder(Supersymmetry.id("liquid_oxygen_product"))
                .liquid(new FluidBuilder().temperature(90))
                .color(0x459fcc)
                .buildAndRegister();

        LiquidNitrogenProduct = new Material.Builder(Supersymmetry.id("liquid_nitrogen_product"))
                .liquid(new FluidBuilder().temperature(77))
                .color(0x0b9a9c)
                .buildAndRegister();

        LiquidDeoxygenatedArgon = new Material.Builder(Supersymmetry.id("liquid_deoxygenated_argon"))
                .liquid(new FluidBuilder().temperature(87))
                .color(0x3de03d)
                .buildAndRegister();

        LiquidWasteNitrogen = new Material.Builder(Supersymmetry.id("liquid_waste_nitrogen"))
                .liquid(new FluidBuilder().temperature(77))
                .color(0x379394)
                .buildAndRegister();

        PartiallyLiquefiedArgon = new Material.Builder(Supersymmetry.id("partially_liquefied_argon"))
                .liquid(new FluidBuilder().temperature(120))
                .color(0x56bf56)
                .buildAndRegister();

        SupercriticalCarbonDioxide = new Material.Builder(Supersymmetry.id("supercritical_carbon_dioxide"))
                .liquid(new FluidBuilder().temperature(373))
                .components(CarbonDioxide, 1)
                .colorAverage()
                .buildAndRegister();
    }
}
