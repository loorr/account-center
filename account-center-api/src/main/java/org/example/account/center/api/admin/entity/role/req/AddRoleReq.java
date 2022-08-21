package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

@Data
public class AddRoleReq extends TenantBaseReq {

    private String name;
    private String remark;
    private Boolean valid;
    private Long parentId;

}
