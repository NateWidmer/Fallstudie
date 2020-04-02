package ch.course223.helloworld.domainModels.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BidServiceImpl implements BidService {

  private BidRepository bidRepository;

  @Autowired
  public BidServiceImpl(BidRepository bidRepository) {
    this.bidRepository = bidRepository;
  }

  @Override
  public Bid create(Bid bid) {
    return bidRepository.save(bid);
  }

  @Override
  public List<Bid> findAll() {
    return bidRepository.findAll();
  }

  @Override
  public Bid findById(int id) {
    return bidRepository.findById(id).get();
  }

  @Override
  public Bid updateById(int id, Bid bid) {
    if(bidRepository.existsById(id)) {
      bid.setId(id);
      bidRepository.save(bid);

      return bid;
    } else {
      throw new NoSuchElementException("No value present");
    }
  }

  @Override
  public void deleteById(int id) {
    bidRepository.deleteById(id);
  }
}
