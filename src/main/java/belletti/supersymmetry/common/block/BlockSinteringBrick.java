package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.ISinteringBrickType;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class BlockSinteringBrick extends ActiveBlock {
    public ISinteringBrickType brickType;

    public BlockSinteringBrick(Properties properties, ISinteringBrickType brickType) {
        super(properties, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                        Map.of("all", brickType.getTexture())) : null,
                Platform.isClient() ? new TextureOverrideRenderer(GTCEu.id("block/cube_2_layer_all"),
                        Map.of("bot_all", brickType.getTexture(),
                                "top_all", new ResourceLocation(brickType.getTexture() + "_bloom"))) :
                        null);
        this.brickType = brickType;
    }

    public enum SinteringBrickType implements StringRepresentable, ISinteringBrickType {
        BRICK("brick", false, Supersymmetry.id("block/casings/sintering_bricks/sintering_bricks")),
        MAGNETOPLATED("magnetoplated", true, Supersymmetry.id("block/casings/sintering_bricks/sintering_bricks_magnetic"));

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final boolean canResistPlasma;
        @NotNull
        @Getter
        private final ResourceLocation texture;

        SinteringBrickType(@NotNull String name, boolean canResistPlasma, @NotNull ResourceLocation texture) {
            this.name = name;
            this.canResistPlasma = canResistPlasma;
            this.texture = texture;
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
