package org.example.account.center.api.admin.entity.role.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBasePageReq;
import org.example.account.center.api.common.TenantBaseReq;

@Data
public class GetRoleListPageReq extends TenantBaseReq {
    private Long id;
    private Long parentId;
    private String name;
    private String remark;
    private Boolean valid;
}
