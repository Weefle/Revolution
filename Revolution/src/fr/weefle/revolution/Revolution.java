package fr.weefle.revolution;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import fr.weefle.revolution.commands.NPCCommand;
import fr.weefle.revolution.game.Game;
import fr.weefle.revolution.game.GameListener;
import fr.weefle.revolution.game.GameState;

public class Revolution extends JavaPlugin implements Game {
	
	private List<Player> players = new ArrayList<>();
	private GameState state;
	
	@Override
	public void onEnable() {
		/*FakeAPI fake = new FakeAPI();
		fake.enable(this);*/
		/*GameStatus gt = new GameStatus("WAITING");
		GameStatus.setCurrentStatus(gt);
		MinigameLogic mg = new MinigameLogic(false, false, false, false, false, false, false, false, false, false, false, GameStatus.getCurrentStatus());
		System.out.println("" + mg.getGameStatus());*/
		setState(GameState.WAITING);
		getCommand("spawnnpc").setExecutor(new NPCCommand());
		getServer().getPluginManager().registerEvents(new GameListener(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}

	public void setState(GameState state) {
		this.state = state;
	}
	
	public boolean isState(GameState state) {
		return this.state == state;
	}
	
	public GameState getState() {
		return state;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	

}
