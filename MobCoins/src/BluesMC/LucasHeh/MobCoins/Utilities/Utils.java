package BluesMC.LucasHeh.MobCoins.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import BluesMC.LucasHeh.MobCoins.Main;

public class Utils {
	
	public HashMap<String, Integer> coinBalance;
	public FileConfiguration config;
	public String chatPrefix;
	
	public Utils() {
		coinBalance = new HashMap<String, Integer>();
		config = Main.getInstance().getConfig();
		chatPrefix = config.getString("chatPrefix");
	}
	
	public ItemStack MobCoin() {
		ItemStack item = new ItemStack(Material.valueOf(config.getString("Coin.Item")));
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', 
				config.getString("Coin.Name")));
		itemMeta.setLore(listTranslate(config.getStringList("Coin.Lore")));
		if(config.getBoolean("Coin.Glowing")) {
			itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
			itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		item.setItemMeta(itemMeta);
		return item;
	}
	
	public List<String> listTranslate(List<String> list){
		List<String> converted = new ArrayList<String>();
		for(String str : list) {
			converted.add(ChatColor.translateAlternateColorCodes('&', str));
		}
		return converted;
	}
	
}
