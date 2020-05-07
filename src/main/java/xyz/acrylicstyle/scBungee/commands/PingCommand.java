package xyz.acrylicstyle.scBungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import xyz.acrylicstyle.scBungee.SimpleCommandsBungee;

public class PingCommand extends Command {
    public PingCommand() {
        super("ping");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "This command cannot be invoked from console."));
            return;
        }
        if (args.length == 0) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            sender.sendMessage(new TextComponent(ChatColor.GREEN + "Ping: " + SimpleCommandsBungee.getPingMessage(player.getPing())));
            return;
        }
        String p = args[0];
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(p);
        if (player == null) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Player could not be found."));
            return;
        }
        sender.sendMessage(new TextComponent(ChatColor.GREEN + player.getName() + "'s Ping: " + SimpleCommandsBungee.getPingMessage(player.getPing())));
    }
}
