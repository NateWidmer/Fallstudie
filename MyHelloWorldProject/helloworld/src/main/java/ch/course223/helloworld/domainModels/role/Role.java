package ch.course223.helloworld.domainModels.role;

import ch.course223.helloworld.domainModels.authority.Authority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(nullable = false)
  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "role_authority",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "authority_id")
  )
  private Set<Authority> authorities;

  public Role() {
  }

  public int getId() {
    return id;
  }

  public Role setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Role setName(String name) {
    this.name = name;
    return this;
  }

  public Set<Authority> getAuthorities() {
    return authorities;
  }

  public Role setAuthorities(Set<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }

}
