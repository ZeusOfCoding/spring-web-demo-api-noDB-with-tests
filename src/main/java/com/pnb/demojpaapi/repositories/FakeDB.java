package com.pnb.demojpaapi.repositories;

import com.pnb.demojpaapi.model.Genre;
import com.pnb.demojpaapi.model.Personne;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class FakeDB {

    private final List<Personne> DB = new ArrayList<>();

    public FakeDB(){
        load();
    }

    public Personne save(Personne p){
        if(p.getId() == null) {
            p.setId(UUID.randomUUID());
        }
        DB.add(p);
        return p;
    }

    public void deleteById(UUID id){
        DB.removeIf(p -> p.getId().equals(id));
    }

    public List<Personne> getAll(){
        return DB;
    }

    public Optional<Personne> getById(UUID id) {
        return DB.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Personne> getByGenre(Genre genre) {
        return DB.stream()
                .filter(p -> p.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public List<Personne> findAllByNom(String nom) {
        return DB.stream()
                .filter(p -> p.getNom().equalsIgnoreCase(nom))
                .collect(Collectors.toList());
    }

    public List<Personne> findAllByPrenom(String prenom) {
        return DB.stream()
                .filter(p -> p.getPrenom().equalsIgnoreCase(prenom))
                .collect(Collectors.toList());
    }

    public List<Personne> findAllByDob(Calendar dob) {
        return DB.stream()
                .filter(p -> p.getDob().equals(dob))
                .collect(Collectors.toList());
    }

    public List<Personne> findAllByLogin(String login) {
        return DB.stream()
                .filter(p -> p.getLogin().equalsIgnoreCase(login))
                .collect(Collectors.toList());
    }


    void load(){
        Personne p0 = Personne.builder()
                .nom("Dupont")
                .prenom("Jean")
                .genre(Genre.MASCULIN)
                .dob(Calendar.getInstance())
                .dateEnregistrement(Calendar.getInstance())
                .login("jean.dupont")
                .password("password")
                .build();

        Personne p00 = Personne.builder()
                .nom("Durand")
                .prenom("Marie")
                .genre(Genre.FEMININ)
                .dob(Calendar.getInstance())
                .dateEnregistrement(Calendar.getInstance())
                .login("marie.durand")
                .password("password")
                .build();
        // Création des personnes
        Personne p1 = Personne.builder()
                .nom("Dupont")
                .prenom("Jean")
                .genre(Genre.MASCULIN)
                .dob(Calendar.getInstance())
                .login("jdupont")
                .password("password123")
                .build();
        Personne p2 = Personne.builder()
                .nom("Durand")
                .prenom("Sophie")
                .genre(Genre.FEMININ)
                .dob(Calendar.getInstance())
                .login("sdurand")
                .password("password456")
                .build();
        Personne p3 = Personne.builder()
                .nom("Martin")
                .prenom("Luc")
                .genre(Genre.MASCULIN)
                .dob(Calendar.getInstance())
                .login("lmartin")
                .password("password789")
                .build();
        Personne p4 = Personne.builder()
                .nom("Leroy")
                .prenom("Marie")
                .genre(Genre.FEMININ)
                .dob(Calendar.getInstance())
                .login("mleroy")
                .password("password123")
                .build();
        Personne p5 = Personne.builder()
                .nom("Lambert")
                .prenom("Pierre")
                .genre(Genre.MASCULIN)
                .dob(Calendar.getInstance())
                .login("plambert")
                .password("password456")
                .build();

// Ajout des personnes dans la liste
        save(p0);
        save(p00);
        save(p1);
        save(p2);
        save(p3);
        save(p4);
        save(p5);

    }
}
