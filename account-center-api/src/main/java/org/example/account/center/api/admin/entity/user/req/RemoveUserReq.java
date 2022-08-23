package org.example.account.center.api.admin.entity.user.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class RemoveUserReq extends TenantBaseReq {

    @NotNull
    private Long uid;

}
