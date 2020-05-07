package xyz.acrylicstyle.scBungee.commands;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import util.CollectionList;
import util.ICollectionList;

import java.lang.reflect.Modifier;

public class TLBungeeCommand extends Command {
    public TLBungeeCommand() {
        super("tlbungee", "simplecommands.tlbungee", "tlb");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        CollectionList<String> argsList = ICollectionList.asList(args);
        String argsString = argsList.join(" ");
        try {
            Object result = eval(sender, args, argsString);
            sender.sendMessage(new TextComponent(ChatColor.GREEN + "Result[" + (result != null ? Modifier.toString(result.getClass().getModifiers()) : "<?>") + "](" + (result != null ? result.getClass().getCanonicalName() : "null") + "):"));
            sender.sendMessage(new TextComponent(ChatColor.GREEN + "" + result));
        } catch (Throwable e) {
            sender.sendMessage(new TextComponent(ChatColor.RED + "An error occurred: " + e.getClass().getSimpleName() + ": " + e.getMessage()));
            ProxyServer.getInstance().getLogger().warning("An error occurred in eval:");
            e.printStackTrace();
        }
    }

    private static Object eval(CommandSender sender, String[] args, String expression) {
        Binding b = new Binding();
        b.setVariable("sender", sender);
        b.setVariable("args", args);
        b.setVariable("proxy", ProxyServer.getInstance());
        b.setProperty("sender", sender);
        b.setProperty("args", args);
        b.setProperty("proxy", ProxyServer.getInstance());
        return new GroovyShell(b).evaluate(expression);
    }
}
