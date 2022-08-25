package org.example.account.center.api.entity.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

@Data
public class LoginReq extends TenantBaseReq {
    private String email;
    private String password;
}
