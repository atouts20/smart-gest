package bj.prexed.succursaleservice.repositories;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, String> {
    //Page<Agence> findByDivision(Division d, Pageable p);
    Page<Agence> findByDivision(Division s, Pageable page);
    Page<Agence> findByDivisionSuccursale(Succursale s, Pageable p);
    List<AgenceResponseDTO> findByDivision_lblDivisionContaining(Division division);
    Optional<Agence> findById( String id);

}
