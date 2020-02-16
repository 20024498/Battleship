package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class MoveResult implements Serializable{

	private static final long serialVersionUID = 1L;
	private MoveResultType moveRes;
	private ShipType shipType;
	private Point point;
	private Turn turn;
	private LinkedHashMap<Integer,String> charMap;
	
	/**
	 * Il costruttore inizializza alcuni campi della classe tramite dei 
	 * parametri passati in input
	 * 
	 * @param moveRes
	 * @param Coord
	 */
	public MoveResult(MoveResultType moveRes,Point point,Turn turn) {
		charMapInit();
		this.turn= turn;
		this.moveRes = moveRes;
		this.point = point;
	}
	
	/**
	 * Il costruttore inizializza i campi della classe tramite dei 
	 * parametri passati in input
	 * 
	 * @param moveRes
	 * @param Coord
	 * @param shipType
	 */
	public MoveResult(MoveResultType moveRes,Point point,ShipType shipType,Turn turn) {
		charMapInit();
		this.turn= turn;
		this.moveRes = moveRes;
		this.shipType=shipType;
		this.point = point;
	}

	/**
	 * Questa funzione consente di ottenere il campo moveRes
	 * 
	 * @return moveRes
	 */
	public MoveResultType getMoveResultType() {
		return moveRes;
	}

	/**
	 * Questa funzione consente di ottenere il campo shipType
	 * 
	 * @return shipType
	 */
	public ShipType getShipType() {
		return shipType;
	}
	
	

	public Point getCoord() {
		return point;
	}

	public Turn getTurn() {
		return turn;
	}

	@Override
	public String toString() {

		String str = turn.toString()+ ":" +"["+charMap.get(point.y)  +"," + pointCorrector(point.x)+"]" +" "+moveRes.toString();
		return str;
	}
	
	private void charMapInit() {
		charMap= new LinkedHashMap<Integer,String>();
		charMap.put(0,"A");
		charMap.put(1,"B");
		charMap.put(2,"C");
		charMap.put(3,"D");
		charMap.put(4,"E");
		charMap.put(5,"F");
		charMap.put(6,"G");
		charMap.put(7,"H");
		charMap.put(8,"I");
		charMap.put(9,"J");
		
	} 
	
	private int pointCorrector(int coord) {
		return coord+1;
	}
}
