package com.kicks.api.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoeProduct {

    @Id
    @Column(name = "product_id")
    private String productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id")
    private ShoeFamily family;

    @Column(name = "color_ko")
    private String colorKo;

    @Column(name = "color_en")
    private String colorEn;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "stock_list")
    private List<ShoeStock> stockList = new ArrayList<>();

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "image_list")
    private List<ProductImage> imageList = new ArrayList<>();

    public ShoeProduct(String productId, ShoeFamily family, String colorKo, String colorEn) {
        this.productId = productId;
        this.family = family;
        this.colorKo = colorKo;
        this.colorEn = colorEn;
    }

    public ShoeStock addNewStock(int size, int price, int quantity) {
        ShoeStock newStock = new ShoeStock(this, size, price, quantity);
        stockList.add(newStock);
        return newStock;
    }

    public ProductImage addNewImage(String url) {
        ProductImage newImage = new ProductImage(this, url);
        imageList.add(newImage);
        return newImage;
    }

    public List<ShoeStock> getStockList() {
        return Collections.unmodifiableList(stockList);
    }

    public List<ProductImage> getImageList() {
        return Collections.unmodifiableList(imageList);
    }
}
