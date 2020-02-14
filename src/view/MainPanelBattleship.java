package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MainPanelBattleship extends JPanel{

	private JPanel playerMapPanel;
	private Border border;
	private CellViewPlayer[][] gridPlayerMap;
	private JPanel centralPanel;
	private CellViewBattleCamp[][] gridBattle;
	private JPanel battleMapPanel;
	private JTable tableActions;
	private DefaultTableModel tableModel;
	
	public MainPanelBattleship() {
		
		setPanel();
	}
	
	public void setPlayerMap() {
		
		playerMapPanel = new JPanel();
		playerMapPanel.setLayout(new GridLayout(10, 10));
		
		gridPlayerMap = new CellViewPlayer[10][10];
		playerMapPanel = new JPanel();
		playerMapPanel.setLayout(new GridLayout(10, 10));
		
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				gridPlayerMap[i][j] = new CellViewPlayer(i, j);
				gridPlayerMap[i][j].setForeground(Color.orange);
				gridPlayerMap[i][j].setHorizontalAlignment(JLabel.CENTER);
				gridPlayerMap[i][j].setVerticalAlignment(JLabel.CENTER);
				gridPlayerMap[i][j].setOpaque(true);
				gridPlayerMap[i][j].setBackground(Color.WHITE);
				gridPlayerMap[i][j].setBorder(border);
				playerMapPanel.add(gridPlayerMap[i][j]);
			}
		}
		
		playerMapPanel.setPreferredSize(new Dimension(425, 425));
		add(playerMapPanel);
	}
	
	public void setCentralPanel() {
		
		centralPanel = new JPanel();
		centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
		centralPanel.setPreferredSize(new Dimension(150, 425));
		
		JLabel lblNewLabel = new JLabel("  00 : 00");
		lblNewLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 27));
		lblNewLabel.setPreferredSize(new Dimension(150, 60));
		centralPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(150, 400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		centralPanel.add(scrollPane);
		
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
		
		
		add(centralPanel);
	}
	
	public void setBattleMap() {
		
		gridBattle = new CellViewBattleCamp[10][10];
		battleMapPanel = new JPanel();
		battleMapPanel.setLayout(new GridLayout(10, 10));
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				gridBattle[i][j] = new CellViewBattleCamp(i, j);
				gridBattle[i][j].setHorizontalAlignment(JLabel.CENTER);
				gridBattle[i][j].setVerticalAlignment(JLabel.CENTER);
				gridBattle[i][j].setOpaque(true);
				gridBattle[i][j].setBackground(Color.WHITE);
				gridBattle[i][j].setBorder(border);
				battleMapPanel.add(gridBattle[i][j]);
			}
		}
		
		battleMapPanel.setPreferredSize(new Dimension(425, 425));
		add(battleMapPanel);
	}
	
	public void setPanel() {
		
		setBounds(30, 30, 1000, 425);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPanels();
	}
	
	public void setPanels() {
		
		setPlayerMap();
		setCentralPanel();
		setBattleMap();
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

	public void setGridPlayerMap(CellViewPlayer[][] gridPlayerMap) {
		this.gridPlayerMap = gridPlayerMap;
	}

	public void setGridBattle(CellViewBattleCamp[][] gridBattle) {
		this.gridBattle = gridBattle;
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

	public JLabel[][] getGridPlayerMap() {
		return gridPlayerMap;
	}

	public JPanel getCentralPanel() {
		return centralPanel;
	}

	public void setCentralPanel(JPanel centralPanel) {
		this.centralPanel = centralPanel;
	}

	public JLabel[][] getGridBattle() {
		return gridBattle;
	}

	public JPanel getBattleMapPanel() {
		return battleMapPanel;
	}

	public void setBattleMapPanel(JPanel battleMapPanel) {
		this.battleMapPanel = battleMapPanel;
	}
	
}
