package me.qxrvy.simplerandomteleport.listeners;

import me.qxrvy.simplerandomteleport.SimpleRandomTeleport;
import me.qxrvy.simplerandomteleport.timer.Timer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Plugin plugin = SimpleRandomTeleport.getPlugin(SimpleRandomTeleport.class);

        SimpleRandomTeleport.checkMap.put(e.getPlayer(), false);
        SimpleRandomTeleport.timerMap.put(e.getPlayer(), new Timer(plugin.getConfig().getInt("cooldown"), e.getPlayer()));

    }

}
