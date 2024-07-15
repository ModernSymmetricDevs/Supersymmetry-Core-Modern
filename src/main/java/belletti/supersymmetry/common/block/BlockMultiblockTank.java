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

public class BlockMultiblockTank extends ActiveBlock {
    public BlockMultiblockTank(Properties properties, IStateHarvestLevel resourceBlock) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", resourceBlock.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", resourceBlock.getTexture().withSuffix("_on")))
                        : null);
    }

    public enum MultiblockTankType implements StringRepresentable, IStateHarvestLevel {
        CLARIFIER("clarifier", 1),
        FLOTATION("flotation", 1);

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final int harvestLevel;
        @Getter
        private final ResourceLocation texture;

        MultiblockTankType(@NotNull String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
            this.texture = Supersymmetry.id("block/casings/multiblock_tank/" + name);
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
