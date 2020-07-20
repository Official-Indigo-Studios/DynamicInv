package me.thebirmanator.dynamicinv.commands;

import me.thebirmanator.dynamicinv.api.InventoryProfile;
import me.thebirmanator.dynamicinv.api.ProfileManager;
import me.thebirmanator.dynamicinv.utils.PlayerUtils;
import me.thebirmanator.dynamicinv.utils.Text;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoadInvCmd implements CommandExecutor {

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
            InventoryProfile profile = ProfileManager.getProfile(player.getUniqueId());
            if (profile != null) {
                String invName = ProfileManager.DEFAULT_PROFILE;
                if (args.length > 1) {
                    invName = args[1];
                }
                if (profile.getInventory(invName) != null) {
                    profile.fillInv(invName);
                }
                sender.sendMessage(Text.format("&aSet inventory to &f" + invName));
            } else {
                sender.sendMessage(Text.format("&cThis player does not have any saved inventories."));
            }
        }
        return true;
    }
}
