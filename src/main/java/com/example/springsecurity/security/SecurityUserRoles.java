package com.example.springsecurity.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum SecurityUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(SecurityUserPermissions.COURSE_READ, SecurityUserPermissions.COURSE_WRITE, SecurityUserPermissions.STUDENT_READ, SecurityUserPermissions.STUDENT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(SecurityUserPermissions.COURSE_READ, SecurityUserPermissions.STUDENT_READ));

    private final Set<SecurityUserPermissions> permissions;

    SecurityUserRoles(Set<SecurityUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<SecurityUserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
