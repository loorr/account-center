package org.example.account.center.api.entity;

import lombok.Data;

import java.util.ArrayList;
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

    private List<String> defaultRoles= new ArrayList<>(0);
    private List<String> defaultPermissions= new ArrayList<>(0);
    private List<UserGroupItem> userGroups = new ArrayList<>(0);
}
