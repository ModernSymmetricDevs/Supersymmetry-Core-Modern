package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.BlockDeposit;
import com.gregtechceu.gtceu.api.capability.IControllable;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.WorkableTieredMachine;
import com.gregtechceu.gtceu.api.machine.feature.IEnvironmentalHazardEmitter;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

// @TODO: environment hazard emission
// @TODO: handle energy

public class MiningDrill extends WorkableElectricMultiblockMachine implements IFancyUIMachine {
    @Persisted
    public final NotifiableItemStackHandler importItems;

    public MiningDrill(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.importItems = new NotifiableItemStackHandler(this, getRecipeType().getMaxInputs(ItemRecipeCapability.CAP), IO.IN);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();

        BlockDeposit targetDepositBlockEntry = getMultiblockState().getMatchContext().get("targetDepositBlockEntry");
        if (targetDepositBlockEntry == null) return;

        this.importItems.storage.insertItem(0, targetDepositBlockEntry.asItem().getDefaultInstance(), false);
    }

    @Override
    public void onStructureInvalid() {
        this.importItems.storage.insertItem(0, ItemStack.EMPTY, false);
        super.onStructureInvalid();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@NotNull RandomSource random) {
        super.animateTick(random);
        if (!this.isActive()) return;

        BlockPos targetDepositBlockPos = getPos().relative(getFrontFacing().getOpposite()).below(4);
        float xBase = targetDepositBlockPos.getX() + 0.5F;
        float yBase = targetDepositBlockPos.getY() + 1;
        float zBase = targetDepositBlockPos.getZ() + 0.5F;

        // @TODO: integrate the campfire_cosy_smoke particles into SuSy, so texture packs might change it independently of the actual campfire smoke texture
        // @TODO: MAKE THIS PLAY A LOUD MINING NOISE, PERHAPS HAVE STATUS EFFECTS FOR PLAYERS WHO COME NEAR THE MINING
        drawRandomizedParticles(xBase, yBase, zBase, ParticleTypes.CAMPFIRE_COSY_SMOKE, 15, random);

        BlockState stoneState = Blocks.STONE.defaultBlockState();
        for (int i = 0; i < 30; i++) {
            double offsetX = random.nextDouble() - 0.5;
            double offsetY = random.nextDouble();
            double offsetZ = random.nextDouble() - 0.5;
            drawRandomizedParticles(
                    xBase + offsetX, yBase + offsetY - 0.5, zBase + offsetZ,
                    new BlockParticleOption(ParticleTypes.BLOCK, stoneState), 3, random
            );
        }
    }

    private void drawRandomizedParticles(double centerX, double centerY, double centerZ, ParticleOptions particleType, int particleCount, RandomSource random) {
        double maxRadius = 1.5;
        for (int i = 0; i < particleCount; i++) {
            double angle = 2 * Math.PI * random.nextDouble();
            double distance = maxRadius * random.nextDouble();
            double x = centerX + distance * Math.cos(angle) + (random.nextDouble() - 0.5) * 0.1;
            double z = centerZ + distance * Math.sin(angle) + (random.nextDouble() - 0.5) * 0.1;
            getLevel().addParticle(particleType, x, centerY, z, 0, 0, 0);
        }
    }

//    @Override
//    public void animateTick(@NotNull RandomSource random) {
//        super.animateTick(random);
//        if (!this.isActive()) return;
//
//        BlockPos targetDepositBlockPos = getPos().relative(getFrontFacing().getOpposite()).below(4);
//        float xBase = targetDepositBlockPos.getX() + random.nextFloat();
//        float yBase = targetDepositBlockPos.getY() + 1;
//        float zBase = targetDepositBlockPos.getZ() + random.nextFloat();
//
//        addSmokeParticle(xBase - 1, yBase, zBase);
//        addSmokeParticle(xBase + 1, yBase, zBase);
//        addSmokeParticle(xBase, yBase, zBase - 1);
//        addSmokeParticle(xBase, yBase, zBase + 1);
//        addSmokeParticle(xBase - 0.5, yBase, zBase - 0.5);
//        addSmokeParticle(xBase + 0.5, yBase, zBase - 0.5);
//        addSmokeParticle(xBase - 0.5, yBase, zBase + 0.5);
//        addSmokeParticle(xBase + 0.5, yBase, zBase + 0.5);
//
//        // Add breaking particles
//        BlockState stoneState = Blocks.STONE.defaultBlockState();
//        for (int i = 0; i < 30; i++) {
//            double offsetX = random.nextDouble();
//            double offsetY = random.nextDouble();
//            double offsetZ = random.nextDouble();
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX - 1, offsetY, offsetZ);
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX + 1, offsetY, offsetZ);
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX, offsetY, offsetZ - 1);
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX, offsetY, offsetZ + 1);
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX - 0.5, offsetY, offsetZ - 0.5);
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX + 0.5, offsetY, offsetZ - 0.5);
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX - 0.5, offsetY, offsetZ + 0.5);
//            addBreakingParticle(stoneState, targetDepositBlockPos, offsetX + 0.5, offsetY, offsetZ + 0.5);
//        }
//    }
//
//    private void addSmokeParticle(double x, double y, double z) {
//        getLevel().addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0, 0, 0);
//    }
//
//    private void addBreakingParticle(BlockState blockState, BlockPos basePos, double offsetX, double offsetY, double offsetZ) {
//        getLevel().addParticle(
//                new BlockParticleOption(ParticleTypes.BLOCK, blockState),
//                basePos.getX() + offsetX,
//                basePos.getY() + offsetY,
//                basePos.getZ() + offsetZ,
//                0.0D, 0.0D, 0.0D
//        );
//    }
}