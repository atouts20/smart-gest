package bj.prexed.succursaleservice.dtos.Get;

import bj.prexed.succursaleservice.entities.Succursale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor @NoArgsConstructor
public class EntiteGetDTO {


    private Long id;


    private String sigle;


    private String raisociale;


    private String email;

    private boolean enabled = false;

    private String verificaToken;

    private boolean deleted;


    private String urllogo;

    private String slogan;

    private String domaineweb;



}
