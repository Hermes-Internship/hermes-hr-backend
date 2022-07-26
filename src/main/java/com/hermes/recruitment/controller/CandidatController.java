package com.hermes.recruitment.controller;

import com.hermes.recruitment.model.Candidat;
import com.hermes.recruitment.model.dto.CandidatDTO;
import com.hermes.recruitment.service.CandidatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidat")
@RequiredArgsConstructor
public class CandidatController {
    private final CandidatService service;

    @ApiOperation(
            value = "Get all candidats",
            response = List.class
    )
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "All good", response = List.class),
                    @ApiResponse(code = 204, message = "No candidat found", response = List.class)
            }
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Candidat>> getCandidat() {
        List<Candidat> candidati = service.getCandidati();
        if (candidati.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(candidati);
    }

    @ApiOperation(
            value = "Retrieve a candidat by surname",
            response = List.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Here you go", response = List.class),
            @ApiResponse(code = 404, message = "No candidati with that surname")
    })
    @GetMapping("/get/{surname}")
    public ResponseEntity<List<Candidat>> getCandidati(@PathVariable String surname) {
        List<Candidat> candidati = service.getCandidat(surname);
        if (candidati.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(candidati);
    }

    @ApiOperation(
            value = "Add a candidat to the database"
    )
    @ApiResponse(code = 200, message = "Candidat added successfully")
    @GetMapping("/save")
    public ResponseEntity<Void> save(CandidatDTO dto) {
        service.save(dto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "Delete a book from the database"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Deleted successfully"),
            @ApiResponse(code = 404, message = "No candidat with that ID")
    }
    )
    @GetMapping("/delete")
    @Transactional
    public ResponseEntity<Void> delete(CandidatDTO dto) {
        Optional<Candidat> candidati = service.findCandidat(dto.getId());
        if (candidati.isEmpty())
            return ResponseEntity.notFound().build();
        service.deleteCandidat(dto.getId());
        return ResponseEntity.ok().build();
    }
}
