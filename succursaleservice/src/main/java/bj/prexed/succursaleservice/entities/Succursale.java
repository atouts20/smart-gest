package bj.prexed.succursaleservice.entities;


import bj.prexed.succursaleservice.enums.FormeJuridique;
import bj.prexed.succursaleservice.enums.TypeStructure;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Succursale {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private String lblSuccursale;

    @Enumerated(EnumType.STRING)
    private FormeJuridique formeJuridique = FormeJuridique.ETS;

    @Column(nullable = false)
    private String ville, pays;

    @Enumerated(EnumType.STRING)
    private TypeStructure type = TypeStructure.Agroalimentaire;

    @Basic
    private String portable, telephone, adresse;

    @Email
    private String email;

    @ManyToOne
    private Entite entite;

}
