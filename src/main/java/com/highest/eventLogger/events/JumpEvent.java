package com.highest.eventLogger.events;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class JumpEvent {
    long eventcalled = 0;
    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event) {
        // prevents the event from being called twice
        if (!(eventcalled == 0) && (eventcalled + 100 > System.currentTimeMillis())) {
            return;
        }
        eventcalled = System.currentTimeMillis();

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            String message = "[" + new Date().toString() + "] " + player.getName().getString() + " has jumped.";
            updateFile.update(message, "jump");
        }
    }
}
