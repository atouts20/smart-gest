package bj.prexed.succursaleservice.records.request;

import bj.prexed.succursaleservice.entities.Succursale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DivisionRequestDTO {

    private String lblDivision;
    private String description;
    private String idSuccursale;
}
