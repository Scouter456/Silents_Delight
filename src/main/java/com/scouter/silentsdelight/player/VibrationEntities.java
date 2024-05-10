package com.scouter.silentsdelight.player;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class VibrationEntities {
    private static final Multimap<UUID, Integer> mapToShow = HashMultimap.create();
    private static  final HashMap<Integer, Integer> timer = new HashMap<>();

    public static Collection<Integer> getToShow(UUID uuid){
        return mapToShow.get(uuid);
    }

    public static void addToShow(UUID player, Integer toShow) {
        mapToShow.put(player, toShow);
        timer.put(toShow, 50);
    }

    public static int getTime(int id) {
        return timer.computeIfAbsent(id, (k) -> 0);
    }

    public static void remove(UUID player, List<Integer> ids){
        for (Integer id: ids) {
            int time = timer.get(id);
            if(time > 0) {
                timer.put(id, time -1);
            } else {
                mapToShow.remove(player, id);
            }
        }

    }
}
