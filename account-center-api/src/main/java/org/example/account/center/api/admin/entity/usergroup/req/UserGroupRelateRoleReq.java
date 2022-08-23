package org.example.account.center.api.admin.entity.usergroup.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserGroupRelateRoleReq {
    @NotNull
    private Long ugId;
    private List<Long> roleIds;
}
