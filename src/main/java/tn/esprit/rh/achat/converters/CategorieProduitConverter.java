package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

@Component
public class CategorieProduitConverter {
    public CategorieProduit dtoToEntity(CategorieProduitDTO dto){
        CategorieProduit categorieProduit=new CategorieProduit();
        categorieProduit.setIdCategorieProduit(dto.getId());
        categorieProduit.setCodeCategorie(dto.getCode());
        categorieProduit.setLibelleCategorie(dto.getLibelle());
        return categorieProduit;
    }
}
