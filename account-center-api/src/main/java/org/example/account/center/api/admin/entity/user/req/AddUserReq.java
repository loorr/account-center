package org.example.account.center.api.admin.entity.user.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ApiModel
public class AddUserReq {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String username;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String nickname;
}
