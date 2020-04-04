package com.fdm0506.stockify.tradeservicev2.ports.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.Decimal128;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostTradeRequest {
    private String username;
    private String stockSymbol;
    private Decimal128 currentSharePrice;
    private LocalDateTime localDateTime;
    private int volume;
    private double total;
}
