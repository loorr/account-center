package org.example.account.center.api.admin.entity.usergroup.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

@Data
public class AddUserGroupReq extends TenantBaseReq {
    private Long parentId;
    private String name;
    private String remark;
}
