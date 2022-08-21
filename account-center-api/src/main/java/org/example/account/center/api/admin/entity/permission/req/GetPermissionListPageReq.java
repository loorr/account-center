package org.example.account.center.api.admin.entity.permission.req;

import com.github.pagehelper.Page;
import lombok.Data;

@Data
public class GetPermissionListPageReq extends Page {
    private String name;
    private String code;
    private String url;
    private String type;
    private String remark;
    private Boolean valid;
}
