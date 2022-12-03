package bj.prexed.rhumaineservice.mapper;

import bj.prexed.rhumaineservice.dto.get.PersonGetDTO;
import bj.prexed.rhumaineservice.dto.post.PersonPostDTO;
import bj.prexed.rhumaineservice.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonPostDTO toDto(Person person);

    Person toEntity(PersonPostDTO personPostDTO);
    PersonGetDTO toGetEntity(Person person);
}
