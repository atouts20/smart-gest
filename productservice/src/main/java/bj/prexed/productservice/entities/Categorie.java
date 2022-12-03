package bj.prexed.productservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(indexes = {@Index(columnList = "lblCategorie")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"lblCategorie", "marque_id"})})
public class Categorie {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String lblCategorie;

    @ManyToOne
    private Marque marque;

    @OneToMany(mappedBy = "categorie")
    private Set<Famille> familles = new HashSet<>();
}
