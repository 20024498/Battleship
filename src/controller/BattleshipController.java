package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.BattleshipModel;
import view.BattleshipView;

public class BattleshipController {

	private BattleshipModel model;
	private BattleshipView view;
	private OwnGridController ownGridController;
	private OppGridController oppGridController;
	private MenuGameController menuGameController;
	
	public BattleshipController() {
		
		this.model=new BattleshipModel();
		this.view=new BattleshipView();
		this.ownGridController = new OwnGridController();
		this.oppGridController = new OppGridController();
		this.menuGameController = new MenuGameController();
		
	}
	
	public void InitListeners() {
		
		ActionListener menuGameListener;
		
		
		//ActionListener NewGamePanelListener
		
		menuGameListener= new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JMenuItem source = (JMenuItem)e.getSource();
				
				if(source.getText().equals("NUOVA PARTITA"))
				
				JOptionPane JOPNewGame = new JOptionPane
				
			}
		
		
		
		};
		
		
		view.getNewGame().addActionListener(newGameListener); 
		view.getSaveGame().addActionListener(saveGameListener);
		view.getLoadGame().addActionListener(loadGameListener);
		view.getHelpGame().addActionListener(helpListener);
		
	}
	
}
