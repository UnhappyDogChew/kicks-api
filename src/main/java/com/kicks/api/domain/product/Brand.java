package com.kicks.api.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    private String name;
    @Lob
    private String info;
    private String logoUrl;

    @Builder
    public Brand(String name, String info, String logoUrl) {
        this.name = name;
        this.info = info;
        this.logoUrl = logoUrl;
    }
}
