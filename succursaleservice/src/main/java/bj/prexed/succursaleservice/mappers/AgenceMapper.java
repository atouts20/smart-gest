package bj.prexed.succursaleservice.mappers;

import bj.prexed.succursaleservice.Utils.OptionalUtils;
import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.records.request.AgenceRequestDTO;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.Optional;

@Mapper(componentModel = "spring" )
public interface AgenceMapper {
   // @Mapping(source = "division.id", target = "division")
    //AgenceRequestDTO toDto(Agence agence);

    AgenceResponseDTO toDtoR(Agence agence);
    //Agence toUpdate(Agence agenceUpdate);
    Agence toUpdate( Agence entitesend, @MappingTarget Agence ent);
    //@Mapping(source = "division.id", target = "division")
    Agence toEntity(AgenceRequestDTO agenceRequestDTO);

}
