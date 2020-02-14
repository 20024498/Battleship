package view; 
import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CellViewPlayer extends JLabel {

	private int x;
	private int y;
	
	public CellViewPlayer(int x, int y) {
		
		super();
		this.x = x;
		this.y = y;
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
		setBackground(Color.GRAY);
	}
	
	public void mapPlayerHit() {
		
		setText("X");
		setBackground(Color.GRAY);
	}
}
