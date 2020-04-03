package ch.course223.helloworld.domainModels.article;

import ch.course223.helloworld.domainModels.auction.Auction;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private long value;

  public Article() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

}
