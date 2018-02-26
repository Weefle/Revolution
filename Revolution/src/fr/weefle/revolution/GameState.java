package fr.weefle.revolution;

public enum GameState {

	STARTING(0), WAITING(1), STOPPING(2), STARTED(3), STOPPED(4);
	
	private int id;
	
	private GameState(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}