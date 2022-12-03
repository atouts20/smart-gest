package bj.prexed.productservice.services;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.CategorieRequestDTO;
import bj.prexed.productservice.records.input.FamilleRequestDTO;
import bj.prexed.productservice.records.output.CategorieResponseDTO;
import bj.prexed.productservice.records.output.FamilleResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FamilleService {

    FamilleResponseDTO add(FamilleRequestDTO resquest);

    //DivisionResponseDTO getById(String id);

    Page<Famille> all(String division, Pageable page);

    Page<Famille> selectionParDivison(String lbl, Pageable page);

    FamilleResponseDTO one( String id);

    FamilleResponseDTO set(String id, Famille famille);

}
