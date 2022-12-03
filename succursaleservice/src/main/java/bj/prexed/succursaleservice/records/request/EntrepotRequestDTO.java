package bj.prexed.succursaleservice.records.request;

import bj.prexed.succursaleservice.entities.Agence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrepotRequestDTO{
    private String reference;
    private  String lblEntrepot;
    private  String telephone;
    private  String type;
    private  boolean initialised;
    private  String idAgence;
}
