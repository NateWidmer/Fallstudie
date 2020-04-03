package ch.course223.helloworld.domainModels.bid.dto;

import ch.course223.helloworld.domainModels.bid.Bid;
import ch.course223.helloworld.domainModels.role.Role;
import ch.course223.helloworld.domainModels.role.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BidMapper {

  Bid fromDTO(BidDTO dto);

  List<Bid> fromDTOs(List<BidDTO> dtos);

  Set<Bid> fromDTOs(Set<BidDTO> dtos);

  BidDTO toDTO(Bid dm);

  List<BidDTO> toDTOs(List<Bid> dms);

  Set<BidDTO> toDTOs(Set<Bid> dms);
}
