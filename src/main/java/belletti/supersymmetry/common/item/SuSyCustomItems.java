package belletti.supersymmetry.common.item;

import belletti.supersymmetry.Supersymmetry;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ElectricStats;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.world.item.Item;

import static belletti.supersymmetry.api.registries.SuSyRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.common.data.GTItems.attach;
import static com.gregtechceu.gtceu.common.data.GTItems.modelPredicate;
import static com.gregtechceu.gtceu.common.data.GTModels.overrideModel;

// equivalent of RegisterMetaItems.groovy
public class SuSyCustomItems {
    public static void init() {
        REGISTRATE.item("rock.orthomagmatic", Item::new)
                .lang("Rock Orthomagmatic")
                .register();

        REGISTRATE.item("rock.metamorphic", Item::new)
                .lang("Rock Metamorphic")
                .register();

        REGISTRATE.item("rock.magmatic_hydrothermal", Item::new)
                .lang("Rock Magmatic Hydrothermal")
                .register();

        REGISTRATE.item("rock.sedimentary", Item::new)
                .lang("Rock Sedimentary")
                .register();

        REGISTRATE.item("rock.hydrothermal", Item::new)
                .lang("Rock Hydrothermal")
                .register();

        REGISTRATE.item("rock.alluvial", Item::new)
                .lang("Rock Alluvial")
                .register();

        REGISTRATE.item("cement.clinker", Item::new)
                .lang("Cement Clinker")
                .register();

        REGISTRATE.item("hot.cement.clinker", Item::new)
                .lang("Hot Cement Clinker")
                .register();

        REGISTRATE.item("cement.dust", Item::new)
                .lang("Cement Dust")
                .register();

        REGISTRATE.item("shape.mold.rod", Item::new)
                .lang("Shape Mold Rod")
                .register();

        REGISTRATE.item("shape.mold.crucible", Item::new)
                .lang("Shape Mold Crucible")
                .register();

        REGISTRATE.item("crucible.boron.nitride", Item::new)
                .lang("Crucible Boron Nitride")
                .register();

        REGISTRATE.item("crucible.quartz", Item::new)
                .lang("Crucible Quartz")
                .register();

        REGISTRATE.item("crucible.graphite", Item::new)
                .lang("Crucible Graphite")
                .register();

        REGISTRATE.item("shape.mold.long_rod", Item::new)
                .lang("Shape Mold Long Rod")
                .register();

        REGISTRATE.item("shape.mold.ring", Item::new)
                .lang("Shape Mold Ring")
                .register();

        REGISTRATE.item("mudbrick_mix", Item::new)
                .lang("Mudbrick Mix")
                .register();

        REGISTRATE.item("slaked_lime", Item::new)
                .lang("Slaked Lime")
                .register();

        REGISTRATE.item("sand.dust", Item::new)
                .lang("Sand Dust")
                .register();

        REGISTRATE.item("straw", Item::new)
                .lang("Straw")
                .register();

        REGISTRATE.item("washed_rotten_flesh", Item::new)
                .lang("Washed Rotten Flesh")
                .register();

        REGISTRATE.item("sugar_cane_dust", Item::new)
                .lang("Sugar Cane Dust")
                .register();

        REGISTRATE.item("bitumen", Item::new)
                .lang("Bitumen")
                .register();

        REGISTRATE.item("bituminous_residue", Item::new)
                .lang("Bituminous Residue")
                .register();

        REGISTRATE.item("paraffin_wax", Item::new)
                .lang("Paraffin Wax")
                .register();

        REGISTRATE.item("spent_cracking_catalyst", Item::new)
                .lang("Spent Cracking Catalyst")
                .register();

        REGISTRATE.item("red_mud_slag", Item::new)
                .lang("Red Mud Slag")
                .register();

        REGISTRATE.item("leached_red_mud_slag", Item::new)
                .lang("Leached Red Mud Slag")
                .register();

        REGISTRATE.item("pitch_binder", Item::new)
                .lang("Pitch Binder")
                .register();

        REGISTRATE.item("raw_electrode", Item::new)
                .lang("Raw Electrode")
                .register();

        REGISTRATE.item("graphite_electrode", Item::new)
                .lang("Graphite Electrode")
                .register();

        REGISTRATE.item("rydberg_atom_array", Item::new)
                .lang("Rydberg Atom Array")
                .register();

        REGISTRATE.item("malted_grain", Item::new)
                .lang("Malted Grain")
                .register();

        REGISTRATE.item("mineral_wool", Item::new)
                .lang("Mineral Wool")
                .register();

        REGISTRATE.item("hepa_filter", Item::new)
                .lang("HEPA Filter")
                .register();

        REGISTRATE.item("cracking_catalyst", Item::new)
                .lang("Cracking Catalyst")
                .register();

        REGISTRATE.item("raw_diamond", Item::new)
                .lang("Raw Diamond")
                .register();

        REGISTRATE.item("cellulose_acetate_mesh", Item::new)
                .lang("Cellulose Acetate Mesh")
                .register();

        REGISTRATE.item("zeolite_membrane_support", Item::new)
                .lang("Zeolite Membrane Support")
                .register();

        REGISTRATE.item("zeolite_membrane", Item::new)
                .lang("Zeolite Membrane")
                .register();

        REGISTRATE.item("patterned_thick_film_substrate_wafer", Item::new)
                .lang("Patterned Thick Film Substrate Wafer")
                .register();

        REGISTRATE.item("thick_film_resistor_wafer", Item::new)
                .lang("Thick Film Resistor Wafer")
                .register();

        REGISTRATE.item("metallized_plastic_film", Item::new)
                .lang("Metallized Plastic Film")
                .register();

        REGISTRATE.item("metallized_plastic_square", Item::new)
                .lang("Metallized Plastic Square")
                .register();

        REGISTRATE.item("raw_smd_capacitor", Item::new)
                .lang("Raw SMD Capacitor")
                .register();

        REGISTRATE.item("raw_capacitor_roll", Item::new)
                .lang("Raw Capacitor Roll")
                .register();

        REGISTRATE.item("aluminium_electrolytic_capacitor", Item::new)
                .lang("Aluminium Electrolytic Capacitor")
                .register();

        REGISTRATE.item("tantalum_chip", Item::new)
                .lang("Tantalum Chip")
                .register();

        REGISTRATE.item("anodized_tantalum_chip", Item::new)
                .lang("Anodized Tantalum Chip")
                .register();

        REGISTRATE.item("manganized_tantalum_chip", Item::new)
                .lang("Manganized Tantalum Chip")
                .register();

        REGISTRATE.item("ferroelectric_ceramic_foil", Item::new)
                .lang("Ferroelectric Ceramic Foil")
                .register();

        REGISTRATE.item("stacked_ceramic_capacitor", Item::new)
                .lang("Stacked Ceramic Capacitor")
                .register();

        REGISTRATE.item("raw_ceramic_capacitor", Item::new)
                .lang("Raw Ceramic Capacitor")
                .register();

        REGISTRATE.item("chip.insulated_silicon", Item::new)
                .lang("Chip Insulated Silicon")
                .register();

        REGISTRATE.item("chip.insulated_silicon_germanium", Item::new)
                .lang("Chip Insulated Silicon Germanium")
                .register();

        REGISTRATE.item("chip.n_doped_silicon", Item::new)
                .lang("Chip N-Doped Silicon")
                .register();

        REGISTRATE.item("chip.silicon_dioxide", Item::new)
                .lang("Chip Silicon Dioxide")
                .register();

        REGISTRATE.item("fused_quartz", Item::new)
                .lang("Fused Quartz")
                .register();

        REGISTRATE.item("thick_film_substrate_wafer", Item::new)
                .lang("Thick Film Substrate Wafer")
                .register();

        REGISTRATE.item("vti_rich_pig_iron", Item::new)
                .lang("VTI Rich Pig Iron")
                .register();

        REGISTRATE.item("vt_slag", Item::new)
                .lang("VT Slag")
                .register();

        REGISTRATE.item("bound_leather", Item::new)
                .lang("Bound Leather")
                .register();

        REGISTRATE.item("glass_fibers", Item::new)
                .lang("Glass Fibers")
                .register();

        REGISTRATE.item("epoxy_lamina", Item::new)
                .lang("Epoxy Lamina")
                .register();

        REGISTRATE.item("beads.amberlyst_ch", Item::new)
                .lang("Beads Amberlyst CH")
                .register();

        REGISTRATE.item("beads.ag_fifty_w_x_eight", Item::new)
                .lang("Beads AG Fifty W X Eight")
                .register();

        REGISTRATE.item("beads.rhenium_ion_exchange", Item::new)
                .lang("Beads Rhenium Ion Exchange")
                .register();

        REGISTRATE.item("beads.loaded_rhenium_ion_exchange", Item::new)
                .lang("Beads Loaded Rhenium Ion Exchange")
                .register();

        REGISTRATE.item("mylar", Item::new)
                .lang("Mylar")
                .register();

        REGISTRATE.item("spinneret", Item::new)
                .lang("Spinneret")
                .register();

        REGISTRATE.item("chunk.magnetite", Item::new)
                .lang("Chunk Magnetite")
                .register();

        REGISTRATE.item("hot_iron_rod", Item::new)
                .lang("Hot Iron Rod")
                .register();

        REGISTRATE.item("voltaic_pile", Item::new)
                .lang("Voltaic Pile")
                .properties(p -> p.stacksTo(1))
                .register();

        REGISTRATE.item("electrolyte_paper", Item::new)
                .lang("Electrolyte Paper")
                .register();

        REGISTRATE.item("steam.piston", Item::new)
                .lang("Steam Piston")
                .register();

        REGISTRATE.item("steam.motor", Item::new)
                .lang("Steam Motor")
                .register();

//        REGISTRATE.item("spaceship.me.scrap", Item::new)
//                .lang("Spaceship ME Scrap")
//                .register();

        REGISTRATE.item("wafer.pattern.processor", Item::new)
                .lang("Wafer Pattern Processor")
                .register();

        REGISTRATE.item("wafer.pattern.memory", Item::new)
                .lang("Wafer Pattern Memory")
                .register();

        REGISTRATE.item("plate.pattern.processor", Item::new)
                .lang("Plate Pattern Processor")
                .register();

        REGISTRATE.item("plate.pattern.memory", Item::new)
                .lang("Plate Pattern Memory")
                .register();

        REGISTRATE.item("pattern.processor", Item::new)
                .lang("Pattern Processor")
                .register();

        REGISTRATE.item("pattern.memory", Item::new)
                .lang("Pattern Memory")
                .register();

        REGISTRATE.item("storage.segment", Item::new)
                .lang("Storage Segment")
                .register();

        REGISTRATE.item("gun.barrel.steel", Item::new)
                .lang("Gun Barrel Steel")
                .register();

        REGISTRATE.item("circuit.gooware_processor", Item::new)
                .lang("Circuit Gooware Processor")
                .register();

        REGISTRATE.item("circuit.gooware_assembly", Item::new)
                .lang("Circuit Gooware Assembly")
                .register();

        REGISTRATE.item("circuit.gooware_computer", Item::new)
                .lang("Circuit Gooware Computer")
                .register();

        REGISTRATE.item("circuit.gooware_mainframe", Item::new)
                .lang("Circuit Gooware Mainframe")
                .register();

        REGISTRATE.item("circuit.optical_processor", Item::new)
                .lang("Circuit Optical Processor")
                .register();

        REGISTRATE.item("circuit.optical_assembly", Item::new)
                .lang("Circuit Optical Assembly")
                .register();

        REGISTRATE.item("circuit.optical_computer", Item::new)
                .lang("Circuit Optical Computer")
                .register();

        REGISTRATE.item("circuit.optical_mainframe", Item::new)
                .lang("Circuit Optical Mainframe")
                .register();

        REGISTRATE.item("circuit.spintronic_processor", Item::new)
                .lang("Circuit Spintronic Processor")
                .register();

        REGISTRATE.item("circuit.spintronic_assembly", Item::new)
                .lang("Circuit Spintronic Assembly")
                .register();

        REGISTRATE.item("circuit.spintronic_computer", Item::new)
                .lang("Circuit Spintronic Computer")
                .register();

        REGISTRATE.item("circuit.spintronic_mainframe", Item::new)
                .lang("Circuit Spintronic Mainframe")
                .register();

        REGISTRATE.item("circuit.cosmic_processor", Item::new)
                .lang("Circuit Cosmic Processor")
                .register();

        REGISTRATE.item("circuit.cosmic_assembly", Item::new)
                .lang("Circuit Cosmic Assembly")
                .register();

        REGISTRATE.item("circuit.cosmic_computer", Item::new)
                .lang("Circuit Cosmic Computer")
                .register();

        REGISTRATE.item("circuit.cosmic_mainframe", Item::new)
                .lang("Circuit Cosmic Mainframe")
                .register();

        REGISTRATE.item("circuit.supracausal_processor", Item::new)
                .lang("Circuit Supracausal Processor")
                .register();

        REGISTRATE.item("circuit.supracausal_assembly", Item::new)
                .lang("Circuit Supracausal Assembly")
                .register();

        REGISTRATE.item("circuit.supracausal_computer", Item::new)
                .lang("Circuit Supracausal Computer")
                .register();

        REGISTRATE.item("circuit.supracausal_mainframe", Item::new)
                .lang("Circuit Supracausal Mainframe")
                .register();

        REGISTRATE.item("circuit.suprachronal.ulv", Item::new)
                .lang("Circuit Suprachronal ULV")
                .register();

        REGISTRATE.item("circuit.suprachronal.lv", Item::new)
                .lang("Circuit Suprachronal LV")
                .register();

        REGISTRATE.item("circuit.suprachronal.mv", Item::new)
                .lang("Circuit Suprachronal MV")
                .register();

        REGISTRATE.item("circuit.suprachronal.hv", Item::new)
                .lang("Circuit Suprachronal HV")
                .register();

        REGISTRATE.item("circuit.suprachronal.ev", Item::new)
                .lang("Circuit Suprachronal EV")
                .register();

        REGISTRATE.item("circuit.suprachronal.iv", Item::new)
                .lang("Circuit Suprachronal IV")
                .register();

        REGISTRATE.item("circuit.suprachronal.luv", Item::new)
                .lang("Circuit Suprachronal LUV")
                .register();

        REGISTRATE.item("circuit.suprachronal.zpm", Item::new)
                .lang("Circuit Suprachronal ZPM")
                .register();

        REGISTRATE.item("circuit.suprachronal.uv", Item::new)
                .lang("Circuit Suprachronal UV")
                .register();

        REGISTRATE.item("circuit.suprachronal.uhv", Item::new)
                .lang("Circuit Suprachronal UHV")
                .register();

        REGISTRATE.item("circuit.suprachronal.uev", Item::new)
                .lang("Circuit Suprachronal UEV")
                .register();

        REGISTRATE.item("circuit.suprachronal.uiv", Item::new)
                .lang("Circuit Suprachronal UIV")
                .register();

        REGISTRATE.item("circuit.suprachronal.uxv", Item::new)
                .lang("Circuit Suprachronal UXV")
                .register();

        REGISTRATE.item("circuit.suprachronal.opv", Item::new)
                .lang("Circuit Suprachronal OPV")
                .register();

        REGISTRATE.item("circuit.suprachronal.max", Item::new)
                .lang("Circuit Suprachronal MAX")
                .register();

//        REGISTRATE.item("wafer.advanced_random_access_memory", Item::new)
//                .lang("Wafer Advanced Random Access Memory")
//                .register();

//        REGISTRATE.item("plate.advanced_random_access_memory", Item::new)
//                .lang("Plate Advanced Random Access Memory")
//                .register();

        REGISTRATE.item("copra", Item::new)
                .lang("Copra")
                .register();

        REGISTRATE.item("battery.lead_acid", ComponentItem::create)
                .lang("Battery Lead Acid")
                .properties(p -> p.stacksTo(1))
                .model(overrideModel(Supersymmetry.id("battery"), 8))
                .onRegister(modelPredicate(Supersymmetry.id("battery"), ElectricStats::getStoredPredicate))
                .onRegister(attach(ElectricStats.createRechargeableBattery(120000, GTValues.ULV)))
                .tag(CustomTags.ULV_BATTERIES)
                .register();

        REGISTRATE.item("cathode.lead", Item::new)
                .lang("Cathode Lead")
                .register();

        REGISTRATE.item("anode.lead", Item::new)
                .lang("Anode Lead")
                .register();

        REGISTRATE.item("vacuum_tube_components", Item::new)
                .lang("Vacuum Tube Components")
                .register();

        REGISTRATE.item("rubylith", Item::new)
                .lang("Rubylith")
                .register();

        REGISTRATE.item("rubylith_film", Item::new)
                .lang("Rubylith Film")
                .register();

        REGISTRATE.item("stencil.ic", Item::new)
                .lang("Stencil IC")
                .register();

        REGISTRATE.item("stencil.cpu", Item::new)
                .lang("Stencil CPU")
                .register();

        REGISTRATE.item("stencil.ram", Item::new)
                .lang("Stencil RAM")
                .register();

        REGISTRATE.item("stencil.pcb", Item::new)
                .lang("Stencil PCB")
                .register();

        REGISTRATE.item("stencil.ulpic", Item::new)
                .lang("Stencil UL-PIC")
                .register();

        REGISTRATE.item("stencil.lpic", Item::new)
                .lang("Stencil L-PIC")
                .register();

        REGISTRATE.item("mask.blank", Item::new)
                .lang("Mask Blank")
                .register();

        REGISTRATE.item("mask.ic", Item::new)
                .lang("Mask IC")
                .register();

        REGISTRATE.item("mask.cpu", Item::new)
                .lang("Mask CPU")
                .register();

        REGISTRATE.item("mask.ram", Item::new)
                .lang("Mask RAM")
                .register();

        REGISTRATE.item("mask.pcb", Item::new)
                .lang("Mask PCB")
                .register();

        REGISTRATE.item("mask.ulpic", Item::new)
                .lang("Mask UL-PIC")
                .register();

        REGISTRATE.item("mask.lpic", Item::new)
                .lang("Mask L-PIC")
                .register();

        REGISTRATE.item("mask.nand", Item::new)
                .lang("Mask NAND")
                .register();

        REGISTRATE.item("mask.nor", Item::new)
                .lang("Mask NOR")
                .register();

        REGISTRATE.item("mask.advanced", Item::new)
                .lang("Mask Advanced")
                .register();

        REGISTRATE.item("patterned.ic", Item::new)
                .lang("Patterned IC")
                .register();

        REGISTRATE.item("patterned.cpu", Item::new)
                .lang("Patterned CPU")
                .register();

        REGISTRATE.item("patterned.ram", Item::new)
                .lang("Patterned RAM")
                .register();

        REGISTRATE.item("patterned.ulpic", Item::new)
                .lang("Patterned UL-PIC")
                .register();

        REGISTRATE.item("patterned.lpic", Item::new)
                .lang("Patterned L-PIC")
                .register();

        REGISTRATE.item("patterned.silicon_dioxide", Item::new)
                .lang("Patterned Silicon Dioxide")
                .register();

        REGISTRATE.item("patterned.polysilicon", Item::new)
                .lang("Patterned Polysilicon")
                .register();

        REGISTRATE.item("patterned.silicon_nitride", Item::new)
                .lang("Patterned Silicon Nitride")
                .register();

        REGISTRATE.item("patterned.nand", Item::new)
                .lang("Patterned NAND")
                .register();

        REGISTRATE.item("patterned.nor", Item::new)
                .lang("Patterned NOR")
                .register();

        REGISTRATE.item("patterned.board.phenolic", Item::new)
                .lang("Patterned Board Phenolic")
                .register();

        REGISTRATE.item("patterned.board.plastic", Item::new)
                .lang("Patterned Board Plastic")
                .register();

        REGISTRATE.item("laminated.board.phenolic", Item::new)
                .lang("Laminated Board Phenolic")
                .register();

        REGISTRATE.item("etched.ic", Item::new)
                .lang("Etched IC")
                .register();

        REGISTRATE.item("etched.cpu", Item::new)
                .lang("Etched CPU")
                .register();

        REGISTRATE.item("etched.ram", Item::new)
                .lang("Etched RAM")
                .register();

        REGISTRATE.item("etched.ulpic", Item::new)
                .lang("Etched UL-PIC")
                .register();

        REGISTRATE.item("etched.lpic", Item::new)
                .lang("Etched L-PIC")
                .register();

        REGISTRATE.item("etched.silicon_dioxide", Item::new)
                .lang("Etched Silicon Dioxide")
                .register();

        REGISTRATE.item("etched.polysilicon", Item::new)
                .lang("Etched Polysilicon")
                .register();

        REGISTRATE.item("etched.silicon_nitride", Item::new)
                .lang("Etched Silicon Nitride")
                .register();

        REGISTRATE.item("carbon_arc_lamp", Item::new)
                .lang("Carbon Arc Lamp")
                .register();

        REGISTRATE.item("incandescent_light", Item::new)
                .lang("Incandescent Light")
                .register();

        REGISTRATE.item("halogen_light", Item::new)
                .lang("Halogen Light")
                .register();

        REGISTRATE.item("fluorescent_light", Item::new)
                .lang("Fluorescent Light")
                .register();

        REGISTRATE.item("led_light", Item::new)
                .lang("LED Light")
                .register();

        REGISTRATE.item("assemblymanganesephosphide", Item::new)
                .lang("Assembly Manganese Phosphide")
                .register();

        REGISTRATE.item("basemanganesephosphide", Item::new)
                .lang("Base Manganese Phosphide")
                .register();

        REGISTRATE.item("cannedmagnesiumdiboride", Item::new)
                .lang("Canned Magnesium Diboride")
                .register();

        REGISTRATE.item("tubemagnesiumdiboride", Item::new)
                .lang("Tube Magnesium Diboride")
                .register();

        REGISTRATE.item("basemagnesiumdiboride", Item::new)
                .lang("Base Magnesium Diboride")
                .register();

        REGISTRATE.item("cannedmercurybariumcalciumcuprate", Item::new)
                .lang("Canned Mercury Barium Calcium Cuprate")
                .register();

        REGISTRATE.item("tubemercurybariumcalciumcuprate", Item::new)
                .lang("Tube Mercury Barium Calcium Cuprate")
                .register();

        REGISTRATE.item("basemercurybariumcalciumcuprate", Item::new)
                .lang("Base Mercury Barium Calcium Cuprate")
                .register();

        REGISTRATE.item("assemblyuraniumtriplatinum", Item::new)
                .lang("Assembly Uranium Triplatinum")
                .register();

        REGISTRATE.item("baseuraniumtriplatinum", Item::new)
                .lang("Base Uranium Triplatinum")
                .register();

        REGISTRATE.item("cannedsamariumironarsenicoxide", Item::new)
                .lang("Canned Samarium Iron Arsenic Oxide")
                .register();

        REGISTRATE.item("tubesamariumironarsenicoxide", Item::new)
                .lang("Tube Samarium Iron Arsenic Oxide")
                .register();

        REGISTRATE.item("basesamariumironarsenicoxide", Item::new)
                .lang("Base Samarium Iron Arsenic Oxide")
                .register();

        REGISTRATE.item("assemblyindiumtinbariumtitaniumcuprate", Item::new)
                .lang("Assembly Indium Tin Barium Titanium Cuprate")
                .register();

        REGISTRATE.item("baseindiumtinbariumtitaniumcuprate", Item::new)
                .lang("Base Indium Tin Barium Titanium Cuprate")
                .register();

        REGISTRATE.item("assemblyuraniumrhodiumdinaquadide", Item::new)
                .lang("Assembly Uranium Rhodium Dinaquadide")
                .register();

        REGISTRATE.item("baseuraniumrhodiumdinaquadide", Item::new)
                .lang("Base Uranium Rhodium Dinaquadide")
                .register();

        REGISTRATE.item("assemblyenrichednaquadahtriniumeuropiumduranide", Item::new)
                .lang("Assembly Enriched Naquadah Trinium Europium Duranide")
                .register();

        REGISTRATE.item("baseenrichednaquadahtriniumeuropiumduranide", Item::new)
                .lang("Base Enriched Naquadah Trinium Europium Duranide")
                .register();

        REGISTRATE.item("assemblyrutheniumtriniumamericiumneutronate", Item::new)
                .lang("Assembly Ruthenium Trinium Americium Neutronate")
                .register();

        REGISTRATE.item("baserutheniumtriniumamericiumneutronate", Item::new)
                .lang("Base Ruthenium Trinium Americium Neutronate")
                .register();

        REGISTRATE.item("sponge.titanium", Item::new)
                .lang("Sponge Titanium")
                .register();

        REGISTRATE.item("sponge.titanium.crude", Item::new)
                .lang("Sponge Titanium Crude")
                .register();

        REGISTRATE.item("sponge.zirconium", Item::new)
                .lang("Sponge Zirconium")
                .register();

        REGISTRATE.item("sponge.zirconium.crude", Item::new)
                .lang("Sponge Zirconium Crude")
                .register();

        REGISTRATE.item("sponge.hafnium", Item::new)
                .lang("Sponge Hafnium")
                .register();

        REGISTRATE.item("sponge.hafnium.crude", Item::new)
                .lang("Sponge Hafnium Crude")
                .register();

        REGISTRATE.item("sponge.platinum", Item::new)
                .lang("Sponge Platinum")
                .register();

        REGISTRATE.item("sponge.cadmium", Item::new)
                .lang("Sponge Cadmium")
                .register();

        REGISTRATE.item("sponge.indium", Item::new)
                .lang("Sponge Indium")
                .register();

        REGISTRATE.item("anode_slime.gold", Item::new)
                .lang("Anode Slime Gold")
                .register();

        REGISTRATE.item("anode_slime.silver", Item::new)
                .lang("Anode Slime Silver")
                .register();

        REGISTRATE.item("anode_slime.lead", Item::new)
                .lang("Anode Slime Lead")
                .register();

        REGISTRATE.item("anode_slime.copper", Item::new)
                .lang("Anode Slime Copper")
                .register();

        REGISTRATE.item("anode_slime.decopperized", Item::new)
                .lang("Anode Slime Decopperized")
                .register();

        REGISTRATE.item("seed_crystal.silicon", Item::new)
                .lang("Seed Crystal Silicon")
                .register();

        REGISTRATE.item("seed_crystal.gallium_arsenide", Item::new)
                .lang("Seed Crystal Gallium Arsenide")
                .register();

        REGISTRATE.item("seed_crystal.alumina", Item::new)
                .lang("Seed Crystal Alumina")
                .register();

        REGISTRATE.item("seed_crystal.beryllium_oxide", Item::new)
                .lang("Seed Crystal Beryllium Oxide")
                .register();

        REGISTRATE.item("seed_crystal.emerald", Item::new)
                .lang("Seed Crystal Emerald")
                .register();

        REGISTRATE.item("seed_crystal.lithium_niobate", Item::new)
                .lang("Seed Crystal Lithium Niobate")
                .register();

        REGISTRATE.item("unrefined_boule.silicon", Item::new)
                .lang("Unrefined Boule Silicon")
                .register();

        REGISTRATE.item("boule.gallium_arsenide", Item::new)
                .lang("Boule Gallium Arsenide")
                .register();

        REGISTRATE.item("unrefined_boule.gallium_arsenide", Item::new)
                .lang("Unrefined Boule Gallium Arsenide")
                .register();

        REGISTRATE.item("boule.alumina", Item::new)
                .lang("Boule Alumina")
                .register();

        REGISTRATE.item("boule.beryllium_oxide", Item::new)
                .lang("Boule Beryllium Oxide")
                .register();

        REGISTRATE.item("boule.emerald", Item::new)
                .lang("Boule Emerald")
                .register();

        REGISTRATE.item("boule.sapphire", Item::new)
                .lang("Boule Sapphire")
                .register();

        REGISTRATE.item("boule.ruby", Item::new)
                .lang("Boule Ruby")
                .register();

        REGISTRATE.item("boule.silicon_germanium", Item::new)
                .lang("Boule Silicon Germanium")
                .register();

        REGISTRATE.item("boule.lithium_niobate", Item::new)
                .lang("Boule Lithium Niobate")
                .register();

        REGISTRATE.item("wafer.doped.silicon", Item::new)
                .lang("Wafer Doped Silicon")
                .register();

        REGISTRATE.item("wafer.n_doped.silicon", Item::new)
                .lang("Wafer N-Doped Silicon")
                .register();

        REGISTRATE.item("wafer.silicon_dioxide", Item::new)
                .lang("Wafer Silicon Dioxide")
                .register();

        REGISTRATE.item("wafer.alumina", Item::new)
                .lang("Wafer Alumina")
                .register();

        REGISTRATE.item("wafer.beryllium_oxide", Item::new)
                .lang("Wafer Beryllium Oxide")
                .register();

        REGISTRATE.item("wafer.silicon_germanium", Item::new)
                .lang("Wafer Silicon Germanium")
                .register();

        REGISTRATE.item("wafer.insulated_silicon", Item::new)
                .lang("Wafer Insulated Silicon")
                .register();

        REGISTRATE.item("wafer.insulated_silicon_germanium", Item::new)
                .lang("Wafer Insulated Silicon Germanium")
                .register();

        REGISTRATE.item("wafer.doped.silicon_dioxide", Item::new)
                .lang("Wafer Doped Silicon Dioxide")
                .register();

        REGISTRATE.item("wafer.polysilicon", Item::new)
                .lang("Wafer Polysilicon")
                .register();

        REGISTRATE.item("wafer.doped.polysilicon", Item::new)
                .lang("Wafer Doped Polysilicon")
                .register();

        REGISTRATE.item("wafer.silicon_nitride", Item::new)
                .lang("Wafer Silicon Nitride")
                .register();

        REGISTRATE.item("wafer.nickel", Item::new)
                .lang("Wafer Nickel")
                .register();

        REGISTRATE.item("wafer.gallium_arsenide", Item::new)
                .lang("Wafer Gallium Arsenide")
                .register();

        REGISTRATE.item("wafer.raw.silicon", Item::new)
                .lang("Wafer Raw Silicon")
                .register();

        REGISTRATE.item("wafer.treated.silicon", Item::new)
                .lang("Wafer Treated Silicon")
                .register();

        REGISTRATE.item("seed.cotton", Item::new)
                .lang("Seed Cotton")
                .register();

        REGISTRATE.item("crop.cotton", Item::new)
                .lang("Crop Cotton")
                .register();

        REGISTRATE.item("stem.cotton", Item::new)
                .lang("Stem Cotton")
                .register();
    }
}
