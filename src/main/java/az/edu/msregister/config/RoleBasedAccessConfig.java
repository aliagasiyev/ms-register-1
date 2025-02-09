package az.edu.msregister.config;

import az.edu.msregister.enums.UserRole;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RoleBasedAccessConfig {

    private static final Map<UserRole, RolePermissions> rolePermissions = new HashMap<>();

    static {
        Set<UserRole> allRoles = new HashSet<>(Arrays.asList(UserRole.values()));
        rolePermissions.put(UserRole.SUPER_ADMIN, new RolePermissions(allRoles, allRoles));

        rolePermissions.put(UserRole.STAFF, new RolePermissions(
                Set.of(UserRole.STAFF, UserRole.STUDENT, UserRole.TEACHER),
                Set.of(UserRole.STAFF, UserRole.STUDENT, UserRole.TEACHER)
        ));

        rolePermissions.put(UserRole.TEACHER, new RolePermissions(
                Collections.emptySet(),
                Collections.emptySet()
        ));

        rolePermissions.put(UserRole.STUDENT, new RolePermissions(
                Collections.emptySet(),
                Collections.emptySet()
        ));
    }

    public static RolePermissions getPermissions(UserRole role) {
        return rolePermissions.getOrDefault(role, new RolePermissions(Collections.emptySet(), Collections.emptySet()));
    }
}
