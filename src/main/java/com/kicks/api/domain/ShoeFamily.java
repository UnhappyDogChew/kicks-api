package com.kicks.api.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"id", "category", "info", "releaseDate"})
public class ShoeFamily {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Lob
    private String info;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    @OneToOne
    @JoinColumn(name = "rep_stock_id")
    private ShoeStock representation;

    public ShoeFamily(String name, Category category, String info, LocalDateTime releaseDate) {
        this.name = name;
        this.category = category;
        this.info = info;
        this.releaseDate = releaseDate;
    }

    public void setRepresentation(ShoeStock representation) {
        this.representation = representation;
    }
}
