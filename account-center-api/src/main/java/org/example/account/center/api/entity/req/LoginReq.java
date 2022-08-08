package org.example.account.center.api.entity.req;

import lombok.Data;

@Data
public class LoginReq {
    private String email;
    private String password;
}
