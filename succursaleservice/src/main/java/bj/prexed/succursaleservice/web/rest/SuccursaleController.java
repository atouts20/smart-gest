package bj.prexed.succursaleservice.web.rest;

import bj.prexed.succursaleservice.entities.Entite;
import bj.prexed.succursaleservice.entities.Succursale;
import bj.prexed.succursaleservice.mappers.SuccursaleMapper;
import bj.prexed.succursaleservice.records.request.SuccursaleRequestDTO;
import bj.prexed.succursaleservice.records.response.SuccursaleResponseDTO;
import bj.prexed.succursaleservice.repositories.SuccursaleRepository;
import bj.prexed.succursaleservice.services.SuccursaleService;
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
@RequestMapping("/api/v1/succursale")
public class SuccursaleController {
    private  final SuccursaleMapper succursaleMapper;
    private final SuccursaleRepository succursaleRepository;
    private final SuccursaleService succursaleService;

    public SuccursaleController(SuccursaleMapper succursaleMapper, SuccursaleRepository succursaleRepository, SuccursaleService succursaleService) {
        this.succursaleMapper = succursaleMapper;
        this.succursaleRepository = succursaleRepository;
        this.succursaleService = succursaleService;
    }

    @PostMapping("/add")
    public ResponseEntity<SuccursaleResponseDTO> post( @RequestBody @Valid SuccursaleRequestDTO request) {
        try {
            System.out.println ("ok "+request.getIdEntite ());
            SuccursaleResponseDTO succursaleSave = succursaleService.add(request);
            return new ResponseEntity<>( succursaleSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Succursale>> getAll( @PathVariable Entite entite, @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(succursaleService.all ( entite, pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<SuccursaleResponseDTO> getSuccursaleById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(succursaleService.one ( id ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<SuccursaleResponseDTO> update(@PathVariable String id, @RequestBody @Valid Succursale succursale){
        try {
            return new ResponseEntity<>(succursaleService.set ( id,succursale ),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
