package org.example.account.center.web.model;

import com.tove.web.infra.common.BaseModel;
import lombok.Data;

@Data
public class Role extends BaseModel {
    private String name;
    private String remark;
    private Boolean valid;
}
