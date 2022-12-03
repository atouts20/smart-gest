package bj.prexed.succursaleservice.servicesImpl;

import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.exception.ResourceNotFoundException;
import bj.prexed.succursaleservice.mappers.SuccursaleMapper;
import bj.prexed.succursaleservice.records.request.SuccursaleRequestDTO;
import bj.prexed.succursaleservice.records.response.SuccursaleResponseDTO;
import bj.prexed.succursaleservice.repositories.EntiteRepository;
import bj.prexed.succursaleservice.repositories.SuccursaleRepository;
import bj.prexed.succursaleservice.services.SuccursaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class SuccursaleServiceImpl  implements SuccursaleService {
    private  final SuccursaleMapper succursaleMapper;
    private final SuccursaleRepository succursaleRepository;
    private final EntiteRepository entiteRepository;

    public SuccursaleServiceImpl ( SuccursaleMapper succursaleMapper , SuccursaleRepository succursaleRepository , EntiteRepository entiteRepository ) {
        this.succursaleMapper = succursaleMapper;
        this.succursaleRepository = succursaleRepository;
        this.entiteRepository = entiteRepository;
    }


    @Override
    public SuccursaleResponseDTO add(SuccursaleRequestDTO resquest) {
        Entite e = entiteRepository.findById (resquest.getIdEntite ()).orElseThrow ( ()->new RuntimeException (String.format("Cannot Find Expense by ID %s", resquest.getIdEntite ())));
        Succursale suc = succursaleMapper.toEntity (resquest); suc.setEntite ( e );
        Succursale succResp = succursaleRepository.save ( suc );    succResp.setEntite ( e );
         return succursaleMapper.toDtoR(succResp);
    }



    @Override
    public Page<Succursale> all ( Entite s , Pageable page ) {
        return succursaleRepository.findByEntite (s, page);
    }

    @Override
    public SuccursaleResponseDTO one ( String id ) {
        Succursale  e = succursaleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return succursaleMapper.toDtoR (e);
    }

    @Override
    public SuccursaleResponseDTO set ( String id , Succursale succursale ) {
        Succursale e = succursaleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ( "Succursale", id));

        return succursaleMapper.toDtoR(succursaleRepository.save(succursaleMapper.succursaleUpdate(succursale,e)));
    }


}
