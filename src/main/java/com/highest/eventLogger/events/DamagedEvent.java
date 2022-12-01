package com.highest.eventLogger.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;

public class DamagedEvent {
    @SubscribeEvent
    public void onDamaged(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            String message = "[" + new Date().toString() + "] " + player.getName().getString() + " has been damaged by " + event.getSource().getMsgId() + ".";
            updateFile.update(message, "damaged");
        }
    }
}
