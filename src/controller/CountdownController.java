package controller;

import java.util.Timer;
import java.util.TimerTask;

import model.BattleshipModel;
import model.GameState;
import view.BattleshipView;

public class CountdownController {

	BattleshipModel model;
	BattleshipView view;
	
	public CountdownController (BattleshipModel model,BattleshipView view) {
		this.model=model;
		this.view=view;
		init();
	}

	private void init() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
		
				model.getGame().getCountdown().updateTime();
				view.getPanel().getLblNewLabel().setText(model.getGame().getCountdown().toString());
				if(model.getGame().getCountdown().getSec()==0) {
					model.getGame().setGameState(GameState.SCONFITTA);
					System.out.println("SCONFITTA");}
				
			}
			
		}, 0, 1000);
		
	}
	
	
}
