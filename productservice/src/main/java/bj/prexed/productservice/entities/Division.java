package bj.prexed.productservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;



@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Division {
    private String id;
    private String lblDivision;
    @Column(columnDefinition = "text")
    private String description;

}
