package com.pnb.demojpaapi.dto;

import com.pnb.demojpaapi.model.Genre;
import com.pnb.demojpaapi.model.Personne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneDto {
    private UUID id;
    @NotNull
    @NotEmpty
    private String nom;
    private String prenom;
    @NotNull
    private Genre genre;
    @NotNull
    private Calendar dob;

    public PersonneDto(Personne personne) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.genre = personne.getGenre();
        this.dob = personne.getDob();
    }

    public Personne toPersonne() {
        return Personne.builder()
                .id(this.id)
                .nom(this.nom)
                .prenom(this.prenom)
                .genre(this.genre)
                .dob(this.dob)
                .dateEnregistrement(Calendar.getInstance())
                .build();
    }


}
