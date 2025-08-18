package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;


public class DecorativeTrellisBlock extends TrellisBlock implements BonemealableBlock {
    private final boolean canDuplicate;

    public TrellisVariant variant;
    public DecorativeVine vine;

    public DecorativeTrellisBlock(boolean canDuplicate, Item item, TrellisVariant variant, DecorativeVine vine, Properties settings) {
        super(variant, settings);
        this.canDuplicate = canDuplicate;
        BFBlocks.PLANTS_TO_DECORATIVE_TRELLISES.put(item, this);
        BFBlocks.DECORATIVE_TRELLISES_TO_PLANTS.put(this, item);
        this.variant = variant;
        this.vine = vine;
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult hit) {
        Direction facing = state.getValue(FACING);
        if (player.getItemInHand(player.getUsedItemHand()).is(Items.SHEARS)) {
            if (player instanceof ServerPlayer serverPlayer)
                player.getItemInHand(player.getUsedItemHand()).hurt(1, world.getRandom(), serverPlayer);
            world.setBlock(pos, TrellisUtil.getTrellisFromVariant(variant).get().defaultBlockState().setValue(FACING, facing), 2);
            popResource(world, pos, new ItemStack(BFBlocks.DECORATIVE_TRELLISES_TO_PLANTS.get(this)));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void destroy(LevelAccessor world, BlockPos pos, BlockState state) {
        popResource((Level) world, pos, new ItemStack(vine.getPlantItem()));
        super.destroy(world, pos, state);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
        return new ItemStack(TrellisUtil.getTrellisFromVariant(variant).get());
    }


    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return canDuplicate;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return canDuplicate;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        if (canDuplicate) {
            popResource(world, pos, new ItemStack(BFBlocks.DECORATIVE_TRELLISES_TO_PLANTS.get(this)));
        }
    }

    public static BlockState getDecorativeTrellisFromPlant(Item item) {
        if (item != null && BFBlocks.PLANTS_TO_DECORATIVE_TRELLISES.containsKey(item)) {
            return (BFBlocks.PLANTS_TO_DECORATIVE_TRELLISES.get(item)).defaultBlockState();
        } else {
            return BFTrellises.TRELLISES.get("trellis").get().defaultBlockState();
        }
    }

    // @Override
    // protected MapCodec<? extends HorizontalDirectionalBlock> getCodec() {
    //     return null;
    // }

    // Hey Hecco i have noticed that you have like 20-22 lang files for the same translation of trellises
    // You can use this method to make these hundreds of lang lines redundant
    // P.S. i tested this with WTHIT and it works
    // if you accept this, this will allow to remove like 500 lines from every lang file
    // they are so annoying to translate through "find and replace"
    @Override
    public String getDescriptionId() {
        return "block." + variant.getModId() + "." + variant.getBlockName();
    }
}
