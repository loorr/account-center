package org.example.account.center.web.model;

import com.tove.web.infra.common.BaseModel;
import lombok.Data;

import java.util.Date;

@Data
public class Account extends BaseModel {

    private Long uid;
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户名
     */
    private String nickname;

    /**
     * 登录次数
     */
    private Integer loginNum;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    private Boolean valid;
}
