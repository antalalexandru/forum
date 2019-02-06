package com.crg.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails extends User implements UserDetails {
    public CustomUserDetails(final User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setAccountExpired(user.isAccountExpired());
        setAccountDisabled(user.isAccountDisabled());
        setAccountLocked(user.isAccountLocked());
        setCredentialsExpired(user.isCredentialsExpired());
        setRoles(user.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return ! super.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return ! super.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return ! super.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return ! super.isAccountDisabled();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }
}
