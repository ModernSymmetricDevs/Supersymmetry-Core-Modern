package belletti.supersymmetry.common.data;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.BlockCoolingCoil;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import static belletti.supersymmetry.api.registries.SuSyRegistries.REGISTRATE;

public class SuSyCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> SUSY = REGISTRATE.defaultCreativeTab(Supersymmetry.MOD_ID,
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(Supersymmetry.MOD_ID, REGISTRATE))
                            .title(Component.literal("Super Symmetry"))
                            .build())
            .register();

    public static void init() {

    }

}
