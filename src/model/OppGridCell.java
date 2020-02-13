package model;


/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class OppGridCell extends Cell{

	private static final long serialVersionUID = 1L;

	private OppGridCellState state;
	
	/**
	 * Il costruttore OppGridCell(int x , int y) si riferisce alla
	 * superclasse impostando il valore di x ed y. Inoltre
	 * setta il valore del campo state ad uno di quelli validi
	 * forniti dalla classe Enum OppGridCellState
	 * 
	 * @param x
	 * @param y
	 */
	public OppGridCell(int x , int y) {
		super(x,y);
		state=OppGridCellState.DEFAULT;
		
	}
	
	/**
	 * Il costruttore OppGridCell(Cell c) si riferisce con
	 * l'operatore super alla super classe per creare un oggetto
	 * di tipo Cell. Inoltre setta il valore del campo state ad uno
	 * di quelli validi forniti dalla classe Enum OppGridCellState
	 * 
	 * @param c
	 */
	public OppGridCell(Cell c) {
		super(c);
		state=OppGridCellState.DEFAULT;
	}

	/**
	 * Ritorna il valore del campo state
	 * 
	 * @return
	 */
	public OppGridCellState getState() {
		return state;
	}

	/**
	 * Imposta il valore del campo sta a quello del parametro
	 * in input alla funzione
	 * 
	 * @param state
	 */
	public void setState(OppGridCellState state) {
		this.state = state;
	}
}
