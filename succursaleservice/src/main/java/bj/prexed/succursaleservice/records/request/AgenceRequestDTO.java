package bj.prexed.succursaleservice.records.request;

import bj.prexed.succursaleservice.entities.Division;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenceRequestDTO {
    private String refAgence;
    private String lblAgence;
    private String telephone;
    private String adresse;
    private Division division;
    private String ktierId;
}
