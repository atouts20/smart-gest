package bj.prexed.succursaleservice.entities;

import bj.prexed.succursaleservice.enums.TypeAgence;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(indexes = {@Index(columnList = "lblAgence")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"lblAgence", "division_id"})})
public class Agence {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "uuid2")
    private String id;

    @Column(length = 10)
    private String refAgence;
    @Column(nullable = false)
    private String lblAgence;
    @Column
    private String telephone, adresse; // type = agence mobile, shop, boutique, direction
    @ManyToOne
    private Division division;

    @NonNull
    private String ktierId;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "lat", column = @Column(name = "latitude")),
            @AttributeOverride(name = "lng", column = @Column(name = "longitude")),
    })
    private Position position;

    @Enumerated
    private TypeAgence type = TypeAgence.Boutique;

    @OneToMany(mappedBy = "agence")
    private Set<Entrepot> entrepots = new HashSet<>();




}
