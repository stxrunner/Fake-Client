package me.bushroot.fakeclient.Chat;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

public class ChatEvent {
    @SubscribeEvent
    public void ChatEvent(ClientChatEvent e) {
        Minecraft mc = Minecraft.getMinecraft();
        String msg = e.getMessage();

        if (Objects.equals(msg, "/gm 1")) {
            mc.player.sendMessage(new TextComponentString("Режим креатива для игрока " + mc.player.getName() + " установлен"));
            mc.playerController.setGameType(GameType.CREATIVE);
        } else if (msg.startsWith("/op ")) {
            mc.player.sendMessage(new TextComponentString(msg.split(" ")[1] + " Opped"));
        } else if (msg.startsWith("/ban ")) {
            mc.player.sendMessage(new TextComponentString("Игрок " + msg.split(" ")[1] + " был забанен по причине: " + msg.split(" ")[2]));
            mc.world.removeEntity(Objects.requireNonNull(mc.world.getPlayerEntityByName(msg.split(" ")[1])));

        } else if (!msg.startsWith("/")) {
            mc.player.sendMessage(new TextComponentString("[ADMIN] " + mc.player.getName() + ": " + msg));
        }

        if (!msg.startsWith("/l") && !msg.startsWith("/reg")) {
            e.setMessage("");
        }
    }
}
