package com.kicks.api.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"brand", "category", "productList"})
public class ShoeFamily {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    private Long id;

    @Column(name = "name_ko")
    private String nameKo;

    @Column(name = "name_en")
    private String nameEn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Lob
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "family", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final List<ShoeProduct> productList = new ArrayList<>();

    @Builder
    public ShoeFamily(String nameKo, String nameEn, Brand brand, String info, Category category, Gender gender) {
        this.nameKo = nameKo;
        this.nameEn = nameEn;
        this.brand = brand;
        this.info = info;
        this.category = category;
        this.gender = gender;
    }

    public ShoeProduct addNewProduct(String productId, String colorKo, String colorEn) {
        ShoeProduct newProduct = new ShoeProduct(productId, this, colorKo, colorEn);
        productList.add(newProduct);
        return newProduct;
    }

    public List<ShoeProduct> getProductList() {
        return Collections.unmodifiableList(productList);
    }
}
