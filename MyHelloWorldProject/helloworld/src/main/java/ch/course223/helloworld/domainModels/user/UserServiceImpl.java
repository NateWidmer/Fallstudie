package ch.course223.helloworld.domainModels.user;

import ch.course223.helloworld.domainModels.article.Article;
import ch.course223.helloworld.domainModels.auction.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User create(User user) {
    return this.userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  @Override
  public User findById(int id) {
    return this.userRepository.findById(id).orElse(null);
  }

  @Override
  public User updateById(int id, User user) {
    if(userRepository.existsById(id)) {
      user.setId(id);
      userRepository.save(user);

      return user;
    } else {
      throw new NoSuchElementException("No value present");
    }
  }

  @Override
  public void deleteById(int id) {
    userRepository.deleteById(id);
  }

  @Override
  public List<Article> getBiddedOn(int id) {
    User user = findById(id);
    List<Article> articlesWithBids = new ArrayList<>();
    if(user.getAuctions() != null) {
      for(Auction auction : user.getAuctions()) {
        if(!auction.getBids().isEmpty()) {
          articlesWithBids.add(auction.getArticle());
        }
      }
    }
    return articlesWithBids;
  }
}
