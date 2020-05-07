package xyz.acrylicstyle.scBungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import util.CollectionList;
import util.ICollectionList;

public class SCAlertCommand extends Command {
    public SCAlertCommand() {
        super("scalert", "simplecommands.scalert");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        CollectionList<String> list = ICollectionList.asList(args);
        boolean noPrefix = list.contains("--no-prefix");
        list.remove("--no-prefix");
        String message = list.join(" ");
        String prefix = noPrefix ? "" : ChatColor.GRAY + "[Message from " + ChatColor.YELLOW + sender.getName() + ChatColor.GRAY + ": " + ChatColor.WHITE;
        ProxyServer.getInstance().getPlayers().forEach(player -> player.sendMessage(new TextComponent(prefix + ChatColor.translateAlternateColorCodes('&', message) + (noPrefix ? "" : ChatColor.GRAY + "]"))));
    }
}
