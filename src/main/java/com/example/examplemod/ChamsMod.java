package com.example.examplemod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ChamsMod.MODID, name = "Chams", version = "1.0")
public class ChamsMod {
    public static final String MODID = "chamsmod";
    public static boolean chamsEnabled = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ChamsRender());
        MinecraftForge.EVENT_BUS.register(new BindCommand());
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }
}
