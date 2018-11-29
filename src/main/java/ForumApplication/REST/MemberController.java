package ForumApplication.REST;

import ForumApplication.Model.Member;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
/*
    private HashMap<Integer, Member> members = new HashMap<Integer, Member>() {{
        put(1, Member.builder().id(1).name("Andrei").build());
        put(2, Member.builder().id(2).name("Mihai").build());
        put(3, Member.builder().id(3).name("Marian").build());
        put(4, Member.builder().id(4).name("Luca").build());
    }};

    @GetMapping
    public Collection<Member> getMembers() {
        return members.values();
    }

    @GetMapping("/{id}")
    public Member getMember(
            @PathVariable(value="id") Integer id
    ) {
        return Member.builder().id(id).name("Maria").build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable(value="id") Integer id) {
        this.members.remove(id);
    }
*/
    /*@PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyMember(@PathVariable(value="id") Integer id, @RequestBody Member member) {
        member.setID(id);
        this.members.put(id, member);
    }*/

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Member modifyMember(@PathVariable(value="id") Integer id, @RequestBody Member member) {
        System.out.println(member.toString());
        return member;
    }

}
