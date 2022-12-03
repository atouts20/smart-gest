package bj.prexed.productservice.services;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.CategorieRequestDTO;
import bj.prexed.productservice.records.input.FamilleRequestDTO;
import bj.prexed.productservice.records.input.MarqueRequestDTO;
import bj.prexed.productservice.records.output.CategorieResponseDTO;
import bj.prexed.productservice.records.output.FamilleResponseDTO;
import bj.prexed.productservice.records.output.MarqueResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategorieService {

    CategorieResponseDTO add(CategorieRequestDTO resquest);

    //DivisionResponseDTO getById(String id);

    Page<Categorie> all(String division, Pageable page);

    Page<Categorie> selectionParDivison(String lbl, Pageable page);

    CategorieResponseDTO one( String id);

    CategorieResponseDTO set(String id, Categorie categorie);
}
