package de.tayblocks.lobbyplugin;

import de.tayblocks.lobbyplugin.commands.LobbyCommand;
import de.tayblocks.lobbyplugin.commands.SpawnCommand;
import de.tayblocks.lobbyplugin.inv.Games;
import de.tayblocks.lobbyplugin.listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyPlugin extends JavaPlugin {
    private static LobbyPlugin instance;
    private Games games;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getServer().getPluginManager().registerEvents(new Games(), this);
        Bukkit.getPluginCommand("spawn").setExecutor(new SpawnCommand());
        Bukkit.getPluginCommand("lobby").setExecutor(new LobbyCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LobbyPlugin getInstance() {
        return instance;
    }

    public Games getGames() {
        return games;
    }
}
