package com.kicks.api.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"id", "family", "color", "size", "price", "quantity"})
public class ShoeStock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private ShoeFamily family;

    @Enumerated(EnumType.STRING)
    private ShoeColor color;

    @Enumerated(EnumType.STRING)
    private ShoeSize size;

    private float price;

    private int quantity;

    private ShoeStock(ShoeFamily family, ShoeColor color, ShoeSize size, float price, int quantity) {
        this.family = family;
        this.color = color;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public int addStock(int quantity) {
        this.quantity += quantity;
        return this.quantity;
    }

    public float changePrice(float newPrice) {
        this.price = newPrice;
        return this.price;
    }

    public static ShoeStock newStock(ShoeFamily family, ShoeColor color, ShoeSize size, float price, int quantity) {
        ShoeStock stock = new ShoeStock(family, color, size, price, quantity);
        if (family.getRepresentation() == null) {
            family.setRepresentation(stock);
        }
        return stock;
    }
}
