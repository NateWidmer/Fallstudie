package ch.course223.helloworld.domainModels.user;

import ch.course223.helloworld.domainModels.auction.Auction;
import ch.course223.helloworld.domainModels.bid.Bid;
import ch.course223.helloworld.domainModels.role.Role;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "users_role",
      joinColumns = @JoinColumn(name = "users_id", nullable = true),
      inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles;

  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
  private List<Auction> auctions;

  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<Bid> bids;

  @Column(name = "account_expiration_date")
  private LocalDate accountExpirationDate;

  @Column(name = "credentials_expiration_date")
  private LocalDate credentialsExpirationDate;

  @Column
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean locked;

  @Column
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private Boolean enabled;

  public User() {}

  public int getId() {
    return id;
  }

  public User setId(int id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public User setRoles(Set<Role> roles) {
    this.roles = roles;
    return this;
  }

  public List<Auction> getAuctions() {
      return auctions;
   }

  public User setAuctions(List<Auction> auctions) {
       this.auctions = auctions;
       return this;
   }

  public LocalDate getAccountExpirationDate() {
    return accountExpirationDate;
  }

  public User setAccountExpirationDate(LocalDate accountExpirationDate) {
    this.accountExpirationDate = accountExpirationDate;
    return this;
  }

  public LocalDate getCredentialsExpirationDate() {
    return credentialsExpirationDate;
  }

  public User setCredentialsExpirationDate(LocalDate credentialsExpirationDate) {
    this.credentialsExpirationDate = credentialsExpirationDate;
    return this;
  }

  public Boolean getLocked() {
    return locked;
  }

  public User setLocked(Boolean locked) {
    this.locked = locked;
    return this;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public User setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  public Set<Bid> getBids() {
    return bids;
  }

  public void setBids(Set<Bid> bids) {
    this.bids = bids;
  }

}
