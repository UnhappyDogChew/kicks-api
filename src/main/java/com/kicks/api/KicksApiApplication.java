package com.kicks.api;

import com.kicks.api.repository.product.BrandRepository;
import com.kicks.api.repository.product.CategoryRepository;
import com.kicks.api.repository.product.ShoeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KicksApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KicksApiApplication.class, args);
	}

	@Bean
	public InitData initData(ShoeRepository shoeRepository,
							 BrandRepository brandRepository,
							 CategoryRepository categoryRepository,
							 EntityManager em) {
		return new InitData(brandRepository, categoryRepository, shoeRepository, em);
	}


}
