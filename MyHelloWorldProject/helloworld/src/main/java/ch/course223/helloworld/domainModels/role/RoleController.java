package ch.course223.helloworld.domainModels.role;

import ch.course223.helloworld.domainModels.role.dto.RoleDTO;
import ch.course223.helloworld.domainModels.role.dto.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

  private RoleService roleService;

  private RoleMapper roleMapper;

  @Autowired
  public RoleController(RoleService roleService, RoleMapper roleMapper) {
    this.roleService = roleService;
    this.roleMapper = roleMapper;
  }

  @PostMapping({"/", ""})
  public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO roleDTO) {
    return new ResponseEntity<>(roleMapper.toDTO(roleService.create(roleMapper.fromDTO(roleDTO))), HttpStatus.CREATED);
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<RoleDTO>> getAll() {
    return new ResponseEntity<>(roleMapper.toDTOs(roleService.findAll()), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RoleDTO> getById(@PathVariable int id) {
    return new ResponseEntity<>(roleMapper.toDTO(roleService.findById(id)), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RoleDTO> updateById(@PathVariable int id, @RequestBody RoleDTO roleDTO) {
    return new ResponseEntity<>(roleMapper.toDTO(roleService.updateById(id, roleMapper.fromDTO(roleDTO))), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable int id) {
    roleService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
