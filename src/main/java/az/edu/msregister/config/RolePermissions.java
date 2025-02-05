package az.edu.msregister.config;

import az.edu.msregister.enums.UserRole;
import lombok.Data;
import java.util.Set;

@Data
public class RolePermissions {
    private final Set<UserRole> canCreate;
    private final Set<UserRole> canDelete;

    public RolePermissions(Set<UserRole> canCreate, Set<UserRole> canDelete) {
        this.canCreate = canCreate;
        this.canDelete = canDelete;
    }
}
