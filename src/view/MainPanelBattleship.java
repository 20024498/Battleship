package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MainPanelBattleship extends JPanel  {

	private JPanel playerMapPanel;
	private Border border;
	private OwnCellView[][] ownGrid;
	private JPanel centralPanel;
	private OppCellView[][] oppGrid;
	private JPanel battleMapPanel;
	private JTable tableActions;
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel;
	
	public MainPanelBattleship() {
		
		setPanel();
	}
	
	public void setPlayerMap() {
		
		playerMapPanel = new JPanel();
		playerMapPanel.setLayout(new GridLayout(10, 10));
		ownGrid = new OwnCellView[10][10];
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				ownGrid[i][j] = new OwnCellView(i, j);
				ownGrid[i][j].setForeground(Color.orange);
				ownGrid[i][j].setHorizontalAlignment(JLabel.CENTER);
				ownGrid[i][j].setVerticalAlignment(JLabel.CENTER);
				ownGrid[i][j].setOpaque(true);
				ownGrid[i][j].setBackground(Color.WHITE);
				ownGrid[i][j].setBorder(border);
				playerMapPanel.add(ownGrid[i][j]);
			}
		}
		
		playerMapPanel.setPreferredSize(new Dimension(425, 425));
		add(playerMapPanel);
	}
	
	public void setCentralPanel() {
		
		centralPanel = new JPanel();
		centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
		centralPanel.setPreferredSize(new Dimension(150, 425));
		
		lblNewLabel = new JLabel("  00 : 00");
		lblNewLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 27));
		lblNewLabel.setPreferredSize(new Dimension(150, 60));
		centralPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(150, 400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		tableActions = new JTable(15, 1);
		String[] nameColumns = {"Actions"};
		
		setTableModel(new DefaultTableModel(nameColumns, 0) {
			
			boolean[] columnEditables = new boolean[] {
					false
			};
			
			public boolean isCellEditable(int row, int column) {
				
				return columnEditables[column];
			}
		});
		tableActions.setModel(getTableModel());
		scrollPane.setViewportView(tableActions);
		
		centralPanel.add(scrollPane);
		add(centralPanel);
	}
	
	public void setBattleMap() {
		
		oppGrid = new OppCellView[10][10];
		battleMapPanel = new JPanel();
		battleMapPanel.setLayout(new GridLayout(10, 10));
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				oppGrid[i][j] = new OppCellView(i, j);
				oppGrid[i][j].setHorizontalAlignment(JLabel.CENTER);
				oppGrid[i][j].setVerticalAlignment(JLabel.CENTER);
				oppGrid[i][j].setOpaque(true);
				oppGrid[i][j].setBackground(Color.WHITE);
				oppGrid[i][j].setBorder(border);
				battleMapPanel.add(oppGrid[i][j]);
			}
		}
		
		battleMapPanel.setPreferredSize(new Dimension(425, 425));
		add(battleMapPanel);
	}
	
	public void setPanel() {

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPanels();
	}
	
	public void setPanels() {
		
		setPlayerMap();
		setCentralPanel();
		setBattleMap();
	}
	
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public void setOwnGrid(OwnCellView[][] ownGrid) {
		this.ownGrid = ownGrid;
	}

	public void setOppGrid(OppCellView[][] oppGrid) {
		this.oppGrid = oppGrid;
	}

	public JTable getTableActions() {
		return tableActions;
	}

	public void setTableActions(JTable tableActions) {
		this.tableActions = tableActions;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public void setGridPlayerMap(OwnCellView[][] gridPlayerMap) {
		this.ownGrid = gridPlayerMap;
	}

	public void setGridBattle(OppCellView[][] gridBattle) {
		this.oppGrid = gridBattle;
	}

	public JPanel getPlayerMapPanel() {
		return playerMapPanel;
	}

	public void setPlayerMapPanel(JPanel playerMapPanel) {
		this.playerMapPanel = playerMapPanel;
	}

	public Border getBorder() {
		return border;
	}

	public void setBorder(Border border) {
		this.border = border;
	}

	public OwnCellView[][]getOwnGrid() {
		return ownGrid;
	}

	public JPanel getCentralPanel() {
		return centralPanel;
	}

	public void setCentralPanel(JPanel centralPanel) {
		this.centralPanel = centralPanel;
	}

	public OppCellView[][] getOppGrid() {
		return oppGrid;
	}

	public JPanel getBattleMapPanel() {
		return battleMapPanel;
	}

	public void setBattleMapPanel(JPanel battleMapPanel) {
		this.battleMapPanel = battleMapPanel;
	}

	
	
	public void resetAll() {
		for(int i = 0; i < 10; i++) 
			for(int j = 0; j < 10; j++) {
				oppGrid[i][j].blank();
				ownGrid[i][j].blank();
				}
		tableModel.setRowCount(0);
		//timer label default;
	}

	
		
	
}
