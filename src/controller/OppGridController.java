package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BattleshipModel;
import view.BattleshipView;

public class OppGridController implements ActionListener{

	private BattleshipView view;
	private BattleshipModel model;
	
	public OppGridController(BattleshipView view,BattleshipModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
