package model;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public interface Hittable {

	/**
	 * Questa funzione deve essere implementata in ogni classe 
	 * che implementa Hittable e consente di colpire un punto
	 * della mappa che ha coordinate x ed y
	 * 
	 * @param x
	 * @param y
	 * @return ritorna un tipo booleano che identifica se la mossa colpisce
	 * una nave
	 */
	public boolean hit(int x, int y);
	
	/**
	 * Questa funzione deve essere implementata in ogni classe 
	 * che implementa Hittable e consente verificare se una cella
	 * sia stato colpito
	 * 
	 * @param x
	 * @param y
	 * @return ritorna un tipo booleano che identifica se la nave è stata colpita
	 */
	public boolean isHit(int x, int y);	
}
