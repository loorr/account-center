package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RoleRelatePermissionReq  extends TenantBaseReq {
    @NotNull
    private Long roleId;
    private List<Long> permissionIds;
}
