package com.kicks.api.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ShoeImageSet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private ShoeStock stock;

    private String main;

    @Column(name = "detail_1")
    private String detail1;

    @Column(name = "detail_2")
    private String detail2;

    @Column(name = "detail_3")
    private String detail3;

    @Column(name = "detail_4")
    private String detail4;

    public void setMainImage(String imageUrl) {
        this.main = imageUrl;
    }

    public void setDetailImage(int index, String imageUrl) {
        switch (index) {
            case 1: detail1 = imageUrl;
            case 2: detail2 = imageUrl;
            case 3: detail3 = imageUrl;
            case 4: detail4 = imageUrl;
            default: throw new IndexOutOfBoundsException("이미지 인덱스가 잘못되었습니다. (제한: 1 ~ 4, 입력: " + index + ")");
        }
    }
}
