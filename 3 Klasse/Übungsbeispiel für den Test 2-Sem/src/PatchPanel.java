import java.util.*;

/**
 * Ergänze diese Klasse PatchPanel, die "angesteckte" Geräte in einer 
 * selbstgewählten Collection typsicher verwaltet.
 * Jedes Gerät wird dabei mit einem Port verbunden, die Ports werden durch Nummern (1 bis numports)
 * unterschieden. Die Anzahl der möglichen Ports (numports) wird beim Erzeugen 
 * eines PatchPanel-Objektes festgelegt.
 * 
 * Achte dabei auf Folgendes:
 * - an einem Port darf nur ein Gerät gleichzeitig verbunden sein.
 * - es müssen sich verschiedene Gerätetypen verbinden lassen (Laptop, Switch, ...), solange diese
 *   "Connectable" sind.
 * 
 * @author // TODO Autor angeben
 */
public class PatchPanel {

	/* diese Attribute nicht ändern */
	private static final int DEFAULTNUMPORTS = 24;
	private int numports;
	
	// TODO Collection auswählen und Attribut deklarieren
	
	
	/**
	 * Konstruktor. Legt die Portanzahl des Patchfeldes fest und initialisiert
	 * die Collection, in der die Verbindungen gespeichert werden. Die Signatur darf sich
	 * nicht ändern! Weitere Konstruktoren dürfen (wenn benötigt) angelegt werden.
	 * 
	 * @param numports Anzahl der Ports. Wird hier ein ungültige Zahl angegeben (<= 0) so 
	 *                 wird DEFAULTNUMPORTS gesetzt.
	 */
	public PatchPanel(int numports) { 
		// TODO Konstrutor implementieren

	}
	
	/** 
	 * Verbindet ein Gerät mit dem Patchfeld. Ist der Port mit dieser Nummer schon besetzt, wird
	 * eine Exception geworfen. Wird eine ungültige Portnummer übergeben, wird die Methode einfach 
	 * beendet.
	 * 
	 * @param portnum Nummer des Ports, an dem das Gerät angeschlossen wird
	 * @param device Gerät, das verbunden werden soll
	 * @throws AlreadyConnectedException wird geworfen, wenn an diesem Port schon ein anderes
	 *   Gerät verbunden ist ODER das gleiche Gerät bereits mit dem Patchfeld verbunden ist.
	 */
	public void connect(int portnum, Connectable device) {
		// TODO connect implementieren
	}
	
	/**
	 * Trennt eine Verbindung eines bestimmten Ports.
	 * 
	 * @param portnum Nummer des Ports, der getrennt werden soll
	 * @return true, wenn dort wirklich ein Gerät hing, false, wenn an dem Port nichts
	 *   angesteckt war oder die Portnummer ungültig ist.
	 */
	public boolean disconnect(int portnum) {
		// TODO disconnect Variante 1 implementieren
		return false;
	}
	
	/**
	 * Trennt ein Gerät vom PatchPanel
	 * 
	 * @param device Gerät, das getrennt werden soll 
	 * @return Nummer des Ports, an dem das Gerät verbunden war, 0 falls das Gerät gar nicht
	 *   mit dem Patchfeld verbunden war.
	 */
	public int disconnect(Connectable device) {
		// TODO disconnect Variante 2 implementieren
		return 0;
	}
	
	/**
	 * Prüft, ob ein Gerät mit dem PatchPanel verbunden ist
	 * 
	 * @param device Gerät, das überprüft werden soll
	 * @return Nummer des Ports, wenn das Gerät verbunden ist, 0 wenn nicht.
	 */
	public int isConnected(Connectable device) {
		// TODO  isConnected implementieren
		return 0;
	}
	
	/**
	 * Gibt eine Liste aller verbundenen Ports mit den jeweiligen Geräten ZURÜCK (KEINE Ausgabe!)
	 * Die Liste ist nach den Ports aufsteigend sortiert, pro String im Array ein Gerät in folgender Form:
	 *   portnr: Typ (Seriennummer)
	 *   
	 * z.B.
	 *   {"1: Laptop (94857292)", "4: PC (90928922)", "23: Switch (1192939)", "24: Laptop (18274742)"} 
	 *   
	 * @return Liste der verbundenen Geräte als Array
	 */
	public String[] listConnections() {
		// TODO listConnections implementieren
		return null;
	}
	
	
}
