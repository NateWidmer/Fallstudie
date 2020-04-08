package ch.course223.helloworld.domainModels.user.dto;

import ch.course223.helloworld.domainModels.role.Role;

import java.util.Set;

public class UserDTO {

  private String id;

  private String username;

  private String password;

  private double salary;

  private Set<Role> roles;

  private Boolean locked;

  private Boolean enabled;

  // Standard empty constructor
  public UserDTO() {}

  // Standard getters and setters
  public String getId() {
    return id;
  }

  public UserDTO setId(String id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UserDTO setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserDTO setPassword(String password) {
    this.password = password;
    return this;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public UserDTO setRoles(Set<Role> roles) {
    this.roles = roles;
    return this;
  }

  public Boolean getLocked() {
    return locked;
  }

  public UserDTO setLocked(Boolean locked) {
    this.locked = locked;
    return this;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public UserDTO setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }
}
