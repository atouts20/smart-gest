package bj.prexed.productservice.services;

import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.MarqueRequestDTO;
import bj.prexed.productservice.records.output.MarqueResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarqueService {


    MarqueResponseDTO add(MarqueRequestDTO resquest);


    //DivisionResponseDTO getById(String id);

    Page<Marque> all(Pageable page);

    Page<Marque> selectionParDivison(String lbl, Pageable page);

    Page<MarqueResponseDTO> selectionParDiv(String lbl, Pageable page);

    MarqueResponseDTO one( String id);
    MarqueResponseDTO set(String id, Marque marque);



}
