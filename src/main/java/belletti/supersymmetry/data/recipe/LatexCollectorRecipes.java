package belletti.supersymmetry.data.recipe;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.data.recipe.conditions.BackFacingCondition;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static belletti.supersymmetry.common.data.SuSyRecipeTypes.LATEX_COLLECTOR_RECIPES;
import static belletti.supersymmetry.common.data.materials.SuSyMaterials.Latex;
import static belletti.supersymmetry.common.data.materials.groovy.GroovySuSyMaterials.Resin;
import static com.gregtechceu.gtceu.api.GTValues.LV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DistilledWater;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Water;
import static com.gregtechceu.gtceu.common.data.GTBlocks.RUBBER_LOG;

public class LatexCollectorRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        LATEX_COLLECTOR_RECIPES.recipeBuilder(Supersymmetry.id("fluid_latex"))
                .notConsumableFluid(Water.getFluid(10))
                .outputFluids(Latex.getFluid(100))
                .EUt(VA[LV])
                .duration(20)
                .addCondition(new BackFacingCondition(RUBBER_LOG.get()))
                .save(provider);

        LATEX_COLLECTOR_RECIPES.recipeBuilder(Supersymmetry.id("resin"))
                .notConsumableFluid(DistilledWater.getFluid(10))
                .outputFluids(Resin.getFluid(100))
                .EUt(VA[LV])
                .duration(20)
                .addCondition(new BackFacingCondition(new Block[]{Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG, Blocks.OAK_LOG, Blocks.SPRUCE_LOG}))
                .save(provider);

        LATEX_COLLECTOR_RECIPES.recipeBuilder(Supersymmetry.id("resin"))
                .notConsumableFluid(GTMaterials.Lubricant.getFluid(10))
                .outputFluids(Resin.getFluid(100))
                .EUt(VA[LV])
                .duration(20)
                .addCondition(new BackFacingCondition(new Block[]{Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG}))
                .save(provider);
    }
}
