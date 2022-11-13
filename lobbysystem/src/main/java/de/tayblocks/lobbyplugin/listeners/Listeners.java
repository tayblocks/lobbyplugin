package de.tayblocks.lobbyplugin.listeners;

import de.tayblocks.lobbyplugin.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Time;

import static org.bukkit.event.inventory.InventoryAction.HOTBAR_SWAP;

public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();
        player.performCommand("spawn");

        event.setJoinMessage("");

        player.getInventory().setItem(4, new ItemBuilder(Material.COMPASS, "§l§3Spielmodus wählen").lore("§lWähle dein Spielmodus").build());
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage("");
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (!event.getPlayer().isOp())
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!event.getPlayer().isOp())
            event.setCancelled(true);
    }


    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (!event.getPlayer().isOp())
        event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getAction() == InventoryAction.HOTBAR_MOVE_AND_READD || event.getAction() == HOTBAR_SWAP)
        {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }


    @EventHandler
    public void onFillBucket(PlayerBucketFillEvent event) {
        if (!event.getPlayer().isOp())
            event.setCancelled(true);
    }



    @EventHandler
    public void onEmptyBucket(PlayerBucketEmptyEvent event) {
        if (!event.getPlayer().isOp())
            event.setCancelled(true);
    }



    @EventHandler
    public void onFishBucket(PlayerBucketFishEvent event) {
        if (!event.getPlayer().isOp())
            event.setCancelled(true);
    }

}
