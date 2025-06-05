package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.ChatFormatting;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArtisanBrushItem extends Item implements BFDyeableLeatherItem{
    public static final String DISPLAY_KEY = "display";
    public static final String COLOR_KEY = "color";

    public static int DEFAULT_COLOR = DyeableBlockEntity.DEFAULT_COLOR;

    public ArtisanBrushItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        Player player = context.getPlayer();
        BlockState current = world.getBlockState(pos);
        int oldColor = DyeableBlockEntity.getColor(world, pos);
        ItemStack stack = context.getItemInHand();
        // DyedColorComponent component = stack.get(DataComponentTypes.DYED_COLOR);
        CompoundTag tag = stack.getTag();
        if (BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.containsKey(current.getBlock()) && oldColor != DyeableBlockEntity.DEFAULT_COLOR) {
            if ((tag != null&&tag.contains(ArtisanBrushItem.DISPLAY_KEY) ? tag.getCompound(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY)  : DEFAULT_COLOR) == oldColor) {
                world.setBlockAndUpdate(pos, BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.get(current.getBlock()).withPropertiesOf(current));
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                    ceramicTilesBlockEntity.color = oldColor;
                    ceramicTilesBlockEntity.setChanged();
                    return InteractionResult.SUCCESS;
                }
            }
        }
        if (world.getBlockEntity(pos) instanceof DyeableBlockEntity && oldColor != DyeableBlockEntity.DEFAULT_COLOR) {
            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity) {
                if (tag == null
                        || (tag.contains(ArtisanBrushItem.DISPLAY_KEY)
                   && tag.getCompound(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY) != oldColor)){
                    // context.getItemInHand().set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(oldColor, true));
                    CompoundTag subNbt = stack.getOrCreateTagElement(ArtisanBrushItem.DISPLAY_KEY);
                    subNbt.putInt(ArtisanBrushItem.COLOR_KEY, oldColor);
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.useOn(context);
    }
//        if (ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.containsKey(current.getBlock()) && Objects.requireNonNull(context.getPlayer()).isSneaking()) {
//            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity && ceramicTilesBlockEntity.color != DyeableBlockEntity.DEFAULT_COLOR) {
//                int oldColor = oldColor;
//                world.setBlockState(pos, ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.get(current.getBlock()).getStateWithProperties(current));
//                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat());
//                ceramicTilesBlockEntity.color = oldColor;
//                ceramicTilesBlockEntity.markDirty();
//                return ActionResult.SUCCESS;
//            }
//        }
//        return super.useOnBlock(context);
//    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level context, List<Component> tooltip, TooltipFlag type) {
        if (stack.getTag() == null || stack.getTag().contains(ArtisanBrushItem.DISPLAY_KEY)) {
            tooltip.add(Component.translatable("tooltip." + BountifulFares.MOD_ID + ".dyeable").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(stack, context, tooltip, type);
    }
}
