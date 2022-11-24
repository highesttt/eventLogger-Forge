package com.highest.eventLogger.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Date;

import com.highest.eventLogger.fileop.updateFile;

@Mod(DeathEvent.MODID)
public class DeathEvent {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "eventlogger";
    // Directly reference a slf4j logger
    public DeathEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            String message = "[" + new Date().toString() + "] " + player.getName().getString() + " died.";
            updateFile.update(message);
        }
    }
}
