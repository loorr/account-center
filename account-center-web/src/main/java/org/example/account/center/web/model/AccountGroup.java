package org.example.account.center.web.model;

import lombok.Data;

@Data
public class AccountGroup  extends TenantModel {
    private Long parentId;
    private String name;
    private String remark;
    private Boolean valid;
}
