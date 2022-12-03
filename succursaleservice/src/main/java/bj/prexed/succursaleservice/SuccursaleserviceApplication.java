package bj.prexed.succursaleservice;

import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.repositories.EntiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@Slf4j
@SpringBootApplication
public class SuccursaleserviceApplication {
	@Autowired
	private EntiteRepository entiteRepository;
	public static void main(String[] args) {
		SpringApplication.run(SuccursaleserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner start() {
		return args-> {
			log.info ( "#" );
			log.info ( "##" );
			log.info ( "###" );
			log.info ( "####" );
			log.info ( "#####" );
			log.info ( "######" );
			log.info ( "#######" );
			log.info ( "########" );
			log.info ( "#########" );
			log.info ( "########" );
			log.info ( "#######" );
			log.info ( "######" );
			log.info ( "#####" );
			log.info ( "####" );
			log.info ( "###" );
			log.info ( "##" );
			log.info ( "#" );
			entiteRepository.save ( new Entite (null,
					  "SSTET",
					  "GOGOOGO",
					  "test@test.com",
					  false,
					UUID.randomUUID ().toString () ,
					  false,
					  "http://localhost:8080/images/logo1.png",
					  "Mongo mongo",
					  "www.atouts1.com",null) );
			entiteRepository.save ( new Entite (null,
					"SSTET",
					"2GOGOOGO",
					"test2@test.com",
					false,
					UUID.randomUUID ().toString () ,
					false,
					"http://localhost:8080/images/logo2.png",
					"2Mongo mongo",
					"www.atouts1.com",null) );
			entiteRepository.save ( new Entite (null,
					"SSTET",
					"3GOGOOGO",
					"test3@test.com",
					false,
					UUID.randomUUID ().toString () ,
					false,
					"http://localhost:8080/images/logo3.png",
					"3Mongo mongo",
					"www.atouts3.com",null) );
			entiteRepository.save ( new Entite (null,
					"SSTET",
					"4GOGOOGO",
					"test4@test.com",
					false,
					UUID.randomUUID ().toString () ,
					false,
					"http://localhost:8080/images/logo4.png",
					"4Mongo mongo",
					"www.atouts4.com",null) );
		};

	}

}
