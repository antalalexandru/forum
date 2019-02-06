package com.crg.persistence;

import com.crg.mappers.UserMapper;
import com.crg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@PropertySource("classpath:config/persistence.properties")
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Value("${persistence.member.get_all_members}")
    private String getAllMembersSqlQuery;

    @Value("${persistence.member.get_member}")
    private String getMemberQuery;

    @Value("${persistence.member.get_member_by_username}")
    private String getUserByUsernameQueryString;

    @Value("${persistence.member.get_member_by_email}")
    private String getUserByEmailQueryString;

    public List<User> getAllMembers() {
        return jdbcTemplate.query(getAllMembersSqlQuery, userMapper);
    }

    public Optional<User> getMember(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(getMemberQuery, new Object[]{id}, userMapper));
        }
        catch(EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Optional<User> getUserByUsername(final String username) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(getUserByUsernameQueryString, new Object[]{username}, userMapper));
        }
        catch(EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Optional<User> getUserByEmail(final String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(getUserByEmailQueryString, new Object[]{email}, userMapper));
        }
        catch(EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }


}
