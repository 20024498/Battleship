package view_main_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MainPanelBattleship extends JPanel{

	private JPanel panel;
	private JPanel playerMapPanel;
	private Border border;
	private JLabel[][] gridPlayerMap;
	private JPanel centralPanel;
	private JLabel[][] gridBattle;
	private JPanel battleMapPanel;
	
	public MainPanelBattleship() {
		
		setPanel();
	}
	
	public void setPlayerMap() {
		
		playerMapPanel = new JPanel();
		playerMapPanel.setLayout(new GridLayout(10, 10));
		
		gridPlayerMap = new JLabel[10][10];
		playerMapPanel = new JPanel();
		playerMapPanel.setLayout(new GridLayout(10, 10));
		
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				gridPlayerMap[i][j] = new JLabel("");
				gridPlayerMap[i][j].setHorizontalAlignment(JLabel.CENTER);
				gridPlayerMap[i][j].setVerticalAlignment(JLabel.CENTER);
				gridPlayerMap[i][j].setOpaque(true);
				gridPlayerMap[i][j].setBackground(Color.WHITE);
				gridPlayerMap[i][j].setBorder(border);
				playerMapPanel.add(gridPlayerMap[i][j]);
			}
		}
		
		playerMapPanel.setPreferredSize(new Dimension(425, 425));
		panel.add(playerMapPanel);
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
		centralPanel.add(scrollPane);
		
		panel.add(centralPanel);
	}
	
	public void setBattleMap() {
		
		gridBattle = new JLabel[10][10];
		battleMapPanel = new JPanel();
		battleMapPanel.setLayout(new GridLayout(10, 10));
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				gridBattle[i][j] = new JLabel("");
				gridBattle[i][j].setHorizontalAlignment(JLabel.CENTER);
				gridBattle[i][j].setVerticalAlignment(JLabel.CENTER);
				gridBattle[i][j].setOpaque(true);
				gridBattle[i][j].setBackground(Color.WHITE);
				gridBattle[i][j].setBorder(border);
				battleMapPanel.add(gridBattle[i][j]);
			}
		}
		
		battleMapPanel.setPreferredSize(new Dimension(425, 425));
		panel.add(battleMapPanel);
	}
	
	public void setPanel() {
		
		panel = new JPanel();
		panel.setBounds(30, 30, 1000, 425);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		setPanels();
	}
	
	public void setPanels() {
		
		setPlayerMap();
		setCentralPanel();
		setBattleMap();
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
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

	public void setGridPlayerMap(JLabel[][] gridPlayerMap) {
		this.gridPlayerMap = gridPlayerMap;
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

	public void setGridBattle(JLabel[][] gridBattle) {
		this.gridBattle = gridBattle;
	}

	public JPanel getBattleMapPanel() {
		return battleMapPanel;
	}

	public void setBattleMapPanel(JPanel battleMapPanel) {
		this.battleMapPanel = battleMapPanel;
	}
	
}
