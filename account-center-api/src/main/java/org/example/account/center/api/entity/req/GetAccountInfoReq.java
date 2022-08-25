package org.example.account.center.api.entity.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;

@Data
public class GetAccountInfoReq extends TenantBaseReq {
    @NotNull
    private Long uid;
}
