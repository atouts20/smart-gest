package bj.prexed.succursaleservice.servicesImpl;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Entrepot;
import bj.prexed.succursaleservice.exception.ResourceNotFoundException;
import bj.prexed.succursaleservice.mappers.EntrepotMapper;
import bj.prexed.succursaleservice.records.request.EntrepotRequestDTO;
import bj.prexed.succursaleservice.records.response.EntrepotResponseDTO;
import bj.prexed.succursaleservice.records.response.EntrepotResponseDTO;
import bj.prexed.succursaleservice.repositories.EntrepotRepository;
import bj.prexed.succursaleservice.services.EntrepotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@Slf4j
public class EntrpotServiceImpl  implements EntrepotService {
    private final EntrepotRepository entrepotRepository;
    private final EntrepotMapper entrepotMapper;

    public EntrpotServiceImpl(EntrepotRepository entrepotRepository, EntrepotMapper entrepotMapper) {
        this.entrepotRepository = entrepotRepository;
        this.entrepotMapper = entrepotMapper;
    }

    @Override
    public EntrepotResponseDTO add(EntrepotRequestDTO resquest) {

        return entrepotMapper.toDtoR(entrepotRepository.save(entrepotMapper.toEntity (resquest)));
    }


    @Override
    public Page<Entrepot> all ( Agence s , Pageable page ) {
        return entrepotRepository.findByAgence (s, page);
    }

    @Override
    public EntrepotResponseDTO one ( String id ) {
        Entrepot  e = entrepotRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return entrepotMapper.toDtoR ( e );
    }

    @Override
    public EntrepotResponseDTO set ( String id , Entrepot entrepot ) {
        Entrepot  e = entrepotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Entrepot", id));
        return entrepotMapper.toDtoR(entrepotRepository.save(entrepotMapper.toUpdate (entrepot,e)));
    }
}
