package com.fdm0506.stockify.tradeservicev2.ports.repository;

import com.fdm0506.stockify.tradeservicev2.domain.Trade;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RxTradeRepository extends ReactiveMongoRepository<Trade, String> {
    Flux<Trade> findAllByUsername(String username);
}
