package org.example.account.center.api.admin.entity.permission;

import lombok.Data;

import java.util.Set;

@Data
public class PermissionTreeVo {
    private Long parentId;
    private String name;
    private String code;
    private String url;
    private String type;
    private String remark;
    private Boolean valid;
    private Set<PermissionTreeVo> children;
}
