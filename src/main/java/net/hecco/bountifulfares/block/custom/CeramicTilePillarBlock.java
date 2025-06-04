package net.hecco.bountifulfares.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class CeramicTilePillarBlock extends RotatedPillarBlock implements EntityBlock {
    public CeramicTilePillarBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    // @Override
    // public ItemStack getPickStack(LevelReader world, BlockPos pos, BlockState state) {
    //     return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    // }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit){
        return DyeableCeramicBlock.onUse(state, world, pos, player, state.getBlock());
    }
}
