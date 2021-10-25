package me.qxrvy.simplerandomteleport.commands;

import me.qxrvy.simplerandomteleport.SimpleRandomTeleport;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class rtpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Plugin plugin = SimpleRandomTeleport.getPlugin(SimpleRandomTeleport.class);

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("randomtp.rtp")) {
                if(!SimpleRandomTeleport.checkMap.get(player)) {
                    if (player.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
                        int min = SimpleRandomTeleport.getPlugin(SimpleRandomTeleport.class).getConfig().getInt("min");
                        int max = SimpleRandomTeleport.getPlugin(SimpleRandomTeleport.class).getConfig().getInt("max");

                        int x = (int) Math.floor(Math.random() * (max - min + 1) + min);
                        int z = (int) Math.floor(Math.random() * (max - min + 1) + min);

                        Location location = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(x, z), z);

                        player.teleport(location);

                        SimpleRandomTeleport.checkMap.replace(player, true);
                        SimpleRandomTeleport.timerMap.get(player).setTimecount(plugin.getConfig().getInt("cooldown"));
                        SimpleRandomTeleport.timerMap.get(player).startTimer();
                    } else {
                        player.sendMessage(ChatColor.RED + "You can't do that here!");
                    }
                }
                else{
                    player.sendMessage(ChatColor.RED + "You can only do this every " + Integer.toString(plugin.getConfig().getInt("cooldown")) + " seconds!");
                }
            }
            else{
                player.sendMessage(ChatColor.RED + "You don't have permission to use that command!");
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
        }

        return true;
    }
}
