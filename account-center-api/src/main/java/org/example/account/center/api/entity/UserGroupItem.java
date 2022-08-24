package org.example.account.center.api.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserGroupItem {
    private String name;
    private Integer weight;
    private List<RoleItem> roles;
}
