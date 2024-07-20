package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.common.machine.multiblock.VoidingMultiblockBase;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FlareStack extends VoidingMultiblockBase {
    public FlareStack(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    // @TODO item tooltip

    @Override
    public boolean canVoid(Fluid fluid) {
        Material fluidMaterial = ChemicalHelper.getMaterial(fluid);
        if (fluidMaterial == null) return false;

        Fluid liquidFluid = fluidMaterial.getFluid(FluidStorageKeys.LIQUID);
        Fluid gasFluid = fluidMaterial.getFluid(FluidStorageKeys.GAS);
        boolean isLiquidFluidOrGas = (liquidFluid != null && liquidFluid == fluid) || (gasFluid != null && gasFluid == fluid);

        return isLiquidFluidOrGas && fluidMaterial.hasFlag(MaterialFlags.FLAMMABLE);
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if(!isFormed) return;
        Component componentHeight = Component.literal(String.valueOf(this.height)).withStyle(ChatFormatting.BLUE);
        Component componentRateBonus = Component.literal(this.rateBonus + "x").withStyle(ChatFormatting.DARK_PURPLE);
        Component componentRateBase = Component.translatable("gregtech.machine.flare_stack.rate", componentRateBonus).withStyle(ChatFormatting.GRAY);
        Component componentRateHover = Component.translatable("gregtech.machine.flare_stack.rate_hover").withStyle(ChatFormatting.GRAY);

        textList.add(Component.translatable("gregtech.machine.flare_stack.height", componentHeight).withStyle(ChatFormatting.GRAY));
        textList.add(componentRateBase.copy().setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, componentRateHover))));
    }
}
