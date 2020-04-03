package ch.course223.helloworld.domainModels.auction.dto;

import ch.course223.helloworld.domainModels.article.Article;
import ch.course223.helloworld.domainModels.auction.Auction;
import ch.course223.helloworld.domainModels.bid.Bid;
import ch.course223.helloworld.domainModels.user.User;

import java.util.Set;

public class AuctionDTO {

  private int id;

  private String description;

  private long fixedPrice;

  private long startingPrice;

  private boolean isPublic;

  private Set<Bid> bids;

  private Article article;

  private User user;
}
