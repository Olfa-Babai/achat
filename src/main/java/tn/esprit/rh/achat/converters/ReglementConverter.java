package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.ReglementDTO;
import tn.esprit.rh.achat.entities.Reglement;

@Component
public class ReglementConverter {

    public Reglement dtoToEntity(ReglementDTO dto){
        Reglement reglement=new Reglement();
        reglement.setIdReglement(dto.getId());
        reglement.setMontantPaye(dto.getMontantPaye());
        reglement.setMontantRestant(dto.getMontantRestant());
        reglement.setPayee(reglement.getPayee());
        return  reglement;
    }
}
