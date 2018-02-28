package fr.weefle.revolution;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import fr.weefle.revolution.game.Game;
import fr.weefle.revolution.game.GameListener;
import fr.weefle.revolution.game.GameState;

public class Revolution extends JavaPlugin implements Game {
	
	private List<Player> players = new ArrayList<>();
	private GameState state;
	
	@Override
	public void onEnable() {
		setState(GameState.WAITING);
		getServer().getPluginManager().registerEvents(new GameListener(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public void setState(GameState state) {
		this.state = state;
	}
	
	@Override
	public boolean isState(GameState state) {
		return this.state == state;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	

}
