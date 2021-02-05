package com.HelpForBlind.HFB.Enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.USER_READ)),
    USER(Set.of(Permission.USER_READ,Permission.USER_WRITE));


    private final Set<Permission> permissions;

    Role(Set<Permission> permissions){
        this.permissions= permissions;
    }

    public Set<Permission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
    }
}
