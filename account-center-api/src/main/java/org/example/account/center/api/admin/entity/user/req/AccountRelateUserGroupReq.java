package org.example.account.center.api.admin.entity.user.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AccountRelateUserGroupReq {
    @NotNull
    private Long uid;
    private List<Long> ugIds;
}
