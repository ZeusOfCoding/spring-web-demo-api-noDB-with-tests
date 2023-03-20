package com.pnb.demojpaapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Personne {
    private UUID id;
    private String nom;
    private String prenom;
    private Genre genre;
    private Calendar dob;
    private Calendar dateEnregistrement;
    private String login;
    private String password;
}
