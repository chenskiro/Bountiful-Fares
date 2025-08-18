package net.hecco.bountifulfares.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ChamomileFlowersBlock extends PinkPetalsBlock implements BonemealableBlock {
    public ChamomileFlowersBlock(Properties settings) {
        super(settings);
    }

    // @Override
    // public boolean isFertilizable(LevelReader world, BlockPos pos, BlockState state) {
    //     return world.getBlockState(pos.below()).is(Blocks.FARMLAND);
    // }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.below()).is(Blocks.FARMLAND);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        int i = state.getValue(AMOUNT);
        if (i < 4 || world.getBlockState(pos.below()).is(Blocks.FARMLAND)) {
            world.setBlock(pos, state.cycle(AMOUNT), Block.UPDATE_CLIENTS);
        }
    }
}
