package com.pnb.demojpaapi.repositories;

import com.pnb.demojpaapi.model.Genre;
import com.pnb.demojpaapi.model.Personne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FakeDBTest {
    private FakeDB fakeDB;

    @BeforeEach
    void setUp() {
        fakeDB = new FakeDB();
    }

    @Test
    void save() {
        Personne p = Personne.builder()
                .nom("Doe")
                .prenom("John")
                .genre(Genre.MASCULIN)
                .dob(Calendar.getInstance())
                .login("jdoe")
                .password("password123")
                .build();
        fakeDB.save(p);
        Optional<Personne> result = fakeDB.getById(p.getId());
        assertTrue(result.isPresent());
        assertEquals(p, result.get());
    }

    @Test
    void deleteById() {
        UUID id = fakeDB.getAll().get(0).getId();
        fakeDB.deleteById(id);
        assertFalse(fakeDB.getById(id).isPresent());
    }

    @Test
    void getAll() {
        List<Personne> personnes = fakeDB.getAll();
        assertEquals(7, personnes.size());
    }

    @Test
    void getById() {
        UUID id = fakeDB.getAll().get(0).getId();
        Optional<Personne> result = fakeDB.getById(id);
        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

    @Test
    void getByGenre() {
        List<Personne> hommes = fakeDB.getByGenre(Genre.MASCULIN);
        assertEquals(4, hommes.size());

        List<Personne> femmes = fakeDB.getByGenre(Genre.FEMININ);
        assertEquals(3, femmes.size());
    }

    @Test
    void findAllByNom() {
        List<Personne> personnes = fakeDB.findAllByNom("Dupont");
        assertEquals(2, personnes.size());
    }

    @Test
    void findAllByPrenom() {
        List<Personne> personnes = fakeDB.findAllByPrenom("Marie");
        assertEquals(2, personnes.size());
    }

    @Test
    void findAllByDob() {
        Calendar dob = Calendar.getInstance();
        List<Personne> personnes = fakeDB.findAllByDob(dob);
        personnes.stream().forEach(p -> assertEquals(dob, p.getDob()));
    }

    @Test
    void findAllByLogin() {
        List<Personne> personnes = fakeDB.findAllByLogin("jdupont");
        assertEquals(1, personnes.size());
    }

}
