package belletti.supersymmetry.common.machine.multiblock.electrical;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.data.SuSyBlocks;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class EvaporationPool extends CoilWorkableElectricMultiblockMachine {
    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(EvaporationPool.class, CoilWorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    private int columnCount = 1; //number of columns in row of controller (1 -> EDGEself(controller)EDGE, 2 -> EsCOLUMNe)
    @Persisted
    private int rowCount = 1; //number of rows where controller is placed on "edge" row
    @Persisted
    private int controllerPosition = 0; //column placement from left to right, where 0 = one from edge [ESCCCCE]
    @Persisted
    private static final int MAX_COLUMNS = 12; //two edge layers on either side, shouldn't exceed chunk boundary at max size
    @DescSynced
    private float sunlightDebuffFactor = 0;
    private float noSunlightPenalty = 4.0f;
    @DescSynced
    private List<BlockPos> positionsWhereEvaporationParticlesShouldSpawn = new ArrayList<>();

    public EvaporationPool(IMachineBlockEntity holder) {
        super(holder);
        this.subscribeServerTick(this::serverTickEvent);
    }

    @Override
    public boolean allowExtendedFacing() {
        return false;
    }

    @Override
    public void updateActiveBlocks(boolean active) {
        if (activeBlocks != null) {
            for (Long pos : activeBlocks) {
                var blockPos = BlockPos.of(pos);
                var blockState = getLevel().getBlockState(blockPos);
                if(this.energyContainer.getEnergyStored() <= 0 && active && blockState.getBlock() instanceof CoilBlock) {
//                    Supersymmetry.LOGGER.info("Block at {} is a CoilBlock, however we don't have enough energy to turn them on.", blockPos);
                    continue;
                }
                if (blockState.getBlock() instanceof ActiveBlock block) {
                    var newState = block.changeActive(blockState, active);
                    if (newState != blockState) {
                        getLevel().setBlockAndUpdate(blockPos, newState);
                    }
                }
            }
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        this.setWorkingEnabled(false);
        this.updateActiveBlocks(false);
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Nullable
    @Override
    public GTRecipe getRealRecipe(GTRecipe recipe) {
        var n = super.getRealRecipe(recipe);
        int debuffedDuration = recipe.duration + (recipe.duration * (int) (0 + sunlightDebuffFactor));
        if(this.energyContainer.getEnergyStored() > 1) debuffedDuration = (int) (debuffedDuration * 0.75);
//        Supersymmetry.LOGGER.info("Recipe duration: {} | Recipe debuffed: {} | sunLightDebuf: {} | energy: {}", recipe.duration, debuffedDuration, sunlightDebuffFactor, this.energyContainer.getEnergyStored());
        recipe.duration = debuffedDuration;
        return n;
    }

    @NotNull
    @Override
    public BlockPattern getPattern() {
        // return the default structure, even if there is no valid size found
        // this means auto-build will still work, and prevents terminal crashes.
        if (getLevel() != null) updateStructureDimensions();

        /*
            'E' for "edge" block, that is to say essentially the blocks that contain the water.
            '#' for air block where hypothetical water would be.
            'S' for self, or controller.
            'C' for "container blocks" that can be coils, with coils required for powered heating.
            'G' for ground blocks which must be some non coil block
         */

        // these can sometimes get set to 0 when loading the game, breaking JEI (Apparently; text from cleanroom impl)
        if (columnCount < 1) columnCount = 1;
        if (rowCount < 1) rowCount = 1;

        //abstracted away construction of center rows for later use
        String[] containerRows = centerRowsPattern();

        //do first two rows including controller row and row behind controller
        FactoryBlockPattern pattern = FactoryBlockPattern.start()
                .aisle(repeat("E", columnCount + 4), repeat(" ", columnCount + 4))
                .aisle(repeat("E", columnCount + 4), " ".concat(repeat("E", columnCount + 2)).concat(" "));

        //place all generated aisles (rows stored closer to further, this wants them further to closer) and save to pattern explicitly (unsure if the explicit assignment is necessary; probably no harm in being safe)
        for (int i = 0; i < rowCount; ++i) {
            pattern.aisle(containerRows[rowCount - 1 - i], " E".concat(repeat("#", columnCount).concat("E ")));
        }

        //place last two aisles
        pattern.aisle(repeat("E", columnCount + 4), " ".concat(repeat("E", columnCount + 2)).concat(" "))
                .aisle(repeat("E", controllerPosition + 2).concat("S").concat(repeat("E", columnCount + 1 - controllerPosition)), repeat(" ", columnCount + 4))

                .where('S', Predicates.controller(Predicates.blocks(this.getDefinition().get())))
                .where('E', Predicates.blocks(GTBlocks.LIGHT_CONCRETE.get())
                        .or(Predicates.autoAbilities(this.getRecipeType()).setMaxGlobalLimited(8))
                        .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(0).setMaxGlobalLimited(2).setPreviewCount(0)))
                .where('G', Predicates.blocks(SuSyBlocks.EVAPORATION_BED.get()))
                .where('C', Predicates.blocks(SuSyBlocks.EVAPORATION_BED.get())
                        .or(Predicates.heatingCoils()))
                .where('#', Predicates.air())
                .where(' ', Predicates.any());

        return pattern.build();
    }

    @Override
    public boolean checkPattern() {
        var n = super.checkPattern();
        var coilErrIdx = coilPatternCheck();
        if(coilErrIdx != -1) Supersymmetry.LOGGER.info("Coil misplaced at {}", coilErrIdx);

        return coilErrIdx == -1 && n;
    }

    // @TODO: realistic fluid rendering
    // @TODO: display sunlight penalties and debuffs on machine UI
    // @TODO: in case of no sunlight at all, we should nerf the amount of evaporation particles, instead of removing them all

    @Override
    public void clientTick() {
        super.clientTick();
        if(!this.isActive() || !this.onWorking()) return;

        if(getOffsetTimer() % 5 == 0) {
            spawnEvaporationParticles();
        }
    }

    private void serverTickEvent() {
        if(this.getOffsetTimer() % 20 != 0) return;

        if(getLevel().isRainingAt(getPos().relative(getFrontFacing().getOpposite(), 2)) || getLevel().isNight()) {
            sunlightDebuffFactor = 2;
            return;
        }

        final Direction back = this.getFrontFacing().getOpposite();
        final Direction left = back.getCounterClockWise();

        //conversion from blockpos to in world pos places particle position at corner of block such that relative direction must be accounted for
        //add 1 if x pos or z pos (offsets mutually exclusively non-zero for given facing) as conversion to float pos rounds down in both coords
        int leftOffset = ((left.getStepX() * -1) >>> 31) + ((left.getStepZ() * -1) >>> 31);
        int backOffset = ((back.getStepX() * -1) >>> 31) + ((back.getStepZ() * -1) >>> 31);

        //place pos in closest leftmost corner within the evaporation area
        final BlockPos pos = this.getPos().relative(left, controllerPosition + leftOffset).relative(back, 2 + backOffset);

//        Supersymmetry.LOGGER.info("rowCount: {} | columnCount: {}", rowCount, columnCount);
        List<BlockPos> tempPositionsWhereEvaporationParticlesShouldSpawn = new ArrayList<>();
        sunlightDebuffFactor = 0;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                float xLength = (back.getStepX() * row) + (left.getStepX() * col * -1);
                float zLength = (back.getStepZ() * row) + (left.getStepZ() * col * -1);

                float xPos = pos.getX() + xLength;
                float yPos = pos.getY() + 0.75F;
                float zPos = pos.getZ() + zLength;

                BlockPos checkPos = new BlockPos((int) xPos, (int) yPos, (int) zPos);

                if (!getLevel().canSeeSky(checkPos)) {
//                    Supersymmetry.LOGGER.info("Cannot see the sunlight at {},{},{}", xPos, yPos, zPos);
                    sunlightDebuffFactor += (1.0f / (rowCount * columnCount)) * noSunlightPenalty;
                    continue;
                }
                tempPositionsWhereEvaporationParticlesShouldSpawn.add(checkPos);
            }
        }
        if (!tempPositionsWhereEvaporationParticlesShouldSpawn.equals(positionsWhereEvaporationParticlesShouldSpawn)) {
            positionsWhereEvaporationParticlesShouldSpawn = new ArrayList<>(tempPositionsWhereEvaporationParticlesShouldSpawn);
        }
//        Supersymmetry.LOGGER.info("On serverside: {}", positionsWhereEvaporationParticlesShouldSpawn);
    }

    private void spawnEvaporationParticles() {
//        Supersymmetry.LOGGER.info("On clientside: {}", positionsWhereEvaporationParticlesShouldSpawn);
        if (positionsWhereEvaporationParticlesShouldSpawn.isEmpty()) {
            return;
        }

        for (BlockPos pos : positionsWhereEvaporationParticlesShouldSpawn) {
            float xPos = pos.getX() + GTValues.RNG.nextFloat();
            float yPos = pos.getY() + 0.75F;
            float zPos = pos.getZ() + GTValues.RNG.nextFloat();

            float ySpd = (this.energyContainer.getEnergyStored() > 0 ? 0.25f : 0.15f) + 0.1f * GTValues.RNG.nextFloat();
            getLevel().addParticle(ParticleTypes.CLOUD, xPos, yPos, zPos, 0, ySpd, 0);
        }
    }

    private int coilPatternCheck() {
        //first coil block has been found; ensure full coil pattern is present so that future validation checks may be skipped
        String[] centerPattern = centerRowsPattern();
        CoilBlock targetCoilBlock = GTCEuAPI.HEATING_COILS.get(this.getCoilType()).get();

        Direction right = getFrontFacing().getCounterClockWise(); //right if you are looking at controller
        Direction back = getFrontFacing().getOpposite(); //further from front of controller

        //get blockpos of first row, leftmost center block
        BlockPos.MutableBlockPos targetPos = getPos().relative(back, 2).mutable(); //place on first row
        targetPos.move(right.getOpposite(), controllerPosition +1); //move to the furthest left center block +1 (looking at controller) to account for immediate right deviation in j loop

        //traverse center pattern rows (closer to further)
        for (int i = 0; i < rowCount; ++i) {
            //traverse center pattern columns in 'i'th row, skipping edges
            for (int j = 2; j < columnCount + 2; ++j) {
                targetPos.move(right); //go right one first to allow for continue to be used later

                // skip non coil entries
                if (centerPattern[i].charAt(j) != 'C') continue;

                //current coilpos block is either not a coil (first coil position), or it is not identical to previous coil(s)
                if (!getLevel().getBlockState(targetPos).getBlock().defaultBlockState().equals(targetCoilBlock.defaultBlockState())) {
                    //indicate failure of solid coil structure through >0 value. Stores relative position of failure in int (kind of pointless now; was for old code that got pos from this)
                    return i * columnCount + j -2;
                };
            }

            targetPos.move(back); //go back one row
            targetPos.move(right.getOpposite(), columnCount); //reset to leftmost center position +1 unit left due to order of traversal inside nested loop
        }

        return -1; //no checks failed
    }

    private void updateStructureDimensions() {
        Level world = getLevel();
        Direction front = this.getFrontFacing();
        Direction back = front.getOpposite();
        Direction right = front.getCounterClockWise();
        Direction left = right.getOpposite();

        //distance to use when located edges of structure, moved inwards to container block portion for detection purposes
        BlockPos.MutableBlockPos lPos = getPos().relative(back, 2).mutable();
        BlockPos.MutableBlockPos rPos = getPos().relative(back, 2).mutable();
        BlockPos.MutableBlockPos bPos = getPos().relative(back).mutable();

        //zero on both lDist and rDist indicates 1 column
        int lDist = -1;
        int rDist = -1;
        int bDist = -1;

        //find when container block section is exited left, right, and back
        for (int i = 1; i < MAX_COLUMNS + 1; i++) {
            if (lDist == -1 && !isBlockEdge(world, lPos, left)) lDist += i; //0 -> immediate left is !container
            if (rDist == -1 && !isBlockEdge(world, rPos, right)) rDist += i; //0 -> immediate left is !container
            if (bDist == -1 && !isBlockEdge(world, bPos, back)) bDist += i; //0 -> no container block section
            if (lDist != -1 && rDist != -1 && bDist != -1) break;
        }

        //if l or r dist exceed max, or if bdist exceeds max/ is 0, or if l and r dist individually don't exceed max, but produce a columnCount > max
        if (lDist < 0 || rDist < 0 || bDist < 1 || lDist + rDist + 1 > MAX_COLUMNS) {
            this.isFormed = false;
            return;
        }

        //r,l dist = #container blocks in respective dir. +1 for controller block
        this.columnCount = rDist + lDist + 1;
        this.rowCount = bDist; //"Depth" of container blocks
        this.controllerPosition = lDist; //if there are no blocks to the left controller is left most spot
    }

    private boolean isBlockEdge(@NotNull Level world, @NotNull BlockPos.MutableBlockPos pos,
                                @NotNull Direction direction) {
        BlockState blockState = world.getBlockState(pos.move(direction));
        if (blockState == SuSyBlocks.EVAPORATION_BED.getDefaultState()) return true;

        for (Map.Entry<ICoilType, Supplier<CoilBlock>> entry : GTCEuAPI.HEATING_COILS.entrySet()) {
            if (blockState.is(entry.getValue().get())) return true;
        }

        return false;
    }

    private String[] centerRowsPattern() {
        //rows are done with custom logic due to coil placement; only bottom layer
        String[] containerRows = new String[rowCount];
        final String[] flooring = {"G", "C"};

        //i = row number, j = col number goes from closer rows to further rows
        for (int i = 0; i < rowCount; ++i) {
            //construct row builder for i'th row, setting first two entries to edge blocks
            StringBuilder containerRowBuilder = new StringBuilder(columnCount + 4);
            containerRowBuilder.replace(0, 2, "EE");

            for (int j = 2; j < columnCount + 2; ++j) {
                //if even (least sig bit [2^0] is 0) then do coil column
                if ((j & 1) == 0) {
                    //coil columns always have coils at their position
                    containerRowBuilder.replace(j, j + 1, "C");
                } else if ((j - 2 & 3) == 1) { //if j % 4 == 1, then do further crossover column
                    //if on last row (++i = rowCount) use "C" [1], otherwise use "G" [0]
                    containerRowBuilder.replace(j, j + 1, flooring[(i + 1) / rowCount]);
                } else { //if j % 4 == 3, then do closer crossover column
                    //if on first row then use "C" [1], otherwise use "G" [0] (0 is only number which is non neg after * -1. this means bit flip keeps most sig as 1)
                    containerRowBuilder.replace(j, j + 1, flooring[(~(i * -1)) >>> 31]);
                }
            }

            //place edge blocks in last two positions, then store current row
            containerRowBuilder.replace(columnCount + 2, columnCount + 4, "EE");
            containerRows[i] = containerRowBuilder.toString();
        }

        return containerRows;
    }

    private static String repeat(String s, int count) {
        if (s.length() == 0 || count < 1) {
            return "";
        }
        if (count == 1) {
            return s;
        }

        //create empty char array, convert to string which places null terminators in all its positions, then replace all
        return new String(new char[count * s.length()]).replace("\0", s);
    }
}
