package com.highest.eventLogger.events;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;
import com.highest.eventLogger.loops.checkDay;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DisconnectEvent {
    @SubscribeEvent
    public void onDisconnect(PlayerEvent.PlayerLoggedOutEvent event) {
        Player player = event.getEntity();
        String message = "[" + new Date().toString() + "] " + player.getName().getString() + " has disconnected.";
        checkDay.overworld = null;
        checkDay.player = null;
        checkDay.day = -1;
        checkDay.timer.cancel();
        updateFile.update(message, "disconnect");
    }
}
