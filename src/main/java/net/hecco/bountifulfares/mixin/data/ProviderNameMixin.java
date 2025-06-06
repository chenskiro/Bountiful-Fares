package net.hecco.bountifulfares.mixin.data;

import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameLootTableProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameRecipeProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public abstract class ProviderNameMixin {

    @Mixin(net.minecraft.data.loot.LootTableProvider.class)
    public static abstract class LootTableProviderMixin {
        @Inject(method = {"getName"},
                require = 0,
                at = {@At(value = "HEAD")}, cancellable = true)
        private void buildPatch$fixError(CallbackInfoReturnable<String> cir) {
            // fix our name
            if ((Object) this instanceof ModNameLootTableProvider mutableNameLootTableProvider)
                cir.setReturnValue(mutableNameLootTableProvider.getSelfName());
        }
    }

    @Mixin(net.minecraft.data.recipes.RecipeProvider.class)
    public static abstract class RecipeProviderMixin {
        @Inject(method = {"getName"},
                require = 0,
                at = {@At(value = "HEAD")}, cancellable = true)
        private void buildPatch$fixError(CallbackInfoReturnable<String> cir) {
            // fix our name
            if ((Object) this instanceof ModNameRecipeProvider mutableNameLootTableProvider)
                cir.setReturnValue(mutableNameLootTableProvider.getSelfName());
        }
    }
}