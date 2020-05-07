package xyz.acrylicstyle.scBungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.acrylicstyle.scBungee.commands.PingAllCommand;
import xyz.acrylicstyle.scBungee.commands.PingCommand;
import xyz.acrylicstyle.scBungee.commands.SCAlertCommand;
import xyz.acrylicstyle.scBungee.commands.TLBungeeCommand;

public class SimpleCommandsBungee extends Plugin {
    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new PingCommand());
        getProxy().getPluginManager().registerCommand(this, new PingAllCommand());
        getProxy().getPluginManager().registerCommand(this, new SCAlertCommand());
        getProxy().getPluginManager().registerCommand(this, new TLBungeeCommand());
    }

    public static String getPingMessage(int ping) {
        String message;
        if (ping <= 5) message = "" + ChatColor.LIGHT_PURPLE + ping;
        else if (ping <= 50) message = "" + ChatColor.GREEN + ping;
        else if (ping <= 200) message = "" + ChatColor.YELLOW + ping;
        else if (ping <= 350) message = "" + ChatColor.GOLD + ping;
        else if (ping <= 500) message = "" + ChatColor.RED + ping;
        else message = "" + ChatColor.DARK_RED + ping;
        return message + "ms";
    }
}
