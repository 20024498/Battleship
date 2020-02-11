package model;

public class BattleshipModel {

	/*MODELLO*/
	
	private Game game;
	

	public void newGame(Boolean hard, int time) {
		game = new Game(hard, time);
	}
	
	public void saveGame() {
		game.save(); 
	}
	
	public void loadGame() {
		game = game.load();
	}
}
