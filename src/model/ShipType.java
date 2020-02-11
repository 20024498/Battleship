package Model;

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
	
	public String shipName() {
		return shipName;
	}
	
	public int length() {
		return length;
	}
}
