package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.SecteurActiviteDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;

@Component
public class SecteurActiviteConverter {
    public SecteurActiviteDTO entityToDTO(SecteurActivite secteurActivite){
        SecteurActiviteDTO dto=new SecteurActiviteDTO();
        dto.setId(secteurActivite.getIdSecteurActivite());
        dto.setCode(secteurActivite.getCodeSecteurActivite());
        dto.setLibelle(secteurActivite.getLibelleSecteurActivite());
        return dto;
    }
    public SecteurActivite dtoToEntity(SecteurActiviteDTO dto){
        SecteurActivite secteurActivite=new SecteurActivite();
        secteurActivite.setIdSecteurActivite(dto.getId());
        secteurActivite.setCodeSecteurActivite(dto.getCode());
        secteurActivite.setLibelleSecteurActivite(dto.getLibelle());
        return secteurActivite;
    }
}
