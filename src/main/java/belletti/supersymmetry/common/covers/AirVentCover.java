package belletti.supersymmetry.common.covers;

import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.cover.CoverBehavior;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.recipe.DimensionCondition;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class AirVentCover extends CoverBehavior {
    private final TickableSubscription serverTickSub;
    private final int airPerSecond = 100;
    private @Nullable FluidStack cachedAirFluid;
    private boolean isObstructed = false;

    public AirVentCover(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide) {
        super(definition, coverHolder, attachedSide);
        this.serverTickSub = coverHolder.subscribeServerTick(this::serverTickEvent);
        super.onUnload();
    }

    @Override
    public void onUnload() {
        if (serverTickSub != null) this.coverHolder.unsubscribe(serverTickSub);
        super.onUnload();
    }

    @Override
    public void onAttached(@NotNull ItemStack itemStack, @NotNull ServerPlayer player) {
        super.onAttached(itemStack, player);
        this.isObstructed = checkObstructed();
        this.setCachedAirFluid();
    }

    @Override
    public void onNeighborChanged(@NotNull Block block, @NotNull BlockPos fromPos, boolean isMoving) {
        super.onNeighborChanged(block, fromPos, isMoving);
        this.isObstructed = checkObstructed();
    }

    private boolean checkObstructed() {
        var coverFrontPos = coverHolder.getPos();
        return coverHolder.getLevel().getBlockState(coverFrontPos.relative(attachedSide))
                .isSolidRender(coverHolder.getLevel(), coverFrontPos.relative(attachedSide));
    }

    protected void serverTickEvent() {
        if (coverHolder.isRemote() || coverHolder.getOffsetTimer() % 20 != 0 || isObstructed) return;
        if (this.cachedAirFluid == null) setCachedAirFluid();

        coverHolder.getFluidTransferCap(attachedSide, true).fill(this.cachedAirFluid, false);
    }

    private void setCachedAirFluid() {
        var currentDimensionLocation = coverHolder.getLevel().dimension().location();

        GTRecipeTypes.GAS_COLLECTOR_RECIPES.getLookup().getLookup().getRecipes(false)
                .filter(recipe -> recipe.conditions.stream()
                        .filter(DimensionCondition.class::isInstance)
                        .map(DimensionCondition.class::cast)
                        .anyMatch(condition -> condition.getDimension().equals(currentDimensionLocation)))
                .findFirst()
                .ifPresent(recipe -> {
                    var outputIngredient = recipe.outputs.get(FluidRecipeCapability.CAP).get(0);
                    var outputFluid = (FluidIngredient) outputIngredient.content;
                    if (outputFluid == null) return;
                    Arrays.stream(outputFluid.getStacks())
                            .findFirst()
                            .ifPresent(fluid -> {
                                fluid.setAmount(airPerSecond);
                                this.cachedAirFluid = fluid;
                            });
                });
    }
}
