package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.FermentationVesselBlockEntity;
import net.hecco.bountifulfares.block.enums.FermentationStage;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;

import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class FermentationVesselBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<FermentationStage> FERMENTATION_STAGE = EnumProperty.create("fermentation_stage", FermentationStage.class);

    public FermentationVesselBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FERMENTATION_STAGE, FermentationStage.EMPTY).setValue(WATERLOGGED, false));
    }
    // public static final MapCodec<FermentationVesselBlock> CODEC = FermentationVesselBlock.createCodec(FermentationVesselBlock::new);
    // @Override
    // protected MapCodec<? extends BaseEntityBlock> getCodec() {
    //     return CODEC;
    // }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FERMENTATION_STAGE, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(FERMENTATION_STAGE) == FermentationStage.FERMENTING || state.getValue(FERMENTATION_STAGE) == FermentationStage.FERMENTED) {
            return Stream.of(
                    Block.box(4, 14, 4, 12, 16, 12),
                    Block.box(2, 0, 2, 14, 13, 14),
                    Block.box(5, 13, 5, 11, 14, 11)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        } else {
            return Shapes.join(
                    Block.box(2, 0, 2, 14, 13, 14),
                    Block.box(5, 13, 5, 11, 15, 11),
                    BooleanOp.OR
            );
        }
    }

    public Optional<FermentationRecipe> getCurrentRecipe(Level world, ItemStack input) {
        return Objects.requireNonNull(world).getRecipeManager().getRecipeFor(BFRecipes.FERMENTING, new SimpleContainer(input), world);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(player.getUsedItemHand());
        if (itemStack.is(PotionUtils.setPotion(Items.POTION.getDefaultInstance(), Potions.WATER).getItem()) && state.getValue(FERMENTATION_STAGE) == FermentationStage.EMPTY) {
            world.setBlock(pos, state.setValue(FERMENTATION_STAGE, FermentationStage.WATER), 2);
            world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_FILL, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() / 3);
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
            if (itemStack.isEmpty() && !player.isCreative()) {
                player.setItemInHand(player.getUsedItemHand(), new ItemStack(Items.GLASS_BOTTLE));
            } else if (!player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))) {
                player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
            }
            return InteractionResult.SUCCESS;

        } else if (itemStack.is(Items.WATER_BUCKET) && state.getValue(FERMENTATION_STAGE) == FermentationStage.EMPTY) {
            world.setBlock(pos, state.setValue(FERMENTATION_STAGE, FermentationStage.WATER), 2);
            world.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() / 3);
            world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_FILL, SoundSource.BLOCKS, 0.7F, 0.8F + world.random.nextFloat() / 3);
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
            if (itemStack.isEmpty() && !player.isCreative()) {
                player.setItemInHand(player.getUsedItemHand(), new ItemStack(Items.BUCKET));
            } else if (!player.getInventory().add(new ItemStack(Items.BUCKET))) {
                player.drop(new ItemStack(Items.BUCKET), false);
            }
            return InteractionResult.SUCCESS;

        } else if (world.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (getCurrentRecipe(world, itemStack).isPresent() && state.getValue(FERMENTATION_STAGE) == FermentationStage.WATER) {
                if (entity.canInsertItem()) {
                    entity.insertItem(itemStack.getItem().getDefaultInstance());
                    world.setBlockAndUpdate(pos, state.setValue(FERMENTATION_STAGE, FermentationStage.FERMENTING));
                    pushEntitiesUp(state.setValue(FERMENTATION_STAGE, FermentationStage.WATER), state.setValue(FERMENTATION_STAGE, FermentationStage.FERMENTING), world, pos);
                    ItemStack itemStack1 = getCurrentRecipe(world, itemStack).get().getIngredients().get(0).getItems()[0];
                    ItemStack remainder = itemStack1.getItem().getCraftingRemainingItem(itemStack1);
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                    if (remainder != null) {
                        if (itemStack.isEmpty() && !player.isCreative()) {
                            player.setItemInHand(player.getUsedItemHand(), remainder);
                        } else if (!player.getInventory().add(remainder)) {
                            player.drop(remainder, false);
                        }
                    }
                    world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_SPLASH, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() / 3);
                    entity.setParticleColor(getCurrentRecipe(world, itemStack).get().getParticleColor());
                    return InteractionResult.SUCCESS;
                }
            } else if (!entity.canInsertItem()) {
                return entity.tryExtractItem(world, pos, state, player, player.getUsedItemHand());
            }
            return InteractionResult.PASS;
        }
        return super.use(state, world, pos, player, pHand, hit);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (world.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (BountifulFares.CONFIG.isFermentationBubbleParticles() && state.getValue(FermentationVesselBlock.FERMENTATION_STAGE) == FermentationStage.FERMENTING && entity.getParticleColor().isPresent()) {
                Vector3f color = Vec3.fromRGB24(entity.getParticleColor().orElse(16777215)).toVector3f();
                for (int i = 0; i < random.nextIntBetweenInclusive(1, 3); i++) {
                    world.addParticle(BFParticles.FERMENTED_BUBBLE, pos.getX() + 0.20 + (world.random.nextFloat() * 0.6), pos.getY() + 0.85, pos.getZ() + 0.20 + (world.random.nextFloat() * 0.6), color.x, color.y, color.z);
                }
            }
        }
        super.animateTick(state, world, pos, random);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, bl);
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FermentationVesselBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BFBlockEntities.FERMENTATION_VESSEL_BLOCK_ENTITY.get(), (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
