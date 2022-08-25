package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotEmpty;

@Data
public class AddRoleReq extends TenantBaseReq {

    @NotEmpty
    private String name;
    private String remark;
    private Long parentId;

}
