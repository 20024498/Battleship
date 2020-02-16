package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

//import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.BattleshipModel;
import model.Difficulty;
import model.GameState;
import view.BattleshipView;
import view.NewGamePanel;

public class BattleshipController implements Observer{

	private BattleshipModel model;
	private BattleshipView view;
	private OwnGridController ownGridController;
	private OppGridController oppGridController;
	private Timer timer;
	
	
	
	public BattleshipController(BattleshipModel model,BattleshipView view) {
		
		this.model=model;
		this.view=view;
		this.ownGridController = new OwnGridController(view, model);
		this.oppGridController = new OppGridController(view, model);
		

		InitListeners();
			
	}
	
	public void InitListeners() {
		
		ActionListener menuGameListener;
		
		
		menuGameListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 	{
				
				JMenuItem source = (JMenuItem)e.getSource();
				NewGamePanel newGamePanel = new NewGamePanel();
					if(source.getText().equals("NUOVA PARTITA")) {	
						int opt = view.showNewGameWindow(newGamePanel);
						if(opt == JOptionPane.OK_OPTION) {
							view.getPanel().resetAll();
							model.newGame((Difficulty)newGamePanel.getDifficulties().getSelectedItem(), (int)newGamePanel.getTimes().getSelectedItem());
							model.getGame().addObserver(BattleshipController.this);
							
							
						
						timer = new Timer();
							timer.scheduleAtFixedRate(new TimerTask() {
		
								@Override
								public void run() {
							
									model.getGame().getCountdown().updateTime();
									view.getPanel().getLblNewLabel().setText(model.getGame().getCountdown().toString());
									if(model.getGame().getCountdown().getSec()==0) {
										model.getGame().setGameState(GameState.SCONFITTA);
										System.out.println("SCONFITTA");
										this.cancel();
										
									}
									
									
								}
								
							}, 0, 1000);
						}	
					}
					
					if(source.getText().equals("SALVA PARTITA")) {	
						/*JFileChooser fileChooser = new JFileChooser();
						int opt = view.showSaveGameWindow(fileChooser);
						if (opt == JFileChooser.APPROVE_OPTION) {
				            File file = fileChooser.getSelectedFile();
				            model.saveGame(file);
				            }*/
						System.out.println("SALVATO");
						model.saveGame();
						
					}
					
					if(source.getText().equals("CARICA PARTITA")) {	
						/*JFileChooser fileChooser = new JFileChooser();
						int opt = view.showLoadGameWindow(fileChooser);
						if (opt == JFileChooser.APPROVE_OPTION) {
				            File file = fileChooser.getSelectedFile();
				            model.loadGame(file);
				        }*/
						model.loadGame();
					}
					
					if(source.getText().equals("AIUTO")) {	
						view.showHelpGameWindow();
					}
			
				
			}
		};

		view.getNewGame().addActionListener(menuGameListener); 
		view.getSaveGame().addActionListener(menuGameListener);
		view.getLoadGame().addActionListener(menuGameListener);
		view.getHelpGame().addActionListener(menuGameListener);
	
	}

	public BattleshipModel getModel() {
		return model;
	}

	public BattleshipView getView() {
		return view;
	}

	public OwnGridController getOwnGridController() {
		return ownGridController;
	}

	public OppGridController getOppGridController() {
		return oppGridController;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(model.getGame().getGameState().equals(GameState.VITTORIA)) {
			timer.cancel();
			timer.purge();
			view.win();	
		}
			
		else if(model.getGame().getGameState().equals(GameState.SCONFITTA)) {
			timer.cancel();
			timer.purge();
			view.lose();
		}
		
	}	
}
