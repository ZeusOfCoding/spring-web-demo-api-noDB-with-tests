package com.pnb.demojpaapi.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {
    @Test
    void testConstructeur() {
        // Créer une personne avec des valeurs prédéfinies
        UUID id = UUID.randomUUID();
        String nom = "Doe";
        String prenom = "John";
        Genre genre = Genre.MASCULIN;
        Calendar dob = Calendar.getInstance();
        dob.set(1980, Calendar.JANUARY, 1);
        Calendar dateEnregistrement = Calendar.getInstance();
        dateEnregistrement.set(2022, Calendar.MARCH, 19);
        String login = "johndoe";
        String password = "password";
        Personne personne = new Personne(id, nom, prenom, genre, dob, dateEnregistrement, login, password);

        // Vérifier que les champs ont été initialisés correctement
        assertEquals(id, personne.getId());
        assertEquals(nom, personne.getNom());
        assertEquals(prenom, personne.getPrenom());
        assertEquals(genre, personne.getGenre());
        assertEquals(dob, personne.getDob());
        assertEquals(dateEnregistrement, personne.getDateEnregistrement());
        assertEquals(login, personne.getLogin());
        assertEquals(password, personne.getPassword());
    }

}
