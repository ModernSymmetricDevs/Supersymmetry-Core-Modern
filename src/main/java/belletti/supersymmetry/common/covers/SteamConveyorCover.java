package belletti.supersymmetry.common.covers;

import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.common.cover.ConveyorCover;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

public class SteamConveyorCover extends ConveyorCover {
    private final int maxTransferRate = 4;

    public SteamConveyorCover(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide) {
        super(definition, coverHolder, attachedSide, 1);
        this.transferRate = maxTransferRate;
    }

    @Override
    public void setTransferRate(int transferRate) {
        if (transferRate <= maxTransferRate) {
            this.transferRate = transferRate;
        }
    }

    @Override
    protected @NotNull String getUITitle() {
        return "Steam Conveyor Module";
    }
}
