package tn.esprit.rh.achat.converters;

import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.dtos.StockDTO;
import tn.esprit.rh.achat.entities.Stock;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockConverter {
    public StockDTO entityToDTO(Stock stock){
        StockDTO dto=new StockDTO();
        dto.setId(stock.getIdStock());
        dto.setLibelle(stock.getLibelleStock());
        dto.setQte(stock.getQte());
        dto.setQteMin(stock.getQteMin());
        return dto;
    }

    public List<StockDTO> entityToDTO(List<Stock> stocks){
        return stocks.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    public Stock dtoToEntity(StockDTO stockDTO){
        Stock stock=new Stock();
        stock.setIdStock(stockDTO.getId());
        stock.setLibelleStock(stockDTO.getLibelle());
        stock.setQte(stockDTO.getQte());
        stock.setQteMin(stockDTO.getQteMin());
        return stock;
    }

    public List<Stock> dtoToEntity(List<StockDTO> stockDTOs){
        return stockDTOs.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
