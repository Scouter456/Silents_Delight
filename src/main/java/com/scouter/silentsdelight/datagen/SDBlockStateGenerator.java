package com.scouter.silentsdelight.datagen;

import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.blocks.SDBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

import java.util.List;
import java.util.function.Function;

import static com.scouter.silentsdelight.SilentsDelight.prefix;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.DUSTED;
import static net.minecraftforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class SDBlockStateGenerator extends BlockStateProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final int DEFAULT_ANGLE_OFFSET = 180;
    public SDBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SilentsDelight.MODID, exFileHelper);
    }
    public static final List<Pair<BooleanProperty, Function<ResourceLocation, Variant>>> MULTIFACE_GENERATOR = List.of(
            Pair.of(BlockStateProperties.NORTH, p_176234_ -> Variant.variant().with(VariantProperties.MODEL, p_176234_)),
            Pair.of(
                    BlockStateProperties.EAST,
                    p_176229_ -> Variant.variant()
                            .with(VariantProperties.MODEL, p_176229_)
                            .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                            .with(VariantProperties.UV_LOCK, true)
            ),
            Pair.of(
                    BlockStateProperties.SOUTH,
                    p_176225_ -> Variant.variant()
                            .with(VariantProperties.MODEL, p_176225_)
                            .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                            .with(VariantProperties.UV_LOCK, true)
            ),
            Pair.of(
                    BlockStateProperties.WEST,
                    p_176213_ -> Variant.variant()
                            .with(VariantProperties.MODEL, p_176213_)
                            .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                            .with(VariantProperties.UV_LOCK, true)
            ),
            Pair.of(
                    BlockStateProperties.UP,
                    p_176204_ -> Variant.variant()
                            .with(VariantProperties.MODEL, p_176204_)
                            .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                            .with(VariantProperties.UV_LOCK, true)
            ),
            Pair.of(
                    BlockStateProperties.DOWN,
                    p_176195_ -> Variant.variant()
                            .with(VariantProperties.MODEL, p_176195_)
                            .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                            .with(VariantProperties.UV_LOCK, true)
            )
    );

    public static BlockFamily family = null;
    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ABlocks.OORTALIT);
        //blockWithItem(ABlocks.ARGON_ORE);
        //blockWithItem(ABlocks.VELERIUM_ORE);
        ////blockWithTop(ABlocks.OORTALIT);
        //axisBlock((RotatedPillarBlock) ABlocks.CHISELED_BRINESLATE_PILLAR.get());
        //axisBlock((RotatedPillarBlock) ABlocks.BRINESLATE_PILLAR.get());
//
        //blockWithItem(ABlocks.DEAD_VENT_CORAL_BLOCK);
        //blockWithItem(ABlocks.DEAD_GRIM_CORAL_BLOCK);
        //blockWithItem(ABlocks.DEAD_SCALE_CORAL_BLOCK);
//
        //blockWithItem(ABlocks.VENT_CORAL_BLOCK);
        //blockWithItem(ABlocks.GRIM_CORAL_BLOCK);
        //blockWithItem(ABlocks.SCALE_CORAL_BLOCK);
//
        //createWallFan(ABlocks.DEAD_VENT_CORAL_WALL_FAN, "cutout");
        //createWallFan(ABlocks.DEAD_GRIM_CORAL_WALL_FAN, "cutout");
        //createWallFan(ABlocks.DEAD_SCALE_CORAL_WALL_FAN, "cutout");
//
        //createWallFan(ABlocks.VENT_CORAL_WALL_FAN, "cutout");
        //createWallFan(ABlocks.GRIM_CORAL_WALL_FAN, "cutout");
        //createWallFan(ABlocks.SCALE_CORAL_WALL_FAN, "cutout");
//
        //createCross(ABlocks.DEAD_VENT_CORAL, "cutout");
        //createCross(ABlocks.DEAD_GRIM_CORAL, "cutout");
        //createCross(ABlocks.DEAD_SCALE_CORAL, "cutout");
//
        //createCross(ABlocks.VENT_CORAL, "cutout");
        //createCross(ABlocks.GRIM_CORAL, "cutout");
        //createCross(ABlocks.SCALE_CORAL, "cutout");
//
//
        //createCoralFan(ABlocks.DEAD_VENT_CORAL_FAN, "cutout");
        //createCoralFan(ABlocks.DEAD_GRIM_CORAL_FAN, "cutout");
        //createCoralFan(ABlocks.DEAD_SCALE_CORAL_FAN, "cutout");
//
        //createCoralFan(ABlocks.VENT_CORAL_FAN, "cutout");
        //createCoralFan(ABlocks.GRIM_CORAL_FAN, "cutout");
        //createCoralFan(ABlocks.SCALE_CORAL_FAN, "cutout");
//
//
//
        //buildLamp(ABlocks.ARGON_LAMP.get());
        //createTintedCross(ABlocks.OVERGROWN_SHRUBS, "cutout");

//
        //createSkullBlocks(SBlocks.MAIDENSNATCHER_SKULL);

        //createPottedPlant(UPBlocks.ZULOAGAE_SAPLING, UPBlocks.POTTED_ZULOGAE,"cutout");
        //this.pieBlock(ModBlocks.APPLE_PIE.get());
        //this.feastBlock(Mob);
        pieBlock(SDBlocks.SCULK_CATALYST_PIE.get());
        feastBlock((FeastBlock) SDBlocks.PLATED_WARDEN_HEART.get());
    }


    public void pieBlock(Block block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                            int bites = state.getValue(PieBlock.BITES);
                            String suffix = bites > 0 ? "_slice" + bites : "";
                            return ConfiguredModel.builder()
                                    .modelFile(existingModel(getName(block) + suffix))
                                    .rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                                    .build();
                        }
                );
    }
    public void feastBlock(FeastBlock block) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    IntegerProperty servingsProperty = block.getServingsProperty();
                    int servings = state.getValue(servingsProperty);
                    if(servings == 3 || servings == 4) return ConfiguredModel.builder()
                            .modelFile(existingModel(getName(block) + "_stage1"))
                            .rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();;
                    String suffix = "_stage" + (block.getMaxServings() - servings);

                    if (servings == 2) {
                        suffix = "_stage1";
                    }

                    if (servings == 1) {
                        suffix = "_stage0";
                    }
                    if (servings == 0) {
                        suffix = "_leftover";
                    }

                    return ConfiguredModel.builder()
                            .modelFile(existingModel(getName(block) + suffix))
                            .rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                            .build();
                });
    }

    private void createPottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pottedPlant, String renderType){
        ConfiguredModel cFfile = new ConfiguredModel(pottedPlant(name(pottedPlant.get()), blockTexture(plant.get()), renderType));
        getVariantBuilder(pottedPlant.get()).partialState().setModels(cFfile);
        //impleBlockItem(plant.get(), file);
    }

    public ModelFile pottedPlant(String name, ResourceLocation plant, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/flower_pot_cross", "plant", plant, renderType);
    }

    public void createFlatWaterEgg(Block block){
        createFlatWaterEgg(block, "");
        flatWaterEgg(block);
        singleTexWaterEgg(block);
    }

    private BlockModelBuilder singleTexWaterEgg(Block block) {
        return generated(getName(block), new ResourceLocation(SilentsDelight.MODID,"item/" + getName(block)));
    }

    private void flatWaterEgg(Block block) {
        getVariantBuilder(block).forAllStatesExcept((state) -> ConfiguredModel.builder().modelFile(existingModel("eggs/"+getName(block)))
                .build());
    }
    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(SilentsDelight.MODID, "block/" + path);
    }


    public void createHangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        createHangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void createHangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private void logBlock(RegistryObject<Block> block) {
        logBlock(block.get());
    }

    private void logBlock(Block block) {
        axisBlock((RotatedPillarBlock) block, prefix("block/" + key(block).getPath()), prefix("block/" +key(block).getPath() + "_top"));
    }

    private void createAge3Block(Block pBlock, String renderTyp, boolean item) {
        String baseName = name(pBlock);
        getVariantBuilder(pBlock).forAllStatesExcept((state ->
        {
            int age = state.getValue(BlockStateProperties.AGE_3);
            ResourceLocation textureSuspicious = prefix("block/" + baseName + "_" + age);
            ModelFile text = cross(baseName + "_" + age, textureSuspicious, renderTyp);
            return ConfiguredModel.builder().modelFile(text).build();
        }
        ));
        ModelFile file = models().getExistingFile(prefix(baseName + "_0"));
        if(item) simpleBlockItem(pBlock, file);
    }

    private void createCropBlock(Block pBlock, String renderTyp) {
        String baseName = name(pBlock);
        getVariantBuilder(pBlock).forAllStatesExcept((state ->
        {
            int age = state.getValue(CropBlock.AGE);
            ResourceLocation textureSuspicious = prefix("block/" + baseName + "_" + age);
            ModelFile text = cross(baseName + "_" + age, textureSuspicious, renderTyp);
            return ConfiguredModel.builder().modelFile(text).build();
        }
        ));
        ModelFile file = models().getExistingFile(prefix(baseName + "_0"));
        simpleBlockItem(pBlock, file);
    }

    private void createSkullBlocks(RegistryObject<Block> RegistryObject) {
        Block block = RegistryObject.get();
        String baseName = name(block);
        getVariantBuilder(block).forAllStates(state -> {
            ResourceLocation skullLoc = prefix("block/skulls/" + baseName);
            ModelFile text = models().getExistingFile(skullLoc);
            return ConfiguredModel.builder().modelFile(text).build();
        });
        getVariantBuilder(getBlock(prefix(baseName+"_wall"))).forAllStates(state -> {
            ResourceLocation skullLoc = prefix("block/skulls/" + baseName+"_wall");
            ModelFile text = models().getExistingFile(skullLoc);
            return ConfiguredModel.builder().modelFile(text).build();
        });

        singleTexItem(block);
        singleTexItem(getBlock(prefix(baseName+"_wall")));
    }
    private void createBrushableBlock(Block pBlock) {
        String baseName = name(pBlock);
        getVariantBuilder(pBlock).forAllStatesExcept((state ->
        {
            int dusted = state.getValue(DUSTED);
            ResourceLocation textureSuspicious = prefix("block/" + baseName + "_" + dusted);
            ModelFile text = models().cubeAll(baseName + "_" + dusted, textureSuspicious);
            return ConfiguredModel.builder().modelFile(text).build();
        }
        ));
        ModelFile file = models().getExistingFile(prefix(baseName + "_0"));
        simpleBlockItem(pBlock, file);
    }


    private void simpleBlockLeaves(RegistryObject<Block> b, String renderType) {
        simpleBlock(b.get(), leaves(b.get(), renderType));
    }

    private void simpleBlock(RegistryObject<Block> b, String renderType) {
        simpleBlock(b.get(), cubeAll(b.get(), renderType));
    }

    public void cubeAllWithItem(Block block, String renderType) {
        ModelFile file = cubeAll(name(block), blockTexture(block), renderType);
        simpleBlockItem(block, file);
    }
    public ModelFile cubeAll(Block block, String renderType) {
      return cubeAll(name(block), blockTexture(block), renderType);
    }

    public ModelFile leaves(Block block, String renderType) {
        ModelFile leaves = leaves(name(block), blockTexture(block), renderType);
        simpleBlockItem(block, leaves);
        return leaves;
    }
    public ModelFile leaves(String name, ResourceLocation texture, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/leaves", "all", texture, renderType);
    }
    public ModelFile cubeAll(String name, ResourceLocation texture, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/cube_all", "all", texture, renderType);
    }
    private void buildLamp(Block block) {
        String baseName = name(block);
        ResourceLocation textureOn = prefix("block/" + baseName + "_on");
        ResourceLocation textureOff = prefix("block/" + baseName + "_off");
        ModelFile on = models().cubeAll(baseName + "_on", textureOn);
        ModelFile off = models().cubeAll(baseName + "_off", textureOff);
        simpleBlockItem(block, off);
        buildLamp(block, on, off);
    }

    private void buildLamp(Block block, ModelFile on, ModelFile off) {
        getVariantBuilder(block).forAllStatesExcept((state -> {
            boolean isLit = state.getValue(BlockStateProperties.LIT);

            return ConfiguredModel.builder().modelFile(isLit ? on : off).build();
        }));
    }

    public void generatePressurePlate(Block block) {
        Block block1 = block;
        if(this.family != null) {
            block1 = this.family.getBaseBlock();
        }
        pressurePlateBlock((PressurePlateBlock) block, prefix("block/" + key(block1).getPath()));
    }

    public void generateWall(Block block) {
        wallBlockWithRenderType((WallBlock) block, prefix("block/" + key(block).getPath().replace("_wall", "")), "cutout");
        generatedWall(name(block), ResourceLocation.tryParse(blockTexture(block).toString().replace("_wall", "")));
    }

    public void generateTrapDoor(Block block) {
        trapdoorBlockWithRenderType((TrapDoorBlock) block, prefix("block/" + key(block).getPath()), true, "cutout");
    }

    public void generateStair(Block block) {
        Block block1 = block;
        if(this.family != null) {
            block1 = this.family.getBaseBlock();
        }
        stairsBlockWithRenderType((StairBlock) block, prefix("block/" + key(block1).getPath()), "cutout");
    }

    public void generateSlab(Block block) {
        //blockWithItemSlab(block);
        Block block1 = block;
        if(this.family != null) {
            block1 = this.family.getBaseBlock();
        }
        slabBlock((SlabBlock) block, prefix("block/" + key(block1).getPath()), prefix("block/" + key(block1).getPath()), prefix("block/" + key(block1).getPath()), prefix("block/" + key(block1).getPath()));
    }

    public void generateSign(Block signBlock) {
        LOGGER.error("Sign gen is not yet implemented!");

        String p =key(signBlock).getPath();
        String z = p.replace("_sign","_wall_sign").replace("blocks/", "");
        ResourceLocation hanging = prefix(z);
        Block block = getBlock(hanging);
        //if(block == null)
        signBlock((StandingSignBlock) signBlock, (WallSignBlock) block, prefix("entity/sign/" + key(signBlock).getPath().replace("_sign", "")));

    }

    public void generateFenceGate(Block block) {
        Block block1 = block;
        if(this.family != null) {
            block1 = this.family.getBaseBlock();
        }
        fenceGateBlockWithRenderType((FenceGateBlock) block, prefix("block/" + key(block1).getPath()), "cutout");
    }

    public void generateFence(Block block) {
        Block block1 = block;
        if(this.family != null) {
            block1 = this.family.getBaseBlock();
        }
        fenceBlockWithRenderType((FenceBlock) block, prefix("block/" + key(block1).getPath()), "cutout");
    }

    public void generateCracked(Block block) {
        blockWithItem(block);
    }

    public void generateChiseled(Block block) {
        blockWithItem(block);
    }

    public void generateDoor(Block doorBlock) {
        doorBlockWithRenderType((DoorBlock) doorBlock,
                prefix("block/" + key(doorBlock).getPath() + "_bottom"),
                prefix("block/" + key(doorBlock).getPath() + "_top"),
                "cutout");
    }

    public void generateButton(Block block) {
        Block block1 = block;
        if(this.family != null) {
            block1 = this.family.getBaseBlock();
        }
        buttonBlock((ButtonBlock) block, prefix("block/" + key(block1).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockWithItem(Block blockRegistryObject, ModelFile file) {
        simpleBlockWithItem(blockRegistryObject, file);
    }

    private void blockWithItem(Block blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject, cubeAll(blockRegistryObject));
    }

    private void blockWithItemSlab(Block blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject, stripSlab(blockRegistryObject));
    }

    private ModelFile stripSlab(Block block) {
        Block block1 = block;
        if(this.family != null) {
            block1 = this.family.getBaseBlock();
        }
        return models().cubeAll(name(block), ResourceLocation.tryParse(blockTexture(block1).toString().replace("_slab", "")));
    }

    private void createWallFan(RegistryObject<Block> b, String renderType) {
        ModelFile file = new ConfiguredModel(wallCoral(name(b.get()), blockTexture(b.get()), renderType)).model;
        getVariantBuilder(b.get())
                .forAllStates(state -> ConfiguredModel.builder()
                        .modelFile(file)
                        .rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                        .build()
                );
        simpleBlockItem(b.get(), file);
    }




    private void createTintedCross(RegistryObject<Block> b, String renderType) {
        getVariantBuilder(b.get()).partialState().setModels(new ConfiguredModel(tintedCross(name(b.get()), blockTexture(b.get()), renderType)));
    }

    public ModelFile tintedCross(String name, ResourceLocation cross, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/tinted_cross", "cross", cross, renderType);
    }
    private void createDoubleCross(RegistryObject<Block> b, String renderType) {
        String baseName = name(b.get());
        getVariantBuilder(b.get()).forAllStatesExcept(e -> {
            DoubleBlockHalf val = e.getValue(DoublePlantBlock.HALF);
            String mod = val == DoubleBlockHalf.LOWER ? "bottom" : "top";
            ResourceLocation texture = prefix("block/" + baseName + "_" + mod);
            ModelFile text = cross(baseName + "_" + mod, texture, renderType);
            return ConfiguredModel.builder().modelFile(text).build();
        });

        //ModelFile file = models().getExistingFile(prefix(baseName + "_top"));
        singleTex(b.get(), baseName + "_top");
    }

    private void createCross(RegistryObject<Block> b, String renderType) {
        ConfiguredModel cFfile = new ConfiguredModel(cross(name(b.get()), blockTexture(b.get()), renderType));
        ModelFile file = cFfile.model;
        String baseName = name(b.get());
        getVariantBuilder(b.get()).partialState().setModels(cFfile);

        singleTex(b.get(), baseName);
        //simpleBlockItem(b.get(), file);
    }

    public ModelFile cross(String name, ResourceLocation cross, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/cross", "cross", cross, renderType);
    }

    private ModelFile singleTexture(String name, String parent, String textureKey, ResourceLocation texture, String renderType) {
        return singleTexture(name, mcLoc(parent), textureKey, texture, renderType);
    }

    public ModelFile wallCoral(String name, ResourceLocation fan, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/coral_wall_fan", "fan", fan, renderType);
    }

    private void createCoralFan(RegistryObject<Block> b, String renderType) {
        getVariantBuilder(b.get()).partialState().setModels(new ConfiguredModel(coralFan(name(b.get()), blockTexture(b.get()), renderType)));
        singleTex(b.get());
    }

    public ModelFile coralFan(String name, ResourceLocation fan, String renderType) {
        return singleTexture(name, BLOCK_FOLDER + "/coral_fan", "fan", fan, renderType);
    }

    public ModelFile singleTexture(String name, ResourceLocation parent, String textureKey, ResourceLocation texture, String renderType) {
        return models().withExistingParent(name, parent)
                .texture(textureKey, texture).renderType(renderType);
    }

    private BlockModelBuilder generatedWall(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("block/" + name, "block/wall_inventory");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private BlockModelBuilder generatedSlab(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("block/" + name, "block/slab");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private void blockWithTop(RegistryObject<Block> blockRegistryObject) {
        horizontalBlock(blockRegistryObject.get(), prefix("block/" + key(blockRegistryObject.get()).getPath()), prefix("block/" + key(blockRegistryObject.get()).getPath()), prefix("block/" + key(blockRegistryObject.get()).getPath() + "_top"));
        simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private BlockModelBuilder singleTexItem(Block block, ResourceLocation name) {
        return generated(name(block), name);
    }
    private BlockModelBuilder singleTexItem(Block block) {
        return generated(name(block), new ResourceLocation(SilentsDelight.MODID, "item/" + name(block)));
    }

    private BlockModelBuilder singleTex(Block block) {
        return singleTex(block,  name(block));
    }

    private BlockModelBuilder singleTex(Block block, String name) {
        return generated(name(block), new ResourceLocation(SilentsDelight.MODID, "block/" + name));
    }

    private BlockModelBuilder generated(String name, ResourceLocation... layers) {
        BlockModelBuilder builder = models().withExistingParent("item/" + name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
    private String getName(Block block) {
        return key(block).toString().replace(SilentsDelight.MODID + ":", "");
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
    public ModelFile createFlatWaterEgg(Block block, String modifier){
        String baseName = getName(block);
        return models().singleTexture("block/eggs/" + modifier + baseName.replace(SilentsDelight.MODID + ":", ""), new ResourceLocation(SilentsDelight.MODID, "block/template_eggs/template_flat_water_egg"), blockTextureEggs(block));
    }

    public ResourceLocation blockTextureEggs(Block block) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/eggs/" + name.getPath());
    }
    private String name(Block block) {
        return key(block).getPath();
    }

    private Block getBlock(ResourceLocation resourceLocation) {
        return BuiltInRegistries.BLOCK.get(resourceLocation);
    }
}