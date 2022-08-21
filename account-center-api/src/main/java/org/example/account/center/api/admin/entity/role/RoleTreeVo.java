package org.example.account.center.api.admin.entity.role;

import lombok.Data;

import java.util.Set;

@Data
public class RoleTreeVo {
    private Long id;
    private String name;
    private Long parentId;
    private String remark;
    private Boolean valid;
    private Set<RoleTreeVo> children;
}
