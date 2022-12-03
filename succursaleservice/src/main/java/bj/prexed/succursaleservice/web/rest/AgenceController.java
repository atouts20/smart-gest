package bj.prexed.succursaleservice.web.rest;

import bj.prexed.succursaleservice.entities.Agence;
import bj.prexed.succursaleservice.entities.Division;
import bj.prexed.succursaleservice.mappers.AgenceMapper;
import bj.prexed.succursaleservice.records.request.AgenceRequestDTO;
import bj.prexed.succursaleservice.records.response.AgenceResponseDTO;
import bj.prexed.succursaleservice.repositories.AgenceRepository;
import bj.prexed.succursaleservice.services.AgenceService;
import lombok.NonNull;
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
@RequestMapping("/api/v1/agence")
public class AgenceController {
    private final AgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;
    private final AgenceService agenceService;

    public AgenceController(AgenceRepository agenceRepository, AgenceMapper agenceMapper, AgenceService agenceService) {
        this.agenceRepository = agenceRepository;
        this.agenceMapper = agenceMapper;
        this.agenceService = agenceService;
    }


    @PostMapping("/add")
    public ResponseEntity<AgenceResponseDTO> post(@RequestBody @Valid AgenceRequestDTO request) {
        try {
            AgenceResponseDTO agenceSave= agenceService.add(request);
            return new ResponseEntity<>( agenceSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Page<Agence>> getAll( @RequestParam(required = false) Division division, @PageableDefault Pageable pageable) {
        try {
            return new ResponseEntity<>(agenceService.all ( division, pageable),HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<AgenceResponseDTO> getAgenceById(@PathVariable String id) {
        try {

                return new ResponseEntity<>(agenceService.one ( id ),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AgenceResponseDTO> updateAgence(@PathVariable String id, @RequestBody @Valid Agence agence){
        try {
                return new ResponseEntity<>(agenceService.set ( id,agence ),HttpStatus.ACCEPTED);

        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
