package net.hecco.bountifulfares.block.interfaces;

import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY;

public interface CeramicDishBlockInterface extends EntityBlock {
    @Override
    default BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicDishBlockEntity(pos, state);
    }

    default ItemStack pickBlock(BlockGetter world, BlockPos pos, ItemStack stack) {
        CeramicDishBlockEntity blockEntity = CERAMIC_DISH_BLOCK_ENTITY.get().getBlockEntity(world, pos);
        int color = CeramicDishBlockEntity.DEFAULT_COLOR;
        if (blockEntity != null) {
            color = blockEntity.color;
        }
        CompoundTag subNbt = stack.getOrCreateTagElement(ArtisanBrushItem.DISPLAY_KEY);
        subNbt.putInt(ArtisanBrushItem.COLOR_KEY, color);
        return stack;
    }

}