package org.example.account.center.api.admin.entity.user.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ResetPasswordReq {
    @NotNull
    private Long uid;
}
