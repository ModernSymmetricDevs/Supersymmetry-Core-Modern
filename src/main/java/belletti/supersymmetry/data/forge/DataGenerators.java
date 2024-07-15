package belletti.supersymmetry.data.forge;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.data.SuSyBiomes;
import belletti.supersymmetry.common.item.armor.trim.SuSyTrimMaterials;
import belletti.supersymmetry.common.item.armor.trim.SuSyTrimPatterns;
import com.gregtechceu.gtceu.api.registry.registrate.SoundEntryBuilder;
import com.gregtechceu.gtceu.data.tags.BiomeTagsLoader;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;

@Mod.EventBusSubscriber(modid = Supersymmetry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();
        var provider = event.getLookupProvider();
        if (event.includeServer()) {
            var set = Set.of(Supersymmetry.MOD_ID);
            generator.addProvider(true, new BiomeTagsLoader(output, provider, existingFileHelper));
            generator.addProvider(true, new SoundEntryBuilder.SoundEntryProvider(output, Supersymmetry.MOD_ID));
            generator.addProvider(true, new DatapackBuiltinEntriesProvider(
                    output, provider, new RegistrySetBuilder()
                    .add(Registries.BIOME, SuSyBiomes::bootstrap)
                    .add(Registries.TRIM_PATTERN, SuSyTrimPatterns::bootstrap)
                    .add(Registries.TRIM_MATERIAL, SuSyTrimMaterials::bootstrap),
                    set));
        }
    }
}