package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;

@Data
public class UpdateRoleReq  extends TenantBaseReq {

    @NotNull
    private Long id;

    private String name;
    private String remark;
    private Boolean valid;
    private Long parentId;
}
