package view;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

public class OppCellView extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	public OppCellView(int x, int y) {
		
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point getPoint() {
		
		return new Point(x, y);
	}
	
	public void missed() {
		
		setText("X");
	}
	
	public void hit() {
		
		setText("X");
		setBackground(Color.RED);
	}
	
	public void sinked() {
		
		setText("X");
		setBackground(Color.BLACK);
	}
	
	public void blank() {
		setText("");
		setBackground(Color.WHITE);
	}
}
