package com.duclm.minitaxi.service;

import com.duclm.minitaxi.model.Permission;
import com.duclm.minitaxi.model.Role;
import java.util.List;

public interface RoleService {
    // Role CRUD
    List<Role> getAllRoles();
    Role createRole(String name);
    void deleteRole(Long id);

    // Permission CRUD
    List<Permission> getAllPermissions();
    Permission createPermission(String name);
    void deletePermission(Long id);

    // Assignments
    void assignPermissionToRole(Long roleId, Long permissionId);
    void assignRoleToUser(Long userId, Long roleId);
}