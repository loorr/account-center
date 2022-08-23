package org.example.account.center.api.admin.entity.user.req;

import lombok.Data;

import java.util.List;

@Data
public class AccountRelateUserGroupReq {
    private Long uid;
    private List<Long> ugIds;
}
