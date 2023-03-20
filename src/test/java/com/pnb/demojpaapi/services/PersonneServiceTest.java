package com.pnb.demojpaapi.services;

import com.pnb.demojpaapi.model.Genre;
import com.pnb.demojpaapi.model.Personne;
import com.pnb.demojpaapi.repositories.FakeDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class PersonneServiceTest {
    private PersonneService personneService;
    private FakeDB fakeDB;

    @BeforeEach
    public void setUp() {
        fakeDB = new FakeDB();
        personneService = new PersonneService(fakeDB);
    }

    @Test
    public void testGetAllPersonnes() {
        List<Personne> personnes = personneService.getAllPersonnes();
        Assertions.assertNotNull(personnes);
        Assertions.assertEquals(7, personnes.size());
    }

    @Test
    public void testGetPersonneById() {
        UUID id = fakeDB.getAll().get(3).getId();
        Personne personne = personneService.getPersonneById(id);
        Assertions.assertNotNull(personne);
        Assertions.assertEquals("Durand", personne.getNom());
        Assertions.assertEquals("Sophie", personne.getPrenom());
    }

    @Test
    public void testSavePersonne() {
        Personne personne = new Personne();
        personne.setId(UUID.randomUUID());
        personne.setNom("Jane");
        personne.setPrenom("Doe");
        personne.setGenre(Genre.FEMININ);
        personne.setDob(Calendar.getInstance());

        Personne savedPersonne = personneService.savePersonne(personne);
        Assertions.assertNotNull(savedPersonne);
        Assertions.assertEquals(personne.getNom(), savedPersonne.getNom());
        Assertions.assertEquals(personne.getPrenom(), savedPersonne.getPrenom());
    }

    @Test
    public void testDeletePersonneById() {
        UUID id = UUID.fromString("d7d63a63-4c7e-4b5e-8d9c-5f5c5e5d14c5");
        personneService.deletePersonneById(id);
        Assertions.assertNull(personneService.getPersonneById(id));
    }

    @Test
    public void testFindPersonnesByNom() {
        List<Personne> personnes = personneService.findPersonnesByNom("Doe");
        Assertions.assertNotNull(personnes);
        Assertions.assertEquals(0, personnes.size());
    }

    @Test
    public void testFindPersonnesByPrenom() {
        List<Personne> personnes = personneService.findPersonnesByPrenom("John");
        Assertions.assertNotNull(personnes);
        Assertions.assertEquals(0, personnes.size());
    }

    @Test
    public void testFindPersonnesByGenre() {
        List<Personne> personnes = personneService.findPersonnesByGenre(Genre.MASCULIN);
        Assertions.assertNotNull(personnes);
        Assertions.assertEquals(4, personnes.size());
    }
}
