package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.machine.multiblock.VoidingMultiblockBase;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Dumper extends VoidingMultiblockBase {
    public Dumper(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    // @TODO item tooltip gregtech.machine.dumper.rate

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("gregtech.machine.dumper.tooltip.1", this.getActualVoidingRate()));
    }

    @Override
    public boolean canVoid(Fluid fluid) {
        Material fluidMaterial = ChemicalHelper.getMaterial(fluid);
        if (fluidMaterial == null) return false;

        Fluid liquidFluid = fluidMaterial.getFluid(FluidStorageKeys.LIQUID);
        boolean isLiquidFluid = liquidFluid != null && liquidFluid == fluid;

        return isLiquidFluid && !fluidMaterial.hasFlag(MaterialFlags.FLAMMABLE);
    }

    @Override
    public void animateTick(@NotNull RandomSource random) {
        super.animateTick(random);
        if(!this.isActive()) return;

        Direction frontFacing = this.getFrontFacing();
        BlockPos dumperOutPos;

        // for some reason getPos() returns different positions depending on the machine facing direction
        if(frontFacing == Direction.SOUTH || frontFacing == Direction.WEST) {
            dumperOutPos = getPos().relative(frontFacing.getOpposite()).relative(getFrontFacing().getCounterClockWise(), 3);
        } else {
            dumperOutPos = getPos().relative(frontFacing.getOpposite()).relative(getFrontFacing().getCounterClockWise(), 2);
        }

        for (int i = 0; i < 10; i++) {
            double xOffset = random.nextDouble() - 0.5;
            double yOffset = -random.nextDouble();
            double zOffset = random.nextDouble() - 0.5;

            getLevel().addParticle(ParticleTypes.FALLING_WATER,
                    dumperOutPos.getX() + xOffset,
                    dumperOutPos.getY() + yOffset,
                    dumperOutPos.getZ() + zOffset,
                    0, 0, 0);

            if (yOffset < -0.8) {
                getLevel().addParticle(ParticleTypes.SPLASH,
                        dumperOutPos.getX() + xOffset,
                        dumperOutPos.getY() + yOffset,
                        dumperOutPos.getZ() + zOffset,
                        0, 0, 0);
            }
        }

        for (int i = 0; i < 5; i++) {
            double xOffset = random.nextDouble() - 0.5;
            double zOffset = random.nextDouble() - 0.5;
            getLevel().addParticle(ParticleTypes.DRIPPING_WATER,
                    dumperOutPos.getX() + xOffset,
                    dumperOutPos.getY(),
                    dumperOutPos.getZ() + zOffset,
                    0, -0.1, 0);
        }
    }
}
