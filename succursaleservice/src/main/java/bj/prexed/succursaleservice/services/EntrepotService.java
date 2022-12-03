package bj.prexed.succursaleservice.services;


import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Entrepot;
import bj.prexed.succursaleservice.records.request.EntrepotRequestDTO;
import bj.prexed.succursaleservice.records.response.EntrepotResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EntrepotService {
  //  List<EntrepotResponseDTO> getAllDivision();
    EntrepotResponseDTO add(EntrepotRequestDTO resquest);
  //  EntrepotResponseDTO getById(String id);

    Page<Entrepot> all( Agence s, Pageable page);
    EntrepotResponseDTO one( String id);
    EntrepotResponseDTO set( String id, Entrepot entrepot);
}
