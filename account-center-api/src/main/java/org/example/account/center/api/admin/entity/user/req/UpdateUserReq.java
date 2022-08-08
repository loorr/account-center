package org.example.account.center.api.admin.entity.user.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class UpdateUserReq {

    @NotNull
    private Long uid;

    private String email;

    private String username;

    private String nickname;

}
