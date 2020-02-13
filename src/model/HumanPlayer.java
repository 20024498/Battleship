package model;

import java.awt.Point;

public class HumanPlayer extends Player{

	private static final long serialVersionUID = 1L;
	private ShipOrientation choiceOrientation;
	private PlayerState pState;

	public HumanPlayer() {
		super();
		choiceOrientation= ShipOrientation.VERTICALE;
		pState = PlayerState.DEFAULT;
	}
	
	public void switchOrientation() {
		if(choiceOrientation.equals(ShipOrientation.ORIZZONTALE))
			setChoiceOrientation(ShipOrientation.VERTICALE);
		else if(choiceOrientation.equals(ShipOrientation.VERTICALE))
			setChoiceOrientation(ShipOrientation.ORIZZONTALE);
	}

	public ShipOrientation getChoiceOrientation() {
		return choiceOrientation;
	}

	private void setChoiceOrientation(ShipOrientation choiceOrientation) {
		this.choiceOrientation = choiceOrientation;
	}

	public PlayerState getpState() {
		return pState;
	}

	public void setpState(PlayerState pState) {
		this.pState = pState;
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
