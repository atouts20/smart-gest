package bj.prexed.productservice.records.input;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.enums.MethodeStock;
import bj.prexed.productservice.enums.TypeFamille;
import bj.prexed.productservice.enums.UniteVte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@AllArgsConstructor @NoArgsConstructor
public class FamilleRequestDTO {



    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private String lblFamille;

    @Column(columnDefinition = "text")
    private String description;


    private String typeFamille;

    @Column(nullable = false)
    private String methodeStock;

    @Column(nullable = false)
    private String uniteVte;

    private boolean neutre;

    private double garantie;

    private double coeffmarge;


    private Categorie categorie;


}
