package belletti.supersymmetry.common.recipes;

import belletti.supersymmetry.api.data.tag.SuSyTagPrefix;
import belletti.supersymmetry.common.data.SuSyItems;
import belletti.supersymmetry.common.data.SuSyRecipeTypes;
import belletti.supersymmetry.common.materials.SuSyMaterialFlags;
import belletti.supersymmetry.common.materials.properties.FiberProperty;
import belletti.supersymmetry.common.materials.properties.SuSyPropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.data.recipe.generated.RecyclingRecipeHandler;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;

public class SuSyMaterialRecipeHandler {
    public static void init(Consumer<FinishedRecipe> provider) {
        SuSyTagPrefix.catalystBed.executeHandler(provider, PropertyKey.DUST, SuSyMaterialRecipeHandler::processCatalystBed);
        SuSyTagPrefix.catalystPellet.executeHandler(provider, PropertyKey.DUST, SuSyMaterialRecipeHandler::processCatalystPellet);
//        SuSyTagPrefix.sheetedFrame.executeHandler(provider, PropertyKey.DUST, SuSyMaterialRecipeHandler::processSheetedFrame);
//        SuSyTagPrefix.sheetedFrame.executeHandler(provider, PropertyKey.DUST, RecyclingRecipeHandler::processCrushing);
        SuSyTagPrefix.fiber.executeHandler(provider, SuSyPropertyKey.FIBER, SuSyMaterialRecipeHandler::processFiber);
        SuSyTagPrefix.thread.executeHandler(provider, SuSyPropertyKey.FIBER, SuSyMaterialRecipeHandler::processThread);
        SuSyTagPrefix.thread.executeHandler(provider, SuSyPropertyKey.FIBER, SuSyMaterialRecipeHandler::processThreadWeaving);
        SuSyTagPrefix.fiber.executeHandler(provider, PropertyKey.DUST, RecyclingRecipeHandler::processCrushing);
        SuSyTagPrefix.thread.executeHandler(provider, PropertyKey.DUST, RecyclingRecipeHandler::processCrushing);
    }

    public static void processCatalystBed(TagPrefix catalystBedPrefix, Material material, DustProperty property,
                                          Consumer<FinishedRecipe> provider) {
        if (material.hasFlag(SuSyMaterialFlags.GENERATE_CATALYST_BED)) {
            VanillaRecipeHelper.addShapedRecipe(provider,
                    String.format("catalyst_bed_%s", material.getName()),
                    ChemicalHelper.get(catalystBedPrefix, material, 1),
                    " S ", "SCS",  " S ",
                    'S', new UnificationEntry(SuSyTagPrefix.catalystPellet, material),
                    'C', SuSyItems.CATALYST_BED_SUPPORT_GRID);

            GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("assembler_" + material.getName() + "_to_catalyst_bed_support_grid")
                    .inputItems(SuSyTagPrefix.catalystPellet, material, 4)
                    .inputItems(SuSyItems.CATALYST_BED_SUPPORT_GRID)
                    .outputItems(catalystBedPrefix, material, 1)
                    .EUt(VA[ULV]).duration(64)
                    .save(provider);
        }
    }

    public static void processCatalystPellet(TagPrefix catalystPelletPrefix, Material material, DustProperty property,
                                             Consumer<FinishedRecipe> provider) {
        if (material.hasFlag(SuSyMaterialFlags.GENERATE_CATALYST_PELLET)) {
            GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder("extruder_" + material.getName() + "_to_catalyst_pellet")
                    .inputItems(TagPrefix.dust, material, 1)
                    .notConsumable(GTItems.SHAPE_EXTRUDER_BOLT)
                    .outputItems(catalystPelletPrefix, material, 4)
                    .EUt(VA[ULV]).duration(64)
                    .save(provider);
        }
    }

    public static void processFiber(TagPrefix fiberPrefix, Material material, FiberProperty property,
                                    Consumer<FinishedRecipe> provider) {
        if (property.solutionSpun) {
            SuSyRecipeTypes.DRYER_RECIPES.recipeBuilder("dryer_" + material.getName() + "_wet_fiber_to_fiber")
                    .inputItems(SuSyTagPrefix.wetFiber, material, 8)
                    .outputItems(fiberPrefix, material, 8)
                    .duration(20)
                    .EUt(VA[HV])
                    .save(provider);
        }
    }

    public static void processThread(TagPrefix threadPrefix, Material material, FiberProperty property,
                                     Consumer<FinishedRecipe> provider) {
        SuSyRecipeTypes.SPINNING_RECIPES.recipeBuilder("spinning_" + material.getName() + "_fiber_to_thread")
                .inputItems(SuSyTagPrefix.fiber, material, 4)
                .inputFluids(GTMaterials.Air.getFluid(100))
                .outputItems(threadPrefix, material, 1)
                .duration(20)
                .EUt(VA[LV])
                .save(provider);
    }

    public static void processThreadWeaving(TagPrefix threadPrefix, Material material, FiberProperty property,
                                            Consumer<FinishedRecipe> provider) {
        if (material.hasFlag(MaterialFlags.GENERATE_PLATE)) {
            GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("assembler_" + material.getName() + "_thread_to_plate")
                    .circuitMeta(1)
                    .inputItems(threadPrefix, material, 8)
                    .outputItems(TagPrefix.plate, material, 1)
                    .duration(20)
                    .EUt(VA[LV])
                    .save(provider);
        }
    }

    public static void processSheetedFrame(TagPrefix sheetedFramePrefix, Material material, DustProperty property,
                                           Consumer<FinishedRecipe> provider) {
        if (material.hasFlag(MaterialFlags.GENERATE_FRAME)) {
            VanillaRecipeHelper.addShapedRecipe(provider,
                    String.format("%s_sheeted_frame", material.getName()),
                    ChemicalHelper.get(sheetedFramePrefix, material, 12),
                    "PFP",
                    "PHP",
                    "PFP",
                    'P', new UnificationEntry(TagPrefix.plate, material),
                    'F', new UnificationEntry(TagPrefix.frameGt, material),
                    'H', GTToolType.HARD_HAMMER);

            GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("assembler_" + material.getName() + "_to_sheeted_frame")
                    .inputItems(TagPrefix.plate, material, 3)
                    .inputItems(TagPrefix.frameGt, material, 1)
                    .outputItems(sheetedFramePrefix, material, 6)
                    .EUt(7)
                    .duration(225)
                    .circuitMeta(10)
                    .save(provider);
        }
    }

}
