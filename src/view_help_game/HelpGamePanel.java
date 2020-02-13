package view_help_game;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HelpGamePanel extends JPanel{

	private GridBagConstraints cs;
	private JLabel lblRuling;
	private TextArea textAreaRuling;
	
	public HelpGamePanel() {
		
		setLayout(new GridBagLayout());
		cs = new GridBagConstraints();
		
		setlblRuling();
		setTextArea();
	}
	
	private void setTextArea() {
		
		textAreaRuling = new TextArea();
		cs.gridx = 0;
		cs.gridy = 1;
		cs.insets = new Insets(10, 0, 0, 0);
		add(textAreaRuling, cs);
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
