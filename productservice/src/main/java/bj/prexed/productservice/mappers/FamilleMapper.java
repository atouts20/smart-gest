package bj.prexed.productservice.mappers;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.CategorieRequestDTO;
import bj.prexed.productservice.records.input.FamilleRequestDTO;
import bj.prexed.productservice.records.input.MarqueRequestDTO;
import bj.prexed.productservice.records.output.CategorieResponseDTO;
import bj.prexed.productservice.records.output.FamilleResponseDTO;
import bj.prexed.productservice.records.output.MarqueResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FamilleMapper {

    FamilleRequestDTO toDto(Famille famille);

    FamilleResponseDTO toDtoR(Famille famille);

    Famille toUpdate(Famille entitesend, @MappingTarget Famille ent);
    Famille toEntity(FamilleRequestDTO requestDTO);

}
