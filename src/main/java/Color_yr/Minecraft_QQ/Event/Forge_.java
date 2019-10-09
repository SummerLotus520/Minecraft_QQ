package Color_yr.Minecraft_QQ.Event;

import Color_yr.Minecraft_QQ.API.Placeholder;
import Color_yr.Minecraft_QQ.Config.Bukkit_;
import Color_yr.Minecraft_QQ.Socket.socket;
import Color_yr.Minecraft_QQ.Socket.socket_send;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "minecraft_qq")
public final class Forge_ {

    @SubscribeEvent
    public static void onPlayerChat(ServerChatEvent event) {
        String player_message;
        player_message = event.getMessage();
        if (Bukkit_.User_NotSendCommder) {
            if (player_message.indexOf("/") == 0)
                return;
        } else if (Bukkit_.Mute_List.contains(event.getPlayer().getName()))
            return;
        if (Bukkit_.Minecraft_Mode != 0 && socket.hand.socket_runFlag) {
            boolean send_ok = false;
            EntityPlayer player = event.getPlayer();
            String message = Bukkit_.Minecraft_Message;
            String playerName = player.getName();
            message = message.replaceAll(Placeholder.Player, playerName);
            message = message.replaceAll(Placeholder.Servername, Bukkit_.Minecraft_ServerName);
            if (player_message.indexOf(Bukkit_.Minecraft_Check) == 0 && Bukkit_.Minecraft_Mode == 1) {
                player_message = player_message.replaceFirst(Bukkit_.Minecraft_Check, "");
                message = message.replaceAll(Placeholder.Message, player_message);
                send_ok = socket_send.send_data(Placeholder.data, Placeholder.group, playerName, message);
            } else if (Bukkit_.Minecraft_Mode == 2) {
                message = message.replaceAll(Placeholder.Message, player_message);
                send_ok = socket_send.send_data(Placeholder.data, Placeholder.group, playerName, message);
            }
            if (Bukkit_.User_SendSucceed && send_ok)
                player.sendMessage(new TextComponentString("§d[Minecraft_QQ]" + Bukkit_.User_SendSucceedMessage));
        }
    }
}