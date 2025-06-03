package net.hecco.bountifulfares.recipe;

import com.google.common.collect.Lists;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.item.custom.CeramicDishBlockItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import java.util.ArrayList;

public class CeramicMassDyeingRecipe extends CustomRecipe {
    public CeramicMassDyeingRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput inventory, Level world) {
        boolean difference = false;
        Item dyeItem = null;
        int dyeCount = 0;
        ItemStack ceramicItemStack = ItemStack.EMPTY;
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack itemStack2 = inventory.getStackInSlot(i);
            if (itemStack2.isEmpty()) {
                continue;
            }
            if (itemStack2.getItem() instanceof DyeItem
            && !BuiltInRegistries.ITEM.getKey(itemStack2.getItem()).equals(ResourceLocation.tryBuild("unidye", "custom_dye"))) {
                dyeCount++;
                if (dyeItem == null) {
                    dyeItem = itemStack2.getItem();
                } else if (dyeItem != itemStack2.getItem()) {
                    difference = true;
                }
                continue;
            }
            if (itemStack2.getItem() instanceof DyeableCeramicBlockItem
                || itemStack2.getItem() instanceof CeramicDishBlockItem) {
                if (ceramicItemStack.isEmpty()) {
                    ceramicItemStack = itemStack2;
                    continue;
                } else if (ceramicItemStack.is(itemStack2.getItem())){
                    if(DyedColorComponent.getColor(ceramicItemStack, DyeableCeramicBlockEntity.DEFAULT_COLOR)
                    == DyedColorComponent.getColor(itemStack2, DyeableCeramicBlockEntity.DEFAULT_COLOR)){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
            return false;
        }
        return difference || dyeCount == 1;
    }

    @Override
    public ItemStack craft(CraftingRecipeInput inventory, HolderLookup.Provider lookup) {
        ArrayList<DyeItem> list = Lists.newArrayList();
        ItemStack ceramicStack = ItemStack.EMPTY;
        int ceramicCount = 0;
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack itemStack2 = inventory.getStackInSlot(i);
            if (itemStack2.isEmpty()) continue;
            Item item = itemStack2.getItem();
            if (item instanceof DyeItem) {
                list.add((DyeItem) item);
            }
            if (item instanceof DyeableCeramicBlockItem
                    || item instanceof CeramicDishBlockItem){
                ceramicCount++;
                if(ceramicStack.isEmpty()){
                    ceramicStack = itemStack2;
                }
            }
        }
        if (list.isEmpty() || ceramicStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStack = DyedColorComponent.setColor(ceramicStack, list);
        itemStack.setCount(ceramicCount);
        return itemStack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BFSpecialRecipes.CERAMIC_MASS_DYEING;
    }
}
