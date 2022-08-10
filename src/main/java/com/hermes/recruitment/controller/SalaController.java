package com.hermes.recruitment.controller;

import com.hermes.recruitment.model.Sala;
import com.hermes.recruitment.service.SalaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
@RequiredArgsConstructor
public class SalaController {
    private final SalaService service;

    @ApiOperation(
            value = "Toate salile valabile",
            response = List.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = List.class),
            @ApiResponse(code = 204, message = "Nicio sala nu e valabila")}
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Sala>> getSali() {
        List<Sala> sali = service.getSali();
        if (sali.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sali);
    }

    @ApiOperation(
            value = "Sala cu id-ul {id}",
            response = Sala.class
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = Sala.class),
            @ApiResponse(code = 204, message = "Nu a fost gasita")}
    )

    @GetMapping("/get/{id}")
    public ResponseEntity<Sala> getSala(@PathVariable Long id) {
        Sala sala = service.getSalaId(id);
        if (sala == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sala);
    }

    @ApiOperation(
            value = "Adaugare sala"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok")}
    )

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody List<String> data, String numar) {
        service.save(data, numar);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "Stergere sala cu id-ul {id}"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "Nu a fost gasita")}
    )

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        if (service.deleteSala(id)) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    @ApiOperation(
            value = "Stergere ora {ora} din sala cu id-ul {id}"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "Nu a fost gasita")}
    )

    @DeleteMapping("/delete/ora/{id, ora}")
    public ResponseEntity<Void> deleteSalaOra(@RequestParam Long id, @RequestParam String ora) {
        Sala book = service.getSalaId(id);
        if (book != null)
        {
            service.deleteSalaOra(id, ora);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.noContent().build();
    }

    @ApiOperation(
            value = "Adaugare ora {ora} din sala cu id-ul {id}"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "Nu a fost gasita")}
    )

    @PostMapping("/saveora/{id, ora}")
    public ResponseEntity<Void> saveSalaOra(@RequestParam Long id, @RequestParam String ora)
    {
        Sala book = service.getSalaId(id);
        if (book != null)
        {
            service.saveSalaOra(id, ora);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.noContent().build();
    }

    @ApiOperation(
            value = "Updatare sala cu id-ul {id}"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "Nu a fost gasita")}
    )

    @PostMapping("/update/{id}")
    public ResponseEntity<Void> updateSala(@PathVariable Long id, @RequestBody List<String> data,  String numar)
    {
        Sala sala = service.getSalaId(id);
        if (sala != null)
        {
            service.updateSala(id, data, numar);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.noContent().build();
    }
}
