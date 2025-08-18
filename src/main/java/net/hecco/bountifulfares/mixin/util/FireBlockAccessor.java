package net.hecco.bountifulfares.mixin.util;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FireBlock.class)
public interface FireBlockAccessor {
    @Accessor("igniteOdds")
    Object2IntMap<Block> bountifulfares_getIgniteOdds();

    @Accessor("burnOdds")
    Object2IntMap<Block> bountifulfares_getBurnOdds();
}