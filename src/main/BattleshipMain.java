package main;



import javax.swing.SwingUtilities;

import controller.BattleshipController;
import model.BattleshipModel;
import view.BattleshipView;



public class BattleshipMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			
			@Override
			public void run() {
				BattleshipModel model = new BattleshipModel();
				BattleshipView view = new BattleshipView();
				BattleshipController controller = new BattleshipController(model, view);
			}

		});
	}

	

}
