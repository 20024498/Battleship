package Model;

import java.awt.Point;

public class MoveResult {

	MoveResultType moveRes;
	ShipType shipType;
	Point Coord;
	
	public MoveResult(MoveResultType moveRes,Point Coord) {
		this.moveRes = moveRes;
		this.Coord = Coord;
	}
	
	public MoveResult(MoveResultType moveRes,Point Coord,ShipType shipType) {
		this.moveRes = moveRes;
		this.shipType=shipType;
	}

	public MoveResultType getMoveResultType() {
		return moveRes;
	}

	public ShipType getShipType() {
		return shipType;
	}
	
	@Override
	public String toString() {
		//TODO
		return null;
	}
}
