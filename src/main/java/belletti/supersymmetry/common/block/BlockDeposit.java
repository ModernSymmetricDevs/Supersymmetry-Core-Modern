package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.IStateHarvestLevel;
import belletti.supersymmetry.common.data.SuSyBlocks;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class BlockDeposit extends ActiveBlock {
    public BlockDeposit(Properties properties, IStateHarvestLevel depositBlockType) {
        super(
                properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", depositBlockType.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                        new ResourceLocation("block/cube_all"), Map.of("all", depositBlockType.getTexture()))
                        : null);
    }

    @Override
    public @NotNull List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        return List.of();
    }

    public enum DepositBlockType implements StringRepresentable, IStateHarvestLevel {
        ORTHOMAGMATIC("orthomagmatic", 10),
        METAMORPHIC("metamorphic", 10),
        SEDIMENTARY("sedimentary", 10),
        HYDROTHERMAL("hydrothermal", 10),
        ALLUVIAL("alluvial", 10),
        MAGMATIC_HYDROTHERMAL("magmatic_hydrothermal", 10);

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final int harvestLevel;
        @Getter
        private final ResourceLocation texture;

        DepositBlockType(@NotNull String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
            this.texture = Supersymmetry.id("block/deposit/" + name);
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
