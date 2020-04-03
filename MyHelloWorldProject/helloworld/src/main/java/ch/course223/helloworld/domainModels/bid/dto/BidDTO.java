package ch.course223.helloworld.domainModels.bid.dto;

import ch.course223.helloworld.domainModels.auction.Auction;
import ch.course223.helloworld.domainModels.user.User;

public class BidDTO {

  private int id;

  private long amount;

  private Auction auction;

  private User user;

  // Standard empty constructor
  public BidDTO() {}

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

  public Auction getAuction() {
    return auction;
  }

  public void setAuction(Auction auction) {
    this.auction = auction;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
