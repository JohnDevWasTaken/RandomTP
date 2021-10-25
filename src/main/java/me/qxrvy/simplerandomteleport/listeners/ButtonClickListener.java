package me.qxrvy.simplerandomteleport.listeners;

import me.qxrvy.simplerandomteleport.SimpleRandomTeleport;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class ButtonClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e){

        Plugin plugin = SimpleRandomTeleport.getPlugin(SimpleRandomTeleport.class);

        if(e.getClickedBlock() != null) {
            if (e.getClickedBlock().getType().toString().toLowerCase().contains("button")) {
                if (e.getPlayer().hasPermission("randomtp.rtp")) {
                    for (BlockFace blockface : BlockFace.values())
                        if (e.getClickedBlock().getRelative(blockface).getType().equals(Material.getMaterial(plugin.getConfig().getString("buttonblock"))))
                            Bukkit.dispatchCommand(e.getPlayer(), "rtp");
                }
            }

        }
    }

}
