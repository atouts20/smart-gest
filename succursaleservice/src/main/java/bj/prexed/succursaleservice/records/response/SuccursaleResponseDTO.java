package bj.prexed.succursaleservice.records.response;

import bj.prexed.succursaleservice.entities.Entite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccursaleResponseDTO {
              private  String id
            ; private  String lblSuccursale
            ; private  String formeJuridique
            ; private  String ville
            ; private  String pays
            ; private  String type
            ; private  String portable
            ; private  String telephone
            ; private  String adresse
            ; private  String email
            ;// private  EntiteResponseDTO entite;

 }
