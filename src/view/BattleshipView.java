package view;

import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BattleshipView extends JFrame{

	private static final int FRAME_WIDTH = 1075;
	private static final int FRAME_HEIGTH = 525;
	private JMenuBar menuBar;
	private JMenu menuGame;
	private JMenuItem loadGame;
	private JMenuItem saveGame;
	private JMenuItem newGame;
	private JMenuItem helpGame;
	private JPanel contentPane;
	private MainPanelBattleship panel;
	
	/*VISTA*/
	public BattleshipView() {
		
		init();
		setMyContentPane();
		setMenuBar();
	}
	
	private void setIconFrame() {
		// TODO Auto-generated method stub
		URL iconURL = getClass().getResource("/image/frameIcon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
	}
	
	public void setMyContentPane() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		
		
		setContentPane(contentPane);
		
		setLabel();
		setMainPanel();	
		
	}
	
	private void setMainPanel() {
		
		panel = new MainPanelBattleship();
		panel.setBounds(30, 30, 1000, 425);
		
		contentPane.add(panel);
	}

	public void init() {
		
		setTitle("BATTLESHIP");
		setFont(new Font("Arial", Font.PLAIN, 20));
		setSize(FRAME_WIDTH, FRAME_HEIGTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconFrame();
	}
	
	private void setMenuBar() {
		menuBar = new JMenuBar();
		
		menuGame = new JMenu("MENU GAME");
		menuGame.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(menuGame);
		
		loadGame = new JMenuItem("CARICA PARTITA");
		loadGame.setFont(new Font("Arial", Font.PLAIN, 10));
		menuGame.add(loadGame);
		
		saveGame = new JMenuItem("SALVA PARTITA");
		saveGame.setFont(new Font("Arial", Font.PLAIN, 10));
		menuGame.add(saveGame);
		
		newGame = new JMenuItem("NUOVA PARTITA");
		newGame.setFont(new Font("Arial", Font.PLAIN, 10));
		menuGame.add(newGame);
		
		
		helpGame = new JMenuItem("AIUTO");
		helpGame.setFont(new Font("Arial", Font.PLAIN, 10));
		menuGame.add(helpGame);
		
		setJMenuBar(menuBar);
	}
	
	public void setLabel() {
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(47, 11, 14, 14);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setBounds(90, 11, 14, 14);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setBounds(131, 11, 14, 14);
		contentPane.add(lblC);
		
		JLabel lblD = new JLabel("D");
		lblD.setBounds(172, 11, 14, 14);
		contentPane.add(lblD);
		
		JLabel lblE = new JLabel("E");
		lblE.setBounds(215, 11, 14, 14);
		contentPane.add(lblE);
		
		JLabel lblF = new JLabel("F");
		lblF.setBounds(256, 11, 14, 14);
		contentPane.add(lblF);
		
		JLabel lblG = new JLabel("G");
		lblG.setBounds(301, 11, 14, 14);
		contentPane.add(lblG);
		
		JLabel lblH = new JLabel("H");
		lblH.setBounds(341, 11, 14, 14);
		contentPane.add(lblH);
		
		JLabel lblI = new JLabel("I");
		lblI.setBounds(387, 11, 14, 14);
		contentPane.add(lblI);
		
		JLabel lblJ = new JLabel("J");
		lblJ.setBounds(426, 11, 14, 14);
		contentPane.add(lblJ);
		
		JLabel label = new JLabel("1");
		label.setBounds(8, 49, 14, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(8, 89, 14, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(8, 130, 14, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setBounds(8, 175, 14, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setBounds(8, 215, 14, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setBounds(8, 256, 14, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("7");
		label_6.setBounds(8, 298, 14, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("8");
		label_7.setBounds(8, 339, 14, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("9");
		label_8.setBounds(8, 380, 14, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("10");
		label_9.setBounds(8, 424, 19, 14);
		contentPane.add(label_9);
		
		JLabel lblA_1 = new JLabel("A");
		lblA_1.setBounds(624, 11, 14, 14);
		contentPane.add(lblA_1);
		
		JLabel lblB_1 = new JLabel("B");
		lblB_1.setBounds(668, 11, 14, 14);
		contentPane.add(lblB_1);
		
		JLabel lblC_1 = new JLabel("C");
		lblC_1.setBounds(708, 11, 14, 14);
		contentPane.add(lblC_1);
		
		JLabel lblD_1 = new JLabel("D");
		lblD_1.setBounds(749, 11, 14, 14);
		contentPane.add(lblD_1);
		
		JLabel lblE_1 = new JLabel("E");
		lblE_1.setBounds(791, 11, 14, 14);
		contentPane.add(lblE_1);
		
		JLabel lblF_1 = new JLabel("F");
		lblF_1.setBounds(832, 11, 14, 14);
		contentPane.add(lblF_1);
		
		JLabel lblG_1 = new JLabel("G");
		lblG_1.setBounds(875, 11, 14, 14);
		contentPane.add(lblG_1);
		
		JLabel lblH_1 = new JLabel("H");
		lblH_1.setBounds(920, 11, 14, 14);
		contentPane.add(lblH_1);
		
		JLabel lblI_1 = new JLabel("I");
		lblI_1.setBounds(961, 11, 14, 14);
		getContentPane().add(lblI_1);
		
		JLabel lblJ_1 = new JLabel("J");
		lblJ_1.setBounds(1003, 11, 14, 14);
		contentPane.add(lblJ_1);
		
		JLabel label_10 = new JLabel("1");
		label_10.setBounds(1035, 49, 14, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("2");
		label_11.setBounds(1035, 89, 14, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("3");
		label_12.setBounds(1035, 130, 14, 14);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("4");
		label_13.setBounds(1035, 175, 14, 14);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("5");
		label_14.setBounds(1035, 215, 14, 14);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("6");
		label_15.setBounds(1035, 256, 14, 14);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("7");
		label_16.setBounds(1035, 298, 14, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("8");
		label_17.setBounds(1035, 339, 14, 14);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("9");
		label_18.setBounds(1035, 380, 14, 14);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("10");
		label_19.setBounds(1035, 424, 20, 14);
		contentPane.add(label_19);
	}
	
	/*
	 * PER EVITARE PROBLEMI DI OVERRIDE ABBIAMO
	 * SCELTO DI CHIAMARE I DUE SEGUENTI METODI, SEPPUR 
	 * PER setMenuBar L'ERRORE NON FOSSE NOTIFICATO DA 
	 * JAVA, CON LA SEGUENTE MODALITA':  <nome_metodo>Variable
	 */
	public JMenuBar getMenuBarVariable() {
		return menuBar;
	}

	public void setMenuBarVariable(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMenuGame() {
		return menuGame;
	}

	public void setMenuGame(JMenu menuGame) {
		this.menuGame = menuGame;
	}
	
	public JMenuItem getLoadGame() {
		return loadGame;
	}

	public void setLoadGame(JMenuItem loadGame) {
		this.loadGame = loadGame;
	}

	public JMenuItem getSaveGame() {
		return saveGame;
	}

	public void setSaveGame(JMenuItem saveGame) {
		this.saveGame = saveGame;
	}

	public JMenuItem getNewGame() {
		return newGame;
	}

	public void setNewGame(JMenuItem newGame) {
		this.newGame = newGame;
	}

	public JMenuItem getHelpGame() {
		return helpGame;
	}

	public void setHelpGame(JMenuItem helpGame) {
		this.helpGame = helpGame;
	}

	public MainPanelBattleship getPanel() {
		return panel;
	}

	public void setPanel(MainPanelBattleship panel) {
		this.panel = panel;
	}

	public static int getFrameWidth() {
		return FRAME_WIDTH;
	}

	public static int getFrameHeigth() {
		return FRAME_HEIGTH;
	}
	
	public int showNewGameWindow(NewGamePanel newGamePanel) {
		return JOptionPane.showConfirmDialog(this, newGamePanel, "Nuova Partita", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
	}
	
	public int showLoadGameWindow(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(this);
	}
	
	public int showSaveGameWindow(JFileChooser fileChooser) {
		return fileChooser.showSaveDialog(this);
	}
	
	public int showHelpGameWindow() {
		HelpPanel helpPanel = new HelpPanel();
		return JOptionPane.showConfirmDialog(this, helpPanel, "Aiuto", JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE, null);
	}
	
	 public void setEnableAll(boolean b) {    	
	    /*	tabbedPane.setEnabled(b);
	    	searchPanel.setAllComponentEnable(b);
	    	
	    	if(!b) {
	    		searchPanel.getTableModelRisultatiRicerca().setRowCount(0);
	    		searchPanel.getTableModelTags().setRowCount(0);
	    		tabbedPane.setSelectedIndex(0);
	    	}
	    	*/
	 }
}
