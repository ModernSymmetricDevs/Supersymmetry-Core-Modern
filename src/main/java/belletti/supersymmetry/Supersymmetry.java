package belletti.supersymmetry;

import belletti.supersymmetry.api.registries.SuSyRegistries;
import belletti.supersymmetry.common.data.*;
import belletti.supersymmetry.common.materials.SuSyMaterials;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Supersymmetry.MOD_ID)
public class Supersymmetry {
	public static final String
			NAME = "Supersymmetry",
			MOD_ID = "susy";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	public static MaterialRegistry MATERIAL_REGISTRY;

	public Supersymmetry() {
		Supersymmetry.init();
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.register(this);

		bus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
		bus.addGenericListener(MachineDefinition.class, this::registerMachines);
	}

	public static void init() {
		SuSyCreativeModeTabs.init();
		SuSyBlocks.init();

		SuSyDatagen.init();

		SuSyRegistries.REGISTRATE.registerRegistrate();
	}

	public static ResourceLocation id(String path) { return new ResourceLocation(MOD_ID, path); }

	@SubscribeEvent
	public void registerMaterialRegistry(MaterialRegistryEvent event) {
		MATERIAL_REGISTRY = GTCEuAPI.materialManager.createRegistry(Supersymmetry.MOD_ID);
	}

	@SubscribeEvent
	public void registerMaterials(MaterialEvent event) {
		SuSyMaterials.init();
	}

	@SubscribeEvent
	public void modifyMaterials(PostMaterialEvent event) {
		SuSyMaterials.changeProperties();
	}

	@SubscribeEvent
	public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
		SuSyRecipeTypes.init();
	}

	@SubscribeEvent
	public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
		SuSyMachines.init();
	}
}
