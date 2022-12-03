package bj.prexed.succursaleservice.mappers;

import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.records.request.DivisionRequestDTO;
import bj.prexed.succursaleservice.records.response.DivisionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DivisionMapper {
    //DivisionRequestDTO toDto(Division division);
    DivisionResponseDTO toDtoR(Division division);
    Division toUpdate( Division entitesend, @MappingTarget Division ent);
    Division toEntity(DivisionRequestDTO requestDTO);
}
