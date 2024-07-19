package belletti.supersymmetry.common.block;

import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.materials.SuSyMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import lombok.Getter;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum SuSyStoneTypes implements StringRepresentable {
    GABBRO("gabbro", MapColor.COLOR_GRAY, true, () -> SuSyBlocks.GABBRO::getDefaultState, SuSyMaterials.Gabbro, true),
    GNEISS("gneiss", MapColor.TERRACOTTA_RED, true, () -> SuSyBlocks.GNEISS::getDefaultState, SuSyMaterials.Gneiss, true),
    LIMESTONE("limestone", MapColor.TERRACOTTA_GRAY, true, () -> SuSyBlocks.LIMESTONE::getDefaultState, SuSyMaterials.Limestone, true),
    PHYLLITE("phyllite", MapColor.COLOR_GRAY, true, () -> SuSyBlocks.PHYLLITE::getDefaultState, SuSyMaterials.Phyllite, true),
    QUARTZITE("quartzite", MapColor.QUARTZ, true, () -> SuSyBlocks.QUARTZITE::getDefaultState, GTMaterials.Quartzite, true),
    SHALE("shale", MapColor.TERRACOTTA_RED, true, () -> SuSyBlocks.SHALE::getDefaultState, SuSyMaterials.Shale, true),
    SLATE("slate", MapColor.TERRACOTTA_RED, true, () -> SuSyBlocks.SLATE::getDefaultState, SuSyMaterials.Slate, true),
    SOAPSTONE("soapstone", MapColor.TERRACOTTA_GRAY, true, () -> SuSyBlocks.SOAPSTONE::getDefaultState, GTMaterials.Soapstone, true),
    KIMBERLITE("kimberlite", MapColor.COLOR_GRAY, true, () -> SuSyBlocks.KIMBERLITE::getDefaultState, SuSyMaterials.Kimberlite, true),
    ;

    private final String name;
    public final MapColor mapColor;
    @Getter
    public final boolean natural;
    @Getter
    public final Supplier<Supplier<BlockState>> state;
    @Getter
    public final Material material;

    public final boolean generateBlocks;

    SuSyStoneTypes(@Nonnull String name, @Nonnull MapColor mapColor, boolean natural, Supplier<Supplier<BlockState>> state,
                   Material material) {
        this(name, mapColor, natural, state, material, true);
    }

    SuSyStoneTypes(@Nonnull String name, @Nonnull MapColor mapColor, boolean natural, Supplier<Supplier<BlockState>> state,
                   Material material, boolean generateBlocks) {
        this.name = name;
        this.mapColor = mapColor;
        this.natural = natural;
        this.state = state;
        this.material = material;
        this.generateBlocks = generateBlocks;
    }

    @Nonnull
    @Override
    public String getSerializedName() {
        return this.name;
    }

    public TagPrefix getTagPrefix() {
        return switch (this) {
//            case GABBRO -> SuSyTagPrefix.oreGabbro;
            default -> TagPrefix.block;
        };
    }

    public static void init() {}
}
