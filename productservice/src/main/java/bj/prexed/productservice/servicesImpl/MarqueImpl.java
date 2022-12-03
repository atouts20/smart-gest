package bj.prexed.productservice.servicesImpl;

import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.exception.ResourceNotFoundException;
import bj.prexed.productservice.mappers.MarqueMapper;
import bj.prexed.productservice.records.input.MarqueRequestDTO;
import bj.prexed.productservice.records.output.MarqueResponseDTO;
import bj.prexed.productservice.repositories.MarqueRepository;
import bj.prexed.productservice.services.MarqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class MarqueImpl implements MarqueService {

    private final MarqueRepository repository;
    private final MarqueMapper mapper;

    public MarqueImpl(MarqueRepository repository, MarqueMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public MarqueResponseDTO add(MarqueRequestDTO resquest) {
        return mapper.toDtoR(repository.save(mapper.toEntity (resquest)));
    }



    @Override
    public Page<Marque> all(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Marque> selectionParDivison(String lbl, Pageable page) {
        return repository.selectionParDivison(lbl, page);
    }

    @Override
    public Page<MarqueResponseDTO> selectionParDiv(String lbl, Pageable page) {
        return  null;
    }


    @Override
    public MarqueResponseDTO one(String id) {
        Marque m = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return mapper.toDtoR ( m );
    }

    @Override
    public MarqueResponseDTO set(String id, Marque marque) {
        Marque  m = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Marque", id));
        return mapper.toDtoR(repository.save(mapper.toUpdate(marque,m)));
    }
}
