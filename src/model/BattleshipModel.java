package Model;

public class BattleshipModel {

	/*MODELLO*/
	
	private Game game;
	private boolean active;
	
	public BattleshipModel() {
		active= false;
		game= new Game();
	}
	

	public void newGame(Boolean hard, int time) {
		game = new Game(hard, time);
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
