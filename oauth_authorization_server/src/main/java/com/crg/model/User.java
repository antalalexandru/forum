package com.crg.model;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    /**
     *  User id
     */
    private int id;

    /**
     *  Username used to authenticate this user
     */
    private String username;

    /**
     *  Password used to authenticate this user
     */
    private String password;

    /**
     *  Indicates whether the user's account has expired. An expired account cannot be authenticated.
     */
    private boolean accountExpired;

    /**
     *  Indicates whether the user is locked or unlocked. A locked user cannot be authenticated.
     */
    private boolean accountLocked;

    /**
     *  Indicates whether the user's credentials (password) has expired. Expired credentials prevent authentication.
     */
    private boolean credentialsExpired;

    /**
     *  Indicates whether the user is enabled or disabled. A disabled user cannot be authenticated.
     */
    private boolean accountDisabled;

    /**
     *  Returns the authorities granted to the user.
     */
    private Collection<SimpleGrantedAuthority> roles;
}