package bj.prexed.succursaleservice.mappers;

import bj.prexed.succursaleservice.Utils.OptionalUtils;
import bj.prexed.succursaleservice.dtos.Get.EntiteGetDTO;
import bj.prexed.succursaleservice.dtos.Post.EntitePostDTO;
import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.records.request.EntiteRequestDTO;
import bj.prexed.succursaleservice.records.request.EntrepotRequestDTO;
import bj.prexed.succursaleservice.records.response.EntiteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntiteMapper {

    EntiteResponseDTO entiteToEntiteResponseDTO(Entite entite);
    //Entite entiteUpdate(Entite entite);
    Entite entiteUpdate(Entite entitesend, @MappingTarget Entite ent);

    EntitePostDTO entiteToEntiteRequest(Entite entite);

    Entite entiteRequestDTOToEntite(EntitePostDTO entiteRequestDTO);
    Entite toEntite( EntiteRequestDTO entiteRe);


    EntiteGetDTO entiteToEntiteDto(Entite entite);


    List<EntiteGetDTO> entitesToEntiteResponseDTO(List<Entite> entites);

    //Page<EntiteResponseDTO> entitesToEntiteResponseDTOPage(Page<Entite> entites);





}
