package model;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class OwnGrid extends Grid{

	private static final long serialVersionUID = 1L;

	/**
	 * Questo costruttore consente di inizializzare la griglia, mappa,
	 * del giocatore dandole delle dimensioni. Inoltre, con la funzione
	 * gridInit(), viene creata una cella per ogni posizione della griglia
	 * 
	 */
	public OwnGrid() {
		this.cells = new OwnGridCell[Grid.DIM][Grid.DIM];
		gridInit();
	}
	
	/**
	 * Questo metodo crea una cella per ogni posizione dellla griglia
	 * 
	 */
	protected void gridInit() {
		
		for(int i=0;i<Grid.DIM;i++)
			for(int j=0;j<Grid.DIM;j++) 
				cells[i][j] = new OwnGridCell(i,j);		
	}


	/**
	 * Questo metodo ritorna il campo cells della superclasse
	 * 
	 * @return (OwnGridCell[][])cells
	 */
	public OwnGridCell[][] getCells() {
		return (OwnGridCell[][])cells;
	}
}
