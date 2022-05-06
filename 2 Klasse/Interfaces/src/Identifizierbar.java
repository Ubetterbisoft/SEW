

/**
 * Hiermit werden alle Objekte gekennzeichnet, die eine Textuelle ID von mindestens 15
 * Stellen zurückgeben können.
 * @author Lisa Vittori
 * @version 20.03.2018
 */
public interface Identifizierbar {
	/**
	 * Diese Methode gibt einen ID-Bezeichnung mit mindestens 15 Stellen zurück
	 * @return eine ID als Text mit mindestens 15 Zeichen.
	 */
	public String identifier();
}
