package bj.prexed.succursaleservice.repositories;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.Entrepot;
import bj.prexed.succursaleservice.records.response.EntrepotResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EntrepotRepository extends JpaRepository<Entrepot, String> {

    Iterable<Entrepot> findByAgence(Agence d);

    Page<Entrepot> findByAgence( Agence d, Pageable p);
    Optional<Entrepot> findById(String id);
}
