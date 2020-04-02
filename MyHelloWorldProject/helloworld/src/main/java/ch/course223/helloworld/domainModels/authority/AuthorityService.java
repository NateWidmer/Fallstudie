package ch.course223.helloworld.domainModels.authority;

import java.util.List;

public interface AuthorityService {

  Authority create(Authority authority);

  List<Authority> findAll();

  Authority findById(int id);

  Authority updateById(int id, Authority authority);

  void deleteById(int id);
}
