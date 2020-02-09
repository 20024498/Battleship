package interfaccia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GamePanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int FRAME_WIDTH = 1050;
	private static final int FRAME_HEIGTH = 500;
	
	private JMenuItem loadGame;
	private JMenuItem saveGame;
	private JMenuItem newGame;
	private JMenuItem helpGame;
	
	private JPanel contentPane;
	
	private JPanel panelPlayerMap;
	private JLabel[][] gridBattle;
	private JLabel[][] gridMap;
	private Border border;
	private JPanel panelBattleCamp;
	private JPanel centralPanel;
	private JLabel lblTime;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu menuGame;
	
	public GamePanel() {
		
		init();
		
		setContentPane();
		setMenuBar();		
	}

	private void setMenuBar() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
	}



	private void setContentPane() {
		// TODO Auto-generated method stub
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setPanels();
	}



	private void setPanels() {
		// TODO Auto-generated method stub
		initPanelPlayer();
		initPanelBattleCamp();
		initCentralPanel();
	}



	private void initCentralPanel() {
		// TODO Auto-generated method stub
		centralPanel = new JPanel();
		centralPanel.setLayout(null);
		centralPanel.setBounds(450, 25, 145, 400);
		
		/*TIMER*/
		lblTime = new JLabel(" 00 : 00");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 27));
		lblTime.setBounds(25, 10, 95, 30);
		centralPanel.add(lblTime);
		
		/*SCROLL PANE*/
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 50, 145, 350);
		centralPanel.add(scrollPane);
		
		contentPane.add(centralPanel);
	}



	private void initPanelBattleCamp() {
		// TODO Auto-generated method stub
		gridBattle = new JLabel[10][10];
		panelBattleCamp = new JPanel();
		panelBattleCamp.setBounds(615, 25, 410, 400);
		panelBattleCamp.setLayout(new GridLayout(10, 10));
		
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				gridBattle[i][j] = new JLabel("");
				gridBattle[i][j].setHorizontalAlignment(JLabel.CENTER);
				gridBattle[i][j].setVerticalAlignment(JLabel.CENTER);
				gridBattle[i][j].setOpaque(true);
				gridBattle[i][j].setBackground(Color.WHITE);
				gridBattle[i][j].setBorder(border);
				panelBattleCamp.add(gridBattle[i][j]);
			}
		}
		
		panelBattleCamp.setBorder(border);
		contentPane.add(panelBattleCamp);
	}



	private void initPanelPlayer() {
		// TODO Auto-generated method stub
		gridMap = new JLabel[10][10];
		panelPlayerMap = new JPanel();
		panelPlayerMap.setBounds(20, 25, 410, 400);
		panelPlayerMap.setLayout(new GridLayout(10, 10));
		
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				gridMap[i][j] = new JLabel("");
				gridMap[i][j].setHorizontalAlignment(JLabel.CENTER);
				gridMap[i][j].setVerticalAlignment(JLabel.CENTER);
				gridMap[i][j].setOpaque(true);
				gridMap[i][j].setBackground(Color.WHITE);
				gridMap[i][j].setBorder(border);
				panelPlayerMap.add(gridMap[i][j]);
			}
		}
		
		panelPlayerMap.setBorder(border);
		contentPane.add(panelPlayerMap);
	}



	private void init() {
		// TODO Auto-generated method stub
		setTitle("BATTLE SHIP");
		setFont(new Font("Arial", Font.PLAIN, 20));
		setSize(FRAME_WIDTH, FRAME_HEIGTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconFrame();
	}

	private void setIconFrame() {
		// TODO Auto-generated method stub
		URL iconURL = getClass().getResource("/image/frameIcon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePanel frame = new GamePanel();
					frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
}
