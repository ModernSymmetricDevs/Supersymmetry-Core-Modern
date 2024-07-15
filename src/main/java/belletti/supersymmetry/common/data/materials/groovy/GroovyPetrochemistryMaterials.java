package belletti.supersymmetry.common.data.materials.groovy;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;

import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.FLAMMABLE;

public class GroovyPetrochemistryMaterials {
    public static void register() {

        Supersymmetry.LOGGER.info("Registering Petrochemistry Materials!");

        DilutedOilLight = new Material.Builder(Supersymmetry.id("diluted_oil_light"))
                .liquid()
                .color(0x2d2f3b)
                .buildAndRegister();

        DilutedOil = new Material.Builder(Supersymmetry.id("diluted_oil"))
                .liquid()
                .color(0x2d2f3b)
                .buildAndRegister();

        DilutedOilHeavy = new Material.Builder(Supersymmetry.id("diluted_oil_heavy"))
                .liquid()
                .color(0x2d2f3b)
                .buildAndRegister();

        DesaltedOilHeavy = new Material.Builder(Supersymmetry.id("desalted_oil_heavy"))
                .liquid()
                .color(0x000000)
                .buildAndRegister();

        DesaltedOilLight = new Material.Builder(Supersymmetry.id("desalted_oil_light"))
                .liquid()
                .color(0x000000)
                .buildAndRegister();

        DesaltedOil = new Material.Builder(Supersymmetry.id("desalted_oil"))
                .liquid()
                .color(0x000000)
                .buildAndRegister();

        OilyBrine = new Material.Builder(Supersymmetry.id("oily_brine"))
                .liquid()
                .color(0x69684e)
                .buildAndRegister();

        SulfuricOilResidue = new Material.Builder(Supersymmetry.id("sulfuric_oil_residue"))
                .liquid()
                .color(0x59572b)
                .buildAndRegister();

        SulfuricFuelOil = new Material.Builder(Supersymmetry.id("sulfuric_fuel_oil"))
                .liquid()
                .color(0x858135)
                .buildAndRegister();

        TreatedSulfuricFuelOil = new Material.Builder(Supersymmetry.id("treated_sulfuric_fuel_oil"))
                .liquid()
                .color(0x9e9a4f)
                .buildAndRegister();

        CrudeNaturalGas = new Material.Builder(Supersymmetry.id("crude_natural_gas"))
                .gas()
                .color(0xc9c9b9)
                .buildAndRegister();

        SulfuricNaturalGas = new Material.Builder(Supersymmetry.id("sulfuric_natural_gas"))
                .gas()
                .color(0xe3e3d1)
                .buildAndRegister();

        TreatedSulfuricNaturalGas = new Material.Builder(Supersymmetry.id("treated_sulfuric_natural_gas"))
                .gas()
                .color(0xf7f7eb)
                .buildAndRegister();

        TreatedSulfuricRefineryGas = new Material.Builder(Supersymmetry.id("treated_sulfuric_refinery_gas"))
                .gas()
                .color(0xe3e3d8)
                .buildAndRegister();

        SourGas = new Material.Builder(Supersymmetry.id("sour_gas"))
                .gas()
                .color(0xebeba4)
                .buildAndRegister();

        SulfuricDiesel = new Material.Builder(Supersymmetry.id("sulfuric_diesel"))
                .liquid()
                .color(0xa8a232)
                .buildAndRegister();

        TreatedSulfuricDiesel = new Material.Builder(Supersymmetry.id("treated_sulfuric_diesel"))
                .liquid()
                .color(0xc2bb42)
                .buildAndRegister();

        SulfuricKerosene = new Material.Builder(Supersymmetry.id("sulfuric_kerosene"))
                .liquid()
                .color(0xbfb82a)
                .buildAndRegister();

        TreatedSulfuricKerosene = new Material.Builder(Supersymmetry.id("treated_sulfuric_kerosene"))
                .liquid()
                .color(0xd6cf3a)
                .buildAndRegister();

        Kerosene = new Material.Builder(Supersymmetry.id("kerosene"))
                .liquid()
                .color(0xd6cf3a)
                .flags(FLAMMABLE)
                .buildAndRegister();

        SulfuricGasoline = new Material.Builder(Supersymmetry.id("sulfuric_gasoline"))
                .liquid()
                .color(0xe8df23)
                .buildAndRegister();

        TreatedSulfuricGasoline = new Material.Builder(Supersymmetry.id("treated_sulfuric_gasoline"))
                .liquid()
                .color(0xf7ef40)
                .buildAndRegister();

        FuelOil = new Material.Builder(Supersymmetry.id("fuel_oil"))
                .liquid()
                .color(0x9e9a4f)
                .flags(FLAMMABLE)
                .buildAndRegister();

        LubricatingOil = new Material.Builder(Supersymmetry.id("lubricating_oil"))
                .liquid()
                .color(0x858146)
                .flags(FLAMMABLE)
                .buildAndRegister();

        SlackWax = new Material.Builder(Supersymmetry.id("slack_wax"))
                .liquid()
                .color(0x7d7b59)
                .buildAndRegister();

        Resin = new Material.Builder(Supersymmetry.id("resin"))
                .liquid()
                .color(0xb5803a)
                .buildAndRegister();

        UncatalyzedSulfurousGases = new Material.Builder(Supersymmetry.id("uncatalyzed_sulfurous_gases"))
                .gas(new FluidBuilder().temperature(773))
                .color(0xd6d372)
                .buildAndRegister();

        NaphthaReformate = new Material.Builder(Supersymmetry.id("naphtha_reformate"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf2f2a0)
                .buildAndRegister();

        BtexExtract = new Material.Builder(Supersymmetry.id("btex_extract"))
                .liquid()
                .color(0xa8a87d)
                .buildAndRegister();

        BTEX = new Material.Builder(Supersymmetry.id("btex"))
                .liquid()
                .color(0x828267)
                .buildAndRegister();

        LightlySteamcrackedKerosene = new Material.Builder(Supersymmetry.id("lightly_steamcracked_kerosene"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xe3dd59)
                .buildAndRegister();

        SeverelySteamcrackedKerosene = new Material.Builder(Supersymmetry.id("severely_steamcracked_kerosene"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf2ed83)
                .buildAndRegister();

        LightlyHydrocrackedKerosene = new Material.Builder(Supersymmetry.id("lightly_hydrocracked_kerosene"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xc4bf51)
                .buildAndRegister();

        SeverelyHydrocrackedKerosene = new Material.Builder(Supersymmetry.id("severely_hydrocracked_kerosene"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbab65f)
                .buildAndRegister();

        LightlySteamcrackedGasoline = new Material.Builder(Supersymmetry.id("lightly_steamcracked_gasoline"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xebe34d)
                .buildAndRegister();

        SeverelySteamcrackedGasoline = new Material.Builder(Supersymmetry.id("severely_steamcracked_gasoline"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf5ed62)
                .buildAndRegister();

        LightlyHydrocrackedGasoline = new Material.Builder(Supersymmetry.id("lightly_hydrocracked_gasoline"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xccc43f)
                .buildAndRegister();

        SeverelyHydrocrackedGasoline = new Material.Builder(Supersymmetry.id("severely_hydrocracked_gasoline"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbdb648)
                .buildAndRegister();

        UpgradedLubricatingOilMix = new Material.Builder(Supersymmetry.id("upgraded_lubricating_oil_mix"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0x948f43)
                .buildAndRegister();

        UpgradedFuelOilMix = new Material.Builder(Supersymmetry.id("upgraded_fuel_oil_mix"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0x918d33)
                .buildAndRegister();

        UpgradedDieselMix = new Material.Builder(Supersymmetry.id("upgraded_diesel_mix"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbab32f)
                .buildAndRegister();

        UpgradedKeroseneMix = new Material.Builder(Supersymmetry.id("upgraded_kerosene_mix"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xe3db30)
                .buildAndRegister();

        UpgradedNaphthaMix = new Material.Builder(Supersymmetry.id("upgraded_naphtha_mix"))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf0e83e)
                .buildAndRegister();

        AlkylatedNaturalGas = new Material.Builder(Supersymmetry.id("alkylated_natural_gas"))
                .gas()
                .color(0xe6e4c1)
                .buildAndRegister();

        AlkylatedRefineryGas = new Material.Builder(Supersymmetry.id("alkylated_refinery_gas"))
                .gas()
                .color(0xf7f5cb)
                .buildAndRegister();

        Syngas = new Material.Builder(Supersymmetry.id("syngas"))
                .gas()
                .color(0xf2ecdc)
                .flags(FLAMMABLE)
                .buildAndRegister()
                .setFormula("(H)6(CO)", true);

        ReformedSyngas = new Material.Builder(Supersymmetry.id("reformed_syngas"))
                .gas(new FluidBuilder().temperature(800))
                .color(0xfcf3d9)
                .buildAndRegister();

        SulfuricRefineryGas = new Material.Builder(Supersymmetry.id("sulfuric_refinery_gas"))
                .gas()
                .color(0xe3e3d8)
                .buildAndRegister();

        TreatedSulfuricNaphtha = new Material.Builder(Supersymmetry.id("treated_sulfuric_naphtha"))
                .gas()
                .color(0xcec929)
                .buildAndRegister();

        LightOilyBrine = new Material.Builder(Supersymmetry.id("light_oily_brine"))
                .liquid()
                .color(0x7d7c61)
                .buildAndRegister();

        HeavyOilyBrine = new Material.Builder(Supersymmetry.id("heavy_oily_brine"))
                .liquid()
                .color(0x4f4e37)
                .buildAndRegister();

        LightBitumenSolution = new Material.Builder(Supersymmetry.id("light_bitumen_solution"))
                .liquid()
                .color(0x1e2021)
                .buildAndRegister();

        BitumenSolution = new Material.Builder(Supersymmetry.id("bitumen_solution"))
                .liquid()
                .color(0x1e2021)
                .buildAndRegister();

        HeavyBitumenSolution = new Material.Builder(Supersymmetry.id("heavy_bitumen_solution"))
                .liquid()
                .color(0x1e2021)
                .buildAndRegister();

        CrudeLubricatingOil = new Material.Builder(Supersymmetry.id("crude_lubricating_oil"))
                .liquid()
                .color(0x80743c)
                .buildAndRegister();

        SolventLubricantMixture = new Material.Builder(Supersymmetry.id("solvent_lubricant_mixture"))
                .liquid()
                .color(0x6e803c)
                .buildAndRegister();

        ColdSolventLubricantMixture = new Material.Builder(Supersymmetry.id("cold_solvent_lubricant_mixture"))
                .liquid(new FluidBuilder().temperature(273))
                .color(0x5e8064)
                .buildAndRegister();

        DewaxedLubricantMixture = new Material.Builder(Supersymmetry.id("dewaxed_lubricant_mixture"))
                .liquid()
                .color(0x7d782e)
                .buildAndRegister();

        SulfuricLubricatingOil = new Material.Builder(Supersymmetry.id("sulfuric_lubricating_oil"))
                .liquid()
                .color(0x7d782e)
                .buildAndRegister();

        CFiveFraction = new Material.Builder(Supersymmetry.id("c_five_fraction"))
                .liquid()
                .color(0x9c8638)
                .buildAndRegister();

        DimerizedCFiveFraction = new Material.Builder(Supersymmetry.id("dimerized_c_five_fraction"))
                .liquid()
                .color(0x9c9538)
                .buildAndRegister();
    }
}
