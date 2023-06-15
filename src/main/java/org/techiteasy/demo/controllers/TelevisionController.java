package org.techiteasy.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.techiteasy.demo.dtos.TelevisionDto;
import org.techiteasy.demo.dtos.TelevisionInputDto;
import org.techiteasy.demo.models.Television;
import org.techiteasy.demo.services.TelevisionService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/televisions")
@RestController
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;

    }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand){

        List<TelevisionDto> dtos;

        if (brand.isEmpty()) {
            dtos = service.getAllTelevisions();

        } else {
            dtos = service.getAllTelevisionsByBrand(brand.get());

        }

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable("id") Long id) {

        TelevisionDto television = service.getTelevisionById(id);

        return ResponseEntity.ok().body(television);
    }

    @PostMapping
    public ResponseEntity<TelevisionDto> addTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {

        TelevisionDto dto = service.addTelevision(televisionInputDto);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {

        service.deleteTelevision(id);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionInputDto newTelevision) {

        TelevisionDto dto = service.updateTelevision(id, newTelevision);

        return ResponseEntity.ok().body(dto);
    }

}



