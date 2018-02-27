package fr.weefle.revolution.game;

public interface Game {
	
	public GameState getState();

	public void setState(GameState state);

	boolean isState(GameState state);

}
