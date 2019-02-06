package forum.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Topic {

    @NonNull
    private Integer ID;

    private String topicName;

    private List<Post> posts;

    private Category category;

    private Boolean isClosed;

    private Boolean isHidden;

    private Boolean isPinned;
}
