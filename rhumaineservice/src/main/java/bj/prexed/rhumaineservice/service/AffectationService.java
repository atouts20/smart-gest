package bj.prexed.rhumaineservice.service;

import bj.prexed.rhumaineservice.dto.get.AffectationGetDTO;
import bj.prexed.rhumaineservice.dto.post.AffectationPostDTO;
import bj.prexed.rhumaineservice.entities.Affectation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AffectationService {
    Page<Affectation> all(  Pageable page);
    AffectationGetDTO one( Long id);
    AffectationGetDTO set( Long id, Affectation affectation );
    AffectationGetDTO add( AffectationPostDTO postDTO );

}
