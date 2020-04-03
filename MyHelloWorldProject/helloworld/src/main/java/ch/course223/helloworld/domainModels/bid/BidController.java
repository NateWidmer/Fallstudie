package ch.course223.helloworld.domainModels.bid;

import ch.course223.helloworld.domainModels.bid.dto.BidDTO;
import ch.course223.helloworld.domainModels.bid.dto.BidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

  private BidService bidService;

  private BidMapper bidMapper;

  @Autowired
  public BidController(BidService bidService, BidMapper bidMapper) {
    this.bidService = bidService;
    this.bidMapper = bidMapper;
  }

  @PostMapping({"/", ""})
  public ResponseEntity<BidDTO> create(@RequestBody BidDTO bidDTO) {
    return new ResponseEntity<>(bidMapper.toDTO(bidService.create(bidMapper.fromDTO(bidDTO))), HttpStatus.CREATED);
  }

  @GetMapping({"/", ""})
  public ResponseEntity<List<BidDTO>> getAll() {
    return new ResponseEntity<>(bidMapper.toDTOs(bidService.findAll()), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BidDTO> getById(@PathVariable int id) {
    return new ResponseEntity<>(bidMapper.toDTO(bidService.findById(id)), HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<BidDTO> updateById(@PathVariable int id, @RequestBody BidDTO bidDTO) {
    return new ResponseEntity<>(bidMapper.toDTO(bidService.updateById(id, bidMapper.fromDTO(bidDTO))), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable int id) {
    bidService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
