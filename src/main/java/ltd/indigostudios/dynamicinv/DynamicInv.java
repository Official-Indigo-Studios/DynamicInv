package ltd.indigostudios.dynamicinv;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class DynamicInv extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "DynamicInv enabled!");
    }
}
