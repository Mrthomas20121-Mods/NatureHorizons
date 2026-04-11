package mrthomas20121.nature_horizons.datagen;

import mrthomas20121.nature_horizons.NatureHorizons;
import mrthomas20121.nature_horizons.init.NatureHorizonsBlocks;
import mrthomas20121.nature_horizons.init.NatureHorizonsItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
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
        woodCrafting(consumer, NatureHorizonsBlocks.BLACK_WALNUT, "black_walnut");
        woodCrafting(consumer, NatureHorizonsBlocks.BLACKWOOD, "blackwood");
        woodCrafting(consumer, NatureHorizonsBlocks.JUNIPER, "juniper");
        woodCrafting(consumer, NatureHorizonsBlocks.PINE, "pine");

        simpleCookingRecipe(consumer, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 500,
                NatureHorizonsItems.JUNIPER_BERRY.get(), NatureHorizonsItems.GRILLED_JUNIPER_BERRY.get(), 0.35f);

        simpleCookingRecipe(consumer, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 400,
                NatureHorizonsItems.WALNUT.get(), NatureHorizonsItems.ROASTED_WALNUT.get(), 0.35f);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, NatureHorizonsItems.GOLDEN_JUNIPER_BERRY.get())
                .define('G', Tags.Items.NUGGETS_GOLD)
                .define('J', NatureHorizonsItems.JUNIPER_BERRY.get())
                .pattern("GGG")
                .pattern("GJG")
                .pattern("GGG")
                .unlockedBy(getHasName(NatureHorizonsItems.JUNIPER_BERRY.get()), has(NatureHorizonsItems.JUNIPER_BERRY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, NatureHorizonsItems.GOLDEN_WALNUT.get())
                .define('G', Tags.Items.NUGGETS_GOLD)
                .define('J', NatureHorizonsItems.WALNUT.get())
                .pattern("GGG")
                .pattern("GJG")
                .pattern("GGG")
                .unlockedBy(getHasName(NatureHorizonsItems.WALNUT.get()), has(NatureHorizonsItems.WALNUT.get()))
                .save(consumer);

        boat(consumer, NatureHorizonsItems.ASPEN_BOAT.get(), NatureHorizonsItems.ASPEN_CHEST_BOAT.get(), NatureHorizonsBlocks.ASPEN.get());
        boat(consumer, NatureHorizonsItems.BLACK_WALNUT_BOAT.get(), NatureHorizonsItems.BLACK_WALNUT_CHEST_BOAT.get(), NatureHorizonsBlocks.BLACK_WALNUT.get());
        boat(consumer, NatureHorizonsItems.BLACKWOOD_BOAT.get(), NatureHorizonsItems.BLACKWOOD_CHEST_BOAT.get(), NatureHorizonsBlocks.BLACKWOOD.get());
        boat(consumer, NatureHorizonsItems.JUNIPER_BOAT.get(), NatureHorizonsItems.JUNIPER_CHEST_BOAT.get(), NatureHorizonsBlocks.JUNIPER.get());
        boat(consumer, NatureHorizonsItems.PINE_BOAT.get(), NatureHorizonsItems.PINE_CHEST_BOAT.get(), NatureHorizonsBlocks.PINE.get());
    }

    private void boat(Consumer<FinishedRecipe> consumer, Item boatItem, Item chestBoatItem, Block planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, boatItem)
                .define('P', planks)
                .pattern("P P")
                .pattern("PPP")
                .unlockedBy(getHasName(planks), has(planks))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, chestBoatItem)
                .requires(Tags.Items.CHESTS_WOODEN)
                .requires(boatItem)
                .unlockedBy(getHasName(planks), has(planks))
                .save(consumer);
    };

    protected static void simpleCookingRecipe(Consumer<FinishedRecipe> p_249398_, String p_249709_, RecipeSerializer<? extends AbstractCookingRecipe> p_251876_, int p_249258_, ItemLike p_250669_, ItemLike p_250224_, float p_252138_) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(p_250669_), RecipeCategory.FOOD, p_250224_, p_252138_, p_249258_, p_251876_).unlockedBy(getHasName(p_250669_), has(p_250669_)).save(p_249398_, NatureHorizons.getResource(getItemName(p_250224_) + "_from_" + p_249709_));
    }

    @Override
    public @NotNull String getModId() {
        return NatureHorizons.MOD_ID;
    }
}
