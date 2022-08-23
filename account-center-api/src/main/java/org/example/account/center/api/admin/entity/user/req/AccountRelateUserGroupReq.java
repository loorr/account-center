package org.example.account.center.api.admin.entity.user.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AccountRelateUserGroupReq {
    @NotNull
    private Long uid;
    @Size(min = 1)
    private List<Long> ugIds;
}
