package model;

import java.awt.Point;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public abstract class Player {
	
	private static final int SHIPNUM = 5;
	private OwnGrid ownGrid;
	private OppGrid oppGrid;
	private LinkedHashMap<Point,Ship> ships;
	private int shipsAlive;
	private LinkedList<Ship> shipHouse;
	
	/**
	 * Il costruttore Player() serve ad impostare tutte i campi del giocatore.
	 * Imposta la mappa del giocatore, e quella dell'avversario, una 
	 * LinkedHashMap<Point,Ship>() per associare ad un punto della griglia
	 * una nave, il numero della navi iniziali e riempie una LinkedList<Ship>
	 * con il tipo di navi a disposizione per la propria flotta
	 * 
	 */
	public Player() {
		
		this.ownGrid = new OwnGrid();
		this.oppGrid = new OppGrid();
		this.ships = new LinkedHashMap<Point,Ship>();
		shipsAlive = SHIPNUM;
		shipHouse = new LinkedList<Ship>();
		shipHouseInit();
	}

	private void shipHouseInit() {
		
		for(ShipType s : ShipType.values()) { 
			shipHouse.add(new Ship(s));
		}
					
	}
	
	/**
	 * Questa funzione serve per posizionare una nave sulla propria griglia.
	 * Dopo aver verificato con la funzione lecitPosition(...) che la posizione
	 * per la nave sia lecita, imposta le celle che il tipo di nave occuperà sulla 
	 * mappa. Con occupy(), occupa la cella disponibile, con setShipType(...) imposta
	 * il tipo di nave e con put(...) la inserisce nella LinkedHashMap
	 * 
	 * @param ship
	 * @param orientation
	 * @param x
	 * @param y
	 * @return un valore booleano che dice se la nave è stata poszionata o meno
	 */
	protected boolean shipPositioning(Ship ship ,ShipOrientation orientation, int x, int y) {
		
		if(lecitPosition(ship.getLength(), orientation, x, y)) {
			
			ship.setPosition(new ShipCell(x,y), orientation);
			
			for(ShipCell c : ship.getCells().values()) {
				ownGrid.getCells()[c.x][c.y].occupy();
				ownGrid.getCells()[c.x][c.y].setShipType(ship.getType());
				ships.put(c, ship);
			}
				
			return true;	
		}
		return false;	
	} 
	
	/**
	 * Con questa funzione si verifica che la posizione per una nave, sulla mappa sia lecita
	 * La verifica viene effettuata controllando che le cella che si vogliono occupare non lo 
	 * siano già
	 * 
	 * @param shipLength
	 * @param orientation
	 * @param x
	 * @param y
	 * @return un tipo booleano che specifica se la posizione fosse valida o meno
	 */
	public boolean lecitPosition(int shipLength ,ShipOrientation orientation, int x, int y) {
		
		if(orientation.equals(ShipOrientation.ORIZZONTALE)) {
			if(shipLength+x >= Grid.DIM)
				return false;
			
			for(int i=0;i<shipLength;i++)
				if(ownGrid.getCells()[x+i][y].isOccupied())
					return false;
		}
		else {
			if(shipLength+y >= Grid.DIM)
				return false;
			
			for(int i=0;i<shipLength;i++)
				if(ownGrid.getCells()[x][y+i].isOccupied())
					return false;
		}
		
		
		return true;
	}
	
	/**
	 * Questa funzione controlla se una propria nave è stata colpita
	 * da una mossa del computer
	 * 
	 * @param x
	 * @param y
	 * @return ShipState.ILLESA la nostra nave non è statta colpita
	 * @return s.getState() ritorniamo lo stato della nave se non è stata affondata
	 */
	public ShipState hitOwnShip(int x, int y) {
		
		/*TODO eccezione griglia non colpita*/
		
			Ship s = ships.get(new Point(x,y));
			
			if(s!=null) {
				if(ownGrid.isHit(x, y)) {
					
					s.hit(x, y);
					if(s.getState().equals(ShipState.AFFONDATA)) 
						shipsAlive--;
					
					return s.getState();
				}
			}
			
		return ShipState.ILLESA;				
	}
	
	/**
	 * Questa funzione controlla l'associazione  tra cella e nave
	 * nella LinkedHashMap
	 * 
	 * @param x
	 * @param y
	 * @return ships.containsKey(new Point(x,y))
	 */
	public boolean isShipOnCell(int x, int y) {
		
		return ships.containsKey(new Point(x,y));
	}
	
	/**
	 * Questa funzione ritorna l'associazione tra cella e nave
	 * nella LinkedHashMap
	 * 
	 * @param x
	 * @param y
	 * @return ships.get(new Point(x,y))
	 */
	public Ship getShipOnCell(int x, int y) {
		
		return ships.get(new Point(x,y));		
	}
	
	/**
	 * Questa funzione imposta a colpita la cella della mappa
	 * di un giocatore avversario, solo dopo essersi assicurata
	 * che non lo sia già
	 * 
	 * @param x
	 * @param y
	 */
	public void hitOppGrid (int x, int y) {
		
		if(!oppGrid.isHit(x, y))
			oppGrid.hit(x, y);
	}
	
	/**
	 * Questa funzione imposta a colpita la cella della propria mappa
	 * solo dopo essersi assicurata che non lo sia già
	 * 
	 * @param x
	 * @param y
	 */
	public void hitOwnGrid(int x, int y) {
		if(!ownGrid.isHit(x, y))
			ownGrid.hit(x, y);
	}

	/**
	 * Questa funzione serve ad ottenere il numero di navi
	 * 
	 * @return SHIPNUM
	 */
	public static int getShipnum() {
		return SHIPNUM;
	}

	/**
	 * Questa funzione serve ad ottenere il campo oppGrid
	 * 
	 * @return  oppGrid
	 */
	public OppGrid getOppGrid() {
		return oppGrid;
	}

	/**
	 * Questa funzione ritorna il campo LinkedHashMap 
	 * 
	 * @return ships
	 */
	public LinkedHashMap<Point,Ship> getShips() {
		return ships;
	}

	/**
	 * Questa funzione ritorna il campo shipsAlive, ovvero il 
	 * nuemro di navi acnora rimanenti
	 * 
	 * @return shipsAlive
	 */
	public int getShipsAlive() {
		return shipsAlive;
	}

	/**
	 * Questa funzione serve ad ottenere il campo ownGrid
	 * 
	 * @return ownGrid
	 */
	public OwnGrid getOwnGrid() {
		return ownGrid;
	}

	/**
	 * Questa funzione serve ad ottenere il campo shipHouse, ovvero 
	 * la propria flotta di navi
	 * 
	 * @return shipHouse
	 */
	public LinkedList<Ship> getShipHouse() {
		return shipHouse;
	}	
}
