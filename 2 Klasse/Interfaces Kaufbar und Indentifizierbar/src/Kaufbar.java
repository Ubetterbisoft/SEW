package drajic;
/**
 * Dieses Interface kann für alle Klassen verwendet werden, die Objekte darstellen, welche
 * gekauft werden können.
 *
 * @author Lisa Vittori
 * @version 20.03.2018
 */
public interface Kaufbar {
	/**
	 * Liefert den Preis des kaufbaren Objekts als Dezimalzahl (in Euro)
	 * @return den Preis des kaufbaren Objekts
	 */
	public double getPreis();
	
	/**
	 * Berechnet den Gesamtpreis des kaufbaren Objekts anhand der übergebenen Stück-Anzahl
	 * und gibt diesen als Dezimalzahl zurück.
	 * @param anzahl die Anzahl der gekauften Stücke
	 * @return den Gesamtpreis anhand der übergebenen Anzahl an Stücken
	 * @throws NumericRangeException falls die übergebene Anzahl 0 oder negativ ist
	 */
	public double gesamtPreis(int anzahl) throws NumericRangeException;
}
