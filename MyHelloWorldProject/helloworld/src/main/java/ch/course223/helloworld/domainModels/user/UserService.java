package ch.course223.helloworld.domainModels.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

  User create(User user);

  List<User> findAll();

  User findById(String id);

  User updateById(String id, User user);

  void deleteById(String id);

  List<User> getBySalary(double min, double max);

}
