package me.thebirmanator.dynamicinv.commands;

import me.thebirmanator.dynamicinv.api.InventoryProfile;
import me.thebirmanator.dynamicinv.api.ProfileManager;
import me.thebirmanator.dynamicinv.utils.PlayerUtils;
import me.thebirmanator.dynamicinv.utils.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaveInvCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = null;
        if (args.length > 0) {
            player = PlayerUtils.findPlayer(args[0]);
        } else {
            if (sender instanceof Player) {
                player = (Player) sender;
            } else {
                sender.sendMessage(Text.format("&cYou must specify a player."));
            }
        }
        if (player != null) {
            // We have a valid player
            String invName = ProfileManager.DEFAULT_PROFILE;
            if (args.length > 1) {
                invName = args[1];
            }
            InventoryProfile invProfile = ProfileManager.getProfile(player.getUniqueId());
            if (invProfile == null) {
                invProfile = new InventoryProfile(player.getUniqueId());
            }
            invProfile.addInv(invName, player.getInventory());
            ProfileManager.cacheProfile(invProfile);
            sender.sendMessage(Text.format("&aSaved inventory under the name &f" + invName));
        } else {
            sender.sendMessage(Text.format("&cInvalid player specified."));
        }
        return true;
    }
}
