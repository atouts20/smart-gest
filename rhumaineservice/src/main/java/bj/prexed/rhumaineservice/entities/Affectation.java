package bj.prexed.rhumaineservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;
    @Temporal(TemporalType.DATE)
    private Date lastdate;
    @Column(columnDefinition = "text")
    private String description;
    private String divisionid;
    @Transient
    private Division division;
}
