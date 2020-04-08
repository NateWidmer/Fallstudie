package ch.course223.helloworld.domainModels.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  // The logic for creating a new user
  @Override
  public User create(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  @Override
  public User findById(String id) {
    return this.userRepository.findById(id).orElse(null);
  }

  @Override
  public User updateById(String id, User user) {
    if (userRepository.existsById(id)) {
      user.setId(id);
      userRepository.save(user);

      return user;
    } else {
      throw new NoSuchElementException("No value present");
    }
  }

  @Override
  public void deleteById(String id) {
    userRepository.deleteById(id);
  }

  @Override
  public List<User> getBySalary(double min, double max) {
    return userRepository.getBySalary(min, max);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      return new UserDetailsImpl(findByUsername(username));
    } catch (NoSuchElementException e) {
      throw new UsernameNotFoundException(e.getMessage());
    }
  }

  private User findByUsername(String username) {
    return userRepository.findByUsernameAndLockedFalse(username);
  }
}

