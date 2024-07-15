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

public class BlockStructural extends ActiveBlock {
    public BlockStructural(Properties properties, IStateHarvestLevel structuralBlockType) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                                new ResourceLocation("block/cube_all"), Map.of("all", structuralBlockType.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                                new ResourceLocation("block/cube_all"), Map.of("all", structuralBlockType.getTexture()))
                        : null);
    }

    public enum StructuralBlockType implements StringRepresentable, IStateHarvestLevel {
        BASE_STRUCTURAL_BLOCK("base_structural_block", 1),
        STRUCTURAL_BLOCK_LOW("structural_block_low", 1),
        STRUCTURAL_BLOCK_LOWLIGHT("structural_block_lowlight", 1),
        STRUCTURAL_BLOCK_DANGER_A("structural_block_danger_a", 1),
        STRUCTURAL_BLOCK_DANGER_B("structural_block_danger_b", 1),
        STRUCTURAL_BLOCK_DANGER_C("structural_block_danger_c", 1),
        STRUCTURAL_BLOCK_DANGER_D("structural_block_danger_d", 1),
        STRUCTURAL_BLOCK_COLUMN("structural_block_column", 1),
        STRUCTURAL_BLOCK_COLUMN_OLD("structural_block_column_old", 1),
        STRUCTURAL_BLOCK_LIGHT("structural_block_light", 1),
        STRUCTURAL_BLOCK_LIGHT_BROKEN("structural_block_light_broken", 1),
        STRUCTURAL_BLOCK_LIGHT_CABLE("structural_block_light_cable", 1),
        STRUCTURAL_BLOCK_INSTRUMENTS("structural_block_instruments", 1),
        STRUCTURAL_BLOCK_SIGN_0("structural_block_sign_0", 1),
        STRUCTURAL_BLOCK_SIGN_1("structural_block_sign_1", 1),
        STRUCTURAL_BLOCK_SIGN_2("structural_block_sign_2", 1),
        STRUCTURAL_BLOCK_1_EXPOSED("structural_block_exposed", 1),
        STRUCTURAL_BLOCK_1_EXPOSED_1("structural_block_exposed_1", 1),
        STRUCTURAL_BLOCK_1_EXPOSED_2("structural_block_exposed_2", 1),
        STRUCTURAL_BLOCK_1_DANGER_SIGN("structural_block_danger_sign", 1),
        STRUCTURAL_BLOCK_1_CABLE("structural_block_cable", 1),
        STRUCTURAL_BLOCK_1_CABLE_HORIZONTAL("structural_block_cable_horizontal", 1),
        STRUCTURAL_BLOCK_1_CABLE_JUNCTION("structural_block_cable_junction", 1),
        STRUCTURAL_BLOCK_1_PIPOCALYPSE("structural_block_pipocalypse", 1),
        STRUCTURAL_BLOCK_1_VENT("structural_block_vent", 1),
        STRUCTURAL_BLOCK_1_VENT_BROKEN("structural_block_vent_broken", 1);

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final int harvestLevel;
        @Getter
        private final ResourceLocation texture;

        StructuralBlockType(@NotNull String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
            this.texture = Supersymmetry.id("block/decorative/structural_blocks/" + name);
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
