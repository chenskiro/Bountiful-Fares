package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

public class PalmCrownBlock extends RotatedPillarBlock {
    public PalmCrownBlock(Properties settings) {
        super(settings);
    }

    @Override
        public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult hit) {
        if (player.getItemInHand(player.getUsedItemHand()).getItem() instanceof BoneMealItem) {
            if (hit.getDirection() != Direction.DOWN && hit.getDirection() != Direction.UP) {
                if (world.getBlockState(pos.relative(hit.getDirection(), 1)).isAir()) {
                    world.setBlockAndUpdate(pos.relative(hit.getDirection(), 1), BFBlocks.COCONUT.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, hit.getDirection()));
                    if (!world.isClientSide) {
                        world.levelEvent(1505, pos, 0);
                    }
                    BoneMealItem.addGrowthParticles(world, pos.below(), 2);
                    if (!player.isCreative()) {
                        player.getItemInHand(player.getUsedItemHand()).shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
            } else {
                Direction[] DIRECTIONS = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH};
                for (Direction direction : DIRECTIONS) {
                    if (world.getBlockState(pos.relative(direction)).isAir()) {
                        world.setBlockAndUpdate(pos.relative(direction), BFBlocks.COCONUT.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction));
                        if (!world.isClientSide) {
                            world.levelEvent(1505, pos.below(), 0);
                        }
                        BoneMealItem.addGrowthParticles(world, pos.below(), 2);
                        if (!player.isCreative()) {
                            player.getItemInHand(player.getUsedItemHand()).shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return super.use(state, world, pos, player, hit);
    }
}
