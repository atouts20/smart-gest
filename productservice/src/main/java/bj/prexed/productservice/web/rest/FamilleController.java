package bj.prexed.productservice.web.rest;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.mappers.FamilleMapper;
import bj.prexed.productservice.records.input.CategorieRequestDTO;
import bj.prexed.productservice.records.input.FamilleRequestDTO;
import bj.prexed.productservice.records.output.CategorieResponseDTO;
import bj.prexed.productservice.records.output.FamilleResponseDTO;
import bj.prexed.productservice.repositories.FamilleRepository;
import bj.prexed.productservice.services.FamilleService;
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
@RequestMapping("/api/v1/product/famille")
public class FamilleController {

    private final FamilleRepository repository;
    private final FamilleMapper mapper;
    private final FamilleService service;

    public FamilleController(FamilleRepository repository, FamilleMapper mapper, FamilleService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<FamilleResponseDTO> post(@RequestBody @Valid FamilleRequestDTO request) {
        try {
            FamilleResponseDTO marqueSave= service.add(request);
            return new ResponseEntity<>( marqueSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Famille>> getAll(@PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(service.all ("",pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/division")
    public ResponseEntity<Page<Famille>> getAllbyDivision(@RequestParam(required = false) String division, @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(service.selectionParDivison(division, pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Famille Details",  description = "Récupère les détails d’un service par id",
            security = @SecurityRequirement(name = "security_auth"))
    @ApiResponses({
            @ApiResponse(responseCode="200", description ="Success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{id:[\\d]+}")
    public  ResponseEntity<FamilleResponseDTO> getMarqueById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.one(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<FamilleResponseDTO> updateMarque(@PathVariable String id, @RequestBody @Valid Famille marque){
        try {
            return new ResponseEntity<>(service.set(id,marque),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
