package bj.prexed.productservice.mappers;

import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.MarqueRequestDTO;
import bj.prexed.productservice.records.output.MarqueResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MarqueMapper {

    MarqueRequestDTO toDto(Marque marque);

    MarqueResponseDTO toDtoR(Marque marque);

    Marque toUpdate(Marque entitesend, @MappingTarget Marque ent);
    Marque toEntity(MarqueRequestDTO requestDTO);
}
