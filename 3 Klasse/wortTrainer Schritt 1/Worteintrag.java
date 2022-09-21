import java.net.URL;
public class Worteintrag {

	private String wort;

	private String url;

	public Worteintrag(String wort, String url) {
		if(wort.length() < 3) {
			throw new IllegalArgumentException("Class Worteintrag at Constructor; zu kurzes Wort");

		}
		this.wort = wort;
		this.url = url;
	}


	//checkt die Url mit dem begin (https:// / http://) und nach den domains und subdomains

	/**
	 * Mann kann mit der URL Methode abchecken ob http enthalten ist.
	 * Danach kann man in einer For-schleife zählen ob es noch einen punkt gibt
	 * wenn es einen gibt kann man mit if ein true returnen
	 * @param url
	 * @return
	 */
	public static boolean checkURL(String url) {
		try{
			new URL(url).toURI();

		}catch (Exception e){
			System.out.println(e);
			return false;
		}
		return true;
	}

	public void setWort(String wort) {
		if(wort == null || wort.length() < 2){
			throw new IllegalArgumentException("set Wort: wort passt nicht");
		}
		this.wort = wort;
	}

	public void setUrl(String url) {
		if(url == null || this.checkURL(url) == false){
			throw new IllegalArgumentException("Die Url entspricht nicht den Vorgaben");
		}
		this.url = url;
	}

	public String getWort() {
		return wort;
	}

	public String getUrl() {
		return url;
	}

	public String toString() {
		return this.wort +" ; "+ this.url;
	}

}
