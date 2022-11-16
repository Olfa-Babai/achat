package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;

@Component
public class ProduitConverter {

    public Produit dtoToEntity(ProduitDTO dto){
        Produit p= new Produit();
        p.setIdProduit(dto.getId());
        p.setCodeProduit(dto.getCode());
        p.setLibelleProduit(dto.getLibelle());
        p.setPrix(dto.getPrix());
        return p;
    }
}