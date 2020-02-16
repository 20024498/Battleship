package view; 
import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

public class OwnCellView extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Color currentColor;
	
	public OwnCellView(int x, int y) {
		
		super();
		this.x = x;
		this.y = y;
		currentColor = Color.WHITE;
	}
	
	public Point getPoint() {
		
		return new Point(x, y);
	}
	
	public void missed() {
		
		setText("X");
		setForeground(Color.BLACK);
	}
	
	public void  shipLocation() {
		
		setText("");
		currentColor = Color.GRAY;
		setBackground(Color.GRAY);
	}
	
	public void hit() {
		
		setText("X");
		setForeground(Color.BLACK);
	}
	
	public void setColorGreen() {
		
		setBackground(Color.GREEN);
	}
	
	public void setColorRed() {
		
		setBackground(Color.RED);
	}
	
	public void resetColor() {
		
		setBackground(currentColor);
	}
	
	public void blank() {
		setText("");
		setBackground(Color.WHITE);
		this.currentColor = Color.WHITE;
	}

	
	
}
