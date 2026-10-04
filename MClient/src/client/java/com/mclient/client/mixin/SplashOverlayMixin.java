package com.mclient.client.mixin;

import com.mclient.MClient;
import com.mclient.MClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.SplashOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashOverlay.class)
public abstract class SplashOverlayMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void mclient$render(GuiGraphics graphics, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!MClientConfig.isReimaginedIntroEnabled()) return;
        Minecraft minecraft = Minecraft.getInstance();
        int width = graphics.guiWidth();
        int height = graphics.guiHeight();

        graphics.fill(0, 0, width, height, 0xFF000000);
        graphics.blit(MClient.id("textures/gui/mclient_intro.png"), 0, 0, 0, 0.0F, 0.0F, width, height, width, height);
        graphics.drawCenteredString(minecraft.font, "MClient", width / 2, Math.max(10, height - 30), 0xFFFFFFFF);
        ci.cancel();
    }
}
