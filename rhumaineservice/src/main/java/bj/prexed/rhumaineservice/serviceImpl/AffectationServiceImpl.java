package bj.prexed.rhumaineservice.serviceImpl;

import bj.prexed.rhumaineservice.dto.get.AffectationGetDTO;
import bj.prexed.rhumaineservice.dto.post.AffectationPostDTO;
import bj.prexed.rhumaineservice.entities.Affectation;
import bj.prexed.rhumaineservice.entities.Person;
import bj.prexed.rhumaineservice.mapper.AffectationMapper;
import bj.prexed.rhumaineservice.repository.AffectationRepository;
import bj.prexed.rhumaineservice.repository.PersonRepository;
import bj.prexed.rhumaineservice.service.AffectationService;
import bj.prexed.rhumaineservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class AffectationServiceImpl implements AffectationService {
    private final AffectationRepository affectationRepository;
    private final AffectationMapper affectationMapper;
    private final PersonService personService;
    private final PersonRepository personRepository;

    public AffectationServiceImpl ( AffectationRepository affectationRepository , AffectationMapper affectationMapper , PersonService personService , PersonRepository personRepository ) {
        this.affectationRepository = affectationRepository;
        this.affectationMapper = affectationMapper;
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @Override
    public Page<Affectation> all (  Pageable page ) {
        return affectationRepository.findAll ( page );
    }

    @Override
    public AffectationGetDTO one ( Long id ) {
        return affectationMapper.toDto (affectationRepository.findById( id ).get());
    }

    @Override
    public AffectationGetDTO set ( Long id, Affectation affectation) {
        Affectation affChe = affectationRepository.findById( id ).get();
        return affectationMapper.toDto ( affChe );
    }

    @Override
    public AffectationGetDTO add ( AffectationPostDTO postDTO ) {
        Person person = personRepository.findById (postDTO.getIdPerson()).orElseThrow ( ()->new RuntimeException (String.format("Cannot Find Expense by ID %s", postDTO.getIdPerson ())));;
        Affectation aff = null;
        System.out.println (person.toString ());
        if (person != null) {
             aff = affectationMapper.toEntity(postDTO);
            aff.setPerson ( person );
        }
        System.out.println (aff.toString ());
        return affectationMapper.toDto(affectationRepository.save(aff));

    }
}
