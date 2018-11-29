package ForumApplication.REST;

import ForumApplication.Exceptions.MemberNotFoundException;
import ForumApplication.Model.Member.Member;
import ForumApplication.Persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Member> getMembers() {
        return memberRepository.getAllMembers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Member getMember(@PathVariable(value="id") Integer id) throws MemberNotFoundException {
        return memberRepository.getMember(id).orElseThrow(MemberNotFoundException::new);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="This member does not exist")
    public void memberNotFound() {
    }
}
