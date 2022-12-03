/*
package bj.prexed.succursaleservice.web.graphsql;

import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.repositories.EntiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class EntiteControllerGraphQl {


    @Autowired
    private EntiteRepository repository;

    @QueryMapping()
    public ResponseEntity<Page<Entite>> entitesPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable));
    }



}
*/
