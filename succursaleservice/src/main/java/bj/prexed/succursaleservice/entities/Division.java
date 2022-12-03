package bj.prexed.succursaleservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Division {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private String lblDivision;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    private Succursale succursale;

    @OneToMany(mappedBy = "division")
    private Set<Agence> agences = new HashSet<>();
}
