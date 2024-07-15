package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.IStateHarvestLevel;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class BlockEvaporationBed extends ActiveBlock {
    public BlockEvaporationBed(Properties properties, IStateHarvestLevel evaporationBedType) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", evaporationBedType.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        GTCEu.id("block/cube_2_layer_all"), Map.of("bot_all", evaporationBedType.getTexture(),
                        "top_all", new ResourceLocation(evaporationBedType.getTexture() + "_on")))
                        :  null);
    }

    public enum EvaporationBedType implements StringRepresentable, IStateHarvestLevel {
        DIRT("dirt", 0);

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final int harvestLevel;
        @Getter
        private final ResourceLocation texture;

        EvaporationBedType(@NotNull String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
            this.texture = Supersymmetry.id("block/casings/evaporation_bed/evaporation_bed_" + name);
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
