package bj.prexed.productservice.entities;


import bj.prexed.productservice.enums.MethodeStock;
import bj.prexed.productservice.enums.TypeFamille;
import bj.prexed.productservice.enums.UniteVte;
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
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(indexes = {@Index(columnList = "lblFamille")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"lblFamille", "categorie_id"})})
public class Famille {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
    private String id;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private String lblFamille;

    @Column(columnDefinition = "text")
    private String description;

    @Enumerated
    private TypeFamille typeFamille = TypeFamille.AUTRES;

    @Column(nullable = false)
    private MethodeStock methodeStock = MethodeStock.CUMP;

    @Column(nullable = false)
    private UniteVte uniteVte = UniteVte.Litre;

    private boolean neutre;

    private double garantie;

    private double coeffmarge;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "famille")
    private Set<Article> articles = new HashSet<>();

}
