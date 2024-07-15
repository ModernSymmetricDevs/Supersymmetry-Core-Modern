package belletti.supersymmetry.api.block;

import belletti.supersymmetry.common.block.SuSyStoneVariantBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public interface IStoneType {
    @NotNull
    String getName();

    Material getMaterial();

    ResourceLocation getTexture(SuSyStoneVariantBlock.StoneShape shape);
}
