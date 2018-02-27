package fr.weefle.revolution.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import fr.weefle.revolution.Revolution;

public class GameManager extends BukkitRunnable {
	
	private int timer = 10;
	private Revolution main;
	public GameManager(Revolution revolution) {
		this.main = revolution;
	}

	@Override
	public void run() {
		
		for(Player pl : main.getPlayers()) {
			pl.setLevel(timer);
		}
		
		if(timer == 0) {
			Bukkit.broadcastMessage("§6Lancement du jeu!");
			cancel();
			main.setState(GameState.PLAYING);
		}
		
		timer--;
		
	}

}
