package net.hecco.bountifulfares.datagen.trellis;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.datagen.bountifulfares.BFTemplateModels;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import com.xueluoanping.bountifulfaresforge.api.data.provider.ModNameRecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.LanguageProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static net.hecco.bountifulfares.BountifulFaresUtil.toSentenceCase;

public class TrellisUtilProvider extends BlockTagsProvider {

    public TrellisUtilProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, BountifulFares.MOD_ID, null);
    }

    public static void registerTrellisModels(BlockModelGenerators blockStateModelGenerator, TrellisVariant variant) {
        BFTemplateModels.registerTrellis(blockStateModelGenerator, variant);
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.PASSION_FRUIT).get(),
                variant.getBlockName(),
                BFTrellises.PASSION_FRUIT.getName() + "_trellis_vines",
                BFTrellises.PASSION_FRUIT.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.ELDERBERRY).get(),
                variant.getBlockName(),
                BFTrellises.ELDERBERRY.getName() + "_trellis_vines",
                BFTrellises.ELDERBERRY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.LAPISBERRY).get(),
                variant.getBlockName(),
                BFTrellises.LAPISBERRY.getName() + "_trellis_vines",
                BFTrellises.LAPISBERRY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.GLOW_BERRY).get(),
                variant.getBlockName(),
                BFTrellises.GLOW_BERRY.getName() + "_trellis_vines",
                BFTrellises.GLOW_BERRY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.ROSE).get(),
                variant.getBlockName(),
                BFTrellises.ROSE.getName() + "_trellis_vines",
                BFTrellises.ROSE.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.LILAC).get(),
                variant.getBlockName(),
                BFTrellises.LILAC.getName() + "_trellis_vines",
                BFTrellises.LILAC.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.PEONY).get(),
                variant.getBlockName(),
                BFTrellises.PEONY.getName() + "_trellis_vines",
                BFTrellises.PEONY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.SUNFLOWER).get(),
                variant.getBlockName(),
                BFTrellises.SUNFLOWER.getName() + "_trellis_vines",
                BFTrellises.SUNFLOWER.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.VINE).get(),
                variant.getBlockName(),
                BFTrellises.VINE.getName() + "_trellis_vines",
                BFTrellises.VINE.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.WEEPING).get(),
                variant.getBlockName(),
                BFTrellises.WEEPING.getName() + "_trellis_vines",
                BFTrellises.WEEPING.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerUpsideDownDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.TWISTING).get(),
                variant.getBlockName(),
                BFTrellises.TWISTING.getName() + "_trellis_vines",
                BFTrellises.TWISTING.getName() + "_trellis_foliage",
                variant.getModId());
//        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                new Identifier(variant.getModId(), ModTrellises.NS_LAVENDER.getName() + "_" + variant.getBlockName()),
//                variant.getBlockName(),
//                ModTrellises.NS_LAVENDER.getName() + "_trellis_vines",
//                ModTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
//                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_LAVENDER).get(),
                variant.getBlockName(),
                BFTrellises.NS_LAVENDER.getName() + "_trellis_vines",
                BFTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLEEDING_HEART).get(),
                variant.getBlockName(),
                BFTrellises.NS_BLEEDING_HEART.getName() + "_trellis_vines",
                BFTrellises.NS_BLEEDING_HEART.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLUE_BULB).get(),
                variant.getBlockName(),
                BFTrellises.NS_BLUE_BULB.getName() + "_trellis_vines",
                BFTrellises.NS_BLUE_BULB.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_CARNATION).get(),
                variant.getBlockName(),
                BFTrellises.NS_CARNATION.getName() + "_trellis_vines",
                BFTrellises.NS_CARNATION.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_GARDENIA).get(),
                variant.getBlockName(),
                BFTrellises.NS_GARDENIA.getName() + "_trellis_vines",
                BFTrellises.NS_GARDENIA.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_MARIGOLD).get(),
                variant.getBlockName(),
                BFTrellises.NS_MARIGOLD.getName() + "_trellis_vines",
                BFTrellises.NS_MARIGOLD.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_FOXGLOVE).get(),
                variant.getBlockName(),
                BFTrellises.NS_FOXGLOVE.getName() + "_trellis_vines",
                BFTrellises.NS_FOXGLOVE.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.SPAWN_SUNFLOWER).get(),
                variant.getBlockName(),
                BFTrellises.SPAWN_SUNFLOWER.getName() + "_trellis_vines",
                BFTrellises.SPAWN_SUNFLOWER.getName() + "_trellis_foliage",
                variant.getModId());
    }

    public static void registerTrellisTranslations(LanguageProvider translationBuilder, TrellisVariant trellis) {
        String temp = toSentenceCase(BuiltInRegistries.ITEM.getKey(TrellisUtil.getTrellisFromVariant(trellis).get().asItem()).getPath());
        translationBuilder.add(TrellisUtil.getTrellisFromVariant(trellis).get(), temp);
        for (VineCrop crop : TrellisUtil.VineCrops) {
            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop).get(), temp);
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            translationBuilder.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine).get(), temp);
        }
    }

    public abstract static class RecipeProviderVisiter extends ModNameRecipeProvider{
        public RecipeProviderVisiter(PackOutput pOutput) {
            super(pOutput);
        }

        public static InventoryChangeTrigger.TriggerInstance has(@NotNull ItemLike pItemLike){
            return RecipeProvider.has(pItemLike);
        }
    }

    public static void registerTrellisRecipe(Consumer<FinishedRecipe> exporter, TrellisVariant trellis) {
        if (trellis.getCraftingItem() != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis).get())
                    .pattern("# #")
                    .pattern(" P ")
                    .pattern("# #")
                    .define('#', Items.STICK)
                    .define('P', trellis.getCraftingItem())
                    .unlockedBy("has_stick", RecipeProviderVisiter.has(Items.STICK))
                    .unlockedBy("has_planks", RecipeProviderVisiter.has(trellis.getCraftingItem()))
                    .group("trellis")
                    .save(exporter);
        }
    }

    public static void registerCompatTrellisRecipe(Consumer<FinishedRecipe> exporter, TrellisVariant trellis) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis).get())
                .pattern("# #")
                .pattern(" P ")
                .pattern("# #")
                .define('#', Items.STICK)
                .define('P', BuiltInRegistries.ITEM.get(trellis.getCraftingItemIdentifier()))
                .unlockedBy("has_stick", RecipeProviderVisiter.has(Items.STICK))
                .unlockedBy("has_planks", RecipeProviderVisiter.has(BuiltInRegistries.ITEM.get(trellis.getCraftingItemIdentifier())))
                .group("trellis")
                .save(exporter);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

    }
}
