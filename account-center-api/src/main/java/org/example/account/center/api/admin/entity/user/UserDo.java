package org.example.account.center.api.admin.entity.user;

import com.tove.web.infra.common.BaseModel;
import lombok.Data;

import java.util.Date;

@Data
public class UserDo extends BaseModel {
    private Long uid;
    private String email;
    private String username;
    private String nickname;
    private Integer loginNum;
    private Date lastLoginTime;
}
