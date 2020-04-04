package com.fdm0506.stockify.tradeservicev2.ports.web;

import com.fdm0506.stockify.tradeservicev2.domain.Trade;
import com.fdm0506.stockify.tradeservicev2.domain.TradeService;
import org.bson.types.Decimal128;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@WebFluxTest
@Import(TradeController.class)
@ExtendWith(SpringExtension.class)
class TradeControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private TradeService service;

    @Test
    public void createNewTrade() {
        var value = Decimal128.parse("123");
        PostTradeRequest postTradeRequest = new PostTradeRequest(
                "JimmyyW",
                "HSBC",
                value,
                LocalDateTime.of(2020, 4, 1, 17, 22, 10),
                200,
                200 * value.doubleValue());

        Mono<PostTradeResponse> responseMono = Mono.just(new PostTradeResponse("success"));

        Mockito.when(this.service.createTrade(any()))
                .thenReturn(responseMono);

        this.webTestClient
                .post()
                .uri("/api/v2/trade/create")
                .body(BodyInserters.fromValue(postTradeRequest))
                .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.outcome").isEqualTo("success");
    }

    @Test
    public void getUsersTrades() {
        var trade1 = new Trade(
                LocalDateTime.of(2020, 4, 1, 17, 22, 10),
                "JimmyyW",
                "HSBC",
                Decimal128.parse("123"),
                200,
                200*Decimal128.parse("123").doubleValue()
        );

        var trade2 = new Trade(
                LocalDateTime.of(2020, 4, 1, 17, 22, 10),
                "JimmyyW2",
                "HSBC",
                Decimal128.parse("123"),
                200,
                200*Decimal128.parse("123").doubleValue()
        );

        Flux<Trade> tradeFlux = Flux.just(trade1, trade2);

        Mockito.when(this.service.getTradesForUser(any()))
                .thenReturn(tradeFlux);

        this.webTestClient
                .get()
                .uri("/api/v2/trades/JimmyyW")
                .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.[0].username").isEqualTo("JimmyyW")
                .jsonPath("$.[1].username").isEqualTo("JimmyyW2")
                .jsonPath("$.[0].total").isEqualTo(24600)
                .jsonPath("$.[1].total").isEqualTo(24600)
        ;

    }
}