package com.kicks.api.repository.product;

import com.kicks.api.domain.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
