package com.duclm.minitaxi.controller;

import com.duclm.minitaxi.dto.AssignPermissionRequest;
import com.duclm.minitaxi.dto.AssignRoleRequest;
import com.duclm.minitaxi.dto.PermissionRequest;
import com.duclm.minitaxi.dto.RoleRequest;
import com.duclm.minitaxi.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')") // Chỉ ADMIN mới được truy cập Controller này
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // --- Role APIs ---
    @GetMapping("/roles")
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PostMapping("/roles")
    public ResponseEntity<?> createRole(@RequestBody RoleRequest request) {
        return ResponseEntity.ok(roleService.createRole(request.getName()));
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role deleted successfully");
    }
    
    // --- Permission APIs ---
    @GetMapping("/permissions")
    public ResponseEntity<?> getAllPermissions() {
        return ResponseEntity.ok(roleService.getAllPermissions());
    }

    @PostMapping("/permissions")
    public ResponseEntity<?> createPermission(@RequestBody PermissionRequest request) {
        return ResponseEntity.ok(roleService.createPermission(request.getName()));
    }

    @DeleteMapping("/permissions/{id}")
    public ResponseEntity<?> deletePermission(@PathVariable Long id) {
        roleService.deletePermission(id);
        return ResponseEntity.ok("Permission deleted successfully");
    }

    @PostMapping("/assign-permission")
    public ResponseEntity<?> assignPermissionToRole(@RequestBody AssignPermissionRequest request) {
        roleService.assignPermissionToRole(request.getRoleId(), request.getPermissionId());
        return ResponseEntity.ok("Permission assigned to role successfully");
    }

    @PostMapping("/assign-role")
    public ResponseEntity<?> assignRoleToUser(@RequestBody AssignRoleRequest request) {
        roleService.assignRoleToUser(request.getUserId(), request.getRoleId());
        return ResponseEntity.ok("Role assigned to user successfully");
    }
}