package com.kicks.api.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ShoeProduct product;
    private String url;

    public ProductImage(ShoeProduct product, String url) {
        this.product = product;
        this.url = url;
    }
}
