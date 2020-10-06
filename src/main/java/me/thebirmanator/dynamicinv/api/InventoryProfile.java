package me.thebirmanator.dynamicinv.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InventoryProfile {

    private UUID uuid;
    private Map<String, ItemStack[]> inventories;

    //TODO: do something with armour contents (they are not part of getContents()
    public InventoryProfile(UUID uuid) {
        this.uuid = uuid;
        inventories = new HashMap<>();
    }

    public InventoryProfile(UUID uuid, Map<String, ItemStack[]> inventories) {
        this.uuid = uuid;
        this.inventories = inventories;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void addInv(String name, Inventory inventory) {
        inventories.put(name, inventory.getContents());
    }

    public void removeInv(String name) {
        inventories.remove(name);
    }

    public ItemStack[] getInventory(String name) {
        return inventories.get(name);
    }

    public void fillInv(String invName) {
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            player.getInventory().setContents(getInventory(invName));
        }
    }

    public void fillInv(String invName, Player player) {
        player.getInventory().setContents(getInventory(invName));
    }
}
