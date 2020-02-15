package controller;

import model.BattleshipModel;
import model.Grid;
import view.BattleshipView;

public class OwnGridController  {

	private BattleshipView view;
	private BattleshipModel model;
	private OwnCellController[][] controllers;
	
	public OwnGridController(BattleshipView view,BattleshipModel model) {
		this.view = view;
		this.model = model;
		this.controllers = new OwnCellController[Grid.DIM][Grid.DIM];
		init();
	}

	private void init() {
		for(int i =0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++) {
				controllers[i][j] = new OwnCellController(view.getPanel().getOwnGrid()[i][j], model, view);
				view.getPanel().getOwnGrid()[i][j].addMouseListener(controllers[i][j]);
			}
		
		
	}

	public BattleshipView getView() {
		return view;
	}

	public BattleshipModel getModel() {
		return model;
	}

	public OwnCellController[][] getControllers() {
		return controllers;
	}

	
}
