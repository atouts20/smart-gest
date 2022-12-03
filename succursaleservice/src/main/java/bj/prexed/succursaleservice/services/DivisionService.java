package bj.prexed.succursaleservice.services;

import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.records.request.DivisionRequestDTO;
import bj.prexed.succursaleservice.records.response.DivisionResponseDTO;
import bj.prexed.succursaleservice.records.response.EntiteResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DivisionService {
    //List<DivisionResponseDTO> getAll();
    DivisionResponseDTO add(DivisionRequestDTO resquest);
    //DivisionResponseDTO getById(String id);

    Page<Division> all( Succursale s, Pageable page);
    DivisionResponseDTO one( String id);
    DivisionResponseDTO set(String id, Division division);
}
