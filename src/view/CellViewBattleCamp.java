package view;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CellViewBattleCamp extends JLabel {

	private int x;
	private int y;
	
	public CellViewBattleCamp(int x, int y) {
		
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
	
	public void mapBattleHit() {
		
		setText("X");
		setBackground(Color.RED);
	}
	
	public void sinked() {
		
		setText("X");
		setBackground(Color.BLACK);
	}
}
