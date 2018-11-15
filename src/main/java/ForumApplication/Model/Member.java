package ForumApplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Member {

    /**
     * Member id
     * */
    @NonNull
    private Integer id;

    private String name;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String hashedPassword;

    @JsonIgnore
    private Long lastActive;

    private Group group;

    @JsonIgnore
    private Integer warningPoints;
}
