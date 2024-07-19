package belletti.supersymmetry.common.recipes;

import belletti.supersymmetry.common.block.SuSyStoneBlockType;
import belletti.supersymmetry.common.data.SuSyBlocks;
import belletti.supersymmetry.common.materials.SuSyMaterials;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTItems.SHAPE_EXTRUDER_BLOCK;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class StoneRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        List<ItemStack> stones = SuSyBlocks.STONE_BLOCKS.row(SuSyStoneBlockType.STONE).values().stream().map(ItemStack::new)
                .toList();
        List<ItemStack> cobbles = SuSyBlocks.STONE_BLOCKS.row(SuSyStoneBlockType.COBBLE).values().stream().map(ItemStack::new)
                .toList();
        List<ItemStack> bricks = SuSyBlocks.STONE_BLOCKS.row(SuSyStoneBlockType.BRICKS).values().stream().map(ItemStack::new)
                .toList();

        registerSmoothRecipe(provider, cobbles, stones);
        registerCobbleRecipe(provider, stones, cobbles);
        registerCobbleSmashingRecipe(provider, stones, cobbles);
        registerMacerationToStoneDustRecipe(provider);
    }

    private static void registerCobbleSmashingRecipe(Consumer<FinishedRecipe> provider, List<ItemStack> smoothStack, List<ItemStack> cobbleStack) {
        for (int i = 0; i < smoothStack.size(); i++) {
            ResourceLocation smoothId = BuiltInRegistries.ITEM.getKey(smoothStack.get(i).getItem());
            VanillaRecipeHelper.addShapedRecipe(provider,
                    smoothId.getPath() + "_hammer_smashing",
                    cobbleStack.get(i),
                    new Object[]{"hS", 'S', smoothStack.get(i)});
        }
    }

    private static void registerCobbleRecipe(Consumer<FinishedRecipe> provider, List<ItemStack> stoneStack,
                                             List<ItemStack> cobbleStack) {
        for (int i = 0; i < stoneStack.size(); i++) {
            ResourceLocation cobbleId = BuiltInRegistries.ITEM.getKey(cobbleStack.get(i).getItem());
            FORGE_HAMMER_RECIPES.recipeBuilder("hammer_" + cobbleId.getPath())
                    .inputItems(stoneStack.get(i))
                    .outputItems(cobbleStack.get(i))
                    .duration(12).EUt(4).save(provider);
        }
    }

    private static void registerSmoothRecipe(Consumer<FinishedRecipe> provider, List<ItemStack> roughStack,
                                             List<ItemStack> stoneStack) {
        for (int i = 0; i < roughStack.size(); i++) {
            ResourceLocation stoneId = BuiltInRegistries.ITEM.getKey(stoneStack.get(i).getItem());
            VanillaRecipeHelper.addSmeltingRecipe(provider, "smelt_" + stoneId.getPath(), roughStack.get(i),
                    stoneStack.get(i), 0.1f);

            EXTRUDER_RECIPES.recipeBuilder("extrude_" + stoneId.getPath())
                    .inputItems(roughStack.get(i))
                    .notConsumable(SHAPE_EXTRUDER_BLOCK.asStack())
                    .outputItems(stoneStack.get(i))
                    .duration(24).EUt(8).save(provider);
        }
    }

    private static void registerMacerationToStoneDustRecipe(Consumer<FinishedRecipe> provider) {
        MACERATOR_RECIPES.recipeBuilder("macerate_gabbro")
                .inputItems(SuSyBlocks.GABBRO.asItem())
                .outputItems(dust, SuSyMaterials.Gabbro)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_gneiss")
                .inputItems(SuSyBlocks.GNEISS.asItem())
                .outputItems(dust, SuSyMaterials.Gneiss)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_limestone")
                .inputItems(SuSyBlocks.LIMESTONE.asItem())
                .outputItems(dust, SuSyMaterials.Limestone)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_phyllite")
                .inputItems(SuSyBlocks.PHYLLITE.asItem())
                .outputItems(dust, SuSyMaterials.Phyllite)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_quartzite")
                .inputItems(SuSyBlocks.QUARTZITE.asItem())
                .outputItems(dust, GTMaterials.Quartzite)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_shale")
                .inputItems(SuSyBlocks.SHALE.asItem())
                .outputItems(dust, SuSyMaterials.Shale)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_stale")
                .inputItems(SuSyBlocks.SLATE.asItem())
                .outputItems(dust, SuSyMaterials.Slate)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_soapstone")
                .inputItems(SuSyBlocks.SOAPSTONE.asItem())
                .outputItems(dust, GTMaterials.Soapstone)
                .save(provider);


        MACERATOR_RECIPES.recipeBuilder("macerate_kimberlite")
                .inputItems(SuSyBlocks.KIMBERLITE.asItem())
                .outputItems(dust, SuSyMaterials.Kimberlite)
                .save(provider);

    }
}
