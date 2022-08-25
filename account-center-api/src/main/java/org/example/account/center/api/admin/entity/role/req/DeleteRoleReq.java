package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;

@Data
public class DeleteRoleReq extends TenantBaseReq {
    @NotNull
    private Long id;
}
