package belletti.supersymmetry.common.block;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.ICoolingCoilType;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

import static belletti.supersymmetry.common.data.materials.SuSyMaterials.*;

public class BlockCoolingCoil extends ActiveBlock {

    public ICoolingCoilType coilType;

    public BlockCoolingCoil(Properties properties, ICoolingCoilType coilType) {
        super(properties,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                            new ResourceLocation("block/cube_all"), Map.of("all", coilType.getTexture()))
                        : null,
                Platform.isClient()
                        ? new TextureOverrideRenderer(
                            GTCEu.id("block/cube_2_layer_all"), Map.of("bot_all", coilType.getTexture(),
                                "top_all", new ResourceLocation(coilType.getTexture() + "_bloom")))
                        :  null);
        this.coilType = coilType;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip,
                                TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        tooltip.add(Component.translatable("tile.cooling_coil.tooltip_temperature", coilType.getCoilTemperature()));
//        tooltip.add(Component.literal(String.valueOf(coilType.getCoilTemperature())));
    }

    public enum CoolingCoilType implements StringRepresentable, ICoolingCoilType {
        MANGANESE_IRON_ARSENIC_PHOSPHIDE("manganese_iron_arsenic_phosphide", 160, ManganeseIronArsenicPhosphide, Supersymmetry.id("block/casings/coils/machine_coil_manganese_iron_arsenic_phosphide")),
        PRASEODYMIUM_NICKEL("praseodymium_nickel", 50, PraseodymiumNickel, Supersymmetry.id("block/casings/coils/machine_coil_praseodymium_nickel")),
        GADOLINIUM_SILICON_GERMANIUM("gadolinium_silicon_germanium", 1, GadoliniumSiliconGermanium, Supersymmetry.id("block/casings/coils/machine_coil_gadolinium_silicon_germanium"));

        @NotNull
        @Getter
        private final String name;
        @Getter
        private final int coilTemperature;
        @Getter
        private final Material material;
        @NotNull
        @Getter
        private final ResourceLocation texture;

        CoolingCoilType(@NotNull String name, int coilTemperature, Material material, @NotNull ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.material = material;
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
            return this.getSerializedName();
        }
    }
}
