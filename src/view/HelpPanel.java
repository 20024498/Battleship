package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints cs;
	private JLabel lblRuling;
	private TextArea textAreaRuling;
	
	public HelpPanel() {
		
		setLayout(new GridBagLayout());
		cs = new GridBagConstraints();
		
		setlblRuling();
		setTextArea();
	}
	
	private void setTextArea() {
		
		textAreaRuling = new TextArea();
		setRules();
		textAreaRuling.setEditable(false);
		cs.gridx = 0;
		cs.gridy = 1;
		cs.insets = new Insets(10, 0, 0, 0);
		add(textAreaRuling, cs);
	}

	private void setRules() {
		
		String s = null;
		
		s = "Battaglia Navale è un gioco di strategia, chi sceglie la migliore\n"
			+"vince. BATTLESHIP è un software Java, ispirato a battaglia navale,\n"
			+"programmato da Andrea Gili e Roberto Patera.\n"
			+"Speriamo che la seguente guida ti aiuti a divertirti con il nostro gioco!\n\n\n"
			+"AZIONI DEL MENU\n\n"
			+"Premendo MENU DEL GIOCO del gioco aprirai un menu' a tendina dove\n"
			+"troverai le seguenti opzioni:\n\n"
			+"1.NUOVA PARTITA : con questa opzione verrà spawnato un pannello\n"
			+"pop up per selezionare il tempo e la difficolta' della partita.\n\n"
			+"2.SALVA PARTITA : con questa opzione potrai salvare la partita che\n"
			+"stai giocando per proseguirla in seguito.\n\n"
			+"3.CARICA PARTITA : con questa opzione potrai caricare la tua vecchia\n"
			+"partita per riprenderla da dove l'avevi lasciata in sospeso.\n\n\n"
			+"AZIONI DELLA PARTITA\n\n\n"
			+"FASE INIZIALE\n\n"
			+"Dopo aver iniziato una nuova partita, tramite l'opzione NUOVA PARTITA,\n"
			+"dovrai posizionare le tue navi sulla mappa di sinistra. Le navi\n"
			+"che hai a disposizione sono 5, per posizionarle sulla mappa devi\n"
			+"muoverti con il cursore verso la cassella che preferisci, scegliere\n"
			+"con il TASTO DESTRO del mouce l'orientamento orizzontale o verticale,\n"
			+"e poi premere il TASTO SINISTRO del mouce per posizionarla.\n\n"
			+"FASE DELLA BATTAGLIA\n\n"
			+"Per attaccare dovrai muoverti con il mouce verso la mappa di destra e\n"
			+"premere il TASTO SINISTRO del mouce per colpire la cella che preferisci.\n\n\n"
			+"Che vinca il migliore!!\n";
		
		textAreaRuling.setText(s);
	}

	private void setlblRuling() {
		
		lblRuling = new JLabel("Regole del gioco : ");
		lblRuling.setFont(new Font("Arial", Font.PLAIN, 12));
		cs.gridx = 0;
		cs.gridy = 0;
		cs.weightx = 2;
		add(lblRuling, cs);
	}

	public GridBagConstraints getCs() {
		return cs;
	}

	public void setCs(GridBagConstraints cs) {
		this.cs = cs;
	}

	public JLabel getLblRuling() {
		return lblRuling;
	}

	public void setLblRuling(JLabel lblRuling) {
		this.lblRuling = lblRuling;
	}

	public TextArea getTextAreaRuling() {
		return textAreaRuling;
	}

	public void setTextAreaRuling(TextArea textAreaRuling) {
		this.textAreaRuling = textAreaRuling;
	}
}
