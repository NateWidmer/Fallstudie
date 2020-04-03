package ch.course223.helloworld.domainModels.authority.dto;

public class AuthorityDTO {

  private int id;

  private String name;

  // Standard empty constructor
  public AuthorityDTO() {}

  // Standard getters and setters
  public int getId() {
    return id;
  }

  public AuthorityDTO setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public AuthorityDTO setName(String name) {
    this.name = name;
    return this;
  }
}
