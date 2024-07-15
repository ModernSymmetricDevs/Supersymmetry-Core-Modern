package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.capability.ICryogenicProvider;
import belletti.supersymmetry.api.capability.ICryogenicReceiver;
import belletti.supersymmetry.common.block.BlockSuSyMultiblockCasing;
import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.data.SuSyMachines;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Set;

import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;

public class LowPressureCryogenicDistillationPlant extends WorkableElectricMultiblockMachine implements ICryogenicProvider, IExplosionMachine {
    @Nullable
    private Collection<ICryogenicReceiver> cryogenicReceivers;

    public LowPressureCryogenicDistillationPlant(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        if (cryogenicReceivers != null) {
            this.cryogenicReceivers.forEach(receiver -> receiver.setCryogenicProvider(null));
            this.cryogenicReceivers = null;
        }
        Set<ICryogenicReceiver> receivers = getMultiblockState().getMatchContext().getOrCreate("cryogenicReceiver",
                Sets::newHashSet);
        this.cryogenicReceivers = ImmutableSet.copyOf(receivers);
        this.cryogenicReceivers.forEach(receiver -> receiver.setCryogenicProvider(this));
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        if (cryogenicReceivers != null) {
            this.cryogenicReceivers.forEach(receiver -> receiver.setCryogenicProvider(null));
            this.cryogenicReceivers = null;
        }
    }

    @NotNull
    @Override
    public BlockPattern getPattern() {
        return FactoryBlockPattern.start(RIGHT, BACK, UP)
                .aisle("CCC", "CCC", "CCC")
                .aisle("XXX", "XFX", "XXX")//.setRepeatable(1, 16)
                .aisle("CSC", "E E", "CEC")
                .aisle("DDD", "DDD", "DDD")
                .where('S', Predicates.controller(Predicates.blocks(this.getDefinition().get())))
                .where('C', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                        .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                        .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1))
                        .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                .where('F', Predicates.blocks(SuSyBlocks.SUSY_MULTIBLOCK_CASING_BLOCKS.get(BlockSuSyMultiblockCasing.CasingType.STRUCTURAL_PACKING).get()))
                .where('X', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())
                        .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMaxLayerLimited(1))
                        .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxLayerLimited(1)))
                .where('D', Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get()))
                .where('E', Predicates.abilities(PartAbility.PASSTHROUGH_HATCH)
                        .or(Predicates.blocks(GTBlocks.CASING_ALUMINIUM_FROSTPROOF.get())))
                .where(' ', cryogenicReceiverPredicate())
                .build();
    }

    public TraceabilityPredicate cryogenicReceiverPredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            Set<ICryogenicReceiver> receivers = blockWorldState.getMatchContext().getOrCreate("cryogenicReceiver",
                    Sets::newHashSet);
            BlockEntity blockEntity = blockWorldState.getTileEntity();

            if(blockEntity instanceof MetaMachineBlockEntity GTEntity && GTEntity.metaMachine instanceof ICryogenicReceiver receiver) {
                receivers.add(receiver);
                receiver.setCryogenicProvider(this);
                Supersymmetry.LOGGER.debug("Block {} assigned as a CryogenicReceiver.", blockEntity);
            }

            return true;
        }, () -> new BlockInfo[]{new BlockInfo(SuSyMachines.BATH_CONDENSER.defaultBlockState())}) {
            @Override
            public boolean isAny() {
                return true;
            }

            @Override
            public boolean addCache() {
                return true;
            }
        };
    }

    @Override
    public boolean allowExtendedFacing() { return false; }
}
