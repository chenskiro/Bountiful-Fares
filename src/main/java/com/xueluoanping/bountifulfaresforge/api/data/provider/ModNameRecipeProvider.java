package com.xueluoanping.bountifulfaresforge.api.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;

public abstract class ModNameRecipeProvider extends RecipeProvider {
    
    public ModNameRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public final String getSelfName() {
        return "Recipes : %s".formatted(this.getClass().getName());
    }
}
