package BluesMC.LucasHeh.MobCoins.Events;

import java.util.Random;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import BluesMC.LucasHeh.MobCoins.Main;
import BluesMC.LucasHeh.MobCoins.Utilities.MobChance;
import BluesMC.LucasHeh.MobCoins.Utilities.Utils;

public class MobDrops implements Listener {

	@EventHandler
	public void mobDeathEvent(EntityDeathEvent e) {
		if(e.getEntity().getKiller() == null) return;
		if(e.getEntity().getKiller() instanceof Player) {
			float multiplier = 1.0f; // WORK ON THIS LATER
			Random rand = new Random();
			// Work on random result chance thing
			EntityType mobType = e.getEntityType();
			Utils utils = Main.getInstance().utils;
			MobChance chance = utils.mobChance;
			
			if(mobType == EntityType.COW) {
				
			}
			
		} else {
			return;
		}
	}
	
}
