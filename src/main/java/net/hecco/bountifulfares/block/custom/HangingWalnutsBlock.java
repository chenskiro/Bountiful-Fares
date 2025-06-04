package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingWalnutsBlock extends FallingBlock implements BonemealableBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final BooleanProperty SNIPPED = BooleanProperty.create("snipped");

    public HangingWalnutsBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(SNIPPED, false));
    }

    // @Override
    // protected MapCodec<? extends FallingBlock> getCodec() {
    //     return null;
    // }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 vec3d = state.getOffset(world, pos);
        return Block.box(4, 12, 4, 12, 16, 12).move(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, SNIPPED);
    }


    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!HangingWalnutsBlock.isFullyGrown(state) && random.nextFloat() < 0.2) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public void onBrokenAfterFall(Level world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        if (world.getBlockState(pos).isAir() || world.getBlockState(pos).is(BlockTags.REPLACEABLE)) {
            if (world.getBlockState(pos.below()).isFaceSturdy(world, pos, Direction.UP)) {
                world.setBlock(pos, BFBlocks.FALLEN_WALNUTS.defaultBlockState(), 2);
            }

        } else {
            if (world.getBlockState(pos).isFaceSturdy(world, pos, Direction.UP)) {
                world.setBlock(pos.above(), BFBlocks.FALLEN_WALNUTS.defaultBlockState(), 2);
            }
            if (world.getBlockState(pos).is(BFBlocks.FALLEN_WALNUTS) && world.getBlockState(pos).getValue(FallenWalnutsBlock.COUNT) != 3) {
                world.setBlock(pos, BFBlocks.FALLEN_WALNUTS.defaultBlockState().setValue(FallenWalnutsBlock.COUNT, world.getBlockState(pos).getValue(FallenWalnutsBlock.COUNT) + 1), 2);
            } else if (world.getBlockState(pos).is(Blocks.FARMLAND) || world.getBlockState(pos).is(Blocks.DIRT_PATH)) {
                if (world.getBlockState(pos.above()).is(BFBlocks.FALLEN_WALNUTS) && world.getBlockState(pos.above()).getValue(FallenWalnutsBlock.COUNT) != 3) {
                    world.setBlock(pos.above(), BFBlocks.FALLEN_WALNUTS.defaultBlockState().setValue(FallenWalnutsBlock.COUNT, world.getBlockState(pos.above()).getValue(FallenWalnutsBlock.COUNT) + 1), 2);
                } else {
                    world.setBlock(pos.above(), BFBlocks.FALLEN_WALNUTS.defaultBlockState(), 2);
                }
            }
        }
        super.onBrokenAfterFall(world, pos, fallingBlockEntity);
    }


    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult hit) {
        if (player.getItemInHand(player.getUsedItemHand()).is(Items.SHEARS) && !state.getValue(SNIPPED)) {
            world.setBlockAndUpdate(pos, state.setValue(SNIPPED, true));
            if (player instanceof ServerPlayer serverPlayer)
                player.getItemInHand(player.getUsedItemHand()).hurt(1, world.getRandom(), serverPlayer);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        return super.use(state, world, pos, player, pHand, hit);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return Block.canSupportCenter(world, pos.above(), Direction.DOWN) && !world.isWaterAt(pos)
                || world.getBlockState(pos.above()).is(BFBlocks.WALNUT_LEAVES) && !world.isWaterAt(pos);
    }

    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (isFree(state) && pos.getY() >= world.getMinBuildHeight()) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(world, pos, state);
            this.falling(fallingBlockEntity);
            world.setBlockAndUpdate(pos, state.setValue(AGE, 0));
        }
    }

    public static boolean isFree(BlockState state) {
        if (!isFullyGrown(state) || state.getValue(SNIPPED)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected int getDelayAfterPlace() {
        return 30;
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {

    }
    

    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state)) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
        return !isFullyGrown(state);
    }

    private static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 3;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        return !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    // @Override
    // protected boolean canPathfindThrough(BlockState state, PathComputationType type) {
    //     return type == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(state, type);
    // }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter pLevel, BlockPos pPos, PathComputationType type) {
        return type == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(state, pLevel, pPos, type);
    }

    // @Override
    // public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player)  {
    //     return BFItems.WALNUT.getDefaultInstance();
    // }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return BFItems.WALNUT.getDefaultInstance();
    }
}
