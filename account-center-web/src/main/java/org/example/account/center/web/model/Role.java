package org.example.account.center.web.model;

import lombok.Data;

@Data
public class Role  extends TenantModel {
    private Long parentId;
    private String name;
    private String remark;
    private Boolean valid;
}
