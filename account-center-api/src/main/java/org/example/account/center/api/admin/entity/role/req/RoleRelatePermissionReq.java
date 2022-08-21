package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;

@Data
public class RoleRelatePermissionReq {
    private Long roleId;
    private Long permissionId;
}
