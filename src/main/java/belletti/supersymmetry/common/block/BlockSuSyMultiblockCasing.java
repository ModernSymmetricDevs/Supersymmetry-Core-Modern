package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.IResourceable;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class BlockSuSyMultiblockCasing extends ActiveBlock {
    public BlockSuSyMultiblockCasing(Properties properties, IResourceable multiblockCasingType) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", multiblockCasingType.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", multiblockCasingType.getTexture()))
                        : null);
    }

    public enum CasingType implements StringRepresentable, IResourceable {
        SILICON_CARBIDE_CASING("silicon_carbide_casing"),
        SIEVE_TRAY("sieve_tray"),
        STRUCTURAL_PACKING("structural_packing"),
        ULV_STRUCTURAL_CASING("ulv_structural_casing"),
        DRONE_PAD("drone_pad");

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final ResourceLocation texture;

        CasingType(@NotNull String name) {
            this.name = name;
            this.texture = Supersymmetry.id("block/multiblock_casing/" + name);
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
