package com.fdm0506.stockify.tradeservicev2.domain;

import com.fdm0506.stockify.tradeservicev2.ports.repository.RxTradeRepository;
import com.fdm0506.stockify.tradeservicev2.ports.web.PostTradeRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TradeServiceTest {

    private RxTradeRepository rxTradeRepository = mock(RxTradeRepository.class);
    private final TradeService unit = new TradeService(rxTradeRepository);

    @Test
    public void things() {}

}