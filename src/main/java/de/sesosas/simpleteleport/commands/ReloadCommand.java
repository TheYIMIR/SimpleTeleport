package de.sesosas.simpleteleport.commands;

import de.sesosas.simpleteleport.SimpleTeleport;
import de.sesosas.simpleteleport.helper.CurrentConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ReloadCommand implements CommandExecutor {

    private String reloadText = "Successfully reloaded the Config!";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Reload();
            Player player = (Player) commandSender;
            player.sendMessage(CurrentConfig.getPrefix() + " " + reloadText);
        }
        else {
            Reload();
            commandSender.sendMessage(CurrentConfig.getPrefix() + " " + reloadText);
        }
        return false;
    }

    private void Reload(){
        File file = new File(SimpleTeleport.getPlugin().getDataFolder().getAbsolutePath() + "/config.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        CurrentConfig.setConfig(cfg);
    }
}
