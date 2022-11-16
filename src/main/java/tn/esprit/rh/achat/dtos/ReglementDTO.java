package tn.esprit.rh.achat.dtos;

import lombok.Data;

@Data
public class ReglementDTO {
    private Long id;
    private float montantPaye;
    private float montantRestant;
    private Boolean payee;
}
