package bj.prexed.rhumaineservice.service;

import bj.prexed.rhumaineservice.dto.get.AffectationGetDTO;
import bj.prexed.rhumaineservice.dto.get.PersonGetDTO;
import bj.prexed.rhumaineservice.dto.post.PersonPostDTO;
import bj.prexed.rhumaineservice.entities.Affectation;
import bj.prexed.rhumaineservice.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface PersonService {

     List<PersonGetDTO> getAllperson();
     Page<Person> all( Pageable page);

     PersonGetDTO add(PersonPostDTO resquest);
     PersonGetDTO set( Long id, Person person );
     PersonGetDTO one(Long id);

     boolean verify(String verificationCode);

}
