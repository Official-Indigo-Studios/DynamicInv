package me.thebirmanator.dynamicinv.utils;

import org.bukkit.ChatColor;

public class Text {

    public static String format(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
