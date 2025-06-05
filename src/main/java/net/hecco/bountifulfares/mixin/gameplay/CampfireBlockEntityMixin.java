package net.hecco.bountifulfares.mixin.gameplay;

import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CampfireBlockEntity.class)
public class CampfireBlockEntityMixin {

    @Unique
    @Final
    private static ItemParticleOption POP = new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(BFItems.POPPED_MAIZE));

    @Inject(method = "cookTick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Containers;dropItemStack(Lnet/minecraft/world/level/Level;DDDLnet/minecraft/world/item/ItemStack;)V"))
    private static void bf_addMaizePoppingSound(Level world, BlockPos pos, BlockState state, CampfireBlockEntity pBlockEntity, CallbackInfo ci,
                                                @Local(ordinal = 1) ItemStack itemStack) {
        if (itemStack.is(BFItems.MAIZE_SEEDS)) {
            world.playSound(null, pos, BFSounds.POPPED_MAIZE_POP, SoundSource.BLOCKS, 1.0f, 1.0f + world.random.nextFloat() / 3);
            ((ServerLevel) world).sendParticles(
                    POP,
                    pos.getCenter().x(),
                    pos.getCenter().y() + 0.2D,
                    pos.getCenter().z(),
                    8,
                    ((double) world.random.nextFloat() - 0.5),
                    ((double) world.random.nextFloat() - 0.5),
                    ((double) world.random.nextFloat() - 0.5),
                    0.1
            );
        }
    }
}