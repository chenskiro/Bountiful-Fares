package net.hecco.bountifulfares.datagen.recipe;

import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FermentingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final ItemLike ingredient;
    private final int count;
    private final int particleColor;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    private final FermentationRecipe.RecipeFactory<?> recipeFactory;

    public FermentingRecipeBuilder(ItemLike ingredient, ItemLike output, int count, int particleColor, FermentationRecipe.RecipeFactory<?> recipeFactory) {
        this.ingredient = ingredient;
        this.result = output.asItem();
        this.count = count;
        this.particleColor = particleColor;
        this.recipeFactory = recipeFactory;
    }

    public static <T extends FermentationRecipe> FermentingRecipeBuilder create(Item input, ItemLike output, int count, int particleColor) {
        return new FermentingRecipeBuilder(input, output, count, particleColor, FermentationRecipe::new);
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public FermentingRecipeBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }


    @Override
    public void save(RecipeOutput exporter, ResourceLocation recipeId) {
        Advancement.Builder builder = Advancement.Builder.recipeAdvancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(builder);
        FermentationRecipe fermentationRecipe = this.recipeFactory.create(
                Ingredient.of(this.ingredient),
                this.result.getDefaultInstance(), this.count, this.particleColor);
        exporter.accept(recipeId, fermentationRecipe, builder.build(recipeId.withPrefix("recipes/")));
    }

    @Override
    public void save(RecipeOutput exporter) {
        this.save(exporter, BuiltInRegistries.ITEM.getKey(getResult()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(ingredient.asItem()).getPath() + "_fermenting");
    }

}
