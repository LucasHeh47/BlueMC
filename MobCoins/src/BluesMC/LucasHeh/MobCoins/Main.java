package BluesMC.LucasHeh.MobCoins;

import org.bukkit.plugin.java.JavaPlugin;

import BluesMC.LucasHeh.MobCoins.Utilities.Utils;

public class Main extends JavaPlugin {
	
	private static Main instance;
	public Utils utils;

	public void OnEnable() {
		instance = this;
		this.saveDefaultConfig();
		utils = new Utils();
	}
	
	public void OnDisable() {
		
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
