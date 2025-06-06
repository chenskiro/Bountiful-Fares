package net.hecco.bountifulfares.datagen.recipe;

import com.google.gson.JsonObject;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class FermentingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final ItemLike ingredient;
    private final int count;
    private final int particleColor;
    private final Map<String, CriterionTriggerInstance> criteria = new LinkedHashMap();
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
    public FermentingRecipeBuilder unlockedBy(String string, CriterionTriggerInstance pCriterionTrigger) {
        this.criteria.put(string, pCriterionTrigger);
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
    public void save(Consumer<FinishedRecipe>  exporter, ResourceLocation recipeId) {
        Advancement.Builder builder = Advancement.Builder.recipeAdvancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .requirements(RequirementsStrategy.OR);
        Objects.requireNonNull(builder);
        FermentationRecipe fermentationRecipe = (FermentationRecipe) this.recipeFactory.create(recipeId,
                this.ingredient.asItem().getDefaultInstance(),
                this.count, Ingredient.of(this.result), this.particleColor);
        exporter.accept(new Result(recipeId, fermentationRecipe,result, builder.build(recipeId.withPrefix("recipes/"))));
    }

    @Override
    public void save(Consumer<FinishedRecipe> exporter) {
        this.save(exporter, BuiltInRegistries.ITEM.getKey(getResult()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(ingredient.asItem()).getPath() + "_fermenting");
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;

        private final RecipeSerializer<?> serializer = BFRecipes.FERMENTING_SERIALIZER;
        private final FermentationRecipe fermentationRecipe;
        private final Item result;
        private @Nullable Advancement advancement;


        public Result(ResourceLocation recipeId, FermentationRecipe fermentationRecipe, Item result, Advancement advancement) {
            this.id =recipeId;
            this.fermentationRecipe =fermentationRecipe;
            this.advancement =advancement;
            this.result=result;
        }


        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonObject outputJson = new JsonObject();
            outputJson.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
            outputJson.addProperty("result_count", 1);
            json.add("result", outputJson);
            json.add("ingredient", Ingredient.merge(fermentationRecipe.getIngredients()).toJson());
            json.addProperty("particle_color", fermentationRecipe.getParticleColor());
        }


        @Override
        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return this.serializer;
        }

        @Override
        public @org.jetbrains.annotations.Nullable JsonObject serializeAdvancement() {
            return this.advancement != null ? this.advancement.deconstruct().serializeToJson() : null;
        }

        @Override
        public @org.jetbrains.annotations.Nullable ResourceLocation getAdvancementId() {
            return  new ResourceLocation(id.getNamespace(), "recipes/" + id.getPath());
        }
    }
}
