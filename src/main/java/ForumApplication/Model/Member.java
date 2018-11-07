package ForumApplication.Model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Member implements ID<Integer> {
    private Integer id;
    private String name;

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public void setID(Integer id) {
        this.id = id;
    }
}
