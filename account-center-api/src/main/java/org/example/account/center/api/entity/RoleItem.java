package org.example.account.center.api.entity;

import lombok.Data;

import java.util.List;

@Data
public class RoleItem {
    private String name;
    private List<PermissionItem> permissions;
}
