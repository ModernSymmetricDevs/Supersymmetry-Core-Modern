package belletti.supersymmetry.common.data;

import belletti.supersymmetry.data.recipe.conditions.BackFacingCondition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class SuSyRecipeConditions {
    public static void init() {
        GTRegistries.RECIPE_CONDITIONS.register(BackFacingCondition.INSTANCE.getType(), BackFacingCondition.class);
    }
}
