package bj.prexed.succursaleservice.web.rest;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.mappers.DivisionMapper;
import bj.prexed.succursaleservice.records.request.AgenceRequestDTO;
import bj.prexed.succursaleservice.records.request.DivisionRequestDTO;
import bj.prexed.succursaleservice.records.response.DivisionResponseDTO;
import bj.prexed.succursaleservice.records.response.DivisionResponseDTO;
import bj.prexed.succursaleservice.repositories.DivisionRepository;
import bj.prexed.succursaleservice.services.DivisionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/division")
public class DivisionController {
    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;
    private final DivisionService divisionService;

    public DivisionController(DivisionRepository divisionRepository, DivisionMapper divisionMapper, DivisionService divisionService) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
        this.divisionService = divisionService;
    }

    @PostMapping("/add")
    public ResponseEntity<DivisionResponseDTO> post( @RequestBody @Valid DivisionRequestDTO request) {
        try {
            DivisionResponseDTO agenceSave= divisionService.add(request);
            return new ResponseEntity<>( agenceSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Division>> getAll( @RequestParam(required = false) Succursale succursale, @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(divisionService.all ( succursale, pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<DivisionResponseDTO> getAgenceById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(divisionService.one ( id ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<DivisionResponseDTO> updateAgence(@PathVariable String id, @RequestBody @Valid Division division){
        try {
            return new ResponseEntity<>(divisionService.set ( id,division ),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
