import java.util.HashSet;

/**
 * Test des RBAC
 */
public class Test {
    public static void main(String[] args) {
        Resource file = new Resource();
        Resource secretFile = new Resource();

        // User definieren
        User employee = new User();
        User itManager = new User();
        User adminIT = new User();
        User adminAll = new User();
        employee.addRole(new Employee());
        itManager.addRole(new ITManager());
        itManager.addRole(new Employee());
        adminIT.addRole(new Admin());
        adminIT.addRole(new ITManager());
        adminAll.addRole(new Employee());
        adminAll.addRole(new Admin());
        adminAll.addRole(new ITManager());

        // Zugriffsrollen-Sets für die Resources definieren
        HashSet<Role> roleE = new HashSet<>();
        roleE.add(new Employee());
        HashSet<Role> roleI = new HashSet<>();
        roleI.add(new ITManager());
        HashSet<Role> roleA = new HashSet<>();
        roleA.add(new Admin());
        HashSet<Role> roleIA = new HashSet<>();
        roleIA.add(new ITManager());
        roleIA.add(new Admin());
        HashSet<Role> roleIAE = new HashSet<>();
        roleIAE.add(new ITManager());
        roleIAE.add(new Admin());
        roleIAE.add(new Employee());

        // Auf file haben alle Zugriff
        file.addRole(roleE);
        file.addRole(roleI);
        file.addRole(roleA);

        // Auf secretFile haben nur ITManager Zugriff, die auch Admins sind
        secretFile.addRole(roleIA);

        System.out.println("Auf file sollten alle Zugriff haben, auf secretFile nur ITManager, die auch Admins sind:");
        System.out.println(file.listRoles());
        System.out.println("employee hat Zugriff auf file:" + file.hasAccess(employee));
        System.out.println("itManager hat Zugriff auf file:" + file.hasAccess(itManager));
        System.out.println("adminIT hat Zugriff auf file:" + file.hasAccess(adminIT));
        System.out.println("adminAll hat Zugriff auf file:" + file.hasAccess(adminAll));
        System.out.println(secretFile.listRoles());
        System.out.println("employee hat Zugriff auf secretFile:" + secretFile.hasAccess(employee));
        System.out.println("itManager hat Zugriff auf secretFile:" + secretFile.hasAccess(itManager));
        System.out.println("adminIT hat Zugriff auf secretFile:" + secretFile.hasAccess(adminIT));
        System.out.println("adminAll hat Zugriff auf secretFile:" + secretFile.hasAccess(adminAll));

        secretFile.deleteRole(roleIA);
        secretFile.addRole(roleIAE);

        System.out.println();
        System.out.println("Jetzt sollte nur noch adminAll Zugriff auf secretFile haben:");
        System.out.println(secretFile.listRoles());
        System.out.println("employee hat Zugriff auf secretFile:" + secretFile.hasAccess(employee));
        System.out.println("itManager hat Zugriff auf secretFile:" + secretFile.hasAccess(itManager));
        System.out.println("adminIT hat Zugriff auf secretFile:" + secretFile.hasAccess(adminIT));
        System.out.println("adminAll hat Zugriff auf secretFile:" + secretFile.hasAccess(adminAll));
    }
}
