package bj.prexed.productservice.web.rest;

import bj.prexed.productservice.entities.Categorie;
import bj.prexed.productservice.entities.Marque;
import bj.prexed.productservice.mappers.CategorieMapper;
import bj.prexed.productservice.records.input.CategorieRequestDTO;
import bj.prexed.productservice.records.input.MarqueRequestDTO;
import bj.prexed.productservice.records.output.CategorieResponseDTO;
import bj.prexed.productservice.records.output.MarqueResponseDTO;
import bj.prexed.productservice.repositories.CategorieRepository;
import bj.prexed.productservice.services.CategorieService;
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
@RequestMapping("/api/v1/product/categorie")
public class CategorieController {

    private final CategorieRepository repository;
    private final CategorieMapper mapper;
    private final CategorieService service;

    public CategorieController(CategorieRepository repository, CategorieMapper mapper, CategorieService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<CategorieResponseDTO> post(@RequestBody @Valid CategorieRequestDTO request) {
        try {

            CategorieResponseDTO marqueSave= service.add(request);

            return new ResponseEntity<>( marqueSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Categorie>> getAll(@PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(service.all ("",pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/division")
    public ResponseEntity<Page<Categorie>> getAllbyDivision(@RequestParam(required = false) String division, @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(service.selectionParDivison(division, pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Categorie Details",  description = "Récupère les détails d’un service par id",
            security = @SecurityRequirement(name = "security_auth"))
    @ApiResponses({
            @ApiResponse(responseCode="200", description ="Success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{id:[\\d]+}")
    public  ResponseEntity<CategorieResponseDTO> getMarqueById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.one(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<CategorieResponseDTO> updateMarque(@PathVariable String id, @RequestBody @Valid Categorie marque){
        try {
            return new ResponseEntity<>(service.set(id,marque),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
