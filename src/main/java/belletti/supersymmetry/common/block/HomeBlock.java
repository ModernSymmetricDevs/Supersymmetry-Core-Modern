package belletti.supersymmetry.common.block;

import com.gregtechceu.gtceu.api.block.AppearanceBlock;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class HomeBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public HomeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    // Block Placement Ruleset //

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    // Home Block Ruleset //

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (placer != null) {
            world.setBlock(pos, state.setValue(FACING, placer.getDirection().getOpposite()), 2);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.dimensionType().hasSkyLight() && !world.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockPos spawnPos = pos.above();
            player.displayClientMessage(Component.literal("tile.home.allowed"), true);
            serverPlayer.setRespawnPosition(world.dimension(), spawnPos, 0.0F, true, true);
            return InteractionResult.SUCCESS;
        } else {
            player.displayClientMessage(Component.literal("tile.home.denied"), true);
            return InteractionResult.FAIL;
        }
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!world.isClientSide && !state.is(newState.getBlock())) {
            for (ServerPlayer player : world.getEntitiesOfClass(ServerPlayer.class, new AABB(pos).inflate(10))) {
                BlockPos spawnPos = player.getRespawnPosition();
                if (spawnPos != null && spawnPos.equals(pos.above())) {
                    player.setRespawnPosition(world.dimension(), null, 0.0F, true, false);
                    player.displayClientMessage(Component.translatable("tile.home.removed"), true);
                }
            }
        }
        super.onRemove(state, world, pos, newState, isMoving);
    }

    public enum HomeType implements StringRepresentable {
        HOME_PRIMITIVE("primitive", "Home Block Primitive"),
        HOME_GT_BRUTALIST("gt_brutalist", "Home Block GT Brutalist"),
        HOME_RENEWAL_BRUTALIST("renewal_brutalist", "Home Block Renewal Brutalist"),
        HOME_SCIFI("scifi", "Home Block SciFi");

        @Getter
        private final String name;
        @Getter
        private final String resourceSuffix;

        HomeType(String resourceSuffix, String name) {
            this.name = name;
            this.resourceSuffix = resourceSuffix;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        @Override
        public String toString() {
            return this.getSerializedName();
        }
    }
}
