package bj.prexed.succursaleservice.services;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.records.request.SuccursaleRequestDTO;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import bj.prexed.succursaleservice.records.response.SuccursaleResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SuccursaleService {
    //List<SuccursaleResponseDTO> getAll();
    SuccursaleResponseDTO add(SuccursaleRequestDTO resquest);
   // SuccursaleResponseDTO getById(String id);

    Page<Succursale> all( Entite s, Pageable page);
    SuccursaleResponseDTO one( String id);
    SuccursaleResponseDTO set(String id, Succursale succursale);
}
