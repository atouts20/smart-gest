package bj.prexed.productservice.records.input;

import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.enums.Conditionnement;
import bj.prexed.productservice.enums.GroupeTaxable;
import bj.prexed.productservice.enums.TypePrix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ArticleRequestDTO{



    @NotNull
    private String reference;


    private String barcode;


    private GroupeTaxable groupeTaxable = GroupeTaxable.B; //A = Exonéré, B = Taxable, C = Exportation de produits
    // D = TV Régime d'Exeption, E = Régime Fiscal TPS,  F = Réservé

    @NotNull
    private String lblproduit;


    private String typePrix;


    private String cond; // Conditionnement




    private Boolean
            isMiseEnSommeil
            , isNonSoumisEscompte
            , isNePasGererStock
            , isFacturerPoidNet
            , isProduitEmballe
            , isGestionEmballageAchat
            , isProduitCautionne;




    private Famille famille;

}
