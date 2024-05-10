package com.scouter.silentsdelight.datagen;

import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import net.minecraft.util.InclusiveRange;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new RecipeGenerator(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new LanguageGenerator(packOutput));
        generator.addProvider(event.includeClient(), new SDBlockStateGenerator(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModelGenerator(packOutput, existingFileHelper));



        BlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(), new BlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));



        Map<PackType, Integer> packVersions = Arrays.stream(PackType.values())
                .collect(Collectors.toMap(Function.identity(), DetectedVersion.BUILT_IN::getPackVersion));

        InclusiveRange<Integer> supportedFormatsRange = new InclusiveRange<>(
                packVersions.values().stream().min(Integer::compareTo).orElse(1),
                packVersions.values().stream().max(Integer::compareTo).orElse(1)
        );

        //generator.addProvider(true, new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(
        //        Component.literal("Resources for Scalebound"),
        //        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
        //        Optional.of(supportedFormatsRange)
        //)));
        //new ForgeSherdDatagenSuite(event, Scalebound.MODID)

        //        .makeSherdSuite(SSherds.DRAGON, new Sherd(SItems.DRAGON_POTTERY_SHERD.get(), prefix("dragon_pottery_pattern")));
    }

    //private static void addArmorTrims(ExistingFileHelper existingFileHelper) {
    //    for (ItemModelGenerators.TrimModelData trim : ItemModelGenerators.GENERATED_TRIM_MODELS) {
    //        existingFileHelper.trackGenerated(new ResourceLocation("boots_trim_" + trim.name()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
    //        existingFileHelper.trackGenerated(new ResourceLocation("chestplate_trim_" + trim.name()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
    //        existingFileHelper.trackGenerated(new ResourceLocation("helmet_trim_" + trim.name()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
    //        existingFileHelper.trackGenerated(new ResourceLocation("leggings_trim_" + trim.name()), PackType.CLIENT_RESOURCES, ".png", "textures/trims/items");
    //    }
    //}
}
