package com.highest.eventLogger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import com.highest.eventLogger.events.ConnectEvent;
import com.highest.eventLogger.events.DamageEvent;
import com.highest.eventLogger.events.DamagedEvent;
import com.highest.eventLogger.events.DeathEvent;
import com.highest.eventLogger.events.DisconnectEvent;
import com.highest.eventLogger.events.EatEvent;
import com.highest.eventLogger.events.JumpEvent;
import com.highest.eventLogger.events.UsingRocketEvent;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "eventlogger";

    public Main() {
        MinecraftForge.EVENT_BUS.register(new DeathEvent());
        MinecraftForge.EVENT_BUS.register(new EatEvent());
        MinecraftForge.EVENT_BUS.register(new UsingRocketEvent());
        MinecraftForge.EVENT_BUS.register(new DamageEvent());
        MinecraftForge.EVENT_BUS.register(new DamagedEvent());
        MinecraftForge.EVENT_BUS.register(new JumpEvent());
        MinecraftForge.EVENT_BUS.register(new ConnectEvent());
        MinecraftForge.EVENT_BUS.register(new DisconnectEvent());
    }
}
