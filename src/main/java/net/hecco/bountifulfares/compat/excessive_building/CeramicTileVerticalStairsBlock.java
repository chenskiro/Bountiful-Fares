package net.hecco.bountifulfares.compat.excessive_building;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.block.interfaces.DyeableCeramicBlockInterface;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CeramicTileVerticalStairsBlock extends CompatVerticalStairsBlock implements DyeableCeramicBlockInterface {
    private final String modId;
    public CeramicTileVerticalStairsBlock(String modId, Properties settings) {
        super(modId, settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
        this.modId = modId;
    }
    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
    @Override
    public ItemStack getPickStack(LevelReader world, BlockPos pos, BlockState state) {
        if (DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getCloneItemStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(this);
        }
    }

    @Override
        public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(player.getUsedItemHand());
        if (itemStack.is(BFItems.ARTISAN_BRUSH) && !player.isShiftKeyDown() && itemStack.get(DataComponentTypes.DYED_COLOR) != null) {
            int brushColor = itemStack.get(DataComponentTypes.DYED_COLOR).rgb();
            world.removeBlock(pos, false);
            world.setBlockAndUpdate(pos, this.withPropertiesOf(state));
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
                    world.setBlockAndUpdate(pos, this.withPropertiesOf(state));
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
