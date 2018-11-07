package ForumApplication.REST;

import ForumApplication.Model.Member;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
    @GetMapping
    public List<Member> getMembers() {
        return Arrays.asList(
                Member.builder().id(1).name("Marta").build(),
                Member.builder().id(2).name("Maria").build(),
                Member.builder().id(3).name("Marana").build(),
                Member.builder().id(4).name("Martata").build()
        );
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable(value="id") Integer id) {
        return Member.builder().id(id).name("Maria").build();
    }
}
