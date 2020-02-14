package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BattleshipModel;
import view.BattleshipView;

public class OwnGridController implements ActionListener {

	private BattleshipView view;
	private BattleshipModel model;
	
	public OwnGridController(BattleshipView view,BattleshipModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
