package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.BattleshipModel;
import model.Difficulty;
import model.GameState;
import model.Grid;
import model.MoveResult;
import model.OppGridCellState;
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
		timer= new Timer();

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
							view.getPanel().getLblNewLabel().setText(model.getGame().getCountdown().toString());
							
						
						
						}
						
					}
					
					if(source.getText().equals("SALVA PARTITA")) {	
						
						
						if(model.saveGame())
							view.correctSave();
						else
							view.failedSave();
						
						
					}
					
					if(source.getText().equals("CARICA PARTITA")) {	
						
						if(model.loadGame()) 
						{
							loadView();
						}
						else 
							view.failedLoad();
						
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
		
		else if(model.getGame().getPlayer().getShipHouse().isEmpty() && model.getGame().getGameState().equals(GameState.DEFAULT)) {
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
	
	private void loadView() {
		for(int i=0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++) {
					view.getPanel().getOwnGrid()[i][j].blank();
				if(model.getGame().getPlayer().getOwnGrid().getCells()[i][j].isOccupied())
					view.getPanel().getOwnGrid()[i][j].shipLocation();
				if(model.getGame().getPlayer().getOwnGrid().getCells()[i][j].isHit())
					view.getPanel().getOwnGrid()[i][j].hit();
				if(model.getGame().getPlayer().getOppGrid().getCells()[i][j].getState().equals(OppGridCellState.DEFAULT))
					view.getPanel().getOppGrid()[i][j].blank();
				if(model.getGame().getPlayer().getOppGrid().getCells()[i][j].getState().equals(OppGridCellState.MANCATO))
					view.getPanel().getOppGrid()[i][j].missed();
				if(model.getGame().getPlayer().getOppGrid().getCells()[i][j].getState().equals(OppGridCellState.COLPITO))
					view.getPanel().getOppGrid()[i][j].hit();
				if(model.getGame().getPlayer().getOppGrid().getCells()[i][j].getState().equals(OppGridCellState.AFFONDATO))
					view.getPanel().getOppGrid()[i][j].sinked();	
			}
				
		
		view.getPanel().getTableModel().setRowCount(0);
		Vector<MoveResult> moves =model.getGame().getMoves();
		Object[] moves3 =  moves.toArray();
		Object[] temp = new Object[1];
		for(int i=0;i<moves3.length;i++) {
			temp[0]=moves3[i];
			view.getPanel().getTableModel().addRow(temp);
		}
			
			
			
		 
		 
		 
		 
		 view.getPanel().getLblNewLabel().setText(model.getGame().getCountdown().toString());
		 
		 	timer.cancel();
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
