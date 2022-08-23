package org.example.account.center.api.admin.entity.usergroup;

import lombok.Data;

import java.util.Set;

@Data
public class UserGroupTreeVo {
    private Long id;
    private Long parentId;
    private String name;
    private String remark;
    private Boolean valid;
    private Set<UserGroupTreeVo> children;
}
