package belletti.supersymmetry.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.data.GTCompassNodes;
import com.gregtechceu.gtceu.common.data.GTCompassSections;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;

import static belletti.supersymmetry.api.registries.SuSyRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.common.data.GTItems.attach;
import static com.gregtechceu.gtceu.common.data.GTItems.compassNodeExist;

public class SuSyItems {
    public static final ItemEntry<ComponentItem> CATALYST_BED_SUPPORT_GRID = REGISTRATE.item("catalyst_bed_support_grid", ComponentItem::create)
            .lang("Catalyst Bed Support Grid")
            .defaultModel()
            .register();

    public static final ItemEntry<ComponentItem> STEAM_CONVEYOR = REGISTRATE.item("steam_conveyor", ComponentItem::create)
            .lang("Steam Conveyor")
            .onRegister(attach(new CoverPlaceBehavior(SuSyCovers.STEAM_CONVEYOR_COVER)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate", 4));
            })))
            .onRegister(compassNodeExist(GTCompassSections.COVERS, "conveyor", GTCompassNodes.COVER))
            .register();

    public static final ItemEntry<ComponentItem> STEAM_PUMP_COVER = REGISTRATE.item("steam_pump", ComponentItem::create)
            .lang("Steam Pump")
            .onRegister(attach(new CoverPlaceBehavior(SuSyCovers.STEAM_PUMP_COVER)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", 32));
            })))
            .onRegister(compassNodeExist(GTCompassSections.COVERS, "pump", GTCompassNodes.COVER))
            .register();

    public static final ItemEntry<ComponentItem> AIR_VENT_COVER = REGISTRATE.item("air_vent_cover", ComponentItem::create)
            .lang("Air Vent Cover")
            .onRegister(attach(new CoverPlaceBehavior(SuSyCovers.AIR_VENT_COVER)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("metaitem.air_vent.tooltip.1", 1000));
            })))
            .register();

    // air vent cover

    public static void init() {

    }
}
