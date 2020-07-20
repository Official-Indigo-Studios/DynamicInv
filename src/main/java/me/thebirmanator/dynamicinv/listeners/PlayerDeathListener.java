package me.thebirmanator.dynamicinv.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.hasPermission("dynamicinv.keepinv")) {
            event.setKeepInventory(true);
            event.getDrops().clear();
        }

        if (player.hasPermission("dynamicinv.keepexp")) {
            event.setKeepLevel(true);
            event.setDroppedExp(0);
        }
    }
}
