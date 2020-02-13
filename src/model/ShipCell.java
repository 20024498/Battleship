package model;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class ShipCell extends Cell{

	private static final long serialVersionUID = 1L;

	/**
	 * Il costruttore ShipCell(int x, int y), tramite 
	 * l'operatore super, si riferisce alla superclasse
	 * per impostare i valori x ed y.
	 * 
	 * @param x
	 * @param y
	 */
	public ShipCell(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Il costruttore ShipCell(Cell c) usa l'operatore super per
	 * riferirsi alla superclasse
	 * 
	 * @param c
	 */
	public ShipCell(Cell c) {
		super(c);
	}
}
