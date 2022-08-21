package org.example.account.center.web.model;

import com.tove.web.infra.common.BaseModel;
import lombok.Data;

import java.util.Date;

@Data
public class AccountExt extends BaseModel {
    private Long uid;
    private Integer loginNum;
    private Date lastLoginTime;
    private Boolean firstLogin;
}
