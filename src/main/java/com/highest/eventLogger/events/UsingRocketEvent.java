package com.highest.eventLogger.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;

public class UsingRocketEvent {
    long eventcalled = 0;
    @SubscribeEvent
    public void onUseRocket(PlayerInteractEvent.RightClickItem event) {
        // prevents the event from being called twice
        if (!(eventcalled == 0) && (eventcalled + 100 > System.currentTimeMillis())) {
            return;
        }
        eventcalled = System.currentTimeMillis();

        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getItemStack().getDisplayName().getString().contains("Rocket")) {
                if (player.isFallFlying() && player.getInventory().getArmor(2).getDisplayName().getString().contains("Elytra")) {
                    String message = "[" + new Date().toString() + "] " + player.getName().getString() + " used a rocket while flying.";
                    updateFile.update(message, "rocket");
                }
            }
        }
    }
}
