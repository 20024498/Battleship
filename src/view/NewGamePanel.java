package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Difficulty;

@SuppressWarnings("serial")
public class NewGamePanel extends JPanel{

	private JLabel lblTime;
	private GridBagConstraints cs;
	private JLabel lblDifficulties;
	private JComboBox<String> diffiulties;
	private JComboBox<String> times;
	private String[] s = {};
	private String[] s1 = {"5", "7", "10"};
	private JButton btnOK;
	private JLabel hint;
	
	public NewGamePanel() {
		
		setLayout(new GridBagLayout());
		cs = new GridBagConstraints();
		
		setLabelTempoConstraint();
		setComboBoxTempoConstraint();
		setLabelDifficoltaConstraint();
		setComboBoxDifficoltaConstraint();
		setBtnOkConstraint();
	}

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
	
		setDifficultiesBox();
		diffiulties = new JComboBox<String>(s);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.insets = new Insets(10, 0, 10, 10);
		add(diffiulties, cs);
	}

	public String[] getS() {
		return s;
	}

	public void setS(String[] s) {
		this.s = s;
	}

	public void setDiffiulties(JComboBox<String> diffiulties) {
		this.diffiulties = diffiulties;
	}

	private void setDifficultiesBox() {
		// TODO Auto-generated method stub
		Difficulty[] s = Difficulty.values();
		String[] str = new String[s.length];
		
		str[0] = Difficulty.FACILE.toString();
		str[1] = Difficulty.MEDIA.toString();
		
		setS(str);
	}

	private void setComboBoxTempoConstraint() {
		
		times = new JComboBox<String>(s1);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.insets = new Insets(10, 0, 10, 10);
		cs.fill = GridBagConstraints.HORIZONTAL;
		add(times, cs);
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

	public JComboBox<String> getTimes() {
		return times;
	}

	public void setTimes(JComboBox<String> times) {
		this.times = times;
	}

	public void setDifficulties(JComboBox<String> diffiulties) {
		this.diffiulties = diffiulties;
	}

	public JComboBox<String> getDifficulties() {
		return diffiulties;
	}
}
