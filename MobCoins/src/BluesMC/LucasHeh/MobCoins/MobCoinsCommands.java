package BluesMC.LucasHeh.MobCoins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import BluesMC.LucasHeh.MobCoins.Utilities.Utils;

public class MobCoinsCommands implements CommandExecutor {
	
	public MobCoinsCommands(Main main) {
		main.getCommand("MobCoins").setExecutor(this);
	}

	/*
	* mobcoins balance <player>
	* mobcoins balance
	* mobcoins withdraw <num>
	*/
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) return true;
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("balance")) {
				Player p = (Player) sender;
				p.sendMessage(Main.getInstance().utils.chatPrefix + ChatColor.translateAlternateColorCodes('&',
						Main.getInstance().getConfig().getString("Messages.Balance").replace("{amount}",  Main.getInstance().utils.coinBalance.get(p.getUniqueId().toString()).toString())));
			}
			if(args[0].equalsIgnoreCase("withdraw")) {
				sender.sendMessage(Main.getInstance().utils.chatPrefix + ChatColor.translateAlternateColorCodes('&', "&cUsage: /MobCoins withdraw <amount>"));
			}
		} else if(args.length == 2) {
			if(args[0].equalsIgnoreCase("balance")) {
				Player p = Bukkit.getPlayerExact(args[1]);
				p.sendMessage(Main.getInstance().utils.chatPrefix + ChatColor.translateAlternateColorCodes('&',
						Main.getInstance().getConfig().getString("Messages.OtherBalance").replace("{PLAYER}", p.getName())).replace("{amount}",  Main.getInstance().utils.coinBalance.get(p.getUniqueId().toString()).toString()));
			}
			if(args[0].equalsIgnoreCase("withdraw")) {
				int amt = Integer.parseInt(args[1]);
				Utils utils = Main.getInstance().utils;
			}
		}
		return true;
	}

}
