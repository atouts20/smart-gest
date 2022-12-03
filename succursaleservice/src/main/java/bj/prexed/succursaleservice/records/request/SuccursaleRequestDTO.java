package bj.prexed.succursaleservice.records.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccursaleRequestDTO{
          private  String lblSuccursale
        ; private  String formeJuridique
        ; private  String ville
        ; private  String pays
        ; private  String type
        ; private  String portable
        ; private  String telephone
        ; private  String adresse
        ; private  String email
        ; private  Long idEntite;

}
