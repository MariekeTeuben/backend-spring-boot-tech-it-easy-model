package org.techiteasy.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.techiteasy.demo.dtos.TelevisionDto;
import org.techiteasy.demo.services.TelevisionService;

import java.net.URI;

@RequestMapping("/teachers")
@RestController
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;

    }

//    @GetMapping("/televisions")
//    public ResponseEntity<Object> getAllTelevisions(){
//        return ResponseEntity.ok("All televisions");
//    }
//
//    @GetMapping("/televisions/{id}")
//    public ResponseEntity<Object> getTelevision(@PathVariable long id) {
//        return ResponseEntity.ok("television: " + id);
//    }

    @PostMapping
    public ResponseEntity<Long> addTelevision(@RequestBody TelevisionDto televisionDto) {
        Long newId = service.addTelevision(televisionDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + newId).toUriString());

        return ResponseEntity.created(uri).body(newId);
    }

//    @DeleteMapping("/televisions/{id}")
//    public ResponseEntity<Object> deleteTelevision(@PathVariable long id) {
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/televisions/{id}")
//    public ResponseEntity<Object> updateTelevision(@PathVariable long id, @RequestBody String television) {
//        return ResponseEntity.noContent().build();
//    }
}



