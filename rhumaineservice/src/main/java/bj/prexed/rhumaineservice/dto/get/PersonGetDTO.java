package bj.prexed.rhumaineservice.dto.get;


import bj.prexed.rhumaineservice.entities.Affectation;
import bj.prexed.rhumaineservice.enums.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor @NoArgsConstructor
public class PersonGetDTO {


    private String id;


    private Genre sexe = Genre.M;


    private Date lastLogin;

    private String civilite;


    private String nom, prenoms;


    private String phone;


    private String email;


    private String password;

    private boolean enabled = true;

    private String verificaToken;


    private String grade;


    private Set<Affectation> affectations = new HashSet<>();

}
