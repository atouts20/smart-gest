package bj.prexed.succursaleservice.mappers;

import bj.prexed.succursaleservice.Utils.OptionalUtils;
import bj.prexed.succursaleservice.entities.*;
import bj.prexed.succursaleservice.records.request.AgenceRequestDTO;
import bj.prexed.succursaleservice.records.request.DivisionRequestDTO;
import bj.prexed.succursaleservice.records.request.SuccursaleRequestDTO;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import bj.prexed.succursaleservice.records.response.SuccursaleResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface SuccursaleMapper{

    SuccursaleRequestDTO toDto(Succursale succursale);
    SuccursaleResponseDTO toDtoR(Succursale succursale);
    Succursale toEntity(SuccursaleRequestDTO succursaleRequestDTO);
    //Succursale succursaleUpdate( Succursale suc);
    Succursale succursaleUpdate( Succursale entitesend, @MappingTarget Succursale ent);
//    Page<Succursale> toEntityPage(Page<SuccursaleResponseDTO> dtoPage);
//    Page<SuccursaleResponseDTO> toDtoPage(Page<Succursale> entityPage);
//
//
//    Optional<Succursale> succursaleRequestDTOtoSuccursale(SuccursaleRequestDTO succursaleRequestDTO);
//
//    Optional<SuccursaleResponseDTO> succursaleToSuccursaleResponseDTO(Succursale succursale);




}
