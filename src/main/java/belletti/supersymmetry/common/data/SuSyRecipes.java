package belletti.supersymmetry.common.data;

import belletti.supersymmetry.Supersymmetry;
import belletti.supersymmetry.common.block.BlockDeposit;
import belletti.supersymmetry.common.materials.SuSyMaterials;
import belletti.supersymmetry.common.recipes.StoneRecipes;
import belletti.supersymmetry.common.recipes.SuSyMaterialRecipeHandler;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static belletti.supersymmetry.common.data.SuSyRecipeTypes.*;
import static belletti.supersymmetry.common.materials.SuSyMaterials.Latex;

public class SuSyRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        StoneRecipes.init(provider);
        SuSyMaterialRecipeHandler.init(provider);

        // @TODO: move to groovy / kubejs, this is just a ploaceholder for testing stuff out
        COAGULATION_RECIPES.recipeBuilder(Supersymmetry.id("dustlatex"))
                .inputFluids(Latex.getFluid(1000))
                .notConsumable(TagPrefix.rod, GTMaterials.Iron)
                .outputItems(TagPrefix.dust, Latex)
                .duration(40)
                .save(provider);

        MINING_DRILL_RECIPES.recipeBuilder("dummyyyy")
                .notConsumable(SuSyBlocks.DEPOSIT_BLOCKS.get(BlockDeposit.DepositBlockType.METAMORPHIC).asStack())
                .outputItems(TagPrefix.dust, Latex)
                .duration(20)
                .EUt(30)
                .save(provider);

        EVAPORATION_POOL.recipeBuilder("dummyyyy")
                .inputFluids(SuSyMaterials.Seawater.getFluid(1000))
                .outputItems(TagPrefix.dust, Latex)
                .duration(400)
                .save(provider);

        FROTH_FLOTATION.recipeBuilder("dummyyyy")
                .inputFluids(SuSyMaterials.Seawater.getFluid(1000))
                .outputItems(TagPrefix.dust, Latex)
                .EUt(20)
                .duration(400)
                .save(provider);

        HEAT_RADIATOR_RECIPES.recipeBuilder("dummyyyy")
                .inputFluids(SuSyMaterials.Seawater.getFluid(1000))
                .duration(400)
                .save(provider);

        BATH_CONDENSER.recipeBuilder("dummyyyy")
                .inputFluids(SuSyMaterials.Seawater.getFluid(1000))
                .outputFluids(SuSyMaterials.Latex.getFluid(2000))
                .duration(200)
                .save(provider);

        LARGE_STEAM_TURBINE.recipeBuilder("dummyyyy")
                .inputFluids(GTMaterials.Steam.getFluid(1000))
                .EUt(-32)
                .duration(200)
                .save(provider);
    }
}
