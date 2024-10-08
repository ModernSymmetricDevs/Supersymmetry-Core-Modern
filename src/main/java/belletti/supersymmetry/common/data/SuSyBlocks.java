package belletti.supersymmetry.common.data;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.api.block.ISinteringBrickType;
import belletti.supersymmetry.common.block.*;
import belletti.supersymmetry.data.recipe.SuSyTags;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.item.RendererBlockItem;
import com.gregtechceu.gtceu.common.data.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.impl.IModelRenderer;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;

import java.util.EnumMap;

import static belletti.supersymmetry.api.registries.SuSyRegistries.REGISTRATE;

public class SuSyBlocks {
    public static EnumMap<BlockCoolingCoil.CoolingCoilType, BlockEntry<BlockCoolingCoil>> COOLING_COIL_BLOCKS = new EnumMap<>(BlockCoolingCoil.CoolingCoilType.class);

    public static final BlockEntry<BlockSinteringBrick> SINTERING_BRICK = createSinteringBrick(BlockSinteringBrick.SinteringBrickType.BRICK);
    public static final BlockEntry<BlockSinteringBrick> SINTERING_BRICK_MAGNETOPLATED = createSinteringBrick(BlockSinteringBrick.SinteringBrickType.MAGNETOPLATED);

    public static BlockEntry<Block> COAGULATION_TANK_WALL;

    public static BlockEntry<AlternatorCoilBlock> ALTERNATOR_COIL;
    public static BlockEntry<TurbineRotorBlock> TURBINE_ROTOR;
    public static BlockEntry<SeparatorRotorBlock> SEPARATOR_ROTOR;
    public static BlockEntry<Block> DRILL_HEAD;
    public static EnumMap<BlockStructural.StructuralBlockType, BlockEntry<BlockStructural>> STRUCTURAL_BLOCKS = new EnumMap<>(BlockStructural.StructuralBlockType.class);

    public static EnumMap<BlockDeposit.DepositBlockType, BlockEntry<BlockDeposit>> DEPOSIT_BLOCKS = new EnumMap<>(BlockDeposit.DepositBlockType.class);

    public static EnumMap<BlockResource.ResourceBlockType, BlockEntry<BlockResource>> RESOURCE_BLOCKS = new EnumMap<>(BlockResource.ResourceBlockType.class);
    public static EnumMap<HomeBlock.HomeType, BlockEntry<HomeBlock>> HOME_BLOCKS = new EnumMap<>(HomeBlock.HomeType.class);
    public static EnumMap<BlockMultiblockTank.MultiblockTankType, BlockEntry<BlockMultiblockTank>> MULTIBLOCK_TANK = new EnumMap<>(BlockMultiblockTank.MultiblockTankType.class);
    public static BlockEntry<BlockEvaporationBed> EVAPORATION_BED = createEvaporationBedBlock(BlockEvaporationBed.EvaporationBedType.DIRT); //
    public static BlockEntry<BlockElectrodeAssembly> ELECTRODE_ASSEMBLY_CARBON = createElectrodeAssemblyBlock(BlockElectrodeAssembly.ElectrodeAssemblyType.CARBON);
    public static EnumMap<BlockSuSyMultiblockCasing.CasingType, BlockEntry<BlockSuSyMultiblockCasing>> SUSY_MULTIBLOCK_CASING_BLOCKS = new EnumMap<>(BlockSuSyMultiblockCasing.CasingType.class);
    public static BlockEntry<BlockSerpentine> SERPENTINE = createSerpentineBlock(BlockSerpentine.SerpentineType.BASIC);

    public static Table<SuSyStoneBlockType, SuSyStoneTypes, BlockEntry<Block>> STONE_BLOCKS;
    public static BlockEntry<Block> GABBRO;
    public static BlockEntry<Block> GNEISS;
    public static BlockEntry<Block> LIMESTONE;
    public static BlockEntry<Block> PHYLLITE;
    public static BlockEntry<Block> QUARTZITE;
    public static BlockEntry<Block> SHALE;
    public static BlockEntry<Block> SLATE;
    public static BlockEntry<Block> SOAPSTONE;
    public static BlockEntry<Block> KIMBERLITE;

    public static void init() {
        REGISTRATE.creativeModeTab(() -> SuSyCreativeModeTabs.SUSY);
        generateStoneBlocks();
        registerCoolingCoilBlocks();
        registerDecorativeStructuralBlocks();
        registerDepositBlocks();
        registerResourceBlocks();
        registerMultiblockTankBlocks();
        registerSuSyMultiblockCasingBlocks();
        registerHomeblocks();

        COAGULATION_TANK_WALL = REGISTRATE
                .block("coagulation_tank_wall", p -> (Block) new RendererBlock(p,
                        Platform.isClient() ? new IModelRenderer(Supersymmetry
                                .id("block/casings/wooden_coagulation_tank_wall"))
                                : null))
                .lang("coagulation_tank_wall")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 10.0f))
                .blockstate(NonNullBiConsumer.noop())
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();

        ALTERNATOR_COIL = REGISTRATE
                .block("alternator_coil", AlternatorCoilBlock::new)
                .lang("Alternator Coil")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 10.0f))
                .blockstate((ctx, prov) -> prov.horizontalBlock(ctx.getEntry(), new ModelFile.UncheckedModelFile(Supersymmetry.id("block/casings/alternator_coil_copper"))))
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), new ResourceLocation("item/generated"))
                        .override().model(new ModelFile.UncheckedModelFile(Supersymmetry.id("block/casings/alternator_coil_copper"))))
                .build()
                .register();

        TURBINE_ROTOR = REGISTRATE
                .block("steel_turbine_rotor", TurbineRotorBlock::new)
                .lang("Steel Turbine Block")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 10.0f))
                .blockstate((ctx, prov) -> prov.horizontalBlock(ctx.getEntry(), new ModelFile.UncheckedModelFile(Supersymmetry.id("block/casings/steel_turbine_rotor"))))
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), new ResourceLocation("item/generated"))
                        .override().model(new ModelFile.UncheckedModelFile(Supersymmetry.id("block/casings/steel_turbine_rotor"))))
                .build()
                .register();

        SEPARATOR_ROTOR = REGISTRATE
                .block("separator_rotor", SeparatorRotorBlock::new)
                .lang("separator_rotor")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 10.0f))
                .blockstate((ctx, prov) -> prov.horizontalBlock(ctx.getEntry(), new ModelFile.UncheckedModelFile(Supersymmetry.id("block/casings/separator_rotor_steel"))))
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), new ResourceLocation("item/generated"))
                        .override().model(new ModelFile.UncheckedModelFile(Supersymmetry.id("block/casings/separator_rotor_steel"))))
                .build()
                .register();

        DRILL_HEAD = REGISTRATE
                .block("drill_head", p -> (Block) new RendererBlock(p,
                        Platform.isClient() ? new IModelRenderer(Supersymmetry
                                .id("block/casings/drill_head_steel"))
                                : null))
                .lang("drill_head")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 10.0f))
                .blockstate(NonNullBiConsumer.noop())
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    public static void generateStoneBlocks() {
        ImmutableTable.Builder<SuSyStoneBlockType, SuSyStoneTypes, BlockEntry<Block>> builder = ImmutableTable.builder();
        for (SuSyStoneTypes strata : SuSyStoneTypes.values()) {
            if (!strata.generateBlocks) continue;
            for (SuSyStoneBlockType type : SuSyStoneBlockType.values()) {
                String blockId = type.blockId.formatted(strata.getSerializedName());
                if (BuiltInRegistries.BLOCK.containsKey(new ResourceLocation(blockId))) continue;
                var entry = REGISTRATE.block(blockId, Block::new)
                        .initialProperties(() -> Blocks.STONE)
                        .properties(p -> p.strength(type.hardness, type.resistance).mapColor(strata.mapColor))
                        .transform(builder2 -> builder2)
                        .tag(BlockTags.MINEABLE_WITH_PICKAXE, CustomTags.NEEDS_WOOD_TOOL)
                        .loot((tables, block) -> {
                            if (type == SuSyStoneBlockType.STONE) {
                                tables.add(block, tables.createSingleItemTableWithSilkTouch(block,
                                        STONE_BLOCKS.get(SuSyStoneBlockType.COBBLE, strata).get()));
                            } else {
                                tables.add(block, tables.createSingleItemTable(block));
                            }
                        })
                        .item()
                        .build();
                if (type == SuSyStoneBlockType.STONE && strata.isNatural()) {
                    entry.tag(BlockTags.STONE_ORE_REPLACEABLES, BlockTags.BASE_STONE_OVERWORLD,
                                    BlockTags.DRIPSTONE_REPLACEABLE, BlockTags.MOSS_REPLACEABLE)
                            .blockstate(GTModels.randomRotatedModel(Supersymmetry.id(ModelProvider.BLOCK_FOLDER + "/stones/" +
                                    strata.getSerializedName() + "/" + type.id)));
                } else {
                    entry.blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                            prov.models().singleTexture(ctx.getName(),
                                    prov.mcLoc(ModelProvider.BLOCK_FOLDER + "/cube_all"), "all",
                                    prov.modLoc(ModelProvider.BLOCK_FOLDER + "/stones/" + strata.getSerializedName() +
                                            "/" + type.id))));
                }
                builder.put(type, strata, entry.register());
            }
        }
        STONE_BLOCKS = builder.build();

        GABBRO = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.GABBRO);
        GNEISS = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.GNEISS);
        LIMESTONE = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.LIMESTONE);
        PHYLLITE = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.PHYLLITE);
        QUARTZITE = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.QUARTZITE);
        SHALE = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.SHALE);
        SLATE = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.SLATE);
        SOAPSTONE = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.SOAPSTONE);
        KIMBERLITE = STONE_BLOCKS.get(SuSyStoneBlockType.STONE, SuSyStoneTypes.KIMBERLITE);
    }

    private static void registerCoolingCoilBlocks() {
        for (BlockCoolingCoil.CoolingCoilType coilType : BlockCoolingCoil.CoolingCoilType.values()) {
            BlockEntry<BlockCoolingCoil> blockEntry = REGISTRATE
                    .block("%s_cooling_block".formatted(coilType.getName()), p -> new BlockCoolingCoil(p, coilType))
                    .lang("cooling_coil")
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .properties(p -> p
                            .isValidSpawn((state, level, pos, ent) -> false)
                            .strength(5.0f, 10.0f)
                    )
                    .addLayer(() -> RenderType::cutoutMipped)
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                    .item(RendererBlockItem::new)
                    .model(NonNullBiConsumer.noop())
//                    .onRegister(compassNodeExist(GTCompassSections.BLOCKS, "cooling_coil_block"))
                    .build()
                    .register();

            COOLING_COIL_BLOCKS.put(coilType, blockEntry);
        }
    }

    private static BlockEntry<BlockSinteringBrick> createSinteringBrick(ISinteringBrickType sinteringBrickType) {
        return REGISTRATE
                .block("sintering_brick_%s".formatted(sinteringBrickType.getName()), p -> new BlockSinteringBrick(p, sinteringBrickType))
                .lang("sintering_brick")
                .initialProperties(() -> Blocks.STONE)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .destroyTime(1f)
                )
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
//                .onRegister(compassNodeExist(GTCompassSections.BLOCKS, "sintering_brick_block"))
                .build()
                .register();
    }

    private static void registerDecorativeStructuralBlocks() {
        for (BlockStructural.StructuralBlockType structuralBlockType : BlockStructural.StructuralBlockType.values()) {
            BlockEntry<BlockStructural> blockEntry = REGISTRATE
                    .block(structuralBlockType.getName(), p -> new BlockStructural(p, structuralBlockType))
                    .initialProperties(() -> Blocks.STONE)
                    .properties(p -> p)
                    .addLayer(() -> RenderType::cutoutMipped)
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                    .item(RendererBlockItem::new)
                    .model(NonNullBiConsumer.noop())
                    .build()
                    .register();
            STRUCTURAL_BLOCKS.put(structuralBlockType, blockEntry);
        }
    }

    private static void registerDepositBlocks() {
        for (BlockDeposit.DepositBlockType depositBlockType : BlockDeposit.DepositBlockType.values()) {
            BlockEntry<BlockDeposit> blockEntry = REGISTRATE
                    .block("%s_deposit_block".formatted(depositBlockType.getName()), p -> new BlockDeposit(p, depositBlockType))
                    .lang("deposit_block")
                    .initialProperties(() -> Blocks.ANVIL)
                    .properties(p -> p.
                            strength(50.0f, 1200f)
                            .sound(SoundType.METAL)
                    )
                    .addLayer(() -> RenderType::cutoutMipped)
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .item(RendererBlockItem::new)
                    .model(NonNullBiConsumer.noop())
                    .build()
                    .register();
            DEPOSIT_BLOCKS.put(depositBlockType, blockEntry);
        }
    }

    private static void registerResourceBlocks() {
        for (BlockResource.ResourceBlockType resourceBlockType : BlockResource.ResourceBlockType.values()) {
            BlockEntry<BlockResource> blockEntry = REGISTRATE
                    .block("%s_deposit_block".formatted(resourceBlockType.getName()), p -> new BlockResource(p, resourceBlockType))
                    .initialProperties(() -> Blocks.STONE)
                    .properties(p -> p)
                    .addLayer(() -> RenderType::cutoutMipped)
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .item(RendererBlockItem::new)
                    .model(NonNullBiConsumer.noop())
                    .build()
                    .register();
            RESOURCE_BLOCKS.put(resourceBlockType, blockEntry);
        }
    }

    private static void registerMultiblockTankBlocks() {
        for (BlockMultiblockTank.MultiblockTankType type : BlockMultiblockTank.MultiblockTankType.values()) {
            BlockEntry<BlockMultiblockTank> blockEntry = REGISTRATE
                    .block("multiblock_tank_%s".formatted(type.getName()), p -> new BlockMultiblockTank(p, type))
                    .initialProperties(() -> Blocks.STONE)
                    .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                    .addLayer(() -> RenderType::cutoutMipped)
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                    .item(RendererBlockItem::new)
                    .model(NonNullBiConsumer.noop())
                    .build()
                    .register();
            MULTIBLOCK_TANK.put(type, blockEntry);
        }
    }

    private static BlockEntry<BlockElectrodeAssembly> createElectrodeAssemblyBlock(BlockElectrodeAssembly.ElectrodeAssemblyType electrodeAssemblyType) {
        return REGISTRATE
                .block("electrode_assembly_%s".formatted(electrodeAssemblyType.getName()), p -> new BlockElectrodeAssembly(p, electrodeAssemblyType))
                .lang("electrode_assembly")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(3.0f, 3.0f)
                )
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    private static BlockEntry<BlockEvaporationBed> createEvaporationBedBlock(BlockEvaporationBed.EvaporationBedType evaporationBedType) {
        return REGISTRATE
                .block("evaporation_bed_%s".formatted(evaporationBedType.getName()), p -> new BlockEvaporationBed(p, evaporationBedType))
                .lang("evaporation_bed")
                .initialProperties(() -> Blocks.CLAY)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(0.5f, 0.5f)
                        .sound(SoundType.GRAVEL)
                )
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    private static void registerSuSyMultiblockCasingBlocks() {
        for (BlockSuSyMultiblockCasing.CasingType type : BlockSuSyMultiblockCasing.CasingType.values()) {
            BlockEntry<BlockSuSyMultiblockCasing> blockEntry = REGISTRATE
                    .block("multiblock_casing_%s".formatted(type.getName()), p -> new BlockSuSyMultiblockCasing(p, type))
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .properties(p -> p
                            .isValidSpawn((state, level, pos, ent) -> false)
                            .strength(5.0f, 10.0f)
                    )
                    .addLayer(() -> RenderType::cutoutMipped)
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                    .item(RendererBlockItem::new)
                    .model(NonNullBiConsumer.noop())
                    .build()
                    .register();
            SUSY_MULTIBLOCK_CASING_BLOCKS.put(type, blockEntry);
        }
    }

    private static void registerHomeblocks() {
        for (HomeBlock.HomeType type : HomeBlock.HomeType.values()) {
            BlockEntry<HomeBlock> block = REGISTRATE
                    .block("home_block_%s".formatted(type.getResourceSuffix()), HomeBlock::new)
                    .lang(type.getName())
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .properties(p -> p
                            .isValidSpawn((state, level, pos, ent) -> false)
                            .destroyTime(0.5f))
                    .blockstate((ctx, prov) -> prov.horizontalBlock(ctx.getEntry(), new ModelFile.UncheckedModelFile(Supersymmetry.id("block/home_block/").withSuffix(type.getResourceSuffix()))))
                    .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                    .item(RendererBlockItem::new)
                    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), new ResourceLocation("item/generated"))
                            .override().model(new ModelFile.UncheckedModelFile(Supersymmetry.id("block/home_block/").withSuffix(type.getResourceSuffix()))))
                    .build()
                    .register();
            HOME_BLOCKS.put(type, block);
        }
    }

    private static BlockEntry<BlockSerpentine> createSerpentineBlock(BlockSerpentine.SerpentineType serpentineType) {
        return REGISTRATE
                .block("serpentine_block_%s".formatted(serpentineType.getName()), p -> new BlockSerpentine(p, serpentineType))
                .lang("serpentine_block")
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p
                        .isValidSpawn((state, level, pos, ent) -> false)
                        .strength(0.5f)
                )
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(SuSyTags.MINEABLE_WITH_WRENCH)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }
}
