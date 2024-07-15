package belletti.supersymmetry.common.machine.multiblock.electrical;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMufflerMechanic;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;

public class ReverberatoryFurnace extends WorkableElectricMultiblockMachine implements IMufflerMechanic, IExplosionMachine {
    public ReverberatoryFurnace(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public void animateTick(@NotNull RandomSource random) {
        if(!this.isActive()) return;

        final BlockPos pos = getPos();
        float x = pos.getX() + 0.5F;
        float z = pos.getZ() + 0.5F;

        final Direction facing = getFrontFacing();
        final float horizontalOffset = random.nextFloat() * 0.6F - 0.3F;
        final float y = pos.getY() + random.nextFloat() * 0.375F + 0.3F;

        if (facing.getAxis() == Direction.Axis.X) {
            if (facing.getAxisDirection() == Direction.AxisDirection.POSITIVE) x += 0.52F;
            else x -= 0.52F;
            z += horizontalOffset;
        } else if (facing.getAxis() == Direction.Axis.Z) {
            if (facing.getAxisDirection() == Direction.AxisDirection.POSITIVE) z += 0.52F;
            else z -= 0.52F;
            x += horizontalOffset;
        }
        if (ConfigHolder.INSTANCE.machines.machineSounds && random.nextDouble() < 0.1) {
            getLevel().playLocalSound(x, y, z, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
        }
        getLevel().addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, 0, 0);
        getLevel().addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }
}
