package bj.prexed.succursaleservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Entite  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 5)
    private String sigle;

    @Column(unique = true, nullable = false)
    private String raisociale;

    @Email
    private String email;

    private boolean enabled = false;

    private String verificaToken= UUID.randomUUID ().toString ();

    private boolean deleted;

    @Basic
    private String urllogo, slogan,  domaineweb;

    @OneToMany(mappedBy = "entite")
    private Set<Succursale> succursales = new HashSet<>();


}
