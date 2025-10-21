package com.ms.keynoteservice.controller;

import com.ms.keynoteservice.dto.KeynoteDTO;
import com.ms.keynoteservice.service.KeynoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keynotes")
@RequiredArgsConstructor
public class KeynoteController {

    private final KeynoteService service;

    @GetMapping
    public ResponseEntity<List<KeynoteDTO>> getAll() {
        return ResponseEntity.ok(service.getAllKeynotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeynoteDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getKeynoteById(id));
    }

    @PostMapping
    public ResponseEntity<KeynoteDTO> create(@RequestBody KeynoteDTO dto) {
        KeynoteDTO created = service.createKeynote(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeynoteDTO> update(@PathVariable Long id, @RequestBody KeynoteDTO dto) {
        return ResponseEntity.ok(service.updateKeynote(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteKeynote(id);
        return ResponseEntity.noContent().build();
    }
}
