package com.fdm0506.stockify.tradeservicev2.ports.web;

import com.fdm0506.stockify.tradeservicev2.domain.Trade;
import com.fdm0506.stockify.tradeservicev2.domain.TradeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TradeController {

    private TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping(value = "/api/v2/trade/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PostTradeResponse> createTrade(@RequestBody PostTradeRequest postTradeRequest) {
        return tradeService.createTrade(postTradeRequest);
    }

    @GetMapping(value = "/api/v2/trades/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Trade> usersTrades(@PathVariable String username) {
        return tradeService.getTradesForUser(username);
    }
}
