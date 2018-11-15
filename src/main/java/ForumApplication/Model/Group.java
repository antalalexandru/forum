package ForumApplication.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Group {
    @NonNull
    private Integer ID;

    private String name;

    private String prefixFormatting;

    private String suffixFormatting;
}
