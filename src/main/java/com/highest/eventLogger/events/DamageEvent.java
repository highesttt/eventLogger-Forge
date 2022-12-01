package com.highest.eventLogger.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;

public class DamageEvent {
    @SubscribeEvent
    public void onDamage(LivingHurtEvent event) {
        if (event.getSource().getEntity() == null) {
            return;
        }
        if (event.getSource().getEntity() instanceof Player) {
            Player player = (Player) event.getSource().getEntity();
            String message = "[" + new Date().toString() + "] " + player.getName().getString() + " has damaged a " + event.getEntity().getName().getString() + ".";
            updateFile.update(message, "damage");
        }
    }
}
