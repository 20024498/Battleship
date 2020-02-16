package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		/*active= false;
		game= new Game();*/
		
		game = new Game(Difficulty.MEDIA, 10);
		active=true;
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
	
	public void saveGame() {
		if(active==true)
			System.out.println(saveGameAux());
	}
	
	public void loadGame() {
		
		boolean b = loadGameAux();
		System.out.println(b);
		if(b)
			active=true;	
	}
	
	/**
	 * Questo metodo serve a salvare una partita
	 * 
	 */
	private Boolean saveGameAux() {
		
			  
			try {
			FileOutputStream fileStream = new FileOutputStream("saveFile.ser"); 
            ObjectOutputStream out = new ObjectOutputStream(fileStream); 
            try {  
            out.writeObject(this.game); 
            }
            catch(IOException e) {
            	e.printStackTrace();
            }
              
            out.close(); 
            fileStream.close(); 
            }
			
			catch(FileNotFoundException e) {
				System.out.println("notfound");
				return false;}
			catch(IOException e) {
				System.out.println("IO");
				return false;
				}   
			
			return true;
	              
		
	}
	
	/**
	 * Questo metodo serve a caricare una partita
	 * @throws  
	 * 
	 */
	private boolean loadGameAux()  {
		
		try {
		
			FileInputStream fileStream = new FileInputStream("saveFile.ser"); 
			ObjectInputStream in = new ObjectInputStream(fileStream); 
			
			this.game = (Game)in.readObject(); 
	    
			in.close(); 
			fileStream.close(); 
	    
		}
		
		catch(FileNotFoundException e){return false;}
		
		catch(IOException e) {return false;}
		
		catch(ClassNotFoundException e) {return false;}
	        
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
