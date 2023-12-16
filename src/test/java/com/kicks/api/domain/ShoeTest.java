package com.kicks.api.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;
class ShoeTest {
    @Test
    void newFamilyAndStock() {
        ShoeFamily family = new ShoeFamily(
                "ADIDAS 4DFWD X PARLEY RUNNING SHOES",
                Category.RUNNERS,
                "This product is excluded from all promotional discounts and offers.",
                LocalDateTime.now());
        ShoeStock stock = ShoeStock.newStock(family, ShoeColor.BLUE, ShoeSize.S38, 125.00f, 20);

        assertThat(family.getRepresentation()).isEqualTo(stock);
    }

}