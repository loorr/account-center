package org.example.account.center.web.model;

import com.tove.web.infra.common.BaseModel;
import lombok.Data;

import java.util.Date;

@Data
public class
Account extends BaseModel {

    private Long uid;
    private String email;

    private String password;
    private String username;

    private String nickname;

    private Integer loginNum;

    private Date lastLoginTime;

    private Boolean valid;

    private Boolean firstLogin;
}
