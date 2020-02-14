package view; 
import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CellViewPlayer extends JLabel {

	private int x;
	private int y;
	private Color currentColor;
	
	public CellViewPlayer(int x, int y) {
		
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
		setBackground(Color.WHITE);
	}
	
	public void  shipLocatin() {
		
		setText("");
		currentColor = Color.GRAY;
		setBackground(Color.GRAY);
	}
	
	public void mapPlayerHit() {
		
		setText("X");
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
}
