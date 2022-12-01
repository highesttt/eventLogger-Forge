package com.highest.eventLogger.loops;

import java.util.Date;
import java.util.Timer;

import com.highest.eventLogger.fileop.updateFile;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class checkDay {
    public static long day = -1;
    public static Level overworld;
    public static Player player;
    public static Timer timer = new Timer();
    public static void check() {
        timer.schedule(
            new java.util.TimerTask() {
                @Override
                public void run() {
                    if (day != (long) (overworld.getDayTime() / 24000)) {
                        day = (long) (overworld.getDayTime() / 24000);
                        updateFile.update("[" + new Date().toString() + "] " + "Day " + day + " in overworld", "day");
                    }
                }
            },
            0,
            1000
        );
    }
}
