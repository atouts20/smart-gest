package bj.prexed.productservice.mappers;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.CategorieRequestDTO;
import bj.prexed.productservice.records.output.CategorieResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategorieMapper {


    CategorieRequestDTO toDto(Categorie categorie);


    CategorieResponseDTO toDtoR(Categorie categorie);

    Categorie toUpdate(Categorie entitesend, @MappingTarget Categorie ent);
    Categorie toEntity(CategorieRequestDTO categorieRequestDTO);

}
