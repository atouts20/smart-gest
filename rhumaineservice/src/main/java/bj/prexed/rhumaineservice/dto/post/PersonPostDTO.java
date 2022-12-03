package bj.prexed.rhumaineservice.dto.post;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@AllArgsConstructor @NoArgsConstructor
public class PersonPostDTO {

    private String id;


    private String  sexe;


    private Date lastLogin;


    private String civilite;


    private String nom, prenoms;


    private String phone;


    private String email;


    private String password;

    private boolean enabled = true;

    private String verificaToken;


    private String grade;



}
