package ForumApplication.Model;

import ForumApplication.Model.Member.Member;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Post {
    @NonNull
    private Integer ID;
    private String content;
    private Long datePosted;
    private Member author;
}
