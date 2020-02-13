package model;

import java.awt.Point;


/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public abstract class Cell extends Point {

	private static final long serialVersionUID = 1L;
	boolean hit;
	
	/**
	 * Il costruttore Cell(int x, int y) assume 
	 * i parametri x ed y in input per poterli utilizzare 
	 * nell'operatore super(), definendo così gli attributi
	 * della superclasse. Inoltre la variabile booleana
	 * hit viene impostata a false
	 * 
	 * @param x
	 * @param y
	 */
	public Cell(int x, int y) {
		super(x,y);
		hit=false;
	}
	
	/**
	 * Il costruttore Cell(Point c) sfrutta le proprietà
	 * della superclasse Point per impostare x ed y. Inoltre
	 * la variabile hit viene impostata a false
	 * 
	 * @param c
	 */
	public Cell(Point c) {
		super(c.x,c.y);
		hit=false;
	}

	/**
	 * Il metodo isHit(), facendo la return del campo hit,
	 * verifica che la cella sia colpita o meno
	 * 
	 * @return hit
	 */
	public boolean isHit() {
		return hit;
	}

	/**
	 * Il metodo hit serve ad impostare il flag hit
	 * al valore true
	 */
	public void hit() {
		this.hit = true;
	}
		
}
