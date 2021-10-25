package me.qxrvy.simplerandomteleport.timer;

import me.qxrvy.simplerandomteleport.SimpleRandomTeleport;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;


public class Timer {

    private int timecount;
    private int taskID;
    private final Plugin plugin = SimpleRandomTeleport.getPlugin(SimpleRandomTeleport.class);
    private int time;
    private Player player;

    public void setTimecount(int timecount) {
        this.timecount = timecount;
    }

    public Timer(int timecount, Player player){
        this.timecount = timecount;
        this.player = player;
    }

    public void startTimer(){
        time = timecount;
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        this.taskID = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                if(time == 0){
                    stopTimer();
                    return;
                }
                time--;
            }
        }, 0L, 20L);
        return;

    }

    public void stopTimer() {
        Bukkit.getScheduler().cancelTask(taskID);
        SimpleRandomTeleport.checkMap.replace(player, false);
    }
}

