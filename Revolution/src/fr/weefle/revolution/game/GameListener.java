package fr.weefle.revolution.game;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.weefle.revolution.Revolution;

public class GameListener implements Listener {
	
	private Revolution main;
	
	public GameListener(Revolution revolution) {
		this.main = revolution;
	}

	@EventHandler
public void playerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		p.getInventory().clear();
		
		if(!main.isState(GameState.WAITING)) {
			p.setGameMode(GameMode.SPECTATOR);
			p.sendMessage("§4La partie a déjà commencé!");
			return;
		}
		
		if(!main.getPlayers().contains(p)) main.getPlayers().add(p);
		p.setGameMode(GameMode.ADVENTURE);
		
		if(main.isState(GameState.WAITING) && main.getPlayers().size() == 1) {
			GameManager gm = new GameManager(main);
			gm.runTaskTimer(main, 0, 20);
			main.setState(GameState.STARTING);
		}
		
	}
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e) {
		
if(main.isState(GameState.PLAYING)) {
			
			
			
		}
		
	}

}
