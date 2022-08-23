package org.example.account.center.api.admin.entity.usergroup.req;

import com.tove.web.infra.common.Page;
import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

@Data
public class GetUserGroupPageReq extends TenantBaseReq {
    private String name;
    private Long id;
    private Long parentId;
    private String remark;
    private Boolean valid;
}
