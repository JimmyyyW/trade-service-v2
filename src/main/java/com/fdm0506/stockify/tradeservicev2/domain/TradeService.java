package com.fdm0506.stockify.tradeservicev2.domain;

import com.fdm0506.stockify.tradeservicev2.ports.repository.RxTradeRepository;
import com.fdm0506.stockify.tradeservicev2.ports.web.PostTradeRequest;
import com.fdm0506.stockify.tradeservicev2.ports.web.PostTradeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TradeService {

    private RxTradeRepository rxTradeRepository;

    public Mono<PostTradeResponse> createTrade(PostTradeRequest tradeRequest) {
        Trade trade = new Trade(
                tradeRequest.getLocalDateTime(),
                tradeRequest.getUsername(),
                tradeRequest.getStockSymbol(),
                tradeRequest.getCurrentSharePrice(),
                tradeRequest.getVolume(),
                tradeRequest.getVolume() * tradeRequest.getCurrentSharePrice().doubleValue());

        return rxTradeRepository.save(trade)
                .map(tradeResponse -> new PostTradeResponse("success"))
                .doOnError(failedTradeResponse -> new PostTradeResponse("failure"));
    }

    public Flux<Trade> getTradesForUser(String username) {
        return rxTradeRepository.findAllByUsername(username);
    }
}
