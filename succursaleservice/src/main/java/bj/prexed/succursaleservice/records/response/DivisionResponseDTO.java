package bj.prexed.succursaleservice.records.response;

import bj.prexed.succursaleservice.entities.Succursale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DivisionResponseDTO  {
    private String id;
        private String lblDivision;
        private String description;
        private SuccursaleResponseDTO succursale;

}
