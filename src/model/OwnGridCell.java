package model;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class OwnGridCell extends Cell {

	private static final long serialVersionUID = 1L;

	private boolean occupied;
	private ShipType shipType;
	
	/**
	 * Il costruttore OwnGridCell(int x, int y) utilizza
	 * l'operatore super per riferirsi alla superclasse ed
	 * impostare i valori di x ed y. Inoltre imposta sia
	 * il valore del campo occupied a false, per identificare
	 * o meno la presenza di una nave, sia quello del 
	 * campo shipType, di default a null, ma potrebbe rappresentare
	 * la presenza o meno di un tipo di nave
	 * 
	 * @param x
	 * @param y
	 */
	public OwnGridCell(int x,int y) {
		super(x,y);	
		occupied=false;
		shipType=null;
	}
	
	/**
	 * Il costruttore OwnGridCell(Cell c) usa l'operatore super 
	 * per riferirsi alla superclasse e generare un oggetto di tipo
	 * Cell. Inoltre imposta sia
	 * il valore del campo occupied a false, per identificare
	 * o meno la presenza di una nave, sia quello del 
	 * campo shipType, di default a null, ma potrebbe rappresentare
	 * la presenza o meno di un tipo di nave
	 * 
	 * @param c
	 */
	public OwnGridCell(Cell c) {
		super(c);
		occupied=false;
		shipType=null;
	}

	/**
	 * Controlla il valore del campo occupied
	 * 
	 * @return occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * Controlla il valore del campo shipType
	 * 
	 * @return shipType
	 */
	public ShipType getShipType() {
		return shipType;
	}

	/**
	 * Impopsta il valore del campo occupied a true
	 * 
	 */
	public void occupy() {
		occupied = true;
	}

	/**
	 * Imposta il valore del campo shipType al valore passato
	 * in input al metodo (shipType)
	 * 
	 * @param shipType
	 */
	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}
}
