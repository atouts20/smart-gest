package bj.prexed.rhumaineservice.repository;

import bj.prexed.rhumaineservice.dto.post.PersonPostDTO;
import bj.prexed.rhumaineservice.entities.Affectation;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {


    @Query("select a from Affectation a " +
            "join Person t on t = a.person " +
            "where a.division = ?1 order by t.nom asc")
    List<PersonPostDTO> findByDivision(String d);


    Optional<Affectation> findById( Long id);

    Page<Affectation> findByDivision ( Long division, Pageable pageable );
}
