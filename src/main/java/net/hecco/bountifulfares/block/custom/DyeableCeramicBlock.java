package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.registry.content.BFItems;
// import net.minecraft.component.DataComponentTypes;
// import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY;

public class DyeableCeramicBlock {

    public static BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableCeramicBlockEntity(pos, state);
    }

    public static ItemStack getPickStack(BlockGetter world, BlockPos pos, Block block) {
        if (DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = new ItemStack(block);
            DyeableCeramicBlockEntity blockEntity = CERAMIC_TILES_BLOCK_ENTITY.getBlockEntity(world, pos);
            int color;
            if (blockEntity != null) {
                color = blockEntity.color;
            } else {
                color = DyeableCeramicBlockEntity.DEFAULT_COLOR;
            }
            // stack.set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(color, true));
            CompoundTag subNbt = stack.getOrCreateTagElement(ArtisanBrushItem.DISPLAY_KEY);
            subNbt.putInt(ArtisanBrushItem.COLOR_KEY, color);
            return stack;
        } else {
            return new ItemStack(block);
        }
    }

    public static InteractionResult onUse(BlockState state, Level world, BlockPos pos, Player player, Block block) {
        ItemStack itemStack = player.getItemInHand(player.getUsedItemHand());
        if (itemStack.is(BFItems.ARTISAN_BRUSH) && !player.isShiftKeyDown()
                && itemStack.getTag() != null && itemStack.getTag().contains(ArtisanBrushItem.DISPLAY_KEY)
                && itemStack.getTag().getCompound(ArtisanBrushItem.DISPLAY_KEY).contains(ArtisanBrushItem.COLOR_KEY)
            // && itemStack.get(DataComponentTypes.DYED_COLOR) != null
        ) {
            // int brushColor = itemStack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            int brushColor = itemStack.getTag().getCompound(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY);
            world.removeBlock(pos, false);
            world.setBlockAndUpdate(pos, block.withPropertiesOf(state));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                dyeableCeramicBlockEntity.color = brushColor;
                dyeableCeramicBlockEntity.setChanged();
                return InteractionResult.SUCCESS;

            }
        }
        if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = player.getItemInHand(player.getUsedItemHand()).getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                int brushColor = CompatUtil.getIntColorFromPaintbrush(item);
                if (brushColor != 1) {
                    world.removeBlock(pos, false);
                    world.setBlockAndUpdate(pos, block.withPropertiesOf(state));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                    if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                        dyeableCeramicBlockEntity.color = brushColor;
                        dyeableCeramicBlockEntity.setChanged();
                        return InteractionResult.SUCCESS;

                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
}
