package bj.prexed.succursaleservice.entities;


import bj.prexed.succursaleservice.enums.TypeEntrepot;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(indexes = {@Index(columnList = "lblEntrepot")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"lblEntrepot", "agence_id"})})
public class Entrepot {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "uuid2")
    private String id;

    @Column(length = 10)
    private String reference;

    @Column(nullable = false)
    private String lblEntrepot;

    @Column
    private String  telephone;

    @Enumerated
    private TypeEntrepot type = TypeEntrepot.Entrepot;

    @Basic
    private Boolean initialised; // cuivre = societe pétrolière

    @ManyToOne
    private Agence agence;
}
