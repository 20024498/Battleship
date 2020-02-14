package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Difficulty;

@SuppressWarnings("serial")
public class NewGamePanel extends JPanel{

	private JLabel lblTime;
	private GridBagConstraints cs;
	private JTextField textFieldTime;
	private JLabel lblDifficulties;
	private JComboBox<Difficulty> diffiulties;
	private JComboBox<Integer> times;
	private JButton btnOK;
	private JLabel hint;
	
	public NewGamePanel() {
		
		setLayout(new GridBagLayout());
		cs = new GridBagConstraints();
		
		setLabelTempoConstraint();
		setTextFieldTempoConstraint();
		setLabelDifficoltaConstraint();
		setComboBoxDifficoltaConstraint();
		setBtnOkConstraint();
		//setAiutoTextArea();
	}
	
//	private void setAiutoTextArea() {
//		
//		hint = new JLabel("es. tempo: 15:05, 6:09, 1:33...");
//		cs.gridx = 0;
//		cs.gridy = 2;
//		cs.weightx = 1;
//		cs.weighty = 1;
//		cs.fill = GridBagConstraints.CENTER;
//		add(hint, cs);
//	}

	private void setBtnOkConstraint() {
		
		btnOK = new JButton("OK");
		cs.gridx = 1;
		cs.gridy = 2;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.insets = new Insets(10, 10, 10, 10);
		cs.fill = GridBagConstraints.HORIZONTAL;
		add(btnOK, cs);
	}

	private void setComboBoxDifficoltaConstraint() {
	
		diffiulties = new JComboBox<Difficulty>();
		cs.gridx = 1;
		cs.gridy = 1;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.insets = new Insets(10, 0, 10, 10);
		add(diffiulties, cs);
	}

	private void setTextFieldTempoConstraint() {
		
		/**/
		times = new JComboBox<Integer>();
		cs.gridx = 1;
		cs.gridy = 0;
		cs.weightx = 1;
		cs.weighty = 1;
		textFieldTime.setColumns(10);
		cs.insets = new Insets(10, 0, 10, 10);
		cs.fill = GridBagConstraints.HORIZONTAL;
		add(textFieldTime, cs);
	}
	
	private void setLabelDifficoltaConstraint() {
		
		lblDifficulties = new JLabel("Scegliere difficoltà : ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.fill = GridBagConstraints.CENTER;
		cs.insets = new Insets(10, 0, 10, 0);
		add(lblDifficulties, cs);
	}

	private void setLabelTempoConstraint() {
		
		lblTime = new JLabel("Inserire il tempo : ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.insets = new Insets(10, 0, 10, 0);
		add(lblTime, cs);
	}

	public JLabel getLblTime() {
		return lblTime;
	}

	public void setLblTime(JLabel lblTime) {
		this.lblTime = lblTime;
	}

	public GridBagConstraints getCs() {
		return cs;
	}

	public void setCs(GridBagConstraints cs) {
		this.cs = cs;
	}

	public JTextField getTextFieldTime() {
		return textFieldTime;
	}

	public void setTextFieldTime(JTextField textFieldTime) {
		this.textFieldTime = textFieldTime;
	}

	public JLabel getLblDifficulties() {
		return lblDifficulties;
	}

	public void setLblDifficulties(JLabel lblDifficulties) {
		this.lblDifficulties = lblDifficulties;
	}

//	public JComboBox getDiffiulties() {
//		return diffiulties;
//	}
//
//	public void setDiffiulties(JComboBox diffiulties) {
//		this.diffiulties = diffiulties;
//	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JLabel getHint() {
		return hint;
	}

	public void setHint(JLabel hint) {
		this.hint = hint;
	}

	public JComboBox<Integer> getTimes() {
		return times;
	}

	public void setTimes(JComboBox<Integer> times) {
		this.times = times;
	}

	public void setDiffiulties(JComboBox<Difficulty> diffiulties) {
		this.diffiulties = diffiulties;
	}
}
