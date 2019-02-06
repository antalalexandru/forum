package com.crg.repository;

import com.crg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

@Repository
@PropertySource("classpath:persistence.properties")
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${persistence.member.get_member_by_username}")
    private String getUserByUsernameQueryString;

    @Value("${persistence.roles.get_roles_by_user_id}")
    private String getUserRolesByUserIdQueryString;

    private Optional<Collection<SimpleGrantedAuthority>> getUserRolesByUserId(int userId) {
        try {
            return Optional.of(jdbcTemplate.query(getUserRolesByUserIdQueryString, new Object[]{userId}, (ResultSet rs, int rowNum) -> new SimpleGrantedAuthority(rs.getString("role_name"))));
        }
        catch(EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Optional<User> findByName(final String username) {
        try {
            User result = jdbcTemplate.queryForObject(getUserByUsernameQueryString, new Object[]{username}, (ResultSet rs, int rowNum) -> User.builder()
                    .id(rs.getInt("user_id"))
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .accountExpired(rs.getBoolean("account_expired"))
                    .accountDisabled(rs.getBoolean("account_disabled"))
                    .accountLocked(rs.getBoolean("account_locked"))
                    .credentialsExpired(rs.getBoolean("credentials_expired"))
                    .build());

            if(result == null) {
                return Optional.empty();
            }

            result.setRoles( getUserRolesByUserId(result.getId()).orElse(Collections.emptyList()));

            return Optional.of(result);
        }
        catch(EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }
}