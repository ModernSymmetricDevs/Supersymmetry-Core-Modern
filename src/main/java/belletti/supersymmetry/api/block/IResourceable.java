package belletti.supersymmetry.api.block;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public interface IResourceable {
    @NotNull
    String getName();

    ResourceLocation getTexture();
}
