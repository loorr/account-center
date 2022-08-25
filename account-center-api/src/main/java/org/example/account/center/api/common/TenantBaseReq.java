package org.example.account.center.api.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TenantBaseReq {

    @ApiModelProperty(value = "tenantId", hidden = true)
    private Long tenantId;
}
