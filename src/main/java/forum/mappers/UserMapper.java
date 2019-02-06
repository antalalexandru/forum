package forum.mappers;

import forum.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    private final static String ID_MAPPER = "id";
    private final static String NAME_MAPPER = "username";
    private final static String PASSWORD_MAPPER = "password";
    private final static String EMAIL_MAPPER = "email";
    private final static String ROLE_ID_MAPPER = "role_id";
    private final static String ROLE_NAME_MAPPER = "role_name";


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getInt(ID_MAPPER))
                .username(rs.getString(NAME_MAPPER))
                .password(rs.getString(PASSWORD_MAPPER))
                .email(rs.getString(EMAIL_MAPPER))
                .build();
    }
}
