package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class RoleRelatePermissionReq  extends TenantBaseReq {
    @NotNull
    private Long roleId;
    @Size(min = 1)
    private List<Long> permissionIds;
}
