package org.example.account.center.api.admin.entity.permission.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddPermissionReq {
    private Long parentId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String code;

    private String url;

    @NotEmpty
    private String type;

    private String remark;

}
