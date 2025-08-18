package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBakery.class)
public abstract class ModelLoaderMixin {


    @Shadow
    protected abstract void loadSpecialItemModelAndDependencies(ModelResourceLocation modelLocation);

    @Inject(method = {"<init>"}, at = {@At(value = "RETURN")})
    private void bountifulfares_addModels(CallbackInfo info) {
        this.loadSpecialItemModelAndDependencies(new ModelResourceLocation(BountifulFares.rl("sun_hat_head"), "inventory"));
    }
}