package belletti.supersymmetry.api.block;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public interface ISinteringBrickType {
    @NotNull
    String getName();

    boolean isCanResistPlasma();

    ResourceLocation getTexture();
}
