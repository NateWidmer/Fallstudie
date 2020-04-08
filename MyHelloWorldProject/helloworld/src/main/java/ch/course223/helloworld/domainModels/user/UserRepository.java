package ch.course223.helloworld.domainModels.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  public User findByUsernameAndLockedFalse(String username);

  @Query(value = "SELECT * from users where salary >= :min and salary <= :max", nativeQuery = true)
  List<User> getBySalary(@Param("min") double minSalary, @Param("max") double maxSalary);

}
