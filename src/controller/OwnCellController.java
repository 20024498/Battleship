package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import model.BattleshipModel;
import model.Grid;
import model.ShipOrientation;
import view.BattleshipView;
import view.OwnCellView;

public class OwnCellController implements MouseListener{

	OwnCellView cellView;
	BattleshipModel model;
	BattleshipView view;
	
	
	public OwnCellController(OwnCellView cellView,BattleshipModel model,BattleshipView view) {
		this.cellView= cellView;
		this.model=model;
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(model.isActive()==true)
			if(!model.getGame().getPlayer().getShipHouse().isEmpty()) {
				int l = model.getGame().getPlayer().getShipHouse().peek().getLength();
				if(SwingUtilities.isLeftMouseButton(e)) {
					if(model.getGame().playerPosition(cellView.getPoint()))
						shipColoring(l);
				}
				else if(SwingUtilities.isRightMouseButton(e)){
					gridReverting(l);
					model.getGame().getPlayer().switchOrientation();
					gridColoring(l);
				}
				
			}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
		if(model.isActive()==true)
			if(!model.getGame().getPlayer().getShipHouse().isEmpty()) {
				int l = model.getGame().getPlayer().getShipHouse().peek().getLength();
				gridColoring(l);
				}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if(model.isActive()==true)
			if(!model.getGame().getPlayer().getShipHouse().isEmpty()) {
				int l = model.getGame().getPlayer().getShipHouse().peek().getLength();
				gridReverting(l);
			}
		
	}

	

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private void shipColoring(int l) {
		
		ShipOrientation so = model.getGame().getPlayer().getChoiceOrientation();
		Point p = cellView.getPoint();
		
		
		
		if(so.equals(ShipOrientation.ORIZZONTALE))
			for(int i=0;i<l;i++) {
				
				view.getPanel().getOwnGrid()[p.x][p.y+i].shipLocation();
			}
		else if(so.equals(ShipOrientation.VERTICALE))
			for(int i=0;i<l;i++)
				view.getPanel().getOwnGrid()[p.x+i][p.y].shipLocation();
	}

	private void gridColoring(int l) {
		
		ShipOrientation so = model.getGame().getPlayer().getChoiceOrientation();
		Point p = cellView.getPoint();
		
			
		if(model.getGame().getPlayer().lecitPosition(l, so, p.x, p.y)) {
			
			
			
			if(so.equals(ShipOrientation.ORIZZONTALE))
				for(int i=0;i<l;i++)
					view.getPanel().getOwnGrid()[p.x][p.y+i].setColorGreen();
			else if(so.equals(ShipOrientation.VERTICALE))
				for(int i=0;i<l;i++)
					view.getPanel().getOwnGrid()[p.x+i][p.y].setColorGreen();
							
		}
		
		else  {
			
			if(so.equals(ShipOrientation.ORIZZONTALE)) {
				if(p.y+l>=Grid.DIM)
					for(int i=0;i<Grid.DIM-p.y;i++)
						view.getPanel().getOwnGrid()[p.x][p.y+i].setColorRed();
				else 
					for(int i=0;i<l;i++)
						view.getPanel().getOwnGrid()[p.x][p.y+i].setColorRed();
				
			}
			
			else if(so.equals(ShipOrientation.VERTICALE)) {
				
				if(p.x+l>=Grid.DIM)
					for(int i=0;i<Grid.DIM-p.x;i++)
						view.getPanel().getOwnGrid()[p.x+i][p.y].setColorRed();
				else 
					for(int i=0;i<l;i++)
						view.getPanel().getOwnGrid()[p.x+i][p.y].setColorRed();
				
			}
		}			
	}
	
	private void gridReverting(int l) {
		
		ShipOrientation so = model.getGame().getPlayer().getChoiceOrientation();
		Point p = cellView.getPoint();
		
			
		if(model.getGame().getPlayer().lecitPosition(l, so, p.x, p.y)) {
			
			if(so.equals(ShipOrientation.ORIZZONTALE))
				for(int i=0;i<l;i++)
					view.getPanel().getOwnGrid()[p.x][p.y+i].resetColor();
			else if(so.equals(ShipOrientation.VERTICALE))
				for(int i=0;i<l;i++)
					view.getPanel().getOwnGrid()[p.x+i][p.y].resetColor();
							
		}
		
		else  {
			
			if(so.equals(ShipOrientation.ORIZZONTALE)) {
				if(p.y+l>=Grid.DIM)
					for(int i=0;i<Grid.DIM-p.y;i++)
						view.getPanel().getOwnGrid()[p.x][p.y+i].resetColor();
				else 
					for(int i=0;i<l;i++)
						view.getPanel().getOwnGrid()[p.x][p.y+i].resetColor();
				
			}
			
			else if(so.equals(ShipOrientation.VERTICALE)) {
				
				if(p.x+l>=Grid.DIM)
					for(int i=0;i<Grid.DIM-p.x;i++)
						view.getPanel().getOwnGrid()[p.x+i][p.y].resetColor();
				else 
					for(int i=0;i<l;i++)
						view.getPanel().getOwnGrid()[p.x+i][p.y].resetColor();
				
			}
		}			
	}
		
	
	
}
