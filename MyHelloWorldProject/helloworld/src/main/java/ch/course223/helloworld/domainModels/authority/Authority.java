package ch.course223.helloworld.domainModels.authority;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class Authority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(nullable = false)
  private String name;

  public Authority() {}

  public int getId() {
    return id;
  }

  public Authority setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Authority setName(String name) {
    this.name = name;
    return this;
  }
}
