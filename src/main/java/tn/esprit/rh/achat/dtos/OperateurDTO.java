package tn.esprit.rh.achat.dtos;

import lombok.Data;

@Data
public class OperateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String password;
}
