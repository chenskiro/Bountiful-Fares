package net.hecco.bountifulfares.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class CeramicTrapdoorBlock extends TrapDoorBlock implements EntityBlock {
    private final BlockSetType blockSetType;
    public CeramicTrapdoorBlock(Properties settings, BlockSetType blockSetType) {
        super(blockSetType, settings);
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
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader world, BlockPos pos, Player player) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (DyeableCeramicBlock.onUse(state, world, pos, player, state.getBlock()) == InteractionResult.PASS) {
            if (!state.getValue(POWERED)) {
                if (!this.blockSetType.canOpenByHand()) {
                    return InteractionResult.PASS;
                } else {
                    state = state.cycle(OPEN);
                    world.setBlock(pos, state, 2);
                    if (state.getValue(WATERLOGGED)) {
                        world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
                    }

                    this.playSound(player, world, pos, state.getValue(OPEN));
                    return InteractionResult.sidedSuccess(world.isClientSide);
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClientSide) {
            boolean bl = world.hasNeighborSignal(pos);
            if (bl != state.getValue(POWERED)) {
                if (!state.getValue(POWERED)) {
                    state = state.cycle(OPEN);
                    this.playSound(null, world, pos, bl);
                }
                world.setBlock(pos, state.setValue(POWERED, bl), 2);
                if (state.getValue(WATERLOGGED)) {
                    world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
                }
            }

        }
    }
}

