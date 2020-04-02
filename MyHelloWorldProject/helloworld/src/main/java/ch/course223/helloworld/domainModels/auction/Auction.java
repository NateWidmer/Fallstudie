package ch.course223.helloworld.domainModels.auction;

import ch.course223.helloworld.domainModels.article.Article;
import ch.course223.helloworld.domainModels.bid.Bid;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "auction")
public class Auction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(nullable = false)
  private String description;

  @Column(name = "fixed_price", nullable = false)
  private long fixedPrice;

  @Column(name = "starting_price", nullable = false)
  private long startingPrice;

  @Column(name = "is_public", nullable = false)
  private boolean isPublic;

  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<Bid> bids;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "article_id")
  private Article article;

  public Auction() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getFixedPrice() {
    return fixedPrice;
  }

  public void setFixedPrice(long fixedPrice) {
    this.fixedPrice = fixedPrice;
  }

  public long getStartingPrice() {
    return startingPrice;
  }

  public void setStartingPrice(long startingPrice) {
    this.startingPrice = startingPrice;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean aPublic) {
    isPublic = aPublic;
  }

  public Set<Bid> getBids() {
    return bids;
  }

  public void setBids(Set<Bid> bids) {
    this.bids = bids;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }
}
