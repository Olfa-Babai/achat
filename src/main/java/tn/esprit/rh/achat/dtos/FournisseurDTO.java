package tn.esprit.rh.achat.dtos;

import lombok.Data;

@Data
public class FournisseurDTO {
    private Long idFournisseur;
    private String code;
    private String libelle;
}
