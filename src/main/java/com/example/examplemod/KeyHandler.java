package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import static org.lwjgl.opengl.GL11.*;

public class KeyHandler {
    private boolean lastKeyState = false;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.thePlayer == null) return;

        boolean currentKeyState = BindCommand.bindKey != 0 && Keyboard.isKeyDown(BindCommand.bindKey);
        if (currentKeyState && !lastKeyState) {
            ChamsMod.chamsEnabled = !ChamsMod.chamsEnabled;
            String status = ChamsMod.chamsEnabled ? "§aON" : "§cOFF";
            mc.thePlayer.addChatMessage(new net.minecraft.util.ChatComponentText("Chams " + status));
        }
        lastKeyState = currentKeyState;
    }
}

class ChamsRender {
    @SubscribeEvent
    public void onRenderPlayerPre(RenderPlayerEvent.Pre event) {
        if (ChamsMod.chamsEnabled) {
            glDisable(GL_DEPTH_TEST);
            glColor3f(1, 0, 0);
        }
    }

    @SubscribeEvent
    public void onRenderPlayerPost(RenderPlayerEvent.Post event) {
        if (ChamsMod.chamsEnabled) {
            glEnable(GL_DEPTH_TEST);
            glColor3f(1, 1, 1);
        }
    }
}
