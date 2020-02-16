package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.BattleshipModel;
import model.Countdown;
import model.Difficulty;
import model.GameState;
import view.BattleshipView;
import view.NewGamePanel;

public class BattleshipController implements Observer{

	private BattleshipModel model;
	private BattleshipView view;
	private OwnGridController ownGridController;
	private OppGridController oppGridController;
	private int x;
	private int min;
	private int sec = 0;
	private Countdown countDown;
	private Timer timer;
	
	
	public BattleshipController(BattleshipModel model,BattleshipView view) {
		
		this.model=model;
		this.view=view;
		this.ownGridController = new OwnGridController(view, model);
		this.oppGridController = new OppGridController(view, model);
		timer = new Timer();
		
//		view.getPanel().update(null, (int)model.getGame().getTimer().getTime());
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
						model.newGame((Difficulty)newGamePanel.getDifficulties().getSelectedItem(), (int)newGamePanel.getTimes().getSelectedItem());
			
					x = (int)newGamePanel.getTimes().getSelectedItem();
					min =  x;
					
					getTimer().scheduleAtFixedRate(new TimerTask() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							view.getPanel().update(null, setLabelCounter());
						}
						
					}, 0, 1000);

					view.getPanel().resetAll();
				}
				
				if(source.getText().equals("SALVA PARTITA")) {	
					/*JFileChooser fileChooser = new JFileChooser();
					int opt = view.showSaveGameWindow(fileChooser);
					if (opt == JFileChooser.APPROVE_OPTION) {
			            File file = fileChooser.getSelectedFile();
			            model.saveGame(file);
			            }*/
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
					//int opt = view.showHelpGameWindow();
					opt = view.showHelpGameWindow();
				}
		
			}
		
		};

		view.getNewGame().addActionListener(menuGameListener); 
		view.getSaveGame().addActionListener(menuGameListener);
		view.getLoadGame().addActionListener(menuGameListener);
		view.getHelpGame().addActionListener(menuGameListener);
	
	}

	private boolean setLabelCounter() {

		String s = null;
			
			if(min >= 0) {
				
				if(sec == 0) {
					sec= 59;
					min--;
				}
				else
					sec--;
				
				if(min == 0 && sec == 0)
					timer.cancel();
			}
			
			if(min < 10 && sec < 10) {
				s = String.format(" 0%d : 0%d", min, sec);
				view.getPanel().getLblNewLabel().setText(s);
			}	
			else if(min >= 10 && sec >= 10) {
				
				s = String.format(" %d : %d", min, sec);
				view.getPanel().getLblNewLabel().setText(s);
			}
			else if(min >= 10 && sec < 10) {
				
				s = String.format(" %d : 0%d", min, sec);
				view.getPanel().getLblNewLabel().setText(s);
			}
			else if(min < 10 && sec >= 10) {
				
				s = String.format(" 0%d : %d", min, sec);
				view.getPanel().getLblNewLabel().setText(s);
			}
			
		countDown = new Countdown(min);
//		return countDown.getTime();
		return true;
	}
	
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
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
		if(model.getGame().getGameState().equals(GameState.VITTORIA))
			view.win();
		else if(model.getGame().getGameState().equals(GameState.SCONFITTA))
			view.lose();
		
	}
	
	
}
