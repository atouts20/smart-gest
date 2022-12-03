package bj.prexed.productservice.repositories;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Marque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {

   // Page<Categorie> findBySuccursale(String division, Pageable pageable);

//    @Query("select c from Categorie c " +
//            "join Marque m on m = c.marque " +
//            "where m.id = ?1 and c.lblCategorie = ?2  order by c.lblCategorie  asc"
//    )
//    Page<Categorie> findCategorieByLblCategorieContains(@Param("mc")String des, String division);

    @Query("select c from Categorie c " +
            "join Marque m on m = c.marque " +
            "where m.divisionId = ?1  order by c.lblCategorie  asc"
    )
    Page<Categorie> selectionCategorieParDivision(String a, Pageable pageable);

}
