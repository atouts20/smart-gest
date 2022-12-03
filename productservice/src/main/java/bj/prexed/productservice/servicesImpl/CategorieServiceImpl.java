package bj.prexed.productservice.servicesImpl;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.exception.ResourceNotFoundException;
import bj.prexed.productservice.mappers.CategorieMapper;
import bj.prexed.productservice.records.input.CategorieRequestDTO;
import bj.prexed.productservice.records.output.CategorieResponseDTO;
import bj.prexed.productservice.repositories.CategorieRepository;
import bj.prexed.productservice.services.CategorieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository repository;
    private final CategorieMapper mapper;

    public CategorieServiceImpl(CategorieRepository repository, CategorieMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public CategorieResponseDTO add(CategorieRequestDTO resquest) {
        return mapper.toDtoR(repository.save(mapper.toEntity (resquest)));
    }

    @Override
    public Page<Categorie> all(String division, Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Categorie> selectionParDivison(String lbl, Pageable page) {
        return repository.selectionCategorieParDivision(lbl, page);
    }

    @Override
    public CategorieResponseDTO one(String id) {
        Categorie c = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return mapper.toDtoR ( c );
    }



    @Override
    public CategorieResponseDTO set(String id, Categorie categorie) {
        Categorie  c = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categorie", id));
        return mapper.toDtoR(repository.save(mapper.toUpdate(categorie,c)));
    }
}
