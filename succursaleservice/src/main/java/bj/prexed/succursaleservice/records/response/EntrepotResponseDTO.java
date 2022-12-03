package bj.prexed.succursaleservice.records.response;

import bj.prexed.succursaleservice.entities.Agence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrepotResponseDTO {

private  String id; private  String reference; private  String lblEntrepot; private  String telephone; private  String type; private  boolean initialised; private  Agence agence;
}
