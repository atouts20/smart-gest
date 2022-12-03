package bj.prexed.succursaleservice.opendoc;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = { @Server(url = "https://localhost:9789")}, info = @Info(title = "Succursale Service APIs", description = "Cela répertorie tous les appels d’API de service de service. Les appels sont sécurisés OAuth2, "
        + "veuillez donc utiliser votre nom d'utilisateur client et votre mot de passe pour les tester.",
        version = "v1.0"))
@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(clientCredentials  = @OAuthFlow(tokenUrl = "${openapi.oAuthFlow.tokenUrl}", scopes = {
                @OAuthScope(name = "openid", description = "openid scope")
        })))
public class OpenAPI3Configuration {

}
