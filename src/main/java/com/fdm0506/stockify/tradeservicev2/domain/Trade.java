package com.fdm0506.stockify.tradeservicev2.domain;

import lombok.*;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "trades")
public class Trade {
    @Id String _id;
    @NonNull LocalDateTime date;
    @NonNull String username;
    @NonNull String stockSymbol;
    @NonNull Decimal128 value;
    @NonNull int volume;
    @NonNull double total;
}
