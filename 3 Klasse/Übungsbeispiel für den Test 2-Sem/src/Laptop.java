/**
 * Diese Klasse bildet ein beispielhaftes Gerät ab, dass sich verbinden lässt.
 * 
 * Die Klasse soll so gestaltet werden, dass sie sinnvoll für das gesamte 
 * Collection Framework als Element eingesetzt werden kann. 
 * 
 * Zwei Geräte gelten als gleich, wenn ihr Typ und ihre Seriennummern gleich sind. 
 * Die Werte etwaiger anderer Attribute sind dafür nicht relevant.
 * 
 * Überschreibe alle relevanten Methoden und implementiere alle relevanten 
 * Interfaces!  
 * 
 * In sortierten Collections soll die natürliche Ordnung nach dem Typ der Seriennummer 
 * erfolgen. Achte auf eine konsistente Implementierung.
 * Achtung: Objekte von verschiedenen Connectable-Klassen müssen sich vergleichen lassen!
 * 
 * @author // TODO Autor angeben
 */
// TODO relevante Interfaces angeben
public class Laptop implements Connectable {
	
	/* BEGINN nicht zu ändernder Code */
	private final String type = "Laptop";
	private long serialNumber;
	private String manufacturer;
	
	public Laptop(long serialNumber, String manufacturer) {
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
	}
	
	public String getType() {
		return this.type;
	}
	
	public long getSerialNumber() {
		return this.serialNumber;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	/* ENDE nicht zu ändernder Code */
	
	// TODO relevante Methoden überschreiben
	// TODO relevante Interfaces implementieren
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;

		result = result * prime + (this.type == null ? 0: this.type.hashCode());
		result = result * prime + (int)( this.serialNumber ^ (this.getSerialNumber() >>> 32));
		return result;

	}

	@Override
	public boolean equals(Object o){

		if(o == this)
			return true;
		if(o == null || o.getClass() != this.getClass())
			return false;

		Connectable other = (Connectable) o;
	}
}
