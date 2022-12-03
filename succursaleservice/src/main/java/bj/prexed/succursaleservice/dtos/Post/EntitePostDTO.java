package bj.prexed.succursaleservice.dtos.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor @NoArgsConstructor
public class EntitePostDTO {


    private Long id;

    @NotNull
    private String sigle;

    @NotNull
    private String raisociale;


    private String email;

    private boolean enabled = false;

    private String verificaToken;

    private boolean deleted;


    private String urllogo;

    private String slogan;

    private String domaineweb;



}
