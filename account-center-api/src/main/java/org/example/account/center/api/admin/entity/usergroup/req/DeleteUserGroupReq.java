package org.example.account.center.api.admin.entity.usergroup.req;


import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;

@Data
public class DeleteUserGroupReq extends TenantBaseReq {
    @NotNull
    private Long id;

}
