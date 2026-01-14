package com.duclm.minitaxi.dto;

import lombok.Data;

@Data
public class AssignPermissionRequest {
    private Long roleId;
    private Long permissionId;
}