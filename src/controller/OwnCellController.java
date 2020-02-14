package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.BattleshipModel;
import model.Grid;
import model.Ship;
import model.ShipOrientation;
import view.OwnCellView;

public class OwnCellController implements MouseListener{

	OwnCellView cellView;
	BattleshipModel model;
	
	
	public OwnCellController(OwnCellView cellView,BattleshipModel model) {
		this.cellView= cellView;
		this.model=model;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!model.getGame().getPlayer().getShipHouse().isEmpty()) {
			
			if(model.getGame().playerPosition(cellView.getPoint()))
				cellView.shipLocation();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(!model.getGame().getPlayer().getShipHouse().isEmpty()) {
			
			int l = model.getGame().getPlayer().getShipHouse().peek().getLength();
			
			if(model.getGame().getPlayer().getChoiceOrientation().equals(ShipOrientation.ORIZZONTALE)) {
			
				if(cellView.getPoint().x+l<Grid.DIM) {}
					//Coloro tutto di verde
				else {}
					//Coloro tutto di rosso
					
					
			}
			else if(model.getGame().getPlayer().getChoiceOrientation().equals(ShipOrientation.VERTICALE)) {
				
			}
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(!model.getGame().getPlayer().getShipHouse().isEmpty()) {
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
