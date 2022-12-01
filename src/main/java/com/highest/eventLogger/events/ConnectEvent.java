package com.highest.eventLogger.events;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;
import com.highest.eventLogger.loops.checkDay;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ConnectEvent {
    @SubscribeEvent
    public void onConnect(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        // overworld
        if (player.getServer() == null) {
            return;
        }
        Level level = player.getServer().getLevel(Level.OVERWORLD);
        checkDay.overworld = level;
        checkDay.player = player;
        checkDay.check();
        String message = "[" + new Date().toString() + "] " + player.getName().getString() + " has connected.";
        updateFile.update(message, "connect");
    }
}
