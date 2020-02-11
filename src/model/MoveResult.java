package Model;

import java.awt.Point;

public class MoveResult {

	MoveRes moveRes;
	ShipType shipType;
	Point Coord;
	
	public MoveResult(MoveRes moveRes,Point Coord) {
		this.moveRes = moveRes;
		this.Coord = Coord;
	}
	
	public MoveResult(MoveRes moveRes,ShipType shipType,Point Coord) {
		this.moveRes = moveRes;
		this.shipType=shipType;
	}

	public MoveRes getMoveRes() {
		return moveRes;
	}

	public ShipType getShipType() {
		return shipType;
	}
	
	
}
