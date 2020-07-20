package me.thebirmanator.dynamicinv.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtils {

    public static Player findPlayer(String playerName) {
        return Bukkit.getPlayer(playerName);
    }

    public static Player findPlayer(String playerName, Player defaultPlayer) {
        Player player = Bukkit.getPlayer(playerName);
        if (player == null) player = defaultPlayer;
        return player;
    }
}
