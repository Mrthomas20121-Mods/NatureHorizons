package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.mantle.recipe.data.IRecipeHelper;

import java.util.function.Consumer;

public class NatureHorizonsRecipeProvider extends RecipeProvider implements IRecipeHelper, ICommonRecipeHelper {

    public NatureHorizonsRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        woodCrafting(consumer, NatureHorizonsBlocks.ASPEN, "aspen");
        woodCrafting(consumer, NatureHorizonsBlocks.BLACKWOOD, "blackwood");
        woodCrafting(consumer, NatureHorizonsBlocks.JUNIPER, "juniper");
        woodCrafting(consumer, NatureHorizonsBlocks.PINE, "pine");

        simpleCookingRecipe(consumer, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 500,
                NatureHorizonsItems.JUNIPER_BERRY.get(), NatureHorizonsItems.GRILLED_JUNIPER_BERRY.get(), 0.35f);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, NatureHorizonsItems.GOLDEN_JUNIPER_BERRY.get())
                .define('G', Tags.Items.NUGGETS_GOLD)
                .define('J', NatureHorizonsItems.JUNIPER_BERRY.get())
                .pattern("GGG")
                .pattern("GJG")
                .pattern("GGG")
                .unlockedBy(getHasName(NatureHorizonsItems.JUNIPER_BERRY.get()), has(NatureHorizonsItems.JUNIPER_BERRY.get()))
                .save(consumer);
    }

    @Override
    public @NotNull String getModId() {
        return NatureHorizons.MOD_ID;
    }
}
