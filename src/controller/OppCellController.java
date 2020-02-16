package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.BattleshipModel;
import model.GameState;
import model.MoveResult;
import model.MoveResultType;
import model.ShipCell;
import view.BattleshipView;
import view.OppCellView;


public class OppCellController implements MouseListener{

	OppCellView cellView;
	BattleshipModel model;
	BattleshipView view;
	
	public OppCellController(OppCellView cellView,BattleshipModel model,BattleshipView view) {
		this.cellView= cellView;
		this.model=model;
		this.view=view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(model.isActive()==true) 
			if(model.getGame().getGameState().equals(GameState.DEFAULT)) {
			
			MoveResult mr = null;
			int x =cellView.getPoint().x;
			int y = cellView.getPoint().y;
			
			if(model.getGame().getPlayer().getShipHouse().isEmpty()) {
				if(!model.getGame().getPlayer().getOppGrid().isHit(x, y)) {
					
					//player
					mr = model.getGame().playerMove(x, y);
					
					 if(mr.getMoveResultType().equals(MoveResultType.COLPITO))
						 view.getPanel().getOppGrid()[x][y].hit();
					 else if(mr.getMoveResultType().equals(MoveResultType.MANCATO))
						 view.getPanel().getOppGrid()[x][y].missed();
					 else {
						 for(ShipCell c : model.getGame().getCpu().getShips().get(new Point(x,y)).getCells().values())
							 view.getPanel().getOppGrid()[c.x][c.y].sinked();
					 }
					 String[] saPlayer = {mr.toString()};
					 view.getPanel().getTableModel().insertRow(view.getPanel().getTableModel().getRowCount(), saPlayer);
					 
					 
					 // pc
					 mr = model.getGame().cpuMove();
					 
					 if(mr.getMoveResultType().equals(MoveResultType.MANCATO))
						 view.getPanel().getOwnGrid()[mr.getCoord().x][mr.getCoord().y].missed();
					 else
						 view.getPanel().getOwnGrid()[mr.getCoord().x][mr.getCoord().y].hit();
					 String[] saCpu = {mr.toString()};
					 view.getPanel().getTableModel().insertRow(view.getPanel().getTableModel().getRowCount(), saCpu);
				}
					
				
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
