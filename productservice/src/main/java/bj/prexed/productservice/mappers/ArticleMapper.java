package bj.prexed.productservice.mappers;

import bj.prexed.productservice.entities.Article;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.ArticleRequestDTO;
import bj.prexed.productservice.records.output.ArticleResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    ArticleRequestDTO toDto(Article article);

    ArticleResponseDTO toDtoR(Article article);


    Article toUpdate(Article entitesend, @MappingTarget Article ent);

    Article toEntity(ArticleRequestDTO articleRequestDTO);

}
