package ch.course223.helloworld.domainModels.user;

import ch.course223.helloworld.domainModels.article.Article;
import ch.course223.helloworld.domainModels.user.dto.UserDTO;
import ch.course223.helloworld.domainModels.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  private UserMapper userMapper;

  @Autowired
  public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @PostMapping({"/", ""})
  public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
    return new ResponseEntity<UserDTO>(userMapper.toDTO(userService.create(userMapper.fromDTO(userDTO))), HttpStatus.CREATED);
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<UserDTO>> getAll() {
    return new ResponseEntity<>(userMapper.toDTOs(userService.findAll()), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getById(@PathVariable int id) {
    return new ResponseEntity<>(userMapper.toDTO(userService.findById(id)), HttpStatus.OK);
  }

  // @GetMapping("/{id}/biddedOn")
  // public ResponseEntity<List<Article>> getAllBiddedOn(@PathVariable int id) {
  //  return new ResponseEntity<>(userService.getBiddedOn(id), HttpStatus.OK);
  // }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateById(@PathVariable int id, @RequestBody UserDTO userDTO) {
    return new ResponseEntity<>(userMapper.toDTO(userService.updateById(id, userMapper.fromDTO(userDTO))), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable int id) {
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
