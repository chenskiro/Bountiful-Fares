package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBakery.class)
public abstract class ModelLoaderMixin {


    @Shadow protected abstract void loadTopLevel(ModelResourceLocation pLocation);

    @Inject(method = {"<init>"}, at = {@At(value = "RETURN")})
    private void addModels(CallbackInfo info) {
        this.loadTopLevel(new ModelResourceLocation(BountifulFares.rl( "sun_hat_head"),"inventory"));
    }
}