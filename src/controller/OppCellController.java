package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.BattleshipModel;
import view.OppCellView;


public class OppCellController implements MouseListener{

	OppCellView cellView;
	BattleshipModel model;
	
	public OppCellController(OppCellView cellView,BattleshipModel model) {
		this.cellView= cellView;
		this.model=model;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
