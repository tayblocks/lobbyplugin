package de.tayblocks.lobbyplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationUtils {


    public static String loc2Str(Location location) {
        String loc = "";

        loc += location.getWorld().getName() +  ";";
        loc += location.getX() +  ";";
        loc += location.getY() +  ";";
        loc += location.getZ() +  ";";
        loc += location.getYaw() +  ";";
        loc += location.getPitch() +  ";";

        return loc;
    }

    public static Location loc2Str(String str) {
        String[] args = str.split(";");


        return new Location(Bukkit.getWorld(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Float.parseFloat(args[4]), Float.parseFloat(args[5]));

    }

    public static void teleport(Player player, Location location) {
        player.teleport(location);
    }
}

