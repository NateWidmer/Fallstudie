package ch.course223.helloworld.domainModels.user;

import ch.course223.helloworld.domainModels.article.Article;

import java.util.List;

public interface UserService {

  User create(User user);

  List<User> findAll();

  User findById(int id);

  User updateById(int id, User user);

  void deleteById(int id);

  List<Article> getBiddedOn(int id);
}
