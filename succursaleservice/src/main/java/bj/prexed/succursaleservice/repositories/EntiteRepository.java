package bj.prexed.succursaleservice.repositories;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import bj.prexed.succursaleservice.records.response.EntiteResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntiteRepository extends JpaRepository<Entite, Long> {
    Optional<Entite> findById(Long id);
    //EntiteResponseDTO findById( String id);
    Page<Entite> findAll( Pageable page);

}
