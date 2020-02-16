package main;



import javax.swing.SwingUtilities;

import controller.BattleshipController;
import controller.CountdownController;
import model.BattleshipModel;
import view.BattleshipView;



public class BattleshipMain {

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			
			@Override
			public void run() {
				BattleshipModel model = new BattleshipModel();
				BattleshipView view = new BattleshipView();
				BattleshipController Bcontroller = new BattleshipController(model, view);
				//model.getGame().addObserver(Bcontroller);
				//CountdownController cController = new CountdownController(model, view);
				
			}

		});
	}

	

}
