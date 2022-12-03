package bj.prexed.rhumaineservice.entities;


import bj.prexed.rhumaineservice.enums.Civilite;
import bj.prexed.rhumaineservice.enums.Genre;
import bj.prexed.rhumaineservice.enums.GradeType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Genre sexe = Genre.M;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Enumerated
    private Civilite civilite = Civilite.M;
    @Column(nullable = false)
    private String nom, prenoms;
    @Column(unique = true, nullable = false)
    private String phone;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private boolean enabled = true;
    private String verificaToken;
    @Enumerated
    private GradeType grade = GradeType.PDG;
    private boolean superAdmin;
    private String resetToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date resetDate ;
    private boolean emailVerified = false;
}
