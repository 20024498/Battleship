package model;

/**
 * Questa classe Enum consente di associare ad una nave 
 * un tipo preciso di nave con un nome ed una dimensione
 * 
 * @author Gili_Patera
 *
 */
public enum ShipType {

	PORTAEREI("Portaerei",5,1),
	CORAZZATA("Corazzata",4,2),
	INCROCIATORE("Incrociatore",3,3),
	SOTTOMARINO("Sottomarino",3,4),
	CACCIATORPEDINIERE("Cacciatorpediniere",2,5);
	
	private final String shipName;
	private final int length;
	private final int id;
	
	private ShipType (String shipName, int length,int id) {
		this.shipName=shipName;
		this.length=length;
		this.id=id;
	}
	
	/**
	 * Questo metodo restituisce il nome della nave
	 * 
	 * @return shipName
	 */
	public String shipName() {
		return shipName;
	}
	
	/**
	 * Questo metodo restituisce la lunghezza della nave
	 * 
	 * @return length
	 */
	public int length() {
		return length;
	}
	
	/**
	 * Questa funzione restituisce il campo id
	 * 
	 * @return id
	 */
	public int id() {
		return id;
	}
}
