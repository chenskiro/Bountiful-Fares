package net.hecco.bountifulfares.block.entity;

// import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.GristmillBlock;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.hecco.bountifulfares.screen.GristmillScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GristmillBlockEntity extends BlockEntity implements
        // ExtendedScreenHandlerFactory,
        MenuProvider,
        ImplementedInventory {

    private static BooleanProperty millingState;
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(2, ItemStack.EMPTY);

    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{1};
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    protected final ContainerData propertyDelegate;
    private int progress = 0;
    private int maxProgress = 80;

    public GristmillBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.GRISTMILL_BLOCK_ENTITY.get(), pos, state);
        millingState = ((GristmillBlock) state.getBlock()).getMillingState();
        this.propertyDelegate = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GristmillBlockEntity.this.progress;
                    case 1 -> GristmillBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        GristmillBlockEntity.this.progress = value;
                    case 1:
                        GristmillBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    // @Override
    // public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
    //     buf.writeBlockPos(this.worldPosition);
    // }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.bountifulfares.gristmill");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new GristmillScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.inventory;
    }


    @Override
    public void saveAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.saveAdditional(nbt, registries);
        ContainerHelper.saveAllItems(nbt, inventory, registries);
        nbt.putInt("milling.progress", progress);
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        ContainerHelper.loadAllItems(nbt, inventory, registries);
        nbt.getInt("milling.progress");
        super.loadAdditional(nbt, registries);
    }

    private boolean isCrafting() {
        return hasRecipe() && canInsertOutputSlot();
    }

    public void tick(Level world, BlockPos pos, BlockState state) {
        if (!world.isClientSide) {
            if (this.maxProgress != (BountifulFares.CONFIG.getMillingTime() * 20)) {
                this.maxProgress = BountifulFares.CONFIG.getMillingTime() * 20;
            }
//        Updates the block state based on if it is milling
            if (!state.getValue(millingState) && !inventory.get(0).isEmpty() && isCrafting()) {
                world.setBlockAndUpdate(pos, state.setValue(millingState, true));
            }
            if (state.getValue(millingState) && !hasRecipe() && progress != 0) {
                world.setBlockAndUpdate(pos, state.setValue(millingState, false));
            }
            if (canInsertOutputSlot() && hasRecipe()) {
                increaseCraftingProgress();
                setChanged(world, pos, state);
                if (hasCraftingFinished()) {
                    craftItem();
                    resetProgress();
                }
            } else {
                decreaseCraftingProgress();
            }
        }
    }

    private void resetProgress() {
        this.progress = 1;
    }

    private void craftItem() {
        Optional<RecipeHolder<MillingRecipe>> recipe = getCurrentRecipe();

        this.removeItem(INPUT_SLOT, 1);
        this.setItem(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResultItem(null).getItem(),
                this.getItem(OUTPUT_SLOT).getCount() + recipe.get().value().getResultItem(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private void decreaseCraftingProgress() {
        if (this.progress > 0) {
            this.progress -= 2;
        }
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<MillingRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) return false;
        ItemStack output = recipe.get().value().getResultItem(null);

        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getItem(OUTPUT_SLOT).getMaxStackSize() >= this.getItem(OUTPUT_SLOT).getCount() + count;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return BOTTOM_SLOTS;
        }
        if (side == Direction.UP) {
            return TOP_SLOTS;
        }
        return TOP_SLOTS;
    }

    private Optional<RecipeHolder<MillingRecipe>> getCurrentRecipe() {
        NonNullList<ItemStack> inventory = NonNullList.create();
        for (int i = 0; i < this.getContainerSize(); i++) {
            inventory.add(this.getItem(i));
        }
        return this.getLevel().getRecipeManager().getRecipeFor(BFRecipes.MILLING, new RecipeWrapper(new ItemStackHandler(inventory)), this.getLevel());
    }

    private boolean canInsertOutputSlot() {
        return this.getItem(OUTPUT_SLOT).isEmpty() ||
                this.getItem(OUTPUT_SLOT).getCount() < this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }
}
