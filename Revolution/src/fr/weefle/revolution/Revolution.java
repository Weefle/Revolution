package fr.weefle.revolution;

import org.bukkit.plugin.java.JavaPlugin;

public class Revolution extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//GameManager.start();
		getServer().getPluginManager().registerEvents(new GameListener(), this);
		super.onEnable();
	}
	
	@Override
	public void onDisable() {

		super.onDisable();
	}

}
