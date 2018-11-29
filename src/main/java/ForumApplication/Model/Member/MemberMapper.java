package ForumApplication.Model.Member;

import ForumApplication.Model.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper<Member> {
    private final static String ID_MAPPER = "member_id";
    private final static String NAME_MAPPER = "m_name";
    private final static String PASSWORD_MAPPER = "password";
    private final static String EMAIL_MAPPER = "email";
    private final static String LAST_ACCESS_MAPPER = "last_active";
    private final static String WARNING_PONTS_MAPPER = "warning_points";
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Member.builder()
                .id(rs.getInt(ID_MAPPER))
                .name(rs.getString(NAME_MAPPER))
                .password(rs.getString(PASSWORD_MAPPER))
                .email(rs.getString(EMAIL_MAPPER))
                .group(new Group().mapRow(rs, rowNum))
                .lastActive(rs.getLong(LAST_ACCESS_MAPPER))
                .warningPoints(rs.getInt(WARNING_PONTS_MAPPER))
                .build();
    }
}
