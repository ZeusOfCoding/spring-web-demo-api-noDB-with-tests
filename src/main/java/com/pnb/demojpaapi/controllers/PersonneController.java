package com.pnb.demojpaapi.controllers;

import com.pnb.demojpaapi.dto.PersonneDto;
import com.pnb.demojpaapi.model.Personne;
import com.pnb.demojpaapi.services.PersonneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public List<PersonneDto> getAllPersonnes() {
        return personneService.getAllPersonnes().stream()
                .map(PersonneDto::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonneDto> getPersonneById(@PathVariable UUID id) {
        PersonneDto personne = new PersonneDto(personneService.getPersonneById(id));
        return ResponseEntity.ok(personne);
    }

    @PostMapping
    public ResponseEntity<PersonneDto> createPersonne(@Valid @RequestBody PersonneDto personneDto) {
        PersonneDto createdPersonne = new PersonneDto(personneService.savePersonne(personneDto.toPersonne()));
        return ResponseEntity.created(URI.create("/personnes/" + createdPersonne.getId())).body(createdPersonne);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonneDto> updatePersonne(@PathVariable UUID id, @Valid @RequestBody PersonneDto personneDto) {
        PersonneDto updatedPersonne = new PersonneDto(personneService.updatePersonne(id, personneDto));
        return ResponseEntity.ok(updatedPersonne);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonne(@PathVariable UUID id) {
        personneService.deletePersonneById(id);
        return ResponseEntity.noContent().build();
    }
}
