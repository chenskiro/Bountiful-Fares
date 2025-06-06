package net.hecco.bountifulfares.recipe;

import com.google.gson.JsonObject;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class FermentationRecipe implements Recipe<SimpleContainer> {
    @FunctionalInterface
    public interface RecipeFactory<T> {
        T create(ResourceLocation id, ItemStack output, int outputCount, Ingredient input, int particleColor);
    }
    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient ingredient;
    private final int particleColor;

    public FermentationRecipe(ResourceLocation id, ItemStack output, int outputCount, Ingredient input, int particleColor) {
        this.id = id;
        this.output = new ItemStack(output.getItem(), outputCount);
        this.ingredient = input;
        this.particleColor = particleColor;
    }

    @Override
    public boolean matches(SimpleContainer inventory, Level world) {
        if (world.isClientSide()) {
            return false;
        }
        return ingredient.test(inventory.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer inventory, RegistryAccess registryManager) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    public int getParticleColor() {
        return particleColor;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryManager) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FermentationRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return FermentationRecipe.Type.INSTANCE;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(ingredient);
        return list;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BFBlocks.GRISTMILL.get());
    }

    public static class Type implements RecipeType<FermentationRecipe> {
        private Type() { }
        public static final FermentationRecipe.Type INSTANCE = new FermentationRecipe.Type();
        public static final String ID = "fermenting";
    }

    public static class Serializer implements RecipeSerializer<FermentationRecipe> {
        public static final FermentationRecipe.Serializer INSTANCE = new FermentationRecipe.Serializer();
        public static final String ID = "fermenting";

        @Override
        public FermentationRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));

            int outputCount = GsonHelper.getAsInt(json, "result_count");

            Ingredient ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));

            int particleColor = GsonHelper.getAsInt(json, "particle_color");

            return new FermentationRecipe(id, output, outputCount, ingredient, particleColor);
        }

        @Override
        public FermentationRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            ItemStack output = buf.readItem();

            int outputCount = buf.readInt();

            Ingredient ingredient = Ingredient.fromNetwork(buf);

            int particleColor = buf.readInt();

            return new FermentationRecipe(id, output, outputCount, ingredient, particleColor);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, FermentationRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItem(recipe.getResultItem(null));
        }
    }
}
