package bj.prexed.productservice.repositories;

import bj.prexed.productservice.entities.Article;
import bj.prexed.productservice.entities.Famille;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {


    //Page<Article> findByDivision(String division, Pageable pageable);



    //List<Article> findArticlesByLblproduitContains(@Param("mc")String des, String division);

    @Query("select a from Article a " +
            "join Famille f on f = a.famille  " +
            "join Categorie c on c = f.categorie  " +
            "join Marque m on m = c.marque " +
            "where m.divisionId = ?1   group by m.lblMarque order by f.lblFamille  asc"
    )
    Page<Article> selectionArticleParDivision(String division, Pageable pageable);

}
