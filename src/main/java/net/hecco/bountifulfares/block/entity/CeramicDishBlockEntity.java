package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CeramicDishBlockEntity extends DyeableBlockEntity implements ImplementedInventory {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);
    public CeramicDishBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.inventory;
    }

    public boolean canInsertItem() {
        return this.getItem(0).isEmpty();
    }

    @Override
    public void saveAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        ContainerHelper.saveAllItems(nbt, inventory,registries);
        super.saveAdditional(nbt,registries);
    }

    // @Override
    // protected void writeNbt(CompoundTag nbt, HolderLookup.Provider registryLookup) {
    //     ContainerHelper.saveAllItems(nbt, inventory, registryLookup);
    //     super.saveAdditional(nbt, registryLookup);
    // }


    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        ContainerHelper.loadAllItems(nbt, inventory,registries);
        super.loadAdditional(nbt,registries);
    }

    // @Override
    // protected void readNbt(CompoundTag nbt, HolderLookup.Provider registryLookup) {
    //     ContainerHelper.loadAllItems(nbt, inventory, registryLookup);
    //     super.load(nbt, registryLookup);
    // }

    public void insertItem(ItemStack item) {
        assert level != null;
        this.setItem(0, item.copyWithCount(1));
        setChanged();
    }

    public void removeItem() {
        assert level != null;
        this.setItem(0, Items.AIR.getDefaultInstance());
        setChanged();
    }

    public static int getColor(BlockGetter world, BlockPos pos){
        if(world==null){
            return CeramicDishBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof CeramicDishBlockEntity ceramicDishBlockEntity){
            return ceramicDishBlockEntity.color;
        } else {
            return CeramicDishBlockEntity.DEFAULT_COLOR;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction side) {
        return this.inventory.get(0).isEmpty();
    }

    public void setInventory(NonNullList<ItemStack> list) {
        this.inventory.set(0, list.get(0));
    }

    public ItemStack getRenderStack() {
        return this.getItem(0);
    }

//    @Override
//    public void markDirty() {
//        if (!world.isClient()) {
//            PacketByteBuf data = PacketByteBufs.create();
//            data.writeInt(inventory.size());
//            for (int i = 0; i < inventory.size(); i++) {
//                data.writeItemStack(inventory.get(i));
//            }
//            data.writeBlockPos(getPos());
//            PacketByteBuf colorData = PacketByteBufs.create();
//            colorData.writeInt(color);
//            colorData.writeBlockPos(getPos());
//            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
//                ServerPlayNetworking.send(player, BFMessages.CERAMIC_DISH_ITEM_SYNC, data);
//                ServerPlayNetworking.send(player, BFMessages.CERAMIC_COLOR_SYNC, colorData);
//            }
//        }
//        super.markDirty();
//    }
}
