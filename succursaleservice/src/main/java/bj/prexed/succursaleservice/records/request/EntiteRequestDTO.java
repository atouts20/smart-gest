package bj.prexed.succursaleservice.records.request;

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
public class  EntiteRequestDTO{
        private String sigle;
        private String raisociale;
        private String email;
        private boolean enabled;
        private String verificaToken;
        private boolean deleted;
        private String urllogo;
        private String slogan;
        private String domaineweb;
        //
}
