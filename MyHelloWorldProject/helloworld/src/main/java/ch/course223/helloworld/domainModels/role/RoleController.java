package ch.course223.helloworld.domainModels.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

  private RoleService roleService;

  @Autowired
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping({"/", ""})
  public ResponseEntity<Role> create(@RequestBody Role role) {
    return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<Role>> getAll() {
    return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Role> getById(@PathVariable int id) {
    return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Role> updateById(@PathVariable int id, @RequestBody Role role) {
    return new ResponseEntity<>(roleService.updateById(id, role), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable int id) {
    roleService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
