package org.example.account.center.api.admin.entity.usergroup.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotEmpty;

@Data
public class AddUserGroupReq extends TenantBaseReq {
    private Long parentId;
    @NotEmpty
    private String name;

    private String remark;
}
