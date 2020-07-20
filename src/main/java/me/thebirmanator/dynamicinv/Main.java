package me.thebirmanator.dynamicinv;

import me.thebirmanator.dynamicinv.api.ProfileManager;
import me.thebirmanator.dynamicinv.commands.LoadInvCmd;
import me.thebirmanator.dynamicinv.commands.SaveInvCmd;
import me.thebirmanator.dynamicinv.listeners.PlayerDeathListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        ProfileManager.load();
        getCommand("saveinv").setExecutor(new SaveInvCmd());
        getCommand("loadinv").setExecutor(new LoadInvCmd());
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "DynamicInv enabled!");
    }
}
