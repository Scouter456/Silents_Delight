package com.scouter.silentsdelight.datagen;

import com.google.common.collect.ImmutableMap;
import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    //private static final List<ItemLike> VELERIUM_SMELTABLES = List.of(ABlocks.VELERIUM_ORE.get(), AItems.RAW_VELERIUM.get());
    static final Map<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>> SHAPE_CONSUMERS =
            ImmutableMap.<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>>builder()
                    .put(BlockFamily.Variant.BUTTON, ((itemLike, itemLike2) -> buttonBuilder(itemLike, Ingredient.of(itemLike2))))
                    .put(BlockFamily.Variant.DOOR, ((itemLike, itemLike2) -> doorBuilder(itemLike, Ingredient.of(itemLike2))))
                    .put(BlockFamily.Variant.CHISELED, ((itemLike, itemLike2) -> chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, itemLike, Ingredient.of(itemLike2))))
                    .put(BlockFamily.Variant.CUSTOM_FENCE, (p_176708_, p_176709_) -> fenceBuilder(p_176708_, Ingredient.of(p_176709_)))
                    .put(BlockFamily.Variant.FENCE, (p_248031_, p_248032_) -> fenceBuilder(p_248031_, Ingredient.of(p_248032_)))
                    .put(BlockFamily.Variant.CUSTOM_FENCE_GATE, (p_176698_, p_176699_) -> fenceGateBuilder(p_176698_, Ingredient.of(p_176699_)))
                    .put(BlockFamily.Variant.FENCE_GATE, (p_248035_, p_248036_) -> fenceGateBuilder(p_248035_, Ingredient.of(p_248036_)))
                    .put(BlockFamily.Variant.SIGN, (p_176688_, p_176689_) -> signBuilder(p_176688_, Ingredient.of(p_176689_)))
                    .put(BlockFamily.Variant.SLAB, (p_248017_, p_248018_) -> slabBuilder(RecipeCategory.BUILDING_BLOCKS, p_248017_, Ingredient.of(p_248018_)))
                    .put(BlockFamily.Variant.STAIRS, (p_176674_, p_176675_) -> stairBuilder(p_176674_, Ingredient.of(p_176675_)))
                    .put(BlockFamily.Variant.PRESSURE_PLATE, (p_248039_, p_248040_) -> pressurePlateBuilder(RecipeCategory.REDSTONE, p_248039_, Ingredient.of(p_248040_)))
                    .put(BlockFamily.Variant.TRAPDOOR, (p_176638_, p_176639_) -> trapdoorBuilder(p_176638_, Ingredient.of(p_176639_)))
                    .put(BlockFamily.Variant.POLISHED, (p_248019_, p_248020_) -> polishedBuilder(RecipeCategory.BUILDING_BLOCKS, p_248019_, Ingredient.of(p_248020_)))
                    .put(BlockFamily.Variant.WALL, (p_248024_, p_248025_) -> wallBuilder(RecipeCategory.DECORATIONS, p_248024_, Ingredient.of(p_248025_)))
                    .put(BlockFamily.Variant.CUT, (p_248026_, p_248027_) -> cutBuilder(RecipeCategory.BUILDING_BLOCKS, p_248026_, Ingredient.of(p_248027_)))
                    .build();

    public RecipeGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pRecipeOutput) {
        generateForEnabledBlockFamilies(pRecipeOutput, FeatureFlagSet.of(FeatureFlags.VANILLA));
        generateForEnabledBlockFamilies(pRecipeOutput, FeatureFlagSet.of(FeatureFlags.VANILLA));

        //oreSmelting(pWriter, VELERIUM_SMELTABLES, RecipeCategory.MISC, AItems.VELERIUM.get(), 0.25f, 200, "sapphire");
        //oreBlasting(pWriter, VELERIUM_SMELTABLES, RecipeCategory.MISC, AItems.VELERIUM.get(), 0.25f, 100, "velerium");
        
        // ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
        //         .pattern("SSS")
        //         .pattern("SSS")
        //         .pattern("SSS")
        //         .define('S', ModItems.SAPPHIRE.get())
        //         .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
        //         .save(pWriter);
//
        // ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
        //         .requires(ModBlocks.SAPPHIRE_BLOCK.get())
        //         .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
        //         .save(pWriter);

        //wrap(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,AItems.ARGON_FLASH.get())
        //        .define('G', Tags.Items.GLASS)
        //        .define('P', Tags.Items.ENDER_PEARLS)
        //        .pattern(" P ")
        //        .pattern("PGP")
        //        .pattern(" P ")
        //        .unlockedBy("has_smelts_to_glass",has(ItemTags.SMELTS_TO_GLASS)),"clear_view_block_water_normal", pWriter, not(modLoaded("netherdepthsupgrade")));

        //wrap(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,AItems.ARGON_FLASH.get())
        //        .define('G', Tags.Items.GLASS)
        //        .define('P', Tags.Items.ENDER_PEARLS)
        //        .pattern(" P ")
        //        .pattern("PGP")
        //        .pattern(" P ")
        //        .unlockedBy("has_smelts_to_glass",has(ItemTags.SMELTS_TO_GLASS)),"clear_view_block_water_ndu", pWriter, modLoaded("netherdepthsupgrade"));


        //wrap(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,AItems.ARGON_FLASH.get())
        //        .define('G', Tags.Items.GLASS)
        //        .define('P', Tags.Items.ENDER_PEARLS)
        //        .pattern(" P ")
        //        .pattern("PGP")
        //        .pattern(" P ")
        //        .unlockedBy("has_smelts_to_glass",has(ItemTags.SMELTS_TO_GLASS)),"clear_view_block_lava_normal", pWriter, not(modLoaded("netherdepthsupgrade")));
//
        //wrap(ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,AItems.ARGON_FLASH.get())
        //        .define('G', Tags.Items.GLASS)
        //        .define('P', Tags.Items.ENDER_PEARLS)
        //        .pattern(" P ")
        //        .pattern("PGP")
        //        .pattern(" P ")
        //        .unlockedBy("has_smelts_to_glass",has(ItemTags.SMELTS_TO_GLASS)),"clear_view_block_lava_ndu", pWriter, modLoaded("netherdepthsupgrade"));
        //SimpleCookingRecipeBuilder.smelting()


    }



    protected void generateForEnabledBlockFamilies(Consumer<FinishedRecipe> pEnabledFeatures, FeatureFlagSet p_251836_) {
        generateRecipes(pEnabledFeatures, p_251836_);
    }

    protected static void generateRecipes(Consumer<FinishedRecipe> pRecipeOutput, FeatureFlagSet pRequiredFeatures) {
        //SBlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateRecipe).forEach(blockFamily -> {
        //    for (Map.Entry<BlockFamily.Variant, Block> family : blockFamily.getVariants().entrySet()) {
        //        if (family.getValue().requiredFeatures().isSubsetOf(pRequiredFeatures)) {
        //            BiFunction<ItemLike, ItemLike, RecipeBuilder> bifunction = SHAPE_CONSUMERS.get(family.getKey());
        //            ItemLike itemlike = getBaseBlock(blockFamily, family.getKey());
        //            if (bifunction != null) {
        //                RecipeBuilder recipebuilder = bifunction.apply(family.getValue(), itemlike);
        //                blockFamily.getRecipeGroupPrefix()
        //                        .ifPresent(
        //                                p_293701_ -> recipebuilder.group(p_293701_ + (family.getKey() == BlockFamily.Variant.CUT ? "" : "_" + family.getKey().getRecipeGroup()))
        //                        );
        //                recipebuilder.unlockedBy(blockFamily.getRecipeUnlockedBy().orElseGet(() -> getHasName(itemlike)), has(itemlike));
        //                recipebuilder.save(pRecipeOutput);
        //            }
//
        //            if (family.getKey() == BlockFamily.Variant.CRACKED) {
        //                smeltingResultFromBase(pRecipeOutput, family.getValue(), itemlike);
        //            }
        //        }
        //    }
//
        //});
    }

    private Block getBlock(ResourceLocation resourceLocation) {
        return BuiltInRegistries.BLOCK.get(resourceLocation);
    }

    private Item getItem(ResourceLocation resourceLocation) {
        return BuiltInRegistries.ITEM.get(resourceLocation);
    }

    private String name(Item block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Item block) {
        return BuiltInRegistries.ITEM.getKey(block);
    }
    private void wrap(CuttingBoardRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, SilentsDelight.MODID, name, consumer, conds);
    }
    //
    private void wrap(CuttingBoardRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.build(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
                .build(consumer, loc);
    }
    //
    private void wrap(CookingPotRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, SilentsDelight.MODID, name, consumer, conds);
    }
    //
    private void wrap(CookingPotRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.build(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
                .build(consumer, loc);
    }
    //
    private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, SilentsDelight.MODID, name, consumer, conds);
    }
    //
    private void wrap(RecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.save(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
                .generateAdvancement()
                .build(consumer, loc);
    }
}
