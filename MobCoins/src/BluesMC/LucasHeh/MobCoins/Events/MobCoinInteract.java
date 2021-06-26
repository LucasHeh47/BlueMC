package BluesMC.LucasHeh.MobCoins.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import BluesMC.LucasHeh.MobCoins.Main;
import BluesMC.LucasHeh.MobCoins.Utilities.Utils;

public class MobCoinInteract implements Listener{
	
	@EventHandler
	public void coinInteract(PlayerInteractEvent e) {
		if(e.getAction() != Action.RIGHT_CLICK_AIR || e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		Utils utils = Main.getInstance().utils;
		if(e.getPlayer().getItemInHand().getType() == utils.MobCoin().getType()
				&& e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(utils.MobCoin().getType())) {
			ItemStack item = e.getItem();
			e.getPlayer().getInventory().removeItem(item);
			utils.addMobCoinBalance(e.getPlayer(), item.getAmount());
			e.getPlayer().sendMessage(Main.getInstance().getConfig().getString("Messages.Redeemed").replace("{amount}", String.valueOf(item.getAmount())));
		}
	}

}
