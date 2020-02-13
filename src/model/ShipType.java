package model;

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
	
	public String shipName() {
		return shipName;
	}
	
	public int length() {
		return length;
	}
	
	public int id() {
		return id;
	}
}
