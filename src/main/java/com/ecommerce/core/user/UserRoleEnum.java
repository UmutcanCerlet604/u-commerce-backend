package com.ecommerce.core.user;

public enum UserRoleEnum {
    ROLE_ADMIN("role_admin"),
    ROLE_USER("role_user");


    private final String label;
    UserRoleEnum(String label) {
        this.label = label;
    }
}
