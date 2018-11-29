package ForumApplication.Model.Member;

import ForumApplication.Model.Group;
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
public class Member {

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
}