package belletti.supersymmetry.common.machine.multiblock.electrical;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Dumper extends WorkableElectricMultiblockMachine {
    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(Dumper.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    private NotifiableFluidTank inputFluidTank;
    private final int voidingRate = 1000;
    @DescSynced
    private boolean isActive = false;

    public Dumper(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.initializeTank();
        this.subscribeServerTick(this::serverTickEvent);
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private void serverTickEvent() {
        if (getOffsetTimer() % 20 == 0) return;
        if (inputFluidTank == null || inputFluidTank.getContents().isEmpty()) {
            this.isActive = false;
            return;
        }

        FluidStack fluidIn = (FluidStack) inputFluidTank.getContents().get(0);
        if (fluidIn.isEmpty() || !canVoid(fluidIn.getFluid())) return;

        this.isActive = true;
        inputFluidTank.drainInternal(voidingRate, false);
    }

    private boolean canVoid(Fluid fluid) {
        Material fluidMaterial = ChemicalHelper.getMaterial(fluid);
        if (fluidMaterial == null) return false;

        Fluid liquidFluid = fluidMaterial.getFluid(FluidStorageKeys.LIQUID);
        return liquidFluid != null && liquidFluid == fluid && fluidMaterial.hasFlag(MaterialFlags.FLAMMABLE);
    }

    // @TODO item tooltip gregtech.machine.dumper.rate

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

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        textList.add(Component.translatable("gregtech.machine.dumper.tooltip.1", voidingRate));
        super.addDisplayText(textList);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        if (this.inputFluidTank == null) initializeTank();
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.inputFluidTank = null;
    }

    private void initializeTank() {
        for (IMultiPart part : getParts()) {
            for (var handler : part.getRecipeHandlers()) {
                if (handler.getHandlerIO() == IO.IN && handler.getCapability() == FluidRecipeCapability.CAP) {
                    inputFluidTank = (NotifiableFluidTank) handler;
                    return;
                }
            }
        }
    }

}
