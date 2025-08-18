package net.hecco.bountifulfares.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class CeramicButtonBlock extends ButtonBlock implements EntityBlock {
    public CeramicButtonBlock(Properties settings, BlockSetType blockSetType, int pressTicks) {
        super(blockSetType, pressTicks, settings);
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
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return DyeableCeramicBlock.getPickStack(level, pos, state.getBlock());
    }


    @Override
        public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult hit) {
        if (DyeableCeramicBlock.onUse(state, world, pos, player, state.getBlock()) == InteractionResult.PASS) {
            if (state.getValue(POWERED)) {
                return InteractionResult.CONSUME;
            } else {
                this.press(state, world, pos);
                return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }
}
