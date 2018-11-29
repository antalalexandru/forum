package ForumApplication.Model;

import ForumApplication.Model.Member.MemberMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mappers {
    @Bean
    public MemberMapper getMemberMapper() {
        return new MemberMapper();
    }
}
