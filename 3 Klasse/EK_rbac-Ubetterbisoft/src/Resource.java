import java.util.HashSet;
import java.util.Set;

/**
 * Eine Ressource, dessen Zugriff mit Rollen verwaltet wird
 * @author Dejan Rajic
 * @version 2023-06-15
 */
public class Resource {
    private Set<Set<Role>> accessRoles = new HashSet<>();

    /**
     * Fügt eine Rolle hinzu, die Zugriff auf diese Ressource haben soll
     * @param role Rolle, die Zugriff auf diese Ressource haben soll
     */
    public void addRole(Set<Role> role) {
        accessRoles.add(role);
    }

    /**
     * Entfernt eine Rolle, die aktuell Zugriff auf diese Ressource hat
     * @param role Rolle, die entfernt wird
     */
    public void deleteRole(Set<Role> role) {
        accessRoles.remove(role);
    }

    /**
     * Liefert alle Rollen, die Zugriff auf diese Ressource haben, als Text aufgelistet zurück
     * @return Rollen, die Zugriff auf diese Ressource haben, als Text aufgelistet
     */
    public String listRoles() {
        StringBuilder output = new StringBuilder();
        for(Set<Role> roles: accessRoles) {
            output.append("[");
            for(Role role : roles) {
                output.append(role.getName() + ", ");
            }
            output.append("], ");
        }
        return output.toString();
    }

    /**
     * Prüft, ob der übergebene User Zugriff auf diese Ressource hat
     * @param user User, der überprüft wird
     * @return true wenn der User Zugriff hat, ansonsten false
     */
    public boolean hasAccess(User user) {
        for(Set<Role> role: accessRoles) {
            if(user.hasRoles(role))
                return true;
        }
        return false;
    }
}
