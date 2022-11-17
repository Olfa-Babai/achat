package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.OperateurDTO;
import tn.esprit.rh.achat.entities.Operateur;


@Component
public class OperateurConverter {

    public  Operateur dtoToEntity(OperateurDTO dto){
        Operateur o=new Operateur();
        o.setIdOperateur(dto.getId());
        o.setNom(dto.getNom());
        o.setPrenom(dto.getPrenom());
        o.setPassword(dto.getPassword());
        return o;
    }

}
