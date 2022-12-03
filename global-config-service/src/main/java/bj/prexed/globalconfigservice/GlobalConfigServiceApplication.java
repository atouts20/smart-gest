package bj.prexed.globalconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableConfigServer
public class GlobalConfigServiceApplication {

    public static void main ( String[] args ) {
        SpringApplication.run ( GlobalConfigServiceApplication.class , args );
    }

}
