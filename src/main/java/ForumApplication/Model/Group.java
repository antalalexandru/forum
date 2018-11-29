package ForumApplication.Model;

import lombok.*;
import org.springframework.jdbc.core.RowMapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Group implements RowMapper<Group> {

    private final static String ID_MAPPER = "group_id";
    private final static String NAME_MAPPER = "g_name";
    private final static String PREFIX_MAPPER = "prefix";
    private final static String SUFFIX_MAPPER = "suffix";

    private Integer id;

    private String name;

    private String prefixFormatting;

    private String suffixFormatting;

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Group.builder()
                .id(rs.getInt(ID_MAPPER))
                .name(rs.getString(NAME_MAPPER))
                .prefixFormatting(rs.getString(PREFIX_MAPPER))
                .suffixFormatting(rs.getString(SUFFIX_MAPPER))
                .build();
    }
}
