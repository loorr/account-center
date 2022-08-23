package org.example.account.center.api.admin.entity.usergroup.req;

import lombok.Data;

import java.util.List;

@Data
public class UserGroupRelateRoleReq {
    private Long ugId;
    private List<Long> roleIds;
}
