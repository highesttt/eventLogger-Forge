package com.highest.eventLogger.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;

public class DeathEvent {
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            String message = "[" + new Date().toString() + "] " + player.getName().getString() + " died.";
            updateFile.update(message);
        }
    }
}
