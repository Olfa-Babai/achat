package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.FournisseurDTO;
import tn.esprit.rh.achat.entities.Fournisseur;

@Component
public class FournisseurConverter {
    public Fournisseur dtoToEntity(FournisseurDTO dto){
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setIdFournisseur(dto.getIdFournisseur());
        fournisseur.setCode(dto.getCode());
        fournisseur.setLibelle(dto.getLibelle());
        return fournisseur;
    }
}
