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
    @NonNull
    private Integer id;

    private String name;

    private String prefixFormatting;

    private String suffixFormatting;

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        throw new NotImplementedException();
    }
}
