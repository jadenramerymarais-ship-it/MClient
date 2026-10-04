package com.mclient;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class MClientConfig {
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("mclient.properties");

    private static final Properties PROPERTIES = new Properties();

    private MClientConfig() {
    }

    public static void load() {
        PROPERTIES.clear();

        if (Files.exists(FILE)) {
            try (InputStream input = Files.newInputStream(FILE)) {
                PROPERTIES.load(input);
            } catch (IOException ignored) {
            }
        }

        PROPERTIES.putIfAbsent("reimagined_intro", "true");
        save();
    }

    public static boolean isReimaginedIntroEnabled() {
        return Boolean.parseBoolean(PROPERTIES.getProperty("reimagined_intro", "true"));
    }

    public static void setReimaginedIntroEnabled(boolean enabled) {
        PROPERTIES.setProperty("reimagined_intro", Boolean.toString(enabled));
        save();
    }

    private static void save() {
        try {
            Files.createDirectories(FILE.getParent());
            try (OutputStream output = Files.newOutputStream(FILE)) {
                PROPERTIES.store(output, "MClient settings");
            }
        } catch (IOException ignored) {
        }
    }
}
