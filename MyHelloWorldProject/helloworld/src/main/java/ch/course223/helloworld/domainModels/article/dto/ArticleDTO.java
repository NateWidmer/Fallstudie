package ch.course223.helloworld.domainModels.article.dto;

import ch.course223.helloworld.domainModels.article.Article;

public class ArticleDTO {

  private int id;

  private String name;

  private String description;

  private long value;

  public ArticleDTO() {
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
