package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.IResourceable;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class BlockSerpentine extends ActiveBlock {
    public BlockSerpentine(Properties properties, IResourceable serpentineType) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", serpentineType.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        GTCEu.id("block/cube_2_layer_all"), Map.of("bot_all", serpentineType.getTexture(),
                        "top_all", new ResourceLocation(serpentineType.getTexture() + "_bloom")))
                        : null);
    }

    public enum SerpentineType implements StringRepresentable, IResourceable {
        BASIC("basic");

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final ResourceLocation texture;

        SerpentineType(@NotNull String name) {
            this.name = name;
            this.texture = Supersymmetry.id("block/casings/serpentine/serpentine");
        }

        @NotNull
        @Override
        public String getSerializedName() {
            return this.name;
        }

        @NotNull
        @Override
        public String toString() {
            return this.getName();
        }
    }
}
