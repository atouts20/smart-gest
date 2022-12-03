package bj.prexed.succursaleservice.services;

import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.records.request.EntiteRequestDTO;
import bj.prexed.succursaleservice.records.response.EntiteResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EntiteService {
   // List<EntiteResponseDTO> getAll();
    EntiteResponseDTO add( EntiteRequestDTO resquest);
   // EntiteResponseDTO getById(Long id);

    Page<Entite> all( Pageable page);
    EntiteResponseDTO one( Long id);
    EntiteResponseDTO set(Long id, Entite entite);
}
