package mk.finki.ukim.mk.lab_1.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER, ROLE_LIBRARIAN, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}