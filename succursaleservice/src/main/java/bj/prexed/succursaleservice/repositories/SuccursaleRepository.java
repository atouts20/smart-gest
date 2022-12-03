package bj.prexed.succursaleservice.repositories;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.records.response.SuccursaleResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuccursaleRepository extends JpaRepository<Succursale, String> {

    Page<Succursale> findByEntite(Entite entite, Pageable p);

    Optional<Succursale> findById(String id);

}
