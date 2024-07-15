package belletti.supersymmetry.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

import javax.annotation.Nullable;

public class HomeBlock extends Block {
    // @TODO: This might need a rework, fitting the same model of BlockCoolingCoil which extended ActiveBlock
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<HomeType> VARIANT = EnumProperty.create("variant", HomeType.class);

    public HomeBlock(Properties properties) {
        super(properties);
    }

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

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, VARIANT);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    public enum HomeType implements StringRepresentable {
        HOME_PRIMITIVE("primitive"),
        HOME_GT_BRUTALIST("gt_brutalist"),
        HOME_RENEWAL_BRUTALIST("renewal_brutalist"),
        HOME_SCIFI("scifi");

        private final String name;

        HomeType(String name) {
            this.name = name;
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
