package model;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class BattleshipModel {

	/*MODELLO*/
	
	private Game game;
	private boolean active;
	
	/**
	 * Il costruttore inizializza i campi della classe
	 * active a false e per game invece viene 
	 * creato un nuovo oggetto
	 * 
	 */
	public BattleshipModel() {
		active= false;
		game= new Game();
	}
	
	/**
	 * Questo metodo serve a creare una nuova partita
	 * con i parametri passati in input
	 * 
	 * @param diff
	 * @param time
	 */
	public void newGame(Difficulty diff, int time) {
		game = new Game(diff, time);
		active=true;
	}
	
	/**
	 * Questo metodo serve a salvare una partita
	 * 
	 */
	public void saveGame() {
		if(active==true)
			game.save(); 
	}
	
	/**
	 * Questo metodo serve a caricare una partita
	 * 
	 */
	public void loadGame() {
		game = game.load();
		active=true;
	}
	
	/**
	 * Questo metodo serve per generare la finestra di aiuto
	 * 
	 */
	public void help() {
		
	}
}
