package bj.prexed.rhumaineservice.mapper;

import bj.prexed.rhumaineservice.dto.get.AffectationGetDTO;
import bj.prexed.rhumaineservice.dto.get.PersonGetDTO;
import bj.prexed.rhumaineservice.dto.post.AffectationPostDTO;
import bj.prexed.rhumaineservice.dto.post.PersonPostDTO;
import bj.prexed.rhumaineservice.entities.Affectation;
import bj.prexed.rhumaineservice.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AffectationMapper {
    Affectation toEntity( AffectationPostDTO postDTO );
    AffectationGetDTO toDto( Affectation affectation);

}
