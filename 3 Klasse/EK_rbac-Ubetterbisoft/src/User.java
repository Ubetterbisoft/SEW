import java.util.HashSet;
import java.util.Set;

/**
 * Ein User, dem Rollen zugewiesen werden können
 * @author Dejan Rajic
 * @version 2023-03-11
 */
public class User {
    private Set<Role> roles = new HashSet<>();

    /**
     * Gibt dem User eine zusätzliche Rolle
     * @param role Rolle, die dem User gegeben wird
     */
    public void addRole(Role role) {
        roles.add(role);
    }

    /**
     * Entnimmt dem User die übergebene Rolle, falls vorhanden
     * @param role Rolle, die dem User entnommen wird
     */
    public void deleteRole(Role role) {
        roles.remove(role);
    }

    /**
     * Liefert alle Rollen, die der User hat, als Text aufgelistet zurück
     * @return Rollen, die der User hat, als Text aufgelistet
     */
    public String listRoles() {
        StringBuilder output = new StringBuilder();
        for(Role role: roles) {
            output.append(role.getName() + ", ");
        }
        return output.toString();
    }

    /**
     * Prüft, ob die übergebene Rolle Zugriff auf diese Ressource hat
     * @param role Rolle, die überprüft wird
     * @return true wenn die Rolle Zugriff hat, ansonsten false
     */
    public boolean hasRoles(Set<Role> roles) {
        return this.roles.containsAll(roles);
    }
}
