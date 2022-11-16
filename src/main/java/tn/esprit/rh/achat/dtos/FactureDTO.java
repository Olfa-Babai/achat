package tn.esprit.rh.achat.dtos;

import lombok.Data;

@Data
public class FactureDTO {
    private Long id;
    private float montantRemise;
    private float montantFacture;
    private Boolean archivee;
}
