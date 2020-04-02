package ch.course223.helloworld.domainModels.user;

import ch.course223.helloworld.domainModels.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
