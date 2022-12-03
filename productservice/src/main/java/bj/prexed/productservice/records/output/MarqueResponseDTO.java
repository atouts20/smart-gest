package bj.prexed.productservice.records.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MarqueResponseDTO {

    private String id;

    @NotNull
    private String lblMarque;

    @NotNull
    private String divisionId;

}
