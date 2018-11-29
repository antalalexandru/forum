package ForumApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString // TODO TEMPORARY
public class Member implements RowMapper<Member> {

    private final static String ID_MAPPER = "id";
    private final static String NAME_MAPPER = "name";
    private final static String PASSWORD_MAPPER = "password";
    private final static String EMAIL_MAPPER = "email";
    private final static String LAST_ACCESS_MAPPER = "last_active";
    private final static String WARNING_PONTS_MAPPER = "warning_ponts";

    private Integer id;

    @NonNull
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long lastActive;

    @NonNull
    private Group group;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer warningPoints;

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