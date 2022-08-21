package org.example.account.center.web.model;

import lombok.Data;
@Data
public class Account extends TenantModel {
    private Long uid;
    private String email;
    private String password;
    private String username;
    private String nickname;
    private Boolean valid;
    private AccountExt accountExt;
}
