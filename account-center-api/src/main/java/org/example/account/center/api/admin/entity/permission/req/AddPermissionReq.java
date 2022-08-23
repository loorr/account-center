package org.example.account.center.api.admin.entity.permission.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.account.center.api.common.TenantBaseReq;

import javax.validation.constraints.NotEmpty;

@Data
public class AddPermissionReq extends TenantBaseReq {
    private Long parentId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String code;

    private String url;

    @NotEmpty
    private String type;

    private String remark;

    @ApiModelProperty(value = "是否有效", hidden = true)
    private Boolean valid = true;

}
