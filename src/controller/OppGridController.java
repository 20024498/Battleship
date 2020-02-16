package controller;

import model.BattleshipModel;
import model.Grid;
import view.BattleshipView;

public class OppGridController {

	private BattleshipView view;
	private BattleshipModel model;
	private OppCellController[][] controllers;
	
	public OppGridController(BattleshipView view,BattleshipModel model) {
		this.view = view;
		this.model = model;
		controllers= new OppCellController[Grid.DIM][Grid.DIM];
		init();	
	}

	private void init() {
		for(int i =0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++) {
				controllers[i][j] = new OppCellController(view.getPanel().getOppGrid()[i][j], model, view);
				view.getPanel().getOppGrid()[i][j].addMouseListener(controllers[i][j]);
			}
	}

	public BattleshipView getView() {
		return view;
	}

	public BattleshipModel getModel() {
		return model;
	}

	public OppCellController[][] getControllers() {
		return controllers;
	}
}
