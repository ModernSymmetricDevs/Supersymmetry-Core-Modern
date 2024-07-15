package belletti.supersymmetry.api.block;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public interface IStateHarvestLevel {
    @NotNull
    String getName();

    int getHarvestLevel();

    ResourceLocation getTexture();
}
