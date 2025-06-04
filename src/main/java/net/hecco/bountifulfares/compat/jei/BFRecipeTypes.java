package net.hecco.bountifulfares.compat.jei;

import mezz.jei.api.recipe.RecipeType;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.recipe.MillingRecipe;

public class BFRecipeTypes {
    public static final RecipeType<FermentationRecipe> FERMENTING = new RecipeType<>(BountifulFares.rl("fermenting"), FermentationRecipe.class);
    public static final RecipeType<MillingRecipe> MILLING = new RecipeType<>(BountifulFares.rl("milling"), MillingRecipe.class);
    public static final RecipeType<PropagationRecipe> PRISMARINE_PROPAGATION = new RecipeType<>(BountifulFares.rl("prismarine_propagation"), PropagationRecipe.class);

    public BFRecipeTypes() {
    }
}
