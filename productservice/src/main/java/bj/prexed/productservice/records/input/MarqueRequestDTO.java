package bj.prexed.productservice.records.input;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Marque;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MarqueRequestDTO {

    @NotNull
    private String lblMarque;

    @NotNull
    private String divisionId;

}
