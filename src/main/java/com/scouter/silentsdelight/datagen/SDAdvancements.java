package com.scouter.silentsdelight.datagen;

import com.scouter.silentsdelight.datagen.advancement.SDAdvancementGenerator;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SDAdvancements extends ForgeAdvancementProvider
{
	public SDAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, existingFileHelper, List.of(new SDAdvancementGenerator()));
	}
}
