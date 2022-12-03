package bj.prexed.rhumaineservice.controllers;

import bj.prexed.rhumaineservice.dto.get.AffectationGetDTO;
import bj.prexed.rhumaineservice.entities.Affectation;
import bj.prexed.rhumaineservice.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import bj.prexed.rhumaineservice.dto.get.PersonGetDTO;
import bj.prexed.rhumaineservice.dto.post.PersonPostDTO;
import bj.prexed.rhumaineservice.mapper.PersonMapper;
import bj.prexed.rhumaineservice.repository.PersonRepository;
import bj.prexed.rhumaineservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/personne")
public class PersonController {
    private  PersonRepository repository;
    private  PersonMapper mapper;
    private  PersonService service;
    private  JwtEncoder jwtEncoder;
    private  JwtDecoder jwtDecoder;
    private  AuthenticationManager authenticationManager;
    private  UserDetailsService userDetailsService;

    public PersonController ( PersonRepository repository , PersonMapper mapper , PersonService service , JwtEncoder jwtEncoder , JwtDecoder jwtDecoder , AuthenticationManager authenticationManager , UserDetailsService userDetailsService ) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }


  /*  @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody String userName) {
        return new ResponseEntity<String>(null, HttpStatus.OK);
    }*/
  @GetMapping("/message")
  public ResponseEntity<String> message() {
      try {

          return new ResponseEntity<>( "Bonjour!!!!! Eddy", HttpStatus.CREATED);
      } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }

  }

    @PostMapping("/register-bis")
    public ResponseEntity<Person> posttes( @RequestBody @Valid Person request) {
        try {

            return new ResponseEntity<>( repository.save ( request ), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/register")
    public ResponseEntity<PersonGetDTO> post(@RequestBody @Valid PersonPostDTO request) {
        System.out.println (request.toString ());
        System.out.println (request.toString ());
        try {
            System.out.println (request.toString ());
            PersonGetDTO personSave= service.add(request);
            return new ResponseEntity<>( personSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PersonGetDTO>> getAll(@RequestParam(required = false) String division) {
        try {
            List<PersonGetDTO> personGetDTOList = new ArrayList<PersonGetDTO>();
            if (division== null)
                service.getAllperson().forEach(personGetDTOList::add);
            else
                repository.findByDivision(division);
            if (personGetDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(personGetDTOList,HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<Page<Person>> getAll( @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(repository.findAll ( pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<PersonGetDTO> getAgenceById( @PathVariable Long id) {
        try {

            return new ResponseEntity<>(service.one ( id ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonGetDTO> updateAgence(@PathVariable Long id, @RequestBody @Valid Person person){
        try {
            return new ResponseEntity<>(service.set ( id,person ),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> jwtToken(
            String grantType,
            String username,
            String password,
            boolean withRefreshToken,
            String refreshToken){
        String subject=null;
        String scope=null;
        if(grantType.equals("password")){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            subject=authentication.getName();
            scope=authentication.getAuthorities()
                    .stream().map(aut -> aut.getAuthority())
                    .collect(Collectors.joining(" "));

        } else if(grantType.equals("refreshToken")){
            if(refreshToken==null) {
                return new ResponseEntity<>(Map.of("errorMessage","Refresh  Token is required"), HttpStatus.UNAUTHORIZED);
            }
            Jwt decodeJWT = null;
            try {
                decodeJWT = jwtDecoder.decode(refreshToken);
            } catch (JwtException e) {
                return new ResponseEntity<>(Map.of("errorMessage",e.getMessage()), HttpStatus.UNAUTHORIZED);
            }
            subject=decodeJWT.getSubject();
            UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            scope=authorities.stream().map(auth->auth.getAuthority()).collect(Collectors.joining(" "));
        }
        Map<String, String> idToken=new HashMap<>();
        Instant instant=Instant.now();
        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(withRefreshToken?1:5, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("scope",scope)
                .build();
        String jwtAccessToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        idToken.put("accessToken",jwtAccessToken);
        if(withRefreshToken){
            JwtClaimsSet jwtClaimsSetRefresh=JwtClaimsSet.builder()
                    .subject(subject)
                    .issuedAt(instant)
                    .expiresAt(instant.plus(5, ChronoUnit.MINUTES))
                    .issuer("security-service")
                    .build();
            String jwtRefreshToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
            idToken.put("refreshToken",jwtRefreshToken);
        }
        return new ResponseEntity<>(idToken,HttpStatus.OK);
    }

}
