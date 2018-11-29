package ForumApplication.Persistence;

import ForumApplication.Exceptions.MemberNotFoundException;
import ForumApplication.Model.Member.Member;
import ForumApplication.Model.Member.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
@PropertySource("classpath:config/persistence.properties")
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MemberMapper memberMapper;

    @Value("${persistence.member.get_all_members}")
    private String getAllMembersSqlQuery;

    @Value("${persistence.member.get_member}")
    private String getMemberQuery;


    public List<Member> getAllMembers() {
        return jdbcTemplate.query(getAllMembersSqlQuery, memberMapper);
    }

    public Optional<Member> getMember(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(getMemberQuery, new Object[]{id}, memberMapper));
        }
        catch(EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }
}
