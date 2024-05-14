package de.sesosas.simpleteleport.helper;

import de.sesosas.simpleteleport.SimpleTeleport;
import org.bukkit.configuration.file.FileConfiguration;

public class CurrentConfig {
    public static FileConfiguration getConfig(){
        return SimpleTeleport.getPlugin().config;
    }

    public static void setConfig(FileConfiguration cfg){
        SimpleTeleport.getPlugin().config = cfg;
    }

    public static String getPrefix(){
        return getConfig().getString("Chat.Prefix");
    }
}
