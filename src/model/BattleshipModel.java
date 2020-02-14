package model;

import java.io.File;
import java.io.IOException;

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
	public Boolean saveGame(File file) {
		if(active==true) {
			
			try {
			game.save(file); 
			
			}
		
		catch(IOException ex) 
        { 
            return false; 
        } 
		
		return true;
		
		}
		
		return false;
	}
	
	/**
	 * Questo metodo serve a caricare una partita
	 * 
	 */
	public boolean loadGame(File file) {
		try {
		game = game.load(file);
		active=true;
		}
		
		catch(IOException ex) 
        { 
             game=null;
             return false;
        } 
          
        catch(ClassNotFoundException ex) 
        { 
             game=null;
             return false;
        } 
		
		return true;
	}
	
	/**
	 * Questo metodo serve per generare la finestra di aiuto
	 * 
	 */
	public void help() {
		
	}

	public Game getGame() {
		return game;
	}

	public boolean isActive() {
		return active;
	}
	
	
}
