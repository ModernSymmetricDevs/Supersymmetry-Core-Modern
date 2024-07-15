package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.BlockCoolingCoil;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockDisplayText;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MagneticRefrigerator extends WorkableElectricMultiblockMachine implements IExplosionMachine {
    @Getter
    private BlockCoolingCoil.CoolingCoilType coilType;
    @Getter
    private int temperature;

    public MagneticRefrigerator(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var type = getMultiblockState().getMatchContext().get("CoolingCoilType");
        if (type instanceof BlockCoolingCoil.CoolingCoilType coil) {
            this.coilType = coil;
            this.temperature = coil.getCoilTemperature();
        }
    }

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        MultiblockDisplayText.builder(textList, isFormed())
                .setWorkingStatus(isWorkingEnabled(), isActive())
                .addEnergyUsageLine(getEnergyContainer())
                .addEnergyTierLine(GTUtil.getTierByVoltage(getMaxVoltage()))
                .addCustom(tl -> {
                    // Coil heat capacity line
                    if (isFormed()) {
                        tl.add(Component.translatable("gtceu.multiblock.blast_furnace.max_temperature",
                                Component.translatable(FormattingUtil.formatNumbers(temperature) + "K")
                                        .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                    }
                })
//                .addParallelsLine(recipeMapWorkable.getParallelLimit())
                .addWorkingStatusLine()
                .addProgressLine((int) (recipeLogic.getProgressPercent() * 100));
    }
}
