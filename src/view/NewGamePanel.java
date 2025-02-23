package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Difficulty;

public class NewGamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTime;
	private GridBagConstraints cs;
	private JLabel lblDifficulties;
	private JComboBox<Difficulty> diffiulties;
	private JComboBox<Integer> times;
	private Difficulty[] s = {};
	private Integer[] s1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	private JLabel hint;
	
	public NewGamePanel() {
		
		setLayout(new GridBagLayout());
		cs = new GridBagConstraints();
		
		setLabelTempoConstraint();
		setComboBoxTempoConstraint();
		setLabelDifficoltaConstraint();
		setComboBoxDifficoltaConstraint();
	}

	private void setComboBoxDifficoltaConstraint() {
	
		setDifficultiesBox();
		diffiulties = new JComboBox<Difficulty>(s);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.fill = GridBagConstraints.HORIZONTAL;
		cs.insets = new Insets(10, 0, 10, 10);
		add(diffiulties, cs);
	}

	public Difficulty[] getS() {
		return s;
	}

	public void setS(Difficulty[] s) {
		this.s = s;
	}

	public void setDiffiulties(JComboBox<Difficulty> diffiulties) {
		this.diffiulties = diffiulties;
	}

	private void setDifficultiesBox() {
		Difficulty[] s = Difficulty.values();
		Difficulty[] str = new Difficulty[s.length];
		
		str[0] = Difficulty.FACILE;
		str[1] = Difficulty.MEDIA;
		
		setS(str);
	}

	private void setComboBoxTempoConstraint() {
		
		times = new JComboBox<Integer>(s1);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.weightx = 1;
		cs.weighty = 1;
		cs.insets = new Insets(10, 0, 10, 10);
		cs.fill = GridBagConstraints.HORIZONTAL;
		add(times, cs);
	}
	
	private void setLabelDifficoltaConstraint() {
		
		lblDifficulties = new JLabel("Scegliere difficolta' : ");
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

	public void setDifficulties(JComboBox<Difficulty> diffiulties) {
		this.diffiulties = diffiulties;
	}

	public JComboBox<Difficulty> getDifficulties() {
		return diffiulties;
	}
}
