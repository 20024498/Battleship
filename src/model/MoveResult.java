package model;

import java.awt.Point;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class MoveResult {

	private MoveResultType moveRes;
	private ShipType shipType;
	private Point Coord;
	private Turn turn;
	
	/**
	 * Il costruttore inizializza alcuni campi della classe tramite dei 
	 * parametri passati in input
	 * 
	 * @param moveRes
	 * @param Coord
	 */
	public MoveResult(MoveResultType moveRes,Point Coord,Turn turn) {
		this.turn= turn;
		this.moveRes = moveRes;
		this.Coord = Coord;
	}
	
	/**
	 * Il costruttore inizializza i campi della classe tramite dei 
	 * parametri passati in input
	 * 
	 * @param moveRes
	 * @param Coord
	 * @param shipType
	 */
	public MoveResult(MoveResultType moveRes,Point Coord,ShipType shipType,Turn turn) {
		this.turn= turn;
		this.moveRes = moveRes;
		this.shipType=shipType;
		this.Coord = Coord;
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
		return Coord;
	}

	public Turn getTurn() {
		return turn;
	}

	@Override
	public String toString() {

		String str = turn.toString()+ ":" +" " +Coord.x+"," +Coord.y +moveRes.toString();
		return str;
	}
}
