package org.example.account.center.web.model;

import lombok.Data;

import java.util.List;

@Data
public class AccountGroup  extends TenantModel {
    private Long parentId;
    private String name;
    private String remark;
    private Boolean valid;
}
