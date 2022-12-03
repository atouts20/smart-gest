package bj.prexed.succursaleservice.servicesImpl;

import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.exception.ResourceNotFoundException;
import bj.prexed.succursaleservice.mappers.DivisionMapper;
import bj.prexed.succursaleservice.records.request.DivisionRequestDTO;
import bj.prexed.succursaleservice.records.response.DivisionResponseDTO;
import bj.prexed.succursaleservice.repositories.DivisionRepository;
import bj.prexed.succursaleservice.repositories.SuccursaleRepository;
import bj.prexed.succursaleservice.services.DivisionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class DivisionImpl  implements DivisionService {
    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;
    private final SuccursaleRepository succursaleRepository;

    public DivisionImpl ( DivisionRepository divisionRepository , DivisionMapper divisionMapper , SuccursaleRepository succursaleRepository ) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
        this.succursaleRepository = succursaleRepository;
    }



    @Override
    public DivisionResponseDTO add(DivisionRequestDTO resquest) {
        Succursale s = succursaleRepository.findById (resquest.getIdSuccursale ()).orElseThrow ( ()->new RuntimeException (String.format("Cannot Find Expense by ID %s", resquest.getIdSuccursale ())));
        Division d = divisionMapper.toEntity (resquest);
        d.setSuccursale ( s );
        return divisionMapper.toDtoR(divisionRepository.save(d));
    }



    @Override
    public Page<Division> all ( Succursale s, Pageable page ) {
        return divisionRepository.findBySuccursale (s, page );
    }

    @Override
    public DivisionResponseDTO one ( String id ) {
        Division e = divisionRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return divisionMapper.toDtoR ( e );
    }

    @Override
    public DivisionResponseDTO set ( String id , Division division ) {
        Division  e = divisionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Division", id));
        return divisionMapper.toDtoR(divisionRepository.save(divisionMapper.toUpdate(division,e)));
    }
}
