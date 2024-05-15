package com.scouter.silentsdelight;

import com.nhoryzon.mc.farmersdelight.FarmersDelightMod;
import com.scouter.silentsdelight.config.SilentsDelightConfig;
import com.scouter.silentsdelight.setup.Registration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Set;

public class SilentsDelight implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("silentsdelight");
	public static final String MODID = "silentsdelight";
	@Override
	public void onInitialize() {
		SilentsDelightConfig.registerConfigs();
		Registration.init();

		this.registerLootTable();

	}

	public static ResourceLocation prefix(String name) {
		return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
	}
	protected void registerLootTable() {
		Set<ResourceLocation> scavengingEntityIdList = Set.of(
				EntityType.WARDEN.getDefaultLootTable()
		);

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			ResourceLocation injectId = new ResourceLocation(FarmersDelightMod.MOD_ID, "inject/" + id.getPath());
			if (scavengingEntityIdList.contains(id)) {
				tableBuilder.pool(LootPool.lootPool().add(LootTableReference.lootTableReference(injectId)).build());
			}
		});
	}
}