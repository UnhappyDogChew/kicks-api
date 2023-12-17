package com.kicks.api.repository.product;

import com.kicks.api.domain.product.ShoeFamily;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<ShoeFamily, Long> {
}
