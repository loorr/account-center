package org.example.account.center.web.model;

import com.tove.web.infra.common.BaseModel;
import lombok.Data;

@Data
public class Tenant extends BaseModel {
    private String tenantName;
    private String tenantCode;
    private String remark;
    private Boolean valid;
}
