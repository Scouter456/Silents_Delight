package com.scouter.silentsdelight.datagen;

import com.google.common.collect.ImmutableMap;
import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.items.SDItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.scouter.silentsdelight.SilentsDelight.prefix;
import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.MEDIUM_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.NORMAL_COOKING;

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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD ,SDItems.WARDEN_EAR_ON_A_STICK.get(), 1)
                .requires(Items.STICK)
                .requires(SDItems.WARDEN_EAR.get())
                .unlockedBy("has_warden_ear", has(SDItems.WARDEN_EAR.get()))
                .save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SDItems.SCULK_BARBECUE_STICK.get())
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(Ingredient.fromValues(Stream.of(
                        new Ingredient.ItemValue(new ItemStack(SDItems.SCULK_SENSOR_TENDRIL.get())),
                        new Ingredient.ItemValue(new ItemStack(SDItems.WARDEN_EAR.get()))
                        )))
                .requires(Ingredient.fromValues(Stream.of(
                        new Ingredient.ItemValue(new ItemStack(SDItems.SCULK_SENSOR_TENDRIL.get())),
                        new Ingredient.ItemValue(new ItemStack(SDItems.WARDEN_EAR.get()))
                )))
                .requires(Items.STICK)
                .unlockedBy("has_sculk_sensor_tendril", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_SENSOR_TENDRIL.get()))
                .unlockedBy("has_warden_ear", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.WARDEN_EAR.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SDItems.HEARTBURGER.get())
                .requires(ForgeTags.BREAD)
                .requires(SDItems.WARDEN_HEART_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_warden_heart_patty", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.WARDEN_HEART_PATTY.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SDItems.SCULK_SENSOR_TENDRIL_ROLL.get(), 1)
                .pattern("RXR")
                .pattern("###")
                .define('#', SDItems.SCULK_SENSOR_TENDRIL.get())
                .define('R', ModItems.COOKED_RICE.get())
                .define('X', Items.CARROT)
                .unlockedBy("has_sculk_sensor_tendril", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_SENSOR_TENDRIL.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SDItems.PLATED_WARDEN_HEART.get())
                .requires(ForgeTags.MILK)
                .requires(Items.BAKED_POTATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(Items.BOWL)
                .requires(SDItems.WARDEN_HEART.get())
                .unlockedBy("has_warden_heart", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.WARDEN_HEART.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SDItems.SCULK_CATALYST_PIE_CRUST.get(), 1)
                .pattern(" S ")
                .pattern("wMw")
                .pattern(" S ")
                .define('w', Items.WHEAT)
                .define('M', ForgeTags.MILK)
                .define('S', Items.SCULK_CATALYST)
                .unlockedBy("has_sculk_catalyst", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SCULK_CATALYST))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SDItems.SCULK_CATALYST_PIE.get(), 1)
                .pattern("###")
                .pattern("aaa")
                .pattern("xOx")
                .define('#', Items.WHEAT)
                .define('a', Items.SCULK_CATALYST)
                .define('x', Items.SCULK)
                .define('O', SDItems.SCULK_CATALYST_PIE_CRUST.get())
                .unlockedBy("has_sculk_catalyst_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_CATALYST_PIE_CRUST.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, SDItems.SCULK_CATALYST_PIE.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', SDItems.SCULK_CATALYST_PIE_SLICE.get())
                .unlockedBy("has_sculk_catalyst_pie_slice", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_CATALYST_PIE_SLICE.get()))
                .save(pRecipeOutput, prefix("sculk_catalyst_pie_from_slices"));


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, SDItems.SCULK_VEIN_SALAD.get())
                .requires(Items.SCULK_VEIN)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(Items.BEETROOT)
                .requires(Items.BOWL)
                .unlockedBy("has_bowl", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOWL))
                .save(pRecipeOutput);
        cookMeals(pRecipeOutput);
        cuttingAnimalItems(pRecipeOutput);
        smeltingRecipes(pRecipeOutput);
    }

    private void cookMeals(Consumer<FinishedRecipe> consumer) {

        wrap(CookingPotRecipeBuilder.cookingPotRecipe(SDItems.WARDEN_EAR_FRIED_RICE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                        .addIngredient(SDItems.CUT_WARDEN_EAR.get())
                        .addIngredient(ForgeTags.CROPS_RICE)
                        .addIngredient(ForgeTags.EGGS)
                        .addIngredient(Items.CARROT)
                        .addIngredient(ForgeTags.CROPS_ONION)
                        .unlockedByAnyIngredient(ModItems.RICE.get(), Items.EGG, Items.CARROT, ModItems.ONION.get(), SDItems.WARDEN_EAR.get())
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                , "cooking/warden_ear_fried_rice", consumer);

        wrap(CookingPotRecipeBuilder.cookingPotRecipe(SDItems.SCULK_SHRIEKER_SHAKE.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.GLASS_BOTTLE)
                        .addIngredient(Items.SCULK_SHRIEKER)
                        .addIngredient(Items.SUGAR)
                        .unlockedByItems("has_sculk_shrieker", Items.SCULK_SHRIEKER)
                        .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                , "cooking/sculk_shrieker_shake", consumer);

        wrap(CookingPotRecipeBuilder.cookingPotRecipe(SDItems.SCULK_SOUP.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(Items.SCULK)
                        .addIngredient(ForgeTags.EGGS)
                        .addIngredient(ForgeTags.VEGETABLES_CARROT)
                        .unlockedByItems("has_sculk", Items.SCULK)
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                , "cooking/sculk_soup", consumer);

        wrap(CookingPotRecipeBuilder.cookingPotRecipe(SDItems.SCULK_SENSOR_SPRINKLES.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(Items.SCULK)
                        .addIngredient(Items.SWEET_BERRIES)
                        .addIngredient(Items.SUGAR)
                        .addIngredient(SDItems.SCULK_SENSOR_TENDRIL.get())
                        .unlockedByItems("has_sculk_sensor_tendri;", SDItems.SCULK_SENSOR_TENDRIL.get())
                        .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                , "cooking/sculk_sensor_sprinkles", consumer);
    }

    private void cuttingAnimalItems(Consumer<FinishedRecipe> consumer) {

        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.SCULK_SENSOR), Ingredient.of(ForgeTags.TOOLS_KNIVES), SDItems.SCULK_SENSOR_TENDRIL.get(), 2)
                , "cutting/sculk_sensor_tendril", consumer);

        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(SDItems.SCULK_SENSOR_TENDRIL_ROLL.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), SDItems.SCULK_SENSOR_TENDRIL_ROLL_SLICE.get(), 3)
                , "cutting/sculk_sensor_tendril_roll_slice", consumer);

        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(SDItems.SCULK_CATALYST_PIE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), SDItems.SCULK_CATALYST_PIE_SLICE.get(), 4)
                , "cutting/sculk_catalyst_pie", consumer);

        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(SDItems.WARDEN_EAR.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), SDItems.CUT_WARDEN_EAR.get(), 1)
                        .addResult(Items.BONE_MEAL)
                , "cutting/warden_ear", consumer);

        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(SDItems.WARDEN_HEART.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), SDItems.MINCED_WARDEN_HEART.get(), 2)
                , "cutting/minced_warden_heart", consumer);
    }


    private void farmersDelightRecipes(Consumer<FinishedRecipe> consumer) {
    }

    private void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        foodSmeltingRecipes("baked_warden_ear_on_a_stick", SDItems.WARDEN_EAR_ON_A_STICK.get(), SDItems.BAKED_WARDEN_EAR_ON_A_STICK.get(), 0.35F, consumer);
        foodSmeltingRecipes("warden_heart_patty", SDItems.MINCED_WARDEN_HEART.get(), SDItems.WARDEN_HEART_PATTY.get(), 0.35F, consumer);
    }

    private void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
        String namePrefix = new ResourceLocation(FarmersDelight.MODID, name).toString();
        wrap(SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                        .unlockedBy(name, hasItems(ingredient))
                , name, consumer);
        wrap(SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                        .unlockedBy(name, hasItems(ingredient))
                , name + "_from_campfire_cooking", consumer);
        wrap(SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD ,result, experience, 100)
                        .unlockedBy(name, hasItems(ingredient))
                , name + "_from_smoking", consumer);
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
        wrap(builder, SilentsDelight.MODID, name, consumer, modLoaded("farmersdelight"));
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
        wrap(builder, SilentsDelight.MODID, name, consumer, modLoaded("farmersdelight"));
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
        wrap(builder, SilentsDelight.MODID, name, consumer, modLoaded("farmersdelight"));
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
