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
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(indexes = {@Index(columnList = "lblMarque")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"lblMarque", "divisionId"})})
public class Marque {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
    private String id;

    @Column(nullable = false)
    private String lblMarque;

    @Column(nullable = false)
    private String divisionId;
    @Transient
    private Division division;

    @OneToMany(mappedBy = "marque")
    private Set<Categorie> categories = new HashSet<>();
}
