package model;

/**
 * Questa classe Enum consente di associare ad una nave 
 * un tipo preciso di nave con un nome ed una dimensione
 * 
 * @author Gili_Patera
 *
 */
public enum ShipType {

	PORTAEREI("Portaerei",5),
	CORAZZATA("Corazzata",4),
	INCROCIATORE("Incrociatore",3),
	SOTTOMARINO("Sottomarino",3),
	CACCIATORPEDINIERE("Cacciatorpediniere",2);
	
	private final String shipName;
	private final int length;
	
	private ShipType (String shipName, int length) {
		this.shipName=shipName;
		this.length=length;
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
}
