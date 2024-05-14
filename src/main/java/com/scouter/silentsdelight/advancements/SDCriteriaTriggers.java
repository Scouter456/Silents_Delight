package com.scouter.silentsdelight.advancements;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.KilledTrigger;

import static com.scouter.silentsdelight.SilentsDelight.prefix;

public class SDCriteriaTriggers {
    public static final KilledTrigger KILL_MOB_NEAR_SCULK_CATALYST_PIE = CriteriaTriggers.register(new KilledTrigger(prefix("kill_mob_near_sculk_catalyst_pie")));

    public static void init(){
    }
}
