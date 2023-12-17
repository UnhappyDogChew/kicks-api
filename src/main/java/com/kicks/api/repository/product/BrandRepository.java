package com.kicks.api.repository.product;

import com.kicks.api.domain.product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
