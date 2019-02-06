package forum.rest;

import forum.exceptions.MemberNotFoundException;
import forum.model.User;
import forum.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUser() {
        return userRepository.getAllMembers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable(value="id") Integer id) throws MemberNotFoundException {
        return userRepository.getMember(id).orElseThrow(MemberNotFoundException::new);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="This user does not exist")
    public void userNotFound() {
    }
}
