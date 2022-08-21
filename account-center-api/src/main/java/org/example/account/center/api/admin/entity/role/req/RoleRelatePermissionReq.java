package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

@Data
public class RoleRelatePermissionReq  extends TenantBaseReq {
    private Long roleId;
    private Long permissionId;
}
