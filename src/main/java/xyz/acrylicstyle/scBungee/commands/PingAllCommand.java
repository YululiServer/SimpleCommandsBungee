package xyz.acrylicstyle.scBungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import xyz.acrylicstyle.scBungee.SimpleCommandsBungee;

import java.util.ArrayList;
import java.util.List;

public class PingAllCommand extends Command {
    public PingAllCommand() {
        super("pingall", "simplecommands.pingall");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        List<TextComponent> list = new ArrayList<>();
        ProxyServer.getInstance().getPlayers().forEach(player -> list.add(new TextComponent(ChatColor.GREEN + player.getName() + "'s Ping: " + SimpleCommandsBungee.getPingMessage(player.getPing()))));
        list.forEach(sender::sendMessage);
    }
}
