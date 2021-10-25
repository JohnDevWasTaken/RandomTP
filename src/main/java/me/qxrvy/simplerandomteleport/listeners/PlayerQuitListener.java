package me.qxrvy.simplerandomteleport.listeners;

import me.qxrvy.simplerandomteleport.SimpleRandomTeleport;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        SimpleRandomTeleport.checkMap.remove(e.getPlayer());
        SimpleRandomTeleport.timerMap.remove(e.getPlayer());

    }

}
