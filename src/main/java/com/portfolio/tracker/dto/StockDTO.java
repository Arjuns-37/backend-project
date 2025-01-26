package com.portfolio.tracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO {

    @NotBlank(message = "Stock name is required")
    private String stockName;

    @NotBlank(message = "Ticker is required")
    private String ticker;

    private int quantity;
    private double buyPrice;
}
