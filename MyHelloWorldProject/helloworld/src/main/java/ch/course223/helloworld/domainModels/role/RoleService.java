package ch.course223.helloworld.domainModels.role;

import java.util.List;

public interface RoleService {

  Role create(Role role);

  List<Role> findAll();

  Role findById(int id);

  Role updateById(int id, Role role);

  void deleteById(int id);
}
