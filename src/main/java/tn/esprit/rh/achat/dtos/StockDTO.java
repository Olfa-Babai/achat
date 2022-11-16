package tn.esprit.rh.achat.dtos;

import lombok.*;

@Data
public class StockDTO {
    private Long id;
    private String libelle;
    private Integer qte;
    private Integer qteMin;
}
