package bj.prexed.succursaleservice.servicesImpl;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.exception.ResourceNotFoundException;
import bj.prexed.succursaleservice.mappers.AgenceMapper;
import bj.prexed.succursaleservice.records.request.AgenceRequestDTO;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import bj.prexed.succursaleservice.repositories.AgenceRepository;
import bj.prexed.succursaleservice.services.AgenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class AgenceImpl implements AgenceService {
    private final AgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    public AgenceImpl(AgenceRepository agenceRepository, AgenceMapper agenceMapper) {
        this.agenceRepository = agenceRepository;
        this.agenceMapper = agenceMapper;
    }

    /*@Override
    public List<AgenceResponseDTO> getAllagence() {
        List<Agence> agenceList = agenceRepository.findAll();
        return agenceList.stream ()
                .map ( a->agenceMapper.toDtoR(a) )
                .collect( Collectors.toList());
    }*/

    @Override
    public AgenceResponseDTO add(AgenceRequestDTO resquest) {
        return agenceMapper.toDtoR(agenceRepository.save(agenceMapper.toEntity(resquest)));
    }

    /*@Override
    public AgenceResponseDTO getById(String id) {
        Agence agenceOptional = agenceRepository.findById(id).get();
        return agenceMapper.toDtoR(agenceOptional);
    }*/

    @Override
    public Page<Agence> all ( Division s , Pageable page ) {
        return agenceRepository.findByDivision (s, page);
    }

    public AgenceResponseDTO one ( String id ) {
        Agence  e = agenceRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return agenceMapper.toDtoR ( e );
    }

    @Override
    public AgenceResponseDTO set ( String id , Agence agence ) {
        Agence  e = agenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Agence", id));

        return  agenceMapper.toDtoR(agenceRepository.save(agenceMapper.toUpdate(agence,e)));
    }
}
