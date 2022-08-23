package org.example.account.center.api.admin.entity.permission.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotNull;

@Data
public class UpdatePermissionReq extends TenantBaseReq {
    @NotNull
    private Long id;

    private Long parentId;
    private String name;
    private String code;
    private String url;
    private String type;
    private String remark;
    private Boolean valid;
}
