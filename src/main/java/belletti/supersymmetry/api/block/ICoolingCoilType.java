package belletti.supersymmetry.api.block;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public interface ICoolingCoilType {
    @NotNull
    String getName();

    int getCoilTemperature();

    ResourceLocation getTexture();
}
