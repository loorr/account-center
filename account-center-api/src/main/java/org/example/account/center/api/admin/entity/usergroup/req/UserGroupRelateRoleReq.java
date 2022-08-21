package org.example.account.center.api.admin.entity.usergroup.req;

import lombok.Data;

@Data
public class UserGroupRelateRoleReq {
    private Long ugId;
    private Long roleId;
}
