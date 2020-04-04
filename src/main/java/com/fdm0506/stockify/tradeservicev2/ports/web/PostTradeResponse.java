package com.fdm0506.stockify.tradeservicev2.ports.web;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class PostTradeResponse {
    private String outcome;
}
