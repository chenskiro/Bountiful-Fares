package com.xueluoanping.bountifulfaresforge.api.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public abstract class ModNameRecipeProvider extends RecipeProvider {
    
    public ModNameRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(pOutput,registries);
    }

    public final String getSelfName() {
        return "Recipes : %s".formatted(this.getClass().getName());
    }
}
