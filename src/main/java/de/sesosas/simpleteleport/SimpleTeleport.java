package de.sesosas.simpleteleport;

import de.sesosas.simpleteleport.commands.*;
import de.sesosas.simpleteleport.events.IEventHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class SimpleTeleport extends JavaPlugin {

    public FileConfiguration config = getConfig();

    private static SimpleTeleport plugin;

    public static SimpleTeleport getPlugin() { return plugin; }

    @Override
    public void onEnable() {
        plugin = this;

        config.addDefault("Teleport.Spawn.Position.X", 0);
        config.addDefault("Teleport.Spawn.Position.Y", 0);
        config.addDefault("Teleport.Spawn.Position.Z", 0);
        config.addDefault("Teleport.Spawn.Position.YAW", 0);
        config.addDefault("Teleport.Spawn.Position.PITCH", 0);
        config.addDefault("Teleport.Spawn.Enabled", false);
        config.addDefault("Teleport.Spawn.NewPlayersOnly", true);
        config.addDefault("Teleport.Enabled", true);
        config.addDefault("Teleport.Range.Restricted", true);
        config.addDefault("Teleport.Range.Type", "spawn");
        config.addDefault("Teleport.Range.Distance.MAX", 400);
        config.addDefault("Teleport.Range.Distance.MIN", 100);
        config.addDefault("Chat.Prefix", "§f[§cSTP§f]");

        List<String> headerComment = new ArrayList<>();
        headerComment.add("Teleport Range Types:\n");
        headerComment.add("Spawn = Teleport based on Teleport.Spawn.Position\n");
        headerComment.add("LastPosition = Teleport based on last player position\n\n");
        headerComment.add("Teleport.Range.Restricted does handle if the teleport distance should be random between Teleport.Range.Distance.MIN and Teleport.Range.Distance.MAX blocks or if disabled a completely random amount of blocks\n");
        config.options().header(headerComment.toString().replace("[", "").replace("]", "").replace(", ", ""));

        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new IEventHandler(), this);
        getCommand("stp-reload").setExecutor(new ReloadCommand());
        getCommand("tpaccept").setExecutor(new TPAcceptCommand());
        getCommand("tpa").setExecutor(new TPACommand());
        getCommand("tpar").setExecutor(new TPARCommand());
        getCommand("tpdeny").setExecutor(new TPDenyCommand());
        getCommand("tphere").setExecutor(new TPHereCommand());
        getCommand("tpr").setExecutor(new TPRCommand());
    }
}
