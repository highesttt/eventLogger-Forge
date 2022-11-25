package com.highest.eventLogger.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;

public class EatEvent {
    long eventcalled = 0;
    @SubscribeEvent
    public void onEat(LivingEntityUseItemEvent.Finish event) {
        // prevents the event from being called twice
        if (!(eventcalled == 0) && (eventcalled + 100 > System.currentTimeMillis())) {
            return;
        }
        eventcalled = System.currentTimeMillis();

        if (event.getEntity() instanceof Player) {
            if (event.getItem().getItem().isEdible()) {
                Player player = (Player) event.getEntity();
                String message = "[" + new Date().toString() + "] " + player.getName().getString() + " ate " + event.getItem().getDisplayName().getString() + ".";
                updateFile.update(message);
            }
        }
    }
}