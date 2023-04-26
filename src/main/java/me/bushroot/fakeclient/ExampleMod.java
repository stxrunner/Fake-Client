package me.bushroot.fakeclient;

import me.bushroot.fakeclient.Chat.ChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "fakeclient", name = "FakeClient Mod", version = "1.0.1")
public class ExampleMod {
    public static final String MODID = "fakeclient";
    public static final String NAME = "FakeClient Mod";
    public static final String VERSION = "1.0.1";

    private static Logger logger;

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        ExampleMod.logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ChatEvent());
    }
}
