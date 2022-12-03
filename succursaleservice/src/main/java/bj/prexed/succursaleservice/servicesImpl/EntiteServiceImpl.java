package bj.prexed.succursaleservice.servicesImpl;

import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.mappers.EntiteMapper;
import bj.prexed.succursaleservice.records.request.EntiteRequestDTO;
import bj.prexed.succursaleservice.records.response.EntiteResponseDTO;
import bj.prexed.succursaleservice.repositories.EntiteRepository;
import bj.prexed.succursaleservice.services.EntiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@Slf4j
public class EntiteServiceImpl  implements EntiteService {
    private final EntiteRepository entiteRepository;
    private final EntiteMapper entiteMapper;

    public EntiteServiceImpl(EntiteRepository entiteRepository, EntiteMapper entiteMapper) {
        this.entiteRepository = entiteRepository;
        this.entiteMapper = entiteMapper;
    }



    @Override
    public EntiteResponseDTO add( EntiteRequestDTO resquest) {
        return entiteMapper.entiteToEntiteResponseDTO (entiteRepository.save(entiteMapper.toEntite (resquest)));
    }



    @Override
    public Page<Entite> all ( Pageable page ) {
        return entiteRepository.findAll ( page );
    }

    @Override
    public EntiteResponseDTO one ( Long id ) {
       Entite e = entiteRepository.findById (id).orElseThrow ( ()->new RuntimeException (String.format("Cannot Find Expense by ID %s", id)));
        return entiteMapper.entiteToEntiteResponseDTO ( e );
    }

    @Override
    public EntiteResponseDTO set ( Long id , Entite entite ) {
        Entite e = entiteRepository.findById (id).orElseThrow ( ()->new RuntimeException (String.format("Cannot Find Expense by ID %s", id)));

        return entiteMapper.entiteToEntiteResponseDTO(entiteRepository.save(entiteMapper.entiteUpdate(entite,e)));
    }
}
