package com.mclient.client;

import com.mclient.MClient;
import net.fabricmc.api.ClientModInitializer;

public class MClientClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MClient.LOGGER.info("MClient client initialized.");
    }
}
