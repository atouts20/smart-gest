package bj.prexed.rhumaineservice.serviceImpl;
import bj.prexed.rhumaineservice.entities.Affectation;
import bj.prexed.rhumaineservice.entities.Person;
import bj.prexed.rhumaineservice.service.SemailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;


import bj.prexed.rhumaineservice.dto.get.PersonGetDTO;
import bj.prexed.rhumaineservice.dto.post.PersonPostDTO;
import bj.prexed.rhumaineservice.mapper.PersonMapper;
import bj.prexed.rhumaineservice.repository.PersonRepository;
import bj.prexed.rhumaineservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PersonImpl implements PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final SemailService semailService;

    public PersonImpl ( PersonRepository repository , PersonMapper mapper , PasswordEncoder passwordEncoder , SemailService semailService ) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.semailService = semailService;
    }

    @Override
    public List<PersonGetDTO> getAllperson() {
        return null;
    }

    @Override
    public Page<Person> all ( Pageable page ) {
        return repository.findAll (page);
    }

    @Override
    public PersonGetDTO add(PersonPostDTO resquest) {
        Person person = repository.save ( mapper.toEntity ( resquest ));
        semailService.sendHtml ( person.getEmail (),"TEST","http://localhost:9898/api/v1/personne/token" );
        return mapper.toGetEntity (person );
    }

    @Override
    public PersonGetDTO set ( Long id , Person person ) {
        Person personCher = repository.findById( id ).get();
        return mapper.toGetEntity ( personCher );
    }

    @Override
    public PersonGetDTO one ( Long id ) {
        Person e = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return mapper.toGetEntity ( e );

    }

    @Override
    public boolean verify(String verificationCode) {
        Person user = repository.findByVerificaToken (verificationCode);
        Calendar cal = Calendar.getInstance();
        if ((user == null || user.isEmailVerified ()) && (user.getResetDate ().getTime () - cal.getTime().getTime()) <= 0 ) {
            return false;
        } else {
            user.setVerificaToken (null);
            user.setEmailVerified (true);
            repository.save(user);
        return false;
        }
    }

}
