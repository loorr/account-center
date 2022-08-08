package org.example.account.center.api.entity.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ModifyUserInfoReq {
    @NotNull
    private Long uid;

    @NotEmpty
    private String newPassword;
}
