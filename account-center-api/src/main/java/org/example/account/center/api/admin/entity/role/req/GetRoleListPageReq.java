package org.example.account.center.api.admin.entity.role.req;

import com.tove.web.infra.common.Page;
import lombok.Data;

@Data
public class GetRoleListPageReq extends Page {
    private String roleName;
}
