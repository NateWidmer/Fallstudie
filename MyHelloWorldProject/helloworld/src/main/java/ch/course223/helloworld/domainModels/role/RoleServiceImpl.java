package ch.course223.helloworld.domainModels.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Role create(Role role) {
    return roleRepository.save(role);
  }

  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }

  @Override
  public Role findById(int id) {
    return roleRepository.findById(id).get();
  }

  @Override
  public Role updateById(int id, Role role) {
    if(roleRepository.existsById(id)) {
      role.setId(id);
      roleRepository.save(role);

      return role;
    } else {
      throw new NoSuchElementException("No value present");
    }
  }

  @Override
  public void deleteById(int id) {
    roleRepository.deleteById(id);
  }
}
