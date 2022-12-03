package bj.prexed.succursaleservice.web.rest;


import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.mappers.EntiteMapper;
import bj.prexed.succursaleservice.records.request.EntiteRequestDTO;
import bj.prexed.succursaleservice.records.response.EntiteResponseDTO;
import bj.prexed.succursaleservice.repositories.EntiteRepository;
import bj.prexed.succursaleservice.services.EntiteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/entites")
public class EntiteController {

    private final EntiteRepository repository;
    private final EntiteMapper mapper;
    private final EntiteService entiteService;

    public EntiteController ( EntiteRepository repository , EntiteMapper mapper , EntiteService entiteService ) {
        this.repository = repository;
        this.mapper = mapper;
        this.entiteService = entiteService;
    }


    @PostMapping("/add")
    public ResponseEntity<EntiteResponseDTO> post( @RequestBody @Valid EntiteRequestDTO request) {
        try {
            EntiteResponseDTO agenceSave= entiteService.add(request);
            return new ResponseEntity<>( agenceSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Entite>> getAll( @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(entiteService.all ( pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id:[\\d]+}")
    public  ResponseEntity<EntiteResponseDTO> getAgenceById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(entiteService.one ( id ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id:[\\d]+}}")
    public ResponseEntity<EntiteResponseDTO> updateAgence(@PathVariable Long id, @RequestBody @Valid Entite entite){
        try {
            return new ResponseEntity<>(entiteService.set ( id,entite ),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
