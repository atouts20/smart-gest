package bj.prexed.productservice.web.graphQL;


import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.repositories.MarqueRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MarqueGraphQLController {

    private final MarqueRepository repository;
    //private final MarqueMapper mapper;

    public MarqueGraphQLController(MarqueRepository repository) {
        this.repository = repository;

    }


//    public ResponseEntity<Page<Marque>> getAll(@PageableDefault Pageable pageable) {
//        return ResponseEntity.ok(service.all(current().getSuccursale(), pageable));
//    }

    public List<Marque> allMarque(){

        return repository.findAll();


    }
}
