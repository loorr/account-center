package org.example.account.center.web.model;

import lombok.Data;

@Data
public class Permission extends TenantModel {
    private Long parentId;
    private String name;
    private String code;
    private String url;
    private String type;
    private String remark;
    private Boolean valid;
}
