package bj.prexed.succursaleservice.services;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.records.request.AgenceRequestDTO;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AgenceService {
    // List<AgenceResponseDTO> getAllagence();
     AgenceResponseDTO add(AgenceRequestDTO resquest);
     //AgenceResponseDTO getById(String id);
     //Methode for exist projet
     Page<Agence> all( Division s, Pageable page);
     AgenceResponseDTO one( String id);
     AgenceResponseDTO set(String id, Agence agence);


}
