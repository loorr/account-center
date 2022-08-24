package org.example.account.center.api.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AccountVo {
    private Long uid;
    private String email;
    private String username;
    private String nickname;
    private Integer loginNum;
    private Date lastLoginTime;

    private List<String> defaultRoles;
    private List<String> defaultPermissions;
    private List<UserGroupItem> userGroups;
}
