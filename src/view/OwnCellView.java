package view; 
import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class OwnCellView extends JLabel {

	private int x;
	private int y;
	
	public OwnCellView(int x, int y) {
		
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
	
	public void  shipLocation() {
		
		setText("");
		setBackground(Color.GRAY);
	}
	
	public void mapPlayerHit() {
		
		setText("X");
		setBackground(Color.GRAY);
	}
}
