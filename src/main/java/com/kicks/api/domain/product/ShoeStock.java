package com.kicks.api.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoeStock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ShoeProduct product;

    private int size;

    private int price;

    private int quantity;

    public ShoeStock(ShoeProduct product, int size, int price, int quantity) {
        this.product = product;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }
}
