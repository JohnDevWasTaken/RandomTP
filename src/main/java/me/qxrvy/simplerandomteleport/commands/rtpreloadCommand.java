package me.qxrvy.simplerandomteleport.commands;

import me.qxrvy.simplerandomteleport.SimpleRandomTeleport;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class rtpreloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("randomtp.reload")){
            Plugin plugin = SimpleRandomTeleport.getPlugin(SimpleRandomTeleport.class);
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Config reloaded successfully!");
        }
        else{
            sender.sendMessage(ChatColor.RED + "You don't have permission to use that command!");
        }

        return true;
    }
}
