package tech.inno100.tryjesusapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    MEMBER_READ("member:read"),
    MEMBER_WRITE("member:write");

    @Getter
    private final String permission;
}
