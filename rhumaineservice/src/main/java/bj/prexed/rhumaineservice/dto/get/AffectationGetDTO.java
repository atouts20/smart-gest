package bj.prexed.rhumaineservice.dto.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffectationGetDTO {
    private Long id;
    private Long idPerson;
    private Date lastdate;
    private String description;
    private Long division;
}
