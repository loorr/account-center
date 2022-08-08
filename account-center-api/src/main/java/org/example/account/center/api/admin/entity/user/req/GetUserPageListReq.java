package org.example.account.center.api.admin.entity.user.req;


import com.tove.web.infra.common.Page;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class GetUserPageListReq extends Page {
    private String userName;
    private String email;
}
