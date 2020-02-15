package model;

import java.awt.Point;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class HumanPlayer extends Player {

	private static final long serialVersionUID = 1L;
	private ShipOrientation choiceOrientation;
	

	/**
	 * Il costruttore HumanPlayer() si riferisce, tramite l'operatore super,
	 * alla sua superclasse. Inoltre, imposta il valore dei campi
	 * pState e choiceOrientation. Rispettivamente questi campi rappresentano
	 * lo stato del giocatore durante la partita e l'orientamento della nave
	 * 
	 */
	public HumanPlayer() {
		super();
		choiceOrientation = ShipOrientation.ORIZZONTALE;
		
	}
	
	/**
	 * Questo metodo serve a cambiare l'orientamento della nave durante
	 * il suo posizionamento sulla mappa
	 * 
	 */
	public void switchOrientation() {
		if(choiceOrientation.equals(ShipOrientation.ORIZZONTALE))
			setChoiceOrientation(ShipOrientation.VERTICALE);
		else if(choiceOrientation.equals(ShipOrientation.VERTICALE))
			setChoiceOrientation(ShipOrientation.ORIZZONTALE);
	}

	/**
	 * Ritorna il valore del campo choiceOrientation
	 * 
	 * @return choiceOrientation
	 */
	public ShipOrientation getChoiceOrientation() {
		return choiceOrientation;
	}

	/**
	 * Imposta il valore del campo choiceOrientation a quello in input
	 * alla funzione
	 * 
	 * @param choiceOrientation
	 */
	private void setChoiceOrientation(ShipOrientation choiceOrientation) {
		this.choiceOrientation = choiceOrientation;
	}



	public boolean humanShipPosition(Point p) {
		
		if(getShipHouse().isEmpty())
			return false;
		
		Ship ship = getShipHouse().peek();
		
		boolean b = shipPositioning(ship, choiceOrientation, p.x, p.y);
		
		
		if(b) {
			getShipHouse().remove();
			return true;
		}
		
		else
			return false;	
	}
}
