package belletti.supersymmetry.common.data;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.covers.AirVentCover;
import belletti.supersymmetry.common.covers.SteamConveyorCover;
import belletti.supersymmetry.common.covers.SteamPumpCover;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.client.renderer.cover.ICoverRenderer;
import com.gregtechceu.gtceu.client.renderer.cover.SimpleCoverRenderer;
import net.minecraft.resources.ResourceLocation;

public class SuSyCovers {
    public final static CoverDefinition STEAM_CONVEYOR_COVER = register(
            GTCEu.id("steam_conveyor"), SteamConveyorCover::new,
            new SimpleCoverRenderer(GTCEu.id("block/cover/overlay_conveyor")));

    public final static CoverDefinition STEAM_PUMP_COVER = register(
            GTCEu.id("steam_pump"), SteamPumpCover::new,
            new SimpleCoverRenderer(GTCEu.id("block/cover/overlay_pump")));

    public final static CoverDefinition AIR_VENT_COVER = register(
            Supersymmetry.id("air_vent_cover"), AirVentCover::new,
            new SimpleCoverRenderer(Supersymmetry.id("item/air_vent_cover")));

    public static CoverDefinition register(ResourceLocation itemTextureRes,
                                           CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                           ICoverRenderer coverRenderer) {
        var definition = new CoverDefinition(itemTextureRes, behaviorCreator, coverRenderer);
        GTRegistries.COVERS.register(Supersymmetry.id(itemTextureRes.getPath()), definition);
        return definition;
    }

    public static void init() {

    }
}
