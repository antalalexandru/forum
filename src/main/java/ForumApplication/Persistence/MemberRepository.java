package ForumApplication.Persistence;

import ForumApplication.Model.Member.Member;
import ForumApplication.Model.Member.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:config/persistence.properties")
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${persistence.member.get_all_members}")
    private String getAllMembersSqlQuery;

    public List<Member> getAllMembers() {
        return jdbcTemplate.query(getAllMembersSqlQuery, new MemberMapper());
    }
}
