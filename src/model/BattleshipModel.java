package model;

public class BattleshipModel {

	/*MODELLO*/
	
	private Game game;
	private boolean active;
	
	public BattleshipModel() {
		active= false;
		game= new Game();
	}
	

	public void newGame(Difficulty diff, int time) {
		game = new Game(diff, time);
		active=true;
	}
	
	public void saveGame() {
		if(active==true)
			game.save(); 
	}
	
	public void loadGame() {
		game = game.load();
		active=true;
	}
	
	public void help() {
		
	}
}
