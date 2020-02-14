package model;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class OppGrid extends Grid {

	private static final long serialVersionUID = 1L;


		/**
	 * Questo costruttore associa alla griglia, mappa, 
	 * dell'avversario le dimensioni. Inoltre, utilizza 
	 * la funzione gridInit() per creare le celle
	 * della mappa
	 * 
	 */
	public OppGrid() {
		this.cells = new OppGridCell[Grid.DIM][Grid.DIM];
		gridInit();
	}
	
	
	protected void gridInit() {
		
		for(int i=0;i<Grid.DIM;i++)
			for(int j=0;j<Grid.DIM;j++) 
				cells[i][j] = new OppGridCell(i,j);		
	}


	public OppGridCell[][] getCells() {
		return (OppGridCell[][]) cells;
	}	
}
