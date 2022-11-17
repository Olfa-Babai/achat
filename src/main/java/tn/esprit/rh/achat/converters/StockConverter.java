package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.StockDTO;
import tn.esprit.rh.achat.entities.Stock;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockConverter {

    public Stock dtoToEntity(StockDTO stockDTO){
        Stock stock=new Stock();
        stock.setIdStock(stockDTO.getId());
        stock.setLibelleStock(stockDTO.getLibelle());
        stock.setQte(stockDTO.getQte());
        stock.setQteMin(stockDTO.getQteMin());
        return stock;
    }

}
