package ForumApplication.Model;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Category {

    @NonNull
    private Integer ID;

    private Category parentCategory;

    private String name;

    private String description;

    private List<Category> childCategories;
}
