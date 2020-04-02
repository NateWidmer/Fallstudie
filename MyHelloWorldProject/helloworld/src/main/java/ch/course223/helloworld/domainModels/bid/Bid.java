package ch.course223.helloworld.domainModels.bid;

import ch.course223.helloworld.domainModels.auction.Auction;
import ch.course223.helloworld.domainModels.user.User;

import javax.persistence.*;

@Entity
@Table(name = "bid")
public class Bid {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(nullable = false)
  private long amount;

  @ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  public Bid() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }
}
