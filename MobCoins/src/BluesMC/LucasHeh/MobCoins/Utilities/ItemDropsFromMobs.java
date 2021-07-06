package BluesMC.LucasHeh.MobCoins.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemDropsFromMobs {
	
	public List<ItemStack> cowDrops(Player p) {
		Random rand = new Random();
		boolean looting = p.getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
		int lootingMultiplier = 1;
		if(looting) {
			lootingMultiplier = rand.nextInt(p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS));
			if(lootingMultiplier == 0) lootingMultiplier = 1;
		}
		int beefAmt = rand.nextInt(3)*lootingMultiplier;
		int leatherAmt = rand.nextInt(3)*lootingMultiplier;
		
		ItemStack beef = new ItemStack(Material.BEEF);
		beef.setAmount(beefAmt);
		ItemStack leather = new ItemStack(Material.LEATHER);
		leather.setAmount(leatherAmt);
		
		List<ItemStack> list = new ArrayList();
		list.add(beef);
		list.add(leather);
		return list;
	}

}
