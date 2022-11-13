package de.tayblocks.lobbyplugin.inv;

import de.tayblocks.lobbyplugin.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Games implements Listener {
    public final Inventory inv;

    public Games() {
        inv = Bukkit.createInventory(null, 9, "§l§3Spielmodus wöhlen");

        initializeItems();
    }
    public void initializeItems() {
        inv.setItem(3, new ItemBuilder(Material.DIAMOND_SWORD, "§3PVP").lore("§lKämpfe gegen ein anderen Spieler").build());
        inv.setItem(4 ,new ItemBuilder(Material.RED_BED, "§cBedWars").lore("§lZerstöre das Bett vom gegner auf mehrere Inseln").build());
        inv.setItem(5, new ItemBuilder(Material.GRASS_BLOCK, "§1SkyBlock").lore("§lDu hast eine kleine Insel und musst überleben").build());
        inv.setItem(6, new ItemBuilder(Material.DIAMOND_AXE, "§3SkyWars").lore("§lKämpfe gegen ein anderen Spieler auf Inseln mit OP Truhen").build());
    }

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event) {
        if (event.getItem().getType() == Material.COMPASS) {
            event.getPlayer().openInventory(this.inv);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!e.getInventory().equals(inv)) return;

        e.setCancelled(true);
        if (e.getCurrentItem().getType() != Material.COMPASS) {
            e.getWhoClicked().sendMessage("§l§cServer ist offline");
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
