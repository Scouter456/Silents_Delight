package com.scouter.silentsdelight.datagen.advancement;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.advancements.SDCriteriaTriggers;
import com.scouter.silentsdelight.items.SDItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.advancement.CuttingBoardTrigger;
import vectorwing.farmersdelight.common.block.TomatoVineBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModEffects;
import vectorwing.farmersdelight.common.registry.ModEntityTypes;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Consumer;

public class SDAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator
{
	@Override
	public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
		Advancement silentsDelight = Advancement.Builder.advancement()
				.display(Items.SCULK,
						getTranslation("advancement.root"),
						getTranslation("advancement.root.desc"),
						new ResourceLocation("minecraft:textures/block/sculk.png"),
						FrameType.TASK, false, false, false)
				.addCriterion("sculk", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
				.save(consumer, getNameId("main/root"));

		// Harvesting Branch
		Advancement sculkSensorTendril = getAdvancement(silentsDelight, SDItems.SCULK_SENSOR_TENDRIL.get(), "get_sculk_sensor_tendril", FrameType.TASK, true, true, false)
				.addCriterion("sculk_sensor_tendril", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_SENSOR_TENDRIL.get()))
				.requirements(RequirementsStrategy.OR)
				.save(consumer, getNameId("main/get_sculk_sensor_tendril"));

		Advancement rolledSensor = getAdvancement(sculkSensorTendril, SDItems.SCULK_SENSOR_TENDRIL_ROLL.get(), "get_sculk_sensor_tendril_roll", FrameType.TASK, true, true, false)
				.addCriterion("sculk_sensor_tendril_roll", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_SENSOR_TENDRIL_ROLL.get()))
				.save(consumer, getNameId("main/get_sculk_sensor_tendril_roll"));

		Advancement sprinkles = getAdvancement(sculkSensorTendril, SDItems.SCULK_SENSOR_SPRINKLES.get(), "get_sculk_sensor_tendril_sprinkles", FrameType.TASK, true, true, false)
				.addCriterion("sculk_sensor_tendril_sprinkles", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_SENSOR_SPRINKLES.get()))
				.save(consumer, getNameId("main/get_sculk_sensor_tendril_sprinkles"));

		Advancement obtainEar = getAdvancement(silentsDelight, SDItems.WARDEN_EAR.get(), "obtain_warden_ear", FrameType.TASK, true, true, false)
				.addCriterion("obtain_warden_ear", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.WARDEN_EAR.get()))
				.save(consumer, getNameId("main/obtain_warden_ear"));

		Advancement bakedEar = getAdvancement(obtainEar, SDItems.BAKED_WARDEN_EAR_ON_A_STICK.get(), "obtain_baked_warden_ear", FrameType.TASK, true, true, false)
				.addCriterion("obtain_baked_warden_ear", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.BAKED_WARDEN_EAR_ON_A_STICK.get()))
				.save(consumer, getNameId("main/obtain_baked_warden_ear"));

		Advancement earFriedRice = getAdvancement(obtainEar, SDItems.WARDEN_EAR_FRIED_RICE.get(), "obtain_warden_ear_fried_rice", FrameType.TASK, true, false, false)
				.addCriterion("obtain_warden_ear_fried_rice", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.WARDEN_EAR_FRIED_RICE.get()))
				.save(consumer, getNameId("main/obtain_warden_ear_fried_rice"));

		Advancement veinySalad = getAdvancement(silentsDelight, SDItems.SCULK_VEIN_SALAD.get(), "get_sculk_vein_salad", FrameType.GOAL, true, true, false)
				.addCriterion("get_sculk_vein_salad", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_VEIN_SALAD.get()))
				.save(consumer, getNameId("main/get_sculk_vein_salad"));

		Advancement sculkSoup = getAdvancement(silentsDelight, SDItems.SCULK_SOUP.get(), "get_sculk_soup", FrameType.GOAL, true, true, false)
				.addCriterion("get_sculk_soup", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_SOUP.get()))
				.save(consumer, getNameId("main/get_sculk_soup"));

		Advancement wardenHeart = getAdvancement(silentsDelight, SDItems.WARDEN_HEART.get(), "get_warden_heart", FrameType.GOAL, true, true, false)
				.addCriterion("get_warden_heart", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.WARDEN_HEART.get()))
				.save(consumer, getNameId("main/get_warden_heart"));

		Advancement wardenHeartburger = getAdvancement(wardenHeart, SDItems.HEARTBURGER.get(), "get_warden_heartburger", FrameType.GOAL, true, true, false)
				.addCriterion("get_warden_heartburger", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.HEARTBURGER.get()))
				.save(consumer, getNameId("main/get_warden_heartburger"));

		Advancement platedWardenHeart = getAdvancement(wardenHeart, SDItems.PLATED_WARDEN_HEART.get(), "get_plated_warden_heart", FrameType.GOAL, true, true, false)
				.addCriterion("get_plated_warden_heart", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.PLATED_WARDEN_HEART.get()))
				.save(consumer, getNameId("main/get_plated_warden_heart"));

		Advancement sculkPie = getAdvancement(silentsDelight, SDItems.SCULK_CATALYST_PIE.get(), "get_sculk_catalyst_pie", FrameType.GOAL, true, true, false)
				.addCriterion("get_sculk_catalyst_pie", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_CATALYST_PIE.get()))
				.save(consumer, getNameId("main/get_sculk_catalyst_pie"));

		Advancement itGrows = getAdvancement(sculkPie, SDItems.SCULK_CATALYST_PIE_SLICE.get(), "grow_sculk_catalyst_pie", FrameType.CHALLENGE, true, true, true)
				.addCriterion("grow_sculk_catalyst_pie", playerKilledEntityNearSculkCatalystPie())
				.save(consumer, getNameId("main/grow_sculk_catalyst_pie"));

		Advancement itScreams = getAdvancement(silentsDelight, SDItems.SCULK_SHRIEKER_SHAKE.get(), "get_sculk_shrieker_shake", FrameType.GOAL, true, true, false)
				.addCriterion("get_sculk_shrieker_shake", InventoryChangeTrigger.TriggerInstance.hasItems(SDItems.SCULK_SHRIEKER_SHAKE.get()))
				.save(consumer, getNameId("main/get_sculk_shrieker_shake"));
	}

	protected static Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
		return Advancement.Builder.advancement().parent(parent).display(display,
				getTranslation("advancement." + name),
				getTranslation("advancement." + name + ".desc"),
				null, frame, showToast, announceToChat, hidden);
	}

	public static MutableComponent getTranslation(String key, Object... args) {
		return Component.translatable("silentsdelight." + key, args);
	}

	public static KilledTrigger.TriggerInstance playerKilledEntityNearSculkCatalystPie() {
		return new KilledTrigger.TriggerInstance(SDCriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST_PIE.getId(), ContextAwarePredicate.ANY, ContextAwarePredicate.ANY, DamageSourcePredicate.ANY);
	}
	private String getNameId(String id) {
		return SilentsDelight.MODID + ":" + id;
	}
}
