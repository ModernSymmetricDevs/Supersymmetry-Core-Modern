package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.IStoneType;
import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.data.materials.SuSyMaterials;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SuSyStoneVariantBlock extends ActiveBlock {
    private StoneShape stoneShape;
    private StoneType stoneType;

    public SuSyStoneVariantBlock(Properties properties, StoneType stoneType, StoneShape stoneShape) {
        super(properties,
                Platform.isClient() ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"),
                        Map.of("all", stoneType.getTexture(stoneShape))
                ) : null,
                Platform.isClient() ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"),
                        Map.of("all", stoneType.getTexture(stoneShape))
                ) : null
        );
        this.stoneShape = stoneShape;
        this.stoneType = stoneType;
    }

    @Override
    public @NotNull List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
         if(this.stoneShape == StoneShape.SMOOTH) {
            return List.of(SuSyBlocks.SUSY_STONE_BLOCKS.get(this.stoneType).get(StoneShape.COBBLE).asStack());
        }

        return super.getDrops(state, params);
    }

    public enum StoneShape {
        SMOOTH("smooth"),
        COBBLE("cobble", 2.0F, 10.0F),
        BRICKS("bricks");
//      TODO
//        COBBLE_MOSSY("stone_cobble_mossy", 2.0F, 10.0F),
//        POLISHED("stone_polished"),
//        BRICKS_CRACKED("stone_bricks_cracked"),
//        BRICKS_MOSSY("stone_bricks_mossy"),
//        CHISELED("stone_chiseled"),
//        TILED("stone_tiled"),
//        TILED_SMALL("stone_tiled_small"),
//        BRICKS_SMALL("stone_bricks_small"),
//        WINDMILL_A("stone_windmill_a", "stone_bricks_windmill_a"),
//        WINDMILL_B("stone_windmill_b", "stone_bricks_windmill_b"),
//        BRICKS_SQUARE("stone_bricks_square");

        public final String variantName;
        public final float hardness;
        public final float resistance;

        StoneShape(@Nonnull String variantName) {
            this(variantName, 1.5F, 10.0F);
        }

        StoneShape(@Nonnull String variantName, float hardness, float resistance) {
            this.variantName = variantName;
            this.hardness = hardness;
            this.resistance = resistance;
        }
    }

    public enum StoneType implements StringRepresentable, IStoneType {
        GABBRO("gabbro", MapColor.COLOR_GRAY),
        GNEISS("gneiss", MapColor.TERRACOTTA_RED),
        LIMESTONE("limestone", MapColor.TERRACOTTA_RED),
        PHYLLITE("phyllite", MapColor.COLOR_GRAY),
        QUARTZITE("quartzite", MapColor.QUARTZ),
        SHALE("shale", MapColor.TERRACOTTA_RED),
        SLATE("slate", MapColor.TERRACOTTA_RED),
        SOAPSTONE("soapstone", MapColor.TERRACOTTA_GRAY),
        KIMBERLITE("kimberlite", MapColor.COLOR_GRAY);

        @NotNull
        @Getter
        private final String name;
        @NotNull
        @Getter
        private final MapColor mapColor;

        StoneType(@NotNull String name, @NotNull MapColor mapColor) {
            this.name = name;
            this.mapColor = mapColor;
        }

        @Override
        public ResourceLocation getTexture(StoneShape shape) {
            return Supersymmetry.id("block/susy_stones/" + this.name + "_" + shape.variantName);
        }

        @Override
        public Material getMaterial() {
            return switch (this) {
                case GABBRO -> SuSyMaterials.Gabbro;
                case GNEISS -> SuSyMaterials.Gneiss;
                case LIMESTONE -> SuSyMaterials.Limestone;
                case PHYLLITE -> SuSyMaterials.Phyllite;
                case QUARTZITE -> GTMaterials.Quartzite;
                case SHALE -> SuSyMaterials.Shale;
                case SLATE -> SuSyMaterials.Slate;
                case SOAPSTONE -> GTMaterials.Soapstone;
                case KIMBERLITE -> SuSyMaterials.Kimberlite;
            };
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
