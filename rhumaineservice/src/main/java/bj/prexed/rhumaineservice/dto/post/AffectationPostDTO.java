package bj.prexed.rhumaineservice.dto.post;

import bj.prexed.rhumaineservice.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffectationPostDTO {
    private Long idPerson;
    private Date lastdate;
    private String description;
    private Long division;
}
