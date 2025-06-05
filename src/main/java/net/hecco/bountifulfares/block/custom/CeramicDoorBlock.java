package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulfares.registry.content.BFItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class CeramicDoorBlock extends DoorBlock implements EntityBlock {
    private final BlockSetType blockSetType;

    public CeramicDoorBlock(Properties settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.blockSetType = blockSetType;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    // @Override
    // public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player)  {
    //     return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    // }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit){
        ItemStack itemStack = player.getItemInHand(player.getUsedItemHand());
        int brushColor = 1;
        if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = player.getItemInHand(player.getUsedItemHand()).getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                brushColor = CompatUtil.getIntColorFromPaintbrush(item);
            } else if (itemStack.is(BFItems.ARTISAN_BRUSH.get()) && !player.isShiftKeyDown() && itemStack.getTagElement(ArtisanBrushItem.DISPLAY_KEY) != null) {
                brushColor = itemStack.getTagElement(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY);
            }
        } else if (itemStack.is(BFItems.ARTISAN_BRUSH.get()) && !player.isShiftKeyDown() && itemStack.getTagElement(ArtisanBrushItem.DISPLAY_KEY) != null) {
            brushColor = itemStack.getTagElement(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY);
        }
        if (brushColor != 1 && !player.isShiftKeyDown()) {
            if (state.getValue(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.above()).is(this)) {
                world.setBlock(pos.above(), this.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(OPEN, state.getValue(OPEN)).setValue(HINGE, state.getValue(HINGE)), 0);
                if (world.getBlockEntity(pos.above()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.setChanged();
                }
            }
            if (state.getValue(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.below()).is(this)) {
                world.setBlock(pos.below(), this.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(OPEN, state.getValue(OPEN)).setValue(HINGE, state.getValue(HINGE)), 0);
                if (world.getBlockEntity(pos.below()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.setChanged();
                }
            }
            world.removeBlock(pos, false);
            world.setBlock(pos, this.withPropertiesOf(state), 0);
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
                return InteractionResult.SUCCESS;
            }
        }
        if (!state.getValue(POWERED)) {
            if (!this.blockSetType.canOpenByHand()) {
                return InteractionResult.PASS;
            } else {
                state = state.cycle(OPEN);
                world.setBlock(pos, state, 10);
                this.playSound(player, world, pos, state.getValue(OPEN));
                world.gameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = state.getValue(HALF);
        DyeableCeramicBlockEntity entity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos);
        DyeableCeramicBlockEntity topentity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos.above());
        DyeableCeramicBlockEntity bottomentity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos.below());
        if (doubleBlockHalf == DoubleBlockHalf.LOWER && world.getBlockState(pos.above()).is(this) && entity.color == topentity.color) {
            if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
                return neighborState.is(this) && neighborState.getValue(HALF) != doubleBlockHalf ? state.setValue(FACING, neighborState.getValue(FACING)).setValue(OPEN, neighborState.getValue(OPEN)).setValue(HINGE, neighborState.getValue(HINGE)).setValue(POWERED, neighborState.getValue(POWERED)) : Blocks.AIR.defaultBlockState();
            } else {
                if (direction == Direction.DOWN && !state.canSurvive(world, pos)) {
                    world.scheduleTick(pos.above(), this, 1);
                    return Blocks.AIR.defaultBlockState();
                } else {
                    return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
                }
            }
        }
        if (doubleBlockHalf == DoubleBlockHalf.UPPER && world.getBlockState(pos.below()).is(this) && entity.color == bottomentity.color) {
            return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
        }
        return state;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.hasNeighborSignal(pos) || world.hasNeighborSignal(pos.relative(state.getValue(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.defaultBlockState().is(sourceBlock) && bl != state.getValue(POWERED)) {
            if (bl != state.getValue(POWERED)) {
                if (!state.getValue(POWERED)) {
                    state = state.cycle(OPEN);
                    this.playSound(null, world, pos, bl);
                }
                world.setBlock(pos, state.setValue(POWERED, bl), 2);
            }
//            if (!state.get(POWERED)) {
//                if (bl != state.get(OPEN)) {
//                    this.playOpenCloseSound(null, world, pos, bl);
//                    world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
//                }
//
//                world.setBlockState(pos, (state.with(POWERED, bl)).cycle(OPEN), 2);
//            }
        }

    }

    private void playSound(@Nullable Entity entity, Level world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundSource.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
        if (world.getBlockEntity(pos.above()) instanceof DyeableCeramicBlockEntity entity) {
            DyeableCeramicBlockItem thisEntity = (DyeableCeramicBlockItem) itemStack.getItem();
            entity.color = thisEntity.getColor(itemStack);
            entity.setChanged();
        }
    }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.above()).is(this)) {
            world.scheduleTick(pos.above(), this, 1);
        }
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.below()).is(this)) {
            world.scheduleTick(pos.below(), this, 1);
        }
        super.playerWillDestroy(world, pos, state, player);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        world.destroyBlock(pos, true);
        super.tick(state, world, pos, random);
    }
}

