package me.qxrvy.simplerandomteleport;

import me.qxrvy.simplerandomteleport.commands.rtpCommand;
import me.qxrvy.simplerandomteleport.commands.rtpreloadCommand;
import me.qxrvy.simplerandomteleport.listeners.ButtonClickListener;
import me.qxrvy.simplerandomteleport.listeners.PlayerJoinListener;
import me.qxrvy.simplerandomteleport.listeners.PlayerQuitListener;
import me.qxrvy.simplerandomteleport.timer.Timer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class SimpleRandomTeleport extends JavaPlugin {

    public static Map<Player, Timer> timerMap;
    public static Map<Player, Boolean> checkMap;

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        timerMap = new HashMap<>();
        checkMap = new HashMap<>();

        getCommand("randomtp").setExecutor(new rtpCommand());
        getCommand("rtpreload").setExecutor(new rtpreloadCommand());

        getServer().getPluginManager().registerEvents(new ButtonClickListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);

        for(Player p : Bukkit.getServer().getOnlinePlayers()){
            SimpleRandomTeleport.checkMap.put(p, false);
            SimpleRandomTeleport.timerMap.put(p, new Timer(getConfig().getInt("cooldown"), p));
        }

    }

}
