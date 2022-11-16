package tn.esprit.rh.achat.dtos;

import lombok.Data;

@Data
public class ProduitDTO {
    private Long id;
    private String code;
    private String libelle;
    private float prix;
}
