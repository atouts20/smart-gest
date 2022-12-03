package bj.prexed.rhumaineservice.controllers;

import bj.prexed.rhumaineservice.dto.get.AffectationGetDTO;
import bj.prexed.rhumaineservice.dto.post.AffectationPostDTO;
import bj.prexed.rhumaineservice.entities.Affectation;
import bj.prexed.rhumaineservice.repository.AffectationRepository;
import bj.prexed.rhumaineservice.service.AffectationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/affectation")
public class AffectationController {
    private final AffectationService affectationService;
    private final AffectationRepository affectationRepository;


    public AffectationController ( AffectationService affectationService , AffectationRepository affectationRepository ) {
        this.affectationService = affectationService;
        this.affectationRepository = affectationRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<AffectationGetDTO> post( @RequestBody @Valid AffectationPostDTO request) {
        try {
            AffectationGetDTO affSave = affectationService.add(request);
            return new ResponseEntity<>( affSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/all")
    public ResponseEntity<Page<Affectation>> getAll( @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(affectationRepository.findAll ( pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Personne Details",  description = "Récupère les détails d’un service par id",
            security = @SecurityRequirement(name = "security_auth"))
    @ApiResponses({
            @ApiResponse(responseCode="200", description ="Success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{id}")
    public  ResponseEntity<AffectationGetDTO> getAgenceById(@PathVariable Long id) {
        try {

            return new ResponseEntity<>(affectationService.one ( id ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AffectationGetDTO> updateAgence(@PathVariable Long id, @RequestBody @Valid Affectation affectation){
        try {
            return new ResponseEntity<>(affectationService.set ( id,affectation ),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
