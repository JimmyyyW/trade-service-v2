package com.fdm0506.stockify.tradeservicev2.ports.web;

import com.fdm0506.stockify.tradeservicev2.domain.Trade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserTradesResponse {
    Flux<Trade> trades;
}
