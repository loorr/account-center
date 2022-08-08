package org.example.account.center.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AccountVo {
    private Long uid;
    private String email;
    private String username;
    private String nickname;
    private Integer loginNum;
    private Date lastLoginTime;
}
