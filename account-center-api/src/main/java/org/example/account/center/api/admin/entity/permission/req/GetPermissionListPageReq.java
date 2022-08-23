package org.example.account.center.api.admin.entity.permission.req;

import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

@Data
public class GetPermissionListPageReq extends TenantBaseReq {
    private String name;
    private String code;
    private String url;
    private String type;
    private String remark;
    private Boolean valid;
}
