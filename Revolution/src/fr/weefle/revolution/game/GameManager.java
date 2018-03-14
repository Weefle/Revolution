package fr.weefle.revolution.game;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import fr.weefle.revolution.Revolution;
import fr.weefle.revolution.npc.NpcGui;
import fr.weefle.wazeapi.WazeAPI;

public class GameManager extends BukkitRunnable {
	
	NpcGui npc = new NpcGui();
	
	private int timer = 10;
	private Revolution main;
	public GameManager(Revolution revolution) {
		this.main = revolution;
	}

	@Override
	public void run() {
		
		for(Player pl : main.getPlayers()) {
			pl.setLevel(timer);
			if(main.getPlayers().size() < 2) {
				cancel();
				main.setState(GameState.WAITING);
				pl.setLevel(0);
				Bukkit.broadcastMessage("§6Il manque des joueurs!");
			}
			if(timer == 10 || timer == 5 || timer == 4 || timer ==3 || timer ==2 || timer == 1) {
				try {
					WazeAPI.getInstance().getTitle().sendTitle(pl, "§4" + timer, "", 20);
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
						| IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(timer == 0) {
			Bukkit.broadcastMessage("§6Lancement du jeu!");
			npc.createGUI(10, "test");
			cancel();
			main.setState(GameState.PLAYING);
		}
		
		timer--;
		
	}

}
