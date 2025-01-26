package com.portfolio.tracker.controller;

import com.portfolio.tracker.model.Stock;
import com.portfolio.tracker.service.StockService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")

public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
public ResponseEntity<Stock> addStock(@Valid @RequestBody Stock stock) {
    Stock savedStock = stockService.addStock(stock);
    return ResponseEntity.status(201).body(savedStock);
}

// @DeleteMapping
// public ResponseEntity<Void> deleteAllStocks() {
//     stockService.deleteAllStocks();
//     return ResponseEntity.noContent().build();
// }

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
    stockService.deleteStock(id);
    return ResponseEntity.noContent().build(); // Returns HTTP 204 (No Content)
}

@PutMapping("/{id}")
public ResponseEntity<Stock> updateStock(@PathVariable Long id, @Valid @RequestBody Stock stock) {
    Stock updatedStock = stockService.updateStock(id, stock);
    return ResponseEntity.ok(updatedStock);
}


    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }
}
