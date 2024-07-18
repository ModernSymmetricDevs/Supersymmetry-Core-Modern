package belletti.supersymmetry.common.covers;

import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.common.cover.PumpCover;
import net.minecraft.core.Direction;

public class SteamPumpCover extends PumpCover {
    private final int maxMbPerTick = 32;

    public SteamPumpCover(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide) {
        super(definition, coverHolder, attachedSide, 1);
        this.currentMilliBucketsPerTick = maxMbPerTick;
    }

    @Override
    public void setTransferRate(long milliBucketsPerTick) {
        this.currentMilliBucketsPerTick = Math.min(Math.max(milliBucketsPerTick, 0), maxMbPerTick);
    }

    @Override
    protected String getUITitle() {
        return "Steam Pump";
    }
}
