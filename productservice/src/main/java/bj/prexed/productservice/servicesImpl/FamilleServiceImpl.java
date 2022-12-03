package bj.prexed.productservice.servicesImpl;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.exception.ResourceNotFoundException;
import bj.prexed.productservice.mappers.FamilleMapper;
import bj.prexed.productservice.records.input.FamilleRequestDTO;
import bj.prexed.productservice.records.output.FamilleResponseDTO;
import bj.prexed.productservice.repositories.FamilleRepository;
import bj.prexed.productservice.services.FamilleService;
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
public class FamilleServiceImpl implements FamilleService {

    private final FamilleRepository repository;
    private final FamilleMapper mapper;

    public FamilleServiceImpl(FamilleRepository repository, FamilleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public FamilleResponseDTO add(FamilleRequestDTO resquest) {
        return mapper.toDtoR(repository.save(mapper.toEntity (resquest)));
    }

    @Override
    public Page<Famille> all(String division, Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Famille> selectionParDivison(String lbl, Pageable page) {
        return repository.selectionFamilleParDivision(lbl, page);
    }

    @Override
    public FamilleResponseDTO one(String id) {
        Famille c = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return mapper.toDtoR ( c );
    }

    @Override
    public FamilleResponseDTO set(String id, Famille famille) {
        Famille  c = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Famille", id));
        return mapper.toDtoR(repository.save(mapper.toUpdate(famille,c)));
    }
}
