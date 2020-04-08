package ch.course223.helloworld.domainModels.user;

import ch.course223.helloworld.domainModels.authority.Authority;
import ch.course223.helloworld.domainModels.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

  private User user;

  public UserDetailsImpl(User user) {
    super();
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    for (Role role : user.getRoles()) {
      for (Authority authority : role.getAuthorities()) {
        grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
      }
    }
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO implement account expired check
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !user.isLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO implement credentials expired check
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
