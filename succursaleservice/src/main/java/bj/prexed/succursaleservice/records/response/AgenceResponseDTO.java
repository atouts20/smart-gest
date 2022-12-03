package bj.prexed.succursaleservice.records.response;

import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.dto.response.DivisionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenceResponseDTO {
    private String id;
    private String refAgence;
    private String lblAgence;
    private String telephone;
    private String adresse;
    private Division division;
    private String ktierId;

}
