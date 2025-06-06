package net.hecco.bountifulfares.datagen.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
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

import net.minecraft.data.recipes.FinishedRecipe;

public class MillingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final ItemLike ingredient;
    private final int count;
    private final Map<String, CriterionTriggerInstance> criteria = new LinkedHashMap();
    private final MillingRecipe.RecipeFactory<?> recipeFactory;

    public MillingRecipeBuilder(ItemLike ingredient, ItemLike output, int count, MillingRecipe.RecipeFactory<?> recipeFactory) {
        this.ingredient = ingredient;
        this.result = output.asItem();
        this.count = count;
        this.recipeFactory = recipeFactory;
    }

    public static <T extends MillingRecipe> MillingRecipeBuilder create(Item input, ItemLike output, int count) {
        return new MillingRecipeBuilder(input, output, count, MillingRecipe::new);
    }

    @Override
    public MillingRecipeBuilder unlockedBy(String string, CriterionTriggerInstance advancementCriterion) {
        this.criteria.put(string, advancementCriterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }


    @Override
    public void save(Consumer<FinishedRecipe> exporter, ResourceLocation recipeId) {
        Advancement.Builder builder = Advancement.Builder.recipeAdvancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .requirements(RequirementsStrategy.OR);
        Objects.requireNonNull(builder);
        MillingRecipe millingRecipe = (MillingRecipe) this.recipeFactory.create(recipeId, this.result.getDefaultInstance(), NonNullList.withSize(1, Ingredient.of(this.ingredient)));
        exporter.accept(new Result(recipeId, millingRecipe, result, builder.build(recipeId.withPrefix("recipes/"))));
    }

    @Override
    public void save(Consumer<FinishedRecipe> exporter) {
        this.save(exporter, BuiltInRegistries.ITEM.getKey(getResult()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(this.ingredient.asItem()).getPath() + "_milling");
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;

        private final RecipeSerializer<?> serializer = BFRecipes.MILLING_SERIALIZER;
        private final MillingRecipe millingRecipe;
        private final Item result;
        private @Nullable Advancement advancement;


        public Result(ResourceLocation recipeId, MillingRecipe millingRecipe, Item result, Advancement advancement) {
            this.id = recipeId;
            this.millingRecipe = millingRecipe;
            this.advancement = advancement;
            this.result = result;
        }


        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonObject outputJson = new JsonObject();
            outputJson.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
            json.add("output", outputJson);
            JsonArray ingredientsJson = new JsonArray();
            for (Ingredient ingredient : millingRecipe.getIngredients()) {
                ingredientsJson.add(ingredient.toJson());
            }
            json.add("ingredients", ingredientsJson);

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
            return new ResourceLocation(id.getNamespace(), "recipes/" + id.getPath());
        }
    }
}
