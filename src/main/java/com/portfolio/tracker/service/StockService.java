package com.portfolio.tracker.service;

import com.portfolio.tracker.model.Stock;
import com.portfolio.tracker.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
    

    public Stock updateStock(Long id, Stock updatedStock) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
        stock.setName(updatedStock.getName());
        stock.setTicker(updatedStock.getTicker());
        stock.setQuantity(updatedStock.getQuantity());
        stock.setBuyPrice(updatedStock.getBuyPrice());
        return stockRepository.save(stock);
    }

    // public void deleteStock(Long id) {
    //     stockRepository.deleteById(id);
    // }
    // public void deleteAllStocks() {
    //     stockRepository.deleteAll();
    // }
}
