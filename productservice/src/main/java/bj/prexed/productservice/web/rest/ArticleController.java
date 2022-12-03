package bj.prexed.productservice.web.rest;


import bj.prexed.productservice.entities.Article;
import bj.prexed.productservice.entities.Famille;
import bj.prexed.productservice.mappers.ArticleMapper;
import bj.prexed.productservice.records.input.ArticleRequestDTO;
import bj.prexed.productservice.records.input.FamilleRequestDTO;
import bj.prexed.productservice.records.output.ArticleResponseDTO;
import bj.prexed.productservice.records.output.FamilleResponseDTO;
import bj.prexed.productservice.repositories.ArticleRepository;
import bj.prexed.productservice.services.ProductService;
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
@RequestMapping("/api/v1/product")
public class ArticleController {

    private final ArticleRepository repository;
    private final ArticleMapper mapper;
    private final ProductService service;

    public ArticleController(ArticleRepository repository, ArticleMapper mapper, ProductService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<ArticleResponseDTO> post(@RequestBody @Valid ArticleRequestDTO request) {
        try {
            ArticleResponseDTO marqueSave= service.add(request);
            return new ResponseEntity<>( marqueSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Article>> getAll(@PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(service.all ("",pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/division")
    public ResponseEntity<Page<Article>> getAllbyDivision(@RequestParam(required = false) String division, @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(service.selectionParDivison(division, pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Article Details",  description = "Récupère les détails d’un service par id",
            security = @SecurityRequirement(name = "security_auth"))
    @ApiResponses({
            @ApiResponse(responseCode="200", description ="Success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{id:[\\d]+}")
    public  ResponseEntity<ArticleResponseDTO> getMarqueById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.one(id),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<ArticleResponseDTO> updateMarque(@PathVariable String id, @RequestBody @Valid Article marque){
        try {
            return new ResponseEntity<>(service.set(id,marque),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
