package com.portfolio.tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Stock name is required")
    private String name;

    @NotBlank(message = "Ticker symbol is required")
    private String ticker;

    @Positive(message = "Quantity must be positive")
    private int quantity;

    @Positive(message = "Buy price must be positive")
    private double buyPrice;
}
