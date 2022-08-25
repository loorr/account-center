package org.example.account.center.api.admin.entity.user.req;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.example.account.center.api.common.TenantBasePageReq;

@Data
@ApiModel
public class GetUserPageListReq extends TenantBasePageReq {
    private String userName;
    private String nickname;
    private String email;
}
