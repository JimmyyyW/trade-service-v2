package com.fdm0506.stockify.tradeservicev2.domain;

import org.bson.types.Decimal128;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TradeTest {

    @Test
    public void create() {
        Trade trade = new Trade();
        trade._id = "5ddce6bda9773473e4518d66";
        trade.date = LocalDateTime.of(2020, 4, 1, 17, 22, 10);
        trade.username = "JimmyyW";
        trade.stockSymbol = "HSBC";
        trade.value = Decimal128.parse("123");
        trade.volume = 200;
        trade.total = trade.value.doubleValue() * trade.volume;

        assertEquals("5ddce6bda9773473e4518d66", trade._id);
        assertEquals(2020, trade.date.getYear());
        assertEquals(17, trade.date.getHour());
        assertEquals("JimmyyW", trade.username);
        assertEquals(24600, trade.total);
    }
}