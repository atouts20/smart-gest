package bj.prexed.productservice.entities;

import bj.prexed.productservice.enums.Conditionnement;
import bj.prexed.productservice.enums.GroupeTaxable;
import bj.prexed.productservice.enums.TypePrix;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(indexes = {@Index(columnList = "lblproduit")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"lblproduit", "famille_id"})})
public class Article {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")

    @Id
    private String id;

    @Column(length = 15)
    private String reference;

    @Column
    private String barcode;

    @Enumerated
    private GroupeTaxable groupeTaxable = GroupeTaxable.B; //A = Exonéré, B = Taxable, C = Exportation de produits
    // D = TV Régime d'Exeption, E = Régime Fiscal TPS,  F = Réservé

    @Column(nullable = false)
    private String lblproduit;

    @Enumerated
    private TypePrix typePrix = TypePrix.TTC;

    @Enumerated
    private Conditionnement cond = Conditionnement.B6; // Conditionnement



    @Basic
    private Boolean
              isMiseEnSommeil
            , isNonSoumisEscompte
            , isNePasGererStock
            , isFacturerPoidNet
            , isProduitEmballe
            , isGestionEmballageAchat
            , isProduitCautionne;




    @ManyToOne
    private Famille famille;

}
