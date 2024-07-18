package belletti.supersymmetry;

import belletti.supersymmetry.api.data.tag.SuSyTagPrefix;
import belletti.supersymmetry.api.registries.SuSyRegistries;
import belletti.supersymmetry.common.data.*;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Consumer;

@GTAddon
public class SuSyGTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return SuSyRegistries.REGISTRATE;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return Supersymmetry.MOD_ID;
    }

    @Override
    public void registerElements() {
        IGTAddon.super.registerElements();
    }

    @Override
    public void registerCovers() {
        SuSyCovers.init();
        SuSyItems.init();
    }

//    @Override
//    public void registerWorldgenLayers() {
//        SuSyWorldGenLayers.init();
//    }

    @Override
    public boolean requiresHighTier() {
        return false;
    }

    @Override
    public void registerVeinGenerators() {
        IGTAddon.super.registerVeinGenerators();
    }

    @Override
    public void collectMaterialCasings(MaterialCasingCollectionEvent event) {
        IGTAddon.super.collectMaterialCasings(event);
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        SuSyRecipes.init(provider);
    }

    @Override
    public void registerRecipeConditions() {
        SuSyRecipeConditions.init();
    }

    @Override
    public void registerTagPrefixes() {
        SuSyTagPrefix.init();
    }
}
