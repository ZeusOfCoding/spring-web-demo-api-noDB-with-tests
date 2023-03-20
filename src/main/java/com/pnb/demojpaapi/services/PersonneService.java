package com.pnb.demojpaapi.services;
import com.pnb.demojpaapi.dto.PersonneDto;
import com.pnb.demojpaapi.model.Genre;
import com.pnb.demojpaapi.model.Personne;
import com.pnb.demojpaapi.repositories.FakeDB;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PersonneService {
    private FakeDB fakeDB;

    public PersonneService(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    public List<Personne> getAllPersonnes() {
        return fakeDB.getAll();
    }

    public Personne getPersonneById(UUID id) {
        return fakeDB.getAll().stream().filter(personne -> personne.getId().equals(id)).findFirst().orElse(null);
    }

    public Personne savePersonne(Personne personne) {
        return fakeDB.save(personne);
    }

    public void deletePersonneById(UUID id) {
        fakeDB.deleteById(id);
    }

    public List<Personne> findPersonnesByNom(String nom) {
        return fakeDB.getAll().stream().filter(personne -> personne.getNom().equals(nom)).toList();
    }

    public List<Personne> findPersonnesByPrenom(String prenom) {
        return fakeDB.getAll().stream().filter(personne -> personne.getPrenom().equals(prenom)).toList();
    }

    public List<Personne> findPersonnesByGenre(Genre genre) {
        return fakeDB.getAll().stream().filter(personne -> personne.getGenre().equals(genre)).toList();
    }

    public Personne updatePersonne(UUID id, PersonneDto personneDto) {
        Personne personneToUpdate = fakeDB.getAll().stream().filter(personne -> personne.getId().equals(id)).findFirst().orElse(null);
        if (personneToUpdate != null) {
            personneToUpdate.setNom(personneDto.getNom());
            personneToUpdate.setPrenom(personneDto.getPrenom());
            personneToUpdate.setGenre(personneDto.getGenre());
            personneToUpdate.setDob(personneDto.getDob());
            return fakeDB.save(personneToUpdate);
        }
        return null;
    }

    public List<Personne> findPersonnesByAge(int age) {
        // Calculer la date de naissance pour une personne d'âge "age" (en années)
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -age);
        Date dob = cal.getTime();

        return fakeDB.getAll().stream().filter(personne -> personne.getDob().before(dob)).toList();
    }
}
