package bj.prexed.productservice.repositories;

import bj.prexed.productservice.entities.Marque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, String> {

    //Page<Marque> findBySuccursale(String division, Pageable pageable);

    //Page<Marque> findMarqueByLibelleContains(@Param("mc")String des, String division);

    @Query("select a from Marque a " +
            "where a.divisionId = ?1  order by a.lblMarque  asc"
    )
    Page<Marque> selectionParDivison(String division, Pageable pageable);


    Page<Marque> findMarqueByLblMarqueContaining(@Param("mc")String des, String division, Pageable pageable);

}
