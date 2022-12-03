package bj.prexed.succursaleservice.mappers;

import bj.prexed.succursaleservice.Utils.OptionalUtils;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.Entrepot;
import bj.prexed.succursaleservice.records.request.EntrepotRequestDTO;
import bj.prexed.succursaleservice.records.response.EntrepotResponseDTO;
import bj.prexed.succursaleservice.records.response.EntrepotResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring"  )
public interface EntrepotMapper {
    //@Mapping(source = "agence.id", target = "agence")
    EntrepotRequestDTO toDto(Entrepot entrepot);
    EntrepotResponseDTO toDtoR( Entrepot entrepot);
    //Entrepot toUpdate(Entrepot entrepot);
    Entrepot toUpdate( Entrepot entitesend, @MappingTarget Entrepot ent);
    //@Mapping(source = "agence.id", target = "agence")
    Entrepot toEntity(EntrepotRequestDTO entrepotRequestDTO);

    //Page<Entrepot> toEntityPage(Page<EntrepotResponseDTO> dtoPage);
    //Page<EntrepotResponseDTO> toDtoPage(Page<Entrepot> entityPage);


//    Optional<Entrepot> entrepotRequestDTOtoENtrepot(EntrepotResponseDTO entrepotResponsetDTO);
//
//    Optional<EntrepotResponseDTO> entrepotToEntrepotResponseDTO(Entrepot entrepot);
}
