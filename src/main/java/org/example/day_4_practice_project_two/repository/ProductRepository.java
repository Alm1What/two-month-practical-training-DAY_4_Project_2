package org.example.day_4_practice_project_two.repository;

import org.example.day_4_practice_project_two.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
