package de.tayblocks.lobbyplugin.commands;

import de.tayblocks.lobbyplugin.utils.FileConfig;
import de.tayblocks.lobbyplugin.utils.LocationUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;
        FileConfig spawns = new FileConfig("locations.yml");

        if (label.equalsIgnoreCase("setspawn")) {
            if (player.hasPermission("system.setspawn")) {
                spawns.set("spawn", LocationUtils.loc2Str(player.getLocation()));
                spawns.saveConfig();
                player.sendMessage("§eSpawn§a wurde gesetzt");
            }
            return true;
        }

        if (spawns.contains("spawn")) {
            LocationUtils.teleport(player, LocationUtils.loc2Str(spawns.getString("spawn")));
                player.sendMessage("§aDu wurdest zum §eSpawn§a teleportiert");
            return false;
        }
        return true;
    }
}
