package bj.prexed.productservice.services;

import bj.prexed.productservice.entities.Article;
import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.records.input.ArticleRequestDTO;
import bj.prexed.productservice.records.input.FamilleRequestDTO;
import bj.prexed.productservice.records.output.ArticleResponseDTO;
import bj.prexed.productservice.records.output.FamilleResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ArticleResponseDTO add(ArticleRequestDTO resquest);

    //DivisionResponseDTO getById(String id);

    Page<Article> all(String division, Pageable page);

    Page<Article> selectionParDivison(String lbl, Pageable page);

    ArticleResponseDTO one( String id);

    ArticleResponseDTO set(String id, Article article);
}
