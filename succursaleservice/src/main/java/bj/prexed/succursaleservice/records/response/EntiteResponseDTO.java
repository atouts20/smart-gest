package bj.prexed.succursaleservice.records.response;

import bj.prexed.succursaleservice.entities.Succursale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EntiteResponseDTO {
          private String id;
          private String sigle
        ; private  String raisociale
        ; private  String email
        ; private  boolean enabled
        ; private  String verificaToken
        ; private  boolean deleted
        ; private  String urllogo
        ; private  String slogan
        ; private  String domaineweb
        ; private Set<Succursale> succursales;
}
