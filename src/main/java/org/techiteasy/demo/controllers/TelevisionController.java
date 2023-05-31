package org.techiteasy.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("/televisions")
    public ResponseEntity<Object> getAllTelevisions(){
        return ResponseEntity.ok("All televisions");
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable long id) {
        return ResponseEntity.ok("television: " + id);
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody String television) {
        return ResponseEntity.created(null).body("television");
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable long id, @RequestBody String television) {
        return ResponseEntity.noContent().build();
    }
}



