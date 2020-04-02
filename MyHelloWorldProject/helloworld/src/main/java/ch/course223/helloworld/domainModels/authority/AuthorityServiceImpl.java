package ch.course223.helloworld.domainModels.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorityServiceImpl implements AuthorityService {

  private AuthorityRepository authorityRepository;

  @Autowired
  public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
    this.authorityRepository = authorityRepository;
  }

  @Override
  public Authority create(Authority authority) {
    return authorityRepository.save(authority);
  }

  @Override
  public List<Authority> findAll() {
    return authorityRepository.findAll();
  }

  @Override
  public Authority findById(int id) {
    return authorityRepository.findById(id).get();
  }

  @Override
  public Authority updateById(int id, Authority authority) {
    if(authorityRepository.existsById(id)) {
      authority.setId(id);
      authorityRepository.save(authority);

      return authority;
    } else {
      throw new NoSuchElementException("No value present");
    }
  }

  @Override
  public void deleteById(int id) {
    authorityRepository.deleteById(id);
  }
}
