package org.example.account.center.api.admin.entity.user.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;

@Data
public class ResetPasswordReq extends TenantBaseReq {
    @NotNull
    private Long uid;
}
