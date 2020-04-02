package ch.course223.helloworld.domainModels.user;

import ch.course223.helloworld.domainModels.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping({"/", ""})
  public ResponseEntity<User> create(@RequestBody User user) {
    return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<User>> getAll() {
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getById(@PathVariable int id) {
    return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
  }

  @GetMapping("/{id}/biddedOn")
  public ResponseEntity<List<Article>> getAllBiddedOn(@PathVariable int id) {
    return new ResponseEntity<>(userService.getBiddedOn(id), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateById(@PathVariable int id, @RequestBody User user) {
    return new ResponseEntity<>(userService.updateById(id, user), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable int id) {
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
