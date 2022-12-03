package bj.prexed.succursaleservice.web.rest;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Entrepot;
import bj.prexed.succursaleservice.mappers.EntrepotMapper;
import bj.prexed.succursaleservice.records.request.EntrepotRequestDTO;
import bj.prexed.succursaleservice.records.response.EntrepotResponseDTO;
import bj.prexed.succursaleservice.repositories.EntrepotRepository;
import bj.prexed.succursaleservice.services.EntrepotService;
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
@RequestMapping("/api/v1/entrepot")
public class EntrepotController {
    private final EntrepotRepository entrepotRepository;
    private final EntrepotMapper entrepotMapper;
    private final EntrepotService entrepotService;

    public EntrepotController(EntrepotRepository entrepotRepository, EntrepotMapper entrepotMapper, EntrepotService entrepotService) {
        this.entrepotRepository = entrepotRepository;
        this.entrepotMapper = entrepotMapper;
        this.entrepotService = entrepotService;
    }

    @PostMapping("/add")
    public ResponseEntity<EntrepotResponseDTO> post( @RequestBody @Valid EntrepotRequestDTO request) {
        try {
            EntrepotResponseDTO agenceSave= entrepotService.add(request);
            return new ResponseEntity<>( agenceSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Entrepot>> getAll( @RequestParam(required = false) Agence agence, @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(entrepotService.all ( agence, pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<EntrepotResponseDTO> getEntrepotById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(entrepotService.one ( id ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<EntrepotResponseDTO> update(@PathVariable String id, @RequestBody @Valid Entrepot entrepot){
        try {
            return new ResponseEntity<>(entrepotService.set ( id,entrepot ),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
