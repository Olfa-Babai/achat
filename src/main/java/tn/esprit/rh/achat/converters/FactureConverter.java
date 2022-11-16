package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.FactureDTO;
import tn.esprit.rh.achat.entities.Facture;

@Component
public class FactureConverter {

    public Facture dtoToEntity(FactureDTO dto){
        Facture facture=new Facture();
        facture.setIdFacture(dto.getId());
        facture.setMontantRemise(dto.getMontantRemise());
        facture.setMontantFacture(dto.getMontantFacture());
        facture.setArchivee(dto.getArchivee());
        return facture;
    }
}
