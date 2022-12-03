package bj.prexed.productservice.repositories;

import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.entities.Marque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilleRepository extends JpaRepository<Famille, String> {

    //Page<Famille> findBySuccursale(String division, Pageable pageable);

    //Page<Famille> findFamilleByLibelleContains(@Param("mc")String des, String division);

    @Query("select f from Famille f " +
            "join Categorie c on c = f.categorie  " +
            "join Marque m on m = c.marque " +
            "where m.divisionId = ?1  order by f.lblFamille  asc"
    )
    Page<Famille> selectionFamilleParDivision(String a, Pageable pageable);
}
