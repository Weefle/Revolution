package fr.weefle.revolution.game;

public interface Game {
	
	public void setState(GameState state);

	boolean isState(GameState state);

}
