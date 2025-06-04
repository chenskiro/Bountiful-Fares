package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.FastColor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class CeramicTileSlabBlock extends SlabBlock implements EntityBlock {
    public CeramicTileSlabBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, false));
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
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return DyeableCeramicBlock.onUse(state, world, pos, player, state.getBlock());
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        ItemStack itemStack = context.getItemInHand();
        SlabType slabType = state.getValue(TYPE);
        if (slabType != SlabType.DOUBLE && itemStack.is(this.asItem())
                && itemStack.getTagElement(ArtisanBrushItem.DISPLAY_KEY) != null && itemStack.getTagElement(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY) == DyeableCeramicBlockEntity.getColor(context.getLevel(), context.getClickedPos())
            // && DyedColorComponent.getColor(itemStack, DyeableCeramicBlockEntity.DEFAULT_COLOR) == FastColor.ARGB32.fullAlpha(DyeableCeramicBlockEntity.getColor(context.getLevel(), context.getClickedPos()))
        ) {
            if (context.replacingClickedOnBlock()) {
                boolean bl = context.getClickLocation().y - (double) context.getClickedPos().getY() > 0.5;
                Direction direction = context.getClickedFace();
                return slabType == SlabType.BOTTOM
                        ? direction == Direction.UP || bl && direction.getAxis().isHorizontal()
                        : direction == Direction.DOWN || !bl && direction.getAxis().isHorizontal();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
