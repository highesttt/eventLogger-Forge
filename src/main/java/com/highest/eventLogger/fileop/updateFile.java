package com.highest.eventLogger.fileop;

import java.io.File;
import java.io.FileWriter;

public class updateFile {
    public static void update(String content, String filename) {
        File file = new File(System.getenv("APPDATA") + "\\.minecraft\\mods\\eventLogger\\" + filename + ".txt");
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            // add a new line to the file
            FileWriter writer = new FileWriter(file, true);
            writer.write(content + "\n");
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
