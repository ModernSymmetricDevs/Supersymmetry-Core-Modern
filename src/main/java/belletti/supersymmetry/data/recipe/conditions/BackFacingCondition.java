package belletti.supersymmetry.data.recipe.conditions;

import belletti.supersymmetry.Supersymmetry;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import lombok.NoArgsConstructor;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@NoArgsConstructor
public class BackFacingCondition extends RecipeCondition {
    public final static BackFacingCondition INSTANCE = new BackFacingCondition();
    // @REFACTOR: targetBlockNames is a terrible var name, as well the implementation itself is disgusting
    // however I don't want to spend time right now figuring out the proper way to Encode/Decode block registries
    // through GSON / JSON. So that's it.
    private String[] targetBlockNames = new String[]{"dummy"};

    public BackFacingCondition(Block targetBlockName) {
        this.targetBlockNames = new String[]{targetBlockName.getName().getString()};
    }

    public BackFacingCondition(Block[] targetBlocks) {
        this.targetBlockNames = Arrays.stream(targetBlocks).map(block -> block.getName().getString()).toArray(String[]::new);
    }

    // @TODO: implement a constructor that receives a TagElement, such as minecraft:logs
    // IDK, just find a way to implement wildcard stuff such as "*_log"

    @Override
    public String getType() {
        return "facingBlock";
    }

    @Override
    public boolean isOr() {
        return true;
    }

    @Override
    public Component getTooltips() {
        String blockNames = String.join(", ", this.targetBlockNames);
        return Component.literal(LocalizationUtils.format("Blocks: %s", blockNames));
    }

    public String[] getBlocks() {
        return targetBlockNames;
    }

    @Override
    public boolean test(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        Direction back = recipeLogic.machine.self().getFrontFacing().getOpposite();
        Block block = recipeLogic.machine.self().getLevel().getBlockState(recipeLogic.machine.self().getPos().offset(back.getNormal())).getBlock();
        String blockName = block.getName().getString();
        return Arrays.asList(this.targetBlockNames).contains(blockName);
    }

    @Override
    public RecipeCondition createTemplate() {
        return new BackFacingCondition();
    }

    @NotNull
    @Override
    public JsonObject serialize() {
        JsonObject config = super.serialize();
        JsonArray jsonArray = new JsonArray();
        for (String blockName : targetBlockNames) {
            jsonArray.add(blockName);
        }
        config.add("targetBlockNames", jsonArray);
        return config;
    }

    @Override
    public RecipeCondition deserialize(@NotNull JsonObject config) {
        super.deserialize(config);
        JsonArray jsonArray = GsonHelper.getAsJsonArray(config, "targetBlockNames");
        targetBlockNames = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            targetBlockNames[i] = jsonArray.get(i).getAsString();
        }
        return this;
    }

    @Override
    public RecipeCondition fromNetwork(FriendlyByteBuf buf) {
        super.fromNetwork(buf);
        int size = buf.readInt();
        targetBlockNames = new String[size];
        for (int i = 0; i < size; i++) {
            targetBlockNames[i] = buf.readUtf();
        }
        return this;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf) {
        super.toNetwork(buf);
        buf.writeInt(targetBlockNames.length);
        for (String blockName : targetBlockNames) {
            buf.writeUtf(blockName);
        }
    }
}
