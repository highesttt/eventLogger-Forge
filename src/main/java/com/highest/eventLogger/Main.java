package com.highest.eventLogger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import com.highest.eventLogger.events.DeathEvent;
import com.highest.eventLogger.events.EatEvent;
import com.highest.eventLogger.events.UsingRocketEvent;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "eventlogger";

    public Main() {
        MinecraftForge.EVENT_BUS.register(new DeathEvent());
        MinecraftForge.EVENT_BUS.register(new EatEvent());
        MinecraftForge.EVENT_BUS.register(new UsingRocketEvent());
    }
}

//when a rocket is used, when you take damage, when you give damage