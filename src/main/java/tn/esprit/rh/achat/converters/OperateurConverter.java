package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.OperateurDTO;
import tn.esprit.rh.achat.entities.Operateur;

import java.util.List;

@Component
public class OperateurConverter {

    public OperateurDTO entityToDTO(Operateur o){
        OperateurDTO dto=new OperateurDTO();
        dto.setId(o.getIdOperateur());
        dto.setNom(o.getNom());
        dto.setPrenom(o.getPrenom());
        dto.setPassword(o.getPassword());
        return dto;
    }
    public  Operateur dtoToEntity(OperateurDTO dto){
        Operateur o=new Operateur();
        o.setIdOperateur(dto.getId());
        o.setNom(dto.getNom());
        o.setPrenom(dto.getPrenom());
        o.setPassword(dto.getPassword());
        return o;
    }

}
