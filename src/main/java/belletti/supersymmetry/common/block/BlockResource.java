package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.IStateHarvestLevel;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class BlockResource extends ActiveBlock {
    public BlockResource(Properties properties, IStateHarvestLevel resourceBlock) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", resourceBlock.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", resourceBlock.getTexture()))
                        : null);
    }

    public enum ResourceBlockType implements StringRepresentable, IStateHarvestLevel {
        BAUXITE("bauxite", 1),
        CALICHE("caliche", 1),
        NON_MARINE_EVAPORITE("non_marine_evaporite", 1),
        HALIDE_EVAPORITE("halide_evaporite", 1),
        SULFATE_EVAPORITE("sulfate_evaporite", 1),
        CARBONATE_EVAPORITE("carbonate_evaporite", 1),
        MONAZITE_ALLUVIAL("monazite_alluvial", 1),
        BASTNASITE_ALLUVIAL("bastnasite_alluvial", 1),
        EUXENITE_ALLUVIAL("euxenite_alluvial", 1),
        XENOTIME_ALLUVIAL("xenotime_alluvial", 1),
        PLATINUM_PLACER("platinum_placer", 1),
        GOLD_ALLUVIAL("gold_alluvial", 1),
        PHOSPHORITE("phosphorite", 1),
        POTASH("potash", 1),
        SULFUR("sulfur", 1);

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final int harvestLevel;
        @Getter
        private final ResourceLocation texture;

        ResourceBlockType(@NotNull String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
            this.texture = Supersymmetry.id("block/resource_block/" + name);
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
